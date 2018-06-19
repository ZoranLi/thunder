package com.igexin.push.f.b;

import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.push.c.i;
import com.igexin.push.core.a.f;
import com.igexin.push.util.a;
import java.util.concurrent.TimeUnit;

public class g extends h {
    private static g a;

    private g() {
        super(3600000);
        this.o = true;
    }

    public static synchronized g g() {
        g gVar;
        synchronized (g.class) {
            if (a == null) {
                a = new g();
            }
            gVar = a;
        }
        return gVar;
    }

    protected void a() {
        f.a().A();
        boolean a = a.a(System.currentTimeMillis());
        boolean b = a.b();
        com.igexin.push.core.g.h = a.g();
        StringBuilder stringBuilder = new StringBuilder("ReconnectTimerTask|networkAvailable = ");
        stringBuilder.append(com.igexin.push.core.g.h);
        stringBuilder.append("|,sdkOnline = ");
        stringBuilder.append(com.igexin.push.core.g.l);
        stringBuilder.append(", sdkOn= ");
        stringBuilder.append(com.igexin.push.core.g.i);
        stringBuilder.append(", pushOn =");
        stringBuilder.append(com.igexin.push.core.g.j);
        stringBuilder.append(", isSilentTime= ");
        stringBuilder.append(a);
        stringBuilder.append(", blockEndTime= ");
        stringBuilder.append(b);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (com.igexin.push.core.g.h && com.igexin.push.core.g.i && com.igexin.push.core.g.j && !com.igexin.push.core.g.l && !a) {
            if (b) {
                if (a.h() || !TextUtils.isEmpty(com.igexin.push.core.g.r)) {
                    com.igexin.b.a.c.a.b("ReconnectTimerTask reconnect timer task isOnline = false, try login...");
                    int d = com.igexin.push.core.f.a().i().d();
                    if (d != 1 && d == 0) {
                        c.b().a(new com.igexin.push.d.b.a());
                        c.b().c();
                    }
                    a(1800000, TimeUnit.MILLISECONDS);
                    return;
                }
                a(900000, TimeUnit.MILLISECONDS);
                com.igexin.b.a.c.a.b("ReconnectTimerTask|date is error, set connect interval = 15min");
                return;
            }
        }
        com.igexin.b.a.c.a.b("ReconnectTimerTask reconnect timer task stop, connect interval= 1h #######");
        a(3600000, TimeUnit.MILLISECONDS);
    }

    public final int b() {
        return -2147483641;
    }

    public void c() {
        super.c();
    }

    public void d() {
    }

    public void h() {
        long j = com.igexin.push.core.g.E;
        StringBuilder stringBuilder = new StringBuilder("ReconnectTimerTask|refreshDelayTime, delay = ");
        stringBuilder.append(j);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (!i.a().e().j()) {
            com.igexin.b.a.c.a.b("ReconnectTimerTask|refreshDelayTime, already enter backup or trynormal #####");
        } else if (i.a().g() == null) {
            com.igexin.b.a.c.a.b("ReconnectTimerTask|detect ip = null and not enter backup,  wait for detect, delay = 3600000");
            j = 3600000;
        }
        a(j, TimeUnit.MILLISECONDS);
    }
}
