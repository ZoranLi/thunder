package com.tencent.wxop.stat.event;

import android.content.Context;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.wxop.stat.StatAppMonitor;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.r;
import org.json.JSONObject;

public class g extends e {
    private static String m;
    private static String n;
    private StatAppMonitor a = null;

    public g(Context context, int i, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        super(context, i, statSpecifyReportedInfo);
        this.a = statAppMonitor.clone();
    }

    public EventType a() {
        return EventType.MONITOR_STAT;
    }

    public boolean a(JSONObject jSONObject) {
        if (this.a == null) {
            return false;
        }
        jSONObject.put("na", this.a.getInterfaceName());
        jSONObject.put("rq", this.a.getReqSize());
        jSONObject.put("rp", this.a.getRespSize());
        jSONObject.put("rt", this.a.getResultType());
        jSONObject.put(IXAdRequestInfo.MAX_TITLE_LENGTH, this.a.getMillisecondsConsume());
        jSONObject.put("rc", this.a.getReturnCode());
        jSONObject.put("sp", this.a.getSampling());
        if (n == null) {
            n = l.l(this.l);
        }
        r.a(jSONObject, a.k, n);
        if (m == null) {
            m = l.g(this.l);
        }
        r.a(jSONObject, "op", m);
        jSONObject.put("cn", com.tencent.wxop.stat.a.a(this.l).b());
        return true;
    }
}
