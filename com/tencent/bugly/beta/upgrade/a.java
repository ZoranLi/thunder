package com.tencent.bugly.beta.upgrade;

import com.tencent.bugly.proguard.aj;

/* compiled from: BUGLY */
public class a implements aj {
    public final int a;
    public final int b;
    public final Object[] c;
    public boolean d = false;

    public void a(int i) {
    }

    public a(int i, int i2, Object... objArr) {
        this.a = i;
        this.b = i2;
        this.c = objArr;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(int r18, com.tencent.bugly.proguard.be r19, long r20, long r22, boolean r24, java.lang.String r25) {
        /*
        r17 = this;
        r1 = r17;
        r2 = r19;
        monitor-enter(r17);
        r4 = r1.d;	 Catch:{ Exception -> 0x0126 }
        if (r4 != 0) goto L_0x0121;
    L_0x0009:
        r4 = r1.b;	 Catch:{ Exception -> 0x0126 }
        r5 = r18;
        if (r5 != r4) goto L_0x0121;
    L_0x000f:
        r4 = "upload %s:[%d] [sended %d] [recevied %d]";
        r6 = 4;
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x0126 }
        if (r24 == 0) goto L_0x0019;
    L_0x0016:
        r7 = "succ";
        goto L_0x001b;
    L_0x0019:
        r7 = "err";
    L_0x001b:
        r8 = 0;
        r6[r8] = r7;	 Catch:{ Exception -> 0x0126 }
        r5 = java.lang.Integer.valueOf(r18);	 Catch:{ Exception -> 0x0126 }
        r7 = 1;
        r6[r7] = r5;	 Catch:{ Exception -> 0x0126 }
        r5 = java.lang.Long.valueOf(r20);	 Catch:{ Exception -> 0x0126 }
        r9 = 2;
        r6[r9] = r5;	 Catch:{ Exception -> 0x0126 }
        r5 = java.lang.Long.valueOf(r22);	 Catch:{ Exception -> 0x0126 }
        r10 = 3;
        r6[r10] = r5;	 Catch:{ Exception -> 0x0126 }
        com.tencent.bugly.proguard.an.a(r4, r6);	 Catch:{ Exception -> 0x0126 }
        r4 = r1.a;	 Catch:{ Exception -> 0x0126 }
        switch(r4) {
            case 1: goto L_0x0063;
            case 2: goto L_0x003d;
            default: goto L_0x003b;
        };	 Catch:{ Exception -> 0x0126 }
    L_0x003b:
        goto L_0x011f;
    L_0x003d:
        r4 = r1.b;	 Catch:{ Exception -> 0x0126 }
        r5 = 803; // 0x323 float:1.125E-42 double:3.967E-321;
        if (r4 == r5) goto L_0x0045;
    L_0x0043:
        monitor-exit(r17);
        return;
    L_0x0045:
        if (r24 == 0) goto L_0x011f;
    L_0x0047:
        if (r2 == 0) goto L_0x005c;
    L_0x0049:
        r2 = r2.c;	 Catch:{ Exception -> 0x0126 }
        r3 = com.tencent.bugly.proguard.aa.class;
        r2 = com.tencent.bugly.proguard.ah.a(r2, r3);	 Catch:{ Exception -> 0x0126 }
        r2 = (com.tencent.bugly.proguard.aa) r2;	 Catch:{ Exception -> 0x0126 }
        if (r2 == 0) goto L_0x005c;
    L_0x0055:
        r3 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        r2 = r2.a;	 Catch:{ Exception -> 0x0126 }
        r3.a(r2);	 Catch:{ Exception -> 0x0126 }
    L_0x005c:
        r2 = com.tencent.bugly.proguard.p.a;	 Catch:{ Exception -> 0x0126 }
        r2.b();	 Catch:{ Exception -> 0x0126 }
        goto L_0x011f;
    L_0x0063:
        r4 = r1.c;	 Catch:{ Exception -> 0x0126 }
        r4 = r4[r8];	 Catch:{ Exception -> 0x0126 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0126 }
        r12 = r4.booleanValue();	 Catch:{ Exception -> 0x0126 }
        r4 = r1.c;	 Catch:{ Exception -> 0x0126 }
        r4 = r4[r7];	 Catch:{ Exception -> 0x0126 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ Exception -> 0x0126 }
        r13 = r4.booleanValue();	 Catch:{ Exception -> 0x0126 }
        r4 = r1.b;	 Catch:{ Exception -> 0x0126 }
        r5 = 804; // 0x324 float:1.127E-42 double:3.97E-321;
        if (r4 == r5) goto L_0x007f;
    L_0x007d:
        monitor-exit(r17);
        return;
    L_0x007f:
        r4 = 0;
        if (r24 == 0) goto L_0x0096;
    L_0x0082:
        if (r2 == 0) goto L_0x0096;
    L_0x0084:
        r2 = r2.c;	 Catch:{ Exception -> 0x0126 }
        r5 = com.tencent.bugly.proguard.aa.class;
        r2 = com.tencent.bugly.proguard.ah.a(r2, r5);	 Catch:{ Exception -> 0x0126 }
        r2 = (com.tencent.bugly.proguard.aa) r2;	 Catch:{ Exception -> 0x0126 }
        if (r2 == 0) goto L_0x0096;
    L_0x0090:
        r5 = r2.a;	 Catch:{ Exception -> 0x0126 }
        r2 = r2.b;	 Catch:{ Exception -> 0x0126 }
        r15 = r2;
        goto L_0x0098;
    L_0x0096:
        r5 = r4;
        r15 = r5;
    L_0x0098:
        r2 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        r2.a(r5);	 Catch:{ Exception -> 0x0126 }
        r2 = r1.c;	 Catch:{ Exception -> 0x0126 }
        r2 = r2[r9];	 Catch:{ Exception -> 0x0126 }
        r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2;	 Catch:{ Exception -> 0x0126 }
        if (r15 == 0) goto L_0x00a7;
    L_0x00a5:
        r4 = r15;
        goto L_0x00ab;
    L_0x00a7:
        if (r2 == 0) goto L_0x00ab;
    L_0x00a9:
        r4 = r2.a;	 Catch:{ Exception -> 0x0126 }
    L_0x00ab:
        r2 = -1;
        if (r4 == 0) goto L_0x0112;
    L_0x00ae:
        r4 = r4.p;	 Catch:{ Exception -> 0x0126 }
        switch(r4) {
            case 1: goto L_0x00fb;
            case 2: goto L_0x011f;
            case 3: goto L_0x00b6;
            default: goto L_0x00b3;
        };	 Catch:{ Exception -> 0x0126 }
    L_0x00b3:
        r2 = "unexpected updatetype";
        goto L_0x010c;
    L_0x00b6:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0126 }
        r4.ac = r10;	 Catch:{ Exception -> 0x0126 }
        r4 = com.tencent.bugly.proguard.q.a;	 Catch:{ Exception -> 0x0126 }
        if (r24 == 0) goto L_0x00bf;
    L_0x00be:
        r2 = r8;
    L_0x00bf:
        r4.a(r2, r15, r8);	 Catch:{ Exception -> 0x0126 }
        r2 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        r2 = r2.f;	 Catch:{ Exception -> 0x0126 }
        if (r2 == 0) goto L_0x00e7;
    L_0x00c8:
        r2 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0126 }
        r3 = 18;
        r4 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0126 }
        r5 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        r5 = r5.f;	 Catch:{ Exception -> 0x0126 }
        r4[r8] = r5;	 Catch:{ Exception -> 0x0126 }
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0126 }
        r4[r7] = r5;	 Catch:{ Exception -> 0x0126 }
        r5 = java.lang.Boolean.valueOf(r12);	 Catch:{ Exception -> 0x0126 }
        r4[r9] = r5;	 Catch:{ Exception -> 0x0126 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0126 }
        com.tencent.bugly.beta.utils.e.a(r2);	 Catch:{ Exception -> 0x0126 }
        goto L_0x011f;
    L_0x00e7:
        if (r12 == 0) goto L_0x011f;
    L_0x00e9:
        if (r13 != 0) goto L_0x011f;
    L_0x00eb:
        r2 = new com.tencent.bugly.beta.global.d;	 Catch:{ Exception -> 0x0126 }
        r3 = 5;
        r4 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0126 }
        r5 = com.tencent.bugly.beta.Beta.strToastYourAreTheLatestVersion;	 Catch:{ Exception -> 0x0126 }
        r4[r8] = r5;	 Catch:{ Exception -> 0x0126 }
        r2.<init>(r3, r4);	 Catch:{ Exception -> 0x0126 }
        com.tencent.bugly.beta.utils.e.a(r2);	 Catch:{ Exception -> 0x0126 }
        goto L_0x011f;
    L_0x00fb:
        r11 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        if (r24 == 0) goto L_0x0101;
    L_0x00ff:
        r14 = r8;
        goto L_0x0102;
    L_0x0101:
        r14 = r2;
    L_0x0102:
        r16 = r25;
        r11.a(r12, r13, r14, r15, r16);	 Catch:{ Exception -> 0x0126 }
        r2 = com.tencent.bugly.beta.global.e.E;	 Catch:{ Exception -> 0x0126 }
        r2.ac = r7;	 Catch:{ Exception -> 0x0126 }
        goto L_0x011f;
    L_0x010c:
        r3 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0126 }
        com.tencent.bugly.proguard.an.a(r2, r3);	 Catch:{ Exception -> 0x0126 }
        goto L_0x011f;
    L_0x0112:
        r11 = com.tencent.bugly.beta.upgrade.c.a;	 Catch:{ Exception -> 0x0126 }
        if (r24 == 0) goto L_0x0118;
    L_0x0116:
        r14 = r8;
        goto L_0x0119;
    L_0x0118:
        r14 = r2;
    L_0x0119:
        r15 = 0;
        r16 = r25;
        r11.a(r12, r13, r14, r15, r16);	 Catch:{ Exception -> 0x0126 }
    L_0x011f:
        r1.d = r7;	 Catch:{ Exception -> 0x0126 }
    L_0x0121:
        monitor-exit(r17);
        return;
    L_0x0123:
        r0 = move-exception;
        r2 = r0;
        goto L_0x0133;
    L_0x0126:
        r0 = move-exception;
        r2 = r0;
        r3 = com.tencent.bugly.proguard.an.b(r2);	 Catch:{ all -> 0x0123 }
        if (r3 != 0) goto L_0x0131;
    L_0x012e:
        r2.printStackTrace();	 Catch:{ all -> 0x0123 }
    L_0x0131:
        monitor-exit(r17);
        return;
    L_0x0133:
        monitor-exit(r17);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.upgrade.a.a(int, com.tencent.bugly.proguard.be, long, long, boolean, java.lang.String):void");
    }
}
