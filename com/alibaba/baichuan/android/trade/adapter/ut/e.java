package com.alibaba.baichuan.android.trade.adapter.ut;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.ut.performance.PerformancePoint;
import com.alibaba.baichuan.android.trade.utils.c;
import com.alibaba.baichuan.android.trade.utils.g.a;

public class e {
    private static final String a = "e";
    private static long b;

    public static void a() {
        b = System.currentTimeMillis();
    }

    public static void a(String str) {
        if (str == null) {
            c.a(a, "sendUseabilityFailure", "label/errMsg is null!");
            return;
        }
        str = b(str);
        a.a();
        a.a("BCTradeSDK", str);
    }

    public static void a(String str, String str2) {
        a(str, str2, null);
    }

    private static String b(String str) {
        if (str.contains("_Page_Native")) {
            return "Page_Native";
        }
        if (str.contains("_Page_H5")) {
            return "Page_H5";
        }
        if (str.contains("Taoke_Trace_")) {
            str = "Taoke_Trace";
        }
        return str;
    }

    public static void b() {
        b = System.currentTimeMillis() - b;
    }

    public static void b(String str, String str2, String str3) {
        if (str != null) {
            if (str3 != null) {
                str = b(str);
                a.a();
                String str4 = "BCTradeSDK";
                if (str2 == null) {
                    str2 = "";
                }
                a.a(str4, str, str3, str2);
                return;
            }
        }
        c.a(a, "sendUseabilityFailure", "monitorPoint/errCode is null!");
    }

    public static void a(PerformancePoint performancePoint) {
        if (performancePoint == null) {
            c.a(a, "sendPerfomancePoint", "pagePerformancePoint is null");
            return;
        }
        new StringBuilder("sendPerfomancePoint:").append(performancePoint.toString());
        AlibcContext.b();
        if (!performancePoint.checkData()) {
            a.b();
        }
        a.a();
        a.a("BCTradeSDK", performancePoint.getMonitorPoint(), performancePoint.getDimensionValues(), performancePoint.getMeasureValues());
    }

    public static void a(String str, String str2, String str3) {
        if (str != null) {
            if (str2 != null) {
                str2 = c.a(str, str2, str3);
                if (str2 == null) {
                    str = a;
                    str2 = "sendUseabilityFailure";
                    str3 = "usabilityErrorMsg is null !";
                    c.a(str, str2, str3);
                }
                str = b(str);
                a.a();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2.a);
                stringBuilder.append(str2.b);
                stringBuilder.append(str2.c);
                a.a("BCTradeSDK", str, stringBuilder.toString(), str2.d);
                return;
            }
        }
        str = a;
        str2 = "sendUseabilityFailure";
        str3 = "label/errMsg is null!";
        c.a(str, str2, str3);
    }
}
