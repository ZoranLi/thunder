package com.xunlei.downloadprovider.pushmessage.a;

import android.content.Context;
import com.xunlei.common.androidutil.PreferenceHelper;

/* compiled from: PushUtil */
public final class a {
    public static void a(Context context, boolean z) {
        new PreferenceHelper(context, "pushmessageservice").setBoolean("isAwaysRun", z);
    }

    public static boolean a(Context context) {
        return new PreferenceHelper(context, "pushmessageservice", 4).getBoolean("isAwaysRun", true);
    }
}
