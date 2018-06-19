package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.xiaomi.metoknlp.a;
import com.xiaomi.metoknlp.a.d;
import com.xiaomi.metoknlp.b;
import java.util.ArrayList;
import java.util.HashMap;

public class n {
    private static String a;
    private static n i;
    private Object b = new Object();
    private g c;
    private int d = 0;
    private d e = new d();
    private h f;
    private k g;
    private Context h;
    private Handler j = new b(this);

    public static n a() {
        if (i == null) {
            i = new n();
        }
        return i;
    }

    private void a(HashMap hashMap) {
        if (hashMap != null) {
            String c = j.c(this.h);
            if (!(this.e == null || c == null)) {
                this.e.g(c);
                if (hashMap.containsKey(c)) {
                    this.e.h((String) hashMap.get(c));
                }
            }
            c = j.b(this.h);
            if (c != null && hashMap.containsKey(c)) {
                hashMap.remove(c);
            }
            if (this.e != null && hashMap.size() > 0) {
                this.e.a(new ArrayList(hashMap.values()));
                c();
            }
        }
    }

    private void e() {
        m.a(this.h, this.j, 0);
    }

    private void f() {
        String d = j.d(this.h);
        String a = j.a(this.h, 2);
        String a2 = j.a(this.h, 1);
        if (!(d == null || a == null || a2 == null || this.e == null)) {
            this.e.a(Build.MODEL).b(d.b()).c(d).f(a).e(a2).a(this.f.a()).b(this.f.b());
        }
    }

    private void g() {
        c();
    }

    private void h() {
        if (this.d == 4 && this.e != null) {
            ((a) this.h).a(this.e.a().a().toString());
        }
    }

    private void i() {
        this.g = new k();
        a = b.a().e();
        StringBuffer stringBuffer = new StringBuffer(a);
        stringBuffer.append("/api/v2/realip");
        String stringBuffer2 = stringBuffer.toString();
        this.g.execute(new String[]{stringBuffer2});
    }

    public void a(Context context) {
        this.h = context;
        this.f = new h();
        this.c = new g(context);
        this.c.b();
        this.c.a(this.f);
    }

    public void b() {
        if (this.c != null) {
            this.c.c();
            this.c.d();
            this.c = null;
        }
        this.f = null;
    }

    void c() {
        if (b.a().f()) {
            switch (this.d) {
                case 0:
                    this.d = 1;
                    f();
                    if (this.e != null) {
                        e();
                    }
                    return;
                case 1:
                    this.d = 2;
                    g();
                    return;
                case 2:
                    this.d = 3;
                    i();
                    return;
                case 3:
                    this.d = 4;
                    this.g.cancel(true);
                    this.g = null;
                    h();
                    return;
                default:
                    return;
            }
        }
    }

    public void d() {
        if (this.c != null) {
            this.c.a();
        }
    }
}
