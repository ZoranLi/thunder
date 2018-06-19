package com.alipay.sdk.encrypt;

import com.tencent.bugly.beta.tinker.TinkerReport;

public final class a {
    private static final int a = 128;
    private static final int b = 64;
    private static final int c = 24;
    private static final int d = 8;
    private static final int e = 16;
    private static final int f = 4;
    private static final int g = -128;
    private static final char h = '=';
    private static final byte[] i = new byte[128];
    private static final char[] j = new char[64];

    private static boolean a(char c) {
        if (!(c == ' ' || c == '\r' || c == '\n')) {
            if (c != '\t') {
                return false;
            }
        }
        return true;
    }

    private static boolean b(char c) {
        return c == h;
    }

    static {
        int i;
        int i2 = 0;
        for (int i3 = 0; i3 < 128; i3++) {
            i[i3] = (byte) -1;
        }
        for (i = 90; i >= 65; i--) {
            i[i] = (byte) (i - 65);
        }
        i = 122;
        while (true) {
            int i4 = 26;
            if (i < 97) {
                break;
            }
            i[i] = (byte) ((i - 97) + 26);
            i--;
        }
        i = 57;
        while (true) {
            int i5 = 52;
            if (i < 48) {
                break;
            }
            i[i] = (byte) ((i - 48) + 52);
            i--;
        }
        i[43] = (byte) 62;
        i[47] = (byte) 63;
        for (i = 0; i <= 25; i++) {
            j[i] = (char) (65 + i);
        }
        i = 0;
        while (i4 <= 51) {
            j[i4] = (char) (97 + i);
            i4++;
            i++;
        }
        while (i5 <= 61) {
            j[i5] = (char) (48 + i2);
            i5++;
            i2++;
        }
        j[62] = '+';
        j[63] = '/';
    }

