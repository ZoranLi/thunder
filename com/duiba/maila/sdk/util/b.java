package com.duiba.maila.sdk.util;

import android.content.Context;

public final class b {
    public static String a(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void a(Context context, String str, String str2, String str3) {
        context = context.getSharedPreferences(str, 0).edit();
        context.putString(str2, str3);
        context.commit();
    }
}
