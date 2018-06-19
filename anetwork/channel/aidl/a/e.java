package anetwork.channel.aidl.a;

import android.os.Handler;
import android.os.RemoteException;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.j;
import anetwork.channel.aidl.k.a;
import anetwork.channel.c;
import anetwork.channel.c.b;
import anetwork.channel.c.d;

/* compiled from: Taobao */
public final class e extends a {
    private anetwork.channel.e a;
    private Handler b;
    private Object c;
    private byte d = (byte) 0;

    public e(anetwork.channel.e eVar) {
        this.a = eVar;
        if (c.a.class.isAssignableFrom(eVar.getClass())) {
            this.d = (byte) (this.d | 1);
        }
        if (c.c.class.isAssignableFrom(eVar.getClass())) {
            this.d = (byte) (this.d | 2);
        }
        if (d.class.isAssignableFrom(eVar.getClass())) {
            this.d = (byte) (this.d | 4);
        }
        if (b.class.isAssignableFrom(eVar.getClass()) != null) {
            this.d = (byte) (this.d | 8);
        }
        this.b = null;
        this.c = null;
    }

    private void a(byte b, Object obj) {
        if (this.b == null) {
            b(b, obj);
        } else {
            this.b.post(new f(this, b, obj));
        }
    }

    private void b(byte r6, java.lang.Object r7) {
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
        r5 = this;
        r0 = 4;
        r1 = 0;
        r2 = 0;
        r3 = 1;
        if (r6 != r0) goto L_0x002f;
    L_0x0006:
        r7 = (anetwork.channel.aidl.ParcelableHeader) r7;	 Catch:{ Exception -> 0x00a0 }
        r6 = r5.a;	 Catch:{ Exception -> 0x00a0 }
        r6 = (anetwork.channel.c.d) r6;	 Catch:{ Exception -> 0x00a0 }
        r0 = r7.a;	 Catch:{ Exception -> 0x00a0 }
        r4 = r7.b;	 Catch:{ Exception -> 0x00a0 }
        r6.a(r0, r4);	 Catch:{ Exception -> 0x00a0 }
        r6 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ Exception -> 0x00a0 }
        if (r6 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x00a0 }
    L_0x0019:
        r6 = "anet.ParcelableNetworkListenerWrapper";	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r3 = "[onResponseCode]";	 Catch:{ Exception -> 0x00a0 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x00a0 }
        r0.append(r7);	 Catch:{ Exception -> 0x00a0 }
        r7 = r0.toString();	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a0 }
        anet.channel.util.ALog.d(r6, r7, r2, r0);	 Catch:{ Exception -> 0x00a0 }
    L_0x002e:
        return;	 Catch:{ Exception -> 0x00a0 }
    L_0x002f:
        r0 = 2;	 Catch:{ Exception -> 0x00a0 }
        if (r6 != r0) goto L_0x0056;	 Catch:{ Exception -> 0x00a0 }
    L_0x0032:
        r7 = (anetwork.channel.aidl.DefaultProgressEvent) r7;	 Catch:{ Exception -> 0x00a0 }
        if (r7 == 0) goto L_0x003a;	 Catch:{ Exception -> 0x00a0 }
    L_0x0036:
        r6 = r5.c;	 Catch:{ Exception -> 0x00a0 }
        r7.e = r6;	 Catch:{ Exception -> 0x00a0 }
    L_0x003a:
        r6 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ Exception -> 0x00a0 }
        if (r6 == 0) goto L_0x0055;	 Catch:{ Exception -> 0x00a0 }
    L_0x0040:
        r6 = "anet.ParcelableNetworkListenerWrapper";	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r3 = "[onDataReceived]";	 Catch:{ Exception -> 0x00a0 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x00a0 }
        r0.append(r7);	 Catch:{ Exception -> 0x00a0 }
        r7 = r0.toString();	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a0 }
        anet.channel.util.ALog.d(r6, r7, r2, r0);	 Catch:{ Exception -> 0x00a0 }
    L_0x0055:
        return;	 Catch:{ Exception -> 0x00a0 }
    L_0x0056:
        if (r6 != r3) goto L_0x0083;	 Catch:{ Exception -> 0x00a0 }
    L_0x0058:
        r7 = (anetwork.channel.aidl.DefaultFinishEvent) r7;	 Catch:{ Exception -> 0x00a0 }
        if (r7 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x00a0 }
    L_0x005c:
        r6 = r5.c;	 Catch:{ Exception -> 0x00a0 }
        r7.a = r6;	 Catch:{ Exception -> 0x00a0 }
    L_0x0060:
        r6 = r5.a;	 Catch:{ Exception -> 0x00a0 }
        r6 = (anetwork.channel.c.a) r6;	 Catch:{ Exception -> 0x00a0 }
        r6.a(r7);	 Catch:{ Exception -> 0x00a0 }
        r6 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ Exception -> 0x00a0 }
        if (r6 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x00a0 }
    L_0x006d:
        r6 = "anet.ParcelableNetworkListenerWrapper";	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a0 }
        r3 = "[onFinished]";	 Catch:{ Exception -> 0x00a0 }
        r0.<init>(r3);	 Catch:{ Exception -> 0x00a0 }
        r0.append(r7);	 Catch:{ Exception -> 0x00a0 }
        r7 = r0.toString();	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a0 }
        anet.channel.util.ALog.d(r6, r7, r2, r0);	 Catch:{ Exception -> 0x00a0 }
    L_0x0082:
        return;	 Catch:{ Exception -> 0x00a0 }
    L_0x0083:
        r0 = 8;	 Catch:{ Exception -> 0x00a0 }
        if (r6 != r0) goto L_0x00aa;	 Catch:{ Exception -> 0x00a0 }
    L_0x0087:
        r7 = (anetwork.channel.aidl.j) r7;	 Catch:{ Exception -> 0x00a0 }
        r6 = r5.a;	 Catch:{ Exception -> 0x00a0 }
        r6 = (anetwork.channel.c.b) r6;	 Catch:{ Exception -> 0x00a0 }
        r6.a(r7);	 Catch:{ Exception -> 0x00a0 }
        r6 = anet.channel.util.ALog.isPrintLog(r3);	 Catch:{ Exception -> 0x00a0 }
        if (r6 == 0) goto L_0x00aa;	 Catch:{ Exception -> 0x00a0 }
    L_0x0096:
        r6 = "anet.ParcelableNetworkListenerWrapper";	 Catch:{ Exception -> 0x00a0 }
        r7 = "[onInputStreamReceived]";	 Catch:{ Exception -> 0x00a0 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00a0 }
        anet.channel.util.ALog.d(r6, r7, r2, r0);	 Catch:{ Exception -> 0x00a0 }
        goto L_0x00aa;
    L_0x00a0:
        r6 = "anet.ParcelableNetworkListenerWrapper";
        r7 = "dispatchCallback error";
        r0 = new java.lang.Object[r1];
        anet.channel.util.ALog.e(r6, r7, r2, r0);
        return;
    L_0x00aa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.a.e.b(byte, java.lang.Object):void");
    }

    public final void a(DefaultProgressEvent defaultProgressEvent) throws RemoteException {
        if ((this.d & 2) != 0) {
            a((byte) 2, (Object) defaultProgressEvent);
        }
    }

    public final void a(DefaultFinishEvent defaultFinishEvent) throws RemoteException {
        if ((this.d & 1) != 0) {
            a((byte) 1, (Object) defaultFinishEvent);
        }
        this.a = null;
        this.c = null;
        this.b = null;
    }

    public final boolean a(int i, ParcelableHeader parcelableHeader) throws RemoteException {
        if ((this.d & 4) != 0) {
            a((byte) 4, (Object) parcelableHeader);
        }
        return false;
    }

    public final void a(j jVar) throws RemoteException {
        if ((this.d & 8) != 0) {
            a((byte) 8, (Object) jVar);
        }
    }

    public final byte a() throws RemoteException {
        return this.d;
    }
}
