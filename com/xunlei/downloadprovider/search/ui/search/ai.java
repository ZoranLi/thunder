package com.xunlei.downloadprovider.search.ui.search;

import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.shortvideo.entity.LiveExtra;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import org.json.JSONObject;

/* compiled from: MultiUserInfo */
public final class ai implements a {
    VideoUserInfo a;
    String b;
    boolean c;
    String d;
    String e = "";
    String f;
    String g;
    String h;

    public final int a() {
        return 5;
    }

    public final void a(JSONObject jSONObject) {
        try {
            this.a = VideoUserInfo.parseFrom(jSONObject);
            if (jSONObject != null) {
                this.h = jSONObject.optString("kind", "");
                this.c = "rad".equals(this.h);
                this.f = jSONObject.optString("icon_url", "");
                this.d = jSONObject.optString("description", "");
                this.g = jSONObject.optString("uid", RePlugin.PROCESS_UI);
                this.b = jSONObject.optString("title", "");
                jSONObject = jSONObject.optInt("fans_count");
                if (jSONObject != null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(jSONObject);
                    stringBuilder.append(" 粉丝");
                    this.e = stringBuilder.toString();
                }
            }
        } catch (JSONObject jSONObject2) {
            jSONObject2.printStackTrace();
        }
    }

    public final int b() {
        if (!(this.a == null || this.a.getLiveExtra() == null)) {
            LiveExtra liveExtra = this.a.getLiveExtra();
            if ("1".equals(liveExtra.b)) {
                return 1;
            }
            if ("2".equals(liveExtra.b)) {
                return 2;
            }
        }
        return 0;
    }
}
