package com.tencent.wxop.stat;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.ta.utdid2.android.utils.TimeUtils;
import com.tencent.a.a.a.a.g;
import com.tencent.wxop.stat.common.StatConstants;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.common.l;
import com.tencent.wxop.stat.common.q;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import java.net.URI;
import java.util.Iterator;
import org.json.JSONObject;

public class StatConfig {
    private static String A = null;
    private static String B = null;
    private static String C = null;
    private static String D = "mta_channel";
    private static int E = 180;
    private static int F = 1024;
    private static long G = 0;
    private static long H = 300000;
    private static volatile String I = "http://pingma.qq.com:80/mstat/report";
    private static int J = 0;
    private static volatile int K = 0;
    private static int L = 20;
    private static int M = 0;
    private static boolean N = false;
    private static int O = 4096;
    private static boolean P = false;
    private static String Q = null;
    private static boolean R = false;
    private static g S = null;
    static f a = new f(2);
    static f b = new f(1);
    static String c = "__HIBERNATE__";
    static String d = "__HIBERNATE__TIME";
    static String e = "__MTA_KILL__";
    static String f = "";
    static boolean g = false;
    static int h = 100;
    static long i = 10000;
    public static boolean isAutoExceptionCaught = true;
    static boolean j = true;
    static volatile String k = "pingma.qq.com:80";
    static boolean l = true;
    static int m = 0;
    static long n = 10000;
    static int o = 512;
    private static StatLogger p = l.b();
    private static StatReportStrategy q = StatReportStrategy.APP_LAUNCH;
    private static boolean r = false;
    private static boolean s = true;
    private static int t = 30000;
    private static int u = 100000;
    private static int v = 30;
    private static int w = 10;
    private static int x = 100;
    private static int y = 30;
    private static int z = 1;

    static int a() {
        return v;
    }

    static java.lang.String a(java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.b;	 Catch:{ Throwable -> 0x000b }
        r0 = r0.getString(r3);	 Catch:{ Throwable -> 0x000b }
        if (r0 == 0) goto L_0x001e;
    L_0x000a:
        return r0;
    L_0x000b:
        r0 = p;
        r1 = new java.lang.StringBuilder;
        r2 = "can't find custom key:";
        r1.<init>(r2);
        r1.append(r3);
        r3 = r1.toString();
        r0.w(r3);
    L_0x001e:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatConfig.a(java.lang.String, java.lang.String):java.lang.String");
    }

    static synchronized void a(int i) {
        synchronized (StatConfig.class) {
            K = i;
        }
    }

    static void a(long j) {
        q.b(i.a(), c, j);
        setEnableStatService(false);
        p.warn("MTA is disable for current SDK version");
    }

    static void a(Context context, f fVar) {
        if (fVar.a == b.a) {
            b = fVar;
            a(fVar.b);
            if (!b.b.isNull("iplist")) {
                a.a(context).a(b.b.getString("iplist"));
            }
            return;
        }
        if (fVar.a == a.a) {
            a = fVar;
        }
    }

