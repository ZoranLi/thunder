package com.xunlei.downloadprovider.ad.common.report;

import android.support.annotation.Nullable;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ThunderAdReportInfo */
public final class k {
    private String a;
    private String b;

    public k(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public k(String str, @Nullable STYLES_INFO styles_info) {
        this.a = str;
        if (styles_info == null) {
            str = "";
        } else {
            str = styles_info.mStyleId;
        }
        this.b = str;
    }

    public final Map<String, String> a() {
        Map hashMap = new HashMap();
        hashMap.put("position_id", this.a);
        hashMap.put("style_id", this.b);
        d.a(this.a, hashMap);
        return hashMap;
    }
}
