package com.xunlei.downloadprovider.ad.common.adget;

import com.baidu.mobad.feeds.NativeResponse;
import com.qq.e.ads.nativ.NativeADDataRef;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import java.util.HashMap;
import java.util.Map;

/* compiled from: MaterialReporter */
public final class o {
    private static final String a = "o";

    private static Map<String, String> c(b bVar, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("xunlei_title", bVar.j());
        hashMap.put("xunlei_desc", bVar.m());
        hashMap.put("xunlei_img", bVar.l());
        hashMap.put("xunlei_icon", bVar.k());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(bVar.E());
        hashMap.put("xunlei_price", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(bVar.n());
        hashMap.put("xunlei_download_count", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(bVar.q());
        hashMap.put("xunlei_app_score", stringBuilder.toString());
        hashMap.put("xunlei_sid", str);
        hashMap.put("xunlei_is_app", bVar.w() ? "1" : "0");
        hashMap.put("adv_position", str2);
        hashMap.put("adv_style_id", str3);
        hashMap.put("source", bVar.y());
        hashMap.put("landing_type", String.valueOf(bVar.u()));
        hashMap.put("landing_url", bVar.g);
        return hashMap;
    }

    private static Map<String, String> c(NativeADDataRef nativeADDataRef, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("gdt_title", nativeADDataRef.getTitle());
        hashMap.put("gdt_desc", nativeADDataRef.getDesc());
        hashMap.put("gdt_img", nativeADDataRef.getImgUrl());
        hashMap.put("gdt_icon", nativeADDataRef.getIconUrl());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nativeADDataRef.getAPPPrice());
        hashMap.put("gdt_price", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeADDataRef.getDownloadCount());
        hashMap.put("gdt_download_count", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeADDataRef.getAPPScore());
        hashMap.put("gdt_app_score", stringBuilder.toString());
        hashMap.put("gdt_sid", str);
        hashMap.put("gdt_is_app", nativeADDataRef.isAPP() != null ? "1" : "0");
        hashMap.put("adv_position", str2);
        hashMap.put("adv_style_id", str3);
        return hashMap;
    }

    private static Map<String, String> c(NativeResponse nativeResponse, String str, String str2, String str3) {
        Map hashMap = new HashMap();
        hashMap.put("baidu_title", nativeResponse.getTitle());
        hashMap.put("baidu_desc", nativeResponse.getDesc());
        hashMap.put("baidu_img", nativeResponse.getImageUrl());
        hashMap.put("baidu_icon", nativeResponse.getIconUrl());
        hashMap.put("baidu_is_app", nativeResponse.isDownloadApp() ? "1" : "0");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getMainPicWidth());
        hashMap.put("baidu_main_pic_width", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getMainPicHeight());
        hashMap.put("baidu_main_pic_height", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getBrandName());
        hashMap.put("baidu_brandname", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getAdLogoUrl());
        hashMap.put("baidu_ad_logo_url", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getBaiduLogoUrl());
        hashMap.put("baidu_baidu_logo_url", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getAppSize());
        hashMap.put("baidu_app_size", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getAppPackage());
        hashMap.put("baidu_app_package", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeResponse.getMaterialType().name());
        hashMap.put("baidu_material_type", stringBuilder.toString());
        hashMap.put("baidu_html_snippet", nativeResponse.getHtmlSnippet());
        hashMap.put("adv_position", str2);
        hashMap.put("adv_style_id", str3);
        hashMap.put("baidu_sid", str);
        return hashMap;
    }

    private static Map<String, String> c(NativeMediaADData nativeMediaADData, String str, String str2) {
        Map hashMap = new HashMap();
        hashMap.put("gdt_title", nativeMediaADData.getTitle());
        hashMap.put("gdt_desc", nativeMediaADData.getDesc());
        hashMap.put("gdt_img", nativeMediaADData.getImgUrl());
        hashMap.put("gdt_icon", nativeMediaADData.getIconUrl());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nativeMediaADData.getAPPPrice());
        hashMap.put("gdt_price", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeMediaADData.getDownloadCount());
        hashMap.put("gdt_download_count", stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append(nativeMediaADData.getAPPScore());
        hashMap.put("gdt_app_score", stringBuilder.toString());
        hashMap.put("gdt_is_app", nativeMediaADData.isAPP() ? "1" : "0");
        hashMap.put("gdt_sid", str);
        hashMap.put("adv_position", str2);
        hashMap.put("adv_style_id", nativeMediaADData.isVideoAD() != null ? "2" : "1");
        return hashMap;
    }

    public static void a(b bVar, String str, String str2, String str3) {
        a("show_xunlei_material", c(bVar, str, str2, str3));
    }

    public static void b(b bVar, String str, String str2, String str3) {
        a("click_xunlei_material", c(bVar, str, str2, str3));
    }

    public static void a(NativeADDataRef nativeADDataRef, String str, String str2, String str3) {
        a("show_gdt_material", c(nativeADDataRef, str, str2, str3));
    }

    public static void b(NativeADDataRef nativeADDataRef, String str, String str2, String str3) {
        a("click_gdt_material", c(nativeADDataRef, str, str2, str3));
    }

    public static void a(NativeMediaADData nativeMediaADData, String str, String str2) {
        a("show_gdt_material", c(nativeMediaADData, str, str2));
    }

    public static void b(NativeMediaADData nativeMediaADData, String str, String str2) {
        a("click_gdt_material", c(nativeMediaADData, str, str2));
    }

    public static void a(NativeResponse nativeResponse, String str, String str2, String str3) {
        a("show_baidu_material", c(nativeResponse, str, str2, str3));
    }

    public static void b(NativeResponse nativeResponse, String str, String str2, String str3) {
        a("click_baidu_material", c(nativeResponse, str, str2, str3));
    }

    private static void a(String str, Map<String, String> map) {
        str = StatEvent.build("android_advertise").addString(HubbleEventBuilder.KEY_ATTRIBUTE1, str);
        if (map != null) {
            for (String str2 : map.keySet()) {
                str.addString(str2, (String) map.get(str2));
            }
        }
        ThunderReport.reportEvent(str);
    }
}
