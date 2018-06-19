package com.alibaba.sdk.android.feedback.xblink.webview;

import android.text.TextUtils;
import android.webkit.CookieManager;
import com.alibaba.sdk.android.feedback.xblink.i.g;

public class t {
    private static int a = 101;
    private static int b = 300000;

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String cookie = CookieManager.getInstance().getCookie(str);
        if (g.a()) {
            StringBuilder stringBuilder = new StringBuilder("get cookie : ");
            stringBuilder.append(cookie);
            stringBuilder.append(";url: ");
            stringBuilder.append(str);
            g.c("WVCookieManager", stringBuilder.toString());
        }
        return cookie;
    }
}
