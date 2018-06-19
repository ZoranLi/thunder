package com.xunlei.downloadprovider.web.base.core;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.web.base.f;

public abstract class BaseWebViewActivity extends BaseActivity {
    protected CustomWebView f;
    protected String g;
    protected String h;

    public void a() {
    }

    public boolean c() {
        return true;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
        a();
        if (TextUtils.isEmpty(this.g) == null) {
            this.f.a(this.g);
        }
        this.f.setFrom(this.h);
        f.a(this.h, this.g);
    }

    public void a(Intent intent) {
        this.g = intent.getStringExtra("url");
        this.h = intent.getStringExtra("from");
    }

    protected void onResume() {
        super.onResume();
        this.f.e();
    }

    protected void onPause() {
        if (c()) {
            this.f.f();
        }
        super.onPause();
    }

    public void onDestroy() {
        this.f.d();
        super.onDestroy();
    }

    public void onBackPressed() {
        h();
        if (this.f.h()) {
            this.f.i();
        } else {
            super.onBackPressed();
        }
    }

    public final void h() {
        if (this.f != null) {
            this.f.g();
        }
    }

    public void onClickGoback(View view) {
        finish();
    }
}
