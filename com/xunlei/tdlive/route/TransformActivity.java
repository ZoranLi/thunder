package com.xunlei.tdlive.route;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import java.util.HashMap;

public class TransformActivity extends Activity {
    private static HashMap<String, ActivityHelper> a;

    public static void start(Context context, ActivityHelper activityHelper) {
        start(context, activityHelper, 268435456);
    }

    public static void start(Context context, ActivityHelper activityHelper, int i) {
        if (a == null) {
            a = new HashMap();
        }
        String obj = activityHelper.toString();
        a.put(obj, activityHelper);
        context.startActivity(new Intent(context, TransformActivity.class).putExtra("ActivityHelper", obj).addFlags(i));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityHelper a = a();
        if (a == null) {
            finish();
        } else {
            a.onActivityCreated(this, bundle);
        }
    }

    protected void onResume() {
        super.onResume();
        ActivityHelper a = a();
        if (a == null) {
            finish();
        } else {
            a.onActivityResumed(this);
        }
    }

    protected void onPause() {
        super.onPause();
        ActivityHelper a = a();
        if (a == null) {
            finish();
        } else {
            a.onActivityPaused(this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ActivityHelper a = a();
        if (a == null) {
            finish();
            return;
        }
        a.onActivityDestroyed(this);
        b();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ActivityHelper a = a();
        if (a == null) {
            finish();
        } else {
            a.onActivityResult(this, i, i2, intent);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.dispatchTouchEvent(motionEvent);
    }

    public void finish() {
        super.finish();
        b();
    }

    private ActivityHelper a() {
        if (a == null) {
            return null;
        }
        return (ActivityHelper) a.get(getIntent().getStringExtra("ActivityHelper"));
    }

    private void b() {
        if (a != null) {
            a.remove(getIntent().getStringExtra("ActivityHelper"));
        }
    }
}
