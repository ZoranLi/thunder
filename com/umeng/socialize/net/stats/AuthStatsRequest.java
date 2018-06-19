package com.umeng.socialize.net.stats;

import android.content.Context;
import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.utils.URequest.RequestMethod;

public class AuthStatsRequest extends StatsRequest {

    protected enum AuthLifecycle {
        START("authstart"),
        END("authend");
        
        private String value;

        private AuthLifecycle(String str) {
            this.value = str;
        }

        public final String toString() {
            return this.value;
        }
    }

    public AuthStatsRequest(Context context, Class<? extends SocializeReseponse> cls) {
        super(context, "", cls, 0, RequestMethod.GET);
    }

    protected String getPath() {
        return this.mRequestPath;
    }

    protected void setRequestPath(AuthLifecycle authLifecycle) {
        addStringParams(PARAMS_STATS_TYPE, authLifecycle.toString());
    }
}
