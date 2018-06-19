package com.alibaba.sdk.android.httpdns;

public interface DegradationFilter {
    boolean shouldDegradeHttpDNS(String str);
}
