package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.b;
import com.tencent.wxop.stat.common.e;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import com.tencent.wxop.stat.event.a;
import com.tencent.wxop.stat.event.c;
import com.tencent.wxop.stat.event.h;
import com.tencent.wxop.stat.event.k;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class StatServiceImpl {
    static volatile int a = 0;
    static volatile long b = 0;
    static volatile long c = 0;
    private static e d = null;
    private static volatile Map<c, Long> e = new ConcurrentHashMap();
    private static volatile Map<String, Properties> f = new ConcurrentHashMap();
    private static volatile Map<Integer, Integer> g = new ConcurrentHashMap(10);
    private static volatile long h = 0;
    private static volatile long i = 0;
    private static volatile long j = 0;
    private static String k = "";
    private static volatile int l = 0;
    private static volatile String m = "";
    private static volatile String n = "";
    private static Map<String, Long> o = new ConcurrentHashMap();
    private static Map<String, Long> p = new ConcurrentHashMap();
    private static StatLogger q = l.b();
    private static UncaughtExceptionHandler r = null;
    private static volatile boolean s = true;
    private static Context t;

    static int a(Context context, boolean z, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = (!z || currentTimeMillis - i < ((long) StatConfig.getSessionTimoutMillis())) ? false : 1;
        i = currentTimeMillis;
        if (j == 0) {
            j = l.c();
        }
        if (currentTimeMillis >= j) {
            j = l.c();
            if (au.a(context).b(context).d() != 1) {
                au.a(context).b(context).a(1);
            }
            StatConfig.b(0);
            a = 0;
            k = l.a(0);
            i = 1;
        }
        Object obj = k;
        if (l.a(statSpecifyReportedInfo)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(statSpecifyReportedInfo.getAppKey());
            stringBuilder.append(k);
            obj = stringBuilder.toString();
        }
        if (!p.containsKey(obj)) {
            i = 1;
        }
        if (i != 0) {
            if (l.a(statSpecifyReportedInfo)) {
                a(context, statSpecifyReportedInfo);
            } else if (StatConfig.c() < StatConfig.getMaxDaySessionNumbers()) {
                l.v(context);
                a(context, null);
            } else {
                q.e((Object) "Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            p.put(obj, Long.valueOf(1));
        }
        if (s) {
            testSpeed(context);
            s = false;
        }
        return l;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized void a(android.content.Context r7) {
        /*
        r0 = com.tencent.wxop.stat.StatServiceImpl.class;
        monitor-enter(r0);
        if (r7 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r0);
        return;
    L_0x0007:
        r1 = d;	 Catch:{ all -> 0x003d }
        if (r1 != 0) goto L_0x003b;
    L_0x000b:
        r1 = b(r7);	 Catch:{ all -> 0x003d }
        if (r1 != 0) goto L_0x0013;
    L_0x0011:
        monitor-exit(r0);
        return;
    L_0x0013:
        r7 = r7.getApplicationContext();	 Catch:{ all -> 0x003d }
        t = r7;	 Catch:{ all -> 0x003d }
        r1 = new com.tencent.wxop.stat.common.e;	 Catch:{ all -> 0x003d }
        r1.<init>();	 Catch:{ all -> 0x003d }
        d = r1;	 Catch:{ all -> 0x003d }
        r1 = 0;
        r1 = com.tencent.wxop.stat.common.l.a(r1);	 Catch:{ all -> 0x003d }
        k = r1;	 Catch:{ all -> 0x003d }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x003d }
        r3 = com.tencent.wxop.stat.StatConfig.i;	 Catch:{ all -> 0x003d }
        r5 = r1 + r3;
        h = r5;	 Catch:{ all -> 0x003d }
        r1 = d;	 Catch:{ all -> 0x003d }
        r2 = new com.tencent.wxop.stat.l;	 Catch:{ all -> 0x003d }
        r2.<init>(r7);	 Catch:{ all -> 0x003d }
        r1.a(r2);	 Catch:{ all -> 0x003d }
    L_0x003b:
        monitor-exit(r0);
        return;
    L_0x003d:
        r7 = move-exception;
        monitor-exit(r0);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatServiceImpl.a(android.content.Context):void");
    }

    static void a(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (c(context) != null) {
            if (StatConfig.isDebugEnable()) {
                q.d("start new session.");
            }
            if (statSpecifyReportedInfo == null || l == 0) {
                l = l.a();
            }
            StatConfig.a(0);
            StatConfig.b();
            new aq(new k(context, l, b(), statSpecifyReportedInfo)).a();
        }
    }

    static void a(Context context, Throwable th) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.reportSdkSelfException() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new q(context, th));
            }
        }
    }

    static boolean a() {
        if (a < 2) {
            return false;
        }
        b = System.currentTimeMillis();
        return true;
    }

    static boolean a(String str) {
        if (str != null) {
            if (str.length() != 0) {
                return false;
            }
        }
        return true;
    }

    static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (StatConfig.b.d != 0) {
                jSONObject2.put("v", StatConfig.b.d);
            }
            jSONObject.put(Integer.toString(StatConfig.b.a), jSONObject2);
            jSONObject2 = new JSONObject();
            if (StatConfig.a.d != 0) {
                jSONObject2.put("v", StatConfig.a.d);
            }
            jSONObject.put(Integer.toString(StatConfig.a.a), jSONObject2);
            return jSONObject;
        } catch (Throwable e) {
            q.e(e);
            return jSONObject;
        }
    }

    private static void b(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            new aq(new a(context, a(context, false, statSpecifyReportedInfo), statAccount, statSpecifyReportedInfo)).a();
        } catch (Throwable th) {
            q.e(th);
            a(context, th);
        }
    }

    static boolean b(Context context) {
        boolean z;
        long a = q.a(context, StatConfig.c, 0);
        long b = l.b(StatConstants.VERSION);
        if (b <= a) {
            StatLogger statLogger = q;
            StringBuilder stringBuilder = new StringBuilder("MTA is disable for current version:");
            stringBuilder.append(b);
            stringBuilder.append(",wakeup version:");
            stringBuilder.append(a);
            statLogger.error(stringBuilder.toString());
            z = false;
        } else {
            z = true;
        }
        long a2 = q.a(context, StatConfig.d, 0);
        if (a2 > System.currentTimeMillis()) {
            StatLogger statLogger2 = q;
            StringBuilder stringBuilder2 = new StringBuilder("MTA is disable for current time:");
            stringBuilder2.append(System.currentTimeMillis());
            stringBuilder2.append(",wakeup time:");
            stringBuilder2.append(a2);
            statLogger2.error(stringBuilder2.toString());
            z = false;
        }
        StatConfig.setEnableStatService(z);
        return z;
    }

    static e c(Context context) {
        if (d == null) {
            synchronized (StatServiceImpl.class) {
                if (d == null) {
                    try {
                        a(context);
                    } catch (Throwable th) {
                        q.error(th);
                        StatConfig.setEnableStatService(false);
                    }
                }
            }
        }
        return d;
    }

    static void c() {
        a = 0;
        b = 0;
    }

    public static void commitEvents(Context context, int i) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (StatConfig.isDebugEnable()) {
                StatLogger statLogger2 = q;
                StringBuilder stringBuilder = new StringBuilder("commitEvents, maxNumber=");
                stringBuilder.append(i);
                statLogger2.i(stringBuilder.toString());
            }
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.commitEvents() can not be null!";
            } else {
                if (i >= -1) {
                    if (i != 0) {
                        if (a.a(t).f() && c(context) != null) {
                            d.a(new ad(context, i));
                        }
                        return;
                    }
                }
                statLogger = q;
                obj = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            }
            statLogger.error(obj);
        }
    }

    static void d() {
        a++;
        b = System.currentTimeMillis();
        flushDataToDB(t);
    }

    static void d(Context context) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                i.b(context).a(new h(context), new t());
            } catch (Throwable th) {
                q.e(th);
            }
        }
    }

    static void e(Context context) {
        c = System.currentTimeMillis() + ((long) (60000 * StatConfig.getSendPeriodMinutes()));
        q.b(context, "last_period_ts", c);
        commitEvents(context, -1);
    }

    public static void flushDataToDB(Context context) {
        if (StatConfig.isEnableStatService() && StatConfig.m > 0) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.testSpeed() can not be null!");
            } else {
                au.a(context).c();
            }
        }
    }

    public static Properties getCommonKeyValueForKVEvent(String str) {
        return (Properties) f.get(str);
    }

    public static Context getContext(Context context) {
        return context != null ? context : t;
    }

    public static void onLowMemory(Context context) {
        if (StatConfig.isEnableStatService() && c(getContext(context)) != null) {
            d.a(new o(context));
        }
    }

    public static void onPause(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && c(context) != null) {
            d.a(new m(context, statSpecifyReportedInfo));
        }
    }

    public static void onResume(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService() && c(context) != null) {
            d.a(new aj(context, statSpecifyReportedInfo));
        }
    }

    public static void onStop(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (c(context) != null) {
                d.a(new n(context));
            }
        }
    }

    public static void reportAccount(Context context, StatAccount statAccount, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.e((Object) "context is null in reportAccount.");
                return;
            }
            if (c(context) != null) {
                d.a(new al(statAccount, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = q;
                obj = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() == null) {
                statLogger = q;
                obj = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            } else {
                statAppMonitor = statAppMonitor.clone();
                if (c(context) != null) {
                    d.a(new aa(context, statSpecifyReportedInfo, statAppMonitor));
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void reportError(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.reportError() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new p(str, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportException(Context context, Throwable th, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.reportException() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new r(th, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportGameUser(Context context, StatGameUser statGameUser, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.reportGameUser() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new am(statGameUser, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void reportQQ(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "context is null in reportQQ()");
                return;
            }
            if (c(context) != null) {
                d.a(new ak(str, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void setCommonKeyValueForKVEvent(String str, Properties properties) {
        if (!l.c(str)) {
            q.e((Object) "event_id or commonProp for setCommonKeyValueForKVEvent is invalid.");
        } else if (properties == null || properties.size() <= 0) {
            f.remove(str);
        } else {
            f.put(str, (Properties) properties.clone());
        }
    }

    public static void setContext(Context context) {
        if (context != null) {
            t = context.getApplicationContext();
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map != null) {
            if (map.size() <= 512) {
                try {
                    b.a(context, (Map) map);
                    return;
                } catch (Throwable e) {
                    q.e(e);
                    return;
                }
            }
        }
        q.error((Object) "The map in setEnvAttributes can't be null or its size can't exceed 512.");
    }

    public static void startNewSession(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.startNewSession() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new ai(context, statSpecifyReportedInfo));
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        try {
            if (StatConfig.isEnableStatService()) {
                String str3 = StatConstants.VERSION;
                if (StatConfig.isDebugEnable()) {
                    StatLogger statLogger = q;
                    StringBuilder stringBuilder = new StringBuilder("MTA SDK version, current: ");
                    stringBuilder.append(str3);
                    stringBuilder.append(" ,required: ");
                    stringBuilder.append(str2);
                    statLogger.d(stringBuilder.toString());
                }
                if (context != null) {
                    if (str2 != null) {
                        if (l.b(str3) < l.b(str2)) {
                            StringBuilder stringBuilder2 = new StringBuilder("MTA SDK version conflicted, current: ");
                            stringBuilder2.append(str3);
                            stringBuilder2.append(",required: ");
                            stringBuilder2.append(str2);
                            String stringBuilder3 = stringBuilder2.toString();
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(stringBuilder3);
                            stringBuilder4.append(". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                            q.error(stringBuilder4.toString());
                            StatConfig.setEnableStatService(false);
                            return false;
                        }
                        str2 = StatConfig.getInstallChannel(context);
                        if (str2 == null || str2.length() == 0) {
                            StatConfig.setInstallChannel("-");
                        }
                        if (str != null) {
                            StatConfig.setAppKey(context, str);
                        }
                        if (c(context) != null) {
                            d.a(new an(context, statSpecifyReportedInfo));
                        }
                        return true;
                    }
                }
                q.error((Object) "Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
                StatConfig.setEnableStatService(false);
                return false;
            }
            q.error((Object) "MTA StatService is disable.");
            return false;
        } catch (Throwable th) {
            q.e(th);
            return false;
        }
    }

    public static void stopSession() {
        i = 0;
    }

    public static void testSpeed(Context context) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.testSpeed() can not be null!");
                return;
            }
            if (c(context) != null) {
                d.a(new ae(context));
            }
        }
    }

    public static void testSpeed(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.testSpeed() can not be null!";
            } else {
                if (map != null) {
                    if (map.size() != 0) {
                        Map hashMap = new HashMap(map);
                        if (c(context) != null) {
                            d.a(new af(context, hashMap, statSpecifyReportedInfo));
                        }
                        return;
                    }
                }
                statLogger = q;
                obj = "The domainMap of StatService.testSpeed() can not be null or empty!";
            }
            statLogger.error(obj);
        }
    }

    public static void trackBeginPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (!(context == null || str == null)) {
                if (str.length() != 0) {
                    String str2 = new String(str);
                    if (c(context) != null) {
                        d.a(new w(str2, context, statSpecifyReportedInfo));
                    }
                    return;
                }
            }
            q.error((Object) "The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
        }
    }

    public static void trackCustomBeginEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            c cVar = new c(str, strArr, null);
            if (c(context) != null) {
                d.a(new v(str, cVar, context));
            }
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.trackCustomBeginEvent() can not be null!");
                return;
            }
            c cVar = new c(str, null, properties);
            if (c(context) != null) {
                d.a(new y(str, cVar, context));
            }
        }
    }

    public static void trackCustomEndEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            c cVar = new c(str, strArr, null);
            if (c(context) != null) {
                d.a(new x(str, cVar, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (context == null) {
                q.error((Object) "The Context of StatService.trackCustomEndEvent() can not be null!");
                return;
            }
            c cVar = new c(str, null, properties);
            if (c(context) != null) {
                d.a(new z(str, cVar, context, statSpecifyReportedInfo));
            }
        }
    }

    public static void trackCustomEvent(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (a(str)) {
                statLogger = q;
                obj = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                c cVar = new c(str, strArr, null);
                if (c(context) != null) {
                    d.a(new s(context, statSpecifyReportedInfo, cVar));
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (a(str)) {
                statLogger = q;
                obj = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            } else {
                c cVar = new c(str, null, properties);
                if (c(context) != null) {
                    d.a(new u(context, statSpecifyReportedInfo, cVar));
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomKVTimeIntervalEvent(Context context, String str, Properties properties, int i, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            context = getContext(context);
            if (context == null) {
                statLogger = q;
                obj = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (a(str)) {
                statLogger = q;
                obj = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            } else {
                c cVar = new c(str, null, properties);
                if (c(context) != null) {
                    d.a(new ac(context, statSpecifyReportedInfo, cVar, i));
                }
                return;
            }
            statLogger.error(obj);
        }
    }

    public static void trackCustomTimeIntervalEvent(Context context, int i, String str, String... strArr) {
        if (StatConfig.isEnableStatService()) {
            StatLogger statLogger;
            Object obj;
            if (i <= 0) {
                statLogger = q;
                obj = "The intervalSecond of StatService.trackCustomTimeIntervalEvent() can must bigger than 0!";
            } else {
                context = getContext(context);
                if (context == null) {
                    statLogger = q;
                    obj = "The Context of StatService.trackCustomTimeIntervalEvent() can not be null!";
                } else {
                    if (c(context) != null) {
                        d.a(new ab());
                    }
                    return;
                }
            }
            statLogger.error(obj);
        }
    }

    public static void trackEndPage(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        if (StatConfig.isEnableStatService()) {
            context = getContext(context);
            if (!(context == null || str == null)) {
                if (str.length() != 0) {
                    String str2 = new String(str);
                    if (c(context) != null) {
                        d.a(new ah(context, str2, statSpecifyReportedInfo));
                    }
                    return;
                }
            }
            q.error((Object) "The Context or pageName of StatService.trackEndPage() can not be null or empty!");
        }
    }
}
