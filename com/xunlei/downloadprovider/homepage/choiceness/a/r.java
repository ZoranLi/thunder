package com.xunlei.downloadprovider.homepage.choiceness.a;

import com.android.volley.VolleyError;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.k;
import org.json.JSONObject;

/* compiled from: ChoicenessNetworkHelper */
final class r implements b<JSONObject> {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        try {
            this.a.b.a(k.a(false, (JSONObject) obj));
        } catch (Object obj2) {
            obj2.printStackTrace();
            j.b((VolleyError) null, this.a.b);
        }
    }
}
