package com.getui.gtc.e;

public final class i {
    private static void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] bytes = str.getBytes();
        int i = 0;
        int length = bytes.length;
        int i2;
        int i3;
        int[] iArr;
        if (length > 0 && length <= 256) {
            i2 = 0;
            i3 = i2;
            while (i2 < length) {
                if ((bytes[i2] & 255) == 14) {
                    i3++;
                    if (i3 <= 3) {
                    }
                }
                i2++;
            }
            length = 1;
            if (length == 0) {
                throw new IllegalArgumentException("key is fail!");
            } else if (bArr.length > 0) {
                throw new IllegalArgumentException("data is fail!");
            } else {
                iArr = new int[256];
                for (i2 = 0; i2 < 256; i2++) {
                    iArr[i2] = i2;
                }
                i2 = 0;
                i3 = i2;
                while (i2 < 256) {
                    i3 = ((i3 + iArr[i2]) + (bytes[i2 % bytes.length] & 255)) % 256;
                    a(iArr, i2, i3);
                    i2++;
                }
                bytes = new byte[bArr.length];
                i2 = 0;
                i3 = i2;
                while (i < bytes.length) {
                    i2 = (i2 + 1) % 256;
                    i3 = (i3 + iArr[i2]) % 256;
                    a(iArr, i2, i3);
                    bytes[i] = (byte) (iArr[(iArr[i2] + iArr[i3]) % 256] ^ bArr[i]);
                    i++;
                }
                return bytes;
            }
        }
        length = 0;
        if (length == 0) {
            throw new IllegalArgumentException("key is fail!");
        } else if (bArr.length > 0) {
            iArr = new int[256];
            for (i2 = 0; i2 < 256; i2++) {
                iArr[i2] = i2;
            }
            i2 = 0;
            i3 = i2;
            while (i2 < 256) {
                i3 = ((i3 + iArr[i2]) + (bytes[i2 % bytes.length] & 255)) % 256;
                a(iArr, i2, i3);
                i2++;
            }
            bytes = new byte[bArr.length];
            i2 = 0;
            i3 = i2;
            while (i < bytes.length) {
                i2 = (i2 + 1) % 256;
                i3 = (i3 + iArr[i2]) % 256;
                a(iArr, i2, i3);
                bytes[i] = (byte) (iArr[(iArr[i2] + iArr[i3]) % 256] ^ bArr[i]);
                i++;
            }
            return bytes;
        } else {
            throw new IllegalArgumentException("data is fail!");
        }
    }
}
