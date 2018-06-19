package com.alibaba.mtl.log.a;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.q;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Config */
public final class a {
    public static String a = "http://m-adash.m.taobao.com/rest/sur";
    public static String b = "http://adashbc.m.taobao.com/rest/sur";
    public static boolean c = false;
    public static String d = null;
    public static volatile boolean e = false;
    static List<String> f = new ArrayList();
    static List<String> g = new ArrayList();
    static List<String> h = new ArrayList();
    static List<String> i = new ArrayList();
    static List<String> j = new ArrayList();
    static List<String> k = new ArrayList();
    private static long l = 300000;
    private static long m = 30000;
    private static boolean n = false;
    private static boolean o = false;
    private static String p = "net";
    private static boolean q;

    static {
        g.add("stm_bcx");
        h.add("stm_x");
        i.add("stm_p");
        j.add("stm_c");
        f.add("stm_d");
        k.add("stm_nc");
    }

    public static java.util.List<java.lang.String> a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = -1;
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Exception -> 0x0006 }
        goto L_0x0007;
    L_0x0006:
        r3 = r0;
    L_0x0007:
        if (r3 != r0) goto L_0x000c;
    L_0x0009:
        r3 = f;
        return r3;
    L_0x000c:
        r0 = 1;
        if (r3 == r0) goto L_0x009e;
    L_0x000f:
        r1 = 61005; // 0xee4d float:8.5486E-41 double:3.01405E-319;
        if (r3 == r1) goto L_0x009e;
    L_0x0014:
        r1 = 61006; // 0xee4e float:8.5488E-41 double:3.0141E-319;
        if (r3 == r1) goto L_0x009e;
    L_0x0019:
        r1 = 65501; // 0xffdd float:9.1786E-41 double:3.2362E-319;
        if (r3 == r1) goto L_0x009e;
    L_0x001e:
        r1 = 65502; // 0xffde float:9.1788E-41 double:3.23623E-319;
        if (r3 == r1) goto L_0x009e;
    L_0x0023:
        r1 = 65503; // 0xffdf float:9.1789E-41 double:3.2363E-319;
        if (r3 == r1) goto L_0x009e;
    L_0x0028:
        r1 = 65133; // 0xfe6d float:9.1271E-41 double:3.218E-319;
        if (r3 != r1) goto L_0x002f;
    L_0x002d:
        goto L_0x009e;
    L_0x002f:
        if (r3 <= r0) goto L_0x0035;
    L_0x0031:
        r0 = 100;
        if (r3 < r0) goto L_0x0059;
    L_0x0035:
        r0 = 15300; // 0x3bc4 float:2.144E-41 double:7.559E-320;
        if (r3 <= r0) goto L_0x003d;
    L_0x0039:
        r0 = 15400; // 0x3c28 float:2.158E-41 double:7.6086E-320;
        if (r3 < r0) goto L_0x0059;
    L_0x003d:
        r0 = 21000; // 0x5208 float:2.9427E-41 double:1.03754E-319;
        if (r3 <= r0) goto L_0x0045;
    L_0x0041:
        r0 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        if (r3 < r0) goto L_0x0059;
    L_0x0045:
        r0 = 61000; // 0xee48 float:8.5479E-41 double:3.0138E-319;
        if (r3 <= r0) goto L_0x004f;
    L_0x004a:
        r0 = 61200; // 0xef10 float:8.576E-41 double:3.0237E-319;
        if (r3 < r0) goto L_0x0059;
    L_0x004f:
        r0 = 65000; // 0xfde8 float:9.1084E-41 double:3.21143E-319;
        if (r3 <= r0) goto L_0x005c;
    L_0x0054:
        r1 = 65300; // 0xff14 float:9.1505E-41 double:3.22625E-319;
        if (r3 >= r1) goto L_0x005c;
    L_0x0059:
        r3 = h;
        return r3;
    L_0x005c:
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = 2100; // 0x834 float:2.943E-42 double:1.0375E-320;
        if (r3 <= r1) goto L_0x0067;
    L_0x0062:
        if (r3 >= r2) goto L_0x0067;
    L_0x0064:
        r3 = i;
        return r3;
    L_0x0067:
        if (r3 <= r2) goto L_0x0070;
    L_0x0069:
        r1 = 2200; // 0x898 float:3.083E-42 double:1.087E-320;
        if (r3 >= r1) goto L_0x0070;
    L_0x006d:
        r3 = j;
        return r3;
    L_0x0070:
        r1 = 19999; // 0x4e1f float:2.8025E-41 double:9.881E-320;
        if (r3 == r1) goto L_0x009b;
    L_0x0074:
        r1 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        if (r3 <= r1) goto L_0x007c;
    L_0x0078:
        r1 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        if (r3 < r1) goto L_0x009b;
    L_0x007c:
        r1 = 64000; // 0xfa00 float:8.9683E-41 double:3.162E-319;
        if (r3 <= r1) goto L_0x0083;
    L_0x0081:
        if (r3 < r0) goto L_0x009b;
    L_0x0083:
        r0 = 65500; // 0xffdc float:9.1785E-41 double:3.23613E-319;
        if (r3 <= r0) goto L_0x008d;
    L_0x0088:
        r0 = 65600; // 0x10040 float:9.1925E-41 double:3.24107E-319;
        if (r3 < r0) goto L_0x009b;
    L_0x008d:
        r0 = 66000; // 0x101d0 float:9.2486E-41 double:3.26083E-319;
        if (r3 <= r0) goto L_0x0098;
    L_0x0092:
        r0 = 67000; // 0x105b8 float:9.3887E-41 double:3.31024E-319;
        if (r3 >= r0) goto L_0x0098;
    L_0x0097:
        goto L_0x009b;
    L_0x0098:
        r3 = k;
        return r3;
    L_0x009b:
        r3 = f;
        return r3;
    L_0x009e:
        r3 = g;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.a.a(java.lang.String):java.util.List<java.lang.String>");
    }

    public static void a(Map<String, String> map) {
        i.a(Config.TAG, "[turnOnRealTimeDebug] params:", map);
        if (map != null) {
            String str = (String) map.get("debug_api_url");
            String str2 = (String) map.get("debug_key");
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(str2))) {
                b = str;
                c = true;
                d = str2;
            }
            if (map.containsKey("debug_sampling_option") != null) {
                q.a = true;
                com.alibaba.mtl.log.a.i();
            }
        }
    }

    public static boolean a() {
        return c;
    }

    public static boolean b() {
        return !e;
    }

    public static long c() {
        return m;
    }

    public static long d() {
        return l;
    }

    private static int d(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 != 0) goto L_0x000f;
    L_0x0006:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Exception -> 0x000f }
        r1 = r1.intValue();	 Catch:{ Exception -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r1 = -1;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.a.d(java.lang.String):int");
    }

    public static void b(String str) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(com.alibaba.mtl.log.a.c()).edit();
        if (!TextUtils.isEmpty(str)) {
            try {
                str = new JSONObject(str).getJSONObject("config");
                if (str != null) {
                    Iterator keys = str.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String str2 = (String) keys.next();
                            JSONObject jSONObject = str.getJSONObject(str2);
                            if (jSONObject != null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(jSONObject.remove("timestamp"));
                                String stringBuilder2 = stringBuilder.toString();
                                StringBuilder stringBuilder3 = new StringBuilder("ut_");
                                stringBuilder3.append(str2);
                                stringBuilder3.append("_config");
                                edit.putString(stringBuilder3.toString(), jSONObject.toString());
                                StringBuilder stringBuilder4 = new StringBuilder("ut_");
                                stringBuilder4.append(str2);
                                stringBuilder4.append("_timestamp");
                                edit.putString(stringBuilder4.toString(), stringBuilder2);
                            }
                        }
                    }
                }
            } catch (String str3) {
                str3.printStackTrace();
            }
        }
        edit.apply();
    }

    public static String e() {
        if ("l0".equalsIgnoreCase(p)) {
            i.a(Config.TAG, p, "l0 config");
            return "{\"SYSTEM\":{\"discardap\":\"1\"}}";
        } else if ("l1".equalsIgnoreCase(p)) {
            i.a(Config.TAG, p, "l1 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":2500},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":2500},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":2500},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":2500},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":250}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":2500},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":2500}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":2500},{\"monitorPoint\":\"LoadDesc\",\"sampling\":2500}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":2000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":2500}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":2500}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":2500}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":2500},{\"monitorPoint\":\"ShowCart\",\"sampling\":2500},{\"monitorPoint\":\"UpdateCart\",\"sampling\":2500}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":2500}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":2500},{\"monitorPoint\":\"CreateOrder\",\"sampling\":2500}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":2500},{\"monitorPoint\":\"refreshAttention\",\"sampling\":2500}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":2500}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":1250},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":1250},{\"monitorPoint\":\"Config\",\"sampling\":1250},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":1250},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":2500},{\"monitorPoint\":\"enviroment\",\"sampling\":2500},{\"monitorPoint\":\"jsBridge\",\"sampling\":2500},{\"monitorPoint\":\"streamModule\",\"sampling\":2500}]},{\"module\":\"ACDS\",\"sampling\":250,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":250}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":2500}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":250},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":250},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":2500}]}]}}";
        } else if ("l2".equalsIgnoreCase(p)) {
            i.a(Config.TAG, p, "l2 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":5000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":5000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":5000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":5000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":500}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":5000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":5000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":5000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":5000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":5000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":5000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":5000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":5000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":5000},{\"monitorPoint\":\"ShowCart\",\"sampling\":5000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":5000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":5000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":5000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":5000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":5000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":5000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":5000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":2500},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":2500},{\"monitorPoint\":\"Config\",\"sampling\":2500},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":2500},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":5000},{\"monitorPoint\":\"enviroment\",\"sampling\":5000},{\"monitorPoint\":\"jsBridge\",\"sampling\":5000},{\"monitorPoint\":\"streamModule\",\"sampling\":5000}]},{\"module\":\"ACDS\",\"sampling\":500,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":500}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":5000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":500},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":500},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":5000}]}]}}";
        } else if ("l3".equalsIgnoreCase(p)) {
            i.a(Config.TAG, p, "l3 config");
            return "{\"SYSTEM\":{\"useut\":\"0\",\"bg_interval\":600000,\"fg_interval\":60000},\"STAT\":{\"sampling\":0,\"metrics\":[{\"module\":\"networkPrefer\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"network\",\"sampling\":10},{\"monitorPoint\":\"NetworkError\",\"sampling\":10000}]},{\"module\":\"mtopsdk\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"mtopStats\",\"sampling\":10},{\"monitorPoint\":\"mtopExceptions\",\"sampling\":10},{\"monitorPoint\":\"uploadStats\",\"sampling\":10000}]},{\"module\":\"ImageLib\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"ImageFlow\",\"sampling\":50},{\"monitorPoint\":\"ImageExceptions\",\"sampling\":50}]},{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"netperformance\",\"sampling\":10}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"initdata\",\"sampling\":20}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"AllPackageApps\",\"sampling\":10000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000},{\"monitorPoint\":\"H5\",\"sampling\":1},{\"monitorPoint\":\"WebViewVisit\",\"sampling\":5000}]},{\"module\":\"order\",\"sampling\":10000,\"monitorPoints\":[{\"monitorPoint\":\"Page_OrderList\",\"sampling\":500},{\"monitorPoint\":\"Page_OrderDetail\",\"sampling\":1000}]},{\"module\":\"wopc\",\"sampling\":10000},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"load\",\"sampling\":10000}]},{\"module\":\"NetworkSDK\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"TrafficStats\",\"sampling\":20}]}]},\"COUNTER\":{\"sampling\":0,\"cacheCount\":60,\"metrics\":[{\"module\":\"accs\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"to_buss\",\"sampling\":1},{\"monitorPoint\":\"resend\",\"sampling\":1}]},{\"module\":\"configCenter\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SyncConfigsFromApi\",\"sampling\":10000},{\"monitorPoint\":\"SynconfigUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"NotifyConfigChanged\",\"sampling\":1},{\"monitorPoint\":\"RegisterToken\",\"sampling\":1},{\"monitorPoint\":\"SyncReferFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"XcmdUpdateConfig\",\"sampling\":1},{\"monitorPoint\":\"SyncXcommandFromCdn\",\"sampling\":10000},{\"monitorPoint\":\"SaveConfigError\",\"sampling\":10000},{\"monitorPoint\":\"ParseTokenError\",\"sampling\":10000},{\"monitorPoint\":\"NotifyLoadConfig\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000},{\"module\":\"Page_hotpatch\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hotpatch\",\"sampling\":1000}]}]},\"ALARM\":{\"sampling\":0,\"successSampling\":0,\"failSampling\":0,\"metrics\":[{\"module\":\"Page_Home\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"HomeItemLoad\",\"sampling\":10000},{\"monitorPoint\":\"HomeNetwork\",\"sampling\":10000}]},{\"module\":\"Page_Detail\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"LoadDetail\",\"sampling\":10000},{\"monitorPoint\":\"LoadDesc\",\"sampling\":10000}]},{\"module\":\"Page_SearchItemList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchItem\",\"sampling\":10000}]},{\"module\":\"Page_Shop\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadShop\",\"sampling\":10000}]},{\"module\":\"Page_AutoLogin\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"autoLogin\",\"sampling\":10000}]},{\"module\":\"Page_Shop_Search_List\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"searchShopList\",\"sampling\":10000}]},{\"module\":\"Page_ShoppingCart\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"QueryData\",\"sampling\":10000},{\"monitorPoint\":\"ShowCart\",\"sampling\":10000},{\"monitorPoint\":\"UpdateCart\",\"sampling\":10000}]},{\"module\":\"Page_Pay\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"Alipay\",\"sampling\":10000}]},{\"module\":\"Page_ShowOrder\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"ShowOrder\",\"sampling\":10000},{\"monitorPoint\":\"CreateOrder\",\"sampling\":10000}]},{\"module\":\"Page_Attention\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"loadAttention\",\"sampling\":10000},{\"monitorPoint\":\"refreshAttention\",\"sampling\":10000}]},{\"module\":\"Page_SearchShopList\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"SearchShop\",\"sampling\":10000}]},{\"module\":\"WindVane\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"NativeError\",\"sampling\":5000},{\"monitorPoint\":\"AllPackageApps\",\"sampling\":5000},{\"monitorPoint\":\"Config\",\"sampling\":5000},{\"monitorPoint\":\"JavaScriptError\",\"sampling\":5000},{\"monitorPoint\":\"PackageApp\",\"sampling\":2000}]},{\"module\":\"WeApp+\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"domModule\",\"sampling\":10000},{\"monitorPoint\":\"enviroment\",\"sampling\":10000},{\"monitorPoint\":\"jsBridge\",\"sampling\":10000},{\"monitorPoint\":\"streamModule\",\"sampling\":10000}]},{\"module\":\"ACDS\",\"sampling\":1000,\"monitorPoints\":[{\"monitorPoint\":\"huichang\",\"sampling\":0}]},{\"module\":\"Page_HuiChangTab\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcconfig\",\"sampling\":1000}]},{\"module\":\"Page_2015MainStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcmaindegrade\",\"sampling\":10000}]},{\"module\":\"Page_2015SubStage\",\"sampling\":0,\"monitorPoints\":[{\"monitorPoint\":\"hcjs_cdn\",\"sampling\":1000},{\"monitorPoint\":\"hcjs_mtop\",\"sampling\":1000},{\"monitorPoint\":\"hcsubdegrade\",\"sampling\":10000}]}]}}";
        } else {
            i.a(Config.TAG, p, "net config");
            String e = e("b01na");
            if (e != null) {
                try {
                    JSONObject jSONObject = new JSONObject(e).getJSONObject("content");
                    if (jSONObject != null) {
                        return jSONObject.getString("c_content");
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return null;
        }
    }

    public static void f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = e();	 Catch:{ Exception -> 0x0184 }
        r1 = com.alibaba.mtl.appmonitor.d.j.a();	 Catch:{ Exception -> 0x0184 }
        r2 = "SampleRules";	 Catch:{ Exception -> 0x0184 }
        r3 = 2;	 Catch:{ Exception -> 0x0184 }
        r4 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0184 }
        r5 = "config:";	 Catch:{ Exception -> 0x0184 }
        r6 = 0;	 Catch:{ Exception -> 0x0184 }
        r4[r6] = r5;	 Catch:{ Exception -> 0x0184 }
        r5 = 1;	 Catch:{ Exception -> 0x0184 }
        r4[r5] = r0;	 Catch:{ Exception -> 0x0184 }
        com.alibaba.mtl.log.e.i.a(r2, r4);	 Catch:{ Exception -> 0x0184 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0184 }
        r2 = com.alibaba.mtl.appmonitor.f.b.b(r0);	 Catch:{ all -> 0x0181 }
        if (r2 != 0) goto L_0x0064;	 Catch:{ all -> 0x0181 }
    L_0x001f:
        r2 = r1.c;	 Catch:{ all -> 0x0181 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ all -> 0x0181 }
    L_0x0023:
        r2 = r1.c;	 Catch:{ all -> 0x0181 }
        r2 = r2.equals(r0);	 Catch:{ all -> 0x0181 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ all -> 0x0181 }
    L_0x002b:
        goto L_0x0064;	 Catch:{ all -> 0x0181 }
    L_0x002c:
        monitor-exit(r1);	 Catch:{ all -> 0x0181 }
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0065 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0065 }
        r4 = com.alibaba.mtl.appmonitor.a.f.a();	 Catch:{ Throwable -> 0x0065 }
        r7 = r4.length;	 Catch:{ Throwable -> 0x0065 }
        r8 = r6;	 Catch:{ Throwable -> 0x0065 }
    L_0x0038:
        if (r8 >= r7) goto L_0x0061;	 Catch:{ Throwable -> 0x0065 }
    L_0x003a:
        r9 = r4[r8];	 Catch:{ Throwable -> 0x0065 }
        r10 = r9.toString();	 Catch:{ Throwable -> 0x0065 }
        r10 = r2.optJSONObject(r10);	 Catch:{ Throwable -> 0x0065 }
        r11 = r1.b;	 Catch:{ Throwable -> 0x0065 }
        r11 = r11.get(r9);	 Catch:{ Throwable -> 0x0065 }
        r11 = (com.alibaba.mtl.appmonitor.d.g) r11;	 Catch:{ Throwable -> 0x0065 }
        if (r10 == 0) goto L_0x005e;	 Catch:{ Throwable -> 0x0065 }
    L_0x004e:
        if (r11 == 0) goto L_0x005e;	 Catch:{ Throwable -> 0x0065 }
    L_0x0050:
        r12 = com.alibaba.mtl.appmonitor.d.j.a;	 Catch:{ Throwable -> 0x0065 }
        r13 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0065 }
        r13[r6] = r9;	 Catch:{ Throwable -> 0x0065 }
        r13[r5] = r10;	 Catch:{ Throwable -> 0x0065 }
        com.alibaba.mtl.log.e.i.a(r12, r13);	 Catch:{ Throwable -> 0x0065 }
        r11.b(r10);	 Catch:{ Throwable -> 0x0065 }
    L_0x005e:
        r8 = r8 + 1;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0038;	 Catch:{ Throwable -> 0x0065 }
    L_0x0061:
        r1.c = r0;	 Catch:{ Throwable -> 0x0065 }
        goto L_0x0065;
    L_0x0064:
        monitor-exit(r1);	 Catch:{ all -> 0x0181 }
    L_0x0065:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0184 }
        if (r1 != 0) goto L_0x0173;
    L_0x006b:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x016c }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x016c }
        r2 = "SYSTEM";	 Catch:{ Throwable -> 0x016c }
        r2 = r1.has(r2);	 Catch:{ Throwable -> 0x016c }
        if (r2 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x016c }
    L_0x0078:
        r2 = "SystemConfig";	 Catch:{ Throwable -> 0x016c }
        r4 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x016c }
        r7 = "server system config ";	 Catch:{ Throwable -> 0x016c }
        r4[r6] = r7;	 Catch:{ Throwable -> 0x016c }
        r4[r5] = r0;	 Catch:{ Throwable -> 0x016c }
        com.alibaba.mtl.log.e.i.a(r2, r4);	 Catch:{ Throwable -> 0x016c }
        r0 = "SYSTEM";	 Catch:{ Throwable -> 0x016c }
        r0 = r1.optJSONObject(r0);	 Catch:{ Throwable -> 0x016c }
        if (r0 == 0) goto L_0x0173;
    L_0x008d:
        r1 = -1;
        r2 = "bg_interval";	 Catch:{ Throwable -> 0x00b7 }
        r2 = r0.has(r2);	 Catch:{ Throwable -> 0x00b7 }
        if (r2 == 0) goto L_0x00b7;	 Catch:{ Throwable -> 0x00b7 }
    L_0x0096:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b7 }
        r2.<init>();	 Catch:{ Throwable -> 0x00b7 }
        r4 = "bg_interval";	 Catch:{ Throwable -> 0x00b7 }
        r4 = r0.getInt(r4);	 Catch:{ Throwable -> 0x00b7 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00b7 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00b7 }
        r4 = o;	 Catch:{ Throwable -> 0x00b7 }
        if (r4 != 0) goto L_0x00b7;	 Catch:{ Throwable -> 0x00b7 }
    L_0x00ac:
        r2 = d(r2);	 Catch:{ Throwable -> 0x00b7 }
        if (r2 == r1) goto L_0x00b7;	 Catch:{ Throwable -> 0x00b7 }
    L_0x00b2:
        r2 = r2 * 1000;	 Catch:{ Throwable -> 0x00b7 }
        r7 = (long) r2;	 Catch:{ Throwable -> 0x00b7 }
        l = r7;	 Catch:{ Throwable -> 0x00b7 }
    L_0x00b7:
        r2 = "fg_interval";	 Catch:{ Throwable -> 0x00e0 }
        r2 = r0.has(r2);	 Catch:{ Throwable -> 0x00e0 }
        if (r2 == 0) goto L_0x00e0;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00bf:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e0 }
        r2.<init>();	 Catch:{ Throwable -> 0x00e0 }
        r4 = "fg_interval";	 Catch:{ Throwable -> 0x00e0 }
        r4 = r0.getInt(r4);	 Catch:{ Throwable -> 0x00e0 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00e0 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00e0 }
        r4 = n;	 Catch:{ Throwable -> 0x00e0 }
        if (r4 != 0) goto L_0x00e0;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00d5:
        r2 = d(r2);	 Catch:{ Throwable -> 0x00e0 }
        if (r2 == r1) goto L_0x00e0;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00db:
        r2 = r2 * 1000;	 Catch:{ Throwable -> 0x00e0 }
        r1 = (long) r2;	 Catch:{ Throwable -> 0x00e0 }
        m = r1;	 Catch:{ Throwable -> 0x00e0 }
    L_0x00e0:
        r1 = "SystemConfig";	 Catch:{ Throwable -> 0x016c }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x016c }
        r4 = "UTDC.bSendToNewLogStore:";	 Catch:{ Throwable -> 0x016c }
        r2[r6] = r4;	 Catch:{ Throwable -> 0x016c }
        r4 = com.alibaba.mtl.log.a.h;	 Catch:{ Throwable -> 0x016c }
        r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Throwable -> 0x016c }
        r2[r5] = r4;	 Catch:{ Throwable -> 0x016c }
        com.alibaba.mtl.log.e.i.a(r1, r2);	 Catch:{ Throwable -> 0x016c }
        r1 = "SystemConfig";	 Catch:{ Throwable -> 0x016c }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x016c }
        r4 = "Config.BACKGROUND_PERIOD:";	 Catch:{ Throwable -> 0x016c }
        r2[r6] = r4;	 Catch:{ Throwable -> 0x016c }
        r7 = l;	 Catch:{ Throwable -> 0x016c }
        r4 = java.lang.Long.valueOf(r7);	 Catch:{ Throwable -> 0x016c }
        r2[r5] = r4;	 Catch:{ Throwable -> 0x016c }
        com.alibaba.mtl.log.e.i.a(r1, r2);	 Catch:{ Throwable -> 0x016c }
        r1 = "SystemConfig";	 Catch:{ Throwable -> 0x016c }
        r2 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x016c }
        r3 = "Config.FOREGROUND_PERIOD:";	 Catch:{ Throwable -> 0x016c }
        r2[r6] = r3;	 Catch:{ Throwable -> 0x016c }
        r3 = m;	 Catch:{ Throwable -> 0x016c }
        r3 = java.lang.Long.valueOf(r3);	 Catch:{ Throwable -> 0x016c }
        r2[r5] = r3;	 Catch:{ Throwable -> 0x016c }
        com.alibaba.mtl.log.e.i.a(r1, r2);	 Catch:{ Throwable -> 0x016c }
        r1 = "discard";	 Catch:{ Throwable -> 0x014c }
        r1 = r0.has(r1);	 Catch:{ Throwable -> 0x014c }
        if (r1 == 0) goto L_0x013f;	 Catch:{ Throwable -> 0x014c }
    L_0x0121:
        r1 = "discard";	 Catch:{ Throwable -> 0x014c }
        r1 = r0.getInt(r1);	 Catch:{ Throwable -> 0x014c }
        if (r1 != r5) goto L_0x0133;	 Catch:{ Throwable -> 0x014c }
    L_0x0129:
        e = r5;	 Catch:{ Throwable -> 0x014c }
        r1 = com.alibaba.mtl.log.d.a.a();	 Catch:{ Throwable -> 0x014c }
        r1.c();	 Catch:{ Throwable -> 0x014c }
        goto L_0x014c;	 Catch:{ Throwable -> 0x014c }
    L_0x0133:
        if (r1 != 0) goto L_0x014c;	 Catch:{ Throwable -> 0x014c }
    L_0x0135:
        e = r6;	 Catch:{ Throwable -> 0x014c }
        r1 = com.alibaba.mtl.log.d.a.a();	 Catch:{ Throwable -> 0x014c }
        r1.b();	 Catch:{ Throwable -> 0x014c }
        goto L_0x014c;	 Catch:{ Throwable -> 0x014c }
    L_0x013f:
        r1 = e;	 Catch:{ Throwable -> 0x014c }
        if (r1 == 0) goto L_0x014c;	 Catch:{ Throwable -> 0x014c }
    L_0x0143:
        e = r6;	 Catch:{ Throwable -> 0x014c }
        r1 = com.alibaba.mtl.log.d.a.a();	 Catch:{ Throwable -> 0x014c }
        r1.b();	 Catch:{ Throwable -> 0x014c }
    L_0x014c:
        r1 = "cdb";	 Catch:{ Throwable -> 0x0173 }
        r1 = r0.has(r1);	 Catch:{ Throwable -> 0x0173 }
        if (r1 == 0) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0154:
        r1 = "cdb";	 Catch:{ Throwable -> 0x0173 }
        r0 = r0.getInt(r1);	 Catch:{ Throwable -> 0x0173 }
        r1 = com.alibaba.mtl.log.a.e.a();	 Catch:{ Throwable -> 0x0173 }
        if (r0 <= r1) goto L_0x0173;	 Catch:{ Throwable -> 0x0173 }
    L_0x0160:
        com.alibaba.mtl.log.e.r.a();	 Catch:{ Throwable -> 0x0173 }
        r0 = new com.alibaba.mtl.log.a.f;	 Catch:{ Throwable -> 0x0173 }
        r0.<init>();	 Catch:{ Throwable -> 0x0173 }
        com.alibaba.mtl.log.e.r.a(r0);	 Catch:{ Throwable -> 0x0173 }
        goto L_0x0173;
    L_0x016c:
        r0 = "SystemConfig";	 Catch:{ Exception -> 0x0184 }
        r1 = "updateconfig";	 Catch:{ Exception -> 0x0184 }
        com.alibaba.mtl.log.e.i.a(r0, r1);	 Catch:{ Exception -> 0x0184 }
    L_0x0173:
        r0 = com.alibaba.mtl.log.a.d.a();	 Catch:{ Exception -> 0x0184 }
        r1 = "b01n15";	 Catch:{ Exception -> 0x0184 }
        r1 = e(r1);	 Catch:{ Exception -> 0x0184 }
        r0.a(r1);	 Catch:{ Exception -> 0x0184 }
        return;
    L_0x0181:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0181 }
        throw r0;	 Catch:{ Exception -> 0x0184 }
    L_0x0184:
        r0 = move-exception;
        r0.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.a.f():void");
    }

    private static String e(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.alibaba.mtl.log.a.c());
        StringBuilder stringBuilder = new StringBuilder("ut_");
        stringBuilder.append(str);
        stringBuilder.append("_config");
        return defaultSharedPreferences.getString(stringBuilder.toString(), null);
    }

    public static String c(String str) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.alibaba.mtl.log.a.c());
        StringBuilder stringBuilder = new StringBuilder("ut_");
        stringBuilder.append(str);
        stringBuilder.append("_timestamp");
        return defaultSharedPreferences.getString(stringBuilder.toString(), "0");
    }

    public static synchronized void g() {
        synchronized (a.class) {
            if (!q) {
                q = true;
                try {
                    f();
                    j.a().b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                b a = b.a();
                r.a();
                r.a(new a(a));
            }
        }
    }
}
