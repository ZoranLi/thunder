package com.igexin.push.core.a;

import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.e;
import com.igexin.push.config.l;
import com.igexin.push.core.f;
import com.igexin.push.core.g;
import com.igexin.push.d.c.q;
import com.igexin.push.e.j;

public class u extends a {
    private static final String a;

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(l.a);
        stringBuilder.append("_RegisterResultAction");
        a = stringBuilder.toString();
    }

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            g.E = 0;
            StringBuilder stringBuilder = new StringBuilder("register resp |");
            stringBuilder.append(qVar.a);
            stringBuilder.append("|");
            stringBuilder.append(g.q);
            a.b(stringBuilder.toString());
            stringBuilder = new StringBuilder("register resp cid = ");
            stringBuilder.append(qVar.c);
            stringBuilder.append(" device id = ");
            stringBuilder.append(qVar.d);
            a.b(stringBuilder.toString());
            if (qVar.a != g.q) {
                g.m = false;
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" change session : from [");
                stringBuilder.append(g.q);
                stringBuilder.append("] to [");
                stringBuilder.append(qVar.a);
                stringBuilder.append("]");
                a.b(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" change cid : from [");
                stringBuilder.append(g.r);
                stringBuilder.append("] to [");
                stringBuilder.append(qVar.c);
                stringBuilder.append("]");
                a.b(stringBuilder.toString());
                if (TextUtils.isEmpty(qVar.c) || TextUtils.isEmpty(qVar.d)) {
                    com.igexin.push.core.b.g.a().b(qVar.a);
                } else {
                    com.igexin.push.core.b.g.a().a(qVar.c, qVar.d, qVar.a);
                }
                g.G = 0;
            }
            StringBuilder stringBuilder2 = new StringBuilder("loginReqAfterRegister|new session:");
            stringBuilder2.append(g.q);
            stringBuilder2.append(", cid :");
            stringBuilder2.append(g.r);
            stringBuilder2.append(", devId :");
            stringBuilder2.append(g.y);
            a.b(stringBuilder2.toString());
            com.igexin.push.d.c.e c = f.a().c();
            j g = f.a().g();
            StringBuilder stringBuilder3 = new StringBuilder("S-");
            stringBuilder3.append(c.a);
            g.a(stringBuilder3.toString(), c, true);
        }
        return true;
    }
}
