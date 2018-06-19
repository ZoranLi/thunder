package com.xunlei.tdlive.util;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: TSimpleListener */
public class k<T> {
    private ConcurrentHashMap<T, Boolean> a;
    private HashSet<T> b;

    /* compiled from: TSimpleListener */
    public interface a<T> {
        void a(T t, Object... objArr);
    }

    public synchronized void a(T t) {
        a((Object) t, false);
    }

    public synchronized void a(T t, boolean z) {
        if (t != null) {
            if (this.a == null) {
                this.a = new ConcurrentHashMap();
            }
            this.a.put(t, Boolean.valueOf(z));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(T r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.a;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0017;
    L_0x0005:
        if (r2 == 0) goto L_0x0017;
    L_0x0007:
        r0 = r1.b;	 Catch:{ all -> 0x0019 }
        if (r0 == 0) goto L_0x0012;
    L_0x000b:
        r0 = r1.b;	 Catch:{ all -> 0x0019 }
        r0.add(r2);	 Catch:{ all -> 0x0019 }
        monitor-exit(r1);
        return;
    L_0x0012:
        r0 = r1.a;	 Catch:{ all -> 0x0019 }
        r0.remove(r2);	 Catch:{ all -> 0x0019 }
    L_0x0017:
        monitor-exit(r1);
        return;
    L_0x0019:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.k.b(java.lang.Object):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.xunlei.tdlive.util.k.a<T> r4, java.lang.Object... r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.a;	 Catch:{ all -> 0x0060 }
        if (r0 == 0) goto L_0x005e;
    L_0x0005:
        if (r4 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x005e;
    L_0x0008:
        r0 = new java.util.HashSet;	 Catch:{ all -> 0x0060 }
        r0.<init>();	 Catch:{ all -> 0x0060 }
        r3.b = r0;	 Catch:{ all -> 0x0060 }
        r0 = r3.a;	 Catch:{ all -> 0x0060 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0060 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0060 }
    L_0x0019:
        r1 = r0.hasNext();	 Catch:{ all -> 0x0060 }
        if (r1 == 0) goto L_0x003e;
    L_0x001f:
        r1 = r0.next();	 Catch:{ all -> 0x0060 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ all -> 0x0060 }
        r2 = r1.getKey();	 Catch:{ all -> 0x0060 }
        r4.a(r2, r5);	 Catch:{ all -> 0x0060 }
        r1 = r1.getValue();	 Catch:{ all -> 0x0060 }
        r1 = (java.lang.Boolean) r1;	 Catch:{ all -> 0x0060 }
        r1 = r1.booleanValue();	 Catch:{ all -> 0x0060 }
        if (r1 == 0) goto L_0x0019;
    L_0x0038:
        r1 = r3.b;	 Catch:{ all -> 0x0060 }
        r1.add(r2);	 Catch:{ all -> 0x0060 }
        goto L_0x0019;
    L_0x003e:
        r4 = r3.b;	 Catch:{ all -> 0x0060 }
        r4 = r4.iterator();	 Catch:{ all -> 0x0060 }
    L_0x0044:
        r5 = r4.hasNext();	 Catch:{ all -> 0x0060 }
        if (r5 == 0) goto L_0x0054;
    L_0x004a:
        r5 = r4.next();	 Catch:{ all -> 0x0060 }
        r0 = r3.a;	 Catch:{ all -> 0x0060 }
        r0.remove(r5);	 Catch:{ all -> 0x0060 }
        goto L_0x0044;
    L_0x0054:
        r4 = r3.b;	 Catch:{ all -> 0x0060 }
        r4.clear();	 Catch:{ all -> 0x0060 }
        r4 = 0;
        r3.b = r4;	 Catch:{ all -> 0x0060 }
        monitor-exit(r3);
        return;
    L_0x005e:
        monitor-exit(r3);
        return;
    L_0x0060:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.k.a(com.xunlei.tdlive.util.k$a, java.lang.Object[]):void");
    }
}
