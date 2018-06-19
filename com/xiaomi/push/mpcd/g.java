package com.xiaomi.push.mpcd;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xiaomi.channel.commonutils.misc.h;
import com.xiaomi.channel.commonutils.misc.h.a;
import com.xiaomi.push.mpcd.job.b;
import com.xiaomi.push.mpcd.job.c;
import com.xiaomi.push.mpcd.job.d;
import com.xiaomi.push.mpcd.job.e;
import com.xiaomi.push.mpcd.job.i;
import com.xiaomi.push.mpcd.job.j;
import com.xiaomi.push.mpcd.job.k;
import com.xiaomi.push.mpcd.job.m;
import com.xiaomi.push.service.am;

public class g {
    private static volatile g a;
    private Context b;

    private g(Context context) {
        this.b = context;
    }

    private int a(int i) {
        return Math.max(60, i);
    }

    public static g a(Context context) {
        if (a == null) {
            synchronized (g.class) {
                if (a == null) {
                    a = new g(context);
                }
            }
        }
        return a;
    }

    private void b() {
        h a = h.a(this.b);
        am a2 = am.a(this.b);
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) >= 172800000) {
            int a3;
            boolean a4 = a2.a(com.xiaomi.xmpush.thrift.g.c.a(), true);
            boolean a5 = a2.a(com.xiaomi.xmpush.thrift.g.f.a(), true);
            boolean a6 = a2.a(com.xiaomi.xmpush.thrift.g.g.a(), true);
            boolean a7 = a2.a(com.xiaomi.xmpush.thrift.g.h.a(), true);
            boolean a8 = a2.a(com.xiaomi.xmpush.thrift.g.ap.a(), true);
            if (a4 || a5 || a6 || a7 || a8) {
                int a9 = a(a2.a(com.xiaomi.xmpush.thrift.g.i.a(), 1209600));
                a aVar = r6;
                a hVar = new com.xiaomi.push.mpcd.job.h(r0.b, a9, a4, a5, a6, a7, a8);
                a.a(aVar, a9, 30);
            }
            a4 = a2.a(com.xiaomi.xmpush.thrift.g.d.a(), true);
            a5 = a2.a(com.xiaomi.xmpush.thrift.g.e.a(), true);
            a6 = a2.a(com.xiaomi.xmpush.thrift.g.ag.a(), true);
            a7 = a2.a(com.xiaomi.xmpush.thrift.g.aq.a(), true);
            if (a4 || a5 || a6 || a7) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.ar.a(), 1209600));
                a.a(new com.xiaomi.push.mpcd.job.g(r0.b, a3, a4, a5, a6, a7), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.j.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.k.a(), 86400));
                a.a(new c(r0.b, a3), a3, 30);
            }
            if (VERSION.SDK_INT < 21 && a2.a(com.xiaomi.xmpush.thrift.g.l.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.m.a(), SecExceptionCode.SEC_ERROR_UMID_VALID));
                a.a(new b(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.n.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.o.a(), 10800));
                a.a(new d(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.r.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.s.a(), 604800));
                a.a(new com.xiaomi.push.mpcd.job.a(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.t.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.u.a(), SecExceptionCode.SEC_ERROR_UMID_VALID));
                a.a(new k(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.x.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.y.a(), 300));
                a.a(new i(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.Q.a(), true)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.R.a(), SecExceptionCode.SEC_ERROR_UMID_VALID));
                a.a(new e(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.W.a(), false)) {
                a3 = a(a2.a(com.xiaomi.xmpush.thrift.g.X.a(), SecExceptionCode.SEC_ERROR_UMID_VALID));
                a.a(new m(r0.b, a3), a3, 30);
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.ao.a(), false)) {
                c();
            }
            if (a2.a(com.xiaomi.xmpush.thrift.g.a.a(), true)) {
                a.a(new j(r0.b), a(a2.a(com.xiaomi.xmpush.thrift.g.b.a(), 86400)), 60);
            }
        }
    }

    private boolean c() {
        if (VERSION.SDK_INT >= 14) {
            try {
                ((Application) (this.b instanceof Application ? this.b : this.b.getApplicationContext())).registerActivityLifecycleCallbacks(new a(this.b, String.valueOf(System.currentTimeMillis() / 1000)));
                return true;
            } catch (Throwable e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
            }
        }
        return false;
    }

    public void a() {
        h.a(this.b).a(new h(this), 30);
    }
}
