package com.alibaba.wireless.security.framework;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;
import com.alibaba.wireless.security.framework.a.a;
import com.alibaba.wireless.security.framework.a.b;
import com.alibaba.wireless.security.framework.a.d;

public class SGProxyActivity extends Activity implements a {
    private d a = new d(this);
    protected b mRemoteActivity;

    public void attach(b bVar, b bVar2) {
        this.mRemoteActivity = bVar;
    }

    public AssetManager getAssets() {
        return this.a.c() == null ? super.getAssets() : this.a.c();
    }

    public ClassLoader getClassLoader() {
        return this.a.b();
    }

    public Resources getResources() {
        return this.a.d() == null ? super.getResources() : this.a.d();
    }

    public Theme getTheme() {
        return this.a.e() == null ? super.getTheme() : this.a.e();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mRemoteActivity.onActivityResult(i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    public void onBackPressed() {
        this.mRemoteActivity.onBackPressed();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a.a(getIntent());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.mRemoteActivity.onCreateOptionsMenu(menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy() {
        this.mRemoteActivity.onDestroy();
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        super.onKeyUp(i, keyEvent);
        return this.mRemoteActivity.onKeyUp(i, keyEvent);
    }

    protected void onNewIntent(Intent intent) {
        this.mRemoteActivity.onNewIntent(intent);
        super.onNewIntent(intent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        this.mRemoteActivity.onOptionsItemSelected(menuItem);
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPause() {
        this.mRemoteActivity.onPause();
        super.onPause();
    }

    protected void onRestart() {
        this.mRemoteActivity.onRestart();
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.mRemoteActivity.onRestoreInstanceState(bundle);
        super.onRestoreInstanceState(bundle);
    }

    protected void onResume() {
        this.mRemoteActivity.onResume();
        super.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mRemoteActivity.onSaveInstanceState(bundle);
        super.onSaveInstanceState(bundle);
    }

    protected void onStart() {
        this.mRemoteActivity.onStart();
        super.onStart();
    }

    protected void onStop() {
        this.mRemoteActivity.onStop();
        super.onStop();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.mRemoteActivity.onTouchEvent(motionEvent);
    }

    public void onWindowAttributesChanged(LayoutParams layoutParams) {
        this.mRemoteActivity.onWindowAttributesChanged(layoutParams);
        super.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.mRemoteActivity.onWindowFocusChanged(z);
        super.onWindowFocusChanged(z);
    }

    public ComponentName startService(Intent intent) {
        return super.startService(intent);
    }
}
