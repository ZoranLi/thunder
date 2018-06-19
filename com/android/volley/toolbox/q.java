package com.android.volley.toolbox;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ImageLoader */
final class q implements a {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    q(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        o oVar = this.b;
        String str = this.a;
        a aVar = (a) oVar.c.remove(str);
        if (aVar != null) {
            aVar.b = volleyError;
            oVar.a(str, aVar);
        }
    }
}
