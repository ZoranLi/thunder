package com.xunlei.download.proguard;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.Downloads.Impl;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: StorageManager */
public class q {
    private static final long a = 104857600;
    private static final long b = 10485760;
    private static final int f = 1048576;
    private static final int i = 250;
    private final File c;
    private final File d;
    private final File e;
    private int g = 0;
    private final Context h;
    private int j = 0;
    private Thread k = null;

    public q(Context context) {
        this.h = context;
        this.e = a(context);
        this.c = Environment.getExternalStorageDirectory();
        this.d = Environment.getDownloadCacheDirectory();
        c();
    }

    synchronized void a() {
        int i = this.j + 1;
        this.j = i;
        if (i % 250 == 0) {
            c();
        }
    }

    private synchronized void c() {
        if (this.k == null || !this.k.isAlive()) {
            this.k = new Thread(this) {
                final /* synthetic */ q a;

                {
                    this.a = r1;
                }

                public void run() {
                    this.a.d();
                    this.a.e();
                }
            };
            this.k.start();
        }
    }

    void a(int i, String str, long j) throws p {
        if (a(j) >= 1048576) {
            b(i, str, j);
        }
    }

    public void b(int i, String str, long j) throws p {
        f();
        StringBuilder stringBuilder = new StringBuilder("in verifySpace, destination: ");
        stringBuilder.append(i);
        stringBuilder.append(", path: ");
        stringBuilder.append(str);
        stringBuilder.append(", length: ");
        stringBuilder.append(j);
        an.a("DownloadManager", stringBuilder.toString());
        if (str == null) {
            throw new p(Impl.STATUS_FILE_ERROR, "verifySpace fail.");
        }
        File file;
        switch (i) {
            case 0:
                file = this.c;
                break;
            case 1:
            case 2:
            case 3:
                file = this.e;
                break;
            case 4:
                if (!str.startsWith(this.c.getPath())) {
                    if (!str.startsWith(this.e.getPath())) {
                        if (!str.startsWith(this.d.getPath())) {
                            file = new File(str).getParentFile();
                            file.mkdirs();
                            break;
                        }
                        file = this.d;
                        break;
                    }
                    file = this.e;
                    break;
                }
                file = this.c;
                break;
            case 5:
                file = this.d;
                break;
            default:
                file = null;
                break;
        }
        if (file == null) {
            StringBuilder stringBuilder2 = new StringBuilder("invalid combination of destination: ");
            stringBuilder2.append(i);
            stringBuilder2.append(", path: ");
            stringBuilder2.append(str);
            throw new p(Impl.STATUS_FILE_ERROR, stringBuilder2.toString());
        }
        a(file, j, i);
    }

