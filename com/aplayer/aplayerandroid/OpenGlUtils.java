package com.aplayer.aplayerandroid;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.Camera.Size;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

public class OpenGlUtils {
    public static final int NO_TEXTURE = -1;
    public static final int SIZEOF_BYTE = 1;
    public static final int SIZEOF_FLOAT = 4;
    public static final int SIZEOF_INT = 4;
    public static final int SIZEOF_SHORT = 2;
    public static final String TAG = "GPUIMAGE";

    public static void updateTexture(int i, Bitmap bitmap, boolean z) {
        GLES20.glBindTexture(3553, i);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glBindTexture(3553, 0);
        if (z) {
            bitmap.recycle();
        }
    }

    public static int createTexture() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static int loadTexture(Bitmap bitmap, int i) {
        return loadTexture(bitmap, i, true);
    }

    public static int loadTexture(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        GLES20.glBindTexture(3553, 0);
        return iArr[0];
    }

    public static int loadTexture(IntBuffer intBuffer, int i, int i2, int i3) {
        int i4 = i3;
        int[] iArr = new int[1];
        if (i4 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, intBuffer);
        } else {
            GLES20.glBindTexture(3553, i4);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i, i2, 6408, 5121, intBuffer);
            iArr[0] = i4;
        }
        return iArr[0];
    }

    public static int loadTexture(IntBuffer intBuffer, Size size, int i) {
        Size size2 = size;
        int i2 = i;
        int[] iArr = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, size2.width, size2.height, 0, 6408, 5121, intBuffer);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, size2.width, size2.height, 6408, 5121, intBuffer);
            iArr[0] = i2;
        }
        return iArr[0];
    }

    public static int loadTextureAsBitmap(IntBuffer intBuffer, Size size, int i) {
        return loadTexture(Bitmap.createBitmap(intBuffer.array(), size.width, size.height, Config.ARGB_8888), i);
    }

    public static int loadShader(String str, int i) {
        int[] iArr = new int[1];
        i = GLES20.glCreateShader(i);
        GLES20.glShaderSource(i, str);
        GLES20.glCompileShader(i);
        GLES20.glGetShaderiv(i, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return i;
        }
        new StringBuilder("Compilation\n").append(GLES20.glGetShaderInfoLog(i));
        return 0;
    }

    public static int loadProgram(String str, String str2) {
        int[] iArr = new int[1];
        str = loadShader(str, 35633);
        if (str == null) {
            return 0;
        }
        str2 = loadShader(str2, 35632);
        if (str2 == null) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, str);
        GLES20.glAttachShader(glCreateProgram, str2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            return 0;
        }
        GLES20.glDeleteShader(str);
        GLES20.glDeleteShader(str2);
        return glCreateProgram;
    }

    public static float rnd(float f, float f2) {
        return f + ((f2 - f) * ((float) Math.random()));
    }

    public static void checkGlError(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(": glError 0x");
            stringBuilder.append(Integer.toHexString(glGetError));
        }
    }

    public static FloatBuffer createFloatBuffer(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static FloatBuffer createFloatBuffer(int i) {
        i = ByteBuffer.allocateDirect(i * 4);
        i.order(ByteOrder.nativeOrder());
        return i.asFloatBuffer();
    }

    public static FloatBuffer createFloatBuffer(double[] dArr) {
        float[] fArr = new float[dArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = (float) dArr[i];
        }
        dArr = ByteBuffer.allocateDirect(fArr.length * 4);
        dArr.order(ByteOrder.nativeOrder());
        dArr = dArr.asFloatBuffer();
        dArr.put(fArr);
        dArr.position(0);
        return dArr;
    }

    public static void updateFloatBuffer(FloatBuffer floatBuffer, float[] fArr) {
        floatBuffer.clear();
        floatBuffer.put(fArr);
        floatBuffer.position(null);
    }

    public static IntBuffer createIntBuffer(int[] iArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(iArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        asIntBuffer.put(iArr);
        asIntBuffer.position(0);
        return asIntBuffer;
    }

    public static ShortBuffer createShortBuffer(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.position(0);
        return asShortBuffer;
    }

    public static ByteBuffer createByteBuffer(byte[] bArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bArr.length * 1);
        allocateDirect.order(ByteOrder.nativeOrder());
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        return allocateDirect;
    }

    public static void createFrameBuffer(int i, int i2, int[] iArr, int[] iArr2, int i3) {
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

    public static void releaseFrameBuffer(int i, int[] iArr, int[] iArr2) {
        GLES20.glDeleteTextures(i, iArr, 0);
        GLES20.glDeleteFramebuffers(i, iArr2, 0);
    }
}
