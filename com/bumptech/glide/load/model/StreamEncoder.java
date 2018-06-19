package com.bumptech.glide.load.model;

import com.bumptech.glide.load.Encoder;
import java.io.InputStream;

public class StreamEncoder implements Encoder<InputStream> {
    private static final String TAG = "StreamEncoder";

    public String getId() {
        return "";
    }

    public boolean encode(java.io.InputStream r5, java.io.OutputStream r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.bumptech.glide.util.ByteArrayPool.get();
        r0 = r0.getBytes();
    L_0x0008:
        r1 = 0;
        r2 = r5.read(r0);	 Catch:{ IOException -> 0x0026, all -> 0x001d }
        r3 = -1;	 Catch:{ IOException -> 0x0026, all -> 0x001d }
        if (r2 == r3) goto L_0x0014;	 Catch:{ IOException -> 0x0026, all -> 0x001d }
    L_0x0010:
        r6.write(r0, r1, r2);	 Catch:{ IOException -> 0x0026, all -> 0x001d }
        goto L_0x0008;
    L_0x0014:
        r5 = com.bumptech.glide.util.ByteArrayPool.get();
        r5.releaseBytes(r0);
        r5 = 1;
        return r5;
    L_0x001d:
        r5 = move-exception;
        r6 = com.bumptech.glide.util.ByteArrayPool.get();
        r6.releaseBytes(r0);
        throw r5;
    L_0x0026:
        r5 = com.bumptech.glide.util.ByteArrayPool.get();
        r5.releaseBytes(r0);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.StreamEncoder.encode(java.io.InputStream, java.io.OutputStream):boolean");
    }
}
