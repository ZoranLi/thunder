package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SocializeUtils;
import java.util.Map;
import org.json.JSONObject;

public class UserinfoResponse extends SocializeReseponse {
    public Map<String, String> result;

    public UserinfoResponse(Integer num, JSONObject jSONObject) {
        super(num, jSONObject);
        this.result = SocializeUtils.jsonToMap(jSONObject.toString());
    }
}
