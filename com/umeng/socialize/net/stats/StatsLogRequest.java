package com.umeng.socialize.net.stats;

import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.URequest.RequestMethod;
import java.util.HashMap;
import java.util.Map;

public class StatsLogRequest extends StatsRequest {
    public void onPrepareRequest() {
    }

    public StatsLogRequest(Class<? extends SocializeReseponse> cls) {
        super(null, "", cls, 0, RequestMethod.POST);
        cls = new StringBuilder();
        cls.append(this.mRequestPath);
        cls.append("?test=");
        this.mRequestPath = cls.toString();
        cls = new StringBuilder();
        cls.append(this.mRequestPath);
        cls.append(SocializeConstants.DEBUG_MODE ? "1" : "0");
        this.mRequestPath = cls.toString();
        this.mMimeType = MIME.JSON;
    }

    public String toGetUrl() {
        return generateGetURL(getBaseUrl(), buildParams());
    }

    protected String getPath() {
        return this.mRequestPath;
    }

    public Map<String, Object> getBodyPair() {
        Map<String, Object> hashMap = new HashMap();
        hashMap.putAll(this.mParams);
        return hashMap;
    }
}
