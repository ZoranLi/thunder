package com.xunlei.common.accelerator.js;

import android.webkit.WebView;

public class KNJsCallBack {
    public static void callBack(WebView webView, String str, String str2) {
        if (str2 != null) {
            StringBuilder stringBuilder = new StringBuilder("javascript: ");
            stringBuilder.append(str2);
            stringBuilder.append("('");
            stringBuilder.append(str);
            stringBuilder.append("')");
            webView.loadUrl(stringBuilder.toString());
        }
    }
}
