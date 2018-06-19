package com.getui.gtc.b;

import android.content.Context;
import com.getui.gtc.a.b;
import com.getui.gtc.a.h;
import com.getui.gtc.b.a.a;
import com.getui.gtc.e.e;
import com.getui.gtc.entity.d;
import java.io.File;

final class g implements a {
    final /* synthetic */ c a;

    g(c cVar) {
        this.a = cVar;
    }

    public final void a(d dVar, int i, String str) {
        g gVar = this;
        d dVar2 = dVar;
        int i2 = i;
        com.getui.gtc.entity.a aVar = (com.getui.gtc.entity.a) h.d.get(dVar2.a);
        if (aVar != null) {
            int i3 = 0;
            int intValue = ((Integer) h.c.get(dVar2.a, Integer.valueOf(0))).intValue() + 1;
            h.c.put(dVar2.a, Integer.valueOf(intValue));
            com.getui.gtc.entity.a b = b.b().b(dVar2.a);
            if (b == null || b.b.size() <= 0) {
                b = new com.getui.gtc.entity.a();
                b.a = "0";
            } else {
                com.getui.gtc.entity.a.a a = b.a(i2);
                if (a != null) {
                    b.b(i2);
                    e.a(a.c);
                    i3 = 1;
                }
            }
            com.getui.gtc.entity.a aVar2 = b;
            b b2 = b.b();
            b2.a.b.b.put(dVar2.a, aVar2);
            com.getui.gtc.entity.a.a a2 = aVar.a(i2);
            if (a2 != null) {
                String str2 = str;
                if (new File(str2).exists()) {
                    aVar2.a(i2, a2);
                    aVar2.a = aVar.a;
                    if (i3 == 0) {
                        c cVar = gVar.a;
                        Context context = h.a;
                        String str3 = a2.d;
                        String str4 = a2.f;
                        String str5 = a2.c;
                        if (cVar.a(context, str2, str3, str4, str5, gVar.a.d, dVar2, a2.e)) {
                            a2.g = System.currentTimeMillis();
                        }
                        if (a2.j) {
                            e.a(a2.c);
                            aVar2.b(i2);
                        }
                    }
                    if (intValue == aVar.b.size()) {
                        b.b().a(dVar2.a, aVar2);
                        b.b().b(dVar2.a, dVar2.f);
                    }
                }
            }
        }
    }
}
