package com.igexin.push.c;

import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;

public class l extends m implements o {
    private static final String e = "com.igexin.push.c.l";
    private static l f;

    private l() {
        super(g.ax, g.az);
    }

    public static synchronized l a() {
        l lVar;
        synchronized (l.class) {
            if (f == null) {
                f = new l();
            }
            lVar = f;
        }
        return lVar;
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
                    stringBuilder.append("failed --------");
                    a.b(stringBuilder.toString());
                    if (q()) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(e);
                        stringBuilder.append("|pool is not empty, detect task ");
                        stringBuilder.append(c(jVar));
                        stringBuilder.append("stop");
                        a.b(stringBuilder.toString());
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
        return h.MOBILE;
    }

    public o c() {
        return this;
    }
}
