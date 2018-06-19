package com.xunlei.downloadprovider.pushmessage.report;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: PushNetworkHelper */
final class j implements b<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        new StringBuilder("onResponse jsonObject").append((JSONObject) obj);
    }
}
