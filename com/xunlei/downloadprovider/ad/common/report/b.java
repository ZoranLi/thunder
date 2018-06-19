package com.xunlei.downloadprovider.ad.common.report;

import java.util.HashMap;
import java.util.Map;

/* compiled from: AdPVReportInfo */
public final class b extends f {
    private String a;

    public b(String str) {
        this.a = str;
    }

    public final Map<String, String> a() {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("position_id", this.a);
        hashMap.putAll(getExtras());
        return hashMap;
    }
}
