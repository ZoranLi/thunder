package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpDns implements HttpDnsService {
    private static DegradationFilter degradationFilter;
    private static a hostManager = a.a();
    static HttpDns instance;
    private static ExecutorService pool = Executors.newFixedThreadPool(3);
    private boolean isExpiredIPEnabled = false;

    private HttpDns() {
    }

    public static HttpDnsService getService(Context context, String str) {
        if (instance == null) {
            synchronized (HttpDns.class) {
                if (instance == null) {
                    if (!f.b()) {
                        new Thread(new c(context)).start();
                    }
                    h.setContext(context);
                    j.setContext(context);
                    d.c(str);
                    instance = new HttpDns();
                }
            }
        }
        return instance;
    }

    public String getIpByHost(String str) {
        String[] ipsByHost = getIpsByHost(str);
        return ipsByHost.length > 0 ? ipsByHost[0] : null;
    }

    public String getIpByHostAsync(String str) {
        String[] ipsByHostAsync = getIpsByHostAsync(str);
        return ipsByHostAsync.length > 0 ? ipsByHostAsync[0] : null;
    }

    public String[] getIpsByHost(String str) {
        if (!g.b(str)) {
            return d.f5b;
        }
        if (g.c(str)) {
            return new String[]{str};
        } else if (degradationFilter != null && degradationFilter.shouldDegradeHttpDNS(str)) {
            return d.f5b;
        } else {
            b a = hostManager.a(str);
            if (a != null && a.a() && this.isExpiredIPEnabled) {
                if (!hostManager.a(str)) {
                    StringBuilder stringBuilder = new StringBuilder("refresh host async: ");
                    stringBuilder.append(str);
                    e.d(stringBuilder.toString());
                    pool.submit(new j(str));
                }
                return a.a();
            }
            if (a != null) {
                if (!a.a()) {
                    return a.a();
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("refresh host sync: ");
            stringBuilder2.append(str);
            e.d(stringBuilder2.toString());
            try {
                return (String[]) pool.submit(new j(str)).get();
            } catch (Throwable e) {
                e.a(e);
                return d.f5b;
            }
        }
    }

    public String[] getIpsByHostAsync(String str) {
        if (!g.b(str)) {
            return d.f5b;
        }
        if (g.c(str)) {
            return new String[]{str};
        } else if (degradationFilter != null && degradationFilter.shouldDegradeHttpDNS(str)) {
            return d.f5b;
        } else {
            b a = hostManager.a(str);
            if ((a == null || a.a()) && !hostManager.a(str)) {
                StringBuilder stringBuilder = new StringBuilder("refresh host async: ");
                stringBuilder.append(str);
                e.d(stringBuilder.toString());
                pool.submit(new j(str));
            }
            return (a == null || (a.a() && !(a.a() && this.isExpiredIPEnabled))) ? d.f5b : a.a();
        }
    }

    public void setDegradationFilter(DegradationFilter degradationFilter) {
        degradationFilter = degradationFilter;
    }

    public void setExpiredIPEnabled(boolean z) {
        this.isExpiredIPEnabled = z;
    }

    public void setLogEnabled(boolean z) {
        e.setLogEnabled(z);
    }

    public void setPreResolveAfterNetworkChanged(boolean z) {
        h.f6c = z;
    }

    public void setPreResolveHosts(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            String str = (String) arrayList.get(i);
            if (!hostManager.a(str)) {
                pool.submit(new j(str));
            }
        }
    }
}
