package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: ChoicenessLiveStoryInfo */
public final class j {
    public JSONObject a = null;

    public j(JSONObject jSONObject) {
        this.a = jSONObject;
        if (this.a == null) {
            this.a = new JSONObject();
        }
    }

    public final String a() {
        return a(this.a, "userid");
    }

    public final String b() {
        return a(this.a, "avatar");
    }

    public final String c() {
        return a(this.a, "story_tag");
    }

    public final String d() {
        return a(this.a, "story_extra");
    }

    public final String e() {
        return a(this.a, "roomid");
    }

    public static String a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(str)) {
                return jSONObject.optString(str);
            }
        }
        return "";
    }
}
