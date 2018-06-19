package anet.channel.util;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import anet.channel.GlobalAppRuntimeInfo;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
public class AppLifecycle {
    public static volatile long lastEnterBackgroundTime;
    private static CopyOnWriteArraySet<AppLifecycleListener> listeners = new CopyOnWriteArraySet();
    private static ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            AppLifecycle.onForeground();
        }
    };
    private static ComponentCallbacks2 mComponentCallbacks2 = new ComponentCallbacks2() {
        public static final String TAG = "awcn.ComponentCallbacks2";

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
        }

        public final void onTrimMemory(int i) {
            ALog.i(TAG, "onTrimMemory", null, "level", Integer.valueOf(i));
            if (i == 20) {
                AppLifecycle.onBackground();
            }
        }
    };

    /* compiled from: Taobao */
    public interface AppLifecycleListener {
        void background();

        void forground();
    }

    private AppLifecycle() {
    }

    public static void initialize() {
        if (VERSION.SDK_INT >= 14) {
            ((Application) GlobalAppRuntimeInfo.getContext().getApplicationContext()).registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
            GlobalAppRuntimeInfo.getContext().registerComponentCallbacks(mComponentCallbacks2);
        }
    }

    public static void registerLifecycleListener(AppLifecycleListener appLifecycleListener) {
        if (appLifecycleListener != null) {
            listeners.add(appLifecycleListener);
        }
    }

    public static void unregisterLifecycleListener(AppLifecycleListener appLifecycleListener) {
        listeners.remove(appLifecycleListener);
    }

    public static void onForeground() {
        if (GlobalAppRuntimeInfo.isBackground) {
            GlobalAppRuntimeInfo.isBackground = false;
            Iterator it = listeners.iterator();
            while (it.hasNext()) {
                ((AppLifecycleListener) it.next()).forground();
            }
        }
    }

    public static void onBackground() {
        if (!GlobalAppRuntimeInfo.isBackground) {
            GlobalAppRuntimeInfo.isBackground = true;
            lastEnterBackgroundTime = System.currentTimeMillis();
            Iterator it = listeners.iterator();
            while (it.hasNext()) {
                ((AppLifecycleListener) it.next()).background();
            }
        }
    }
}
