package com.umeng.socialize.net.stats;

import android.content.Context;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.URequest.RequestMethod;

public class DauStatsRequest extends StatsRequest {
    public DauStatsRequest(Context context, Class<? extends SocializeReseponse> cls) {
        super(context, "", cls, 0, RequestMethod.GET);
        addStringParams(PARAMS_STATS_TYPE, "dau");
    }

    protected String getPath() {
        return this.mRequestPath;
    }
}
