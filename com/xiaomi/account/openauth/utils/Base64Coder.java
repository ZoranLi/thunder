package com.xiaomi.account.openauth.utils;

import com.tencent.tinker.android.dx.instruction.Opcodes;

public class Base64Coder {
    private static char[] map1 = new char[64];
    private static byte[] map2 = new byte[128];
    private static final String systemLineSeparator = System.getProperty("line.separator");

    static {
        int i = 0;
        char c = 'A';
        int i2 = 0;
        while (c <= 'Z') {
            int i3 = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        c = 'a';
        while (c <= 'z') {
            i3 = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        c = '0';
        while (c <= '9') {
            i3 = i2 + 1;
            map1[i2] = c;
            c = (char) (c + 1);
            i2 = i3;
        }
        int i4 = i2 + 1;
        map1[i2] = '+';
        map1[i4] = '/';
        for (int i5 = 0; i5 < map2.length; i5++) {
            map2[i5] = (byte) -1;
        }
        while (i < 64) {
            map2[map1[i]] = (byte) i;
            i++;
        }
    }

    public static String encodeString(String str) {
        return new String(encode(str.getBytes()));
    }

    public static String encodeLines(byte[] bArr) {
        return encodeLines(bArr, 0, bArr.length, 76, systemLineSeparator);
    }

    public static String encodeLines(byte[] bArr, int i, int i2, int i3, String str) {
        i3 = (i3 * 3) / 4;
        if (i3 <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder((((i2 + 2) / 3) * 4) + ((((i2 + i3) - 1) / i3) * str.length()));
        int i4 = 0;
        while (i4 < i2) {
            int min = Math.min(i2 - i4, i3);
            stringBuilder.append(encode(bArr, i + i4, min));
            stringBuilder.append(str);
            i4 += min;
        }
        return stringBuilder.toString();
    }

    public static char[] encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public static char[] encode(byte[] bArr, int i) {
        return encode(bArr, 0, i);
    }

    public static char[] encode(byte[] bArr, int i, int i2) {
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
            cArr[i4] = map1[i8];
            i4 = i9 + 1;
            cArr[i9] = map1[i];
            i = 61;
            cArr[i4] = i4 < i3 ? map1[i7] : '=';
            i4++;
            if (i4 < i3) {
                i = map1[i5];
            }
            cArr[i4] = i;
            i4++;
            i = i6;
        }
        return cArr;
    }

    public static String decodeString(String str) {
        return new String(decode(str));
    }

    public static byte[] decodeLines(String str) {
        char[] cArr = new char[str.length()];
        int i = 0;
        int i2 = i;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (!(charAt == ' ' || charAt == '\r' || charAt == '\n' || charAt == '\t')) {
                int i3 = i2 + 1;
                cArr[i2] = charAt;
                i2 = i3;
            }
            i++;
        }
        return decode(cArr, 0, i2);
    }

    public static byte[] decode(String str) {
        return decode(str.toCharArray());
    }

    public static byte[] decode(char[] cArr) {
        return decode(cArr, 0, cArr.length);
    }

    public static byte[] decode(char[] cArr, int i, int i2) {
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
            i = cArr[i];
            int i7 = i6 + 1;
            char c = cArr[i6];
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
                char c2 = cArr[i5];
                i5 = i8;
                i8 = c2;
            }
            if (i <= Opcodes.NEG_FLOAT && c <= '' && i7 <= Opcodes.NEG_FLOAT) {
                if (i8 <= Opcodes.NEG_FLOAT) {
                    i = map2[i];
                    byte b = map2[c];
                    byte b2 = map2[i7];
                    byte b3 = map2[i8];
                    if (i >= 0 && b >= (byte) 0 && b2 >= (byte) 0) {
                        if (b3 >= (byte) 0) {
                            i = (i << 2) | (b >>> 4);
                            i6 = ((b & 15) << 4) | (b2 >>> 2);
                            i7 = ((b2 & 3) << 6) | b3;
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

    private Base64Coder() {
    }
}
