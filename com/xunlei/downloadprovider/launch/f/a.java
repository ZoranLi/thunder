package com.xunlei.downloadprovider.launch.f;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: XunleiApp */
public final class a {
    public static String a(Uri uri) {
        String str = "";
        if (uri != null) {
            str = uri.getQueryParameter("from");
        }
        return TextUtils.isEmpty(str) != null ? "web_share" : str;
    }

    public static String b(Uri uri) {
        return uri == null ? "" : uri.getPath();
    }

    public static boolean c(Uri uri) {
        return (uri == null || !"xunleiapp".equals(uri.getScheme()) || "xunlei.com".equals(uri.getHost()) == null) ? null : true;
    }
}
