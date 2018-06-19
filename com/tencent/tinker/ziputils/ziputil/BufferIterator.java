package com.tencent.tinker.ziputils.ziputil;

/* compiled from: BUGLY */
public abstract class BufferIterator {
    public abstract int readInt();

    public abstract short readShort();

    public abstract void seek(int i);

    public abstract void skip(int i);
}
