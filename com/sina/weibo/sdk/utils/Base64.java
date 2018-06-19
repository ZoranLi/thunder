package com.sina.weibo.sdk.utils;

public final class Base64 {
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
    private static byte[] codes = new byte[256];

    static {
        int i;
        for (i = 0; i < 256; i++) {
            codes[i] = (byte) -1;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            codes[i2] = (byte) (i2 - 65);
        }
        for (i = 97; i <= 122; i++) {
            codes[i] = (byte) ((26 + i) - 97);
        }
        for (i = 48; i <= 57; i++) {
            codes[i] = (byte) ((52 + i) - 48);
        }
        codes[43] = (byte) 62;
        codes[47] = (byte) 63;
    }

    public static byte[] decode(byte[] bArr) {
        int length = ((bArr.length + 3) / 4) * 3;
        if (bArr.length > 0 && bArr[bArr.length - 1] == (byte) 61) {
            length--;
        }
        if (bArr.length > 1 && bArr[bArr.length - 2] == (byte) 61) {
            length--;
        }
        byte[] bArr2 = new byte[length];
        int i = 0;
        length = 0;
        int i2 = length;
        int i3 = i2;
        while (i < bArr.length) {
            byte b = codes[bArr[i] & 255];
            if (b >= (byte) 0) {
                i3 += 6;
                i2 = (i2 << 6) | b;
                if (i3 >= 8) {
                    i3 -= 8;
                    int i4 = length + 1;
                    bArr2[length] = (byte) ((i2 >> i3) & 255);
                    length = i4;
                }
            }
            i++;
        }
        if (length == bArr2.length) {
            return bArr2;
        }
        throw new RuntimeException("miscalculated data length!");
    }

    public static char[] encode(byte[] bArr) {
        char[] cArr = new char[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = i;
        while (i < bArr.length) {
            Object obj;
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            Object obj2 = 1;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            int i5 = i + 2;
            if (i5 < bArr.length) {
                i3 |= 255 & bArr[i5];
            } else {
                obj2 = null;
            }
            int i6 = 64;
            cArr[i2 + 3] = alphabet[obj2 != null ? i3 & 63 : 64];
            i3 >>= 6;
            int i7 = i2 + 2;
            char[] cArr2 = alphabet;
            if (obj != null) {
                i6 = i3 & 63;
            }
            cArr[i7] = cArr2[i6];
            i3 >>= 6;
            cArr[i2 + 1] = alphabet[i3 & 63];
            cArr[i2 + 0] = alphabet[(i3 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return cArr;
    }

    public static byte[] encodebyte(byte[] bArr) {
        byte[] bArr2 = new byte[(((bArr.length + 2) / 3) * 4)];
        int i = 0;
        int i2 = i;
        while (i < bArr.length) {
            Object obj;
            int i3 = (bArr[i] & 255) << 8;
            int i4 = i + 1;
            Object obj2 = 1;
            if (i4 < bArr.length) {
                i3 |= bArr[i4] & 255;
                obj = 1;
            } else {
                obj = null;
            }
            i3 <<= 8;
            int i5 = i + 2;
            if (i5 < bArr.length) {
                i3 |= 255 & bArr[i5];
            } else {
                obj2 = null;
            }
            int i6 = 64;
            bArr2[i2 + 3] = (byte) alphabet[obj2 != null ? i3 & 63 : 64];
            i3 >>= 6;
            int i7 = i2 + 2;
            char[] cArr = alphabet;
            if (obj != null) {
                i6 = i3 & 63;
            }
            bArr2[i7] = (byte) cArr[i6];
            i3 >>= 6;
            bArr2[i2 + 1] = (byte) alphabet[i3 & 63];
            bArr2[i2 + 0] = (byte) alphabet[(i3 >> 6) & 63];
            i += 3;
            i2 += 4;
        }
        return bArr2;
    }
}