    private synchronized void a(File file, long j, int i) throws p {
        if (j != 0) {
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            if (i == 4 || i == 0) {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    stringBuilder = new StringBuilder("external media not mounted ,state=");
                    stringBuilder.append(Environment.getExternalStorageState());
                    throw new p(199, stringBuilder.toString());
                }
            }
            long b = b(file);
            if (b < b) {
                a(i, b);
                d();
                b = b(file);
                if (b < b) {
                    if (file.equals(this.d)) {
                        stringBuilder2 = new StringBuilder("System cache dir ('/cache') is running low on space.space available (in bytes): ");
                        stringBuilder2.append(b);
                        an.c("DownloadManager", stringBuilder2.toString());
                    } else {
                        stringBuilder = new StringBuilder("space in the filesystem rooted at: ");
                        stringBuilder.append(file);
                        stringBuilder.append(" is below 10% availability. stopping this download.");
                        throw new p(198, stringBuilder.toString());
                    }
                }
            }
            if (file.equals(this.e)) {
                b = a(this.e);
                if (b < b) {
                    stringBuilder2 = new StringBuilder("Downloads data dir: ");
                    stringBuilder2.append(file);
                    stringBuilder2.append(" is running low on space. space available (in bytes): ");
                    stringBuilder2.append(b);
                    an.c("DownloadManager", stringBuilder2.toString());
                }
                if (b < j) {
                    a(i, b);
                    d();
                    b = a(this.e);
                }
            }
            if (b < j) {
                stringBuilder = new StringBuilder("not enough free space in the filesystem rooted at: ");
                stringBuilder.append(file);
                stringBuilder.append(" and unable to free any more");
                throw new p(198, stringBuilder.toString());
            }
        }
    }

    private long a(File file) {
        file = file.listFiles();
        long j = a;
        if (file == null) {
            return a;
        }
        int i = 0;
        while (i < file.length) {
            i++;
            j -= file[i].length();
        }
        StringBuilder stringBuilder = new StringBuilder("available space (in bytes) in downloads data dir: ");
        stringBuilder.append(j);
        an.a("DownloadManager", stringBuilder.toString());
        return j;
    }

    private long b(File file) {
        StatFs statFs = new StatFs(file.getPath());
        long blockSize = ((long) statFs.getBlockSize()) * (((long) statFs.getAvailableBlocks()) - 4);
        StringBuilder stringBuilder = new StringBuilder("available space (in bytes) in filesystem rooted at: ");
        stringBuilder.append(file.getPath());
        stringBuilder.append(" is: ");
        stringBuilder.append(blockSize);
        an.a("DownloadManager", stringBuilder.toString());
        return blockSize;
    }

    public File a(String str, int i, long j) throws p {
        if (i == 5) {
            return this.d;
        }
        switch (i) {
            case 0:
                i = new StringBuilder();
                i.append(this.c.getPath());
                i.append(c.r);
                str = new File(i.toString());
                if (str.isDirectory() != 0 || str.mkdir() != 0) {
                    return str;
                }
                StringBuilder stringBuilder = new StringBuilder("unable to create external downloads directory ");
                stringBuilder.append(str.getPath());
                throw new p(492, stringBuilder.toString());
            case 1:
            case 2:
            case 3:
                return this.e;
            default:
                j = new StringBuilder("unexpected value for destination: ");
                j.append(i);
                throw new IllegalStateException(j.toString());
        }
    }

    public File b() {
        return this.e;
    }

    public static File a(Context context) {
        return context.getCacheDir();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long a(int r13, long r14) {
        /*
        r12 = this;
        r0 = "DownloadManager";
        r1 = new java.lang.StringBuilder;
        r2 = "discardPurgeableFiles: destination = ";
        r1.<init>(r2);
        r1.append(r13);
        r2 = ", targetBytes = ";
        r1.append(r2);
        r1.append(r14);
        r1 = r1.toString();
        com.xunlei.download.proguard.an.a(r0, r1);
        r0 = 5;
        if (r13 != r0) goto L_0x0023;
    L_0x001e:
        r13 = java.lang.String.valueOf(r13);
        goto L_0x0025;
    L_0x0023:
        r13 = "2";
    L_0x0025:
        r0 = 1;
        r5 = new java.lang.String[r0];
        r0 = 0;
        r5[r0] = r13;
        r7 = 0;
        r13 = 0;
        r0 = r12.h;	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r1 = r0.getContentResolver();	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r0 = r12.h;	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r0 = com.xunlei.download.DownloadManager.getInstanceFor(r0);	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r2 = r0.getDownloadUri();	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r3 = 0;
        r4 = "( status = '200' AND destination = ? )";
        r6 = "lastmod";
        r0 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00c5, all -> 0x00c1 }
        r1 = "_data";
        r1 = r0.getColumnIndex(r1);	 Catch:{ Exception -> 0x00bf }
    L_0x004d:
        r2 = r0.moveToNext();	 Catch:{ Exception -> 0x00bf }
        if (r2 == 0) goto L_0x00b9;
    L_0x0053:
        r2 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1));
        if (r2 >= 0) goto L_0x00b9;
    L_0x0057:
        r2 = r0.getString(r1);	 Catch:{ Exception -> 0x00bf }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x00bf }
        if (r3 != 0) goto L_0x004d;
    L_0x0061:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00bf }
        r3.<init>(r2);	 Catch:{ Exception -> 0x00bf }
        r2 = "DownloadManager";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00bf }
        r5 = "purging ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00bf }
        r5 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x00bf }
        r4.append(r5);	 Catch:{ Exception -> 0x00bf }
        r5 = " for ";
        r4.append(r5);	 Catch:{ Exception -> 0x00bf }
        r5 = r3.length();	 Catch:{ Exception -> 0x00bf }
        r4.append(r5);	 Catch:{ Exception -> 0x00bf }
        r5 = " bytes";
        r4.append(r5);	 Catch:{ Exception -> 0x00bf }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00bf }
        com.xunlei.download.proguard.an.b(r2, r4);	 Catch:{ Exception -> 0x00bf }
        r4 = r3.length();	 Catch:{ Exception -> 0x00bf }
        r9 = r7 + r4;
        r3.delete();	 Catch:{ Exception -> 0x00b6 }
        r2 = "_id";
        r2 = r0.getColumnIndex(r2);	 Catch:{ Exception -> 0x00b6 }
        r2 = r0.getLong(r2);	 Catch:{ Exception -> 0x00b6 }
        r4 = r12.h;	 Catch:{ Exception -> 0x00b6 }
        r4 = r4.getContentResolver();	 Catch:{ Exception -> 0x00b6 }
        r5 = r12.h;	 Catch:{ Exception -> 0x00b6 }
        r5 = com.xunlei.download.DownloadManager.getInstanceFor(r5);	 Catch:{ Exception -> 0x00b6 }
        r2 = r5.getDownloadUri(r2);	 Catch:{ Exception -> 0x00b6 }
        r4.delete(r2, r13, r13);	 Catch:{ Exception -> 0x00b6 }
        r7 = r9;
        goto L_0x004d;
    L_0x00b6:
        r13 = move-exception;
        r7 = r9;
        goto L_0x00c9;
    L_0x00b9:
        if (r0 == 0) goto L_0x00d2;
    L_0x00bb:
        r0.close();
        goto L_0x00d2;
    L_0x00bf:
        r13 = move-exception;
        goto L_0x00c9;
    L_0x00c1:
        r14 = move-exception;
        r0 = r13;
        r13 = r14;
        goto L_0x00f4;
    L_0x00c5:
        r0 = move-exception;
        r11 = r0;
        r0 = r13;
        r13 = r11;
    L_0x00c9:
        r13.printStackTrace();	 Catch:{ all -> 0x00f3 }
        com.xunlei.download.proguard.an.a(r13);	 Catch:{ all -> 0x00f3 }
        if (r0 == 0) goto L_0x00d2;
    L_0x00d1:
        goto L_0x00bb;
    L_0x00d2:
        r13 = "DownloadManager";
        r0 = new java.lang.StringBuilder;
        r1 = "Purged files, freed ";
        r0.<init>(r1);
        r0.append(r7);
        r1 = " for ";
        r0.append(r1);
        r0.append(r14);
        r14 = " requested";
        r0.append(r14);
        r14 = r0.toString();
        com.xunlei.download.proguard.an.a(r13, r14);
        return r7;
    L_0x00f3:
        r13 = move-exception;
    L_0x00f4:
        if (r0 == 0) goto L_0x00f9;
    L_0x00f6:
        r0.close();
    L_0x00f9:
        throw r13;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.q.a(int, long):long");
    }

    private void d() {
        Throwable e;
        an.a("DownloadManager", "in removeSpuriousFiles");
        List arrayList = new ArrayList();
        File[] listFiles = this.d.listFiles();
        if (listFiles != null) {
            arrayList.addAll(Arrays.asList(listFiles));
        }
        if (this.e != null) {
            listFiles = this.e.listFiles();
            if (listFiles != null) {
                arrayList.addAll(Arrays.asList(listFiles));
            }
            if (arrayList.size() != 0) {
                Cursor cursor = null;
                Cursor query;
                try {
                    query = this.h.getContentResolver().query(DownloadManager.getInstanceFor(this.h).getDownloadUri(), new String[]{Impl._DATA}, null, null, null);
                    if (query != null) {
                        while (query.moveToNext()) {
                            try {
                                String string = query.getString(0);
                                if (!TextUtils.isEmpty(string)) {
                                    StringBuilder stringBuilder = new StringBuilder("in removeSpuriousFiles, preserving file ");
                                    stringBuilder.append(string);
                                    an.a("DownloadManager", stringBuilder.toString());
                                    arrayList.remove(new File(string));
                                }
                            } catch (Exception e2) {
                                e = e2;
                                cursor = query;
                            } catch (Throwable th) {
                                e = th;
                            }
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        an.a(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
        }
    }

    private void e() {
        Cursor query;
        Throwable e;
        StringBuilder stringBuilder;
        Throwable th;
        an.a("DownloadManager", "in trimDatabase");
        try {
            query = this.h.getContentResolver().query(DownloadManager.getInstanceFor(this.h).getDownloadUri(), new String[]{"_id"}, "status >= '200'", null, Impl.COLUMN_LAST_MODIFICATION);
            if (query == null) {
                try {
                    an.d("DownloadManager", "null cursor in trimDatabase");
                    if (query != null) {
                        query.close();
                    }
                    return;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        stringBuilder = new StringBuilder("trimDatabase failed with exception: ");
                        stringBuilder.append(e.getMessage());
                        an.c("DownloadManager", stringBuilder.toString());
                        an.a(e);
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            if (query.moveToFirst()) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                for (int count = query.getCount() - 1000; count > 0; count--) {
                    this.h.getContentResolver().delete(ContentUris.withAppendedId(DownloadManager.getInstanceFor(this.h).getDownloadUri(), query.getLong(columnIndexOrThrow)), null, null);
                    if (!query.moveToNext()) {
                        break;
                    }
                }
            }
            if (query != null) {
                query.close();
            }
        } catch (Throwable e3) {
            th = e3;
            query = null;
            e = th;
            stringBuilder = new StringBuilder("trimDatabase failed with exception: ");
            stringBuilder.append(e.getMessage());
            an.c("DownloadManager", stringBuilder.toString());
            an.a(e);
            if (query != null) {
                query.close();
            }
        } catch (Throwable e32) {
            th = e32;
            query = null;
            e = th;
            if (query != null) {
                query.close();
            }
            throw e;
        }
    }

    private synchronized int a(long j) {
        this.g = (int) (((long) this.g) + j);
        return this.g;
    }

    private synchronized void f() {
        this.g = 0;
    }
}
