package anet.channel.status;

import anet.channel.status.NetworkStatusHelper.NetworkStatus;

/* compiled from: Taobao */
final class a implements Runnable {
    final /* synthetic */ NetworkStatus a;

    a(NetworkStatus networkStatus) {
        this.a = networkStatus;
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = anet.channel.status.NetworkStatusHelper.a;	 Catch:{ Exception -> 0x003e }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x003e }
    L_0x0008:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x003e }
        if (r1 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003e }
    L_0x000e:
        r1 = r0.next();	 Catch:{ Exception -> 0x003e }
        r1 = (anet.channel.status.NetworkStatusHelper.INetworkStatusChangeListener) r1;	 Catch:{ Exception -> 0x003e }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x003e }
        r4 = r8.a;	 Catch:{ Exception -> 0x003e }
        r1.onNetworkStatusChanged(r4);	 Catch:{ Exception -> 0x003e }
        r4 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x003e }
        r6 = r4 - r2;	 Catch:{ Exception -> 0x003e }
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ Exception -> 0x003e }
        r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1));	 Catch:{ Exception -> 0x003e }
        if (r4 <= 0) goto L_0x0008;	 Catch:{ Exception -> 0x003e }
    L_0x0029:
        r2 = "awcn.NetworkStatusHelper";	 Catch:{ Exception -> 0x003e }
        r3 = "call back cost too much time";	 Catch:{ Exception -> 0x003e }
        r4 = 0;	 Catch:{ Exception -> 0x003e }
        r5 = 2;	 Catch:{ Exception -> 0x003e }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x003e }
        r6 = 0;	 Catch:{ Exception -> 0x003e }
        r7 = "listener";	 Catch:{ Exception -> 0x003e }
        r5[r6] = r7;	 Catch:{ Exception -> 0x003e }
        r6 = 1;	 Catch:{ Exception -> 0x003e }
        r5[r6] = r1;	 Catch:{ Exception -> 0x003e }
        anet.channel.util.ALog.e(r2, r3, r4, r5);	 Catch:{ Exception -> 0x003e }
        goto L_0x0008;
    L_0x003d:
        return;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.status.a.run():void");
    }
}
