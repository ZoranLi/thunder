package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.util.LogTime;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class DecodeJob<A, T, Z> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private static final String TAG = "DecodeJob";
    private final DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher<A> fetcher;
    private final FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider<A, T> loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder<T, Z> transcoder;
    private final Transformation<T> transformation;
    private final int width;

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    static class FileOpener {
        FileOpener() {
        }

        public OutputStream open(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    class SourceWriter<DataType> implements Writer {
        private final DataType data;
        private final Encoder<DataType> encoder;

        public SourceWriter(Encoder<DataType> encoder, DataType dataType) {
            this.encoder = encoder;
            this.data = dataType;
        }

        public boolean write(java.io.File r4) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = 0;
            r1 = com.bumptech.glide.load.engine.DecodeJob.this;	 Catch:{ FileNotFoundException -> 0x0025, all -> 0x001e }
            r1 = r1.fileOpener;	 Catch:{ FileNotFoundException -> 0x0025, all -> 0x001e }
            r4 = r1.open(r4);	 Catch:{ FileNotFoundException -> 0x0025, all -> 0x001e }
            r0 = r3.encoder;	 Catch:{ FileNotFoundException -> 0x0026, all -> 0x0019 }
            r1 = r3.data;	 Catch:{ FileNotFoundException -> 0x0026, all -> 0x0019 }
            r0 = r0.encode(r1, r4);	 Catch:{ FileNotFoundException -> 0x0026, all -> 0x0019 }
            if (r4 == 0) goto L_0x002c;
        L_0x0015:
            r4.close();	 Catch:{ IOException -> 0x002c }
            goto L_0x002c;
        L_0x0019:
            r0 = move-exception;
            r2 = r0;
            r0 = r4;
            r4 = r2;
            goto L_0x001f;
        L_0x001e:
            r4 = move-exception;
        L_0x001f:
            if (r0 == 0) goto L_0x0024;
        L_0x0021:
            r0.close();	 Catch:{ IOException -> 0x0024 }
        L_0x0024:
            throw r4;
        L_0x0025:
            r4 = r0;
        L_0x0026:
            if (r4 == 0) goto L_0x002b;
        L_0x0028:
            r4.close();	 Catch:{ IOException -> 0x002b }
        L_0x002b:
            r0 = 0;
        L_0x002c:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.SourceWriter.write(java.io.File):boolean");
        }
    }

    public DecodeJob(EngineKey engineKey, int i, int i2, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority) {
        this(engineKey, i, i2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, diskCacheProvider, diskCacheStrategy, priority, DEFAULT_FILE_OPENER);
    }

    DecodeJob(EngineKey engineKey, int i, int i2, DataFetcher<A> dataFetcher, DataLoadProvider<A, T> dataLoadProvider, Transformation<T> transformation, ResourceTranscoder<T, Z> resourceTranscoder, DiskCacheProvider diskCacheProvider, DiskCacheStrategy diskCacheStrategy, Priority priority, FileOpener fileOpener) {
        this.resultKey = engineKey;
        this.width = i;
        this.height = i2;
        this.fetcher = dataFetcher;
        this.loadProvider = dataLoadProvider;
        this.transformation = transformation;
        this.transcoder = resourceTranscoder;
        this.diskCacheProvider = diskCacheProvider;
        this.diskCacheStrategy = diskCacheStrategy;
        this.priority = priority;
        this.fileOpener = fileOpener;
    }

    public Resource<Z> decodeResultFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheResult()) {
            return null;
        }
        long logTime = LogTime.getLogTime();
        Resource loadFromCache = loadFromCache(this.resultKey);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded transformed from cache", logTime);
        }
        logTime = LogTime.getLogTime();
        Resource<Z> transcode = transcode(loadFromCache);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from cache", logTime);
        }
        return transcode;
    }

    public Resource<Z> decodeSourceFromCache() throws Exception {
        if (!this.diskCacheStrategy.cacheSource()) {
            return null;
        }
        long logTime = LogTime.getLogTime();
        Resource loadFromCache = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return transformEncodeAndTranscode(loadFromCache);
    }

    public Resource<Z> decodeFromSource() throws Exception {
        return transformEncodeAndTranscode(decodeSource());
    }

    public void cancel() {
        this.isCancelled = true;
        this.fetcher.cancel();
    }

    private Resource<Z> transformEncodeAndTranscode(Resource<T> resource) {
        long logTime = LogTime.getLogTime();
        resource = transform(resource);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transformed resource from source", logTime);
        }
        writeTransformedToCache(resource);
        logTime = LogTime.getLogTime();
        resource = transcode(resource);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Transcoded transformed from source", logTime);
        }
        return resource;
    }

    private void writeTransformedToCache(Resource<T> resource) {
        if (resource != null) {
            if (this.diskCacheStrategy.cacheResult()) {
                long logTime = LogTime.getLogTime();
                this.diskCacheProvider.getDiskCache().put(this.resultKey, new SourceWriter(this.loadProvider.getEncoder(), resource));
                if (Log.isLoggable(TAG, 2) != null) {
                    logWithTimeAndKey("Wrote transformed from source to cache", logTime);
                }
            }
        }
    }

    private Resource<T> decodeSource() throws Exception {
        try {
            long logTime = LogTime.getLogTime();
            Object loadData = this.fetcher.loadData(this.priority);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Fetched data", logTime);
            }
            if (this.isCancelled) {
                return null;
            }
            Resource<T> decodeFromSourceData = decodeFromSourceData(loadData);
            this.fetcher.cleanup();
            return decodeFromSourceData;
        } finally {
            this.fetcher.cleanup();
        }
    }

    private Resource<T> decodeFromSourceData(A a) throws IOException {
        if (this.diskCacheStrategy.cacheSource()) {
            return cacheAndDecodeSourceData(a);
        }
        long logTime = LogTime.getLogTime();
        a = this.loadProvider.getSourceDecoder().decode(a, this.width, this.height);
        if (!Log.isLoggable(TAG, 2)) {
            return a;
        }
        logWithTimeAndKey("Decoded from source", logTime);
        return a;
    }

    private Resource<T> cacheAndDecodeSourceData(A a) throws IOException {
        long logTime = LogTime.getLogTime();
        this.diskCacheProvider.getDiskCache().put(this.resultKey.getOriginalKey(), new SourceWriter(this.loadProvider.getSourceEncoder(), a));
        if (Log.isLoggable(TAG, 2) != null) {
            logWithTimeAndKey("Wrote source to cache", logTime);
        }
        logTime = LogTime.getLogTime();
        a = loadFromCache(this.resultKey.getOriginalKey());
        if (Log.isLoggable(TAG, 2) && a != null) {
            logWithTimeAndKey("Decoded source from cache", logTime);
        }
        return a;
    }

    private Resource<T> loadFromCache(Key key) throws IOException {
        File file = this.diskCacheProvider.getDiskCache().get(key);
        if (file == null) {
            return null;
        }
        try {
            Resource<T> decode = this.loadProvider.getCacheDecoder().decode(file, this.width, this.height);
            if (decode == null) {
            }
            return decode;
        } finally {
            this.diskCacheProvider.getDiskCache().delete(key);
        }
    }

    private Resource<T> transform(Resource<T> resource) {
        if (resource == null) {
            return null;
        }
        Resource<T> transform = this.transformation.transform(resource, this.width, this.height);
        if (!resource.equals(transform)) {
            resource.recycle();
        }
        return transform;
    }

    private Resource<Z> transcode(Resource<T> resource) {
        return resource == null ? null : this.transcoder.transcode(resource);
    }

    private void logWithTimeAndKey(String str, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.getElapsedMillis(j));
        stringBuilder.append(", key: ");
        stringBuilder.append(this.resultKey);
    }
}
