package com.xunlei.downloadprovider.ad.cache;

import android.support.annotation.NonNull;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.f;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CacheReporter */
public final class a {
    public static void a(String str, STYLES_INFO styles_info, int i, String str2) {
        if (a()) {
            str = a(str, styles_info, i);
            str.put("error_code", new StringBuilder(str2).toString());
            com.xunlei.downloadprovider.ad.common.report.a.a("adv_get_alliance_by_cache_fail", str, 1);
        }
    }

    @NonNull
    public static Map<String, String> a(String str, STYLES_INFO styles_info, int i) {
        styles_info = styles_info.mStyleId;
        Object obj = "";
        switch (i) {
            case 1:
            case 2:
            case 5:
                obj = SocializeProtocolConstants.PROTOCOL_KEY_TENCENT;
                break;
            case 3:
            case 6:
                obj = "baidu";
                break;
            case 4:
                obj = "xunlei";
                break;
            default:
                break;
        }
        i = new HashMap();
        i.put("positionId", str);
        i.put("styleId", styles_info);
        i.put("ad_type", obj);
        i.put("force", "0");
        return i;
    }

    public static boolean a() {
        String c = f.c();
        if (!c.equals("0")) {
            if (!c.equals("1")) {
                return false;
            }
        }
        return true;
    }
}
