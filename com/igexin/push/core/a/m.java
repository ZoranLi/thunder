package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.push.c.i;
import com.igexin.push.core.b.af;
import com.igexin.push.core.f;
import com.igexin.push.core.g;
import com.igexin.push.d.b;
import com.igexin.push.util.e;

public class m extends a {
    private void b() {
        b.a().f();
        StringBuilder stringBuilder = new StringBuilder("loginRsp|");
        stringBuilder.append(g.r);
        stringBuilder.append("|success");
        a.b(stringBuilder.toString());
        stringBuilder = new StringBuilder("isCidBroadcasted|");
        stringBuilder.append(g.m);
        a.b(stringBuilder.toString());
        if (!g.m) {
            f.a().k();
            g.m = true;
        }
        g.l = true;
        f.a().l();
        f.a().h();
        if (TextUtils.isEmpty(g.y)) {
            a.b("LoginResultAction device id is empty, get device id from server +++++");
            f.a().i();
        }
        e.f();
        e();
        a();
        d();
        com.igexin.push.core.b.g.a().b();
        f.a().h().a();
        f();
        g();
    }

    private void c() {
        StringBuilder stringBuilder = new StringBuilder("loginRsp|");
        stringBuilder.append(g.r);
        stringBuilder.append("|failed");
        a.b(stringBuilder.toString());
        a.b("LoginResultAction login failed, clear session or cid");
        com.igexin.push.core.b.g.a().c();
        f.a().c(true);
    }

    private void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x002a }
        r2 = com.igexin.push.core.g.K;	 Catch:{ Exception -> 0x002a }
        r4 = r0 - r2;	 Catch:{ Exception -> 0x002a }
        r0 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Exception -> 0x002a }
        r2 = r4 - r0;	 Catch:{ Exception -> 0x002a }
        r0 = 0;	 Catch:{ Exception -> 0x002a }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));	 Catch:{ Exception -> 0x002a }
        if (r4 <= 0) goto L_0x002a;	 Catch:{ Exception -> 0x002a }
    L_0x0013:
        r0 = com.igexin.b.a.b.c.b();	 Catch:{ Exception -> 0x002a }
        r1 = new com.igexin.push.f.a.c;	 Catch:{ Exception -> 0x002a }
        r2 = new com.igexin.push.core.c.f;	 Catch:{ Exception -> 0x002a }
        r3 = com.igexin.push.config.SDKUrlConfig.getConfigServiceUrl();	 Catch:{ Exception -> 0x002a }
        r2.<init>(r3);	 Catch:{ Exception -> 0x002a }
        r1.<init>(r2);	 Catch:{ Exception -> 0x002a }
        r2 = 0;	 Catch:{ Exception -> 0x002a }
        r3 = 1;	 Catch:{ Exception -> 0x002a }
        r0.a(r1, r2, r3);	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.m.d():void");
    }

    private void e() {
        if ((System.currentTimeMillis() - g.H) - 259200000 >= 0 && com.igexin.push.config.m.h) {
            String c = f.a().c("ua");
            boolean z = c == null || "1".equals(c);
            if (z) {
                c.b().a(new o(this), false, true);
            }
        }
    }

    private void f() {
        try {
            if (System.currentTimeMillis() - g.M > 86400000) {
                com.igexin.push.core.b.g.a().g(System.currentTimeMillis());
                af.a().b("21");
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("LoginResultAction|report third party guard exception :");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
    }

    private void g() {
        if (com.igexin.assist.sdk.a.e(g.f)) {
            c.b().a(new p(this), false, true);
        }
    }

    public void a() {
        int a = 1 ^ com.igexin.b.b.a.a(g.A, g.z);
        if (!(((System.currentTimeMillis() - g.G) - 86400000 > 0 ? 1 : 0) == 0 && a == 0)) {
            if (TextUtils.isEmpty(g.y)) {
                if (g.av != null) {
                    g.av.u();
                    g.av = null;
                }
                g.av = new n(this, 5000);
                f.a().a(g.av);
                return;
            }
            f.a().j();
        }
    }

    public boolean a(com.igexin.b.a.d.e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof com.igexin.push.d.c.m) {
            g.E = 0;
            if (!g.l) {
                i.a().e().h();
                if (((com.igexin.push.d.c.m) obj).a) {
                    b();
                } else {
                    c();
                }
            }
        }
        return true;
    }
}
