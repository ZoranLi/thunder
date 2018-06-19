package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.ae;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import java.util.Map;

/* compiled from: BUGLY */
public class Bugly {
    private static boolean a = false;
    public static Context applicationContext = null;
    public static boolean enable = true;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        synchronized (Bugly.class) {
            if (a) {
                return;
            }
            a = true;
            context = ap.a(context);
            applicationContext = context;
            if (context == null) {
                context = an.b;
                return;
            }
            b.a(CrashModule.getInstance());
            b.a(Beta.getInstance());
            b.a = enable;
            b.a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static synchronized String getAppChannel() {
        synchronized (Bugly.class) {
            a b = a.b();
            if (b == null) {
                return null;
            }
            String str;
            if (TextUtils.isEmpty(b.q)) {
                ae a = ae.a();
                if (a == null) {
                    str = b.q;
                    return str;
                }
                Map a2 = a.a(556, null, true);
                if (a2 != null) {
                    byte[] bArr = (byte[]) a2.get("app_channel");
                    if (bArr != null) {
                        str = new String(bArr);
                        return str;
                    }
                }
            }
            str = b.q;
            return str;
        }
    }

    public static void setIsDevelopmentDevice(Context context, boolean z) {
        CrashReport.setIsDevelopmentDevice(context, z);
    }

    public static void setAppChannel(Context context, String str) {
        CrashReport.setAppChannel(context, str);
    }

    public static void setUserId(Context context, String str) {
        CrashReport.setUserId(context, str);
    }

    public static void setUserTag(Context context, int i) {
        CrashReport.setUserSceneTag(context, i);
    }

    public static void putUserData(Context context, String str, String str2) {
        CrashReport.putUserData(context, str, str2);
    }
}
