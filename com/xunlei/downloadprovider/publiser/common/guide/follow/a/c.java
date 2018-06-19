package com.xunlei.downloadprovider.publiser.common.guide.follow.a;

import com.xunlei.download.Downloads.Impl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: GuideFollowInfoParser */
public class c {
    private static final String a = "c";

    static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.b = jSONObject.optInt(Impl.COLUMN_GROUP_ID, -1);
        aVar.d = jSONObject.optString("title");
        aVar.e = jSONObject.optString("desc");
        aVar.c = jSONObject.optInt("select_default", 1);
        jSONObject = jSONObject.optJSONArray("pub_list");
        if (jSONObject != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < jSONObject.length(); i++) {
                Object obj;
                JSONObject optJSONObject = jSONObject.optJSONObject(i);
                if (optJSONObject == null) {
                    obj = null;
                } else {
                    obj = new m();
                    obj.o = optJSONObject.optInt(Impl.COLUMN_GROUP_ID);
                    obj.f = optJSONObject.optString("icon_url");
                    obj.b = optJSONObject.optLong("uid");
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
            aVar.a = arrayList;
        }
        return aVar;
    }
}
