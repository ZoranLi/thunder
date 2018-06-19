package com.xunlei.downloadprovider.member.payment.activity;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Referfrom */
public final class r {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    List<List<LimitCondition>> f;
    public String g;

    static r a(JSONObject jSONObject) {
        try {
            r rVar = new r();
            rVar.b = jSONObject.optString("main_title");
            rVar.c = jSONObject.optString("main_icon");
            rVar.d = jSONObject.optString("sub_title");
            rVar.e = jSONObject.optString("actid");
            rVar.g = jSONObject.optString("jump_url");
            if (TextUtils.isEmpty(rVar.e)) {
                jSONObject = jSONObject.optJSONArray("limit");
                rVar.f = new ArrayList();
                int length = jSONObject.length();
                for (int i = 0; i < length; i++) {
                    JSONArray optJSONArray = jSONObject.optJSONArray(i);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        List arrayList = new ArrayList();
                        int length2 = optJSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            LimitCondition a = LimitCondition.a(optJSONArray.optJSONObject(i2));
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            rVar.f.add(arrayList);
                        }
                    }
                }
            }
            return rVar;
        } catch (JSONObject jSONObject2) {
            new StringBuilder("referfrom parseData fail = ").append(jSONObject2.toString());
            return null;
        }
    }
}
