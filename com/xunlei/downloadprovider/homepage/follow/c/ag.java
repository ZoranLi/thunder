package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class ag implements b<JSONObject> {
    final /* synthetic */ af a;

    ag(af afVar) {
        this.a = afVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String optString = jSONObject.optString("result");
        int optInt = jSONObject.optInt("count");
        String optString2 = jSONObject.optString("cursor");
        boolean optBoolean = jSONObject.optBoolean("is_more");
        StringBuilder stringBuilder = new StringBuilder("getFollowingList() onResponse result=");
        stringBuilder.append(optString);
        stringBuilder.append(" json=");
        stringBuilder.append(jSONObject.toString());
        if (ITagManager.SUCCESS.equals(optString)) {
            obj = jSONObject.optJSONArray("list");
            List arrayList = new ArrayList();
            if (obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    try {
                        arrayList.add(a.b(obj.getJSONObject(i)));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            this.a.b.a(Integer.valueOf(optInt), arrayList, optString2, Boolean.valueOf(optBoolean));
        } else if ("data error".equals(optString) != null) {
            this.a.b.a(Integer.valueOf(optInt), new ArrayList(), optString2, Boolean.valueOf(optBoolean));
        } else {
            this.a.b.a(optString);
        }
    }
}
