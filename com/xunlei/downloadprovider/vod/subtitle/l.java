package com.xunlei.downloadprovider.vod.subtitle;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: SubtitleManager */
public final class l implements b<JSONObject> {
    final /* synthetic */ g a;

    public l(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        new StringBuilder("reportSubtitleManifestUseDuration =>").append((JSONObject) obj);
    }
}
