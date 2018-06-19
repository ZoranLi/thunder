package com.xunlei.downloadprovider.download.util.a.a;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

/* compiled from: ApkIconModelLoader */
public class b implements StreamModelLoader<String> {
    private static b a;

    public /* synthetic */ DataFetcher getResourceFetcher(Object obj, int i, int i2) {
        return new a((String) obj);
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }
}
