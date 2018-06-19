package com.igexin.push.d;

import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import com.xunlei.download.proguard.c;

public class f implements i {
    private long a(long j) {
        double d = (double) (j / 10);
        return j + ((long) (((Math.random() * d) * 2.0d) - d));
    }

    public long a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("NormalModel|resetDelay = ");
        stringBuilder.append(z);
        a.b(stringBuilder.toString());
        if (z) {
            g.E = 0;
            a.b("NormalModel|isResetDelay = true, reconnect delayTime = 0");
        }
        z = com.igexin.push.util.a.a(System.currentTimeMillis());
        boolean b = com.igexin.push.util.a.b();
        g.h = com.igexin.push.util.a.g();
        StringBuilder stringBuilder2 = new StringBuilder("NormalModel|isSdkOn = ");
        stringBuilder2.append(g.i);
        stringBuilder2.append(" isPushOn = ");
        stringBuilder2.append(g.j);
        stringBuilder2.append(" checkIsSilentTime = ");
        stringBuilder2.append(z);
        stringBuilder2.append(" isBlockEndTime = ");
        stringBuilder2.append(b);
        stringBuilder2.append(" isNetworkAvailable = ");
        stringBuilder2.append(g.h);
        a.b(stringBuilder2.toString());
        if (g.h && g.i && g.j && !z) {
            if (b) {
                long j;
                if (g.E <= 0) {
                    g.E = 200;
                } else {
                    long j2;
                    if (g.E <= 10000) {
                        j = g.E;
                        j2 = 500;
                    } else if (g.E <= StatisticConfig.MIN_UPLOAD_INTERVAL) {
                        j = g.E;
                        j2 = c.x;
                    } else {
                        j = g.E;
                        j2 = 120000;
                    }
                    g.E = j + j2;
                }
                if (g.E > 3600000) {
                    g.E = 3600000;
                }
                j = a(g.E);
                StringBuilder stringBuilder3 = new StringBuilder("NormalModel|after add auto reconnect delay time = ");
                stringBuilder3.append(j);
                a.b(stringBuilder3.toString());
                return j;
            }
        }
        a.b("NormalModel|reconnect stop, interval= 1h ++++");
        return 3600000;
    }
}
