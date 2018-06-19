package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChoicenessNetworkHelper */
final class s implements a {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        j.b(volleyError, this.a.b);
    }
}
