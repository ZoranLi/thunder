package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class aj implements b<JSONObject> {
    final /* synthetic */ ai a;

    aj(ai aiVar) {
        this.a = aiVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String optString = jSONObject.optString("result");
        StringBuilder stringBuilder = new StringBuilder("getFollowingLiveList() onResponse result=");
        stringBuilder.append(optString);
        stringBuilder.append(" json=");
        stringBuilder.append(jSONObject.toString());
        if (ITagManager.SUCCESS.equals(optString)) {
            boolean optBoolean = jSONObject.optBoolean("new_live");
            List arrayList = new ArrayList();
            obj = jSONObject.optJSONArray("list");
            if (optBoolean && obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    try {
                        arrayList.add(a.a(obj.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.a.b.a(arrayList, Boolean.valueOf(optBoolean));
            return;
        }
        this.a.b.a(optString);
    }
}
