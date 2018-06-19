package com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

import android.text.TextUtils;
import com.android.volley.n.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;
import org.json.JSONObject;

/* compiled from: TouTiaoNetwork */
final class c implements b<JSONObject> {
    final /* synthetic */ a a;
    final /* synthetic */ b b;

    c(b bVar, a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        b.a.a aVar = new b.a.a();
        b.a.a(aVar, jSONObject);
        if (b.a.a(aVar)) {
            obj = jSONObject.optJSONObject("data");
            if (obj == null) {
                aVar.b = -1001;
                aVar.c = "data is empty";
            } else {
                Object optString = obj.optString("access_token");
                obj = obj.optInt("expires_in");
                if (!TextUtils.isEmpty(optString)) {
                    if (obj > null) {
                        aVar.a = new com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a(optString, obj);
                    }
                }
                aVar.b = -1001;
                aVar.c = "accessToken is empty or expires_in is smaller than 0";
            }
        }
        if (b.a.a(aVar) != null) {
            this.a.a(aVar.a);
        } else {
            this.a.a(aVar.b, aVar.c);
        }
    }
}
