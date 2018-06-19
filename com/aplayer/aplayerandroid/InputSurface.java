package com.aplayer.aplayerandroid;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build.VERSION;
import android.view.Surface;

@TargetApi(18)
public class InputSurface {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private EGLContext mEGLContext = null;
    private EGLDisplay mEGLDisplay = null;
    private EGLSurface mEGLSurface = null;
    private Surface mSurface = null;

    public InputSurface(Surface surface) {
        if (surface == null) {
            throw new NullPointerException();
        }
        this.mSurface = surface;
        eglSetup();
    }

    public void release() {
        EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
        EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
        if (VERSION.SDK_INT >= 17) {
            EGL14.eglReleaseThread();
        }
        EGL14.eglTerminate(this.mEGLDisplay);
        this.mSurface = null;
        this.mEGLDisplay = null;
        this.mEGLContext = null;
        this.mEGLSurface = null;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public void makeCurrent() {
        if (!EGL14.eglMakeCurrent(this.mEGLDisplay, this.mEGLSurface, this.mEGLSurface, this.mEGLContext)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
    }

    public void setPresentationTime(long j) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j);
    }

    private void eglSetup() {
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        if (this.mEGLDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(this.mEGLDisplay, iArr, 0, iArr, 1)) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.eglGetCurrentContext(), new int[]{12440, 2, 12344}, 0);
                OpenGlUtils.checkGlError("eglCreateContext");
                if (this.mEGLContext == null) {
                    throw new RuntimeException("null context");
                }
                try {
                    this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                OpenGlUtils.checkGlError("eglCreateWindowSurface");
                if (this.mEGLSurface == null) {
                    throw new RuntimeException("surface was null");
                }
                return;
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
        this.mEGLDisplay = null;
        throw new RuntimeException("unable to initialize EGL14");
    }
}
