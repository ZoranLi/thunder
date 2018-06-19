package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.data.ByteArrayFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {
    private final String id;

    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {
        public void teardown() {
        }

        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }
    }

    public StreamByteArrayLoader() {
        this("");
    }

    @Deprecated
    public StreamByteArrayLoader(String str) {
        this.id = str;
    }

    public DataFetcher<InputStream> getResourceFetcher(byte[] bArr, int i, int i2) {
        return new ByteArrayFetcher(bArr, this.id);
    }
}
