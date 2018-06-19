package com.xiaomi.channel.commonutils.string;

import com.tencent.tinker.android.dx.instruction.Opcodes;

public class a {
    private static final String a = System.getProperty("line.separator");
    private static char[] b = new char[64];
    private static byte[] c = new byte[128];

    static {
        int i = 0;
        char c = 'A';
        int i2 = 0;
        while (c <= 'Z') {
            int i3 = i2 + 1;
            b[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        c = 'a';
        while (c <= 'z') {
            i3 = i2 + 1;
            b[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        c = '0';
        while (c <= '9') {
            i3 = i2 + 1;
            b[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        int i4 = i2 + 1;
        b[i2] = '+';
        b[i4] = '/';
        for (int i5 = 0; i5 < c.length; i5++) {
            c[i5] = (byte) -1;
        }
        while (i < 64) {
            c[b[i]] = (byte) i;
            i++;
        }
    }

    public static byte[] a(String str) {
        return a(str.toCharArray());
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        i2 += i;
        int i4 = 0;
        while (i < i2) {
            int i5;
            int i6 = i + 1;
            char c = cArr[i];
            int i7 = i6 + 1;
            char c2 = cArr[i6];
            int i8 = 65;
            if (i7 < i2) {
                i5 = i7 + 1;
                i7 = cArr[i7];
            } else {
                i5 = i7;
                i7 = 65;
            }
            if (i5 < i2) {
                i8 = i5 + 1;
                char c3 = cArr[i5];
                i5 = i8;
                i8 = c3;
            }
            if (c <= '' && c2 <= '' && i7 <= Opcodes.NEG_FLOAT) {
                if (i8 <= Opcodes.NEG_FLOAT) {
                    byte b = c[c];
                    byte b2 = c[c2];
                    byte b3 = c[i7];
                    byte b4 = c[i8];
                    if (b >= (byte) 0 && b2 >= (byte) 0 && b3 >= (byte) 0) {
                        if (b4 >= (byte) 0) {
                            i = (b << 2) | (b2 >>> 4);
                            i6 = ((b2 & 15) << 4) | (b3 >>> 2);
                            i7 = ((b3 & 3) << 6) | b4;
                            i8 = i4 + 1;
                            bArr[i4] = (byte) i;
                            if (i8 < i3) {
                                i = i8 + 1;
                                bArr[i8] = (byte) i6;
                            } else {
                                i = i8;
                            }
                            if (i < i3) {
                                i4 = i + 1;
                                bArr[i] = (byte) i7;
                            } else {
                                i4 = i;
                            }
                            i = i5;
                        }
                    }
                    throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
                }
            }
            throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
        }
        return bArr;
    }

    public static char[] a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        int i3 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        i2 += i;
        int i4 = 0;
        while (i < i2) {
            int i5;
            int i6;
            int i7 = i + 1;
            i = bArr[i] & 255;
            if (i7 < i2) {
                i5 = i7 + 1;
                i7 = bArr[i7] & 255;
            } else {
                i5 = i7;
                i7 = 0;
            }
            if (i5 < i2) {
                i6 = i5 + 1;
                i5 = bArr[i5] & 255;
            } else {
                i6 = i5;
                i5 = 0;
            }
            int i8 = i >>> 2;
            i = ((i & 3) << 4) | (i7 >>> 4);
            i7 = ((i7 & 15) << 2) | (i5 >>> 6);
            i5 &= 63;
            int i9 = i4 + 1;
            cArr[i4] = b[i8];
            i4 = i9 + 1;
            cArr[i9] = b[i];
            char c = '=';
            cArr[i4] = i4 < i3 ? b[i7] : '=';
            i4++;
            if (i4 < i3) {
                c = b[i5];
            }
            cArr[i4] = c;
            i4++;
            i = i6;
        }
        return cArr;
    }
}
