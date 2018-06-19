package com.tencent.bugly.beta.download;

/* compiled from: BUGLY */
public class c {
    final int a;
    final Object[] b;

    public c(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(int r6, int r7) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.a;	 Catch:{ Exception -> 0x0096 }
        r1 = 1;
        switch(r0) {
            case 1: goto L_0x006c;
            case 2: goto L_0x0009;
            default: goto L_0x0007;
        };	 Catch:{ Exception -> 0x0096 }
    L_0x0007:
        goto L_0x0092;
    L_0x0009:
        r0 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r2 = 0;
        r0 = r0[r2];	 Catch:{ Exception -> 0x0096 }
        r0 = (com.tencent.bugly.beta.download.DownloadTask) r0;	 Catch:{ Exception -> 0x0096 }
        r3 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r4 = 2;
        r3 = r3[r4];	 Catch:{ Exception -> 0x0096 }
        r3 = (com.tencent.bugly.beta.ui.f) r3;	 Catch:{ Exception -> 0x0096 }
        if (r7 != r1) goto L_0x0030;
    L_0x0019:
        r0.download();	 Catch:{ Exception -> 0x0096 }
        r6 = "continue download";
        r7 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0096 }
        com.tencent.bugly.proguard.an.c(r6, r7);	 Catch:{ Exception -> 0x0096 }
        r6 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r7 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0096 }
        r6[r1] = r7;	 Catch:{ Exception -> 0x0096 }
        r3.a();	 Catch:{ Exception -> 0x0096 }
        monitor-exit(r5);
        return;
    L_0x0030:
        if (r6 == r1) goto L_0x003e;
    L_0x0032:
        r6 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r6 = r6[r1];	 Catch:{ Exception -> 0x0096 }
        r6 = (java.lang.Boolean) r6;	 Catch:{ Exception -> 0x0096 }
        r6 = r6.booleanValue();	 Catch:{ Exception -> 0x0096 }
        if (r6 == 0) goto L_0x0092;
    L_0x003e:
        r0.stop();	 Catch:{ Exception -> 0x0096 }
        r6 = "wifi network change to mobile network, stop download";
        r7 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0096 }
        com.tencent.bugly.proguard.an.c(r6, r7);	 Catch:{ Exception -> 0x0096 }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0096 }
        r6 = r6.S;	 Catch:{ Exception -> 0x0096 }
        if (r6 != 0) goto L_0x0092;
    L_0x004e:
        r6 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r7 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x0096 }
        r6[r1] = r7;	 Catch:{ Exception -> 0x0096 }
        r6 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0096 }
        r6 = r6.s;	 Catch:{ Exception -> 0x0096 }
        r6 = com.tencent.bugly.crashreport.common.info.b.f(r6);	 Catch:{ Exception -> 0x0096 }
        if (r6 == 0) goto L_0x0092;
    L_0x0060:
        com.tencent.bugly.beta.ui.g.a(r3, r1);	 Catch:{ Exception -> 0x0096 }
        r6 = r5.b;	 Catch:{ Exception -> 0x0096 }
        r7 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0096 }
        r6[r1] = r7;	 Catch:{ Exception -> 0x0096 }
        goto L_0x0092;
    L_0x006c:
        if (r7 == r1) goto L_0x0073;
    L_0x006e:
        switch(r7) {
            case 3: goto L_0x0073;
            case 4: goto L_0x0073;
            default: goto L_0x0071;
        };
    L_0x0071:
        monitor-exit(r5);
        return;
    L_0x0073:
        r6 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0096 }
        r6 = r6.a();	 Catch:{ Exception -> 0x0096 }
        r6 = (java.util.ArrayList) r6;	 Catch:{ Exception -> 0x0096 }
        if (r6 == 0) goto L_0x0090;
    L_0x007d:
        r7 = r6.isEmpty();	 Catch:{ Exception -> 0x0096 }
        if (r7 == 0) goto L_0x0084;
    L_0x0083:
        goto L_0x0090;
    L_0x0084:
        r7 = com.tencent.bugly.beta.upgrade.b.a;	 Catch:{ Exception -> 0x0096 }
        r0 = new com.tencent.bugly.proguard.x;	 Catch:{ Exception -> 0x0096 }
        r0.<init>(r6);	 Catch:{ Exception -> 0x0096 }
        r7.a(r0, r1);	 Catch:{ Exception -> 0x0096 }
        monitor-exit(r5);
        return;
    L_0x0090:
        monitor-exit(r5);
        return;
    L_0x0092:
        monitor-exit(r5);
        return;
    L_0x0094:
        r6 = move-exception;
        goto L_0x00a2;
    L_0x0096:
        r6 = move-exception;
        r7 = com.tencent.bugly.proguard.an.b(r6);	 Catch:{ all -> 0x0094 }
        if (r7 != 0) goto L_0x00a0;
    L_0x009d:
        r6.printStackTrace();	 Catch:{ all -> 0x0094 }
    L_0x00a0:
        monitor-exit(r5);
        return;
    L_0x00a2:
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.download.c.a(int, int):void");
    }
}