    static void a(Context context, f fVar, JSONObject jSONObject) {
        Object obj = null;
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str = (String) keys.next();
                if (str.equalsIgnoreCase("v")) {
                    int i = jSONObject.getInt(str);
                    if (fVar.d != i) {
                        obj = 1;
                    }
                    fVar.d = i;
                } else if (str.equalsIgnoreCase(c.a)) {
                    str = jSONObject.getString(c.a);
                    if (str.length() > 0) {
                        fVar.b = new JSONObject(str);
                    }
                } else if (str.equalsIgnoreCase("m")) {
                    fVar.c = jSONObject.getString("m");
                }
            }
            if (obj == 1) {
                au a = au.a(i.a());
                if (a != null) {
                    a.a(fVar);
                }
                if (fVar.a == b.a) {
                    a(fVar.b);
                    b(fVar.b);
                }
            }
            a(context, fVar);
        } catch (Throwable e) {
            p.e(e);
        }
    }

    static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2;
                f fVar;
                String str = (String) keys.next();
                if (!str.equalsIgnoreCase(Integer.toString(b.a))) {
                    if (!str.equalsIgnoreCase(Integer.toString(a.a))) {
                        if (!str.equalsIgnoreCase("rs")) {
                            break;
                        }
                        StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(str));
                        if (statReportStrategy != null) {
                            q = statReportStrategy;
                            if (isDebugEnable()) {
                                StatLogger statLogger = p;
                                StringBuilder stringBuilder = new StringBuilder("Change to ReportStrategy:");
                                stringBuilder.append(statReportStrategy.name());
                                statLogger.d(stringBuilder.toString());
                            }
                        }
                    } else {
                        jSONObject2 = jSONObject.getJSONObject(str);
                        fVar = a;
                    }
                } else {
                    jSONObject2 = jSONObject.getJSONObject(str);
                    fVar = b;
                }
                a(context, fVar, jSONObject2);
            }
        } catch (Throwable e) {
            p.e(e);
        }
    }

    static void a(org.json.JSONObject r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "rs";	 Catch:{ JSONException -> 0x0010 }
        r1 = r1.getInt(r0);	 Catch:{ JSONException -> 0x0010 }
        r1 = com.tencent.wxop.stat.StatReportStrategy.getStatReportStrategy(r1);	 Catch:{ JSONException -> 0x0010 }
        if (r1 == 0) goto L_0x000f;	 Catch:{ JSONException -> 0x0010 }
    L_0x000c:
        setStatSendStrategy(r1);	 Catch:{ JSONException -> 0x0010 }
    L_0x000f:
        return;
    L_0x0010:
        r1 = isDebugEnable();
        if (r1 == 0) goto L_0x001d;
    L_0x0016:
        r1 = p;
        r0 = "rs not found.";
        r1.i(r0);
    L_0x001d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatConfig.a(org.json.JSONObject):void");
    }

    static boolean a(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    static boolean a(JSONObject jSONObject, String str, String str2) {
        if (!jSONObject.isNull(str)) {
            String optString = jSONObject.optString(str);
            if (l.c(str2) && l.c(optString) && str2.equalsIgnoreCase(optString)) {
                return true;
            }
        }
        return false;
    }

    static void b() {
        M++;
    }

    static void b(int i) {
        if (i >= 0) {
            M = i;
        }
    }

    static void b(Context context, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString(e);
            if (l.c(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                if (jSONObject2.length() != 0) {
                    StringBuilder stringBuilder;
                    StatLogger statLogger;
                    StringBuilder stringBuilder2;
                    boolean z = false;
                    if (!jSONObject2.isNull("sm")) {
                        Integer num;
                        int i;
                        StatLogger statLogger2;
                        Object obj = jSONObject2.get("sm");
                        if (obj instanceof Integer) {
                            num = (Integer) obj;
                        } else if (obj instanceof String) {
                            num = Integer.valueOf((String) obj);
                        } else {
                            i = 0;
                            if (i > 0) {
                                if (isDebugEnable()) {
                                    statLogger2 = p;
                                    stringBuilder = new StringBuilder("match sleepTime:");
                                    stringBuilder.append(i);
                                    stringBuilder.append(" minutes");
                                    statLogger2.i(stringBuilder.toString());
                                }
                                q.b(context, d, System.currentTimeMillis() + ((long) ((i * 60) * 1000)));
                                setEnableStatService(false);
                                p.warn("MTA is disable for current SDK version");
                            }
                        }
                        i = num.intValue();
                        if (i > 0) {
                            if (isDebugEnable()) {
                                statLogger2 = p;
                                stringBuilder = new StringBuilder("match sleepTime:");
                                stringBuilder.append(i);
                                stringBuilder.append(" minutes");
                                statLogger2.i(stringBuilder.toString());
                            }
                            q.b(context, d, System.currentTimeMillis() + ((long) ((i * 60) * 1000)));
                            setEnableStatService(false);
                            p.warn("MTA is disable for current SDK version");
                        }
                    }
                    if (a(jSONObject2, a.h, StatConstants.VERSION)) {
                        p.i("match sdk version:2.0.4");
                        z = true;
                    }
                    if (a(jSONObject2, IXAdRequestInfo.TEST_MODE, Build.MODEL)) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match MODEL:");
                        stringBuilder2.append(Build.MODEL);
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    if (a(jSONObject2, a.k, l.h(context))) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match app version:");
                        stringBuilder2.append(l.h(context));
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Build.MANUFACTURER);
                    if (a(jSONObject2, "mf", stringBuilder.toString())) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match MANUFACTURER:");
                        stringBuilder2.append(Build.MANUFACTURER);
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    optString = IXAdRequestInfo.OSV;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(VERSION.SDK_INT);
                    if (a(jSONObject2, optString, stringBuilder.toString())) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match android SDK version:");
                        stringBuilder2.append(VERSION.SDK_INT);
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(VERSION.SDK_INT);
                    if (a(jSONObject2, "ov", stringBuilder.toString())) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match android SDK version:");
                        stringBuilder2.append(VERSION.SDK_INT);
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    if (a(jSONObject2, "ui", au.a(context).b(context).b())) {
                        statLogger = p;
                        stringBuilder2 = new StringBuilder("match imei:");
                        stringBuilder2.append(au.a(context).b(context).b());
                        statLogger.i(stringBuilder2.toString());
                        z = true;
                    }
                    if (a(jSONObject2, "mid", getLocalMidOnly(context))) {
                        statLogger = p;
                        StringBuilder stringBuilder3 = new StringBuilder("match mid:");
                        stringBuilder3.append(getLocalMidOnly(context));
                        statLogger.i(stringBuilder3.toString());
                        z = true;
                    }
                    if (z) {
                        a(l.b(StatConstants.VERSION));
                    }
                }
            }
        } catch (Throwable e) {
            p.e(e);
        }
    }

    static void b(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 == 0) goto L_0x004d;
    L_0x0002:
        r0 = r4.length();
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.tencent.wxop.stat.i.a();	 Catch:{ JSONException -> 0x0046 }
        b(r0, r4);	 Catch:{ JSONException -> 0x0046 }
        r0 = c;	 Catch:{ JSONException -> 0x0046 }
        r4 = r4.getString(r0);	 Catch:{ JSONException -> 0x0046 }
        r0 = isDebugEnable();	 Catch:{ JSONException -> 0x0046 }
        if (r0 == 0) goto L_0x0034;	 Catch:{ JSONException -> 0x0046 }
    L_0x001c:
        r0 = p;	 Catch:{ JSONException -> 0x0046 }
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0046 }
        r2 = "hibernateVer:";	 Catch:{ JSONException -> 0x0046 }
        r1.<init>(r2);	 Catch:{ JSONException -> 0x0046 }
        r1.append(r4);	 Catch:{ JSONException -> 0x0046 }
        r2 = ", current version:2.0.4";	 Catch:{ JSONException -> 0x0046 }
        r1.append(r2);	 Catch:{ JSONException -> 0x0046 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0046 }
        r0.d(r1);	 Catch:{ JSONException -> 0x0046 }
    L_0x0034:
        r0 = com.tencent.wxop.stat.common.l.b(r4);	 Catch:{ JSONException -> 0x0046 }
        r4 = "2.0.4";	 Catch:{ JSONException -> 0x0046 }
        r2 = com.tencent.wxop.stat.common.l.b(r4);	 Catch:{ JSONException -> 0x0046 }
        r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));	 Catch:{ JSONException -> 0x0046 }
        if (r4 > 0) goto L_0x0045;	 Catch:{ JSONException -> 0x0046 }
    L_0x0042:
        a(r0);	 Catch:{ JSONException -> 0x0046 }
    L_0x0045:
        return;
    L_0x0046:
        r4 = p;
        r0 = "__HIBERNATE__ not found.";
        r4.d(r0);
    L_0x004d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatConfig.b(org.json.JSONObject):void");
    }

    static int c() {
        return M;
    }

    public static synchronized String getAppKey(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = B;
        }
        return str;
    }

    public static int getCurSessionStatReportCount() {
        return K;
    }

    public static g getCustomLogger() {
        return S;
    }

    public static String getCustomProperty(String str) {
        try {
            return a.b.getString(str);
        } catch (Throwable th) {
            p.e(th);
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        try {
            str = a.b.getString(str);
            return str != null ? str : str2;
        } catch (Throwable th) {
            p.e(th);
        }
    }

    public static String getCustomUserId(Context context) {
        if (context == null) {
            p.error((Object) "Context for getCustomUid is null.");
            return null;
        }
        if (Q == null) {
            Q = q.a(context, "MTA_CUSTOM_UID", "");
        }
        return Q;
    }

    public static long getFlushDBSpaceMS() {
        return n;
    }

    public static synchronized String getInstallChannel(Context context) {
        String str;
        synchronized (StatConfig.class) {
            str = C;
        }
        return str;
    }

    public static String getLocalMidOnly(Context context) {
        return context != null ? g.C(context).p().a() : "0";
    }

    public static int getMaxBatchReportCount() {
        return y;
    }

    public static int getMaxDaySessionNumbers() {
        return L;
    }

    public static int getMaxImportantDataSendRetryCount() {
        return x;
    }

    public static int getMaxParallelTimmingEvents() {
        return F;
    }

    public static int getMaxReportEventLength() {
        return O;
    }

    public static int getMaxSendRetryCount() {
        return w;
    }

    public static int getMaxSessionStatReportCount() {
        return J;
    }

    public static int getMaxStoreEventCount() {
        return u;
    }

    public static String getMid(Context context) {
        return getLocalMidOnly(context);
    }

    public static long getMsPeriodForMethodsCalledLimitClear() {
        return i;
    }

    public static int getNumEventsCachedInMemory() {
        return m;
    }

    public static int getNumEventsCommitPerSec() {
        return z;
    }

    public static int getNumOfMethodsCalledLimit() {
        return h;
    }

    public static String getQQ(Context context) {
        return q.a(context, "mta.acc.qq", f);
    }

    public static int getReportCompressedSize() {
        return o;
    }

    public static int getSendPeriodMinutes() {
        return E;
    }

    public static int getSessionTimoutMillis() {
        return t;
    }

    public static String getStatReportHost() {
        return k;
    }

    public static String getStatReportUrl() {
        return I;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return q;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    public static boolean isDebugEnable() {
        return r;
    }

    public static boolean isEnableConcurrentProcess() {
        return P;
    }

    public static boolean isEnableSmartReporting() {
        return j;
    }

    public static boolean isEnableStatService() {
        return s;
    }

    public static boolean isReportEventsByOrder() {
        return l;
    }

    public static boolean isXGProMode() {
        return R;
    }

    public static void setAppKey(Context context, String str) {
        StatLogger statLogger;
        Object obj;
        if (context == null) {
            statLogger = p;
            obj = "ctx in StatConfig.setAppKey() is null";
        } else {
            if (str != null) {
                if (str.length() <= 256) {
                    B = str;
                    return;
                }
            }
            statLogger = p;
            obj = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        statLogger.error(obj);
    }

    public static void setAppKey(String str) {
        StatLogger statLogger;
        Object obj;
        if (str == null) {
            statLogger = p;
            obj = "appkey in StatConfig.setAppKey() is null";
        } else if (str.length() > 256) {
            statLogger = p;
            obj = "The length of appkey cann't exceed 256 bytes.";
        } else {
            B = str;
            return;
        }
        statLogger.error(obj);
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    public static void setCustomLogger(g gVar) {
        S = gVar;
    }

    public static void setCustomUserId(Context context, String str) {
        if (context == null) {
            p.error((Object) "Context for setCustomUid is null.");
            return;
        }
        q.b(context, "MTA_CUSTOM_UID", str);
        Q = str;
    }

    public static void setDebugEnable(boolean z) {
        r = z;
        l.b().setDebugEnable(z);
    }

    public static void setEnableConcurrentProcess(boolean z) {
        P = z;
    }

    public static void setEnableSmartReporting(boolean z) {
        j = z;
    }

    public static void setEnableStatService(boolean z) {
        s = z;
        if (!z) {
            p.warn("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void setFlushDBSpaceMS(long j) {
        if (j > 0) {
            n = j;
        }
    }

    public static void setInstallChannel(Context context, String str) {
        if (str.length() > 128) {
            p.error((Object) "the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            C = str;
        }
    }

    public static void setInstallChannel(String str) {
        C = str;
    }

    public static void setMaxBatchReportCount(int i) {
        if (a(i, 2, 1000)) {
            y = i;
        } else {
            p.error((Object) "setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            p.e((Object) "maxDaySessionNumbers must be greater than 0.");
        } else {
            L = i;
        }
    }

    public static void setMaxImportantDataSendRetryCount(int i) {
        if (i > 100) {
            x = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (a(i, 1, 4096)) {
            F = i;
        } else {
            p.error((Object) "setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            p.error((Object) "maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            O = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (a(i, 1, 1000)) {
            w = i;
        } else {
            p.error((Object) "setMaxSendRetryCount can not exceed the range of [1,1000].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            p.error((Object) "maxSessionStatReportCount cannot be less than 0.");
        } else {
            J = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (a(i, 0, 500000)) {
            u = i;
        } else {
            p.error((Object) "setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setNumEventsCachedInMemory(int i) {
        if (i >= 0) {
            m = i;
        }
    }

    public static void setNumEventsCommitPerSec(int i) {
        if (i > 0) {
            z = i;
        }
    }

    public static void setNumOfMethodsCalledLimit(int i, long j) {
        h = i;
        if (j >= 1000) {
            i = j;
        }
    }

    public static void setQQ(Context context, String str) {
        q.b(context, "mta.acc.qq", str);
        f = str;
    }

    public static void setReportCompressedSize(int i) {
        if (i > 0) {
            o = i;
        }
    }

    public static void setReportEventsByOrder(boolean z) {
        l = z;
    }

    public static void setSendPeriodMinutes(int i) {
        if (a(i, 1, 10080)) {
            E = i;
        } else {
            p.error((Object) "setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (a(i, 1000, (int) TimeUtils.TOTAL_M_S_ONE_DAY)) {
            t = i;
        } else {
            p.error((Object) "setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str != null) {
            if (str.length() != 0) {
                I = str;
                try {
                    k = new URI(I).getHost();
                } catch (Exception e) {
                    p.w(e);
                }
                if (isDebugEnable()) {
                    StatLogger statLogger = p;
                    StringBuilder stringBuilder = new StringBuilder("url:");
                    stringBuilder.append(I);
                    stringBuilder.append(", domain:");
                    stringBuilder.append(k);
                    statLogger.i(stringBuilder.toString());
                }
                return;
            }
        }
        p.error((Object) "statReportUrl cannot be null or empty.");
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        q = statReportStrategy;
        if (statReportStrategy != StatReportStrategy.PERIOD) {
            StatServiceImpl.c = 0;
        }
        if (isDebugEnable()) {
            StatLogger statLogger = p;
            StringBuilder stringBuilder = new StringBuilder("Change to statSendStrategy: ");
            stringBuilder.append(statReportStrategy);
            statLogger.d(stringBuilder.toString());
        }
    }

    public static void setXGProMode(boolean z) {
        R = z;
    }
}
