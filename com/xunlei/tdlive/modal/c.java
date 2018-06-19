package com.xunlei.tdlive.modal;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.av;
import com.xunlei.tdlive.util.l;
import org.android.agoo.message.MessageService;

/* compiled from: MetaData */
public class c {
    private static String a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;

    public static String a(Context context) {
        if (f == null) {
            f = l.a(context, "XL_LIVE_APP_CHANNEL", "ThunderSDK");
        }
        return f;
    }

    public static void a(Context context, String str, int i) {
        context.getApplicationContext().getSharedPreferences("xllive_sdk_meta_data", 0).edit().putString("LiveAppPluginVersionName", str).putString("LiveAppPluginVersionCode", String.valueOf(i)).apply();
        d = null;
        e = null;
        h = null;
        i = null;
    }

    public static String b(Context context) {
        if (h == null) {
            h = context.getApplicationContext().getSharedPreferences("xllive_sdk_meta_data", 0).getString("LiveAppPluginVersionName", "0");
        }
        return h;
    }

    public static String c(Context context) {
        if (i == null) {
            i = context.getApplicationContext().getSharedPreferences("xllive_sdk_meta_data", 0).getString("LiveAppPluginVersionCode", "0");
        }
        return i;
    }

    public static String d(Context context) {
        if (e == null) {
            e = l.a(context, "XL_LIVE_APP_VERSION_NAME", "5.54.2");
            context = b(context);
            if (TextUtils.isEmpty(context)) {
                context = new StringBuilder();
                context.append(e);
                context.append(".0");
                e = context.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(e);
                stringBuilder.append(".");
                stringBuilder.append(context);
                e = stringBuilder.toString();
            }
        }
        return e;
    }

    public static String e(Context context) {
        if (d == null) {
            d = l.a(context, "XL_LIVE_APP_VERSION_CODE", MessageService.MSG_DB_COMPLETE);
            context = c(context);
            if (!(TextUtils.isEmpty(context) || context.equals("0"))) {
                d = context;
            }
        }
        return d;
    }

    public static String f(Context context) {
        if (a == null) {
            a = l.a(context, "XL_LIVE_APP_ID", "1003");
        }
        return a;
    }

    public static String g(Context context) {
        if (b == null) {
            b = l.a(context, "XL_LIVE_APP_KEY", "39YIW&**6W#BLM=");
        }
        return b;
    }

    public static String h(Context context) {
        if (c == null) {
            c = l.a(context, "XL_LIVE_APP_URL", "http://biz.live.xunlei.com/caller?c=room&a=getchannellist&get_vcpk=1");
        }
        return c;
    }

    public static boolean i(Context context) {
        if (g == null) {
            g = l.a(context, "XL_LIVE_SUPPORT_BACK_FINISH_ENABLE", av.b);
        }
        return "true".equals(g);
    }
}
