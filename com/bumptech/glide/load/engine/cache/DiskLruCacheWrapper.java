package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private DiskLruCache diskLruCache;
    private final int maxSize;
    private final SafeKeyGenerator safeKeyGenerator;
    private final DiskCacheWriteLocker writeLocker = new DiskCacheWriteLocker();

    public static synchronized DiskCache get(File file, int i) {
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, i);
            }
            file = wrapper;
        }
        return file;
    }

    protected DiskLruCacheWrapper(File file, int i) {
        this.directory = file;
        this.maxSize = i;
        this.safeKeyGenerator = new SafeKeyGenerator();
    }

    private synchronized DiskLruCache getDiskCache() throws IOException {
        if (this.diskLruCache == null) {
            this.diskLruCache = DiskLruCache.open(this.directory, 1, 1, (long) this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    public java.io.File get(com.bumptech.glide.load.Key r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.safeKeyGenerator;
        r3 = r0.getSafeKey(r3);
        r0 = 0;
        r1 = r2.getDiskCache();	 Catch:{ IOException -> 0x0017 }
        r3 = r1.get(r3);	 Catch:{ IOException -> 0x0017 }
        if (r3 == 0) goto L_0x0017;	 Catch:{ IOException -> 0x0017 }
    L_0x0011:
        r1 = 0;	 Catch:{ IOException -> 0x0017 }
        r3 = r3.getFile(r1);	 Catch:{ IOException -> 0x0017 }
        r0 = r3;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.get(com.bumptech.glide.load.Key):java.io.File");
    }

    public void put(com.bumptech.glide.load.Key r3, com.bumptech.glide.load.engine.cache.DiskCache.Writer r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.safeKeyGenerator;
        r0 = r0.getSafeKey(r3);
        r1 = r2.writeLocker;
        r1.acquire(r3);
        r1 = r2.getDiskCache();	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
        r0 = r1.edit(r0);	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
        if (r0 == 0) goto L_0x002c;
    L_0x0015:
        r1 = 0;
        r1 = r0.getFile(r1);	 Catch:{ all -> 0x0027 }
        r4 = r4.write(r1);	 Catch:{ all -> 0x0027 }
        if (r4 == 0) goto L_0x0023;	 Catch:{ all -> 0x0027 }
    L_0x0020:
        r0.commit();	 Catch:{ all -> 0x0027 }
    L_0x0023:
        r0.abortUnlessCommitted();	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
        goto L_0x002c;	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
    L_0x0027:
        r4 = move-exception;	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
        r0.abortUnlessCommitted();	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
        throw r4;	 Catch:{ IOException -> 0x002c, all -> 0x0032 }
    L_0x002c:
        r4 = r2.writeLocker;
        r4.release(r3);
        return;
    L_0x0032:
        r4 = move-exception;
        r0 = r2.writeLocker;
        r0.release(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.put(com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.cache.DiskCache$Writer):void");
    }

    public void delete(com.bumptech.glide.load.Key r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.safeKeyGenerator;
        r2 = r0.getSafeKey(r2);
        r0 = r1.getDiskCache();	 Catch:{ IOException -> 0x000e }
        r0.remove(r2);	 Catch:{ IOException -> 0x000e }
        return;
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.delete(com.bumptech.glide.load.Key):void");
    }

    public synchronized void clear() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.getDiskCache();	 Catch:{ IOException -> 0x0010, all -> 0x000d }
        r0.delete();	 Catch:{ IOException -> 0x0010, all -> 0x000d }
        r1.resetDiskCache();	 Catch:{ IOException -> 0x0010, all -> 0x000d }
        monitor-exit(r1);
        return;
    L_0x000d:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0010:
        monitor-exit(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper.clear():void");
    }
}
