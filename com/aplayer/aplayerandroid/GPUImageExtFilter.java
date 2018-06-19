package com.aplayer.aplayerandroid;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class GPUImageExtFilter {
    public static final String NO_FILTER_FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require                                     \nvarying highp vec2 textureCoordinate;                                              \nuniform samplerExternalOES inputImageTexture1;                                      \nvoid main()                                                                        \n{                                                                                  \n     gl_FragColor = texture2D(inputImageTexture1, textureCoordinate);               \n}";
    public static final String NO_FILTER_VERTEX_SHADER = "attribute vec4 position;                                                               \nattribute vec4 inputTextureCoordinate;                                                 \nvarying vec2 textureCoordinate;                                                        \n                                                                                       \nvoid main()                                                                            \n{                                                                                      \n    gl_Position = position;                                                            \n    textureCoordinate = inputTextureCoordinate.xy;                                     \n}";
    private String TAG;
    private Object lock;
    private String mFragmentShader;
    private boolean mFrameAvailable1;
    protected int mGLAttribPosition;
    protected int mGLAttribTextureCoordinate;
    protected int mGLProgId;
    protected int mGLUniformTexture1;
    private InputSurface mInputSurface;
    private boolean mIsInitialized;
    private int[] mOESTextures;
    private final LinkedList<Runnable> mRunOnDraw;
    private SurfaceTexture mSurfaceTexture1;
    protected int mTextureTarget;
    private String mVertexShader;

    public GPUImageExtFilter(InputSurface inputSurface) {
        this(NO_FILTER_VERTEX_SHADER, NO_FILTER_FRAGMENT_SHADER);
        this.mInputSurface = inputSurface;
    }

    public GPUImageExtFilter(String str, String str2) {
        this.TAG = GPUImageFilter.class.getSimpleName();
        this.mRunOnDraw = null;
        this.mSurfaceTexture1 = null;
        this.mFrameAvailable1 = false;
        this.lock = new Object();
        this.mVertexShader = str;
        this.mFragmentShader = str2;
        this.mTextureTarget = 36197;
    }

    public void Init() {
        OpenGlUtils.checkGlError("init start");
        this.mOESTextures = new int[1];
        GLES20.glGenTextures(1, this.mOESTextures, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.mOESTextures[0]);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        this.mGLProgId = OpenGlUtils.loadProgram(this.mVertexShader, this.mFragmentShader);
        this.mGLAttribPosition = GLES20.glGetAttribLocation(this.mGLProgId, "position");
        this.mGLUniformTexture1 = GLES20.glGetUniformLocation(this.mGLProgId, "inputImageTexture1");
        this.mGLAttribTextureCoordinate = GLES20.glGetAttribLocation(this.mGLProgId, "inputTextureCoordinate");
        this.mIsInitialized = true;
        OpenGlUtils.checkGlError("init end");
    }

    public SurfaceTexture getSurfaceTexture1() {
        if (this.mIsInitialized && this.mSurfaceTexture1 == null) {
            this.mSurfaceTexture1 = new SurfaceTexture(this.mOESTextures[0]);
            this.mSurfaceTexture1.setOnFrameAvailableListener(new OnFrameAvailableListener() {
                public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                    Log.i(GPUImageExtFilter.this.TAG, "filter mFrameAvailable1 = true");
                    synchronized (GPUImageExtFilter.this.lock) {
                        GPUImageExtFilter.this.mFrameAvailable1 = true;
                    }
                }
            });
        }
        return this.mSurfaceTexture1;
    }

    public boolean isFrameAvliable() {
        boolean z;
        synchronized (this.lock) {
            z = this.mFrameAvailable1;
        }
        return z;
    }

    public boolean draw(FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        GLES20.glUseProgram(this.mGLProgId);
        if (!this.mIsInitialized || this.mSurfaceTexture1 == null) {
            return false;
        }
        synchronized (this.lock) {
            if (this.mFrameAvailable1) {
                try {
                    this.mSurfaceTexture1.updateTexImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mFrameAvailable1 = false;
                floatBuffer.position(0);
                GLES20.glVertexAttribPointer(this.mGLAttribPosition, 3, 5126, false, 0, floatBuffer);
                GLES20.glEnableVertexAttribArray(this.mGLAttribPosition);
                floatBuffer2.position(0);
                GLES20.glVertexAttribPointer(this.mGLAttribTextureCoordinate, 2, 5126, false, 0, floatBuffer2);
                GLES20.glEnableVertexAttribArray(this.mGLAttribTextureCoordinate);
                GLES20.glActiveTexture(33984);
                GLES20.glBindTexture(this.mTextureTarget, this.mOESTextures[0]);
                GLES20.glUniform1i(this.mGLUniformTexture1, 0);
                GLES20.glDrawArrays(5, 0, 6);
                GLES20.glDisableVertexAttribArray(this.mGLAttribPosition);
                GLES20.glDisableVertexAttribArray(this.mGLAttribTextureCoordinate);
                GLES20.glBindTexture(this.mTextureTarget, 0);
                GLES20.glFlush();
                return true;
            }
            return false;
        }
    }

    public void destroy() {
        this.mIsInitialized = false;
        GLES20.glDeleteProgram(this.mGLProgId);
    }
}
