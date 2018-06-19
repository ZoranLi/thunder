package com.tencent.tinker.loader.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;

/* compiled from: BUGLY */
public class DefaultApplicationLike extends ApplicationLike {
    private static final String TAG = "Tinker.DefaultAppLike";

    public void onBaseContextAttached(Context context) {
    }

    public void onCreate() {
    }

    public void onLowMemory() {
    }

    public void onTerminate() {
    }

    public void onTrimMemory(int i) {
    }

    public DefaultApplicationLike(Application application, int i, boolean z, long j, long j2, Intent intent) {
        super(application, i, z, j, j2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        new StringBuilder("onConfigurationChanged:").append(configuration.toString());
    }
}
