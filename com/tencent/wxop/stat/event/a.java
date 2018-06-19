package com.tencent.wxop.stat.event;

import android.content.Context;
import com.tencent.wxop.stat.StatAccount;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class a extends e {
    private StatAccount a = null;

    public a(Context context, int i, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.a = statAccount;
    }

    public EventType a() {
        return EventType.ADDITION;
    }

    public boolean a(JSONObject jSONObject) {
        r.a(jSONObject, "qq", this.a.getAccount());
        jSONObject.put("acc", this.a.toJsonString());
        return true;
    }
}
