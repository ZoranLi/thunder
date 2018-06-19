package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import org.json.JSONObject;

public class DeleteResponse extends SocializeReseponse {
    public DeleteResponse(Integer num, JSONObject jSONObject) {
        super(num, jSONObject);
    }
}
