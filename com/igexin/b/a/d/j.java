package com.igexin.b.a.d;

final class j extends Thread {
    volatile boolean a = true;
    g b;
    final /* synthetic */ f c;

    public j(f fVar) {
        this.c = fVar;
        setName("TS-processor");
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r0 = -2;
        android.os.Process.setThreadPriority(r0);
        r0 = r9.c;
        r0 = r0.k;
        r1 = 0;
        r2 = 1;
    L_0x000a:
        r4 = r1;
    L_0x000b:
        r3 = r2;
    L_0x000c:
        r5 = r9.a;
        if (r5 == 0) goto L_0x0252;
    L_0x0010:
        switch(r3) {
            case -1: goto L_0x0014;
            case 0: goto L_0x00b6;
            case 1: goto L_0x01b3;
            case 2: goto L_0x01c9;
            default: goto L_0x0013;
        };
    L_0x0013:
        goto L_0x000c;
    L_0x0014:
        r4.d();	 Catch:{ Exception -> 0x023a }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x023a }
        r5 = "TaskService|TASK_INIT|initTask =";	 Catch:{ Exception -> 0x023a }
        r3.<init>(r5);	 Catch:{ Exception -> 0x023a }
        r5 = r4.getClass();	 Catch:{ Exception -> 0x023a }
        r5 = r5.getName();	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = "@";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = r4.hashCode();	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = "|isBlock = ";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = r4.q();	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = "|isCycle = ";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = r4.o;	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = "|doTime = ";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = r4.u;	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x023a }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Exception -> 0x023a }
        r3 = r4.q();	 Catch:{ Exception -> 0x023a }
        if (r3 == 0) goto L_0x0092;	 Catch:{ Exception -> 0x023a }
    L_0x0062:
        r3 = r9.b;	 Catch:{ Exception -> 0x023a }
        if (r3 != 0) goto L_0x006f;	 Catch:{ Exception -> 0x023a }
    L_0x0066:
        r3 = new com.igexin.b.a.d.g;	 Catch:{ Exception -> 0x023a }
        r5 = r9.c;	 Catch:{ Exception -> 0x023a }
        r3.<init>(r5);	 Catch:{ Exception -> 0x023a }
        r9.b = r3;	 Catch:{ Exception -> 0x023a }
    L_0x006f:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x023a }
        r3.<init>();	 Catch:{ Exception -> 0x023a }
        r5 = r4.getClass();	 Catch:{ Exception -> 0x023a }
        r5 = r5.getName();	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r5 = " is a block task!";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x023a }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Exception -> 0x023a }
        r3 = r9.b;	 Catch:{ Exception -> 0x023a }
        r3.a(r4);	 Catch:{ Exception -> 0x023a }
        goto L_0x000a;	 Catch:{ Exception -> 0x023a }
    L_0x0092:
        r3 = r4.o;	 Catch:{ Exception -> 0x023a }
        if (r3 == 0) goto L_0x00b6;	 Catch:{ Exception -> 0x023a }
    L_0x0096:
        r5 = r4.u;	 Catch:{ Exception -> 0x023a }
        r7 = 0;	 Catch:{ Exception -> 0x023a }
        r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));	 Catch:{ Exception -> 0x023a }
        if (r3 != 0) goto L_0x00b6;	 Catch:{ Exception -> 0x023a }
    L_0x009e:
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x023a }
        r5 = "TaskService|";	 Catch:{ Exception -> 0x023a }
        r3.<init>(r5);	 Catch:{ Exception -> 0x023a }
        r3.append(r4);	 Catch:{ Exception -> 0x023a }
        r5 = "|isBlock = false|cycyle = true|doTime = 0, invalid ###########";	 Catch:{ Exception -> 0x023a }
        r3.append(r5);	 Catch:{ Exception -> 0x023a }
        r3 = r3.toString();	 Catch:{ Exception -> 0x023a }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Exception -> 0x023a }
        goto L_0x000b;
    L_0x00b6:
        r3 = 0;
        r4.b_();	 Catch:{ Exception -> 0x0130 }
        r4.t();	 Catch:{ Exception -> 0x0130 }
        r4.v();	 Catch:{ Exception -> 0x0130 }
        r5 = r9.c;
        r5.g();
        r5 = new java.lang.StringBuilder;
        r6 = "TaskService|SERVICE_PROCESSING|finally|hasError = ";
        r5.<init>(r6);
        r6 = r4.t;
        r5.append(r6);
        r6 = "|isDone = ";
        r5.append(r6);
        r6 = r4.s();
        r5.append(r6);
        r6 = "|isPending = ";
        r5.append(r6);
        r6 = r4.p;
        r5.append(r6);
        r6 = "|isCycle = ";
        r5.append(r6);
        r6 = r4.o;
        r5.append(r6);
        r6 = "|isBlcok = ";
        r5.append(r6);
        r6 = r4.q();
        r5.append(r6);
        r5 = r5.toString();
        com.igexin.b.a.c.a.b(r5);
        r5 = r4.t;
        if (r5 != 0) goto L_0x010b;
    L_0x0108:
        r4.c();
    L_0x010b:
        r5 = r4.k;
        if (r5 != 0) goto L_0x0129;
    L_0x010f:
        r5 = r4.p;
        if (r5 != 0) goto L_0x0129;
    L_0x0113:
        r5 = new java.lang.StringBuilder;
        r6 = "TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = ";
        r5.<init>(r6);
    L_0x011a:
        r5.append(r4);
        r5 = r5.toString();
        com.igexin.b.a.c.a.b(r5);
        r4.A = r3;
        r0.a(r4);
    L_0x0129:
        r4 = r1;
        r3 = r2;
        goto L_0x01b3;
    L_0x012d:
        r1 = move-exception;
        goto L_0x01d0;
    L_0x0130:
        r5 = move-exception;
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x012d }
        r7 = "TaskService|SERVICE_PROCESSING|error|";	 Catch:{ all -> 0x012d }
        r6.<init>(r7);	 Catch:{ all -> 0x012d }
        r7 = r5.toString();	 Catch:{ all -> 0x012d }
        r6.append(r7);	 Catch:{ all -> 0x012d }
        r6 = r6.toString();	 Catch:{ all -> 0x012d }
        com.igexin.b.a.c.a.b(r6);	 Catch:{ all -> 0x012d }
        r4.t = r2;	 Catch:{ all -> 0x012d }
        r4.B = r5;	 Catch:{ all -> 0x012d }
        r4.w();	 Catch:{ all -> 0x012d }
        r4.p();	 Catch:{ all -> 0x012d }
        r5 = r9.c;	 Catch:{ all -> 0x012d }
        r5 = r5.j;	 Catch:{ all -> 0x012d }
        r5.a(r4);	 Catch:{ all -> 0x012d }
        r5 = r9.c;
        r5.g();
        r5 = new java.lang.StringBuilder;
        r6 = "TaskService|SERVICE_PROCESSING|finally|hasError = ";
        r5.<init>(r6);
        r6 = r4.t;
        r5.append(r6);
        r6 = "|isDone = ";
        r5.append(r6);
        r6 = r4.s();
        r5.append(r6);
        r6 = "|isPending = ";
        r5.append(r6);
        r6 = r4.p;
        r5.append(r6);
        r6 = "|isCycle = ";
        r5.append(r6);
        r6 = r4.o;
        r5.append(r6);
        r6 = "|isBlcok = ";
        r5.append(r6);
        r6 = r4.q();
        r5.append(r6);
        r5 = r5.toString();
        com.igexin.b.a.c.a.b(r5);
        r5 = r4.t;
        if (r5 != 0) goto L_0x01a2;
    L_0x019f:
        r4.c();
    L_0x01a2:
        r5 = r4.k;
        if (r5 != 0) goto L_0x0129;
    L_0x01a6:
        r5 = r4.p;
        if (r5 != 0) goto L_0x0129;
    L_0x01aa:
        r5 = new java.lang.StringBuilder;
        r6 = "TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = ";
        r5.<init>(r6);
        goto L_0x011a;
    L_0x01b3:
        r5 = r0.c();	 Catch:{ InterruptedException -> 0x01b8 }
        r4 = r5;
    L_0x01b8:
        if (r4 == 0) goto L_0x01c9;
    L_0x01ba:
        r5 = r4.k;
        if (r5 != 0) goto L_0x01c6;
    L_0x01be:
        r5 = r4.m;
        if (r5 == 0) goto L_0x01c3;
    L_0x01c2:
        goto L_0x01c6;
    L_0x01c3:
        r3 = -1;
        goto L_0x000c;
    L_0x01c6:
        r4 = r1;
        goto L_0x000c;
    L_0x01c9:
        r3 = r9.c;
        r3.g();
        goto L_0x000b;
    L_0x01d0:
        r2 = r9.c;
        r2.g();
        r2 = new java.lang.StringBuilder;
        r5 = "TaskService|SERVICE_PROCESSING|finally|hasError = ";
        r2.<init>(r5);
        r5 = r4.t;
        r2.append(r5);
        r5 = "|isDone = ";
        r2.append(r5);
        r5 = r4.s();
        r2.append(r5);
        r5 = "|isPending = ";
        r2.append(r5);
        r5 = r4.p;
        r2.append(r5);
        r5 = "|isCycle = ";
        r2.append(r5);
        r5 = r4.o;
        r2.append(r5);
        r5 = "|isBlcok = ";
        r2.append(r5);
        r5 = r4.q();
        r2.append(r5);
        r2 = r2.toString();
        com.igexin.b.a.c.a.b(r2);
        r2 = r4.t;
        if (r2 != 0) goto L_0x021b;
    L_0x0218:
        r4.c();
    L_0x021b:
        r2 = r4.k;
        if (r2 != 0) goto L_0x0239;
    L_0x021f:
        r2 = r4.p;
        if (r2 != 0) goto L_0x0239;
    L_0x0223:
        r2 = new java.lang.StringBuilder;
        r5 = "TaskService|SERVICE_PROCESSING|finally|mainQueue.offer task = ";
        r2.<init>(r5);
        r2.append(r4);
        r2 = r2.toString();
        com.igexin.b.a.c.a.b(r2);
        r4.A = r3;
        r0.a(r4);
    L_0x0239:
        throw r1;
    L_0x023a:
        r3 = move-exception;
        r5 = new java.lang.StringBuilder;
        r6 = "TaskService|TASK_INIT|error|";
        r5.<init>(r6);
        r3 = r3.toString();
        r5.append(r3);
        r3 = r5.toString();
        com.igexin.b.a.c.a.b(r3);
        goto L_0x000b;
    L_0x0252:
        r0.d();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.j.run():void");
    }
}
