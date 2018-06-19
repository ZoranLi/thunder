package com.getui.gtc.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.Menu;

public abstract class UILogic {
    protected Activity activity;
    protected Long activityId = Long.valueOf(System.currentTimeMillis());
    protected String taskId;

    public abstract void doStop();

    public Activity getActivity() {
        return this.activity;
    }

    public Long getActivityId() {
        return this.activityId;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract boolean onCreateOptionsMenu(Menu menu);

    public abstract void onDestroy();

    public abstract boolean onKeyDown(int i, KeyEvent keyEvent);

    public abstract void onNewIntent(Intent intent);

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onRestart();

    public abstract void onResume();

    public abstract void onStart();

    public abstract void onStop();

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void setActivityId(Long l) {
        this.activityId = l;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }
}
