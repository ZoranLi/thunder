package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import com.huawei.hms.support.log.a;

public class BridgeActivity extends Activity {
    public static final String EXTRA_DELEGATE_CLASS_EX_NAME = "intent.extra.DELEGATE_CLASS_OBJECT_EX";
    public static final String EXTRA_DELEGATE_CLASS_NAME = "intent.extra.DELEGATE_CLASS_OBJECT";
    public static final String EXTRA_RESULT = "intent.extra.RESULT";
    private a a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a();
        if (b() == null) {
            setResult(1, null);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.a != null) {
            this.a.a();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.a != null) {
            this.a.b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.a != null && this.a.a(i, i2, intent) == 0 && isFinishing() == 0) {
            setResult(i2, intent);
            finish();
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.a != null) {
            this.a.a(i, keyEvent);
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void finish() {
        a.b("BridgeActivity", "Enter finish.");
        super.finish();
    }

    private void a() {
        requestWindowFeature(1);
        if (com.huawei.hms.a.a.a.a >= 9) {
            Window window = getWindow();
            window.addFlags(67108864);
            a(window, true);
        }
    }

    private boolean b() {
        Intent intent = getIntent();
        if (intent == null) {
            a.d("BridgeActivity", "In initialize, Must not pass in a null intent.");
            return false;
        }
        String stringExtra = intent.getStringExtra(EXTRA_DELEGATE_CLASS_NAME);
        if (stringExtra == null) {
            a.d("BridgeActivity", "In initialize, Must not pass in a null or non class object.");
            return false;
        }
        try {
            this.a = (a) Class.forName(stringExtra).asSubclass(a.class).newInstance();
            this.a.a((Activity) this, true);
            return true;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("In initialize, Failed to create 'IUpdateWizard' instance.");
            stringBuilder.append(e.getMessage());
            a.d("BridgeActivity", stringBuilder.toString());
            return false;
        }
    }

    private static void a(Window window, boolean z) {
        try {
            window.getClass().getMethod("setHwFloating", new Class[]{Boolean.TYPE}).invoke(window, new Object[]{Boolean.valueOf(z)});
        } catch (Window window2) {
            StringBuilder stringBuilder = new StringBuilder("In setHwFloating, Failed to call Window.setHwFloating().");
            stringBuilder.append(window2.getMessage());
            a.d("BridgeActivity", stringBuilder.toString());
        }
    }
}
