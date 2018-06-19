package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: ShortMovieDetailDataLoader */
final class y implements b<JSONObject> {
    final /* synthetic */ g a;

    y(g gVar) {
        this.a = gVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        new StringBuilder("like users response=>").append(jSONObject.toString());
        String optString = jSONObject.optString("result");
        if (optString != null) {
            if (optString.contentEquals(ITagManager.SUCCESS)) {
                int i = 0;
                int optInt = jSONObject.optInt("praise_num", 0);
                ArrayList arrayList = new ArrayList(3);
                obj = jSONObject.optJSONArray("data");
                if (obj != null && obj.length() > 0) {
                    int length = obj.length();
                    while (i < length) {
                        try {
                            JSONObject optJSONObject = obj.optJSONObject(i);
                            v vVar = new v();
                            vVar.a = optJSONObject.getLong(SocializeConstants.TENCENT_UID);
                            vVar.b = optJSONObject.getString("user_title");
                            if (vVar.b == null || vVar.b.trim().isEmpty()) {
                                vVar.b = "迅雷用户";
                            }
                            vVar.c = optJSONObject.getString("user_poster_url");
                            vVar.d = optJSONObject.getString("user_description");
                            vVar.e = optJSONObject.optBoolean("is_follow");
                            vVar.f = optJSONObject.optString("row_key");
                            arrayList.add(vVar);
                            i++;
                        } catch (Object obj2) {
                            new StringBuilder("like users response=>").append(obj2.getMessage());
                        }
                    }
                }
                this.a.p.post(new aa(this, optInt, arrayList));
                return;
            }
        }
        this.a.p.post(new z(this, optString));
    }
}
