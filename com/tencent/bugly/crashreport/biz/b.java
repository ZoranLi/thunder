package com.tencent.bugly.crashreport.biz;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import java.util.List;

/* compiled from: BUGLY */
public class b {
    public static boolean a = false;
    public static a b = null;
    private static int c = 10;
    private static long d = 300000;
    private static long e = 30000;
    private static long f = 0;
    private static int g = 0;
    private static long h = 0;
    private static long i = 0;
    private static long j = 0;
    private static ActivityLifecycleCallbacks k = null;
    private static Class<?> l = null;
    private static boolean m = true;

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ BuglyStrategy b;

        AnonymousClass1(Context context, BuglyStrategy buglyStrategy) {
            this.a = context;
            this.b = buglyStrategy;
        }

        public final void run() {
            b.c(this.a, this.b);
        }
    }

    static /* synthetic */ int g() {
        int i = g;
        g = i + 1;
        return i;
    }

    private static void m() {
        a b = a.b();
        if (b != null) {
            String str = null;
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i = 0;
            int length = stackTrace.length;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                if (stackTraceElement.getMethodName().equals("onCreate")) {
                    str = stackTraceElement.getClassName();
                }
                if (stackTraceElement.getClassName().equals("android.app.Activity")) {
                    i2 = true;
                }
                i++;
            }
            if (str == null) {
                str = "unknown";
            } else if (i2 != 0) {
                b.a(true);
            } else {
                str = "background";
            }
            b.u = str;
        }
    }

    private static boolean b(Context context) {
        context = a.a(context);
        List a = b.a(context.e);
        if (a == null) {
            return true;
        }
        for (int i = 0; i < a.size(); i++) {
            UserInfoBean userInfoBean = (UserInfoBean) a.get(i);
            if (userInfoBean.n.equals(context.o) && userInfoBean.b == 1) {
                long b = ap.b();
                if (b <= 0) {
                    return true;
                }
                if (userInfoBean.e >= b) {
                    if (userInfoBean.f <= 0) {
                        b.b();
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static void c(Context context, BuglyStrategy buglyStrategy) {
        boolean recordUserInfoOnceADay;
        if (buglyStrategy != null) {
            recordUserInfoOnceADay = buglyStrategy.recordUserInfoOnceADay();
            buglyStrategy = buglyStrategy.isEnableUserInfo();
        } else {
            buglyStrategy = true;
            recordUserInfoOnceADay = false;
        }
        if (recordUserInfoOnceADay) {
            if (b(context) != null) {
                buglyStrategy = null;
            } else {
                return;
            }
        }
        m();
        if (buglyStrategy != null) {
            c(context);
        }
        if (m != null) {
            n();
            b.a();
            b.b(21600000);
        }
    }

    public static void a(Context context, BuglyStrategy buglyStrategy) {
        if (!a) {
            long appReportDelay;
            m = a.a(context).g;
            b = new a(context, m);
            a = true;
            if (buglyStrategy != null) {
                l = buglyStrategy.getUserInfoActivity();
                appReportDelay = buglyStrategy.getAppReportDelay();
            } else {
                appReportDelay = 0;
            }
            if (appReportDelay <= 0) {
                c(context, buglyStrategy);
            } else {
                am.a().a(new AnonymousClass1(context, buglyStrategy), appReportDelay);
            }
        }
    }

    public static void a(long j) {
        if (j < 0) {
            j = com.tencent.bugly.crashreport.common.strategy.a.a().c().q;
        }
        f = j;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        if (!(b == null || z)) {
            b.b();
        }
        if (strategyBean != null) {
            if (strategyBean.q > 0) {
                e = strategyBean.q;
            }
            if (strategyBean.w <= false) {
                c = strategyBean.w;
            }
            if (strategyBean.x > 0) {
                d = strategyBean.x;
            }
        }
    }

    private static void n() {
        i = System.currentTimeMillis();
        b.a(1, false, 0);
        an.a("[session] launch app, new start", new Object[0]);
    }

    public static void a() {
        if (b != null) {
            b.a(2, false, 0);
        }
    }

    private static String b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ap.a());
        stringBuilder.append("  ");
        stringBuilder.append(str);
        stringBuilder.append("  ");
        stringBuilder.append(str2);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    @TargetApi(14)
    private static void c(Context context) {
        if (VERSION.SDK_INT >= 14) {
            context = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (context != null) {
                try {
                    if (k == null) {
                        k = new ActivityLifecycleCallbacks() {
                            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                            }

                            public final void onActivityStarted(Activity activity) {
                            }

                            public final void onActivityStopped(Activity activity) {
                            }

                            public final void onActivityResumed(Activity activity) {
                                String str = "unknown";
                                if (activity != null) {
                                    str = activity.getClass().getName();
                                }
                                if (b.l == null || b.l.getName().equals(str) != null) {
                                    an.c(">>> %s onResumed <<<", str);
                                    activity = a.b();
                                    if (activity != null) {
                                        activity.H.add(b.b(str, "onResumed"));
                                        activity.a(true);
                                        activity.u = str;
                                        activity.v = System.currentTimeMillis();
                                        activity.y = activity.v - b.i;
                                        if (activity.v - b.h > (b.f > 0 ? b.f : b.e)) {
                                            activity.d();
                                            b.g();
                                            an.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(r8 / 1000), Long.valueOf(b.e / 1000));
                                            if (b.g % b.c == null) {
                                                b.b.a(4, b.m, 0);
                                                return;
                                            }
                                            b.b.a(4, false, 0);
                                            long currentTimeMillis = System.currentTimeMillis();
                                            if (currentTimeMillis - b.j > b.d) {
                                                b.j = currentTimeMillis;
                                                an.a("add a timer to upload hot start user info", new Object[0]);
                                                if (b.m != null) {
                                                    b.b.a(b.d);
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                            public final void onActivityPaused(Activity activity) {
                                String str = "unknown";
                                if (activity != null) {
                                    str = activity.getClass().getName();
                                }
                                if (b.l == null || b.l.getName().equals(str)) {
                                    an.c(">>> %s onPaused <<<", str);
                                    a b = a.b();
                                    if (b != null) {
                                        b.H.add(b.b(str, "onPaused"));
                                        b.a(false);
                                        b.w = System.currentTimeMillis();
                                        b.x = b.w - b.v;
                                        b.h = b.w;
                                        if (b.x < 0) {
                                            b.x = 0;
                                        }
                                        if (activity != null) {
                                            b.u = "background";
                                        } else {
                                            b.u = "unknown";
                                        }
                                    }
                                }
                            }

                            public final void onActivityDestroyed(Activity activity) {
                                String str = "unknown";
                                if (activity != null) {
                                    str = activity.getClass().getName();
                                }
                                if (b.l == null || b.l.getName().equals(str) != null) {
                                    an.c(">>> %s onDestroyed <<<", str);
                                    activity = a.b();
                                    if (activity != null) {
                                        activity.H.add(b.b(str, "onDestroyed"));
                                    }
                                }
                            }

                            public final void onActivityCreated(Activity activity, Bundle bundle) {
                                String str = "unknown";
                                if (activity != null) {
                                    str = activity.getClass().getName();
                                }
                                if (b.l == null || b.l.getName().equals(str) != null) {
                                    an.c(">>> %s onCreated <<<", str);
                                    activity = a.b();
                                    if (activity != null) {
                                        activity.H.add(b.b(str, "onCreated"));
                                    }
                                }
                            }
                        };
                    }
                    context.registerActivityLifecycleCallbacks(k);
                } catch (Context context2) {
                    if (!an.a(context2)) {
                        context2.printStackTrace();
                    }
                }
            }
        }
    }

    @TargetApi(14)
    private static void d(Context context) {
        if (VERSION.SDK_INT >= 14) {
            context = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (context != null) {
                try {
                    if (k != null) {
                        context.unregisterActivityLifecycleCallbacks(k);
                    }
                } catch (Context context2) {
                    if (!an.a(context2)) {
                        context2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void a(Context context) {
        if (a) {
            if (context != null) {
                d(context);
                a = null;
            }
        }
    }
}
