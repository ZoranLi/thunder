package com.xunlei.downloadprovider.e.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: LikePresenterImpl */
final class h implements a {
    final /* synthetic */ f.a a;
    final /* synthetic */ f b;

    h(f fVar, f.a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.a != null) {
            f.a aVar = this.a;
            volleyError.toString();
            aVar.b();
        }
    }
}
