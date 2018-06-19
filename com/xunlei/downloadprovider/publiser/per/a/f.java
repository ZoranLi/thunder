package com.xunlei.downloadprovider.publiser.per.a;

import com.android.volley.n.b;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.downloadprovider.publiser.per.model.PersonalFeedInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: PublishNetworkHelper */
final class f implements b<JSONObject> {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        a.a;
        new StringBuilder("getDynamicList response =>").append(jSONObject);
        String optString = jSONObject.optString("result");
        if (ITagManager.SUCCESS.equalsIgnoreCase(optString)) {
            int i = 0;
            int optInt = jSONObject.optInt("dynamic_count", 0);
            obj = jSONObject.optJSONArray("publish_list");
            Object obj2 = null;
            if (obj != null) {
                int length = obj.length();
                List arrayList = new ArrayList(length);
                while (i < length) {
                    PersonalFeedInfo parseDynamicInfoFrom = PersonalFeedInfo.parseDynamicInfoFrom(obj.optJSONObject(i));
                    if (parseDynamicInfoFrom == null || parseDynamicInfoFrom.getData() == null) {
                        a.a;
                    } else {
                        arrayList.add(parseDynamicInfoFrom);
                    }
                    i++;
                }
                obj2 = arrayList;
            }
            this.a.d.a(Integer.valueOf(optInt), obj2);
            return;
        }
        this.a.d.a(optString);
    }
}
