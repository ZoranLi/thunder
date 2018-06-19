package com.ali.auth.third.core.j;

import android.content.Context;
import com.ali.auth.third.core.c.a;

public final class e {
    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }

    public static String a(String str) {
        Context context = a.c;
        return context.getResources().getString(a(context, "string", str));
    }
}
