package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class ap implements b<JSONObject> {
    final /* synthetic */ ao a;

    ap(ao aoVar) {
        this.a = aoVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String optString = jSONObject.optString("result");
        if (ITagManager.SUCCESS.equals(optString)) {
            List arrayList = new ArrayList();
            obj = jSONObject.optJSONArray("list");
            if (obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    try {
                        arrayList.add(g.a(obj.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.a.b.onSuccess(arrayList);
            return;
        }
        this.a.b.onFail(optString);
    }
}
