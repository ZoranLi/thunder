package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;

public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public void recycle() {
    }

    public BytesResource(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Bytes must not be null");
        }
        this.bytes = bArr;
    }

    public byte[] get() {
        return this.bytes;
    }

    public int getSize() {
        return this.bytes.length;
    }
}
