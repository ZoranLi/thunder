package com.xunlei.downloadprovider.publiser.campaign.a;

import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.shortvideo.entity.AudioInfo;
import com.xunlei.downloadprovider.shortvideo.entity.LocationInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TopicData */
public final class b {
    public boolean a;
    public boolean b;
    public String c;
    public List<n> d = new ArrayList();
    public d e = new d();
    public AudioInfo f;
    public LocationInfo g;

    public static b a(JSONObject jSONObject) {
        b bVar = new b();
        int i = 0;
        if (jSONObject == null || !ITagManager.SUCCESS.equals(jSONObject.optString("result"))) {
            bVar.a = false;
        } else {
            bVar.a = true;
            bVar.b = jSONObject.optBoolean("is_more");
            bVar.c = jSONObject.optString("cursor");
            JSONArray optJSONArray = jSONObject.optJSONArray("list");
            if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        bVar.d.add(n.a(optJSONObject));
                    }
                    i++;
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("topic_info");
            if (optJSONObject2 != null) {
                d dVar;
                if (optJSONObject2 == null) {
                    dVar = null;
                } else {
                    d dVar2 = new d();
                    dVar2.b = optJSONObject2.optString("desc1");
                    dVar2.c = optJSONObject2.optString("desc2");
                    dVar2.d = optJSONObject2.optString("poster");
                    dVar2.e = optJSONObject2.optString("title");
                    dVar2.f = optJSONObject2.optLong("count");
                    dVar2.g = optJSONObject2.optBoolean("is_activity");
                    dVar2.h = optJSONObject2.optInt("jump_type");
                    dVar = dVar2;
                }
                bVar.e = dVar;
            }
            optJSONObject2 = jSONObject.optJSONObject("audio_info");
            if (optJSONObject2 != null) {
                bVar.f = AudioInfo.a(optJSONObject2);
            }
            jSONObject = jSONObject.optJSONObject("location_info");
            if (jSONObject != null) {
                bVar.g = LocationInfo.a(jSONObject);
            }
        }
        return bVar;
    }
}
