package com.alibaba.wireless.security.framework.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.WindowManager.LayoutParams;

public interface b {
    void attach(Activity activity, c cVar);

    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed();

    void onCreate(Bundle bundle);

    boolean onCreateOptionsMenu(Menu menu);

    void onDestroy();

    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    boolean onOptionsItemSelected(MenuItem menuItem);

    void onPause();

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    boolean onTouchEvent(MotionEvent motionEvent);

    void onWindowAttributesChanged(LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z);
}
