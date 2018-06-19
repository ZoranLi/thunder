package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class h extends e {
    public static final StatSpecifyReportedInfo a;

    static {
        StatSpecifyReportedInfo statSpecifyReportedInfo = new StatSpecifyReportedInfo();
        a = statSpecifyReportedInfo;
        statSpecifyReportedInfo.setAppKey("A9VH9B8L4GX4");
    }

    public h(Context context) {
        super(context, 0, a);
    }

    public EventType a() {
        return EventType.NETWORK_DETECTOR;
    }

    public boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "actky", StatConfig.getAppKey(this.l));
        return true;
    }
}
