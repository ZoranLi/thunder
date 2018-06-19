package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.a;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class i extends e {
    private static String a;
    private String m = null;
    private String n = null;

    public i(Context context, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.m = a.a(context).b();
        if (a == null) {
            a = l.g(context);
        }
    }

    public EventType a() {
        return EventType.NETWORK_MONITOR;
    }

    public void a(String str) {
        this.n = str;
    }

    public boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "op", a);
        r.a(jSONObject, "cn", this.m);
        jSONObject.put("sp", this.n);
        return true;
    }
}
