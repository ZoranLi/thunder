package com.xunlei.downloadprovider.personal.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.taobao.accs.AccsClientConfig;
import com.xunlei.downloadprovider.personal.user.FeedBackActivity;
import com.xunlei.downloadprovider.web.a;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;

/* compiled from: UserCenterPageJumpUtil */
public final class i {
    public static void a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains(HttpConstant.HTTP)) {
                StringBuilder stringBuilder = new StringBuilder("http://");
                stringBuilder.append(str);
                str = stringBuilder.toString();
            }
            a.a();
            a.a(context, str, str2, str3);
        }
    }

    public static void a(Context context, String str, String str2, boolean z, int i) {
        if (!TextUtils.isEmpty(str2)) {
            z = !z ? "sign" : i > 0 ? "integral" : AccsClientConfig.DEFAULT_CONFIGTAG;
            a.a();
            i = new StringBuilder();
            i.append(str2);
            i.append("&from=");
            i.append(str);
            i.append("&notice=");
            i.append(z);
            i.append("&versioncode=11100");
            a.a(context, i.toString(), "积分中心", "per_cl");
        }
    }

    public static void a(Context context, String str, String str2) {
        CustomWebViewActivity.a(context, str2, str, "帮助反馈", FeedBackActivity.class);
    }
}
