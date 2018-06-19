package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ChoicenessWebsiteTopicInfo */
public final class o extends e {
    public String a;
    public String b;
    public String c;
    public String d;

    public static o a(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            if (jSONObject.length() != 0) {
                e oVar = new o();
                a(oVar, jSONObject);
                jSONObject = jSONObject.getJSONObject("res_info");
                oVar.a = jSONObject.getString(AgooConstants.MESSAGE_ID);
                oVar.b = jSONObject.optString("topic_name");
                oVar.c = jSONObject.optString("topic_pic");
                oVar.d = jSONObject.optString("topic_vice_name");
                return oVar;
            }
        }
        return null;
    }
}
