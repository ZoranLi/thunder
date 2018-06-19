package anetwork.channel.aidl.a;

import android.os.Build.VERSION;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.h;
import anetwork.channel.c.b;
import anetwork.channel.c.d;
import anetwork.channel.entity.j;
import anetwork.channel.statist.StatisticData;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: Taobao */
public final class a extends anetwork.channel.aidl.a.a implements anetwork.channel.c.a, b, d {
    public StatisticData a;
    public h b;
    private d c;
    private int d;
    private String e;
    private Map<String, List<String>> f;
    private CountDownLatch g = new CountDownLatch(1);
    private CountDownLatch h = new CountDownLatch(1);
    private j i;

    public a(j jVar) {
        this.i = jVar;
    }

    public final String c() throws RemoteException {
        a(this.g);
        return this.e;
    }

    public final anetwork.channel.aidl.j a() throws RemoteException {
        a(this.h);
        return this.c;
    }

    public final int b() throws RemoteException {
        a(this.g);
        return this.d;
    }

    public final Map<String, List<String>> d() throws RemoteException {
        a(this.g);
        return this.f;
    }

    public final void e() throws RemoteException {
        if (this.b != null) {
            this.b.a(true);
        }
    }

    public final void a(anetwork.channel.d.a aVar) {
        if (this.c != null) {
            this.c.e();
        }
        this.d = aVar.a();
        this.e = aVar.b() != null ? aVar.b() : ErrorConstant.getErrMsg(this.d);
        this.a = aVar.c();
        this.h.countDown();
        this.g.countDown();
    }

    private void a(java.util.concurrent.CountDownLatch r4) throws android.os.RemoteException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.i;	 Catch:{ InterruptedException -> 0x0021 }
        r0 = r0.a();	 Catch:{ InterruptedException -> 0x0021 }
        r0 = (long) r0;	 Catch:{ InterruptedException -> 0x0021 }
        r2 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0021 }
        r4 = r4.await(r0, r2);	 Catch:{ InterruptedException -> 0x0021 }
        if (r4 != 0) goto L_0x0020;	 Catch:{ InterruptedException -> 0x0021 }
    L_0x000f:
        r4 = r3.b;	 Catch:{ InterruptedException -> 0x0021 }
        if (r4 == 0) goto L_0x0019;	 Catch:{ InterruptedException -> 0x0021 }
    L_0x0013:
        r4 = r3.b;	 Catch:{ InterruptedException -> 0x0021 }
        r0 = 1;	 Catch:{ InterruptedException -> 0x0021 }
        r4.a(r0);	 Catch:{ InterruptedException -> 0x0021 }
    L_0x0019:
        r4 = "wait time out";	 Catch:{ InterruptedException -> 0x0021 }
        r4 = a(r4);	 Catch:{ InterruptedException -> 0x0021 }
        throw r4;	 Catch:{ InterruptedException -> 0x0021 }
    L_0x0020:
        return;
    L_0x0021:
        r4 = "thread interrupt";
        r4 = a(r4);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.aidl.a.a.a(java.util.concurrent.CountDownLatch):void");
    }

    private static RemoteException a(String str) {
        if (VERSION.SDK_INT >= 15) {
            return new RemoteException(str);
        }
        return new RemoteException();
    }

    public final boolean a(int i, Map<String, List<String>> map) {
        this.d = i;
        this.e = ErrorConstant.getErrMsg(this.d);
        this.f = map;
        this.g.countDown();
        return false;
    }

    public final void a(anetwork.channel.aidl.j jVar) {
        this.c = (d) jVar;
        this.h.countDown();
    }
}
