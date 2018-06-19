package com.alibaba.baichuan.android.trade.adapter.ut.performance.dimension;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.f;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.umeng.message.common.a;
import java.io.Serializable;

public class Dimension implements Serializable {
    private static final String e = "Dimension";
    protected String a = AlibcContext.c();
    protected String b = f.b(AlibcContext.a);
    protected String c = AlibcContext.d;
    protected String d = DispatchConstants.ANDROID;

    public static DimensionSet getDimensionSet() {
        return DimensionSet.a().a("appkey").a("app_version").a(a.h).a("platform");
    }

    public DimensionValueSet getDimensionValues() {
        if (this.a != null) {
            if (this.b != null) {
                return DimensionValueSet.a().a("appkey", this.a).a("app_version", this.b).a(a.h, this.c).a("platform", this.d);
            }
        }
        c.a(e, "getDimensionValues", "appkey/appVersion is null");
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Dimension{appkey='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", appVersion='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", sdkVersion='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", platform='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
