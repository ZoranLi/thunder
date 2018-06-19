package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;

public class r extends m implements o {
    private static final String e = "com.igexin.push.c.r";
    private static r f;

    private r() {
        super(g.ay, g.aA);
    }

    public static synchronized r a() {
        r rVar;
        synchronized (r.class) {
            if (f == null) {
                f = new r();
            }
            rVar = f;
        }
        return rVar;
    }

    public void a(g gVar, j jVar) {
        if (jVar != null && !TextUtils.isEmpty(jVar.a())) {
            p a = a(jVar.a());
            if (a != null) {
                b(jVar);
                if (gVar == g.SUCCESS) {
                    a.g();
                    a.j();
                    k();
                    n();
                    return;
                }
                if (gVar == g.EXCEPTION || gVar == g.FAILED) {
                    o();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(e);
                    stringBuilder.append("|detect");
                    stringBuilder.append(c(jVar));
                    stringBuilder.append("failed --------------");
                    a.b(stringBuilder.toString());
                    if (q()) {
                        a.g();
                        return;
                    }
                    a.a(false);
                }
            }
        }
    }

    public void a(j jVar) {
    }

    public h b() {
        return h.WIFI;
    }

    public o c() {
        return this;
    }
}
