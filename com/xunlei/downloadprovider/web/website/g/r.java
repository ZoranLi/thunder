package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.web.website.b.c;
import com.xunlei.downloadprovider.web.website.c.a;
import com.xunlei.xllib.b.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: WebsiteSyncServer */
final class r implements Runnable {
    final /* synthetic */ j a;

    r(j jVar) {
        this.a = jVar;
    }

    public final void run() {
        try {
            long c = LoginHelper.a().g.c();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uid", c);
            JSONArray jSONArray = new JSONArray();
            Object<c> a = a.a();
            if (!d.a(a)) {
                for (c a2 : a) {
                    jSONArray.put(j.a(a2));
                }
                jSONObject.put("site_list", jSONArray);
                j.a(this.a, true, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
