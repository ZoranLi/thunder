package com.xunlei.downloadprovider.discovery.b;

import android.text.TextUtils;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.downloadprovider.discovery.kuainiao.d;

/* compiled from: DiscoveryUtil */
public final class b {
    public static boolean a() {
        return BrothersApplication.getApplicationInstance().getSharedPreferences("shared_for_kuainiao_display", 0).getBoolean("is_has_showed_kuainiao", false);
    }

    public static void a(boolean z) {
        BrothersApplication.getApplicationInstance().getSharedPreferences("shared_for_kuainiao_display", 0).edit().putBoolean("is_has_showed_kuainiao", z).commit();
    }

    public static boolean b() {
        return BrothersApplication.getApplicationInstance().getSharedPreferences("find_fragment_KuaiNiao_RedPoint", 0).getBoolean("findNeedShowKuaiNiaoRedPoint", true);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        o d = i.a().d(str);
        if (d != null) {
            if (d.a()) {
                if (str.equals("kuainiao") == null) {
                    str = new StringBuffer();
                    if (!TextUtils.isEmpty(d.c)) {
                        str.append("word:");
                    }
                    if (!TextUtils.isEmpty(d.d)) {
                        str.append("pic:");
                    }
                    str.append("point");
                    return str.toString();
                } else if (d.a().a != null) {
                    return b() != null ? "point" : "0";
                } else {
                    return "0";
                }
            }
        }
        return "0";
    }
}
