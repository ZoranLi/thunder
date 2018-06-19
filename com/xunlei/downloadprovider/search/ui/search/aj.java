package com.xunlei.downloadprovider.search.ui.search;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import org.json.JSONObject;

/* compiled from: MultiVideoInfo */
public final class aj implements a {
    String a;
    String b;
    String c;
    String d;
    int e;

    public final int a() {
        return 6;
    }

    public final void a(JSONObject jSONObject) {
        this.c = jSONObject.optString("movieid", "");
        this.e = jSONObject.optInt(SocializeProtocolConstants.DURATION, 0);
        this.d = jSONObject.optString("title", "");
        if (jSONObject.optString("user_name") != null) {
            StringBuilder stringBuilder = new StringBuilder("发布者：");
            stringBuilder.append(jSONObject.optString("user_name"));
            this.a = stringBuilder.toString();
        }
        this.b = jSONObject.optString("cover_url", "");
    }
}
