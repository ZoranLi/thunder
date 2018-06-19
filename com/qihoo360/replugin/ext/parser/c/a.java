package com.qihoo360.replugin.ext.parser.c;

import java.nio.ByteBuffer;

/* compiled from: Buffers */
public final class a {
    public static short a(ByteBuffer byteBuffer) {
        return (short) (byteBuffer.get() & 255);
    }

    public static long b(ByteBuffer byteBuffer) {
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    public static String a(ByteBuffer byteBuffer, int i) {
        StringBuilder stringBuilder = new StringBuilder(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(byteBuffer.getChar());
        }
        return stringBuilder.toString();
    }
}
