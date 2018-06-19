package com.tencent.tinker.ziputils.ziputil;

import java.nio.ByteOrder;

/* compiled from: BUGLY */
public final class Memory {
    private Memory() {
    }

    public static int peekInt(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteOrder = i + 1;
            int i2 = byteOrder + 1;
            i = ((bArr[i] & 255) << 24) | ((bArr[byteOrder] & 255) << 16);
            return ((bArr[i2 + 1] & 255) << 0) | (i | ((bArr[i2] & 255) << 8));
        }
        byteOrder = i + 1;
        i2 = byteOrder + 1;
        i = ((bArr[i] & 255) << 0) | ((bArr[byteOrder] & 255) << 8);
        return ((bArr[i2 + 1] & 255) << 24) | (i | ((bArr[i2] & 255) << 16));
    }

    public static long peekLong(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteOrder = i + 1;
            int i2 = byteOrder + 1;
            i = ((bArr[i] & 255) << 24) | ((bArr[byteOrder] & 255) << 16);
            byteOrder = i2 + 1;
            i |= (bArr[i2] & 255) << 8;
            i2 = byteOrder + 1;
            i |= (bArr[byteOrder] & 255) << 0;
            byteOrder = i2 + 1;
            int i3 = byteOrder + 1;
            byteOrder = ((bArr[byteOrder] & 255) << 16) | ((bArr[i2] & 255) << 24);
            return (((long) i) << 32) | (((long) (((bArr[i3 + 1] & 255) << 0) | (byteOrder | ((bArr[i3] & 255) << 8)))) & 4294967295L);
        }
        byteOrder = i + 1;
        i2 = byteOrder + 1;
        i = ((bArr[i] & 255) << 0) | ((bArr[byteOrder] & 255) << 8);
        byteOrder = i2 + 1;
        i |= (bArr[i2] & 255) << 16;
        i2 = byteOrder + 1;
        i |= (bArr[byteOrder] & 255) << 24;
        byteOrder = i2 + 1;
        i3 = byteOrder + 1;
        byteOrder = ((bArr[byteOrder] & 255) << 8) | ((bArr[i2] & 255) << 0);
        return (((long) (((bArr[i3 + 1] & 255) << 24) | (byteOrder | ((bArr[i3] & 255) << 16)))) << 32) | (((long) i) & 4294967295L);
    }

    public static short peekShort(byte[] bArr, int i, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((bArr[i + 1] & 255) | (bArr[i] << 8));
        }
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }

    public static void pokeInt(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteOrder = i + 1;
            bArr[i] = (byte) ((i2 >> 24) & 255);
            i = byteOrder + 1;
            bArr[byteOrder] = (byte) ((i2 >> 16) & 255);
            byteOrder = i + 1;
            bArr[i] = (byte) ((i2 >> 8) & 255);
            bArr[byteOrder] = (byte) ((i2 >> 0) & 255);
            return;
        }
        byteOrder = i + 1;
        bArr[i] = (byte) ((i2 >> 0) & 255);
        i = byteOrder + 1;
        bArr[byteOrder] = (byte) ((i2 >> 8) & 255);
        byteOrder = i + 1;
        bArr[i] = (byte) ((i2 >> 16) & 255);
        bArr[byteOrder] = (byte) ((i2 >> 24) & 255);
    }

    public static void pokeLong(byte[] bArr, int i, long j, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteOrder = (int) (j >> 32);
            int i2 = i + 1;
            bArr[i] = (byte) ((byteOrder >> 24) & 255);
            i = i2 + 1;
            bArr[i2] = (byte) ((byteOrder >> 16) & 255);
            i2 = i + 1;
            bArr[i] = (byte) ((byteOrder >> 8) & 255);
            i = i2 + 1;
            bArr[i2] = (byte) ((byteOrder >> 0) & 255);
            j = (int) j;
            int i3 = i + 1;
            bArr[i] = (byte) ((j >> 24) & 255);
            i = i3 + 1;
            bArr[i3] = (byte) ((j >> 16) & 255);
            i3 = i + 1;
            bArr[i] = (byte) ((j >> 8) & 255);
            bArr[i3] = (byte) ((j >> 0) & 255);
            return;
        }
        byteOrder = (int) j;
        i2 = i + 1;
        bArr[i] = (byte) ((byteOrder >> 0) & 255);
        i = i2 + 1;
        bArr[i2] = (byte) ((byteOrder >> 8) & 255);
        i2 = i + 1;
        bArr[i] = (byte) ((byteOrder >> 16) & 255);
        i = i2 + 1;
        bArr[i2] = (byte) ((byteOrder >> 24) & 255);
        j = (int) (j >> 32);
        i3 = i + 1;
        bArr[i] = (byte) ((j >> 0) & 255);
        i = i3 + 1;
        bArr[i3] = (byte) ((j >> 8) & 255);
        i3 = i + 1;
        bArr[i] = (byte) ((j >> 16) & 255);
        bArr[i3] = (byte) ((j >> 24) & 255);
    }

    public static void pokeShort(byte[] bArr, int i, short s, ByteOrder byteOrder) {
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            byteOrder = i + 1;
            bArr[i] = (byte) ((s >> 8) & 255);
            bArr[byteOrder] = (byte) ((s >> 0) & 255);
            return;
        }
        byteOrder = i + 1;
        bArr[i] = (byte) ((s >> 0) & 255);
        bArr[byteOrder] = (byte) ((s >> 8) & 255);
    }
}
