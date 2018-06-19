package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.Log;
import org.json.JSONObject;

public class LinkCardResponse extends SocializeReseponse {
    public String url;

    public LinkCardResponse(JSONObject jSONObject) {
        super(jSONObject);
    }

    public LinkCardResponse(Integer num, JSONObject jSONObject) {
        super(num, jSONObject);
    }

    public void parseJsonObject() {
        JSONObject jSONObject = this.mJsonData;
        if (jSONObject == null) {
            Log.e("SocializeReseponse", "data json is null....");
        } else {
            this.url = jSONObject.optString("linkcard_url");
        }
    }
}
