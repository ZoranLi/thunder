package com.xunlei.downloadprovider.download.util.a.a;

import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.stream.StreamModelLoader;

/* compiled from: TaskSnapshotModelLoader */
public class f implements StreamModelLoader<e> {
    private static f a;

    public /* synthetic */ DataFetcher getResourceFetcher(Object obj, int i, int i2) {
        e eVar = (e) obj;
        return new d(eVar.c, i, i2, eVar);
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }
}
