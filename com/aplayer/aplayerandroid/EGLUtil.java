package com.aplayer.aplayerandroid;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.opengl.GLSurfaceView.EGLContextFactory;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class EGLUtil {

    public static class MyEGLConfigChooser implements EGLConfigChooser {
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (egl10.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, eGLConfigArr, 1, new int[1]) != null) {
                return eGLConfigArr[null];
            }
            throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
        }
    }

    public static class MyEGLContextFactory implements EGLContextFactory {
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            egl10 = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            if (egl10 != null) {
                return egl10;
            }
            throw new RuntimeException("null context");
        }

        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }
}
