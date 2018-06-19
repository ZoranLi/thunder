package com.xunlei.download.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadlib.XLDownloadManager;
import java.util.List;

/* compiled from: TaskPlayHelper */
public class s {
    private static s a;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private boolean f = false;
    private Object g;
    private Object h;
    private boolean i = false;
    private long j = -1;
    private long k = -1;

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            if (a == null) {
                sVar = new s();
                a = sVar;
                sVar.g = new Object();
                a.h = new Object();
            }
            sVar = a;
        }
        return sVar;
    }

    public void a(long j, long j2) {
        synchronized (this.g) {
            if (j >= 0) {
                this.f = false;
            }
            c(j, j2);
        }
    }

    public void a(Context context) {
        synchronized (this.g) {
            if (this.b >= 0) {
                ContentValues contentValues = new ContentValues();
                Uri downloadUri = DownloadManager.getInstanceFor(context).getDownloadUri(this.b);
                contentValues.put("xunlei_spdy", Integer.valueOf(1));
                try {
                    context.getContentResolver().update(downloadUri, contentValues, null, null);
                } catch (Throwable e) {
                    e.printStackTrace();
                    an.a(e);
                }
            }
        }
    }

    private void c(long j, long j2) {
        StringBuilder stringBuilder = new StringBuilder("setPlayTask,id =");
        stringBuilder.append(j);
        stringBuilder.append(", index=");
        stringBuilder.append(j2);
        stringBuilder.append(", mIsPaused=");
        stringBuilder.append(this.f);
        an.b("TaskPlayHelper", stringBuilder.toString());
        if (this.b >= 0 && this.c >= 0 && j < 0) {
            f();
        }
        this.b = j;
        this.c = j2;
    }

    public void b(long j, long j2) {
        synchronized (this.g) {
            if (this.b == j && this.c == j2) {
                c(-1, -1);
            }
        }
    }

    public void a(long j) {
        synchronized (this.g) {
            if (this.b == j) {
                c(-1, -1);
            }
        }
    }

    public long b() {
        synchronized (this.g) {
            if (this.f) {
                return -1;
            }
            long j = this.b;
            return j;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long b(long r7) {
        /*
        r6 = this;
        r0 = r6.g;
        monitor-enter(r0);
        r1 = r6.b;	 Catch:{ all -> 0x001d }
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 < 0) goto L_0x0019;
    L_0x000b:
        r1 = r6.b;	 Catch:{ all -> 0x001d }
        r3 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1));
        if (r3 != 0) goto L_0x0019;
    L_0x0011:
        r7 = r6.f;	 Catch:{ all -> 0x001d }
        if (r7 != 0) goto L_0x0019;
    L_0x0015:
        r7 = r6.c;	 Catch:{ all -> 0x001d }
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        return r7;
    L_0x0019:
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        r7 = -1;
        return r7;
    L_0x001d:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x001d }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.s.b(long):long");
    }

    public void a(List<Long> list) {
        synchronized (this.g) {
            for (Long longValue : list) {
                if (this.b == longValue.longValue()) {
                    this.f = true;
                }
            }
        }
    }

    public void b(List<Long> list) {
        synchronized (this.g) {
            for (Long longValue : list) {
                if (this.b == longValue.longValue()) {
                    this.f = false;
                }
            }
        }
    }

    public void c(long j) {
        synchronized (this.g) {
            if (this.b == j) {
                this.f = 0;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Context r6, long r7, int r9) {
        /*
        r5 = this;
        r6 = r5.h;
        monitor-enter(r6);
        r0 = "TaskPlayHelper";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
        r2 = "setBtPriorSubTask,xlTaskId =";
        r1.<init>(r2);	 Catch:{ all -> 0x0065 }
        r1.append(r7);	 Catch:{ all -> 0x0065 }
        r2 = ", index=";
        r1.append(r2);	 Catch:{ all -> 0x0065 }
        r1.append(r9);	 Catch:{ all -> 0x0065 }
        r1 = r1.toString();	 Catch:{ all -> 0x0065 }
        com.xunlei.download.proguard.an.b(r0, r1);	 Catch:{ all -> 0x0065 }
        r0 = r5.d;	 Catch:{ all -> 0x0065 }
        r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1));
        if (r2 != 0) goto L_0x002d;
    L_0x0024:
        r0 = r5.e;	 Catch:{ all -> 0x0065 }
        r2 = (long) r9;	 Catch:{ all -> 0x0065 }
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x002d;
    L_0x002b:
        monitor-exit(r6);	 Catch:{ all -> 0x0065 }
        return;
    L_0x002d:
        r0 = 0;
        r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x005d;
    L_0x0033:
        if (r9 < 0) goto L_0x005d;
    L_0x0035:
        r5.d = r7;	 Catch:{ all -> 0x0065 }
        r0 = (long) r9;	 Catch:{ all -> 0x0065 }
        r5.e = r0;	 Catch:{ all -> 0x0065 }
        r0 = com.xunlei.downloadlib.XLDownloadManager.getInstance();	 Catch:{ all -> 0x0065 }
        r0.setBtPriorSubTask(r7, r9);	 Catch:{ all -> 0x0065 }
        r0 = "TaskPlayHelper";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0065 }
        r2 = "XLDownloadManager.setBtPriorSubTask,xlTaskId =";
        r1.<init>(r2);	 Catch:{ all -> 0x0065 }
        r1.append(r7);	 Catch:{ all -> 0x0065 }
        r7 = ", index=";
        r1.append(r7);	 Catch:{ all -> 0x0065 }
        r1.append(r9);	 Catch:{ all -> 0x0065 }
        r7 = r1.toString();	 Catch:{ all -> 0x0065 }
        com.xunlei.download.proguard.an.b(r0, r7);	 Catch:{ all -> 0x0065 }
        goto L_0x0063;
    L_0x005d:
        r7 = -1;
        r5.d = r7;	 Catch:{ all -> 0x0065 }
        r5.e = r7;	 Catch:{ all -> 0x0065 }
    L_0x0063:
        monitor-exit(r6);	 Catch:{ all -> 0x0065 }
        return;
    L_0x0065:
        r7 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0065 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.s.a(android.content.Context, long, int):void");
    }

    private void f() {
        synchronized (this.h) {
            if (this.d >= 0) {
                XLDownloadManager.getInstance().setBtPriorSubTask(this.d, -1);
                a(true);
                e(this.d);
                f(this.c);
                this.d = -1;
            }
        }
    }

    public void d(long j) {
        synchronized (this.h) {
            if (j == this.d) {
                this.d = -1;
                this.e = -1;
                StringBuilder stringBuilder = new StringBuilder("removeBtPriorSubTask,mXLTaskId =");
                stringBuilder.append(this.d);
                stringBuilder.append(", mXLSubTaskIdx=");
                stringBuilder.append(this.e);
                an.b("TaskPlayHelper", stringBuilder.toString());
            }
        }
    }

    public void a(boolean z) {
        this.i = z;
    }

    public boolean c() {
        return this.i;
    }

    public void e(long j) {
        this.j = j;
    }

    public long d() {
        return this.j;
    }

    public void f(long j) {
        this.k = j;
    }

    public long e() {
        return this.k;
    }
}
