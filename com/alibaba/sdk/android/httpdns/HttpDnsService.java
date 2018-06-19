package com.alibaba.sdk.android.httpdns;

import java.util.ArrayList;

public interface HttpDnsService {
    String getIpByHost(String str);

    String getIpByHostAsync(String str);

    String[] getIpsByHost(String str);

    String[] getIpsByHostAsync(String str);

    void setDegradationFilter(DegradationFilter degradationFilter);

    void setExpiredIPEnabled(boolean z);

    void setLogEnabled(boolean z);

    void setPreResolveAfterNetworkChanged(boolean z);

    void setPreResolveHosts(ArrayList arrayList);
}
