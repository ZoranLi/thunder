package com.tencent.bugly.crashreport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebView;
import com.alipay.sdk.util.h;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.CrashModule;
import com.tencent.bugly.b;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.BuglyBroadcastRecevier;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.crashreport.crash.h5.H5JavaScriptInterface;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.af;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
public class CrashReport {
    private static Context a;

    /* compiled from: BUGLY */
    public interface WebViewInterface {
        void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str);

        CharSequence getContentDescription();

        String getUrl();

        void loadUrl(String str);

        void setJavaScriptEnabled(boolean z);
    }

    /* compiled from: BUGLY */
    final class AnonymousClass1 implements WebViewInterface {
        final /* synthetic */ WebView a;

        AnonymousClass1(WebView webView) {
            this.a = webView;
        }

        public final String getUrl() {
            return this.a.getUrl();
        }

        public final void setJavaScriptEnabled(boolean z) {
            z = this.a.getSettings();
            if (!z.getJavaScriptEnabled()) {
                z.setJavaScriptEnabled(true);
            }
        }

        public final void loadUrl(String str) {
            this.a.loadUrl(str);
        }

        public final void addJavascriptInterface(H5JavaScriptInterface h5JavaScriptInterface, String str) {
            this.a.addJavascriptInterface(h5JavaScriptInterface, str);
        }

        public final CharSequence getContentDescription() {
            return this.a.getContentDescription();
        }
    }

    /* compiled from: BUGLY */
    public static class UserStrategy extends BuglyStrategy {
        CrashHandleCallback a;

        public UserStrategy(Context context) {
        }

        public synchronized CrashHandleCallback getCrashHandleCallback() {
            return this.a;
        }

        public synchronized void setCrashHandleCallback(CrashHandleCallback crashHandleCallback) {
            this.a = crashHandleCallback;
        }
    }

    public static void enableBugly(boolean z) {
        b.a = z;
    }

    public static void initCrashReport(Context context) {
        a = context;
        b.a(CrashModule.getInstance());
        b.a(context);
    }

    public static void initCrashReport(Context context, UserStrategy userStrategy) {
        a = context;
        b.a(CrashModule.getInstance());
        b.a(context, (BuglyStrategy) userStrategy);
    }

    public static void initCrashReport(Context context, String str, boolean z) {
        initCrashReport(context, str, z, null);
    }

    public static void initCrashReport(Context context, String str, boolean z, UserStrategy userStrategy) {
        if (context != null) {
            a = context;
            b.a(CrashModule.getInstance());
            b.a(context, str, z, userStrategy);
        }
    }

    public static String getBuglyVersion(Context context) {
        if (context != null) {
            return a.a(context).c();
        }
        an.d("Please call with context.", new Object[0]);
        return "unknown";
    }

    public static void testJavaCrash() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            a b = a.b();
            if (b != null) {
                b.b(24096);
            }
            throw new RuntimeException("This Crash create for Test! You can go to Bugly see more detail!");
        } else {
            str = an.b;
        }
    }

    public static void testNativeCrash() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            an.a("start to create a native crash for test!", new Object[0]);
            c.a().k();
        } else {
            str = an.b;
        }
    }

    public static void testANRCrash() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            an.a("start to create a anr crash for test!", new Object[0]);
            c.a().l();
        } else {
            str = an.b;
        }
    }

    public static void postCatchedException(Throwable th) {
        postCatchedException(th, Thread.currentThread());
    }

    public static void postCatchedException(Throwable th, Thread thread) {
        postCatchedException(th, thread, false);
    }

    public static void postCatchedException(Throwable th, Thread thread, boolean z) {
        if (!b.a) {
            th = an.b;
        } else if (!CrashModule.hasInitialized()) {
            th = an.b;
        } else if (th == null) {
            an.d("throwable is null, just return", new Object[null]);
        } else {
            if (thread == null) {
                thread = Thread.currentThread();
            }
            c.a().a(thread, th, false, null, null, z);
        }
    }

    public static void closeNativeReport() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            c.a().g();
        } else {
            str = an.b;
        }
    }

    public static void startCrashReport() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            c.a().c();
        } else {
            str = an.b;
        }
    }

    public static void closeCrashReport() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            c.a().d();
        } else {
            str = an.b;
        }
    }

    public static void closeBugly() {
        String str;
        if (!b.a) {
            str = an.b;
        } else if (!CrashModule.hasInitialized()) {
            str = an.b;
        } else if (a != null) {
            BuglyBroadcastRecevier instance = BuglyBroadcastRecevier.getInstance();
            if (instance != null) {
                instance.unregister(a);
            }
            closeCrashReport();
            com.tencent.bugly.crashreport.biz.b.a(a);
            am a = am.a();
            if (a != null) {
                a.b();
            }
        }
    }

    public static void setUserSceneTag(Context context, int i) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else {
            if (i <= 0) {
                an.d("setTag args tagId should > 0", new Object[0]);
            }
            a.a(context).a(i);
            an.b("[param] set user scene tag: %d", Integer.valueOf(i));
        }
    }

    public static int getUserSceneTagId(Context context) {
        if (!b.a) {
            context = an.b;
            return -1;
        } else if (context != null) {
            return a.a(context).H();
        } else {
            context = an.b;
            return -1;
        }
    }

    public static String getUserData(Context context, String str) {
        if (!b.a) {
            context = an.b;
            return "unknown";
        } else if (context == null) {
            context = an.b;
            return "unknown";
        } else if (ap.a(str)) {
            return null;
        } else {
            return a.a(context).g(str);
        }
    }

    public static void putUserData(Context context, String str, String str2) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else if (str == null) {
            new StringBuilder().append(str);
            an.d("putUserData args key should not be null or empty", new Object[0]);
        } else if (str2 == null) {
            new StringBuilder().append(str2);
            an.d("putUserData args value should not be null", new Object[0]);
        } else if (str.matches("[a-zA-Z[0-9]]+")) {
            if (str2.length() > 200) {
                an.d("user data value length over limit %d, it will be cutted!", Integer.valueOf(200));
                str2 = str2.substring(0, 200);
            }
            a a = a.a(context);
            NativeCrashHandler instance;
            if (a.E().contains(str)) {
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                a.a(context).b(str, str2);
                an.c("replace KV %s %s", str, str2);
            } else if (a.D() >= 10) {
                an.d("user data size is over limit %d, it will be cutted!", new Object[]{Integer.valueOf(10)});
            } else {
                if (str.length() > 50) {
                    an.d("user data key length over limit %d , will drop this new key %s", Integer.valueOf(50), str);
                    str = str.substring(0, 50);
                }
                instance = NativeCrashHandler.getInstance();
                if (instance != null) {
                    instance.putKeyValueToNative(str, str2);
                }
                a.a(context).b(str, str2);
                an.b("[param] set user data: %s - %s", str, str2);
            }
        } else {
            context = new StringBuilder("putUserData args key should match [a-zA-Z[0-9]]+  {");
            context.append(str);
            context.append(h.d);
            an.d(context.toString(), new Object[0]);
        }
    }

    public static String removeUserData(Context context, String str) {
        if (!b.a) {
            context = an.b;
            return "unknown";
        } else if (context == null) {
            context = an.b;
            return "unknown";
        } else if (ap.a(str)) {
            return null;
        } else {
            an.b("[param] remove user data: %s", str);
            return a.a(context).f(str);
        }
    }

    public static Set<String> getAllUserDataKeys(Context context) {
        if (!b.a) {
            context = an.b;
            return new HashSet();
        } else if (context != null) {
            return a.a(context).E();
        } else {
            context = an.b;
            return new HashSet();
        }
    }

    public static int getUserDatasSize(Context context) {
        if (!b.a) {
            context = an.b;
            return -1;
        } else if (context != null) {
            return a.a(context).D();
        } else {
            context = an.b;
            return -1;
        }
    }

    public static String getAppID() {
        String str;
        if (!b.a) {
            str = an.b;
            return "unknown";
        } else if (CrashModule.hasInitialized()) {
            return a.a(a).f();
        } else {
            str = an.b;
            return "unknown";
        }
    }

    public static void setUserId(String str) {
        if (!b.a) {
            str = an.b;
        } else if (CrashModule.hasInitialized()) {
            setUserId(a, str);
        } else {
            str = an.b;
        }
    }

    public static void setUserId(Context context, String str) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else if (str == null) {
            an.d("userId should not be null", new Object[0]);
        } else {
            if (str.length() > 100) {
                an.d("userId %s length is over limit %d substring to %s", str, Integer.valueOf(100), str.substring(0, 100));
                str = r1;
            }
            if (!str.equals(a.a(context).g())) {
                a.a(context).b(str);
                an.b("[user] set userId : %s", str);
                context = NativeCrashHandler.getInstance();
                if (context != null) {
                    context.setNativeUserId(str);
                }
                if (CrashModule.hasInitialized() != null) {
                    com.tencent.bugly.crashreport.biz.b.a();
                }
            }
        }
    }

    public static String getUserId() {
        String str;
        if (!b.a) {
            str = an.b;
            return "unknown";
        } else if (CrashModule.hasInitialized()) {
            return a.a(a).g();
        } else {
            str = an.b;
            return "unknown";
        }
    }

    public static String getAppVer() {
        String str;
        if (!b.a) {
            str = an.b;
            return "unknown";
        } else if (CrashModule.hasInitialized()) {
            return a.a(a).o;
        } else {
            str = an.b;
            return "unknown";
        }
    }

    public static String getAppChannel() {
        String str;
        if (!b.a) {
            str = an.b;
            return "unknown";
        } else if (CrashModule.hasInitialized()) {
            return a.a(a).q;
        } else {
            str = an.b;
            return "unknown";
        }
    }

    public static void setContext(Context context) {
        a = context;
    }

    public static boolean isLastSessionCrash() {
        String str;
        if (!b.a) {
            str = an.b;
            return false;
        } else if (CrashModule.hasInitialized()) {
            return c.a().b();
        } else {
            str = an.b;
            return false;
        }
    }

    public static void setSdkExtraData(Context context, String str, String str2) {
        if (b.a) {
            if (!(context == null || ap.a(str))) {
                if (!ap.a(str2)) {
                    a.a(context).a(str, str2);
                    return;
                }
            }
            return;
        }
        context = an.b;
    }

    public static Map<String, String> getSdkExtraData() {
        String str;
        if (!b.a) {
            str = an.b;
            return new HashMap();
        } else if (CrashModule.hasInitialized()) {
            return a.a(a).F;
        } else {
            str = an.b;
            return null;
        }
    }

    public static Map<String, String> getSdkExtraData(Context context) {
        if (!b.a) {
            context = an.b;
            return new HashMap();
        } else if (context != null) {
            return a.a(context).F;
        } else {
            an.d("Context should not be null.", new Object[0]);
            return null;
        }
    }

    private static void putSdkData(Context context, String str, String str2) {
        if (!(context == null || ap.a(str))) {
            if (!ap.a(str2)) {
                String str3;
                str = str.replace("[a-zA-Z[0-9]]+", "");
                if (str.length() > 100) {
                    str3 = an.b;
                    String.format("putSdkData key length over limit %d, will be cutted.", new Object[]{Integer.valueOf(50)});
                    str = str.substring(0, 50);
                }
                if (str2.length() > 500) {
                    str3 = an.b;
                    String.format("putSdkData value length over limit %d, will be cutted!", new Object[]{Integer.valueOf(200)});
                    str2 = str2.substring(0, 200);
                }
                a.a(context).c(str, str2);
                an.b(String.format("[param] putSdkData data: %s - %s", new Object[]{str, str2}), new Object[0]);
            }
        }
    }

    public static void setIsAppForeground(Context context, boolean z) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            an.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                an.c("App is in foreground.", new Object[0]);
            } else {
                an.c("App is in background.", new Object[0]);
            }
            a.a(context).a(z);
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            an.d("Context should not be null.", new Object[0]);
        } else {
            if (z) {
                an.c("This is a development device.", new Object[0]);
            } else {
                an.c("This is not a development device.", new Object[0]);
            }
            a.a(context).D = z;
        }
    }

    public static void setSessionIntervalMills(long j) {
        if (b.a) {
            com.tencent.bugly.crashreport.biz.b.a(j);
        } else {
            j = an.b;
        }
    }

    public static void setAppVersion(Context context, String str) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else if (str == null) {
            context = an.b;
        } else {
            a.a(context).o = str;
            context = NativeCrashHandler.getInstance();
            if (context != null) {
                context.setNativeAppVersion(str);
            }
        }
    }

    public static void setAppChannel(Context context, String str) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else if (str == null) {
            context = an.b;
        } else {
            a.a(context).q = str;
            context = NativeCrashHandler.getInstance();
            if (context != null) {
                context.setNativeAppChannel(str);
            }
        }
    }

    public static void setAppPackage(Context context, String str) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else if (str == null) {
            context = an.b;
        } else {
            a.a(context).d = str;
            context = NativeCrashHandler.getInstance();
            if (context != null) {
                context.setNativeAppPackage(str);
            }
        }
    }

    public static void setCrashFilter(String str) {
        if (b.a) {
            String str2 = an.b;
            c.m = str;
            return;
        }
        str = an.b;
    }

    public static void setCrashRegularFilter(String str) {
        if (b.a) {
            String str2 = an.b;
            c.n = str;
            return;
        }
        str = an.b;
    }

    public static void setBuglyDbName(String str) {
        if (b.a) {
            String str2 = an.b;
            af.a = str;
            return;
        }
        str = an.b;
    }

    public static void setAuditEnable(Context context, boolean z) {
        if (!b.a) {
            context = an.b;
        } else if (context == null) {
            context = an.b;
        } else {
            String str = an.b;
            a.a(context).G = z;
        }
    }

    public static boolean setJavascriptMonitor(WebView webView, boolean z) {
        return setJavascriptMonitor(webView, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebView webView, boolean z, boolean z2) {
        if (webView != null) {
            return setJavascriptMonitor(new AnonymousClass1(webView), z, z2);
        }
        webView = an.b;
        return null;
    }

    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z) {
        return setJavascriptMonitor(webViewInterface, z, false);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public static boolean setJavascriptMonitor(WebViewInterface webViewInterface, boolean z, boolean z2) {
        if (webViewInterface == null) {
            webViewInterface = an.b;
            return false;
        } else if (CrashModule.hasInitialized()) {
            an.a("Set Javascript exception monitor of webview.", new Object[0]);
            if (b.a) {
                an.c("URL of webview is %s", webViewInterface.getUrl());
                if (z2 || VERSION.SDK_INT >= true) {
                    an.a("Enable the javascript needed by webview monitor.", new Object[0]);
                    webViewInterface.setJavaScriptEnabled(true);
                    z2 = H5JavaScriptInterface.getInstance(webViewInterface);
                    if (z2) {
                        an.a("Add a secure javascript interface to the webview.", new Object[0]);
                        webViewInterface.addJavascriptInterface(z2, "exceptionUploader");
                    }
                    if (z) {
                        an.a("Inject bugly.js(v%s) to the webview.", com.tencent.bugly.crashreport.crash.h5.b.b());
                        z = com.tencent.bugly.crashreport.crash.h5.b.a();
                        if (z) {
                            z2 = new StringBuilder("javascript:");
                            z2.append(z);
                            webViewInterface.loadUrl(z2.toString());
                        } else {
                            an.e("Failed to inject Bugly.js.", new Object[]{com.tencent.bugly.crashreport.crash.h5.b.b()});
                            return false;
                        }
                    }
                    return true;
                }
                an.e("This interface is only available for Android 4.4 or later.", new Object[0]);
                return false;
            }
            webViewInterface = an.b;
            return false;
        } else {
            an.e("CrashReport has not been initialed! please to call method 'initCrashReport' first!", new Object[0]);
            return false;
        }
    }
}
