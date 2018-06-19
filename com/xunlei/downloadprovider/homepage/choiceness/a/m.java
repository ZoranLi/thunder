package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.VolleyError;
import com.android.volley.n.a;

/* compiled from: ChoicenessNetworkHelper */
final class m implements a {
    final /* synthetic */ k a;

    m(k kVar) {
        this.a = kVar;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        j.b(volleyError, this.a.d);
    }
}
