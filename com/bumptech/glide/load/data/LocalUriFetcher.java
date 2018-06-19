package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.Priority;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final Context context;
    private T data;
    private final Uri uri;

    public void cancel() {
    }

    protected abstract void close(T t) throws IOException;

    public abstract T loadResource(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    public LocalUriFetcher(Context context, Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }

    public final T loadData(Priority priority) throws Exception {
        this.data = loadResource(this.uri, this.context.getContentResolver());
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
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r0 = r1.data;	 Catch:{ IOException -> 0x000a }
        r1.close(r0);	 Catch:{ IOException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.LocalUriFetcher.cleanup():void");
    }

    public String getId() {
        return this.uri.toString();
    }
}
