package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;

/* compiled from: BUGLY */
public final class EncodedValueCodec {
    private EncodedValueCodec() {
    }

    public static void writeSignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = ((65 - Long.numberOfLeadingZeros(j ^ (j >> 63))) + 7) >> 3;
        byteOutput.writeByte(i | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            byteOutput.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void writeUnsignedIntegralValue(ByteOutput byteOutput, int i, long j) {
        int numberOfLeadingZeros = 64 - Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros == 0) {
            numberOfLeadingZeros = 1;
        }
        numberOfLeadingZeros = (numberOfLeadingZeros + 7) >> 3;
        byteOutput.writeByte(i | ((numberOfLeadingZeros - 1) << 5));
        while (numberOfLeadingZeros > 0) {
            byteOutput.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfLeadingZeros--;
        }
    }

    public static void writeRightZeroExtendedValue(ByteOutput byteOutput, int i, long j) {
        int numberOfTrailingZeros = 64 - Long.numberOfTrailingZeros(j);
        if (numberOfTrailingZeros == 0) {
            numberOfTrailingZeros = 1;
        }
        numberOfTrailingZeros = (numberOfTrailingZeros + 7) >> 3;
        j >>= 64 - (numberOfTrailingZeros * 8);
        byteOutput.writeByte(i | ((numberOfTrailingZeros - 1) << 5));
        while (numberOfTrailingZeros > 0) {
            byteOutput.writeByte((byte) ((int) j));
            j >>= 8;
            numberOfTrailingZeros--;
        }
    }

    public static int readSignedInt(ByteInput byteInput, int i) {
        int i2 = 0;
        for (int i3 = i; i3 >= 0; i3--) {
            i2 = (i2 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i2 >> ((3 - i) * 8);
    }

    public static int readUnsignedInt(ByteInput byteInput, int i, boolean z) {
        int i2 = 0;
        if (z) {
            while (i >= 0) {
                i2 = ((byteInput.readByte() & 255) << 24) | (i2 >>> 8);
                i--;
            }
            return i2;
        }
        for (z = i; z < false; z--) {
            i2 = (i2 >>> 8) | ((byteInput.readByte() & 255) << 24);
        }
        return i2 >>> ((3 - i) * 8);
    }

    public static long readSignedLong(ByteInput byteInput, int i) {
        long j = 0;
        int i2 = i;
        while (i2 >= 0) {
            i2--;
            j = (j >>> 8) | ((((long) byteInput.readByte()) & 255) << 56);
        }
        return j >> ((7 - i) * 8);
    }

    public static long readUnsignedLong(ByteInput byteInput, int i, boolean z) {
        long j = 0;
        if (z) {
            while (i >= 0) {
                i--;
                j = (j >>> 8) | ((((long) byteInput.readByte()) & 255) << 56);
            }
            return j;
        }
        z = i;
        while (z < false) {
            z--;
            j = (j >>> 8) | ((((long) byteInput.readByte()) & 255) << 56);
        }
        return j >>> ((7 - i) * 8);
    }
}
