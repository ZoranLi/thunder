package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import com.bumptech.glide.Priority;
import java.io.IOException;

public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetUriFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public void cancel() {
    }

    protected abstract void close(T t) throws IOException;

    protected abstract T loadResource(AssetManager assetManager, String str) throws IOException;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    public T loadData(Priority priority) throws Exception {
        this.data = loadResource(this.assetManager, this.assetPath);
        return this.data;
    }

    public void cleanup() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.data;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r1.data;	 Catch:{ IOException -> 0x000b }
        r1.close(r0);	 Catch:{ IOException -> 0x000b }
        return;
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.AssetPathFetcher.cleanup():void");
    }

    public String getId() {
        return this.assetPath;
    }
}
