package com.alibaba.mtl.appmonitor;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.log.e.b;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: BackgroundTrigger */
final class w implements Runnable {
    private static boolean a = false;
    private static boolean d = false;
    private Application b;
    private boolean c = true;

    @TargetApi(14)
    /* compiled from: BackgroundTrigger */
    class a implements ActivityLifecycleCallbacks {
        final /* synthetic */ w a;
        private Runnable b;

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        a(w wVar, Runnable runnable) {
            this.a = wVar;
            this.b = runnable;
        }

        public final void onActivityStarted(Activity activity) {
            r.a().a(4);
            r.a().a(4, this.b, 60000);
        }

        public final void onActivityStopped(Activity activity) {
            r.a().a(4);
            r.a().a(4, this.b, 60000);
        }
    }

    @TargetApi(14)
    public static void a(Application application) {
        if (!a) {
            Object[] objArr = new Object[1];
            boolean z = false;
            objArr[0] = "init BackgroundTrigger";
            i.a("BackgroundTrigger", objArr);
            Object b = b.b(application.getApplicationContext());
            i.a("BackgroundTrigger", "[checkRuningProcess]:", b);
            if (!(TextUtils.isEmpty(b) || b.indexOf(Constants.COLON_SEPARATOR) == -1)) {
                z = true;
            }
            d = z;
            Runnable wVar = new w(application);
            if (d) {
                r.a().a(4, wVar, 60000);
            } else if (VERSION.SDK_INT >= 14) {
                wVar.getClass();
                application.registerActivityLifecycleCallbacks(new a(wVar, wVar));
            }
            a = true;
        }
    }

    private w(Application application) {
        this.b = application;
    }

    public final void run() {
        Object[] objArr = new Object[1];
        int i = 0;
        objArr[0] = "[bg check]";
        i.a("BackgroundTrigger", objArr);
        boolean a = b.a(this.b.getApplicationContext());
        if (this.c != a) {
            this.c = a;
            f[] a2;
            int length;
            f fVar;
            if (a) {
                j.a().b();
                a2 = f.a();
                length = a2.length;
                while (i < length) {
                    fVar = a2[i];
                    q.a(fVar, fVar.c());
                    i++;
                }
                com.alibaba.mtl.log.a.b();
            } else {
                a2 = f.a();
                length = a2.length;
                while (i < length) {
                    fVar = a2[i];
                    q.a(fVar, fVar.d());
                    i++;
                }
                q.b();
                com.alibaba.mtl.log.a.a();
            }
        }
        if (d) {
            r.a().a(4, this, 60000);
        }
    }
}
