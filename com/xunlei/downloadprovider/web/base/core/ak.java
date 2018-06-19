package com.xunlei.downloadprovider.web.base.core;

import android.text.TextUtils;

/* compiled from: WebUtils */
public final class ak {
    public static boolean a(String str) {
        if (!(TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str))) {
            if ("undefined".equalsIgnoreCase(str) == null) {
                return null;
            }
        }
        return true;
    }
}
