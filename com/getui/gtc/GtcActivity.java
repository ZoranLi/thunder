package com.getui.gtc;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.getui.gtc.ui.UICore;

public class GtcActivity extends Activity {
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        UICore.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return UICore.getInstance().onActivityCreateOptionsMenu(this, menu);
    }

    protected void onDestroy() {
        super.onDestroy();
        UICore.getInstance().onActivityDestroy(this);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return UICore.getInstance().onActivityKeyDown(this, i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        UICore.getInstance().onActivityNewIntent(this, intent);
    }

    protected void onPause() {
        super.onPause();
        UICore.getInstance().onActivityPause(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        UICore.getInstance().onRequestPermissionsResult(this, i, strArr, iArr);
    }

    protected void onRestart() {
        super.onRestart();
        UICore.getInstance().onActivityRestart(this);
    }

    protected void onResume() {
        super.onResume();
        UICore.getInstance().onActivityResume(this);
    }

    protected void onStart() {
        super.onStart();
        UICore.getInstance().onActivityStart(this, getIntent());
    }

    protected void onStop() {
        super.onStop();
        UICore.getInstance().onActivityStop(this);
    }
}
