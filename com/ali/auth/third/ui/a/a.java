package com.ali.auth.third.ui.a;

import android.app.Activity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class a {
    public static volatile WeakReference<Activity> a = null;
    private static final String b = "a";

    public static void a(Activity activity) {
        a = new WeakReference(activity);
    }

    public static boolean a(int i) {
        Activity activity = a != null ? (Activity) a.get() : null;
        Map hashMap = new HashMap();
        hashMap.put("requestCodeKey", String.valueOf(i));
        com.ali.auth.third.ui.b.a aVar = (com.ali.auth.third.ui.b.a) com.ali.auth.third.core.c.a.a(com.ali.auth.third.ui.b.a.class, hashMap);
        if (aVar == null) {
            i = com.ali.auth.third.core.config.a.a;
        } else if (activity != null) {
            return true;
        } else {
            new StringBuilder("No active activity is set, ignore invoke ").append(aVar);
            i = com.ali.auth.third.core.config.a.a;
        }
        return false;
    }
}
