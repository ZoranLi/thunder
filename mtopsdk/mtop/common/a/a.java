package mtopsdk.mtop.common.a;

import mtopsdk.mtop.common.b;
import mtopsdk.mtop.common.f;
import mtopsdk.mtop.common.j;
import mtopsdk.mtop.common.k;
import mtopsdk.mtop.domain.MtopResponse;

public class a extends b {
    protected k a = null;
    public MtopResponse b = null;
    public Object c = null;
    protected boolean d = false;

    public a(k kVar) {
        this.a = kVar;
    }

    public void onHeader(j jVar, Object obj) {
        if (this.a instanceof f) {
            ((f) this.a).onHeader(jVar, obj);
        }
    }

    public void onFinished(mtopsdk.mtop.common.i r2, java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        if (r2 == 0) goto L_0x000c;
    L_0x0002:
        r0 = r2.a;
        if (r0 == 0) goto L_0x000c;
    L_0x0006:
        r0 = r2.a;
        r1.b = r0;
        r1.c = r3;
    L_0x000c:
        monitor-enter(r1);
        r1.notifyAll();	 Catch:{ Exception -> 0x0013 }
        goto L_0x0018;
    L_0x0011:
        r2 = move-exception;
        goto L_0x0038;
    L_0x0013:
        r0 = "[onFinished] notify error";	 Catch:{ all -> 0x0011 }
        mtopsdk.common.util.j.e(r0);	 Catch:{ all -> 0x0011 }
    L_0x0018:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        r0 = r1.a;
        r0 = r0 instanceof mtopsdk.mtop.common.e;
        if (r0 == 0) goto L_0x0037;
    L_0x001f:
        r0 = r1.d;
        if (r0 == 0) goto L_0x0030;
    L_0x0023:
        r0 = r1.b;
        if (r0 == 0) goto L_0x002f;
    L_0x0027:
        r0 = r1.b;
        r0 = r0.isApiSuccess();
        if (r0 != 0) goto L_0x0030;
    L_0x002f:
        return;
    L_0x0030:
        r0 = r1.a;
        r0 = (mtopsdk.mtop.common.e) r0;
        r0.onFinished(r2, r3);
    L_0x0037:
        return;
    L_0x0038:
        monitor-exit(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.common.a.a.onFinished(mtopsdk.mtop.common.i, java.lang.Object):void");
    }
}
