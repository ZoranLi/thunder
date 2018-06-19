package com.xunlei.downloadprovider.ad.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: ExpiredRequestFilter */
public final class g {
    public Map<Integer, Long> a = new HashMap();

    public final boolean a(long j) {
        Long l = (Long) this.a.get(Integer.valueOf(1000));
        return (l == null || j != l.longValue()) ? 0 : 1;
    }
}
