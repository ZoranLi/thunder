package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ao;
import com.tencent.bugly.proguard.ap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public class b {
    public static boolean a = true;
    public static List<a> b = new ArrayList();
    public static boolean c;
    private static ae d;
    private static boolean e;

    private static boolean a(a aVar) {
        List list = aVar.t;
        aVar.getClass();
        return (list == null || list.contains("bugly") == null) ? null : true;
    }

    public static synchronized void a(Context context) {
        synchronized (b.class) {
            a(context, null);
        }
    }

    public static synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (e) {
                an.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                context = an.b;
            } else {
                a a = a.a(context);
                if (a(a)) {
                    a = false;
                    return;
                }
                String f = a.f();
                if (f == null) {
                    context = an.b;
                    return;
                }
                a(context, f, a.z, buglyStrategy);
            }
        }
    }

    public static synchronized void a(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (b.class) {
            if (e) {
                an.d("[init] initial Multi-times, ignore this.", new Object[0]);
            } else if (context == null) {
                context = an.b;
            } else if (str == null) {
                context = an.b;
            } else {
                e = true;
                if (z) {
                    c = true;
                    an.c = true;
                    an.d("Bugly debug模式开启，请在发布时把isDebug关闭。 -- Running in debug model for 'isDebug' is enabled. Please disable it when you release.", new Object[0]);
                    an.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    an.d("Bugly debug模式将有以下行为特性 -- The following list shows the behaviour of debug model: ", new Object[0]);
                    an.d("[1] 输出详细的Bugly SDK的Log -- More detailed log of Bugly SDK will be output to logcat;", new Object[0]);
                    an.d("[2] 每一条Crash都会被立即上报 -- Every crash caught by Bugly will be uploaded immediately.", new Object[0]);
                    an.d("[3] 自定义日志将会在Logcat中输出 -- Custom log will be output to logcat.", new Object[0]);
                    an.e("--------------------------------------------------------------------------------------------", new Object[0]);
                    an.b("[init] Open debug mode of Bugly.", new Object[0]);
                }
                an.a("[init] Bugly version: v%s", "2.6.5");
                an.a(" crash report start initializing...", new Object[0]);
                an.b("[init] Bugly start initializing...", new Object[0]);
                an.a("[init] Bugly complete version: v%s", "2.6.5(1.3.4)");
                context = ap.a(context);
                a a = a.a(context);
                a.t();
                ao.a(context);
                d = ae.a(context, b);
                ak.a(context);
                com.tencent.bugly.crashreport.common.strategy.a a2 = com.tencent.bugly.crashreport.common.strategy.a.a(context, b);
                ac a3 = ac.a(context);
                if (a(a)) {
                    a = false;
                    return;
                }
                a.a(str);
                an.a("[param] Set APP ID:%s", str);
                a(buglyStrategy, a);
                com.tencent.bugly.crashreport.biz.b.a(context, buglyStrategy);
                for (str = null; str < b.size(); str++) {
                    try {
                        if (a3.a(((a) b.get(str)).id)) {
                            ((a) b.get(str)).init(context, z, buglyStrategy);
                        }
                    } catch (Throwable th) {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                    }
                }
                a2.a(buglyStrategy != null ? buglyStrategy.getAppReportDelay() : 0);
                an.b("[init] Bugly initialization finished.", new Object[0]);
            }
        }
    }

    private static void a(BuglyStrategy buglyStrategy, a aVar) {
        if (buglyStrategy != null) {
            String appVersion = buglyStrategy.getAppVersion();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    an.d("appVersion %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), appVersion.substring(0, 100));
                    appVersion = r1;
                }
                aVar.o = appVersion;
                an.a("[param] Set App version: %s", buglyStrategy.getAppVersion());
            }
            try {
                if (buglyStrategy.isReplaceOldChannel()) {
                    appVersion = buglyStrategy.getAppChannel();
                    if (!TextUtils.isEmpty(appVersion)) {
                        if (appVersion.length() > 100) {
                            an.d("appChannel %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), appVersion.substring(0, 100));
                            appVersion = r1;
                        }
                        d.a(556, "app_channel", appVersion.getBytes(), null, false);
                        aVar.q = appVersion;
                    }
                } else {
                    Map a = d.a(556, null, true);
                    if (a != null) {
                        byte[] bArr = (byte[]) a.get("app_channel");
                        if (bArr != null) {
                            aVar.q = new String(bArr);
                        }
                    }
                }
                an.a("[param] Set App channel: %s", aVar.q);
            } catch (Exception e) {
                if (c) {
                    e.printStackTrace();
                }
            }
            appVersion = buglyStrategy.getAppPackageName();
            if (!TextUtils.isEmpty(appVersion)) {
                if (appVersion.length() > 100) {
                    an.d("appPackageName %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), appVersion.substring(0, 100));
                    appVersion = r1;
                }
                aVar.d = appVersion;
                an.a("[param] Set App package: %s", buglyStrategy.getAppPackageName());
            }
            appVersion = buglyStrategy.getDeviceID();
            if (appVersion != null) {
                if (appVersion.length() > 100) {
                    an.d("deviceId %s length is over limit %d substring to %s", appVersion, Integer.valueOf(100), appVersion.substring(0, 100));
                    appVersion = r1;
                }
                aVar.c(appVersion);
                an.a("s[param] Set device ID: %s", appVersion);
            }
            aVar.g = buglyStrategy.isUploadProcess();
            ao.a = buglyStrategy.isBuglyLogUpload();
        }
    }

    public static synchronized void a(a aVar) {
        synchronized (b.class) {
            if (!b.contains(aVar)) {
                b.add(aVar);
            }
        }
    }
}
