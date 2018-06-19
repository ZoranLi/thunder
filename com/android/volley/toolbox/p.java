package com.android.volley.toolbox;

import android.graphics.Bitmap;
import com.android.volley.n.b;

/* compiled from: ImageLoader */
final class p implements b<Bitmap> {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    p(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        o oVar = this.b;
        String str = this.a;
        a aVar = (a) oVar.c.remove(str);
        if (aVar != null) {
            aVar.a = bitmap;
            oVar.a(str, aVar);
        }
    }
}