    private static boolean c(char c) {
        return c < '' && i[c] != '￿';
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i = length % 24;
        length /= 24;
        char[] cArr = new char[((i != 0 ? length + 1 : length) * 4)];
        int i2 = 0;
        int i3 = 0;
        int i4 = i3;
        while (i2 < length) {
            int i5 = i3 + 1;
            byte b = bArr[i3];
            int i6 = i5 + 1;
            byte b2 = bArr[i5];
            int i7 = i6 + 1;
            byte b3 = bArr[i6];
            byte b4 = (byte) (b2 & 15);
            byte b5 = (byte) (b & 3);
            b2 = (byte) ((b2 & g) == 0 ? b2 >> 4 : (b2 >> 4) ^ 240);
            byte b6 = (byte) ((b3 & g) == 0 ? b3 >> 6 : (b3 >> 6) ^ TinkerReport.KEY_LOADED_EXCEPTION_DEX);
            int i8 = i4 + 1;
            cArr[i4] = j[(byte) ((b & g) == 0 ? b >> 2 : (b >> 2) ^ 192)];
            i3 = i8 + 1;
            cArr[i8] = j[b2 | (b5 << 4)];
            i4 = i3 + 1;
            cArr[i3] = j[(b4 << 2) | b6];
            i3 = i4 + 1;
            cArr[i4] = j[b3 & 63];
            i2++;
            i4 = i3;
            i3 = i7;
        }
        byte b7;
        int i9;
        if (i == 8) {
            bArr = bArr[i3];
            b7 = (byte) (bArr & 3);
            i = i4 + 1;
            cArr[i4] = j[(byte) ((bArr & g) == 0 ? bArr >> 2 : (bArr >> 2) ^ 192)];
            bArr = i + 1;
            cArr[i] = j[b7 << 4];
            i9 = bArr + 1;
            cArr[bArr] = h;
            cArr[i9] = h;
        } else if (i == 16) {
            b7 = bArr[i3];
            bArr = bArr[i3 + 1];
            byte b8 = (byte) (bArr & 15);
            byte b9 = (byte) (b7 & 3);
            bArr = (byte) ((bArr & g) == 0 ? bArr >> 4 : (bArr >> 4) ^ 240);
            i3 = i4 + 1;
            cArr[i4] = j[(byte) ((b7 & g) == 0 ? b7 >> 2 : (b7 >> 2) ^ 192)];
            i9 = i3 + 1;
            cArr[i3] = j[bArr | (b9 << 4)];
            bArr = i9 + 1;
            cArr[i9] = j[b8 << 2];
            cArr[bArr] = h;
        }
        return new String(cArr);
    }

    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        int i;
        int i2;
        char c;
        int i3;
        str = str.toCharArray();
        if (str == null) {
            i = 0;
        } else {
            int length = str.length;
            i2 = 0;
            i = i2;
            while (i2 < length) {
                c = str[i2];
                if (!(c == ' ' || c == '\r' || c == '\n')) {
                    if (c != '\t') {
                        i3 = 0;
                        if (i3 == 0) {
                            i3 = i + 1;
                            str[i] = str[i2];
                            i = i3;
                        }
                        i2++;
                    }
                }
                i3 = 1;
                if (i3 == 0) {
                    i3 = i + 1;
                    str[i] = str[i2];
                    i = i3;
                }
                i2++;
            }
        }
        if (i % 4 != 0) {
            return null;
        }
        i /= 4;
        if (i == 0) {
            return new byte[0];
        }
        Object obj = new byte[(i * 3)];
        i2 = 0;
        i3 = i2;
        int i4 = i3;
        while (i2 < i - 1) {
            int i5 = i3 + 1;
            c = str[i3];
            if (c(c)) {
                int i6 = i5 + 1;
                char c2 = str[i5];
                if (c(c2)) {
                    int i7 = i6 + 1;
                    char c3 = str[i6];
                    if (c(c3)) {
                        int i8 = i7 + 1;
                        char c4 = str[i7];
                        if (c(c4)) {
                            byte b = i[c];
                            byte b2 = i[c2];
                            byte b3 = i[c3];
                            byte b4 = i[c4];
                            int i9 = i4 + 1;
                            obj[i4] = (byte) ((b << 2) | (b2 >> 4));
                            i3 = i9 + 1;
                            obj[i9] = (byte) (((b2 & 15) << 4) | ((b3 >> 2) & 15));
                            i4 = i3 + 1;
                            obj[i3] = (byte) ((b3 << 6) | b4);
                            i2++;
                            i3 = i8;
                        }
                    }
                }
            }
            return null;
        }
        int i10 = i3 + 1;
        char c5 = str[i3];
        if (c(c5)) {
            i3 = i10 + 1;
            char c6 = str[i10];
            if (c(c6)) {
                int i11;
                byte b5 = i[c5];
                byte b6 = i[c6];
                i5 = i3 + 1;
                c = str[i3];
                str = str[i5];
                if (c(c)) {
                    if (c(str)) {
                        byte b7 = i[c];
                        str = i[str];
                        i11 = i4 + 1;
                        obj[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                        i2 = i11 + 1;
                        obj[i11] = (byte) (((b6 & 15) << 4) | ((b7 >> 2) & 15));
                        obj[i2] = (byte) (str | (b7 << 6));
                        return obj;
                    }
                }
                if (b(c) && b(str)) {
                    if ((b6 & 15) != null) {
                        return null;
                    }
                    i2 *= 3;
                    str = new byte[(i2 + 1)];
                    System.arraycopy(obj, 0, str, 0, i2);
                    str[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    return str;
                } else if (b(c) || b(str) == null) {
                    return null;
                } else {
                    str = i[c];
                    if ((str & 3) != 0) {
                        return null;
                    }
                    i2 *= 3;
                    Object obj2 = new byte[(i2 + 2)];
                    System.arraycopy(obj, 0, obj2, 0, i2);
                    i11 = i4 + 1;
                    obj2[i4] = (byte) ((b5 << 2) | (b6 >> 4));
                    obj2[i11] = (byte) (((str >> 2) & 15) | ((b6 & 15) << 4));
                    return obj2;
                }
            }
        }
        return null;
    }

    private static int a(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = 0;
        int i2 = i;
        while (i < length) {
            int i3;
            char c = cArr[i];
            if (!(c == ' ' || c == '\r' || c == '\n')) {
                if (c != '\t') {
                    i3 = 0;
                    if (i3 == 0) {
                        i3 = i2 + 1;
                        cArr[i2] = cArr[i];
                        i2 = i3;
                    }
                    i++;
                }
            }
            i3 = 1;
            if (i3 == 0) {
                i3 = i2 + 1;
                cArr[i2] = cArr[i];
                i2 = i3;
            }
            i++;
        }
        return i2;
    }
}
