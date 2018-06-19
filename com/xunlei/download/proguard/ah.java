package com.xunlei.download.proguard;

import android.content.Context;

/* compiled from: ResourceHelper */
public class ah {
    private static ah a;
    private static String b;
    private static Class<?> c;
    private static Class<?> d;
    private static Class<?> e;
    private static Class<?> f;
    private static Class<?> g;
    private static Class<?> h;

    public static ah a(Context context) {
        if (a == null) {
            b = b == null ? context.getPackageName() : b;
            a = new ah(b);
        }
        return a;
    }

    private ah(String str) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$layout");
            c = Class.forName(stringBuilder.toString());
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$drawable");
            d = Class.forName(stringBuilder.toString());
        } catch (Throwable e2) {
            e2.printStackTrace();
            an.a(e2);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$id");
            e = Class.forName(stringBuilder.toString());
        } catch (Throwable e22) {
            e22.printStackTrace();
            an.a(e22);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$string");
            f = Class.forName(stringBuilder.toString());
        } catch (Throwable e222) {
            e222.printStackTrace();
            an.a(e222);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$attr");
            g = Class.forName(stringBuilder.toString());
        } catch (Throwable e2222) {
            e2222.printStackTrace();
            an.a(e2222);
        }
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(".R$plurals");
            h = Class.forName(stringBuilder.toString());
        } catch (Throwable e3) {
            e3.printStackTrace();
            an.a(e3);
        }
    }

    private int a(Class<?> cls, String str) {
        if (cls == null) {
            StringBuilder stringBuilder = new StringBuilder("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have ");
            stringBuilder.append(b);
            stringBuilder.append(".R$* configured in obfuscation. field=");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            return cls.getField(str).getInt(str);
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
            an.d("ResourceHelper", "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project.");
            return -1;
        }
    }

    public int a(String str) {
        return a(d, str);
    }

    public int b(String str) {
        return a(c, str);
    }

    public int c(String str) {
        return a(e, str);
    }

    public int d(String str) {
        return a(f, str);
    }

    public int e(String str) {
        return a(g, str);
    }

    public int f(String str) {
        return a(h, str);
    }
}
