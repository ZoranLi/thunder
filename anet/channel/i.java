package anet.channel;

/* compiled from: Taobao */
class i implements Runnable {
    final /* synthetic */ Session a;
    final /* synthetic */ a b;

    i(a aVar, Session session) {
        this.b = aVar;
        this.a = session;
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
        r4 = this;
        r0 = r4.b;	 Catch:{ Exception -> 0x0024 }
        r0 = r0.b;	 Catch:{ Exception -> 0x0024 }
        r1 = r4.b;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.c;	 Catch:{ Exception -> 0x0024 }
        r2 = r4.a;	 Catch:{ Exception -> 0x0024 }
        r2 = r2.getConnType();	 Catch:{ Exception -> 0x0024 }
        r2 = r2.getTypeLevel();	 Catch:{ Exception -> 0x0024 }
        r3 = r4.b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.seqNum;	 Catch:{ Exception -> 0x0024 }
        r3 = anet.channel.util.g.a(r3);	 Catch:{ Exception -> 0x0024 }
        r0.a(r1, r2, r3);	 Catch:{ Exception -> 0x0024 }
        return;
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.i.run():void");
    }
}
