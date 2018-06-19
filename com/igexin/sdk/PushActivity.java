package com.igexin.sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import com.igexin.sdk.a.a;

public class PushActivity extends Activity {
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.a().b() != null) {
            a.a().b().onActivityConfigurationChanged(this, configuration);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return a.a().b() != null ? a.a().b().onActivityCreateOptionsMenu(this, menu) : true;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (a.a().b() != null) {
            a.a().b().onActivityDestroy(this);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return (a.a().b() == null || !a.a().b().onActivityKeyDown(this, i, keyEvent)) ? super.onKeyDown(i, keyEvent) : true;
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (a.a().b() != null) {
            a.a().b().onActivityNewIntent(this, intent);
        }
    }

    protected void onPause() {
        super.onPause();
        if (a.a().b() != null) {
            a.a().b().onActivityPause(this);
        }
    }

    protected void onRestart() {
        super.onRestart();
        if (a.a().b() != null) {
            a.a().b().onActivityRestart(this);
        }
    }

    protected void onResume() {
        super.onResume();
        if (a.a().b() != null) {
            a.a().b().onActivityResume(this);
        }
    }

    protected void onStart() {
        super.onStart();
        if (a.a().b() != null) {
            a.a().b().onActivityStart(this, getIntent());
        }
    }

    protected void onStop() {
        super.onStop();
        if (a.a().b() != null) {
            a.a().b().onActivityStop(this);
        }
    }
}
