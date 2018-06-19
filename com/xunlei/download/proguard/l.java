package com.xunlei.download.proguard;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"UseSparseArrays"})
/* compiled from: HighSpeedTrialHelper */
public class l {
    private static final String a = "HighSpeedTrialHelper";
    private static l b;
    private Map<Long, b> c = new HashMap();
    private volatile boolean d = false;

    /* compiled from: HighSpeedTrialHelper */
    public enum a {
        QUERY_RESOURCE,
        QUERY_TRIAL,
        ENTER_TRIAL
    }

    /* compiled from: HighSpeedTrialHelper */
    class b {
        int a = -1;
        int b = -1;
        int c = -1;
        a d = a.QUERY_RESOURCE;
        Object e = null;
        final /* synthetic */ l f;

        b(l lVar) {
            this.f = lVar;
        }
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = new l();
            }
            lVar = b;
        }
        return lVar;
    }

    private b a(long j, a aVar) {
        b bVar = (b) this.c.get(Long.valueOf(j));
        if (bVar == null) {
            bVar = new b(this);
            this.c.put(Long.valueOf(j), bVar);
        }
        if (aVar.ordinal() > bVar.d.ordinal()) {
            bVar.d = aVar;
            j = a;
            StringBuilder stringBuilder = new StringBuilder("setCommand = ");
            stringBuilder.append(aVar);
            an.b(j, stringBuilder.toString());
        }
        return bVar;
    }

    public int a(long j) {
        if (!this.d) {
            return -1;
        }
        synchronized (this.c) {
            j = a(j, a.QUERY_RESOURCE).a;
        }
        return j;
    }

    public int b(long j) {
        if (!this.d) {
            return -1;
        }
        synchronized (this.c) {
            j = a(j, a.QUERY_TRIAL).b;
        }
        return j;
    }

    public void c(long j) {
        if (this.d) {
            synchronized (this.c) {
                a(j, a.ENTER_TRIAL);
            }
        }
    }

    public void d(long j) {
        if (this.d) {
            synchronized (this.c) {
                this.c.remove(Long.valueOf(j));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(long r4) {
        /*
        r3 = this;
        r0 = r3.d;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = r3.c;
        monitor-enter(r0);
        r2 = r3.c;	 Catch:{ all -> 0x0022 }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ all -> 0x0022 }
        r4 = r2.get(r4);	 Catch:{ all -> 0x0022 }
        r4 = (com.xunlei.download.proguard.l.b) r4;	 Catch:{ all -> 0x0022 }
        if (r4 == 0) goto L_0x0020;
    L_0x0017:
        r4 = r4.d;	 Catch:{ all -> 0x0022 }
        r5 = com.xunlei.download.proguard.l.a.ENTER_TRIAL;	 Catch:{ all -> 0x0022 }
        if (r4 != r5) goto L_0x001e;
    L_0x001d:
        r1 = 1;
    L_0x001e:
        monitor-exit(r0);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0020:
        monitor-exit(r0);	 Catch:{ all -> 0x0022 }
        return r1;
    L_0x0022:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0022 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.l.e(long):boolean");
    }

    public void a(long j, boolean z) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar != null) {
                if (z) {
                    bVar.a = 1;
                } else {
                    bVar.a = 0;
                }
            }
        }
    }

    public void a(long j, int i) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar != null) {
                bVar.b = i;
            }
        }
    }

    public void b(long j, int i) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar != null) {
                bVar.c = i;
            }
        }
    }

    public int f(long j) {
        if (!this.d) {
            return -1;
        }
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            j = bVar != null ? bVar.c : -1;
        }
        if (j != null) {
            if (j != -1) {
                j -= (int) (SystemClock.elapsedRealtime() / 1000);
                return j < null ? 0 : j;
            }
        }
        return j;
    }

    public void a(long j, Object obj) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar != null) {
                bVar.e = obj;
            }
        }
    }

    public Object g(long j) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar != null) {
                j = bVar.e;
                return j;
            }
            return 0;
        }
    }

    public a h(long j) {
        synchronized (this.c) {
            b bVar = (b) this.c.get(Long.valueOf(j));
            if (bVar == null) {
                an.b(a, "getCommand = null");
                return 0;
            }
            String str = a;
            StringBuilder stringBuilder = new StringBuilder("getCommand = ");
            stringBuilder.append(bVar.d);
            stringBuilder.append(", id=");
            stringBuilder.append(j);
            an.b(str, stringBuilder.toString());
            j = bVar.d;
            return j;
        }
    }

    public boolean i(long j) {
        synchronized (this.c) {
            this.c.remove(Long.valueOf(j));
        }
        return 1;
    }

    public void a(boolean z) {
        if (!z) {
            synchronized (this.c) {
                this.c.clear();
            }
        }
        this.d = z;
    }

    public boolean b() {
        return this.d;
    }
}
