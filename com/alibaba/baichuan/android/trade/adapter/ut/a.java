package com.alibaba.baichuan.android.trade.adapter.ut;

import android.content.Context;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.AppMonitor.d;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.o;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders.UTCustomHitBuilder;
import java.util.Map;

public class a {
    private static final String a = "a";
    private static a d;
    private Context b = AlibcContext.a;
    private String c = AlibcContext.c();

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            aVar = d;
        }
        return aVar;
    }

    public static void a(String str, String str2) {
        if (str2 == null) {
            c.a(a, "sendUseabilitySuccess", "module/monitorPoint is null!");
        } else {
            com.alibaba.mtl.appmonitor.AppMonitor.a.a(str, str2, c());
        }
    }

    public static void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        if (!(str2 == null || measureValueSet == null)) {
            if (dimensionValueSet != null) {
                d.a(str, str2, dimensionValueSet, measureValueSet);
                return;
            }
        }
        c.a(a, "sendPerfomancePoint", "module/monitorPoint/measureValueSet/dimensionValueSet is null!");
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    }

    public static void a(String str, String str2, String str3, String str4) {
        if (!(str2 == null || str3 == null)) {
            if (str4 != null) {
                com.alibaba.mtl.appmonitor.AppMonitor.a.a(str, str2, c(), str3, str4);
                return;
            }
        }
        c.a(a, "sendUseabilityFailure", "module/monitorPoint/errorCode/errorMsg is null!");
    }

    private static String c() {
        if (!(AlibcContext.c() == null || AlibcContext.d == null)) {
            if (com.alibaba.baichuan.android.trade.e.a.g().d() != null) {
                b bVar = new b();
                bVar.a = AlibcContext.c();
                bVar.c = AlibcContext.d;
                bVar.b = com.alibaba.baichuan.android.trade.e.a.g().d();
                return com.alibaba.fastjson.a.toJSONString(bVar);
            }
        }
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        c.a("AlibcUserTracker", "getArg", "appkey/sdkversion/channel is null");
        return "";
    }

    private a() {
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
        r4 = this;
        r4.<init>();
        com.alibaba.baichuan.android.trade.adapter.ut.e.a();
        r0 = com.alibaba.baichuan.android.trade.AlibcContext.c();
        r4.c = r0;
        r0 = com.alibaba.baichuan.android.trade.AlibcContext.a;
        r4.b = r0;
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = r4.b;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.setContext(r1);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = r4.b;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = r1.getApplicationContext();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = (android.app.Application) r1;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.setAppApplicationInstance(r1);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = com.alibaba.baichuan.android.trade.e.a.g();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = r1.d();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.setChannel(r1);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = new com.ut.mini.core.sign.UTSecuritySDKRequestAuthentication;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r2 = r4.c;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r3 = "";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1.<init>(r2, r3);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.setRequestAuthentication(r1);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = com.alibaba.baichuan.android.trade.AlibcContext.e;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        if (r0 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
    L_0x004b:
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.turnOnDebug();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
    L_0x0052:
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.turnOffAutoPageTrack();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = com.alibaba.baichuan.android.trade.AlibcContext.e;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        if (r0 == 0) goto L_0x007a;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
    L_0x005d:
        com.alibaba.mtl.appmonitor.AppMonitor.a();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.<init>();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = "debug_api_url";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r2 = "http://muvp.alibaba-inc.com/online/UploadRecords.do";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = "debug_key";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r2 = "fhx";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = com.ut.mini.internal.UTTeamWork.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1.turnOnRealTimeDebug(r0);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
    L_0x007a:
        r0 = com.ut.mini.UTAnalytics.getInstance();	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = "aliTradesdk";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0 = r0.getTracker(r1);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r1 = "sdk_version";	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r2 = com.alibaba.baichuan.android.trade.AlibcContext.d;	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
        r0.setGlobalProperty(r1, r2);	 Catch:{ Exception -> 0x008b, Exception -> 0x008b }
    L_0x008b:
        r0 = "BCTradeSDK";
        r1 = "init";
        r2 = com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4Init.getMeasureSet();
        r3 = com.alibaba.baichuan.android.trade.adapter.ut.performance.PerformancePoint.getDimensionSet();
        com.alibaba.mtl.appmonitor.AppMonitor.a(r0, r1, r2, r3);
        r0 = "BCTradeSDK";
        r1 = "showH5";
        r2 = com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4ShowH5.getMeasureSet();
        r3 = com.alibaba.baichuan.android.trade.adapter.ut.performance.PerformancePoint.getDimensionSet();
        com.alibaba.mtl.appmonitor.AppMonitor.a(r0, r1, r2, r3);
        r0 = "BCTradeSDK";
        r1 = "showNative";
        r2 = com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4ShowNative.getMeasureSet();
        r3 = com.alibaba.baichuan.android.trade.adapter.ut.performance.PagePerformancePoint.getDimensionSet();
        com.alibaba.mtl.appmonitor.AppMonitor.a(r0, r1, r2, r3);
        r0 = "BCTradeSDK";
        r1 = "urlLoad";
        r2 = com.alibaba.baichuan.android.trade.adapter.ut.performance.Point4UrlLoad.getMeasureSet();
        r3 = com.alibaba.baichuan.android.trade.adapter.ut.performance.PerformancePoint.getDimensionSet();
        com.alibaba.mtl.appmonitor.AppMonitor.a(r0, r1, r2, r3);
        com.alibaba.baichuan.android.trade.adapter.ut.e.b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.adapter.ut.a.<init>():void");
    }

    public static void a(String str, String str2, Map map) {
        StringBuilder stringBuilder = new StringBuilder("调用ut打点，传入参数信息为：label=");
        stringBuilder.append(str);
        stringBuilder.append(" time=60 page=");
        stringBuilder.append(str2);
        stringBuilder.append(" prop=");
        stringBuilder.append(map);
        AlibcContext.b();
        UTCustomHitBuilder uTCustomHitBuilder = new UTCustomHitBuilder(str);
        uTCustomHitBuilder.setDurationOnEvent(60);
        uTCustomHitBuilder.setEventPage(str2);
        uTCustomHitBuilder.setProperties(map);
        str = uTCustomHitBuilder.build();
        new StringBuilder("调用ut打点，经过UTHitBuilders构造后参数为：map=").append(str);
        AlibcContext.b();
        UTAnalytics.getInstance().getTracker("aliTradesdk").send(str);
    }

    public static void b() {
        int b = com.alibaba.baichuan.android.trade.e.a.g().b();
        AppMonitor.a(b);
        if (AppMonitor.m()) {
            AppMonitor.c.a(new o(b));
        }
    }
}
