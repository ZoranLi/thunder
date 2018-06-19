package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class aa implements b<JSONObject> {
    final /* synthetic */ z a;

    aa(z zVar) {
        this.a = zVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        String optString = jSONObject.optString("result");
        if (ITagManager.SUCCESS.equals(optString)) {
            obj = jSONObject.optJSONArray("list");
            Set hashSet = new HashSet();
            if (obj != null) {
                for (int i = 0; i < obj.length(); i++) {
                    try {
                        long j = obj.getLong(i);
                        if (j > 0) {
                            hashSet.add(Long.valueOf(j));
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            a.j(new ab(this, hashSet));
            return;
        }
        a.j(new ac(this, optString));
    }
}
