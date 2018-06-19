package com.tencent.bugly.crashreport.inner;

import com.tencent.bugly.crashreport.crash.d;
import com.tencent.bugly.proguard.an;
import java.util.Map;

/* compiled from: BUGLY */
public class InnerApi {
    public static void postU3dCrashAsync(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            an.e("post u3d fail args null", new Object[0]);
        }
        an.a("post u3d crash %s %s", new Object[]{str, str2});
        d.a(Thread.currentThread(), 4, str, str2, str3, null);
    }

    public static void postCocos2dxCrashAsync(int i, String str, String str2, String str3) {
        if (!(str == null || str2 == null)) {
            if (str3 != null) {
                if (i == 5 || i == 6) {
                    an.a("post cocos2d-x crash %s %s", new Object[]{str, str2});
                    d.a(Thread.currentThread(), i, str, str2, str3, null);
                    return;
                }
                an.e("post cocos2d-x fail category illeagle: %d", new Object[]{Integer.valueOf(i)});
                return;
            }
        }
        an.e("post cocos2d-x fail args null", new Object[0]);
    }

    public static void postH5CrashAsync(Thread thread, String str, String str2, String str3, Map<String, String> map) {
        if (!(str == null || str2 == null)) {
            if (str3 != null) {
                an.a("post h5 crash %s %s", new Object[]{str, str2});
                d.a(thread, 8, str, str2, str3, map);
                return;
            }
        }
        an.e("post h5 fail args null", new Object[0]);
    }
}
