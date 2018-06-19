package com.tencent.wxop.stat.event;

import android.content.Context;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class j extends e {
    Long a = null;
    String m;
    String n;

    public j(Context context, String str, String str2, int i, Long l, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.n = str;
        this.m = str2;
        this.a = l;
    }

    public EventType a() {
        return EventType.PAGE_VIEW;
    }

    public boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "pi", this.m);
        r.a(jSONObject, KEYS.Banner_RF, this.n);
        if (this.a != null) {
            jSONObject.put("du", this.a);
        }
        return true;
    }
}
