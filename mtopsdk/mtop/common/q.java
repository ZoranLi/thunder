package mtopsdk.mtop.common;

import mtopsdk.a.b.e;

final class q implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ Object b;
    final /* synthetic */ o c;

    q(o oVar, e eVar, Object obj) {
        this.c = oVar;
        this.a = eVar;
        this.b = obj;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.c;
        r1 = r11.a;
        r2 = r11.b;
        r3 = r0.c;
        if (r3 != 0) goto L_0x0011;
    L_0x000a:
        r3 = new mtopsdk.mtop.util.h;
        r3.<init>();
        r0.c = r3;
    L_0x0011:
        r3 = r0.c;
        r3.f();
        if (r1 == 0) goto L_0x0025;
    L_0x0018:
        r3 = r0.c;
        r4 = r1.d;
        r3.a(r4);
        r3 = r0.c;
        r4 = r1.a;
        r3.e = r4;
    L_0x0025:
        r3 = r0.c;
        r3 = r3.q;
        r4 = r0.a;
        if (r4 != 0) goto L_0x0033;
    L_0x002d:
        r0 = "[onFinishTask]finishListener is null";
        mtopsdk.common.util.j.e(r3, r0);
        return;
    L_0x0033:
        r4 = r0.d;
        if (r4 != 0) goto L_0x003d;
    L_0x0037:
        r0 = "[onFinishTask]mtopProxy is null";
        mtopsdk.common.util.j.e(r3, r0);
        return;
    L_0x003d:
        r4 = r0.d;
        r4 = r4.g;
        r5 = new mtopsdk.mtop.domain.MtopResponse;
        r6 = r4.getApiName();
        r7 = r4.getVersion();
        r8 = 0;
        r5.<init>(r6, r7, r8, r8);
        r6 = r0.c;
        r5.setMtopStat(r6);
        r6 = new mtopsdk.mtop.common.i;
        r6.<init>(r5);
        if (r1 != 0) goto L_0x0086;
    L_0x005b:
        r1 = "ANDROID_SYS_NETWORK_ERROR";
        r5.setRetCode(r1);
        r1 = "网络错误";
        r5.setRetMsg(r1);
        r1 = r0.c;
        r0.a(r1);
        r0 = r0.a;	 Catch:{ Throwable -> 0x0070 }
        r0.onFinished(r6, r2);	 Catch:{ Throwable -> 0x0070 }
        return;
    L_0x0070:
        r0 = new java.lang.StringBuilder;
        r1 = "[onFinishTask]finishListener error --apiKey=";
        r0.<init>(r1);
        r1 = r4.getKey();
        r0.append(r1);
        r0 = r0.toString();
        mtopsdk.common.util.j.f(r3, r0);
        return;
    L_0x0086:
        r7 = r0.c;
        r7.c();
        r7 = r0.d;
        r8 = new mtopsdk.mtop.common.m;
        r9 = r1.a;
        r10 = r1.b;
        r1 = r1.c;
        r8.<init>(r9, r10, r1);
        r1 = mtopsdk.mtop.common.l.a(r5, r7, r8);
        r6.a = r1;
        r1 = r0.c;
        r1.d();
        r1 = r0.c;
        r5 = r5.getRetCode();
        r1.f = r5;
        r1 = r0.c;
        r0.a(r1);
        r0 = r0.a;	 Catch:{ Throwable -> 0x00b6 }
        r0.onFinished(r6, r2);	 Catch:{ Throwable -> 0x00b6 }
        return;
    L_0x00b6:
        r0 = new java.lang.StringBuilder;
        r1 = "[onFinishTask]finishListener error --apiKey=";
        r0.<init>(r1);
        r1 = r4.getKey();
        r0.append(r1);
        r0 = r0.toString();
        mtopsdk.common.util.j.f(r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.common.q.run():void");
    }
}
