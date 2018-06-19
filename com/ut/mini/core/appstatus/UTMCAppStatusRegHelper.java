package com.ut.mini.core.appstatus;

import android.annotation.TargetApi;
import android.app.Application;

public class UTMCAppStatusRegHelper {
    @TargetApi(14)
    public static void registerAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            UTMCAppStatusMonitor.getInstance().registerAppStatusCallbacks(uTMCAppStatusCallbacks);
        }
    }

    @TargetApi(14)
    public static void unRegisterAppStatusCallbacks(UTMCAppStatusCallbacks uTMCAppStatusCallbacks) {
        if (uTMCAppStatusCallbacks != null) {
            UTMCAppStatusMonitor.getInstance().unregisterAppStatusCallbacks(uTMCAppStatusCallbacks);
        }
    }

    @TargetApi(14)
    public static void registeActivityLifecycleCallbacks(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(UTMCAppStatusMonitor.getInstance());
        }
    }

    @TargetApi(14)
    public static void unregisterActivityLifecycleCallbacks(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(UTMCAppStatusMonitor.getInstance());
        }
    }
}
