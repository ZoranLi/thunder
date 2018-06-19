package anet.channel.monitor;

import anet.channel.util.ALog;

/* compiled from: Taobao */
class d implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ long b;
    final /* synthetic */ long c;
    final /* synthetic */ b d;

    d(b bVar, long j, long j2, long j3) {
        this.d = bVar;
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public void run() {
        d dVar = this;
        int i = 5;
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.BandWidthSampler", "onDataReceived", null, "mRequestStartTime", Long.valueOf(dVar.a), "mRequestFinishedTime", Long.valueOf(dVar.b), "mRequestDataSize", Long.valueOf(dVar.c));
        }
        if (b.k && dVar.c > 3000) {
            if (dVar.a < dVar.b) {
                b.a++;
                b.e += dVar.c;
                if (b.a == 1) {
                    b.d = dVar.b - dVar.a;
                }
                if (b.a >= 2 && b.a <= 3) {
                    if (dVar.a >= b.c) {
                        b.d += dVar.b - dVar.a;
                    } else if (dVar.a < b.c && dVar.b >= b.c) {
                        long j = b.d + (dVar.b - dVar.a);
                        b.d = j;
                        b.d = j - (b.c - dVar.a);
                    }
                }
                b.b = dVar.a;
                b.c = dVar.b;
                if (b.a == 3) {
                    b.i = (double) ((long) dVar.d.n.a((double) b.e, (double) b.d));
                    b.f++;
                    dVar.d.m = dVar.d.m + 1;
                    if (b.f > 30) {
                        dVar.d.n.a();
                        b.f = 3;
                    }
                    double d = ((b.i * 0.68d) + (b.h * 0.27d)) + (b.g * 0.05d);
                    b.g = b.h;
                    b.h = b.i;
                    if (b.i < 0.65d * b.g || b.i > 2.0d * b.g) {
                        b.i = d;
                    }
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.BandWidthSampler", "NetworkSpeed", null, "mKalmanDataSize", Long.valueOf(b.e), "mKalmanTimeUsed", Long.valueOf(b.d), "speed", Double.valueOf(b.i), "mSpeedKalmanCount", Long.valueOf(b.f));
                    }
                    if (dVar.d.m > 5 || b.f == 2) {
                        a.a().a(b.i);
                        dVar.d.m = 0;
                        b bVar = dVar.d;
                        if (b.i < b.j) {
                            i = 1;
                        }
                        bVar.l = i;
                        ALog.i("awcn.BandWidthSampler", "NetworkSpeed notification!", null, "Send Network quality notification.");
                    }
                    b.d = 0;
                    b.e = 0;
                    b.a = 0;
                }
            }
        }
    }
}
