package com.xunlei.downloadprovider.download.tasklist.list.a;

import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.s;

/* compiled from: TaskCardItem */
public final class e {
    public final int a;
    public long b;
    public Object c;
    protected boolean d;

    public e(int i, Object obj, long j) {
        this.b = -1;
        this.a = i;
        this.c = obj;
        this.b = j;
    }

    public e(int i) {
        this(i, null, -1);
    }

    public final <T> T a(java.lang.Class<T> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.c;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r2.c;	 Catch:{ ClassCastException -> 0x000d }
        r3 = r3.cast(r0);	 Catch:{ ClassCastException -> 0x000d }
        return r3;
    L_0x000d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.a.e.a(java.lang.Class):T");
    }

    public final boolean a() {
        return this.d;
    }

    public final void a(boolean z) {
        this.d = z;
    }

    public final DownloadTaskInfo b() {
        if (this.c instanceof s) {
            return ((s) this.c).b;
        }
        return this.c instanceof DownloadTaskInfo ? (DownloadTaskInfo) this.c : null;
    }
}
