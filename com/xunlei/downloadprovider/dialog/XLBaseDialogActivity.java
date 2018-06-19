package com.xunlei.downloadprovider.dialog;

import android.os.Bundle;
import com.xunlei.downloadprovider.app.BaseActivity;

public class XLBaseDialogActivity extends BaseActivity {
    private boolean a = false;

    public int a() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.a = a.a().a(a());
        if (this.a != null) {
            a.a().a(a(), true);
        } else {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.a) {
            a.a().a(a(), false);
        }
    }
}
