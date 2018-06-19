package com.alibaba.sdk.android.httpdns;

class d {
    static String b;
    static final String[] f5b = new String[0];

    static synchronized void c(String str) {
        synchronized (d.class) {
            b = str;
        }
    }
}
