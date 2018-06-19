package com.umeng.message.common;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.proguard.k;

/* compiled from: Res */
public class c {
    private static final String a = "com.umeng.message.common.c";
    private static c b;
    private static Class e;
    private static Class f;
    private static Class g;
    private static Class h;
    private static Class i;
    private static Class j;
    private static Class k;
    private static Class l;
    private Context c;
    private String d;

    private c(Context context) {
        this.c = context.getApplicationContext();
        context = a;
        StringBuilder stringBuilder = new StringBuilder("packageName=");
        stringBuilder.append(this.c.getPackageName());
        UmLog.d(context, stringBuilder.toString());
        try {
            context = new StringBuilder();
            context.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context.append(".R$drawable");
            f = Class.forName(context.toString());
        } catch (Context context2) {
            UmLog.e(a, context2.getMessage());
        }
        try {
            context2 = new StringBuilder();
            context2.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context2.append(".R$layout");
            g = Class.forName(context2.toString());
        } catch (Context context22) {
            UmLog.e(a, context22.getMessage());
        }
        try {
            context22 = new StringBuilder();
            context22.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context22.append(".R$id");
            e = Class.forName(context22.toString());
        } catch (Context context222) {
            UmLog.e(a, context222.getMessage());
        }
        try {
            context222 = new StringBuilder();
            context222.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context222.append(".R$anim");
            h = Class.forName(context222.toString());
        } catch (Context context2222) {
            UmLog.e(a, context2222.getMessage());
        }
        try {
            context2222 = new StringBuilder();
            context2222.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context2222.append(".R$style");
            i = Class.forName(context2222.toString());
        } catch (Context context22222) {
            UmLog.e(a, context22222.getMessage());
        }
        try {
            context22222 = new StringBuilder();
            context22222.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context22222.append(".R$string");
            j = Class.forName(context22222.toString());
        } catch (Context context222222) {
            UmLog.e(a, context222222.getMessage());
        }
        try {
            context222222 = new StringBuilder();
            context222222.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context222222.append(".R$array");
            k = Class.forName(context222222.toString());
        } catch (Context context2222222) {
            UmLog.e(a, context2222222.getMessage());
        }
        try {
            context2222222 = new StringBuilder();
            context2222222.append(!TextUtils.isEmpty(PushAgent.getInstance(this.c).getResourcePackageName()) ? PushAgent.getInstance(this.c).getResourcePackageName() : this.c.getPackageName());
            context2222222.append(".R$raw");
            l = Class.forName(context2222222.toString());
        } catch (Context context22222222) {
            UmLog.e(a, context22222222.getMessage());
        }
    }

    public static c a(Context context) {
        if (b == null) {
            b = new c(context);
        }
        return b;
    }

    public int a(String str) {
        return a(h, str);
    }

    public int b(String str) {
        return a(e, str);
    }

    public int c(String str) throws Exception {
        return b(e, str);
    }

    public int d(String str) {
        return a(f, str);
    }

    public int e(String str) {
        return a(g, str);
    }

    public int f(String str) throws Exception {
        return b(g, str);
    }

    public int g(String str) {
        return a(i, str);
    }

    public int h(String str) {
        return a(j, str);
    }

    public int i(String str) {
        return a(k, str);
    }

    public int j(String str) {
        return a(l, str);
    }

    private int a(Class<?> cls, String str) {
        if (cls == null) {
            cls = a;
            StringBuilder stringBuilder = new StringBuilder("getRes(null,");
            stringBuilder.append(str);
            stringBuilder.append(k.t);
            UmLog.e(cls, stringBuilder.toString());
            stringBuilder = new StringBuilder("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have ");
            stringBuilder.append(this.c.getPackageName());
            stringBuilder.append(".R$* configured in obfuscation. field=");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        try {
            return cls.getField(str).getInt(str);
        } catch (Exception e) {
            String str2 = a;
            StringBuilder stringBuilder2 = new StringBuilder("getRes(");
            stringBuilder2.append(cls.getName());
            stringBuilder2.append(", ");
            stringBuilder2.append(str);
            stringBuilder2.append(k.t);
            UmLog.e(str2, stringBuilder2.toString());
            UmLog.e(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
            UmLog.e(a, e.getMessage());
            return -1;
        }
    }

    private int b(Class<?> cls, String str) throws Exception {
        if (cls == null) {
            cls = a;
            StringBuilder stringBuilder = new StringBuilder("getRes(null,");
            stringBuilder.append(str);
            stringBuilder.append(k.t);
            UmLog.e(cls, stringBuilder.toString());
            stringBuilder = new StringBuilder("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have ");
            stringBuilder.append(this.c.getPackageName());
            stringBuilder.append(".R$* configured in obfuscation. field=");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i = cls.getField(str).getInt(str);
        String str2 = a;
        StringBuilder stringBuilder2 = new StringBuilder("getRes(");
        stringBuilder2.append(cls.getName());
        stringBuilder2.append(", ");
        stringBuilder2.append(str);
        stringBuilder2.append(k.t);
        UmLog.e(str2, stringBuilder2.toString());
        UmLog.e(a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        return i;
    }

    public void k(String str) {
        this.d = str;
    }

    public String a() {
        if (TextUtils.isEmpty(this.d)) {
            return this.c.getPackageName();
        }
        return this.d;
    }
}
