package com.umeng.socialize.net.stats;

import android.content.Context;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.base.SocializeRequest;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.URequest.RequestMethod;

public abstract class StatsRequest extends SocializeRequest {
    protected static String PARAMS_STATS_TYPE = "stats_type";
    private final String BASE_URL = "https://stats.umsns.com/";
    protected String mRequestPath = "sdkstats";

    public String getDecryptString(String str) {
        return str;
    }

    public String getEcryptString(String str) {
        return str;
    }

    public StatsRequest(Context context, String str, Class<? extends SocializeReseponse> cls, int i, RequestMethod requestMethod) {
        super(context, str, cls, i, requestMethod);
        this.mResponseClz = cls;
        this.mOpId = i;
        this.mContext = context;
        this.mMethod = requestMethod;
        addStringParams("test", SocializeConstants.DEBUG_MODE != null ? "1" : "0");
        setBaseUrl("https://stats.umsns.com/");
    }

    public String toGetUrl() {
        return generateGetURL(getBaseUrl(), buildParams());
    }
}
