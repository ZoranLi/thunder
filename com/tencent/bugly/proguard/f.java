package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
public class f {
    public static final byte[] a = new byte[0];
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length != 0) {
                char[] cArr = new char[(bArr.length * 2)];
                for (int i = 0; i < bArr.length; i++) {
                    byte b = bArr[i];
                    int i2 = 2 * i;
                    cArr[i2 + 1] = b[b & 15];
                    cArr[i2 + 0] = b[((byte) (b >>> 4)) & 15];
                }
                return new String(cArr);
            }
        }
        return null;
    }
}
