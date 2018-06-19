package com.umeng.socialize.net.stats;

import android.content.Context;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.URequest.RequestMethod;

public class ShareStatsRequest extends StatsRequest {

    protected enum ShareLifecycle {
        START("sharestart"),
        END("shareend");
        
        private String value;

        private ShareLifecycle(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public ShareStatsRequest(Context context, Class<? extends SocializeReseponse> cls) {
        super(context, "", cls, 0, RequestMethod.GET);
    }

    protected String getPath() {
        return this.mRequestPath;
    }

    protected void setRequestPath(ShareLifecycle shareLifecycle) {
        addStringParams(PARAMS_STATS_TYPE, shareLifecycle.toString());
    }
}
