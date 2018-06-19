package com.alibaba.sdk.android.feedback.xblink.i;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import org.apache.http.HttpHost;

public class f {
    public static boolean a = false;
    private static final String b = "f";

    public static HttpHost a(Context context) {
        HttpHost httpHost = null;
        if (VERSION.SDK_INT < 11) {
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e) {
                g.b(b, String.valueOf(e));
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getType() == 0) {
                String defaultHost = Proxy.getDefaultHost();
                int defaultPort = Proxy.getDefaultPort();
                if (defaultHost != null) {
                    httpHost = new HttpHost(defaultHost, defaultPort);
                }
            }
            return httpHost;
        }
        Object property = System.getProperty("https.proxyHost");
        String property2 = System.getProperty("https.proxyPort");
        if (!TextUtils.isEmpty(property)) {
            httpHost = new HttpHost(property, Integer.parseInt(property2));
        }
        return httpHost;
    }
}
