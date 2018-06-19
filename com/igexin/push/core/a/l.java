package com.igexin.push.core.a;

import com.igexin.b.a.c.a;
import com.igexin.b.a.d.e;
import com.igexin.push.core.f;
import com.igexin.push.d.c.j;

public class l extends a {
    private static final String a = "com.igexin.push.core.a.l";

    public boolean a(e eVar) {
        return false;
    }

    public boolean a(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            boolean z = jVar.a == (byte) 0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|KeyNego result = ");
            stringBuilder.append(jVar.a);
            a.b(stringBuilder.toString());
            if (z) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("|KeyNego success and login");
                a.b(stringBuilder2.toString());
                f.a().i().e();
            }
        }
        return true;
    }
}
