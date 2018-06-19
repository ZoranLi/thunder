package com.xunlei.downloadprovider.publiser.common;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.a;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VisitorNetworkHelper */
final class t implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ a b;
    final /* synthetic */ VisitorNetworkHelper c;

    t(VisitorNetworkHelper visitorNetworkHelper, long j, a aVar) {
        this.c = visitorNetworkHelper;
        this.a = j;
        this.b = aVar;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", this.a);
            new StringBuilder("getVisitCount post request =>http://api-shoulei-ssl.xunlei.com/user_visits/client_visit/get_visit_log|").append(jSONObject);
            this.c.a(new ar(1, "http://api-shoulei-ssl.xunlei.com/user_visits/client_visit/get_visit_log", jSONObject, new u(this), new v(this)));
        } catch (JSONException e) {
            e.printStackTrace();
            this.b.a(0);
        }
    }
}
