package com.tencent.tinker.loader.app;

import android.content.Context;
import android.content.res.Configuration;

/* compiled from: BUGLY */
public interface ApplicationLifeCycle {
    void onBaseContextAttached(Context context);

    void onConfigurationChanged(Configuration configuration);

    void onCreate();

    void onLowMemory();

    void onTerminate();

    void onTrimMemory(int i);
}
