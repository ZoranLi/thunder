package com.xunlei.downloadprovider.personal.playrecord;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: LiveVideoPlayRecord */
public final class b extends VideoPlayRecord {
    JSONObject a;

    public b(JSONObject jSONObject) {
        this.a = jSONObject.optJSONObject("roominfo");
        if (this.a == null) {
            this.a = new JSONObject();
        }
        long optLong = jSONObject.optLong("view_time", 0);
        if (String.valueOf(optLong).length() == 10) {
            optLong *= 1000;
        }
        this.b = Long.valueOf(Long.parseLong(d().replace("_", "")));
        this.j = optLong;
        this.d = d();
        h();
    }

    public final String a() {
        return b(i(), "avatar");
    }

    public final String b() {
        return b(i(), "nickname");
    }

    public final String c() {
        return b(this.a, "title");
    }

    public final String d() {
        return b(this.a, "roomid");
    }

    public final String e() {
        return j() == null ? "" : b(j().optJSONObject("level_info"), "image_leve");
    }

    public final boolean f() {
        if (a(this.a, "status") != 1) {
            if (a(this.a, "status") != 3) {
                return false;
            }
        }
        return true;
    }

    private JSONObject i() {
        return this.a.optJSONObject("userinfo");
    }

    private JSONObject j() {
        return this.a.optJSONObject("playerinfo");
    }

    private static String b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(str)) {
                return jSONObject.optString(str);
            }
        }
        return "";
    }

    static int a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            if (!TextUtils.isEmpty(str)) {
                return jSONObject.optInt(str);
            }
        }
        return null;
    }
}
