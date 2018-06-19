package com.xunlei.downloadprovider.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.multidex.MultiDex;
import com.tencent.tinker.loader.app.TinkerApplication;

public class ThunderTinkerApplication extends TinkerApplication {
    public ThunderTinkerApplication() {
        super(7, "com.xunlei.downloadprovider.app.BrothersApplication", "com.tencent.tinker.loader.TinkerLoader", false);
    }

    protected void attachBaseContext(Context context) {
        MultiDex.install(context);
        super.attachBaseContext(context);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (configuration.fontScale != 1.0f) {
            getResources();
        }
        super.onConfigurationChanged(configuration);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale != 1.0f) {
            configuration.fontScale = 1.0f;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return resources;
    }

    public void onCreate() {
        super.onCreate();
    }
}
