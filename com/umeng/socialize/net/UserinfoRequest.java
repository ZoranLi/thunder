package com.umeng.socialize.net;

import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class UserinfoRequest extends URequest {
    private static final String REQUEST_USERINFO = "https://api.weibo.com/2/users/show.json";

    public JSONObject toJson() {
        return null;
    }

    public UserinfoRequest(String str, String str2, String str3) {
        super(REQUEST_USERINFO);
        this.mMethod = RequestMethod.GET;
        this.mResponseClz = UserinfoResponse.class;
        addStringParams("uid", str);
        addStringParams("appkey", str3);
        addStringParams("access_token", str2);
    }

    public String toGetUrl() {
        return generateGetURL(getBaseUrl(), buildParams());
    }

    public Map<String, Object> buildParams() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.putAll(this.mParams);
        return hashMap;
    }
}
