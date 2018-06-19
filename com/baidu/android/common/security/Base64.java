package com.baidu.android.common.security;

import java.io.UnsupportedEncodingException;

public final class Base64 {
    private static final byte[] MAP = new byte[]{(byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70, (byte) 71, (byte) 72, (byte) 73, (byte) 74, (byte) 75, (byte) 76, (byte) 77, (byte) 78, (byte) 79, (byte) 80, (byte) 81, (byte) 82, (byte) 83, (byte) 84, (byte) 85, (byte) 86, (byte) 87, (byte) 88, (byte) 89, (byte) 90, (byte) 97, (byte) 98, (byte) 99, (byte) 100, (byte) 101, (byte) 102, (byte) 103, (byte) 104, (byte) 105, (byte) 106, (byte) 107, (byte) 108, (byte) 109, (byte) 110, (byte) 111, (byte) 112, (byte) 113, (byte) 114, (byte) 115, (byte) 116, (byte) 117, (byte) 118, (byte) 119, (byte) 120, (byte) 121, (byte) 122, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 43, (byte) 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static byte[] decode(byte[] bArr, int i) {
        int i2 = (i / 4) * 3;
        if (i2 == 0) {
            return new byte[0];
        }
        Object obj = new byte[i2];
        int i3 = i;
        int i4 = 0;
        while (true) {
            byte b = bArr[i3 - 1];
            byte b2 = (byte) 10;
            if (!(b == (byte) 10 || b == (byte) 13 || b == (byte) 32 || b == (byte) 9)) {
                if (b != (byte) 61) {
                    break;
                }
                i4++;
            }
            i3--;
        }
        int i5 = 0;
        int i6 = i5;
        int i7 = i6;
        int i8 = i7;
        while (i5 < i3) {
            byte b3 = bArr[i5];
            if (!(b3 == b2 || b3 == (byte) 13 || b3 == (byte) 32 || b3 == (byte) 9)) {
                int i9;
                if (b3 >= (byte) 65 && b3 <= (byte) 90) {
                    i9 = b3 - 65;
                } else if (b3 >= (byte) 97 && b3 <= (byte) 122) {
                    i9 = b3 - 71;
                } else if (b3 >= (byte) 48 && b3 <= (byte) 57) {
                    i9 = b3 + 4;
                } else if (b3 == (byte) 43) {
                    i9 = 62;
                } else if (b3 != (byte) 47) {
                    return null;
                } else {
                    i9 = 63;
                }
                i9 = ((byte) i9) | (i6 << 6);
                if (i8 % 4 == 3) {
                    int i10 = i7 + 1;
                    obj[i7] = (byte) ((i9 & 16711680) >> 16);
                    i6 = i10 + 1;
                    obj[i10] = (byte) ((i9 & 65280) >> 8);
                    i7 = i6 + 1;
                    obj[i6] = (byte) (i9 & 255);
                }
                i8++;
                i6 = i9;
            }
            i5++;
            b2 = (byte) 10;
        }
        if (i4 > 0) {
            int i11 = i6 << (6 * i4);
            i3 = i7 + 1;
            obj[i7] = (byte) ((i11 & 16711680) >> 16);
            if (i4 == 1) {
                i7 = i3 + 1;
                obj[i3] = (byte) ((i11 & 65280) >> 8);
            } else {
                i7 = i3;
            }
        }
        Object obj2 = new byte[i7];
        System.arraycopy(obj, 0, obj2, 0, i7);
        return obj2;
    }

    public static String encode(byte[] bArr, String str) throws UnsupportedEncodingException {
        int length = (bArr.length * 4) / 3;
        byte[] bArr2 = new byte[(length + ((length / 76) + 3))];
        int length2 = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length2) {
            int i4 = i2 + 1;
            bArr2[i2] = MAP[(bArr[i] & 255) >> 2];
            i2 = i4 + 1;
            int i5 = i + 1;
            bArr2[i4] = MAP[((bArr[i] & 3) << 4) | ((bArr[i5] & 255) >> 4)];
            i4 = i2 + 1;
            i5 = i + 2;
            bArr2[i2] = MAP[((bArr[i5] & 15) << 2) | ((bArr[i5] & 255) >> 6)];
            i2 = i4 + 1;
            bArr2[i4] = MAP[bArr[i5] & 63];
            if ((i2 - i3) % 76 == 0 && i2 != 0) {
                i4 = i2 + 1;
                bArr2[i2] = (byte) 10;
                i3++;
                i2 = i4;
            }
            i += 3;
        }
        switch (bArr.length % 3) {
            case 1:
                i3 = i2 + 1;
                bArr2[i2] = MAP[(bArr[length2] & 255) >> 2];
                i2 = i3 + 1;
                bArr2[i3] = MAP[(bArr[length2] & 3) << 4];
                int i6 = i2 + 1;
                bArr2[i2] = (byte) 61;
                i2 = i6 + 1;
                bArr2[i6] = (byte) 61;
                break;
            case 2:
                i3 = i2 + 1;
                bArr2[i2] = MAP[(bArr[length2] & 255) >> 2];
                i2 = i3 + 1;
                length2++;
                bArr2[i3] = MAP[((bArr[length2] & 3) << 4) | ((bArr[length2] & 255) >> 4)];
                i3 = i2 + 1;
                bArr2[i2] = MAP[(bArr[length2] & 15) << 2];
                i2 = i3 + 1;
                bArr2[i3] = (byte) 61;
                break;
            default:
                break;
        }
        return new String(bArr2, 0, i2, str);
    }
}
