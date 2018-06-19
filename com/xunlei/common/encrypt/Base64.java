package com.xunlei.common.encrypt;

import java.io.UnsupportedEncodingException;

public class Base64 {
    private static byte[] base64DecodeChars = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 62, (byte) -1, (byte) -1, (byte) -1, (byte) 63, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 61, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 0, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 14, (byte) 15, (byte) 16, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 37, (byte) 38, (byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) -1, (byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private static char[] base64EncodeChars = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int length = bArr.length;
        while (i < length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(base64EncodeChars[i >>> 2]);
                stringBuffer.append(base64EncodeChars[(i & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i3 = i2 + 1;
            i2 = bArr[i2] & 255;
            if (i3 == length) {
                stringBuffer.append(base64EncodeChars[i >>> 2]);
                stringBuffer.append(base64EncodeChars[((i & 3) << 4) | ((i2 & 240) >>> 4)]);
                stringBuffer.append(base64EncodeChars[(i2 & 15) << 2]);
                stringBuffer.append("=");
                break;
            }
            int i4 = i3 + 1;
            i3 = bArr[i3] & 255;
            stringBuffer.append(base64EncodeChars[i >>> 2]);
            stringBuffer.append(base64EncodeChars[((i & 3) << 4) | ((i2 & 240) >>> 4)]);
            stringBuffer.append(base64EncodeChars[((i2 & 15) << 2) | ((i3 & 192) >>> 6)]);
            stringBuffer.append(base64EncodeChars[i3 & 63]);
            i = i4;
        }
        return stringBuffer.toString();
    }

    public static byte[] decode(String str) {
        try {
            return decodePrivate(str);
        } catch (String str2) {
            str2.printStackTrace();
            return new byte[null];
        }
    }

    private static byte[] decodePrivate(String str) throws UnsupportedEncodingException {
        StringBuffer stringBuffer = new StringBuffer();
        str = str.getBytes("US-ASCII");
        int i = 0;
        int length = str.length;
        while (i < length) {
            while (true) {
                int i2 = i + 1;
                byte b = base64DecodeChars[str[i]];
                if (i2 >= length) {
                    break;
                } else if (b != (byte) -1) {
                    break;
                } else {
                    i = i2;
                }
            }
            if (b == (byte) -1) {
                break;
            }
            while (true) {
                int i3 = i2 + 1;
                byte b2 = base64DecodeChars[str[i2]];
                if (i3 >= length) {
                    break;
                } else if (b2 != (byte) -1) {
                    break;
                } else {
                    i2 = i3;
                }
            }
            if (b2 == (byte) -1) {
                break;
            }
            stringBuffer.append((char) ((b << 2) | ((b2 & 48) >>> 4)));
            while (true) {
                i = i3 + 1;
                byte b3 = str[i3];
                if (b3 == (byte) 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b3 = base64DecodeChars[b3];
                if (i >= length) {
                    break;
                } else if (b3 != (byte) -1) {
                    break;
                } else {
                    i3 = i;
                }
            }
            if (b3 == (byte) -1) {
                break;
            }
            stringBuffer.append((char) (((b2 & 15) << 4) | ((b3 & 60) >>> 2)));
            while (true) {
                i2 = i + 1;
                b = str[i];
                if (b == (byte) 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b = base64DecodeChars[b];
                if (i2 >= length) {
                    break;
                } else if (b != (byte) -1) {
                    break;
                } else {
                    i = i2;
                }
            }
            if (b == (byte) -1) {
                break;
            }
            stringBuffer.append((char) (b | ((b3 & 3) << 6)));
            i = i2;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
