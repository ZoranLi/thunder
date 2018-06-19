package com.igexin.push.core.stub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.push.core.d.a;
import com.igexin.push.core.d.b;
import com.igexin.push.core.f;
import com.igexin.push.core.o;
import com.igexin.sdk.IPushCore;
import java.util.HashMap;
import java.util.Map;

public class PushCore implements IPushCore {
    private f a;
    private Map<Activity, a> b = new HashMap();

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.a(configuration);
        }
    }

    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        a aVar = (a) this.b.get(activity);
        return aVar != null && aVar.a(menu);
    }

    public void onActivityDestroy(Activity activity) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.h();
            this.b.remove(activity);
            b.a().c(aVar);
        }
    }

    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        a aVar = (a) this.b.get(activity);
        return aVar != null && aVar.a(i, keyEvent);
    }

    public void onActivityNewIntent(Activity activity, Intent intent) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.a(intent);
        }
    }

    public void onActivityPause(Activity activity) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.f();
        }
    }

    public void onActivityRestart(Activity activity) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.d();
        }
    }

    public void onActivityResume(Activity activity) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.e();
        }
    }

    public void onActivityStart(Activity activity, Intent intent) {
        if (!(activity == null || intent == null || !intent.hasExtra("activityid"))) {
            a a = b.a().a(Long.valueOf(intent.getLongExtra("activityid", 0)));
            if (a != null) {
                a.a(activity);
                this.b.put(activity, a);
                a.c();
                return;
            }
            activity.finish();
        }
    }

    public void onActivityStop(Activity activity) {
        a aVar = (a) this.b.get(activity);
        if (aVar != null) {
            aVar.g();
        }
    }

    public IBinder onServiceBind(Intent intent) {
        return o.a();
    }

    public void onServiceDestroy() {
        if (this.a != null) {
            this.a.l();
        }
    }

    public int onServiceStartCommand(Intent intent, int i, int i2) {
        if (this.a != null) {
            Message obtain = Message.obtain();
            obtain.what = com.igexin.push.core.a.c;
            obtain.obj = intent;
            this.a.a(obtain);
        }
        return 1;
    }

    public boolean start(Context context) {
        this.a = f.a();
        this.a.a(context);
        return true;
    }
}
