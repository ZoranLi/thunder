package com.igexin.push.core;

import com.igexin.push.config.m;
import com.igexin.push.util.a;

public class i {
    private static i d;
    public long a = 240000;
    private l b = l.DETECT;
    private long c = 0;

    private i() {
    }

    public static i a() {
        if (d == null) {
            d = new i();
        }
        return d;
    }

    private void b(k kVar) {
        l lVar;
        switch (j.b[kVar.ordinal()]) {
            case 1:
                a(Math.min(this.a + 60000, 420000));
                lVar = l.DETECT;
                break;
            case 2:
            case 3:
                this.c++;
                if (this.c >= 2) {
                    a(Math.max(this.a - 60000, 240000));
                    lVar = l.STABLE;
                    break;
                }
                return;
            case 4:
                a(240000);
                a(l.DETECT);
                return;
            default:
                return;
        }
        a(lVar);
    }

    private void c(k kVar) {
        l lVar;
        switch (j.b[kVar.ordinal()]) {
            case 1:
                lVar = l.STABLE;
                break;
            case 2:
            case 3:
                a(Math.max(this.a - 60000, 240000));
                this.c++;
                if (this.c >= 2) {
                    a(240000);
                    lVar = l.PENDING;
                    break;
                }
                return;
            case 4:
                a(240000);
                a(l.DETECT);
                return;
            default:
                return;
        }
        a(lVar);
    }

    private void d(com.igexin.push.core.k r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:9:0x0024 in {2, 4, 5, 7, 8} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = com.igexin.push.core.j.b;
        r3 = r3.ordinal();
        r3 = r0[r3];
        r0 = 240000; // 0x3a980 float:3.36312E-40 double:1.18576E-318;
        switch(r3) {
            case 1: goto L_0x001e;
            case 2: goto L_0x0018;
            case 3: goto L_0x0018;
            case 4: goto L_0x000f;
            default: goto L_0x000e;
        };
    L_0x000e:
        return;
    L_0x000f:
        r2.a(r0);
        r3 = com.igexin.push.core.l.DETECT;
        r2.a(r3);
        return;
    L_0x0018:
        r3 = com.igexin.push.core.l.PENDING;
    L_0x001a:
        r2.a(r3);
        return;
    L_0x001e:
        r2.a(r0);
        r3 = com.igexin.push.core.l.DETECT;
        goto L_0x001a;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.i.d(com.igexin.push.core.k):void");
    }

    public void a(long j) {
        this.a = j;
    }

    public void a(k kVar) {
        switch (j.a[this.b.ordinal()]) {
            case 1:
                b(kVar);
                return;
            case 2:
                c(kVar);
                return;
            case 3:
                d(kVar);
                return;
            default:
                return;
        }
    }

    public void a(l lVar) {
        this.b = lVar;
        this.c = 0;
    }

    public long b() {
        long j = this.a;
        if (m.d > 0) {
            j = (long) (m.d * 1000);
        }
        boolean g = a.g();
        g.h = g;
        long j2 = 3600000;
        if (g) {
            if (g.l) {
                if (f.a().g().a()) {
                    j2 = j;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder("HeartBeatIntervalGenerator|getHeartbeatInterval final interval = ");
        stringBuilder.append(j2);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        return j2;
    }
}
