package com.xunlei.downloadprovider.ad.recommend.c;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.b.o;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.i;
import com.xunlei.xllib.android.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RecommendAdReporter */
public final class a {
    public static String a(int i) {
        switch (i) {
            case 0:
                return "total";
            case 1:
                return "downloading";
            case 2:
                return "finish";
            default:
                return "total";
        }
    }

    public static void a() {
        o d = i.a().d("game_center");
        if (d.a().c.a() && !com.xunlei.downloadprovider.ad.a.a.a().e) {
            com.xunlei.downloadprovider.ad.a.a.a().e = true;
            Map hashMap = new HashMap();
            if (d == null) {
                String str = "point_status";
                i.a();
                hashMap.put(str, !i.c() ? "1" : "0");
            } else {
                i.a();
                if (i.c()) {
                    hashMap.put("point_status", d.b() ? "1" : "0");
                } else {
                    hashMap.put("point_status", "1");
                }
            }
            com.xunlei.downloadprovider.ad.home.a.a("android_mobgame_channel", "c_game_dlcenter_show", hashMap);
        }
    }

    public static String b() {
        String b = b.b(BrothersApplication.getApplicationInstance());
        return (b == null || !b.equals("null")) ? b : "0";
    }
}
