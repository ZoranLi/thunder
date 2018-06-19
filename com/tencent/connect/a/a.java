package com.tencent.connect.a;

import android.content.Context;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.utils.e;
import java.lang.reflect.Method;

/* compiled from: ProGuard */
public class a {
    private static Class<?> a = null;
    private static Class<?> b = null;
    private static Method c = null;
    private static Method d = null;
    private static Method e = null;
    private static Method f = null;
    private static boolean g = false;

    public static boolean a(Context context, QQToken qQToken) {
        return e.a(context, qQToken.getAppId()).b("Common_ta_enable");
    }

    public static void b(Context context, QQToken qQToken) {
        try {
            if (a(context, qQToken) != null) {
                f.invoke(a, new Object[]{Boolean.valueOf(true)});
                return;
            }
            f.invoke(a, new Object[]{Boolean.valueOf(false)});
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void c(Context context, QQToken qQToken) {
        String appId = qQToken.getAppId();
        StringBuilder stringBuilder = new StringBuilder("Aqc");
        stringBuilder.append(appId);
        appId = stringBuilder.toString();
        try {
            a = Class.forName("com.tencent.stat.StatConfig");
            Class cls = Class.forName("com.tencent.stat.StatService");
            b = cls;
            c = cls.getMethod("reportQQ", new Class[]{Context.class, String.class});
            d = b.getMethod("trackCustomEvent", new Class[]{Context.class, String.class, String[].class});
            e = b.getMethod("commitEvents", new Class[]{Context.class, Integer.TYPE});
            f = a.getMethod("setEnableStatService", new Class[]{Boolean.TYPE});
            b(context, qQToken);
            a.getMethod("setAutoExceptionCaught", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(false)});
            a.getMethod("setEnableSmartReporting", new Class[]{Boolean.TYPE}).invoke(a, new Object[]{Boolean.valueOf(true)});
            a.getMethod("setSendPeriodMinutes", new Class[]{Integer.TYPE}).invoke(a, new Object[]{Integer.valueOf(1440)});
            qQToken = Class.forName("com.tencent.stat.StatReportStrategy");
            a.getMethod("setStatSendStrategy", new Class[]{qQToken}).invoke(a, new Object[]{qQToken.getField("PERIOD").get(null)});
            b.getMethod("startStatService", new Class[]{Context.class, String.class, String.class}).invoke(b, new Object[]{context, appId, Class.forName("com.tencent.stat.common.StatConstants").getField("VERSION").get(null)});
            g = true;
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public static void d(Context context, QQToken qQToken) {
        if (g) {
            b(context, qQToken);
            if (qQToken.getOpenId() != null) {
                try {
                    c.invoke(b, new Object[]{context, qQToken.getOpenId()});
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        }
    }

    public static void a(Context context, QQToken qQToken, String str, String... strArr) {
        if (g) {
            b(context, qQToken);
            try {
                d.invoke(b, new Object[]{context, str, strArr});
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
    }
}
