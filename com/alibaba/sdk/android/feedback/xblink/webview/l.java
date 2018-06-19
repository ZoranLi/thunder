package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class l {
    static Handler a;

    public static void a() {
        if (VERSION.SDK_INT == 15 && !"SAMSUNG".equalsIgnoreCase(Build.BRAND)) {
            if (g.a()) {
                StringBuilder stringBuilder = new StringBuilder("BRAND: ");
                stringBuilder.append(Build.BRAND);
                g.e("TweakWebCoreHandler", stringBuilder.toString());
            }
            b();
        }
    }

    private static void b() {
        if (a == null) {
            try {
                Field declaredField = Class.forName("android.webkit.WebViewCore").getDeclaredField("sWebCoreHandler");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(null);
                Method declaredMethod = Handler.class.getDeclaredMethod("getIMessenger", null);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(obj, null);
                a = new m((Handler) obj);
                if (invoke != null) {
                    Field declaredField2 = Handler.class.getDeclaredField("mMessenger");
                    declaredField2.setAccessible(true);
                    declaredField2.set(a, invoke);
                }
                declaredField.set(null, a);
                if (g.a()) {
                    StringBuilder stringBuilder = new StringBuilder("sWebCoreHandler: ");
                    stringBuilder.append(obj);
                    g.a("TweakWebCoreHandler", stringBuilder.toString());
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder2 = new StringBuilder("tweakWebCoreHandler exception: ");
                stringBuilder2.append(th);
                g.b("TweakWebCoreHandler", stringBuilder2.toString());
            }
            if (a == null) {
                a = new Handler();
            }
        }
    }
}
