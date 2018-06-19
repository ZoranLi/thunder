package com.xunlei.downloadprovider.comment.entity;

import com.alipay.sdk.util.h;
import com.xunlei.common.androidutil.AndroidConfig;

/* compiled from: CookieConstant */
public final class g {
    public static final String a = AndroidConfig.getProductId();
    public static final String b = AndroidConfig.getPartnerId();

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("productId=");
        stringBuilder.append(a);
        stringBuilder.append(h.b);
        stringBuilder.append("channelId=");
        stringBuilder.append(b);
        stringBuilder.append(h.b);
        stringBuilder.append("version=5.60.2.5510;");
        stringBuilder.append("versionCode=11100");
        return stringBuilder.toString();
    }
}
