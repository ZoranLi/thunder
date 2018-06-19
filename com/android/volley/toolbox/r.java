package com.android.volley.toolbox;

import com.android.volley.toolbox.o.c;
import java.util.Iterator;

/* compiled from: ImageLoader */
final class r implements Runnable {
    final /* synthetic */ o a;

    r(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        for (a aVar : this.a.d.values()) {
            Iterator it = aVar.c.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (cVar.b != null) {
                    if (aVar.b == null) {
                        cVar.a = aVar.a;
                        cVar.b.a(cVar, false);
                    } else {
                        cVar.b.onErrorResponse(aVar.b);
                    }
                }
            }
        }
        this.a.d.clear();
        this.a.e = null;
    }
}
