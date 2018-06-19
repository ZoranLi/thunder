package anet.channel.strategy;

/* compiled from: Taobao */
class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ StrategyInfoHolder b;

    d(StrategyInfoHolder strategyInfoHolder, String str) {
        this.b = strategyInfoHolder;
        this.a = str;
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
        r6 = this;
        r0 = anet.channel.strategy.l.b();	 Catch:{ Exception -> 0x0039 }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Exception -> 0x0039 }
    L_0x0006:
        return;	 Catch:{ Exception -> 0x0039 }
    L_0x0007:
        r1 = 0;	 Catch:{ Exception -> 0x0039 }
        r2 = r1;	 Catch:{ Exception -> 0x0039 }
    L_0x0009:
        r3 = r0.length;	 Catch:{ Exception -> 0x0039 }
        if (r1 >= r3) goto L_0x0038;	 Catch:{ Exception -> 0x0039 }
    L_0x000c:
        r3 = 2;	 Catch:{ Exception -> 0x0039 }
        if (r2 >= r3) goto L_0x0038;	 Catch:{ Exception -> 0x0039 }
    L_0x000f:
        r3 = r0[r1];	 Catch:{ Exception -> 0x0039 }
        r3 = r3.getName();	 Catch:{ Exception -> 0x0039 }
        r4 = r6.a;	 Catch:{ Exception -> 0x0039 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x0039 }
        if (r4 != 0) goto L_0x0035;	 Catch:{ Exception -> 0x0039 }
    L_0x001d:
        r4 = anet.channel.strategy.StrategyInfoHolder.a;	 Catch:{ Exception -> 0x0039 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x0039 }
        if (r4 != 0) goto L_0x0035;	 Catch:{ Exception -> 0x0039 }
    L_0x0025:
        r4 = anet.channel.strategy.StrategyInfoHolder.b;	 Catch:{ Exception -> 0x0039 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x0039 }
        if (r4 != 0) goto L_0x0035;	 Catch:{ Exception -> 0x0039 }
    L_0x002d:
        r4 = r6.b;	 Catch:{ Exception -> 0x0039 }
        r5 = 0;	 Catch:{ Exception -> 0x0039 }
        r4.a(r3, r5);	 Catch:{ Exception -> 0x0039 }
        r2 = r2 + 1;
    L_0x0035:
        r1 = r1 + 1;
        goto L_0x0009;
    L_0x0038:
        return;
    L_0x0039:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.d.run():void");
    }
}
