package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.cache.DiskCache;

class CacheLoader {
    private static final String TAG = "CacheLoader";
    private final DiskCache diskCache;

    public CacheLoader(DiskCache diskCache) {
        this.diskCache = diskCache;
    }

    public <Z> com.bumptech.glide.load.engine.Resource<Z> load(com.bumptech.glide.load.Key r3, com.bumptech.glide.load.ResourceDecoder<java.io.File, Z> r4, int r5, int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.diskCache;
        r0 = r0.get(r3);
        r1 = 0;
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r4 = r4.decode(r0, r5, r6);	 Catch:{ IOException -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r4 = r1;
    L_0x0010:
        if (r4 != 0) goto L_0x0017;
    L_0x0012:
        r5 = r2.diskCache;
        r5.delete(r3);
    L_0x0017:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.CacheLoader.load(com.bumptech.glide.load.Key, com.bumptech.glide.load.ResourceDecoder, int, int):com.bumptech.glide.load.engine.Resource<Z>");
    }
}
