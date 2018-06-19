package com.xunlei.downloadprovider.contentpublish.website.a;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.payment.a.e.a;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: WebsiteNetworkHelper */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ a b;
    final /* synthetic */ b c;

    i(b bVar, String str, a aVar) {
        this.c = bVar;
        this.a = str;
        this.b = aVar;
    }

    public final void run() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AgooConstants.MESSAGE_ID, this.a);
            this.c.a(new ar(1, "http://api-shoulei-ssl.xunlei.com/fav_site/api/pub/delete", jSONObject, new j(this), new k(this)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
