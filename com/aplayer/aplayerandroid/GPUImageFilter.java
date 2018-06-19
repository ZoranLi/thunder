package com.aplayer.aplayerandroid;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GPUImageFilter implements OnFrameAvailableListener {
    public static final String NO_FILTER_FRAGMENT_SHADER = "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}";
    public static final String NO_FILTER_FRAGMENT_SHADER2 = "varying highp vec2 textureCoordinate;                                              \nuniform sampler2D inputImageTexture1;                                              \nuniform sampler2D inputImageTexture2;                                              \nvoid main()                                                                        \n{                                                                                  \n     gl_FragColor = texture2D(inputImageTexture1, textureCoordinate)*0.5;          \n     gl_FragColor+= texture2D(inputImageTexture2, textureCoordinate)*0.5;          \n}";
    public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;                                                               \nattribute vec4 inputTextureCoordinate;                                                 \nvarying vec2 textureCoordinate;                                                        \n \nvoid main()                                                                            \n{                                                                                      \n    gl_Position = position;                                                            \n    textureCoordinate = inputTextureCoordinate.xy;                                     \n}";
    private String TAG;
    private String mFragmentShader;
    private boolean mFrameAvailable;
    private Object mFrameSyncObject;
    protected int mGLAttribPosition;
    protected int mGLAttribTextureCoordinate;
    protected int mGLProgId;
    protected int mGLUniformTexture;
    protected int mGLUniformTexture1;
    protected int mGLUniformTexture2;
    private InputSurface mInputSurface;
    private boolean mIsInitialized;
    protected int mOutputHeight;
    protected int mOutputWidth;
    private final LinkedList<Runnable> mRunOnDraw;
    private SurfaceTexture mSurfaceTexture;
    private int mSysRenderTexture;
    protected int mTextureTarget;
    private String mVertexShader;

    public void onDestroy() {
    }

    protected void onDrawArraysPre() {
    }

    public void onInitialized() {
    }

    public GPUImageFilter(InputSurface inputSurface) {
        this(inputSurface, NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
    }

    public GPUImageFilter(InputSurface inputSurface, String str, String str2) {
        this.TAG = GPUImageFilter.class.getSimpleName();
        this.mSysRenderTexture = -1;
        this.mFrameSyncObject = new Object();
        this.mFrameAvailable = true;
        this.mRunOnDraw = new LinkedList();
        this.mInputSurface = inputSurface;
        this.mVertexShader = str;
        this.mFragmentShader = str2;
    }

    public final void init() {
        OpenGlUtils.checkGlError("init start");
        onInitTextureExt(false);
        onInit();
        onInitialized();
        OpenGlUtils.checkGlError("init end");
    }

    public final void initExt() {
        OpenGlUtils.checkGlError("initExt start");
        onInitTextureExt(true);
        onInit();
        onInitialized();
        OpenGlUtils.checkGlError("initExt end");
    }

    private void onInitTextureExt(boolean z) {
        this.mTextureTarget = 3553;
        if (z) {
            this.mTextureTarget = 36197;
            StringBuilder stringBuilder = new StringBuilder("#extension GL_OES_EGL_image_external : require\n");
            stringBuilder.append(this.mFragmentShader.replace("uniform sampler2D inputImageTexture;", "uniform samplerExternalOES inputImageTexture;"));
            this.mFragmentShader = stringBuilder.toString();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, iArr[0]);
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            GLES20.glTexParameterf(36197, 10240, 9729.0f);
            GLES20.glTexParameteri(36197, 10242, 33071);
            GLES20.glTexParameteri(36197, 10243, 33071);
            this.mSysRenderTexture = iArr[0];
        }
    }

    public void onInit() {
        this.mGLProgId = OpenGlUtils.loadProgram(this.mVertexShader, this.mFragmentShader);
        this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mGLProgId, "position");
        this.mGLUniformTexture = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture");
        this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
        this.mIsInitialized = true;
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.i(this.TAG, "lzmlsf new frame available");
        synchronized (this.mFrameSyncObject) {
            this.mFrameAvailable = true;
        }
    }

    public SurfaceTexture GetSurfaceTexture() {
        if (this.mSurfaceTexture == null) {
            Log.e(this.TAG, "GetSurface enter");
            while (this.mSysRenderTexture == -1) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.mSurfaceTexture = new SurfaceTexture(this.mSysRenderTexture);
            this.mSurfaceTexture.setOnFrameAvailableListener(this);
        }
        return this.mSurfaceTexture;
    }

    public final void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mGLProgId);
        onDestroy();
    }

    public void onOutputSizeChanged(int i, int i2) {
        this.mOutputWidth = i;
        this.mOutputHeight = i2;
    }

    public void draw(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (this.mSysRenderTexture != -1) {
            if (this.mFrameAvailable) {
                this.mSurfaceTexture.updateTexImage();
            }
            draw(this.mSysRenderTexture, floatBuffer, floatBuffer2);
        }
    }

    public void draw(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.mGLProgId);
        runPendingOnDrawTasks();
        if (this.mIsInitialized) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribPosition, 3, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.mTextureTarget, i);
                GLES20.glUniform1i(this.mGLUniformTexture, 0);
            }
            onDrawArraysPre();
            GLES20.glDrawArrays(5, 0, 6);
            GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
            GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
            GLES20.glBindTexture(this.mTextureTarget, 0);
        }
    }

    public void draw(int i, int i2, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.mGLProgId);
        runPendingOnDrawTasks();
        if (this.mIsInitialized) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribPosition, 3, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.mTextureTarget, i);
                GLES20.glUniform1i(this.mGLUniformTexture1, 0);
            }
            if (i2 != -1) {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(this.mTextureTarget, i2);
                GLES20.glUniform1i(this.mGLUniformTexture2, 1);
            }
            onDrawArraysPre();
            GLES20.glDrawArrays(5, 0, 6);
            GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
            GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
            GLES20.glBindTexture(this.mTextureTarget, 0);
        }
    }

    protected void runPendingOnDrawTasks() {
        while (!this.mRunOnDraw.isEmpty()) {
            try {
                ((Runnable) this.mRunOnDraw.removeFirst()).run();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public boolean isInitialized() {
        return this.mIsInitialized;
    }

    public int getOutputWidth() {
        return this.mOutputWidth;
    }

    public int getOutputHeight() {
        return this.mOutputHeight;
    }

    public int getProgram() {
        return this.mGLProgId;
    }

    public int getAttribPosition() {
        return this.mGLAttribPosition;
    }

    public int getAttribTextureCoordinate() {
        return this.mGLAttribTextureCoordinate;
    }

    public int getUniformTexture() {
        return this.mGLUniformTexture;
    }

    protected void setInteger(final int i, final int i2) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform1i(i, i2);
            }
        });
    }

    protected void setFloat(final int i, final float f) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform1f(i, f);
            }
        });
    }

    protected void setFloatVec2(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatVec3(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatVec4(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setFloatArray(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform1fv(i, fArr.length, FloatBuffer.wrap(fArr));
            }
        });
    }

    protected void setPoint(final int i, final PointF pointF) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniform2fv(i, 1, new float[]{pointF.x, pointF.y}, 0);
            }
        });
    }

    protected void setUniformMatrix3f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniformMatrix3fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected void setUniformMatrix4f(final int i, final float[] fArr) {
        runOnDraw(new Runnable() {
            public void run() {
                GLES20.glUniformMatrix4fv(i, 1, false, fArr, 0);
            }
        });
    }

    protected void runOnDraw(Runnable runnable) {
        synchronized (this.mRunOnDraw) {
            this.mRunOnDraw.addLast(runnable);
        }
    }

    public static String loadShader(String str, Context context) {
        try {
            str = context.getAssets().open(str);
            context = convertStreamToString(str);
            str.close();
            return context;
        } catch (String str2) {
            str2.printStackTrace();
            return "";
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        inputStream = new Scanner(inputStream).useDelimiter("\\A");
        return inputStream.hasNext() ? inputStream.next() : "";
    }
}
