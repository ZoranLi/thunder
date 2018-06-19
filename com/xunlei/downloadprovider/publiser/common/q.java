package com.xunlei.downloadprovider.publiser.common;

import com.xunlei.downloadprovider.homepage.follow.c.ar;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.XLSexType;
import com.xunlei.downloadprovider.publiser.common.VisitorNetworkHelper.Entrance;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VisitorNetworkHelper */
final class q implements Runnable {
    final /* synthetic */ long a;
    final /* synthetic */ Entrance b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ String e;
    final /* synthetic */ String f;
    final /* synthetic */ VisitorNetworkHelper g;

    q(VisitorNetworkHelper visitorNetworkHelper, long j, Entrance entrance, String str, String str2, String str3, String str4) {
        this.g = visitorNetworkHelper;
        this.a = j;
        this.b = entrance;
        this.c = str;
        this.d = str2;
        this.e = str3;
        this.f = str4;
    }

    public final void run() {
        try {
            if (LoginHelper.a().g.c() != this.a) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", this.a);
                jSONObject.put("visitor_uid", LoginHelper.a().g.c());
                jSONObject.put("entrance", this.b.value());
                jSONObject.put("gcid", this.c);
                jSONObject.put(PushResult.VIDEO_ID, this.d);
                jSONObject.put("src_id", this.e);
                jSONObject.put("content", this.f.length() > 40 ? this.f.substring(0, 40) : this.f);
                jSONObject.put("gender", XLSexType.MALE.equals(LoginHelper.a().g()) ? 1 : 2);
                new StringBuilder("addVisitLog post request =>http://api-shoulei-ssl.xunlei.com/user_visits/client_visit/add_visit_log|").append(jSONObject);
                this.g.a(new ar(1, "http://api-shoulei-ssl.xunlei.com/user_visits/client_visit/add_visit_log", jSONObject, new r(this), new s(this)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
