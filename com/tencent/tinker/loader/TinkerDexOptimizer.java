package com.tencent.tinker.loader;

import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: BUGLY */
public final class TinkerDexOptimizer {
    private static final String INTERPRET_LOCK_FILE_NAME = "interpret.lock";
    private static final String TAG = "Tinker.ParallelDex";

    /* compiled from: BUGLY */
    private static class OptimizeWorker {
        private static String targetISA;
        private final ResultCallback callback;
        private final File dexFile;
        private final File optimizedDir;
        private final boolean useInterpretMode;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.dexFile = file;
            this.optimizedDir = file2;
            this.useInterpretMode = z;
            this.callback = resultCallback;
            targetISA = str;
        }

        public boolean run() {
            try {
                if (SharePatchFileUtil.isLegalFile(this.dexFile) || this.callback == null) {
                    if (this.callback != null) {
                        this.callback.onStart(this.dexFile, this.optimizedDir);
                    }
                    String optimizedPathFor = SharePatchFileUtil.optimizedPathFor(this.dexFile, this.optimizedDir);
                    if (this.useInterpretMode) {
                        interpretDex2Oat(this.dexFile.getAbsolutePath(), optimizedPathFor);
                    } else {
                        DexFile.loadDex(this.dexFile.getAbsolutePath(), optimizedPathFor, 0);
                    }
                    if (this.callback != null) {
                        this.callback.onSuccess(this.dexFile, this.optimizedDir, new File(optimizedPathFor));
                    }
                    return true;
                }
                ResultCallback resultCallback = this.callback;
                File file = this.dexFile;
                File file2 = this.optimizedDir;
                StringBuilder stringBuilder = new StringBuilder("dex file ");
                stringBuilder.append(this.dexFile.getAbsolutePath());
                stringBuilder.append(" is not exist!");
                resultCallback.onFailed(file, file2, new IOException(stringBuilder.toString()));
                return false;
            } catch (Throwable th) {
                new StringBuilder("Failed to optimize dex: ").append(this.dexFile.getAbsolutePath());
                if (this.callback != null) {
                    this.callback.onFailed(this.dexFile, this.optimizedDir, th);
                    return false;
                }
            }
        }

