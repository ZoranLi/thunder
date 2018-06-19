package com.xunlei.downloadprovider.ad.common.report;

import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.j.a;
import com.xunlei.downloadprovider.ad.common.adget.l;
import java.util.HashMap;
import java.util.Map;

/* compiled from: RequestSuccessInfo */
public final class i {
    private a a;
    private l b;
    private THUNDER_AD_INFO c;
    private STYLES_INFO d;
    private String e;

    public i(a aVar) {
        this.a = aVar;
        this.b = this.a != null ? this.a.b : null;
    }

    public i(String str, THUNDER_AD_INFO thunder_ad_info, STYLES_INFO styles_info) {
        this.e = str;
        this.c = thunder_ad_info;
        this.d = styles_info;
    }

    public final Map<String, String> a() {
        Object obj;
        Object obj2;
        String str;
        Object obj3;
        Object obj4 = "";
        Object obj5 = "";
        Object obj6 = "";
        Object obj7 = "0";
        String str2 = "";
        String str3 = "";
        Object obj8 = "";
        if (this.c != null && this.d != null) {
            str2 = this.c.mPositionId;
            obj = this.d.mStyleId;
            obj2 = "0";
            str = str2;
            obj3 = this.e;
        } else if (this.a != null) {
            obj4 = this.a.f;
            str = this.a.g;
            if (TextUtils.isEmpty(this.a.e)) {
                obj2 = RePlugin.PROCESS_UI;
            } else {
                obj5 = this.b != null ? this.b.a() : "";
                obj6 = this.b != null ? this.b.e() : "";
                obj7 = (this.b == null || !this.b.i()) ? "0" : "1";
                str2 = this.a.h.mStyleId;
                str3 = this.a.e;
                obj2 = "0";
            }
            String str4 = str3;
            obj = str2;
            obj3 = str4;
            if (this.a.i != null) {
                obj2 = String.valueOf(this.a.i.a);
                obj8 = this.a.i.b;
            }
        } else {
            throw new IllegalArgumentException("getReportParam. BaseAdapter or parseResult can't be null together.");
        }
        Map hashMap = new HashMap();
        hashMap.put("search_id", obj4);
        hashMap.put("position_id", str);
        hashMap.put("material", obj5);
        hashMap.put("ad_id", obj6);
        hashMap.put("default_ad", obj7);
        hashMap.put("style_id", obj);
        hashMap.put("ad_showtype", obj3);
        hashMap.put("error_code", obj2);
        hashMap.put("error_msg", obj8);
        d.a(str, hashMap);
        return hashMap;
    }
}
