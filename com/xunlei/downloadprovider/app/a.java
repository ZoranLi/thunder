package com.xunlei.downloadprovider.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: AppStatusChgObserver */
final class a implements ActivityLifecycleCallbacks {
    final /* synthetic */ AppStatusChgObserver a;

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    a(AppStatusChgObserver appStatusChgObserver) {
        this.a = appStatusChgObserver;
    }

    public final void onActivityResumed(Activity activity) {
        this.a.a = true;
        this.a.a(activity, 0);
        this.a.h = new WeakReference(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.a.a = false;
    }

    public final void onActivityStopped(Activity activity) {
        this.a.a(activity, 1);
    }
}
