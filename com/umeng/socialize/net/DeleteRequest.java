package com.umeng.socialize.net;

import com.umeng.socialize.net.utils.URequest;
import com.umeng.socialize.net.utils.URequest.PostStyle;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DeleteRequest extends URequest {
    public Map<String, Object> buildParams() {
        return null;
    }

    public String toGetUrl() {
        return null;
    }

    public JSONObject toJson() {
        return null;
    }

    public DeleteRequest(String str, String str2) {
        super("https://api.weibo.com/oauth2/revokeoauth2");
        this.mMethod = RequestMethod.POST;
        this.mResponseClz = DeleteResponse.class;
        this.postStyle = PostStyle.APPLICATION;
        addStringParams("access_token", str2);
    }

    public Map<String, Object> getBodyPair() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.putAll(this.mParams);
        return hashMap;
    }
}
