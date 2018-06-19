package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.web.website.b.c;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class s implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ j b;

    s(j jVar, c cVar) {
        this.b = jVar;
        this.a = cVar;
    }

    public final void run() {
        try {
            long c = LoginHelper.a().g.c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", c);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(j.a(this.a));
            jSONObject.put("site_list", jSONArray);
            j.a(this.b, true, jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
