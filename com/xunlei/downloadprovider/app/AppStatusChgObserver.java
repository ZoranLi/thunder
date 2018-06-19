package com.xunlei.downloadprovider.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.launch.e.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.XLLoginOfflineDlgActivity;
import com.xunlei.xllib.android.b;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class AppStatusChgObserver {
    private static AppStatusChgObserver d;
    public boolean a = false;
    final ActivityLifecycleCallbacks b = new a(this);
    private final String c = AppStatusChgObserver.class.getSimpleName();
    private STATUS e = STATUS.STATUS_INIT;
    private int f;
    private Set<WeakReference> g = new HashSet();
    private WeakReference<Activity> h;

    public enum STATUS {
        STATUS_INIT,
        STATUS_BACKGROUND,
        STATUS_FOREGROUND
    }

    public interface a {
        void a(STATUS status);
    }

    private AppStatusChgObserver() {
    }

    public final boolean a() {
        new StringBuilder("get bg: ").append(this.e == STATUS.STATUS_BACKGROUND);
        return this.e == STATUS.STATUS_BACKGROUND;
    }

    public final void a(a aVar) {
        this.g.add(new WeakReference(aVar));
    }

    final void a(@NonNull Activity activity, int i) {
        synchronized (getClass()) {
            switch (i) {
                case 0:
                    new StringBuilder("notifyActivityChg. STATUS_RESUME. mBackgroundStatus: ").append(this.e);
                    if (this.e == STATUS.STATUS_INIT) {
                        this.e = STATUS.STATUS_FOREGROUND;
                        c.a();
                    } else if (this.e != STATUS.STATUS_FOREGROUND) {
                        if (activity.hashCode() != this.f) {
                            if (this.f != 0) {
                                if (this.e == STATUS.STATUS_BACKGROUND) {
                                    a(STATUS.STATUS_FOREGROUND, activity);
                                    this.e = STATUS.STATUS_FOREGROUND;
                                    i = new StringBuilder("fg-----------");
                                    i.append(activity.hashCode());
                                    i.append(" ");
                                    i.append(activity.getClass().getSimpleName());
                                }
                            }
                        }
                        a(STATUS.STATUS_FOREGROUND, activity);
                        this.e = STATUS.STATUS_FOREGROUND;
                        i = new StringBuilder("fg-----------");
                        i.append(activity.hashCode());
                        i.append(" ");
                        i.append(activity.getClass().getSimpleName());
                    }
                    this.f = activity.hashCode();
                    break;
                case 1:
                    new StringBuilder("notifyActivityChg. STATUS_STOP. mBackgroundStatus: ").append(this.e);
                    if (activity.hashCode() == this.f) {
                        a(STATUS.STATUS_BACKGROUND, activity);
                        this.e = STATUS.STATUS_BACKGROUND;
                        i = new StringBuilder("bg-----------");
                        i.append(activity.hashCode());
                        i.append(" ");
                        i.append(activity.getClass().getSimpleName());
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void a(STATUS status, Activity activity) {
        for (WeakReference weakReference : this.g) {
            a aVar = (a) weakReference.get();
            if (aVar != null) {
                aVar.a(status);
            }
        }
        if (status == STATUS.STATUS_BACKGROUND) {
            com.xunlei.downloadprovider.ad.revive.a.a.b(activity);
            return;
        }
        com.xunlei.downloadprovider.ad.revive.a.a.a(activity);
        com.xunlei.downloadprovider.d.c.a();
        com.xunlei.downloadprovider.d.c.e();
        c.a();
        if (XLLoginOfflineDlgActivity.a != -1) {
            status = LoginHelper.a();
            status.j.a(XLLoginOfflineDlgActivity.a, 1);
            XLLoginOfflineDlgActivity.a = -1;
        }
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            LoginHelper.a();
            if (l.c() != null) {
                LoginHelper.a();
                if (l.b() == null) {
                    LoginHelper.a().a(false);
                }
            }
        }
        com.xunlei.downloadprovider.h.a.a = false;
    }

    public static synchronized AppStatusChgObserver b() {
        AppStatusChgObserver appStatusChgObserver;
        synchronized (AppStatusChgObserver.class) {
            if (d == null) {
                d = new AppStatusChgObserver();
            }
            appStatusChgObserver = d;
        }
        return appStatusChgObserver;
    }

    public final Activity c() {
        return this.h != null ? (Activity) this.h.get() : null;
    }
}
