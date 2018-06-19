package anetwork.channel.stat;

import anet.channel.util.StringUtils;
import anetwork.channel.statist.StatisticData;
import com.alipay.sdk.util.h;
import java.util.Collections;
import java.util.Map;

/* compiled from: Taobao */
final class b implements a {
    private Map<String, String> a;

    /* compiled from: Taobao */
    private static class a {
        public static b a = new b();
    }

    private b() {
        this.a = Collections.synchronizedMap(new NetworkStatCache$1(this));
    }

    public final void a(String str, StatisticData statisticData) {
        if (!StringUtils.isBlank(str)) {
            StringBuilder stringBuilder = new StringBuilder(48);
            stringBuilder.append("{\"oneWayTime\" : ");
            stringBuilder.append(statisticData.oneWayTime_ANet);
            stringBuilder.append(", \"totalSize\" : ");
            stringBuilder.append(statisticData.totalSize);
            stringBuilder.append(h.d);
            this.a.put(str, stringBuilder.toString());
        }
    }
}
