package com.xunlei.downloadprovider.download.tasklist.list.banner;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BannerOnlineServerHelper */
final class n implements b<JSONObject> {
    final /* synthetic */ m a;

    n(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            try {
                if (ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("data");
                    if (optJSONArray != null) {
                        if (optJSONArray.length() != 0) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                a a = a.a();
                                int optInt = optJSONArray.optInt(i);
                                if (!a.b.contains(Integer.valueOf(optInt))) {
                                    a.b.add(Integer.valueOf(optInt));
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONObject.toString();
    }
}
