package com.qihoo360.replugin;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import com.qihoo360.replugin.RePlugin.a;

public class RePluginApplication extends Application {
    protected d createCallbacks() {
        return null;
    }

    protected f createConfig() {
        return new f();
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        context = createConfig();
        if (context == null) {
            context = new f();
        }
        d createCallbacks = createCallbacks();
        if (createCallbacks != null) {
            context.a(createCallbacks);
        }
        a.a(this, context);
    }

    public void onCreate() {
        super.onCreate();
        a.a();
    }

    public void onLowMemory() {
        super.onLowMemory();
        a.b();
    }

    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        if (VERSION.SDK_INT < 14) {
            com.qihoo360.replugin.component.a.a.a(i);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (VERSION.SDK_INT < 14) {
            com.qihoo360.replugin.component.a.a.a(configuration);
        }
    }
}
