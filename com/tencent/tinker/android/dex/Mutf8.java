package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;
import java.io.UTFDataFormatException;

/* compiled from: BUGLY */
public final class Mutf8 {
    private Mutf8() {
    }

    public static String decode(ByteInput byteInput, char[] cArr) throws UTFDataFormatException {
        int i = 0;
        while (true) {
            char readByte = (char) (byteInput.readByte() & 255);
            if (readByte == '\u0000') {
                return new String(cArr, 0, i);
            }
            cArr[i] = readByte;
            if (readByte < '') {
                i++;
            } else {
                int i2;
                int readByte2;
                if ((readByte & 224) == 192) {
                    readByte2 = byteInput.readByte() & 255;
                    if ((readByte2 & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    i2 = i + 1;
                    cArr[i] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                } else if ((readByte & 240) == 224) {
                    readByte2 = byteInput.readByte() & 255;
                    int readByte3 = byteInput.readByte() & 255;
                    if ((readByte2 & 192) != 128) {
                        break;
                    } else if ((readByte3 & 192) != 128) {
                        break;
                    } else {
                        i2 = i + 1;
                        cArr[i] = (char) ((((readByte & 15) << 12) | ((readByte2 & 63) << 6)) | (readByte3 & 63));
                    }
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
                i = i2;
            }
        }
        throw new UTFDataFormatException("bad second or third byte");
    }

    public static long countBytes(String str, boolean z) throws UTFDataFormatException {
        int length = str.length();
        long j = 0;
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            long j2 = (charAt == '\u0000' || charAt > '') ? charAt <= '߿' ? j + 2 : j + 3 : j + 1;
            j = j2;
            if (!z || j <= 65535) {
                i++;
            } else {
                throw new UTFDataFormatException("String more than 65535 UTF bytes long");
            }
        }
        return j;
    }

    public static void encode(byte[] bArr, int i, String str) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            int i3;
            char charAt = str.charAt(i2);
            if (charAt != '\u0000' && charAt <= '') {
                i3 = i + 1;
                bArr[i] = (byte) charAt;
            } else if (charAt <= '߿') {
                i3 = i + 1;
                bArr[i] = (byte) (192 | (31 & (charAt >> 6)));
                i = i3 + 1;
                bArr[i3] = (byte) ((charAt & 63) | 128);
            } else {
                i3 = i + 1;
                bArr[i] = (byte) (224 | (15 & (charAt >> 12)));
                i = i3 + 1;
                bArr[i3] = (byte) (((charAt >> 6) & 63) | 128);
                i3 = i + 1;
                bArr[i] = (byte) ((charAt & 63) | 128);
            }
            i = i3;
        }
    }

    public static byte[] encode(String str) throws UTFDataFormatException {
        byte[] bArr = new byte[((int) countBytes(str, true))];
        encode(bArr, 0, str);
        return bArr;
    }
}
