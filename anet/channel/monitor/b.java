package anet.channel.monitor;

import anet.channel.a.c;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;

/* compiled from: Taobao */
public class b {
    static int a = 0;
    static long b = 0;
    static long c = 0;
    static long d = 0;
    static long e = 0;
    static long f = 0;
    static double g = 0.0d;
    static double h = 0.0d;
    static double i = 0.0d;
    static double j = 40.0d;
    private static volatile boolean k = false;
    private int l;
    private int m;
    private e n;

    /* compiled from: Taobao */
    static class a {
        static b a = new b();

        a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
        this.l = 5;
        this.m = 0;
        this.n = new e();
        NetworkStatusHelper.a(new c(this));
    }

    public int b() {
        if (NetworkStatusHelper.a() == NetworkStatus.G2) {
            return 1;
        }
        return this.l;
    }

    public double c() {
        return i;
    }

    public synchronized void d() {
        try {
            ALog.i("awcn.BandWidthSampler", "[startNetworkMeter]", null, "NetworkStatus", NetworkStatusHelper.a());
            if (NetworkStatusHelper.a() == NetworkStatus.G2) {
                k = false;
            } else {
                k = true;
            }
        } catch (Throwable e) {
            ALog.w("awcn.BandWidthSampler", "startNetworkMeter fail.", null, e, new Object[0]);
        }
    }

    public void e() {
        k = false;
    }

    public void a(long j, long j2, long j3) {
        c.a(new d(this, j, j2, j3));
    }
}
