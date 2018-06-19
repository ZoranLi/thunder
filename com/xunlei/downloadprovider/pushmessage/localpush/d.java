package com.xunlei.downloadprovider.pushmessage.localpush;

import android.content.Context;

/* compiled from: LocalPushPreferences */
final class d {
    public static void a(Context context, String str, int i) {
        context.getSharedPreferences("shared_for_local_push", 0).edit().putInt(str, i).apply();
    }

    public static int a(Context context, String str) {
        return context.getSharedPreferences("shared_for_local_push", 0).getInt(str, 0);
    }
}
