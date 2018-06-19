package com.alibaba.sdk.android.feedback.xblink.g;

import javax.net.ssl.X509TrustManager;

public class d {
    protected static X509TrustManager a = null;
    private static final String b = "d";

    public static X509TrustManager a() {
        if (a == null) {
            try {
                a = new a();
            } catch (Exception e) {
                e.printStackTrace();
                a = null;
            }
        }
        return a;
    }
}
