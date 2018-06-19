package com.xunlei.downloadprovider.vod.subtitle;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: SubtitleManager */
public final class h implements b<JSONObject> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ g c;

    public h(g gVar, String str, String str2) {
        this.c = gVar;
        this.a = str;
        this.b = str2;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        g.a;
        new StringBuilder("exect request resp =>").append(jSONObject);
        SubtitleManifest parseFromJson = SubtitleManifest.parseFromJson(jSONObject);
        if (parseFromJson == null || parseFromJson.getListCount() <= 0) {
            if (this.c.h != null) {
                this.c.d.post(new i(this));
            }
            return;
        }
        parseFromJson.setRelatedGcid(this.a);
        parseFromJson.setRelatedName(this.b);
        g.a(this.c, parseFromJson);
    }
}
