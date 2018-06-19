package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.web.website.b.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class t implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ j b;

    t(j jVar, c cVar) {
        this.b = jVar;
        this.a = cVar;
    }

    public final void run() {
        try {
            long c = LoginHelper.a().g.c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", c);
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", this.a.b);
            jSONObject2.put("collect_time", System.currentTimeMillis() / 1000);
            jSONArray.put(jSONObject2);
            jSONObject.put("site_list", jSONArray);
            j.a(this.b, false, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
