package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayFetcher implements DataFetcher<InputStream> {
    private final byte[] bytes;
    private final String id;

    public void cancel() {
    }

    public void cleanup() {
    }

    public ByteArrayFetcher(byte[] bArr, String str) {
        this.bytes = bArr;
        this.id = str;
    }

    public InputStream loadData(Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }

    public String getId() {
        return this.id;
    }
}
