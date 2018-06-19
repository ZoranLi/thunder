package com.umeng.message.provider;

import android.content.Context;
import android.net.Uri;
import com.umeng.message.common.UmengMessageDeviceConfig;

/* compiled from: MessageConstants */
public class a {
    public static String a;
    public static Uri b;
    public static Uri c;
    public static Uri d;
    public static Uri e;
    public static Uri f;
    public static Uri g;
    public static Uri h;
    public static Uri i;
    public static Uri j;
    public static Uri k;
    private static Context l;
    private static a m;
    private static String n;

    private a() {
    }

    public static a a(Context context) {
        l = context;
        if (m == null) {
            m = new a();
            n = UmengMessageDeviceConfig.getPackageName(context);
            context = new StringBuilder();
            context.append(n);
            context.append(".umeng.message");
            a = context.toString();
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.a);
            b = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.b);
            c = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.c);
            d = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.d);
            e = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.e);
            f = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.f);
            g = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.g);
            h = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.h);
            i = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.i);
            j = Uri.parse(context.toString());
            context = new StringBuilder("content://");
            context.append(a);
            context.append(a$a.j);
            k = Uri.parse(context.toString());
        }
        return m;
    }
}
