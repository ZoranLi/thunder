package com.xunlei.downloadprovider.search.ui.search;

import org.json.JSONObject;

/* compiled from: MultiWebsiteInfo */
public final class ak implements a {
    String a;
    String b;
    String c;
    String d;
    String e;
    String f;
    String g;

    public final int a() {
        return 4;
    }

    public final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject.optString("user_name", "");
            this.c = jSONObject.optString("user_icon_url", "");
            this.d = jSONObject.optString("poster", "");
            this.e = jSONObject.optString("url", "");
            this.f = jSONObject.optString("title", "");
            this.a = jSONObject.optString("uid", "");
            this.g = jSONObject.optString("user_kind", "");
        }
    }
}
