package com.alibaba.wireless.security.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.wireless.security.framework.a.b;
import com.alibaba.wireless.security.framework.a.c;

public class SGBasePluginActivity extends Activity implements b {
    protected int mFrom = 0;
    protected b mPluginManager;
    protected c mPluginPackage;
    protected Activity mProxyActivity;
    protected Activity that;

    public void addContentView(View view, LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.addContentView(view, layoutParams);
        } else {
            this.mProxyActivity.addContentView(view, layoutParams);
        }
    }

    public void attach(Activity activity, c cVar) {
        new StringBuilder("attach: proxyActivity= ").append(activity);
        this.mProxyActivity = activity;
        this.that = this.mProxyActivity;
        this.mPluginPackage = cVar;
    }

    public int bindPluginService(a aVar, ServiceConnection serviceConnection, int i) {
        if (this.mFrom == 1 && aVar.a() == null) {
            aVar.a(this.mPluginPackage.a);
        }
        return this.mPluginManager.a(this.that, aVar, serviceConnection, i);
    }

    public View findViewById(int i) {
        return this.mFrom == 0 ? super.findViewById(i) : this.mProxyActivity.findViewById(i);
    }

    public void finish() {
        if (this.mFrom == 0) {
            super.finish();
        } else {
            this.mProxyActivity.finish();
        }
    }

    public Context getApplicationContext() {
        return this.mFrom == 0 ? super.getApplicationContext() : this.mProxyActivity.getApplicationContext();
    }

    public ClassLoader getClassLoader() {
        return this.mFrom == 0 ? super.getClassLoader() : this.mProxyActivity.getClassLoader();
    }

    public Intent getIntent() {
        return this.mFrom == 0 ? super.getIntent() : this.mProxyActivity.getIntent();
    }

    public LayoutInflater getLayoutInflater() {
        return this.mFrom == 0 ? super.getLayoutInflater() : this.mProxyActivity.getLayoutInflater();
    }

    public MenuInflater getMenuInflater() {
        return this.mFrom == 0 ? super.getMenuInflater() : this.mProxyActivity.getMenuInflater();
    }

    public String getPackageName() {
        return this.mFrom == 0 ? super.getPackageName() : this.mPluginPackage.a;
    }

    public Resources getResources() {
        return this.mFrom == 0 ? super.getResources() : this.mProxyActivity.getResources();
    }

    public SharedPreferences getSharedPreferences(String str, int i) {
        return this.mFrom == 0 ? super.getSharedPreferences(str, i) : this.mProxyActivity.getSharedPreferences(str, i);
    }

    public Object getSystemService(String str) {
        return this.mFrom == 0 ? super.getSystemService(str) : this.mProxyActivity.getSystemService(str);
    }

    public Window getWindow() {
        return this.mFrom == 0 ? super.getWindow() : this.mProxyActivity.getWindow();
    }

    public WindowManager getWindowManager() {
        return this.mFrom == 0 ? super.getWindowManager() : this.mProxyActivity.getWindowManager();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mFrom == 0) {
            super.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (this.mFrom == 0) {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle != null) {
            this.mFrom = bundle.getInt("extra.from", 0);
        }
        if (this.mFrom == 0) {
            super.onCreate(bundle);
            this.mProxyActivity = this;
            this.that = this.mProxyActivity;
        }
        this.mPluginManager = b.a(this.that);
        new StringBuilder("onCreate: from= ").append(this.mFrom == 0 ? "DLConstants.FROM_INTERNAL" : "FROM_EXTERNAL");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return this.mFrom == 0 ? super.onCreateOptionsMenu(menu) : true;
    }

    public void onDestroy() {
        if (this.mFrom == 0) {
            super.onDestroy();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mFrom == 0 ? super.onKeyUp(i, keyEvent) : false;
    }

    public void onNewIntent(Intent intent) {
        if (this.mFrom == 0) {
            super.onNewIntent(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return this.mFrom == 0 ? onOptionsItemSelected(menuItem) : false;
    }

    public void onPause() {
        if (this.mFrom == 0) {
            super.onPause();
        }
    }

    public void onRestart() {
        if (this.mFrom == 0) {
            super.onRestart();
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
        if (this.mFrom == 0) {
            super.onRestoreInstanceState(bundle);
        }
    }

    public void onResume() {
        if (this.mFrom == 0) {
            super.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.mFrom == 0) {
            super.onSaveInstanceState(bundle);
        }
    }

    public void onStart() {
        if (this.mFrom == 0) {
            super.onStart();
        }
    }

    public void onStop() {
        if (this.mFrom == 0) {
            super.onStop();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mFrom == 0 ? super.onTouchEvent(motionEvent) : false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.onWindowAttributesChanged(layoutParams);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (this.mFrom == 0) {
            super.onWindowFocusChanged(z);
        }
    }

    public void setContentView(int i) {
        if (this.mFrom == 0) {
            super.setContentView(i);
        } else {
            this.mProxyActivity.setContentView(i);
        }
    }

    public void setContentView(View view) {
        if (this.mFrom == 0) {
            super.setContentView(view);
        } else {
            this.mProxyActivity.setContentView(view);
        }
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        if (this.mFrom == 0) {
            super.setContentView(view, layoutParams);
        } else {
            this.mProxyActivity.setContentView(view, layoutParams);
        }
    }

    public int startPluginActivity(a aVar) {
        return startPluginActivityForResult(aVar, -1);
    }

    public int startPluginActivityForResult(a aVar, int i) {
        if (this.mFrom == 1 && aVar.a() == null) {
            aVar.a(this.mPluginPackage.a);
        }
        return this.mPluginManager.a(this.that, aVar, i);
    }

    public int startPluginService(a aVar) {
        if (this.mFrom == 1 && aVar.a() == null) {
            aVar.a(this.mPluginPackage.a);
        }
        return this.mPluginManager.a(this.that, aVar);
    }

    public int stopPluginService(a aVar) {
        if (this.mFrom == 1 && aVar.a() == null) {
            aVar.a(this.mPluginPackage.a);
        }
        return this.mPluginManager.b(this.that, aVar);
    }

    int test() {
        return 1;
    }

    public int unBindPluginService(a aVar, ServiceConnection serviceConnection) {
        if (this.mFrom == 1 && aVar.a() == null) {
            aVar.a(this.mPluginPackage.a);
        }
        return this.mPluginManager.a(this.that, aVar, serviceConnection);
    }
}
