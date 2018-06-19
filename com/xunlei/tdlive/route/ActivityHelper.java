package com.xunlei.tdlive.route;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.List;

public class ActivityHelper implements ActivityLifecycleCallbacks {
    private a a;

    private class a implements ActivityLifecycleCallbacks, Callback {
        final /* synthetic */ ActivityHelper a;
        private Application b;
        private WeakReference<Activity> c;
        private boolean d;
        private Handler e;
        private IBinder f;

        private a(ActivityHelper activityHelper) {
            this.a = activityHelper;
        }

        public boolean handleMessage(Message message) {
            a();
            if (!(message.what != 108 || this.f == null || this.c == null)) {
                Activity activity = (Activity) this.c.get();
                IBinder iBinder = (IBinder) ActivityHelper.b(message.obj, "token", null);
                List list = (List) ActivityHelper.b(message.obj, "results", null);
                if (!(iBinder == this.f || list == null || activity == null)) {
                    for (Object next : list) {
                        this.a.onActivityResult(activity, ((Integer) ActivityHelper.b(next, "mRequestCode", Integer.valueOf(0))).intValue(), ((Integer) ActivityHelper.b(next, "mResultCode", Integer.valueOf(0))).intValue(), (Intent) ActivityHelper.b(Integer.valueOf(0), "mData", null));
                    }
                }
            }
            return false;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            a();
            if (a(activity)) {
                this.a.onActivityCreated(activity, bundle);
            }
        }

        public void onActivityStarted(Activity activity) {
            a();
            if (a(activity)) {
                this.a.onActivityStarted(activity);
            }
        }

        public void onActivityResumed(Activity activity) {
            a();
            if (a(activity)) {
                if (this.d && this.e == null && ((Boolean) ActivityHelper.c(Activity.class, activity, "mStartedActivity", Boolean.valueOf(false))).booleanValue()) {
                    this.a.onActivityResult(activity, 0, ((Integer) ActivityHelper.c(Activity.class, activity, "mResultCode", Integer.valueOf(0))).intValue(), (Intent) ActivityHelper.c(Activity.class, activity, "mResultData", null));
                }
                this.d = false;
                this.a.onActivityResumed(activity);
            }
        }

        public void onActivityPaused(Activity activity) {
            a();
            if (a(activity)) {
                this.d = true;
                this.a.onActivityPaused(activity);
            }
        }

        public void onActivityStopped(Activity activity) {
            a();
            if (a(activity)) {
                this.a.onActivityStopped(activity);
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            a();
            if (a(activity)) {
                this.a.onActivitySaveInstanceState(activity, bundle);
            }
        }

        public void onActivityDestroyed(Activity activity) {
            a();
            if (a(activity)) {
                this.a.onActivityDestroyed(activity);
            }
        }

        private boolean a(Activity activity) {
            return (this.c == null || this.c.get() != activity) ? null : true;
        }

        private void a() {
            if (this.c == null || this.c.get() == null) {
                if (this.b != null) {
                    this.b.unregisterActivityLifecycleCallbacks(this);
                }
                this.b = null;
                b();
            }
        }

        private void b(Activity activity) {
            this.f = (IBinder) ActivityHelper.c(Activity.class, activity, "mToken", null);
            if (this.f != null) {
                activity = ActivityHelper.b(ActivityHelper.c(Activity.class, activity, "mMainThread", null), "mH", null);
                if (activity instanceof Handler) {
                    ActivityHelper.d(Handler.class, activity, "mCallback", this);
                    if (this == ActivityHelper.c(Handler.class, activity, "mCallback", null)) {
                        this.e = (Handler) activity;
                        return;
                    }
                    this.f = null;
                }
            }
        }

        private void b() {
            if (this.e != null) {
                ActivityHelper.d(Handler.class, this.e, "mCallback", null);
            }
            this.e = null;
            this.f = null;
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static boolean bind(Activity activity, ActivityHelper activityHelper) {
        if (activity == null || activityHelper == null) {
            return null;
        }
        activityHelper.a(activity);
        return true;
    }

    public static void transform(Context context, ActivityHelper activityHelper) {
        transform(context, activityHelper, 268435456);
    }

    public static void transform(Context context, ActivityHelper activityHelper, int i) {
        TransformActivity.start(context, activityHelper, i);
    }

    public void detach() {
        if (this.a != null) {
            this.a.b.unregisterActivityLifecycleCallbacks(this);
            this.a.b = null;
            this.a.c = null;
            this.a.b();
        }
        this.a = null;
    }

    private void a(Activity activity) {
        this.a = new a();
        this.a.c = new WeakReference(activity);
        this.a.b = activity.getApplication();
        this.a.b.registerActivityLifecycleCallbacks(this.a);
        this.a.b(activity);
    }

    private static <T> T b(Object obj, String str, T t) {
        return obj != null ? c(obj.getClass(), obj, str, t) : t;
    }

    private static <T> T c(Class<?> cls, Object obj, String str, T t) {
        try {
            cls = cls.getDeclaredField(str);
            cls.setAccessible(true);
            return cls.get(obj);
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
            return t;
        }
    }

    private static void d(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            cls = cls.getDeclaredField(str);
            cls.setAccessible(true);
            cls.set(obj, obj2);
        } catch (Class<?> cls2) {
            cls2.printStackTrace();
        }
    }
}
