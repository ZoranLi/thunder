package com.aplayer.hardwareencode;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.opengl.GLES20;
import android.view.Surface;
import com.aplayer.aplayerandroid.GPUImageFilter;
import com.aplayer.aplayerandroid.InputSurface;
import com.aplayer.aplayerandroid.Log;
import com.aplayer.aplayerandroid.SurfaceRenderer;
import com.aplayer.hardwareencode.VideoEncoder.COLOR_FORMAT;
import com.aplayer.hardwareencode.VideoEncoder.ENCODE_FORMAT;
import com.xunlei.common.accelerator.utils.ErrorCodeUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class VideoEncoderSurfaceInput extends VideoEncoder {
    private static final String ERROR_TAGE;
    private static final String TAG = "APlayerAndroid";
    private long mCnt = 0;
    private Surface mEncoderInputSurface = null;
    private GPUImageFilter mFilter = null;
    private InputSurface mRenderInputSurface = null;
    private SurfaceRenderer mSurfaceRenderer = null;
    private FloatBuffer mTextureCoordinateBuf;
    private FloatBuffer mVertexBuf;

    public boolean feedRawData(byte[] bArr, long j, long j2) {
        return true;
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("Aplayer_ERROR");
        stringBuilder.append(VideoEncoderSurfaceInput.class.getSimpleName());
        ERROR_TAGE = stringBuilder.toString();
    }

    public VideoEncoderSurfaceInput(HardwareEncoder hardwareEncoder, ENCODE_FORMAT encode_format, int i, int i2, double d, int i3, int i4) {
        super(hardwareEncoder, encode_format, COLOR_FORMAT.COLOR_FormatSurface, i, i2, d, i3, i4);
    }

    public void run() {
        while (this.mRunning) {
            this.mHardwareEncoder.putEncoderData(this, fetchEncodeData());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean init() {
        boolean init = super.init();
        if (init) {
            return init;
        }
        if (1280 >= this.mWidth) {
            if (ErrorCodeUtils.XLA_ALREADY_SPEEDUP_IN_ANOTHER_NETWORK >= this.mHeight) {
                String str = ERROR_TAGE;
                StringBuilder stringBuilder = new StringBuilder("mediaCodec.configure() failed!  width = ");
                stringBuilder.append(this.mWidth);
                stringBuilder.append("height = ");
                stringBuilder.append(this.mHeight);
                Log.e(str, stringBuilder.toString());
                return init;
            }
        }
        return sacllSizeRetryInit(1280, ErrorCodeUtils.XLA_ALREADY_SPEEDUP_IN_ANOTHER_NETWORK);
    }

    private boolean sacllSizeRetryInit(int i, int i2) {
        float f = (((float) this.mWidth) * 1.0f) / ((float) this.mHeight);
        float f2 = (float) i2;
        float f3 = (((float) i) * 1.0f) / f2;
        if (this.mWidth <= i) {
            if (this.mHeight <= i2) {
                return false;
            }
        }
        if (f > f3) {
            this.mWidth = i;
            this.mHeight = (int) (f2 / f);
        } else {
            this.mHeight = i2;
            this.mWidth = (int) (f2 * f);
        }
        this.mWidth = (this.mWidth / 16) * 16;
        this.mHeight = (this.mHeight / 2) * 2;
        return super.init();
    }

    @SuppressLint({"NewApi"})
    protected void beforeMediaCodecStart(MediaCodec mediaCodec) {
        if (mediaCodec == null) {
            Log.e(TAG, "Please make sure, init() function is called successed!");
            return;
        }
        synchronized (this) {
            this.mEncoderInputSurface = mediaCodec.createInputSurface();
        }
    }

    public boolean renderTexture(int i, long j) {
        if (this.mRenderInputSurface == null && this.mEncoderInputSurface != null) {
            this.mRenderInputSurface = new InputSurface(this.mEncoderInputSurface);
        }
        if (this.mRenderInputSurface != null) {
            this.mRenderInputSurface.makeCurrent();
            if (this.mFilter == null) {
                this.mFilter = new GPUImageFilter(this.mRenderInputSurface);
                this.mFilter.init();
            }
            GLES20.glViewport(0, 0, this.mWidth, this.mHeight);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
            GLES20.glEnable(2929);
            GLES20.glClear(16640);
            if (this.mVertexBuf == null || this.mTextureCoordinateBuf == null) {
                CreateFlatModel();
            }
            j *= 1000000;
            this.mRenderInputSurface.setPresentationTime(j);
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder("setPresentationTime presentationTime = ");
            stringBuilder.append(j);
            Log.i(str, stringBuilder.toString());
            this.mFilter.draw(i, this.mVertexBuf, this.mTextureCoordinateBuf);
            this.mRenderInputSurface.swapBuffers();
            GLES20.glFlush();
        }
        return true;
    }

    public void release() {
        Log.i(TAG, "VideoEncoderSurfaceInput release");
        super.release();
        if (this.mSurfaceRenderer != null) {
            this.mSurfaceRenderer.release();
            this.mSurfaceRenderer = null;
        }
        if (this.mEncoderInputSurface != null) {
            this.mEncoderInputSurface.release();
            this.mEncoderInputSurface = null;
        }
    }

    private void CreateFlatModel() {
        float[] fArr = new float[]{1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f};
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(72);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.mVertexBuf = allocateDirect.asFloatBuffer();
        this.mVertexBuf.put(fArr);
        this.mVertexBuf.position(0);
        fArr = new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(48);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.mTextureCoordinateBuf = allocateDirect2.asFloatBuffer();
        this.mTextureCoordinateBuf.put(fArr);
        this.mTextureCoordinateBuf.position(0);
    }
}
