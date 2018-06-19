package anetwork.channel.entity;

import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.k;

/* compiled from: Taobao */
final class h implements Runnable {
    final /* synthetic */ ByteArray a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ k d;
    final /* synthetic */ f e;

    h(f fVar, ByteArray byteArray, int i, int i2, k kVar) {
        this.e = fVar;
        this.a = byteArray;
        this.b = i;
        this.c = i2;
        this.d = kVar;
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
        r3 = this;
        r0 = r3.e;
        r0 = r0.d;
        if (r0 != 0) goto L_0x0032;
    L_0x0006:
        r0 = new anetwork.channel.aidl.DefaultProgressEvent;
        r0.<init>();
        r1 = r3.a;
        r1 = r1.getDataLength();
        r0.b = r1;
        r1 = r3.b;
        r0.c = r1;
        r1 = "";
        r0.d = r1;
        r1 = r3.c;
        r0.a = r1;
        r1 = r3.a;
        r1 = r1.getBuffer();
        r0.f = r1;
        r1 = r3.d;	 Catch:{ RemoteException -> 0x002d }
        r1.a(r0);	 Catch:{ RemoteException -> 0x002d }
        return;
    L_0x002d:
        r0 = move-exception;
        r0.printStackTrace();
        return;
    L_0x0032:
        r0 = r3.e;	 Catch:{ Exception -> 0x007a }
        r0 = r0.c;	 Catch:{ Exception -> 0x007a }
        if (r0 != 0) goto L_0x0070;	 Catch:{ Exception -> 0x007a }
    L_0x0038:
        r0 = r3.e;	 Catch:{ Exception -> 0x007a }
        r1 = new anetwork.channel.aidl.a.d;	 Catch:{ Exception -> 0x007a }
        r1.<init>();	 Catch:{ Exception -> 0x007a }
        r0.c = r1;	 Catch:{ Exception -> 0x007a }
        r0 = r3.e;	 Catch:{ Exception -> 0x007a }
        r0 = r0.c;	 Catch:{ Exception -> 0x007a }
        r1 = r3.e;	 Catch:{ Exception -> 0x007a }
        r1 = r1.e;	 Catch:{ Exception -> 0x007a }
        r2 = r3.b;	 Catch:{ Exception -> 0x007a }
        r0.a = r2;	 Catch:{ Exception -> 0x007a }
        r2 = r1.g;	 Catch:{ Exception -> 0x007a }
        r0.d = r2;	 Catch:{ Exception -> 0x007a }
        r2 = r1.b;	 Catch:{ Exception -> 0x007a }
        r2 = r2.getUrlString();	 Catch:{ Exception -> 0x007a }
        r0.c = r2;	 Catch:{ Exception -> 0x007a }
        r1 = r1.e;	 Catch:{ Exception -> 0x007a }
        r0.b = r1;	 Catch:{ Exception -> 0x007a }
        r0 = r3.e;	 Catch:{ Exception -> 0x007a }
        r0 = r0.c;	 Catch:{ Exception -> 0x007a }
        r1 = r3.a;	 Catch:{ Exception -> 0x007a }
        r0.a(r1);	 Catch:{ Exception -> 0x007a }
        r0 = r3.d;	 Catch:{ Exception -> 0x007a }
        r1 = r3.e;	 Catch:{ Exception -> 0x007a }
        r1 = r1.c;	 Catch:{ Exception -> 0x007a }
        r0.a(r1);	 Catch:{ Exception -> 0x007a }
        return;	 Catch:{ Exception -> 0x007a }
    L_0x0070:
        r0 = r3.e;	 Catch:{ Exception -> 0x007a }
        r0 = r0.c;	 Catch:{ Exception -> 0x007a }
        r1 = r3.a;	 Catch:{ Exception -> 0x007a }
        r0.a(r1);	 Catch:{ Exception -> 0x007a }
        return;
    L_0x007a:
        r0 = r3.e;
        r0 = r0.c;
        if (r0 == 0) goto L_0x0088;
    L_0x0080:
        r0 = r3.e;	 Catch:{ RemoteException -> 0x0088 }
        r0 = r0.c;	 Catch:{ RemoteException -> 0x0088 }
        r0.b();	 Catch:{ RemoteException -> 0x0088 }
        return;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.entity.h.run():void");
    }
}
