package com.getui.gtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;
import java.util.HashMap;
import java.util.Map;

public class UICore {
    private static UICore a;
    private Map b = new HashMap();

    private UICore() {
    }

    public static UICore getInstance() {
        if (a == null) {
            a = new UICore();
        }
        return a;
    }

    public void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onConfigurationChanged(configuration);
        }
    }

    public boolean onActivityCreateOptionsMenu(Activity activity, Menu menu) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        return uILogic != null && uILogic.onCreateOptionsMenu(menu);
    }

    public void onActivityDestroy(Activity activity) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onDestroy();
            this.b.remove(activity);
            UIManager.getInstance().removeActivityLogic(uILogic);
        }
    }

    public boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        return uILogic != null && uILogic.onKeyDown(i, keyEvent);
    }

    public void onActivityNewIntent(Activity activity, Intent intent) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onNewIntent(intent);
        }
    }

    public void onActivityPause(Activity activity) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onPause();
        }
    }

    public void onActivityRestart(Activity activity) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onRestart();
        }
    }

    public void onActivityResume(Activity activity) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onResume();
        }
    }

    public void onActivityStart(Activity activity, Intent intent) {
        if (!(activity == null || intent == null || !intent.hasExtra("activityid"))) {
            UILogic findActivityLogic = UIManager.getInstance().findActivityLogic(Long.valueOf(intent.getLongExtra("activityid", 0)));
            if (findActivityLogic != null) {
                findActivityLogic.setActivity(activity);
                this.b.put(activity, findActivityLogic);
                findActivityLogic.onStart();
                return;
            }
            activity.finish();
        }
    }

    public void onActivityStop(Activity activity) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onStop();
        }
    }

    public void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr) {
        UILogic uILogic = (UILogic) this.b.get(activity);
        if (uILogic != null) {
            uILogic.onRequestPermissionsResult(i, strArr, iArr);
        }
    }
}
