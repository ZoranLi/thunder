package com.tencent.tinker.android.dx.util;

/* compiled from: BUGLY */
public final class Hex {
    private Hex() {
    }

    public static String u8(long j) {
        char[] cArr = new char[16];
        for (int i = 0; i < 16; i++) {
            cArr[15 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
        }
        return new String(cArr);
    }

    public static String u4(int i) {
        char[] cArr = new char[8];
        for (int i2 = 0; i2 < 8; i2++) {
            cArr[7 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u3(int i) {
        char[] cArr = new char[6];
        for (int i2 = 0; i2 < 6; i2++) {
            cArr[5 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u2(int i) {
        char[] cArr = new char[4];
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[3 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String u2or4(int i) {
        if (i == ((char) i)) {
            return u2(i);
        }
        return u4(i);
    }

    public static String u1(int i) {
        char[] cArr = new char[2];
        for (int i2 = 0; i2 < 2; i2++) {
            cArr[1 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
        }
        return new String(cArr);
    }

    public static String uNibble(int i) {
        return new String(new char[]{Character.forDigit(i & 15, 16)});
    }

    public static String s8(long j) {
        char[] cArr = new char[17];
        int i = 0;
        if (j < 0) {
            cArr[0] = '-';
            j = -j;
        } else {
            cArr[0] = '+';
        }
        while (i < 16) {
            cArr[16 - i] = Character.forDigit(((int) j) & 15, 16);
            j >>= 4;
            i++;
        }
        return new String(cArr);
    }

    public static String s4(int i) {
        char[] cArr = new char[9];
        int i2 = 0;
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        while (i2 < 8) {
            cArr[8 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
            i2++;
        }
        return new String(cArr);
    }

    public static String s2(int i) {
        char[] cArr = new char[5];
        int i2 = 0;
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        while (i2 < 4) {
            cArr[4 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
            i2++;
        }
        return new String(cArr);
    }

    public static String s1(int i) {
        char[] cArr = new char[3];
        int i2 = 0;
        if (i < 0) {
            cArr[0] = '-';
            i = -i;
        } else {
            cArr[0] = '+';
        }
        while (i2 < 2) {
            cArr[2 - i2] = Character.forDigit(i & 15, 16);
            i >>= 4;
            i2++;
        }
        return new String(cArr);
    }

    public static String dump(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = i + i2;
        if (((i | i2) | i6) >= 0) {
            if (i6 <= bArr.length) {
                if (i3 < 0) {
                    throw new IllegalArgumentException("outOffset < 0");
                } else if (i2 == 0) {
                    return "";
                } else {
                    StringBuffer stringBuffer = new StringBuffer((i2 * 4) + 6);
                    int i7 = i;
                    i = 0;
                    while (i2 > 0) {
                        if (i == 0) {
                            String u1;
                            if (i5 == 2) {
                                u1 = u1(i3);
                            } else if (i5 == 4) {
                                u1 = u2(i3);
                            } else if (i5 != 6) {
                                u1 = u4(i3);
                            } else {
                                u1 = u3(i3);
                            }
                            stringBuffer.append(u1);
                            stringBuffer.append(": ");
                        } else if ((i & 1) == 0) {
                            stringBuffer.append(' ');
                        }
                        stringBuffer.append(u1(bArr[i7]));
                        i3++;
                        i7++;
                        i++;
                        if (i == i4) {
                            stringBuffer.append('\n');
                            i = 0;
                        }
                        i2--;
                    }
                    if (i != 0) {
                        stringBuffer.append('\n');
                    }
                    return stringBuffer.toString();
                }
            }
        }
        i3 = new StringBuilder("arr.length ");
        i3.append(bArr.length);
        i3.append("; ");
        i3.append(i);
        i3.append("..!");
        i3.append(i6);
        throw new IndexOutOfBoundsException(i3.toString());
    }

    public static String toHexString(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length << 1);
        for (byte u1 : bArr) {
            stringBuilder.append(u1(u1));
        }
        return stringBuilder.toString();
    }
}
