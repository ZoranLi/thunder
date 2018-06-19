package com.xunlei.downloadprovider.h;

import android.content.Context;

/* compiled from: GlobalSharedPreference */
public final class f {
    public static void a(Context context, String str, int i) {
        context.getSharedPreferences("init", 0).edit().putInt(str, i).apply();
    }

    public static int b(Context context, String str, int i) {
        return context.getSharedPreferences("init", 0).getInt(str, i);
    }

    public static void a(Context context, String str, long j) {
        context.getSharedPreferences("init", 0).edit().putLong(str, j).apply();
    }

    public static long b(Context context, String str, long j) {
        return context.getSharedPreferences("init", 0).getLong(str, j);
    }

    public static void a(Context context, String str, String str2) {
        context.getSharedPreferences("init", 0).edit().putString(str, str2).apply();
    }

    public static String a(Context context, String str) {
        context = context.getSharedPreferences("init", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(str, ""));
        return stringBuilder.toString();
    }

    public static void a(Context context, String str, boolean z) {
        context.getSharedPreferences("init", 0).edit().putBoolean(str, z).apply();
    }

    public static boolean b(Context context, String str) {
        return context.getSharedPreferences("init", 0).getBoolean(str, false);
    }

    public static boolean b(Context context, String str, boolean z) {
        return context.getSharedPreferences("init", 0).getBoolean(str, z);
    }
}
