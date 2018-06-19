package com.xunlei.downloadprovider.publiser.common;

/* compiled from: PublisherHelper */
public final class o {
    public static String a(String str) {
        if ("per".equals(str)) {
            return "personal";
        }
        if ("pub".equals(str)) {
            return "channel";
        }
        if ("rad".equals(str)) {
            return "per_host";
        }
        return ("yl_daren".equals(str) || "yl_nvshen".equals(str) || "yl_nanshen".equals(str)) ? "youliao_talent" : str;
    }
}
