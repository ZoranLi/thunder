package com.xunlei.downloadprovider.download.tasklist.task;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.engine.task.a.ad;
import com.xunlei.downloadprovider.download.engine.task.a.b;
import com.xunlei.downloadprovider.download.engine.task.a.r;
import com.xunlei.downloadprovider.download.engine.task.a.t;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: TaskListManager */
public class h extends ad implements r<s> {
    static final String a = "h";
    private static h f;
    protected final ConcurrentHashMap<Long, s> b = new ConcurrentHashMap(1);
    protected b c = new b(0);
    protected b d = new b(1);
    protected b e = new b(2);
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private q j;
    private final t k = new t(a, new i(this));
    private ExecutorService l = Executors.newSingleThreadExecutor();
    private final a m = new a();
    private int n = 0;
    private Handler o = new k(this);
    private volatile int p = 0;
    private final Object q = new Object();
    private volatile List<z> r;
    private final Object s = new Object();
    private a t = new p(this);

    public final /* synthetic */ void a(Object obj, String str) {
        if (this.b.containsKey(Long.valueOf(((s) obj).a())) != null) {
            m();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.xunlei.downloadprovider.download.tasklist.task.s a(long r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.b;	 Catch:{ all -> 0x002f }
        r1 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x002f }
        r0 = r0.containsKey(r1);	 Catch:{ all -> 0x002f }
        if (r0 == 0) goto L_0x001b;
    L_0x000d:
        r0 = r2.b;	 Catch:{ all -> 0x002f }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ all -> 0x002f }
        r3 = r0.get(r3);	 Catch:{ all -> 0x002f }
        r3 = (com.xunlei.downloadprovider.download.tasklist.task.s) r3;	 Catch:{ all -> 0x002f }
        monitor-exit(r2);
        return r3;
    L_0x001b:
        r0 = 0;
        com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ all -> 0x002f }
        r3 = com.xunlei.downloadprovider.download.engine.task.n.e(r3);	 Catch:{ all -> 0x002f }
        if (r3 == 0) goto L_0x002d;
    L_0x0025:
        r4 = 0;
        r0 = r2.a(r3, r4);	 Catch:{ all -> 0x002f }
        r0.a(r3);	 Catch:{ all -> 0x002f }
    L_0x002d:
        monitor-exit(r2);
        return r0;
    L_0x002f:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.task.h.a(long):com.xunlei.downloadprovider.download.tasklist.task.s");
    }

    public final List<e> a() {
        if (this.c == null) {
            return null;
        }
        return this.c.c;
    }

    public final void a(int i) {
        this.n = i;
        boolean z = false;
        this.d.f = i == 1;
        this.e.f = i == 2;
        b bVar = this.c;
        if (i == 0) {
            z = true;
        }
        bVar.f = z;
    }

    public final long b() {
        if (this.g) {
            return this.m.j;
        }
        boolean n = n();
        n.a();
        return n.c(n).a;
    }

    public static TaskCountsStatistics c() {
        n.a();
        return n.b(n());
    }

    public static TaskCountsStatistics d() {
        n.a();
        return n.b(true);
    }

    private h() {
        this.k.start();
        n.a().a(new j(this));
    }

    public static h e() {
        if (f == null) {
            synchronized (h.class) {
                f = new h();
            }
        }
        return f;
    }

    public final s b(long j) {
        return (s) this.b.get(Long.valueOf(j));
    }

    public final DownloadTaskInfo c(long j) {
        s sVar = (s) this.b.get(Long.valueOf(j));
        return sVar != null ? sVar.b : 0;
    }

    public final b b(int i) {
        if (i == 1) {
            return this.d;
        }
        if (i == 2) {
            return this.e;
        }
        return i == 0 ? this.c : 0;
    }

    public final boolean f() {
        if (!this.m.d || ((Boolean) this.m.k.a()).booleanValue()) {
            return this.m.d;
        }
        return false;
    }

    public final boolean g() {
        if (!this.m.f || ((Boolean) this.m.k.a()).booleanValue()) {
            return this.m.f;
        }
        return false;
    }

    public final boolean h() {
        if (!this.m.i || ((Boolean) this.m.k.a()).booleanValue()) {
            return this.m.i;
        }
        return false;
    }

    public final void a(q qVar) {
        PrivateSpaceMgr.a().a(this.t);
        this.g = true;
        this.j = qVar;
        this.c.e = false;
        this.d.e = false;
        this.e.e = false;
        n.a().a(this);
        this.h = true;
        this.i = true;
    }

    public final void i() {
        this.g = true;
        if (this.h) {
            this.h = false;
            return;
        }
        this.i = true;
        n.a().q();
    }

    public final void j() {
        this.g = false;
        this.j = null;
        PrivateSpaceMgr.a().b(this.t);
        b a = n.a();
        if (a.d != null) {
            a.d.v.b(this);
        }
    }

    private void a(java.util.List<com.xunlei.downloadprovider.download.engine.task.z> r9, boolean r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r9 = r9.iterator();
        r0 = new java.util.ArrayList;
        r0.<init>();
    L_0x0009:
        r1 = r9.hasNext();
        if (r1 == 0) goto L_0x0065;
    L_0x000f:
        r1 = r9.next();
        r1 = (com.xunlei.downloadprovider.download.engine.task.z) r1;
        r2 = r1.a();
        r4 = 0;
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 <= 0) goto L_0x0009;
    L_0x001f:
        r4 = -1;
        r5 = r8.b;
        r6 = java.lang.Long.valueOf(r2);
        r5 = r5.get(r6);
        r5 = (com.xunlei.downloadprovider.download.tasklist.task.s) r5;
        r6 = 1;
        if (r5 != 0) goto L_0x0036;
    L_0x002f:
        r5 = r8.a(r1, r6);
        r7 = r5.b;
        goto L_0x003c;
    L_0x0036:
        r7 = r5.b;
        r4 = r7.getTaskStatus();
    L_0x003c:
        r5.a(r1);
        r1 = r8.b;
        r2 = java.lang.Long.valueOf(r2);
        r1.put(r2, r5);
        r1 = r7.getTaskStatus();
        if (r4 != r1) goto L_0x005c;
    L_0x004e:
        r1 = 8;
        if (r4 == r1) goto L_0x005b;
    L_0x0052:
        r1 = 4;
        if (r4 == r1) goto L_0x005b;
    L_0x0055:
        if (r4 == r6) goto L_0x005b;
    L_0x0057:
        r1 = 16;
        if (r4 != r1) goto L_0x005c;
    L_0x005b:
        r6 = 0;
    L_0x005c:
        if (r6 == 0) goto L_0x0061;
    L_0x005e:
        r5.l();
    L_0x0061:
        r0.add(r5);
        goto L_0x0009;
    L_0x0065:
        r9 = new com.xunlei.downloadprovider.download.tasklist.task.l;
        r9.<init>(r8, r0, r10);
        r10 = r8.k;
        r10 = r10.isAlive();
        if (r10 == 0) goto L_0x0078;
    L_0x0072:
        r10 = r8.k;	 Catch:{ RejectedExecutionException -> 0x0078 }
        r10.execute(r9);	 Catch:{ RejectedExecutionException -> 0x0078 }
        return;
    L_0x0078:
        r9.run();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.task.h.a(java.util.List, boolean):void");
    }

    @NonNull
    private synchronized s a(@NonNull z zVar, boolean z) {
        s sVar;
        sVar = (s) zVar.a(s.class);
        if (sVar == null) {
            sVar = new s(zVar);
        }
        if (z) {
            this.b.put(Long.valueOf(sVar.a()), sVar);
        }
        return sVar;
    }

    public final void d(long j) {
        try {
            Runnable nVar = new n(this);
            if (j > 0) {
                Handler handler = this.k.a;
                if (handler == null) {
                    throw new RejectedExecutionException();
                }
                handler.postDelayed(nVar, j);
                return;
            }
            this.k.execute(nVar);
        } catch (long j2) {
            j2.printStackTrace();
        }
    }

    public final void k() {
        if (this.p <= 0) {
            synchronized (this.q) {
                this.p = 1;
                XLThreadPool.execute(new o(this));
            }
            return;
        }
        this.p++;
    }

    public final void l() {
        this.c.d();
        this.d.d();
        this.e.d();
    }

    public final void d(List<TaskInfo> list) {
        if (!list.isEmpty()) {
            this.c.b((List) list);
            this.d.b((List) list);
            this.e.b((List) list);
        }
    }

    public final void a(Collection<Long> collection) {
        if (collection != null && !collection.isEmpty()) {
            List arrayList = new ArrayList();
            for (Long remove : collection) {
                s sVar = (s) this.b.remove(remove);
                if (sVar != null) {
                    arrayList.add(sVar.b);
                }
            }
            if (!arrayList.isEmpty()) {
                d(arrayList);
            }
            this.c.a((Collection) collection);
            this.d.a((Collection) collection);
            this.e.a((Collection) collection);
        }
    }

    public final void e(long j) {
        j = e().b(j);
        if (j != null) {
            j.c = this;
            n.a();
            n.n(j.a());
        }
    }

    private void m() {
        if (this.c.f) {
            this.c.d.b();
        }
        if (this.d.f) {
            this.d.d.b();
        }
        if (this.e.f) {
            this.e.d.b();
        }
    }

    protected final void a(List<z> list) {
        synchronized (this.s) {
            if (this.r == null) {
                this.r = new ArrayList();
            }
            this.r.clear();
            if (!d.a(list)) {
                this.r.addAll(list);
            }
            e(this.r);
        }
    }

    private static boolean n() {
        if (PrivateSpaceMgr.a().f()) {
            PrivateSpaceMgr.a();
            if (PrivateSpaceMgr.i()) {
                return true;
            }
        }
        return false;
    }

    private void e(List<z> list) {
        List<z> arrayList = new ArrayList(list);
        List arrayList2 = new ArrayList(list.size());
        list = n();
        Collection arrayList3 = new ArrayList(8);
        for (z zVar : arrayList) {
            if (zVar != null) {
                arrayList2.add(zVar);
                TaskInfo c = zVar.c();
                if (c != null && (PrivateSpaceMgr.a().a(c) || c.getCustomFlags() == 300)) {
                    c.setCustomFlags(300);
                    if (list != null) {
                        arrayList3.add(zVar);
                        PrivateSpaceMgr.a().b(c);
                    }
                }
            }
        }
        if (list != null && d.a(arrayList3) == null) {
            arrayList2.removeAll(arrayList3);
        }
        a(arrayList2, this.i);
    }

    static /* synthetic */ void a(h hVar, long j, boolean z, boolean z2, long j2, long j3) {
        boolean z3;
        h hVar2 = hVar;
        long j4 = j;
        long j5 = j2;
        boolean z4 = j5 < 102400;
        boolean z5 = j5 < 51200;
        int i = 400;
        if (a.b) {
            i = a.a;
        } else {
            com.xunlei.downloadprovider.download.c.e.a();
            Object a = com.xunlei.downloadprovider.member.a.a.b.a("netspeed");
            if (!TextUtils.isEmpty(a)) {
                i = Integer.parseInt(a);
                a.a = i;
            }
            a.b = true;
        }
        boolean z6 = j5 > ((long) (i * 1024));
        if (z && z4) {
            a aVar = hVar2.m;
            aVar.g += j4 - hVar2.m.c;
            if (hVar2.m.g >= 10000) {
                hVar2.m.d = true;
            }
        } else {
            hVar2.m.g = 0;
            hVar2.m.d = false;
        }
        if (z && z5) {
            a aVar2 = hVar2.m;
            aVar2.h += j4 - hVar2.m.c;
            if (hVar2.m.h >= 10000) {
                hVar2.m.e = true;
            }
            z3 = false;
        } else {
            hVar2.m.h = 0;
            z3 = false;
            hVar2.m.e = false;
        }
        if (z && z6) {
            z4 = true;
            hVar2.m.f = true;
        } else {
            z4 = true;
            hVar2.m.f = z3;
        }
        hVar2.m.k.a(Boolean.valueOf(z));
        a aVar3 = hVar2.m;
        if (z2 && j3 > 0) {
            z3 = z4;
        }
        aVar3.i = z3;
        hVar2.m.c = j4;
        hVar2.m.j = j5;
    }
}
