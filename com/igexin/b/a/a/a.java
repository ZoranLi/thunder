package com.igexin.b.a.a;

public class a {
    public static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static boolean a(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0 || length > 256) {
            return false;
        }
        length = bArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            if ((bArr[i] & 255) == 14) {
                i2++;
                if (i2 > 3) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static byte[] a(byte[] bArr, String str) {
        return c(bArr, str);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!a(bArr2)) {
            throw new IllegalArgumentException("key is fail!");
        } else if (bArr.length <= 0) {
            throw new IllegalArgumentException("data is fail!");
        } else {
            int i;
            int[] iArr = new int[256];
            int i2 = 0;
            for (i = 0; i < 256; i++) {
                iArr[i] = i;
            }
            i = 0;
            int i3 = i;
            while (i < 256) {
                i3 = ((i3 + iArr[i]) + (bArr2[i % bArr2.length] & 255)) % 256;
                a(iArr, i, i3);
                i++;
            }
            bArr2 = new byte[bArr.length];
            i = 0;
            i3 = i;
            while (i2 < bArr2.length) {
                i = (i + 1) % 256;
                i3 = (i3 + iArr[i]) % 256;
                a(iArr, i, i3);
                bArr2[i2] = (byte) (iArr[(iArr[i] + iArr[i3]) % 256] ^ bArr[i2]);
                i2++;
            }
            return bArr2;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        return d(bArr, str);
    }

    public static byte[] c(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }

    public static byte[] d(byte[] bArr, String str) {
        return a(bArr, str.getBytes());
    }
}