        private void interpretDex2Oat(java.lang.String r5, java.lang.String r6) throws java.io.IOException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r0 = new java.io.File;
            r0.<init>(r6);
            r1 = r0.exists();
            if (r1 != 0) goto L_0x0012;
        L_0x000b:
            r1 = r0.getParentFile();
            r1.mkdirs();
        L_0x0012:
            r1 = new java.io.File;
            r0 = r0.getParentFile();
            r2 = "interpret.lock";
            r1.<init>(r0, r2);
            r0 = 0;
            r1 = com.tencent.tinker.loader.shareutil.ShareFileLockHelper.getFileLock(r1);	 Catch:{ all -> 0x00e4 }
            r0 = new java.util.ArrayList;	 Catch:{ all -> 0x00e2 }
            r0.<init>();	 Catch:{ all -> 0x00e2 }
            r2 = "dex2oat";	 Catch:{ all -> 0x00e2 }
            r0.add(r2);	 Catch:{ all -> 0x00e2 }
            r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00e2 }
            r3 = 24;	 Catch:{ all -> 0x00e2 }
            if (r2 < r3) goto L_0x0046;	 Catch:{ all -> 0x00e2 }
        L_0x0032:
            r2 = "--runtime-arg";	 Catch:{ all -> 0x00e2 }
            r0.add(r2);	 Catch:{ all -> 0x00e2 }
            r2 = "-classpath";	 Catch:{ all -> 0x00e2 }
            r0.add(r2);	 Catch:{ all -> 0x00e2 }
            r2 = "--runtime-arg";	 Catch:{ all -> 0x00e2 }
            r0.add(r2);	 Catch:{ all -> 0x00e2 }
            r2 = "&";	 Catch:{ all -> 0x00e2 }
            r0.add(r2);	 Catch:{ all -> 0x00e2 }
        L_0x0046:
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r3 = "--dex-file=";	 Catch:{ all -> 0x00e2 }
            r2.<init>(r3);	 Catch:{ all -> 0x00e2 }
            r2.append(r5);	 Catch:{ all -> 0x00e2 }
            r5 = r2.toString();	 Catch:{ all -> 0x00e2 }
            r0.add(r5);	 Catch:{ all -> 0x00e2 }
            r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r2 = "--oat-file=";	 Catch:{ all -> 0x00e2 }
            r5.<init>(r2);	 Catch:{ all -> 0x00e2 }
            r5.append(r6);	 Catch:{ all -> 0x00e2 }
            r5 = r5.toString();	 Catch:{ all -> 0x00e2 }
            r0.add(r5);	 Catch:{ all -> 0x00e2 }
            r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r6 = "--instruction-set=";	 Catch:{ all -> 0x00e2 }
            r5.<init>(r6);	 Catch:{ all -> 0x00e2 }
            r6 = targetISA;	 Catch:{ all -> 0x00e2 }
            r5.append(r6);	 Catch:{ all -> 0x00e2 }
            r5 = r5.toString();	 Catch:{ all -> 0x00e2 }
            r0.add(r5);	 Catch:{ all -> 0x00e2 }
            r5 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00e2 }
            r6 = 25;	 Catch:{ all -> 0x00e2 }
            if (r5 <= r6) goto L_0x0087;	 Catch:{ all -> 0x00e2 }
        L_0x0081:
            r5 = "--compiler-filter=quicken";	 Catch:{ all -> 0x00e2 }
            r0.add(r5);	 Catch:{ all -> 0x00e2 }
            goto L_0x008c;	 Catch:{ all -> 0x00e2 }
        L_0x0087:
            r5 = "--compiler-filter=interpret-only";	 Catch:{ all -> 0x00e2 }
            r0.add(r5);	 Catch:{ all -> 0x00e2 }
        L_0x008c:
            r5 = new java.lang.ProcessBuilder;	 Catch:{ all -> 0x00e2 }
            r5.<init>(r0);	 Catch:{ all -> 0x00e2 }
            r6 = 1;	 Catch:{ all -> 0x00e2 }
            r5.redirectErrorStream(r6);	 Catch:{ all -> 0x00e2 }
            r5 = r5.start();	 Catch:{ all -> 0x00e2 }
            r6 = r5.getInputStream();	 Catch:{ all -> 0x00e2 }
            com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.consumeInputStream(r6);	 Catch:{ all -> 0x00e2 }
            r6 = r5.getErrorStream();	 Catch:{ all -> 0x00e2 }
            com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.consumeInputStream(r6);	 Catch:{ all -> 0x00e2 }
            r5 = r5.waitFor();	 Catch:{ InterruptedException -> 0x00c9 }
            if (r5 == 0) goto L_0x00c1;	 Catch:{ InterruptedException -> 0x00c9 }
        L_0x00ad:
            r6 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x00c9 }
            r0 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x00c9 }
            r2 = "dex2oat works unsuccessfully, exit code: ";	 Catch:{ InterruptedException -> 0x00c9 }
            r0.<init>(r2);	 Catch:{ InterruptedException -> 0x00c9 }
            r0.append(r5);	 Catch:{ InterruptedException -> 0x00c9 }
            r5 = r0.toString();	 Catch:{ InterruptedException -> 0x00c9 }
            r6.<init>(r5);	 Catch:{ InterruptedException -> 0x00c9 }
            throw r6;	 Catch:{ InterruptedException -> 0x00c9 }
        L_0x00c1:
            if (r1 == 0) goto L_0x00c8;
        L_0x00c3:
            r1.close();	 Catch:{ IOException -> 0x00c7 }
            goto L_0x00c8;
        L_0x00c7:
            return;
        L_0x00c8:
            return;
        L_0x00c9:
            r5 = move-exception;
            r6 = new java.io.IOException;	 Catch:{ all -> 0x00e2 }
            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e2 }
            r2 = "dex2oat is interrupted, msg: ";	 Catch:{ all -> 0x00e2 }
            r0.<init>(r2);	 Catch:{ all -> 0x00e2 }
            r2 = r5.getMessage();	 Catch:{ all -> 0x00e2 }
            r0.append(r2);	 Catch:{ all -> 0x00e2 }
            r0 = r0.toString();	 Catch:{ all -> 0x00e2 }
            r6.<init>(r0, r5);	 Catch:{ all -> 0x00e2 }
            throw r6;	 Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r5 = move-exception;
            goto L_0x00e6;
        L_0x00e4:
            r5 = move-exception;
            r1 = r0;
        L_0x00e6:
            if (r1 == 0) goto L_0x00eb;
        L_0x00e8:
            r1.close();	 Catch:{ IOException -> 0x00eb }
        L_0x00eb:
            throw r5;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.OptimizeWorker.interpretDex2Oat(java.lang.String, java.lang.String):void");
        }
    }

    /* compiled from: BUGLY */
    public interface ResultCallback {
        void onFailed(File file, File file2, Throwable th);

        void onStart(File file, File file2);

        void onSuccess(File file, File file2, File file3);
    }

    /* compiled from: BUGLY */
    private static class StreamConsumer {
        static final Executor STREAM_CONSUMER = Executors.newSingleThreadExecutor();

        /* compiled from: BUGLY */
        final class AnonymousClass1 implements Runnable {
            final /* synthetic */ InputStream val$is;

            AnonymousClass1(InputStream inputStream) {
                this.val$is = inputStream;
            }

            public final void run() {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                /*
                r2 = this;
                r0 = r2.val$is;
                if (r0 != 0) goto L_0x0005;
            L_0x0004:
                return;
            L_0x0005:
                r0 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
                r0 = new byte[r0];
            L_0x0009:
                r1 = r2.val$is;	 Catch:{ IOException -> 0x001f, all -> 0x0018 }
                r1 = r1.read(r0);	 Catch:{ IOException -> 0x001f, all -> 0x0018 }
                if (r1 > 0) goto L_0x0009;
            L_0x0011:
                r0 = r2.val$is;	 Catch:{ Exception -> 0x0017 }
                r0.close();	 Catch:{ Exception -> 0x0017 }
                return;
            L_0x0017:
                return;
            L_0x0018:
                r0 = move-exception;
                r1 = r2.val$is;	 Catch:{ Exception -> 0x001e }
                r1.close();	 Catch:{ Exception -> 0x001e }
            L_0x001e:
                throw r0;
            L_0x001f:
                r0 = r2.val$is;	 Catch:{ Exception -> 0x0025 }
                r0.close();	 Catch:{ Exception -> 0x0025 }
                return;
            L_0x0025:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.TinkerDexOptimizer.StreamConsumer.1.run():void");
            }
        }

        private StreamConsumer() {
        }

        static void consumeInputStream(InputStream inputStream) {
            STREAM_CONSUMER.execute(new AnonymousClass1(inputStream));
        }
    }

    public static boolean optimizeAll(Collection<File> collection, File file, ResultCallback resultCallback) {
        return optimizeAll(collection, file, false, null, resultCallback);
    }

    public static boolean optimizeAll(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        Object arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final int compare(File file, File file2) {
                long length = file.length() - file2.length();
                if (length > 0) {
                    return 1;
                }
                return length == 0 ? null : -1;
            }
        });
        Collections.reverse(arrayList);
        collection = arrayList.iterator();
        while (collection.hasNext()) {
            if (!new OptimizeWorker((File) collection.next(), file, z, str, resultCallback).run()) {
                return null;
            }
        }
        return true;
    }
}
