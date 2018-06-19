package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: ChoicenessNetworkHelper */
final class o implements b<JSONObject> {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        j.a(this.a.e, (JSONObject) obj, this.a.d);
        this.a.e.a = this.a.e.a + 1;
    }
}
