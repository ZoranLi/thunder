package com.xunlei.downloadprovider.launch;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.launch.c.a;
import com.xunlei.downloadprovider.launch.dispatch.e;
import com.xunlei.downloadprovider.launch.dispatch.g;
import com.xunlei.downloadprovider.launch.dispatch.h;
import com.xunlei.downloadprovider.launch.dispatch.q;
import com.xunlei.downloadprovider.launch.dispatch.r;
import com.xunlei.downloadprovider.launch.dispatch.s;
import com.xunlei.downloadprovider.launch.dispatch.t;
import com.xunlei.downloadprovider.launch.e.b;
import com.xunlei.downloadprovider.launch.guide.k;
import com.xunlei.downloadprovider.loading.LoadingActivity;
import com.xunlei.downloadprovider.loading.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.xllib.android.XLIntent;

public class LaunchActivity extends Activity {
    public static boolean a = false;
    public static boolean c = false;
    public static boolean d = false;
    a b;
    private boolean e = false;
    private boolean f = false;
    private LoginHelper g = LoginHelper.a();
    private boolean h = false;

    protected void onCreate(Bundle bundle) {
        new StringBuilder("LaunchActivity onCreate init----------- extra =").append(getIntent().getExtras());
        super.onCreate(bundle);
        if (j.c(this) != null) {
            j.a(getWindow());
        }
        if (BrothersApplication.getSingletonInstance().hasLaunched == null || (c() != null && l.c() == null)) {
            getWindow().setFlags(1024, 1024);
            this.e = true;
            this.b = new a(this, new a(this));
            if (a(0) == null) {
                this.f = true;
            }
            BrothersApplication.sLaunchAnalysisReport.b = SystemClock.elapsedRealtime();
            new StringBuilder("traceLaunchActivityCreate:").append(b.a());
            return;
        }
        setTheme(R.style.LaunchTheme.LoadingActivity);
        RunningTaskInfo runningTaskInfo = (RunningTaskInfo) ((ActivityManager) BrothersApplication.getApplicationInstance().getSystemService("activity")).getRunningTasks(1).get(0);
        bundle = runningTaskInfo.baseActivity.equals(runningTaskInfo.topActivity);
        if (!f()) {
            if (bundle != null) {
                e();
                return;
            }
            finish();
        }
    }

    private int a(int i) {
        return this.b.a(0, i);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.b.a(i, strArr, iArr);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1000) {
            if (i2 == -1) {
                d();
            } else if (i2 == 1001) {
                this.h = true;
                finish();
            }
        }
    }

    private void b() {
        if (!c()) {
            d();
        } else if (l.c()) {
            d();
        } else {
            Intent xLIntent = new XLIntent((Context) this, LoginActivity.class);
            xLIntent.putExtra("login_from", LoginFrom.FORCE_LOGIN_LAUNCH.toString());
            startActivityForResult(xLIntent, 1000);
        }
    }

    private boolean c() {
        Context baseContext = getBaseContext();
        boolean b = f.b(baseContext, "key_is_new_user");
        long h = d.a().e.h();
        if (b) {
            if (h < 0) {
                f.a(baseContext, "key_is_new_user", false);
            } else {
                long currentTimeMillis = System.currentTimeMillis();
                long b2 = f.b(baseContext, "key_first_enter_thunder", 0);
                if ((currentTimeMillis - b2 > h) && b2 > 0) {
                    f.a(baseContext, "key_is_new_user", false);
                }
            }
            b = false;
        }
        return (c.b() || !d.a().e.a() || b) ? false : true;
    }

    private void d() {
        if (f()) {
            BrothersApplication.getSingletonInstance().hasLaunched = true;
        } else {
            e();
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.b != null) {
            if (this.f) {
                a();
                return;
            }
            if (a(1) == 0) {
                a();
            }
        }
    }

    public void startActivityForResult(Intent intent, int i, @Nullable Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
        o.a((Context) this);
    }

    private static void a(Intent intent) {
        String str = DispatchConstants.OTHER;
        if (intent != null) {
            if ("android.intent.action.MAIN".equals(intent.getAction()) != null) {
                str = "shoulei_icon";
            }
        }
        com.xunlei.downloadprovider.launch.e.c.a(str, (boolean) null);
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.h) {
            this.h = false;
            BrothersApplication.getSingletonInstance().killMyself();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        new StringBuilder("onNewIntent = ").append(intent.getExtras());
        a(intent);
        setIntent(intent);
        this.e = true;
        a();
    }

    private void a() {
        boolean z;
        if (com.xunlei.downloadprovider.h.l.d() || com.xunlei.downloadprovider.h.l.e()) {
            if (c.b() && !d) {
                if (com.xunlei.downloadprovider.pushmessage.b.b.a().b("push_notification_tips_time", -1) == -1) {
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("push_notification_tips_max_time", 2);
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("push_notification_tips_time", 0);
                } else {
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("push_notification_tips_max_time", 1);
                    com.xunlei.downloadprovider.pushmessage.b.b.a().a("push_notification_tips_time", 0);
                }
                d = true;
            }
            if (com.xunlei.downloadprovider.pushmessage.b.b.a().b("push_notification_tips_time", 0) >= com.xunlei.downloadprovider.pushmessage.b.b.a().b("push_notification_tips_max_time", 0)) {
                new StringBuilder("checkNotificationPermissionForSpecialDevice PUSH_NOTIFICATION_TIPS_TIME=").append(com.xunlei.downloadprovider.pushmessage.b.b.a().b("push_notification_tips_time", 0));
            } else if (!com.xunlei.downloadprovider.pushmessage.c.c.a((Context) this)) {
                z = true;
                if (z || c) {
                    if (this.e) {
                        this.e = false;
                        if (a) {
                            com.xunlei.downloadprovider.app.a.d.a().a(1, new b(this, System.currentTimeMillis()));
                        } else {
                            b();
                        }
                    }
                }
                NotificationDialogActivity.a(this, 1);
                k.a();
                return;
            }
        } else {
            new StringBuilder("checkNotificationPermissionForSpecialDevice: ").append(Build.MANUFACTURER);
        }
        z = false;
        if (z) {
        }
        if (this.e) {
            this.e = false;
            if (a) {
                com.xunlei.downloadprovider.app.a.d.a().a(1, new b(this, System.currentTimeMillis()));
            } else {
                b();
            }
        }
    }

    private void e() {
        startActivity(new XLIntent((Context) this, LoadingActivity.class));
        a(getIntent());
        finish();
        BrothersApplication.getSingletonInstance().hasLaunched = true;
    }

    private boolean f() {
        com.xunlei.downloadprovider.launch.dispatch.c cVar = new com.xunlei.downloadprovider.launch.dispatch.c();
        cVar.a(new e());
        cVar.a(new q());
        cVar.a(new r());
        cVar.a(new g());
        cVar.a(new h());
        cVar.a(new s());
        cVar.a(new com.xunlei.downloadprovider.launch.dispatch.a());
        cVar.a(new com.xunlei.downloadprovider.launch.dispatch.f());
        cVar.a(new t());
        if (!cVar.a(this, getIntent())) {
            return false;
        }
        finish();
        return true;
    }
}
