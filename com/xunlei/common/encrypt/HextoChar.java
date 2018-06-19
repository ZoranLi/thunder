package com.xunlei.common.encrypt;

public class HextoChar {
    static final byte[] HEX_DATA_MAP = new byte[]{(byte) 48, (byte) 49, (byte) 50, (byte) 51, (byte) 52, (byte) 53, (byte) 54, (byte) 55, (byte) 56, (byte) 57, (byte) 65, (byte) 66, (byte) 67, (byte) 68, (byte) 69, (byte) 70};

    public static int hex_char_value(byte b) {
        return (b < (byte) 48 || b > (byte) 57) ? (b < (byte) 65 || b > (byte) 90) ? (b < (byte) 97 || b > (byte) 122) ? -1 : (b - 97) + 10 : (b - 65) + 10 : b - 48;
    }

    public static byte[] byte_to_hex(byte b) {
        byte[] bArr = new byte[2];
        int i = (b & 240) >> 4;
        b &= 15;
        try {
            bArr[0] = HEX_DATA_MAP[i];
            bArr[1] = HEX_DATA_MAP[b];
        } catch (byte b2) {
            b2.printStackTrace();
        }
        return bArr;
    }

    public static byte[] bytes_to_hex(byte[] bArr, int i) {
        if (bArr != null) {
            if (i > 0) {
                byte[] bArr2 = new byte[(i << 1)];
                int i2 = 0;
                while (i2 < i) {
                    try {
                        byte[] byte_to_hex = byte_to_hex(bArr[i2]);
                        int i3 = 2 * i2;
                        bArr2[i3] = byte_to_hex[0];
                        bArr2[i3 + 1] = byte_to_hex[1];
                        i2++;
                    } catch (byte[] bArr3) {
                        bArr3.printStackTrace();
                    }
                }
                return bArr2;
            }
        }
        return null;
    }

    public static byte[] hex_to_bytes(byte[] bArr, int i) {
        if (i % 2 != 0) {
            return null;
        }
        i /= 2;
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = i2 << 1;
            try {
                int hex_char_value = hex_char_value(bArr[i3]);
                if (hex_char_value < 0) {
                    return null;
                }
                i3 = hex_char_value(bArr[i3 + 1]);
                if (i3 < 0) {
                    return null;
                }
                bArr2[i2] = (byte) (i3 | (hex_char_value << 4));
                i2++;
            } catch (byte[] bArr3) {
                bArr3.printStackTrace();
            }
        }
        return bArr2;
    }

    public static String parseByte2HexStr(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                StringBuilder stringBuilder = new StringBuilder("0");
                stringBuilder.append(toHexString);
                toHexString = stringBuilder.toString();
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] parseHexStr2Byte(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            int i2 = i << 1;
            int i3 = i2 + 1;
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i2, i3), 16) << 4) + Integer.parseInt(str.substring(i3, i2 + 2), 16));
        }
        return bArr;
    }
}
