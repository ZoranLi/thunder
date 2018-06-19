package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.util.HashSet;
import java.util.Set;

/* compiled from: PushConfig */
public final class d {
    private static Set<String> a;

    @NonNull
    public static Set<String> b() {
        if (a == null) {
            Context applicationInstance = BrothersApplication.getApplicationInstance();
            Set hashSet = new HashSet();
            a = applicationInstance.getSharedPreferences("init", 0).getStringSet("push_should_report_display_types", hashSet);
        }
        return a;
    }

    public static void a() {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        Set a = com.xunlei.downloadprovider.d.d.a().s.a();
        applicationInstance.getSharedPreferences("init", 0).edit().putStringSet("push_should_report_display_types", a).apply();
    }
}
