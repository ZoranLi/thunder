package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChoicenessNetworkHelper */
final class p implements a {
    final /* synthetic */ n a;

    p(n nVar) {
        this.a = nVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        j.b(volleyError, this.a.d);
    }
}
