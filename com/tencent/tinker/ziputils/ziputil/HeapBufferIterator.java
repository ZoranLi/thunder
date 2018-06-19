package com.tencent.tinker.ziputils.ziputil;

import java.nio.ByteOrder;

/* compiled from: BUGLY */
public final class HeapBufferIterator extends BufferIterator {
    private final byte[] buffer;
    private final int byteCount;
    private final int offset;
    private final ByteOrder order;
    private int position;

    HeapBufferIterator(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        this.buffer = bArr;
        this.offset = i;
        this.byteCount = i2;
        this.order = byteOrder;
    }

    public static BufferIterator iterator(byte[] bArr, int i, int i2, ByteOrder byteOrder) {
        return new HeapBufferIterator(bArr, i, i2, byteOrder);
    }

    public final void seek(int i) {
        this.position = i;
    }

    public final void skip(int i) {
        this.position += i;
    }

    public final void readByteArray(byte[] bArr, int i, int i2) {
        System.arraycopy(this.buffer, this.offset + this.position, bArr, i, i2);
        this.position += i2;
    }

    public final byte readByte() {
        byte b = this.buffer[this.offset + this.position];
        this.position++;
        return b;
    }

    public final int readInt() {
        int peekInt = Memory.peekInt(this.buffer, this.offset + this.position, this.order);
        this.position += 4;
        return peekInt;
    }

    public final short readShort() {
        short peekShort = Memory.peekShort(this.buffer, this.offset + this.position, this.order);
        this.position += 2;
        return peekShort;
    }
}
