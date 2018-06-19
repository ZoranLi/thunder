package com.qihoo360.replugin;

import android.app.Application;
import android.content.Context;
import com.qihoo360.mobilesafe.a.a;

/* compiled from: RePluginInternal */
public final class g {
    public static final boolean a = a.a;
    static Context b;

    static void a(Application application) {
        b = application;
    }

    public static Context a() {
        return b;
    }

    public static ClassLoader b() {
        return b.getClassLoader();
    }
}
