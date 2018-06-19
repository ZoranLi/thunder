package com.xiaomi.stats;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.smack.a;
import com.xiaomi.smack.d;
import com.xiaomi.smack.g;

public class e implements d {
    XMPushService a;
    a b;
    private int c;
    private Exception d;
    private String e;
    private long f = 0;
    private long g = 0;
    private long h = 0;
    private long i = 0;
    private long j = 0;
    private long k = 0;

    e(XMPushService xMPushService) {
        this.a = xMPushService;
        this.e = com.xiaomi.channel.commonutils.network.d.k(xMPushService);
        c();
        int myUid = Process.myUid();
        this.k = TrafficStats.getUidRxBytes(myUid);
        this.j = TrafficStats.getUidTxBytes(myUid);
    }

    private void c() {
        this.g = 0;
        this.i = 0;
        this.f = 0;
        this.h = 0;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (com.xiaomi.channel.commonutils.network.d.c(this.a)) {
            this.f = elapsedRealtime;
        }
        if (this.a.f()) {
            this.h = elapsedRealtime;
        }
    }

    private synchronized void d() {
        StringBuilder stringBuilder = new StringBuilder("stat connpt = ");
        stringBuilder.append(this.e);
        stringBuilder.append(" netDuration = ");
        stringBuilder.append(this.g);
        stringBuilder.append(" ChannelDuration = ");
        stringBuilder.append(this.i);
        stringBuilder.append(" channelConnectedTime = ");
        stringBuilder.append(this.h);
        b.c(stringBuilder.toString());
        com.xiaomi.push.thrift.b bVar = new com.xiaomi.push.thrift.b();
        bVar.a = (byte) 0;
        bVar.a(com.xiaomi.push.thrift.a.CHANNEL_ONLINE_RATE.a());
        bVar.a(this.e);
        bVar.d((int) (System.currentTimeMillis() / 1000));
        bVar.b((int) (this.g / 1000));
        bVar.c((int) (this.i / 1000));
        f.a().a(bVar);
        c();
    }

    Exception a() {
        return this.d;
    }

    public void a(a aVar) {
        b();
        this.h = SystemClock.elapsedRealtime();
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a(), aVar.e(), aVar.m());
    }

    public void a(a aVar, int i, Exception exception) {
        if (this.c == 0 && this.d == null) {
            this.c = i;
            this.d = exception;
            h.b(aVar.e(), exception);
        }
        if (i == 22 && this.h != 0) {
            long h = aVar.h() - this.h;
            if (h < 0) {
                h = 0;
            }
            this.i += h + ((long) (g.c() / 2));
            this.h = 0;
        }
        b();
        int myUid = Process.myUid();
        long uidRxBytes = TrafficStats.getUidRxBytes(myUid);
        long uidTxBytes = TrafficStats.getUidTxBytes(myUid);
        StringBuilder stringBuilder = new StringBuilder("Stats rx=");
        stringBuilder.append(uidRxBytes - this.k);
        stringBuilder.append(", tx=");
        stringBuilder.append(uidTxBytes - this.j);
        b.c(stringBuilder.toString());
        this.k = uidRxBytes;
        this.j = uidTxBytes;
    }

    public void a(a aVar, Exception exception) {
        h.a(0, com.xiaomi.push.thrift.a.CHANNEL_CON_FAIL.a(), 1, aVar.e(), com.xiaomi.channel.commonutils.network.d.c(this.a));
        b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b() {
        /*
        r12 = this;
        monitor-enter(r12);
        r0 = r12.a;	 Catch:{ all -> 0x0071 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r12);
        return;
    L_0x0007:
        r0 = r12.a;	 Catch:{ all -> 0x0071 }
        r0 = com.xiaomi.channel.commonutils.network.d.k(r0);	 Catch:{ all -> 0x0071 }
        r1 = r12.a;	 Catch:{ all -> 0x0071 }
        r1 = com.xiaomi.channel.commonutils.network.d.c(r1);	 Catch:{ all -> 0x0071 }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ all -> 0x0071 }
        r4 = r12.f;	 Catch:{ all -> 0x0071 }
        r6 = 0;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 <= 0) goto L_0x002b;
    L_0x001f:
        r4 = r12.g;	 Catch:{ all -> 0x0071 }
        r8 = r12.f;	 Catch:{ all -> 0x0071 }
        r10 = r2 - r8;
        r8 = r4 + r10;
        r12.g = r8;	 Catch:{ all -> 0x0071 }
        r12.f = r6;	 Catch:{ all -> 0x0071 }
    L_0x002b:
        r4 = r12.h;	 Catch:{ all -> 0x0071 }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x003d;
    L_0x0031:
        r4 = r12.i;	 Catch:{ all -> 0x0071 }
        r8 = r12.h;	 Catch:{ all -> 0x0071 }
        r10 = r2 - r8;
        r8 = r4 + r10;
        r12.i = r8;	 Catch:{ all -> 0x0071 }
        r12.h = r6;	 Catch:{ all -> 0x0071 }
    L_0x003d:
        if (r1 == 0) goto L_0x006f;
    L_0x003f:
        r1 = r12.e;	 Catch:{ all -> 0x0071 }
        r1 = android.text.TextUtils.equals(r1, r0);	 Catch:{ all -> 0x0071 }
        if (r1 != 0) goto L_0x004f;
    L_0x0047:
        r4 = r12.g;	 Catch:{ all -> 0x0071 }
        r8 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 > 0) goto L_0x0058;
    L_0x004f:
        r4 = r12.g;	 Catch:{ all -> 0x0071 }
        r8 = 5400000; // 0x5265c0 float:7.567012E-39 double:2.6679545E-317;
        r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x005b;
    L_0x0058:
        r12.d();	 Catch:{ all -> 0x0071 }
    L_0x005b:
        r12.e = r0;	 Catch:{ all -> 0x0071 }
        r0 = r12.f;	 Catch:{ all -> 0x0071 }
        r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r4 != 0) goto L_0x0065;
    L_0x0063:
        r12.f = r2;	 Catch:{ all -> 0x0071 }
    L_0x0065:
        r0 = r12.a;	 Catch:{ all -> 0x0071 }
        r0 = r0.f();	 Catch:{ all -> 0x0071 }
        if (r0 == 0) goto L_0x006f;
    L_0x006d:
        r12.h = r2;	 Catch:{ all -> 0x0071 }
    L_0x006f:
        monitor-exit(r12);
        return;
    L_0x0071:
        r0 = move-exception;
        monitor-exit(r12);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.e.b():void");
    }

    public void b(a aVar) {
        this.c = 0;
        this.d = null;
        this.b = aVar;
        h.a(0, com.xiaomi.push.thrift.a.CONN_SUCCESS.a());
    }
}
