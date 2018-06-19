package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import org.json.JSONObject;

public class UrlResponse extends SocializeReseponse {
    public int code;
    public String result;

    public UrlResponse(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    public void parseJsonObject() {
        if (this.mJsonData != null) {
            this.result = this.mJsonData.optString("new");
        }
    }
}
