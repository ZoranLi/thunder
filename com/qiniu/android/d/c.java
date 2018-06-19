package com.qiniu.android.d;

import android.app.Application;
import android.content.Context;

/* compiled from: ContextGetter */
public final class c {
    public static Context a() {
        try {
            return ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null)).getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
