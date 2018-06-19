package com.xunlei.downloadprovider.download;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.download.create.ThunderTaskActivity;
import com.xunlei.downloadprovider.download.create.ad;

/* compiled from: DownloadCreatePageUtil */
public final class b {
    public static void a(Context context, @NonNull ad adVar, String str) {
        if (TextUtils.isEmpty(str)) {
            str = DispatchConstants.OTHER;
        }
        String str2 = str;
        if (TextUtils.isEmpty(adVar.a()) == null) {
            if (com.xunlei.downloadprovider.download.b.b.d() != null) {
                Bundle bundle = new Bundle(9);
                ThunderTaskActivity.a(bundle, adVar);
                a.a(context, -1, str2, bundle, null);
                return;
            }
            str = new Bundle(9);
            ThunderTaskActivity.a(str, adVar);
            str.putBoolean("back_to_home_page", true);
            a.c(context, -1, str2, str);
        }
    }

    public static void a(Context context, String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str3)) {
            str3 = DispatchConstants.OTHER;
        }
        String str4 = str3;
        str3 = new ad(new Bundle(9));
        str3.a(str);
        str3.d(str2);
        str3.a.putBoolean("fromMagnetComplete", z);
        if (com.xunlei.downloadprovider.download.b.b.d() != null) {
            Bundle bundle = new Bundle(9);
            ThunderTaskActivity.a(bundle, str3);
            a.a(context, -1, str4, bundle, null);
            return;
        }
        str = new Bundle(9);
        ThunderTaskActivity.a(str, str3);
        str.putBoolean("back_to_home_page", true);
        a.c(context, -1, str4, str);
    }
}
