package com.tencent.tinker.android.dex;

import com.tencent.tinker.android.dex.util.ByteInput;
import com.tencent.tinker.android.dex.util.ByteOutput;
import com.tencent.tinker.android.dx.instruction.Opcodes;

/* compiled from: BUGLY */
public final class Leb128 {
    public static int signedLeb128Size(int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = i;
        int i5 = 0;
        i = 1;
        while (i != 0) {
            if (i2 == i3) {
                if ((i2 & 1) == ((i4 >> 6) & 1)) {
                    i = 0;
                    i5++;
                    i4 = i2;
                    i2 >>= 7;
                }
            }
            i = 1;
            i5++;
            i4 = i2;
            i2 >>= 7;
        }
        return i5;
    }

    public static int unsignedLeb128Size(int i) {
        i >>>= 7;
        int i2 = 0;
        while (i != 0) {
            i >>>= 7;
            i2++;
        }
        return i2 + 1;
    }

    private Leb128() {
    }

    public static int unsignedLeb128p1Size(int i) {
        return unsignedLeb128Size(i + 1);
    }

    public static int readSignedLeb128(ByteInput byteInput) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        do {
            int readByte = byteInput.readByte() & 255;
            i |= (readByte & Opcodes.NEG_FLOAT) << (i3 * 7);
            i2 <<= 7;
            i3++;
            readByte &= 128;
            if (readByte != 128) {
                break;
            }
        } while (i3 < 5);
        if (readByte != 128) {
            return ((i2 >> 1) & i) != null ? i | i2 : i;
        } else {
            throw new DexException("invalid LEB128 sequence");
        }
    }

    public static int readUnsignedLeb128(ByteInput byteInput) {
        int i = 0;
        int i2 = 0;
        do {
            int readByte = byteInput.readByte() & 255;
            i |= (readByte & Opcodes.NEG_FLOAT) << (i2 * 7);
            i2++;
            readByte &= 128;
            if (readByte != 128) {
                break;
            }
        } while (i2 < 5);
        if (readByte != 128) {
            return i;
        }
        throw new DexException("invalid LEB128 sequence");
    }

    public static int readUnsignedLeb128p1(ByteInput byteInput) {
        return readUnsignedLeb128(byteInput) - 1;
    }

    public static int writeUnsignedLeb128(ByteOutput byteOutput, int i) {
        int i2 = i >>> 7;
        int i3 = 0;
        while (true) {
            int i4 = i2;
            i2 = i;
            i = i4;
            if (i != 0) {
                byteOutput.writeByte((byte) ((i2 & Opcodes.NEG_FLOAT) | 128));
                i3++;
                i2 = i >>> 7;
            } else {
                byteOutput.writeByte((byte) (i2 & Opcodes.NEG_FLOAT));
                return i3 + 1;
            }
        }
    }

    public static int writeUnsignedLeb128p1(ByteOutput byteOutput, int i) {
        return writeUnsignedLeb128(byteOutput, i + 1);
    }

    public static int writeSignedLeb128(ByteOutput byteOutput, int i) {
        int i2 = i >> 7;
        int i3 = (Integer.MIN_VALUE & i) == 0 ? 0 : -1;
        int i4 = i;
        int i5 = 0;
        i = 1;
        while (i != 0) {
            if (i2 == i3) {
                if ((i2 & 1) == ((i4 >> 6) & 1)) {
                    i = 0;
                    byteOutput.writeByte((byte) ((i4 & Opcodes.NEG_FLOAT) | (i == 0 ? 128 : 0)));
                    i5++;
                    i4 = i2;
                    i2 >>= 7;
                }
            }
            i = 1;
            if (i == 0) {
            }
            byteOutput.writeByte((byte) ((i4 & Opcodes.NEG_FLOAT) | (i == 0 ? 128 : 0)));
            i5++;
            i4 = i2;
            i2 >>= 7;
        }
        return i5;
    }
}
