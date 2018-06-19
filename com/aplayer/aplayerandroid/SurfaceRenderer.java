package com.aplayer.aplayerandroid;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.sina.weibo.sdk.constant.WBConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SurfaceRenderer extends Thread implements Callback {
    private static final String TAG = "APlayerSurfaceRenderer";
    private final int VERTEX_NUM = 6;
    private volatile boolean isRunning = true;
    private APlayerAndroid mAPlayerAndroid;
    private int mDisplayHeight = 1280;
    private Surface mDisplaySurface;
    private FloatBuffer mDisplayTextureCoordinate;
    private int mDisplayWidth = WBConstants.SDK_NEW_PAY_VERSION;
    private GPUImageExtFilter mExtFilter;
    private volatile boolean mFetchScreenshoting = false;
    private GPUImageFilter mFilter;
    private int[] mFrameBuffer = null;
    private int mFrameBufferHeight = WBConstants.SDK_NEW_PAY_VERSION;
    private int[] mFrameBufferTexture = null;
    private FloatBuffer mFrameBufferTextureCoordinate;
    private int mFrameBufferWidth = WBConstants.SDK_NEW_PAY_VERSION;
    private InputSurface mInputSurface = null;
    private boolean mIsFrameBufferDrawn = false;
    private AtomicBoolean mIsReleased = new AtomicBoolean(false);
    private Object mLock = new Object();
    private volatile boolean mReCreateFlatModel = false;
    private Bitmap mScreenshotBitmap;
    private final Lock mScreenshotLock = new ReentrantLock();
    private Condition mScreenshotNotComplete = this.mScreenshotLock.newCondition();
    private volatile boolean mSurfaceChanged = false;
    private TextureArea mTextureArea = null;
    private FloatBuffer mVertexBuf;
    private int mVideoHeight = 1280;
    private int mVideoWidth = WBConstants.SDK_NEW_PAY_VERSION;

    public static class TextureArea {
        public float mTextureHeight = 0.0f;
        public float mTextureWidth = 0.0f;
        public float m_crop_bottom = 0.0f;
        public float m_crop_left = 0.0f;
        public float m_crop_right = 0.0f;
        public float m_crop_top = 0.0f;
    }

    class ViewPort {
        public int height = 0;
        public int left = 0;
        public int top = 0;
        public int width = 0;

        ViewPort() {
        }
    }

    private void onSurfaceChanged() {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SurfaceRenderer(com.aplayer.aplayerandroid.APlayerAndroid r5, android.view.Surface r6, int r7, int r8, int r9, int r10) {
        /*
        r4 = this;
        r4.<init>();
        r0 = 6;
        r4.VERTEX_NUM = r0;
        r0 = 0;
        r4.mFrameBuffer = r0;
        r4.mFrameBufferTexture = r0;
        r4.mInputSurface = r0;
        r4.mTextureArea = r0;
        r0 = 1;
        r4.isRunning = r0;
        r0 = 0;
        r4.mSurfaceChanged = r0;
        r4.mReCreateFlatModel = r0;
        r4.mFetchScreenshoting = r0;
        r4.mIsFrameBufferDrawn = r0;
        r1 = new java.util.concurrent.atomic.AtomicBoolean;
        r1.<init>(r0);
        r4.mIsReleased = r1;
        r1 = 1920; // 0x780 float:2.69E-42 double:9.486E-321;
        r4.mDisplayWidth = r1;
        r2 = 1280; // 0x500 float:1.794E-42 double:6.324E-321;
        r4.mDisplayHeight = r2;
        r4.mVideoWidth = r1;
        r4.mVideoHeight = r2;
        r4.mFrameBufferWidth = r1;
        r4.mFrameBufferHeight = r1;
        r1 = new java.lang.Object;
        r1.<init>();
        r4.mLock = r1;
        r1 = new java.util.concurrent.locks.ReentrantLock;
        r1.<init>();
        r4.mScreenshotLock = r1;
        r1 = r4.mScreenshotLock;
        r1 = r1.newCondition();
        r4.mScreenshotNotComplete = r1;
        r1 = "APlayerSurfaceRenderer";
        r2 = new java.lang.StringBuilder;
        r3 = "SurfaceRenderer w:";
        r2.<init>(r3);
        r2.append(r7);
        r3 = " h:";
        r2.append(r3);
        r2.append(r8);
        r3 = " videoWidth = ";
        r2.append(r3);
        r2.append(r9);
        r3 = " videoHeight = ";
        r2.append(r3);
        r2.append(r10);
        r2 = r2.toString();
        com.aplayer.aplayerandroid.Log.i(r1, r2);
        r4.mDisplayWidth = r7;
        r4.mDisplayHeight = r8;
        r4.mVideoWidth = r9;
        r4.mVideoHeight = r10;
        r4.mAPlayerAndroid = r5;
        r5 = r4.mAPlayerAndroid;
        r7 = new com.aplayer.aplayerandroid.SurfaceRenderer$1;
        r7.<init>();
        r5.setOnSurfaceChangeListener(r7);
        r4.mDisplaySurface = r6;
        r5 = 72;
        r5 = java.nio.ByteBuffer.allocateDirect(r5);
        r6 = java.nio.ByteOrder.nativeOrder();
        r5 = r5.order(r6);
        r5 = r5.asFloatBuffer();
        r6 = 18;
        r6 = new float[r6];
        r6 = {1065353216, -1082130432, 0, 1065353216, 1065353216, 0, -1082130432, 1065353216, 0, -1082130432, 1065353216, 0, -1082130432, -1082130432, 0, 1065353216, -1082130432, 0};
        r5 = r5.put(r6);
        r4.mVertexBuf = r5;
        r5 = r4.mVertexBuf;
        r5.position(r0);
        r5 = 48;
        r5 = java.nio.ByteBuffer.allocateDirect(r5);
        r6 = java.nio.ByteOrder.nativeOrder();
        r5 = r5.order(r6);
        r5 = r5.asFloatBuffer();
        r6 = 12;
        r6 = new float[r6];
        r6 = {1065353216, 0, 1065353216, 1065353216, 0, 1065353216, 0, 1065353216, 0, 0, 1065353216, 0};
        r5 = r5.put(r6);
        r4.mDisplayTextureCoordinate = r5;
        r5 = r4.mDisplayTextureCoordinate;
        r5.position(r0);
        r5 = r4.mIsReleased;
        r5.set(r0);
        r4.start();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.SurfaceRenderer.<init>(com.aplayer.aplayerandroid.APlayerAndroid, android.view.Surface, int, int, int, int):void");
    }

    public void run() {
        if (this.mDisplaySurface != null) {
            try {
                this.mInputSurface = new InputSurface(this.mDisplaySurface);
            } catch (Exception e) {
                e.printStackTrace();
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder("create EGL failed:");
                stringBuilder.append(e);
                Log.e(str, stringBuilder.toString());
                this.mIsReleased.set(true);
                return;
            }
        }
        try {
            this.mInputSurface.makeCurrent();
        } catch (Exception e2) {
            e2.printStackTrace();
            str = TAG;
            stringBuilder = new StringBuilder("makeCurrent failed:");
            stringBuilder.append(e2);
            Log.e(str, stringBuilder.toString());
        }
        if (this.mFrameBuffer == null && this.mFrameBufferTexture == null) {
            this.mFrameBuffer = new int[1];
            this.mFrameBufferTexture = new int[1];
            if (this.mVideoWidth <= 0 || this.mVideoHeight <= 0) {
                Log.v(TAG, "use default wh for fb");
                this.mFrameBufferWidth = WBConstants.SDK_NEW_PAY_VERSION;
                this.mFrameBufferHeight = 1280;
            } else {
                this.mFrameBufferWidth = this.mVideoWidth;
                this.mFrameBufferHeight = this.mVideoHeight;
            }
            createFrameBuffer(this.mFrameBufferWidth, this.mFrameBufferHeight, this.mFrameBuffer, this.mFrameBufferTexture, 1);
            this.mIsFrameBufferDrawn = false;
        }
        createFlatModel();
        this.mExtFilter = new GPUImageExtFilter(this.mInputSurface);
        this.mExtFilter.Init();
        this.mFilter = new GPUImageFilter(this.mInputSurface);
        this.mFilter.init();
        synchronized (this.mLock) {
            this.mLock.notifyAll();
        }
        this.mIsReleased.set(false);
        GLES20.glViewport(0, 0, this.mDisplayWidth, this.mDisplayHeight);
        boolean z = false;
        while (this.mAPlayerAndroid.getState() != 0 && this.isRunning) {
            synchronized (this.mLock) {
                if (this.mReCreateFlatModel) {
                    this.mReCreateFlatModel = false;
                    createFlatModel();
                }
            }
            SystemClock.sleep(5);
            if (this.mAPlayerAndroid.getState() == 3) {
                SystemClock.sleep(50);
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            if (this.mInputSurface != null) {
                synchronized (this.mLock) {
                    if (this.mSurfaceChanged) {
                        onSurfaceChanged();
                        this.mSurfaceChanged = false;
                    }
                }
                GLES20.glBindFramebuffer(36160, this.mFrameBuffer[0]);
                GLES20.glViewport(0, 0, this.mFrameBufferWidth, this.mFrameBufferHeight);
                z = this.mExtFilter.draw(this.mVertexBuf, this.mFrameBufferTextureCoordinate);
                if (z || this.mIsFrameBufferDrawn) {
                    if (z) {
                        this.mIsFrameBufferDrawn = true;
                    }
                    int stretchMode = this.mAPlayerAndroid.getStretchMode();
                    ViewPort viewport = getViewport(stretchMode);
                    String str2 = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("viewPort left =  ");
                    stringBuilder2.append(viewport.left);
                    stringBuilder2.append(" top = ");
                    stringBuilder2.append(viewport.top);
                    stringBuilder2.append(" width = ");
                    stringBuilder2.append(viewport.width);
                    stringBuilder2.append(" height = ");
                    stringBuilder2.append(viewport.height);
                    Log.i(str2, stringBuilder2.toString());
                    GLES20.glViewport(viewport.left, viewport.top, viewport.width, viewport.height);
                    GLES20.glBindFramebuffer(36160, 0);
                    this.mFilter.draw(this.mFrameBufferTexture[0], this.mVertexBuf, this.mDisplayTextureCoordinate);
                    this.mScreenshotLock.lock();
                    if (this.mFetchScreenshoting) {
                        ViewPort viewport2 = getViewport(this.mAPlayerAndroid.getStretchMode());
                        if (this.mScreenshotBitmap != null) {
                            this.mScreenshotBitmap.recycle();
                        }
                        this.mScreenshotBitmap = createBitmapFromGLSurface(viewport2.left, viewport2.top, viewport2.width, viewport2.height);
                        this.mFetchScreenshoting = false;
                        this.mScreenshotNotComplete.signalAll();
                    }
                    this.mScreenshotLock.unlock();
                    if (this.mInputSurface != null) {
                        this.mInputSurface.swapBuffers();
                        GLES20.glFlush();
                    }
                    if (stretchMode != 2) {
                        GLES20.glViewport(0, 0, this.mDisplayWidth, this.mDisplayHeight);
                    }
                }
            }
            if (this.mAPlayerAndroid.getEncodeCore() != null && this.mAPlayerAndroid.getEncodeCore().isEncoding() && r0) {
                this.mAPlayerAndroid.getEncodeCore().putRawData(this.mFrameBufferTexture[0], this.mAPlayerAndroid.getHardwareDecoder().getRealTimeUs());
                try {
                    this.mInputSurface.makeCurrent();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        interRelease();
    }

    public void createFrameBuffer(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int[] iArr3 = iArr;
        int[] iArr4 = iArr2;
        int i4 = i3;
        for (int i5 = 0; i5 < i4; i5++) {
            GLES20.glGenTextures(1, iArr4, i5);
            GLES20.glBindTexture(3553, iArr4[i5]);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glGenFramebuffers(1, iArr3, i5);
            GLES20.glBindFramebuffer(36160, iArr3[i5]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr4[i5], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
    }

    private void destroyFrameBuffers() {
        if (this.mFrameBufferTexture != null) {
            GLES20.glDeleteTextures(this.mFrameBufferTexture.length, this.mFrameBufferTexture, 0);
            this.mFrameBufferTexture = null;
        }
        if (this.mFrameBuffer != null) {
            GLES20.glDeleteFramebuffers(this.mFrameBuffer.length, this.mFrameBuffer, 0);
            this.mFrameBuffer = null;
        }
        this.mIsFrameBufferDrawn = false;
    }

    private void interRelease() {
        destroyFrameBuffers();
        this.mInputSurface.release();
        this.mExtFilter.destroy();
        this.mFilter.destroy();
        this.mIsReleased.set(true);
    }

    public void release() {
        this.isRunning = false;
        do {
        } while (!this.mIsReleased.get());
    }

    public Surface GetSurface() {
        if (this.mExtFilter == null) {
            synchronized (this.mLock) {
                try {
                    this.mLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        SurfaceTexture surfaceTexture1 = this.mExtFilter != null ? this.mExtFilter.getSurfaceTexture1() : null;
        if (surfaceTexture1 != null) {
            return new Surface(surfaceTexture1);
        }
        return null;
    }

    private ViewPort getViewport(int i) {
        ViewPort viewPort;
        int i2 = this.mDisplayWidth;
        int i3 = this.mDisplayHeight;
        double d = (double) ((((float) this.mVideoWidth) * 1.0f) / ((float) this.mVideoHeight));
        double d2 = (double) ((((float) this.mDisplayWidth) * 1.0f) / ((float) this.mDisplayHeight));
        int i4 = 0;
        if (i != 0) {
            if (i == 1) {
                if (d < d2) {
                    i3 = (int) (((double) i2) / d);
                    if (i3 < this.mDisplayHeight) {
                        i = (this.mDisplayHeight - i3) / 2;
                        viewPort = new ViewPort();
                        viewPort.left = i4;
                        viewPort.top = i;
                        viewPort.height = i3;
                        viewPort.width = i2;
                        return viewPort;
                    }
                }
                i2 = (int) (d * ((double) i3));
                i = (this.mDisplayWidth - i2) / 2;
            } else if (i == 3) {
                if (d > 1.0d) {
                    i3 = (int) (((double) i2) / d);
                    if (i3 < this.mDisplayHeight) {
                        i = (this.mDisplayHeight - i3) / 2;
                        viewPort = new ViewPort();
                        viewPort.left = i4;
                        viewPort.top = i;
                        viewPort.height = i3;
                        viewPort.width = i2;
                        return viewPort;
                    }
                }
                i2 = (int) (d * ((double) i3));
                i = (this.mDisplayWidth - i2) / 2;
            }
            i = 0;
            viewPort = new ViewPort();
            viewPort.left = i4;
            viewPort.top = i;
            viewPort.height = i3;
            viewPort.width = i2;
            return viewPort;
        } else if (d > d2) {
            i3 = (int) (((double) i2) / d);
            i = (this.mDisplayHeight - i3) / 2;
            viewPort = new ViewPort();
            viewPort.left = i4;
            viewPort.top = i;
            viewPort.height = i3;
            viewPort.width = i2;
            return viewPort;
        } else {
            i2 = (int) (d * ((double) i3));
            i = (this.mDisplayWidth - i2) / 2;
        }
        i4 = i;
        i = 0;
        viewPort = new ViewPort();
        viewPort.left = i4;
        viewPort.top = i;
        viewPort.height = i3;
        viewPort.width = i2;
        return viewPort;
    }

    public void setTextureArea(TextureArea textureArea) {
        synchronized (this.mLock) {
            this.mTextureArea = textureArea;
            this.mReCreateFlatModel = true;
        }
    }

    private void createFlatModel() {
        float f;
        float f2;
        float f3 = 1.0f;
        if (this.mTextureArea == null || r0.mTextureArea.mTextureWidth <= 0.0f || r0.mTextureArea.mTextureHeight <= 0.0f) {
            f = 1.0f;
            f2 = 0.0f;
        } else {
            f2 = r0.mTextureArea.m_crop_left / r0.mTextureArea.mTextureWidth;
            f = r0.mTextureArea.m_crop_bottom / r0.mTextureArea.mTextureHeight;
            if (r0.mTextureArea.m_crop_right > 0.0f) {
                f3 = (r0.mTextureArea.m_crop_right - r0.mTextureArea.m_crop_left) / r0.mTextureArea.mTextureWidth;
            }
            if (r0.mTextureArea.m_crop_bottom > 0.0f) {
                f = (r0.mTextureArea.m_crop_bottom - r0.mTextureArea.m_crop_top) / r0.mTextureArea.mTextureHeight;
            }
        }
        String config = r0.mAPlayerAndroid.getConfig(41);
        float[] fArr = new float[]{f3, f, f3, 0.0f, f2, 0.0f, f2, 0.0f, f2, f, f3, f};
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("CreateFlatModel orientation = ");
        stringBuilder.append(config);
        Log.i(str, stringBuilder.toString());
        if (config.equals("90") || config.equals("-270")) {
            fArr = new float[]{f3, 0.0f, f2, 0.0f, f2, f, f2, f, f3, f, f3, 0.0f};
        }
        if (config.equals("-90") || config.equals("270")) {
            fArr = new float[]{f2, f, f3, f, f3, 0.0f, f3, 0.0f, f2, 0.0f, f2, f};
        }
        if (config.equals("180") || config.equals("-180")) {
            fArr = new float[]{f2, 0.0f, f2, f, f3, f, f3, f, f3, 0.0f, f2, 0.0f};
        }
        String str2 = TAG;
        StringBuilder stringBuilder2 = new StringBuilder("create FrameBufferTextureCoordinate:（");
        stringBuilder2.append(f2);
        stringBuilder2.append(",0.0), (");
        stringBuilder2.append(f3);
        stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder2.append(f);
        Log.e(str2, stringBuilder2.toString());
        r0.mFrameBufferTextureCoordinate = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr);
        r0.mFrameBufferTextureCoordinate.position(0);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        surfaceHolder = TAG;
        i = new StringBuilder("surfaceRender width = ");
        i.append(i2);
        Log.i(surfaceHolder, i.toString());
    }

    public Bitmap getScreenshot() {
        this.mScreenshotLock.lock();
        this.mFetchScreenshoting = true;
        while (this.mFetchScreenshoting) {
            try {
                this.mScreenshotNotComplete.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                this.mScreenshotLock.unlock();
            }
        }
        this.mScreenshotLock.unlock();
        return this.mScreenshotBitmap;
    }

    private android.graphics.Bitmap createBitmapFromGLSurface(int r11, int r12, int r13, int r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = "APlayerSurfaceRenderer";
        r1 = "surfaceRender createBitmapFromGLSurface";
        com.aplayer.aplayerandroid.Log.i(r0, r1);
        r0 = r13 * r14;
        r1 = new int[r0];
        r0 = new int[r0];
        r8 = java.nio.IntBuffer.wrap(r1);
        r9 = 0;
        r8.position(r9);
        r6 = 6408; // 0x1908 float:8.98E-42 double:3.166E-320;
        r7 = 5121; // 0x1401 float:7.176E-42 double:2.53E-320;
        r2 = r11;
        r3 = r12;
        r4 = r13;
        r5 = r14;
        android.opengl.GLES20.glReadPixels(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x0051 }
        r11 = r9;	 Catch:{ Exception -> 0x0051 }
    L_0x0021:
        if (r11 >= r14) goto L_0x004a;	 Catch:{ Exception -> 0x0051 }
    L_0x0023:
        r12 = r11 * r13;	 Catch:{ Exception -> 0x0051 }
        r2 = r14 - r11;	 Catch:{ Exception -> 0x0051 }
        r2 = r2 + -1;	 Catch:{ Exception -> 0x0051 }
        r2 = r2 * r13;	 Catch:{ Exception -> 0x0051 }
        r3 = r9;	 Catch:{ Exception -> 0x0051 }
    L_0x002b:
        if (r3 >= r13) goto L_0x0047;	 Catch:{ Exception -> 0x0051 }
    L_0x002d:
        r4 = r12 + r3;	 Catch:{ Exception -> 0x0051 }
        r4 = r1[r4];	 Catch:{ Exception -> 0x0051 }
        r5 = r4 >> 16;	 Catch:{ Exception -> 0x0051 }
        r5 = r5 & 255;	 Catch:{ Exception -> 0x0051 }
        r6 = r4 << 16;	 Catch:{ Exception -> 0x0051 }
        r7 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;	 Catch:{ Exception -> 0x0051 }
        r6 = r6 & r7;	 Catch:{ Exception -> 0x0051 }
        r7 = -16711936; // 0xffffffffff00ff00 float:-1.7146522E38 double:NaN;	 Catch:{ Exception -> 0x0051 }
        r4 = r4 & r7;	 Catch:{ Exception -> 0x0051 }
        r4 = r4 | r6;	 Catch:{ Exception -> 0x0051 }
        r4 = r4 | r5;	 Catch:{ Exception -> 0x0051 }
        r5 = r2 + r3;	 Catch:{ Exception -> 0x0051 }
        r0[r5] = r4;	 Catch:{ Exception -> 0x0051 }
        r3 = r3 + 1;
        goto L_0x002b;
    L_0x0047:
        r11 = r11 + 1;
        goto L_0x0021;
    L_0x004a:
        r11 = android.graphics.Bitmap.Config.ARGB_8888;
        r11 = android.graphics.Bitmap.createBitmap(r0, r13, r14, r11);
        return r11;
    L_0x0051:
        r11 = 0;
        return r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.aplayer.aplayerandroid.SurfaceRenderer.createBitmapFromGLSurface(int, int, int, int):android.graphics.Bitmap");
    }
}
