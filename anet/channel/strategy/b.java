package anet.channel.strategy;

/* compiled from: Taobao */
class b implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Object b;
    final /* synthetic */ a c;

    b(a aVar, String str, Object obj) {
        this.c = aVar;
        this.a = str;
        this.b = obj;
    }

    public void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r14 = this;
        r0 = 0;
        r1 = 0;
        r2 = 2;
        r3 = 1;
        r4 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r4 = java.net.InetAddress.getByName(r4);	 Catch:{ Exception -> 0x00d7 }
        r4 = r4.getHostAddress();	 Catch:{ Exception -> 0x00d7 }
        r5 = anet.channel.strategy.utils.d.a(r4);	 Catch:{ Exception -> 0x00d7 }
        if (r5 == 0) goto L_0x00ab;	 Catch:{ Exception -> 0x00d7 }
    L_0x0014:
        r5 = anet.channel.strategy.StrategyTemplate.getInstance();	 Catch:{ Exception -> 0x00d7 }
        r6 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r7 = r5.getConnProtocol(r6);	 Catch:{ Exception -> 0x00d7 }
        r12 = new java.util.LinkedList;	 Catch:{ Exception -> 0x00d7 }
        r12.<init>();	 Catch:{ Exception -> 0x00d7 }
        if (r7 == 0) goto L_0x005e;	 Catch:{ Exception -> 0x00d7 }
    L_0x0025:
        r5 = r7.protocol;	 Catch:{ Exception -> 0x00d7 }
        r6 = "https";	 Catch:{ Exception -> 0x00d7 }
        r5 = r5.equalsIgnoreCase(r6);	 Catch:{ Exception -> 0x00d7 }
        if (r5 != 0) goto L_0x003a;	 Catch:{ Exception -> 0x00d7 }
    L_0x002f:
        r5 = r7.publicKey;	 Catch:{ Exception -> 0x00d7 }
        r5 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x00d7 }
        if (r5 != 0) goto L_0x0038;	 Catch:{ Exception -> 0x00d7 }
    L_0x0037:
        goto L_0x003a;	 Catch:{ Exception -> 0x00d7 }
    L_0x0038:
        r5 = r1;	 Catch:{ Exception -> 0x00d7 }
        goto L_0x003b;	 Catch:{ Exception -> 0x00d7 }
    L_0x003a:
        r5 = r3;	 Catch:{ Exception -> 0x00d7 }
    L_0x003b:
        if (r5 != 0) goto L_0x0041;	 Catch:{ Exception -> 0x00d7 }
    L_0x003d:
        r5 = 80;	 Catch:{ Exception -> 0x00d7 }
    L_0x003f:
        r6 = r5;	 Catch:{ Exception -> 0x00d7 }
        goto L_0x0044;	 Catch:{ Exception -> 0x00d7 }
    L_0x0041:
        r5 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;	 Catch:{ Exception -> 0x00d7 }
        goto L_0x003f;	 Catch:{ Exception -> 0x00d7 }
    L_0x0044:
        r8 = 0;	 Catch:{ Exception -> 0x00d7 }
        r9 = 0;	 Catch:{ Exception -> 0x00d7 }
        r10 = 1;	 Catch:{ Exception -> 0x00d7 }
        r11 = 45000; // 0xafc8 float:6.3058E-41 double:2.2233E-319;	 Catch:{ Exception -> 0x00d7 }
        r5 = r4;	 Catch:{ Exception -> 0x00d7 }
        r5 = anet.channel.strategy.IPConnStrategy.a(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x00d7 }
        r5.a = r2;	 Catch:{ Exception -> 0x00d7 }
        r12.add(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = r14.c;	 Catch:{ Exception -> 0x00d7 }
        r5 = r5.a;	 Catch:{ Exception -> 0x00d7 }
        r6 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r5.put(r6, r12);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x008b;	 Catch:{ Exception -> 0x00d7 }
    L_0x005e:
        r6 = 80;	 Catch:{ Exception -> 0x00d7 }
        r7 = anet.channel.strategy.ConnProtocol.HTTP;	 Catch:{ Exception -> 0x00d7 }
        r8 = 0;	 Catch:{ Exception -> 0x00d7 }
        r9 = 0;	 Catch:{ Exception -> 0x00d7 }
        r10 = 0;	 Catch:{ Exception -> 0x00d7 }
        r11 = 0;	 Catch:{ Exception -> 0x00d7 }
        r5 = r4;	 Catch:{ Exception -> 0x00d7 }
        r13 = anet.channel.strategy.IPConnStrategy.a(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x00d7 }
        r13.a = r2;	 Catch:{ Exception -> 0x00d7 }
        r6 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;	 Catch:{ Exception -> 0x00d7 }
        r7 = anet.channel.strategy.ConnProtocol.HTTPS;	 Catch:{ Exception -> 0x00d7 }
        r8 = 0;	 Catch:{ Exception -> 0x00d7 }
        r9 = 0;	 Catch:{ Exception -> 0x00d7 }
        r10 = 0;	 Catch:{ Exception -> 0x00d7 }
        r11 = 0;	 Catch:{ Exception -> 0x00d7 }
        r5 = r4;	 Catch:{ Exception -> 0x00d7 }
        r5 = anet.channel.strategy.IPConnStrategy.a(r5, r6, r7, r8, r9, r10, r11);	 Catch:{ Exception -> 0x00d7 }
        r5.a = r2;	 Catch:{ Exception -> 0x00d7 }
        r12.add(r13);	 Catch:{ Exception -> 0x00d7 }
        r12.add(r5);	 Catch:{ Exception -> 0x00d7 }
        r5 = r14.c;	 Catch:{ Exception -> 0x00d7 }
        r5 = r5.a;	 Catch:{ Exception -> 0x00d7 }
        r6 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r5.put(r6, r12);	 Catch:{ Exception -> 0x00d7 }
    L_0x008b:
        r5 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ Exception -> 0x00d7 }
        if (r5 == 0) goto L_0x00b6;	 Catch:{ Exception -> 0x00d7 }
    L_0x0091:
        r5 = "awcn.LocalDnsStrategyTable";	 Catch:{ Exception -> 0x00d7 }
        r6 = "resolve ip by local dns";	 Catch:{ Exception -> 0x00d7 }
        r7 = 4;	 Catch:{ Exception -> 0x00d7 }
        r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x00d7 }
        r8 = "host";	 Catch:{ Exception -> 0x00d7 }
        r7[r1] = r8;	 Catch:{ Exception -> 0x00d7 }
        r8 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r7[r3] = r8;	 Catch:{ Exception -> 0x00d7 }
        r8 = "ip";	 Catch:{ Exception -> 0x00d7 }
        r7[r2] = r8;	 Catch:{ Exception -> 0x00d7 }
        r8 = 3;	 Catch:{ Exception -> 0x00d7 }
        r7[r8] = r4;	 Catch:{ Exception -> 0x00d7 }
        anet.channel.util.ALog.d(r5, r6, r0, r7);	 Catch:{ Exception -> 0x00d7 }
        goto L_0x00b6;	 Catch:{ Exception -> 0x00d7 }
    L_0x00ab:
        r4 = r14.c;	 Catch:{ Exception -> 0x00d7 }
        r4 = r4.a;	 Catch:{ Exception -> 0x00d7 }
        r5 = r14.a;	 Catch:{ Exception -> 0x00d7 }
        r6 = java.util.Collections.EMPTY_LIST;	 Catch:{ Exception -> 0x00d7 }
        r4.put(r5, r6);	 Catch:{ Exception -> 0x00d7 }
    L_0x00b6:
        r0 = r14.c;
        r0 = r0.b;
        monitor-enter(r0);
        r1 = r14.c;	 Catch:{ all -> 0x00d2 }
        r1 = r1.b;	 Catch:{ all -> 0x00d2 }
        r2 = r14.a;	 Catch:{ all -> 0x00d2 }
        r1.remove(r2);	 Catch:{ all -> 0x00d2 }
        monitor-exit(r0);	 Catch:{ all -> 0x00d2 }
        r0 = r14.b;
        monitor-enter(r0);
        r1 = r14.b;	 Catch:{ all -> 0x00cf }
        r1.notifyAll();	 Catch:{ all -> 0x00cf }
        monitor-exit(r0);	 Catch:{ all -> 0x00cf }
        return;
    L_0x00cf:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x00d2:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x00d5:
        r0 = move-exception;
        goto L_0x010d;
    L_0x00d7:
        r4 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ all -> 0x00d5 }
        if (r4 == 0) goto L_0x00ee;	 Catch:{ all -> 0x00d5 }
    L_0x00dd:
        r4 = "awcn.LocalDnsStrategyTable";	 Catch:{ all -> 0x00d5 }
        r5 = "resolve ip by local dns failed";	 Catch:{ all -> 0x00d5 }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00d5 }
        r6 = "host";	 Catch:{ all -> 0x00d5 }
        r2[r1] = r6;	 Catch:{ all -> 0x00d5 }
        r1 = r14.a;	 Catch:{ all -> 0x00d5 }
        r2[r3] = r1;	 Catch:{ all -> 0x00d5 }
        anet.channel.util.ALog.d(r4, r5, r0, r2);	 Catch:{ all -> 0x00d5 }
    L_0x00ee:
        r0 = r14.c;
        r0 = r0.b;
        monitor-enter(r0);
        r1 = r14.c;	 Catch:{ all -> 0x010a }
        r1 = r1.b;	 Catch:{ all -> 0x010a }
        r2 = r14.a;	 Catch:{ all -> 0x010a }
        r1.remove(r2);	 Catch:{ all -> 0x010a }
        monitor-exit(r0);	 Catch:{ all -> 0x010a }
        r0 = r14.b;
        monitor-enter(r0);
        r1 = r14.b;	 Catch:{ all -> 0x0107 }
        r1.notifyAll();	 Catch:{ all -> 0x0107 }
        monitor-exit(r0);	 Catch:{ all -> 0x0107 }
        return;
    L_0x0107:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x010a:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x010d:
        r1 = r14.c;
        r1 = r1.b;
        monitor-enter(r1);
        r2 = r14.c;	 Catch:{ all -> 0x0129 }
        r2 = r2.b;	 Catch:{ all -> 0x0129 }
        r3 = r14.a;	 Catch:{ all -> 0x0129 }
        r2.remove(r3);	 Catch:{ all -> 0x0129 }
        monitor-exit(r1);	 Catch:{ all -> 0x0129 }
        r1 = r14.b;
        monitor-enter(r1);
        r2 = r14.b;	 Catch:{ all -> 0x0126 }
        r2.notifyAll();	 Catch:{ all -> 0x0126 }
        monitor-exit(r1);	 Catch:{ all -> 0x0126 }
        throw r0;
    L_0x0126:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x0129:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.b.run():void");
    }
}
