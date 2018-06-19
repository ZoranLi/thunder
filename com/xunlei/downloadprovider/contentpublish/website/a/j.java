package com.xunlei.downloadprovider.contentpublish.website.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import org.json.JSONObject;

/* compiled from: WebsiteNetworkHelper */
final class j implements b<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        obj = ((JSONObject) obj).optString("result");
        if (ITagManager.SUCCESS.equalsIgnoreCase(obj)) {
            this.a.b.a();
        } else {
            this.a.b.a(obj);
        }
    }
}
