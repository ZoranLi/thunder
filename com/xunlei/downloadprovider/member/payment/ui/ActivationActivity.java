package com.xunlei.downloadprovider.member.payment.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.e.a;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.d;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.xllib.android.b;

public class ActivationActivity extends BaseActivity implements OnClickListener {
    private static String a;
    private EditText c = null;
    private EditText d = null;
    private ImageView e = null;
    private Button f = null;
    private Button g = null;
    private Button h = null;
    private ProgressBar i = null;
    private Bitmap j = null;
    private a k = null;
    private String l = null;
    private String m = null;
    private String n = null;
    private boolean o = true;
    private Handler p = new a(this);
    private h q = new b(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activation_payment);
        findViewById(R.id.titlebar_left).setOnClickListener(this);
        ((TextView) findViewById(R.id.titlebar_title)).setText(getResources().getString(R.string.activation_exchange));
        this.c = (EditText) findViewById(R.id.activation_code_et);
        this.d = (EditText) findViewById(R.id.verify_code_et);
        this.e = (ImageView) findViewById(R.id.verify_picture_iv);
        this.f = (Button) findViewById(R.id.recharge_btn);
        this.g = (Button) findViewById(R.id.clearBtn1);
        this.h = (Button) findViewById(R.id.clearBtn2);
        this.i = (ProgressBar) findViewById(R.id.verify_progress);
        this.c.setOnClickListener(this);
        this.c.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.g.setOnClickListener(new c(this));
        this.h.setOnClickListener(new d(this));
        this.c.setOnFocusChangeListener(new e(this));
        this.c.addTextChangedListener(new f(this));
        this.d.setOnFocusChangeListener(new g(this));
        this.d.addTextChangedListener(new h(this));
        this.m = getIntent().getStringExtra("activation_src_key");
        this.n = getIntent().getStringExtra(PayBaseConstants.PAY_FROM);
        new StringBuilder("activationSrc = ").append(this.m);
        d.a("pay_key_show", this.n);
    }

    public void onResume() {
        super.onResume();
        if (a != null) {
            this.c.setText(a);
            if ("".equals(this.c.getText().toString().trim())) {
                this.c.requestFocus();
            } else {
                this.d.requestFocus();
            }
        }
        this.o = true;
        b();
    }

    public void onPause() {
        super.onPause();
        if (this.o) {
            a = this.c.getText().toString().trim();
        } else {
            a = "";
        }
    }

    public void onDestroy() {
        c();
        super.onDestroy();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activation_code_et:
                if ("".equals(this.c.getText().toString().trim()) == null) {
                    this.g.setVisibility(0);
                } else {
                    this.g.setVisibility(4);
                }
                this.c.requestFocus();
                return;
            case R.id.verify_picture_iv:
                b();
                return;
            case R.id.verify_code_et:
                if ("".equals(this.d.getText().toString().trim()) == null) {
                    this.h.setVisibility(0);
                } else {
                    this.h.setVisibility(4);
                }
                this.d.requestFocus();
                break;
            case R.id.recharge_btn:
                if (b.a(getApplicationContext()) == null) {
                    XLToast.showToast(getApplicationContext(), getResources().getString(R.string.sett_no_net));
                    return;
                }
                Object trim = this.c.getText().toString().trim();
                Object trim2 = this.d.getText().toString().trim();
                if ("".equals(trim2) != null && "".equals(trim) != null) {
                    XLToast.showToast(getApplicationContext(), getResources().getString(R.string.activation_empty));
                    this.c.requestFocus();
                    return;
                } else if ("".equals(trim) != null) {
                    XLToast.showToast(getApplicationContext(), getResources().getString(R.string.activation_empty));
                    this.c.requestFocus();
                    return;
                } else if ("".equals(trim2) != null) {
                    XLToast.showToast(getApplicationContext(), getResources().getString(R.string.verifycode_empty));
                    this.d.requestFocus();
                    return;
                } else {
                    if (TextUtils.isEmpty(trim2) == null && TextUtils.isEmpty(trim) == null && this.k != null) {
                        com.xunlei.downloadprovider.member.payment.a.a aVar = new com.xunlei.downloadprovider.member.payment.a.a(getApplicationContext(), String.valueOf(j.a().a.g.c()), trim, trim2, this.k.b, "wx", this.p);
                        this.c.setTextColor(-7829368);
                        this.c.setFocusableInTouchMode(false);
                        this.c.setEnabled(false);
                        this.d.setTextColor(-7829368);
                        this.d.setFocusableInTouchMode(false);
                        this.d.setEnabled(false);
                        this.e.setClickable(false);
                        this.f.setText(R.string.recharging);
                        this.f.setClickable(false);
                        this.g.setVisibility(8);
                        this.h.setVisibility(8);
                        AndroidConfig.hiddenInput(getApplicationContext(), getCurrentFocus());
                    }
                    d.a("pay_key_submit", this.n);
                    return;
                }
            case R.id.titlebar_left:
                finish();
                return;
            default:
                break;
        }
    }

    private void a() {
        this.c.setTextColor(-16777216);
        this.c.setFocusableInTouchMode(true);
        this.c.setEnabled(true);
        this.d.setTextColor(-16777216);
        this.d.setFocusableInTouchMode(true);
        this.d.setEnabled(true);
        this.e.setClickable(true);
        this.f.setText(R.string.recharge);
        this.f.setClickable(true);
    }

    private void b() {
        c();
        this.i.setVisibility(0);
        com.xunlei.downloadprovider.member.payment.a.a aVar = new com.xunlei.downloadprovider.member.payment.a.a();
        Handler handler = this.p;
        if (!aVar.a) {
            XLThreadPool.execute(new com.xunlei.downloadprovider.member.payment.a.d(aVar, handler));
        }
    }

    private void c() {
        if (this.j != null && !this.j.isRecycled()) {
            this.j.recycle();
            this.j = null;
        }
    }

    static /* synthetic */ void k(ActivationActivity activationActivity) {
        activationActivity.a();
        activationActivity.c.setText("");
        activationActivity.d.setText("");
        XLToast.showToast(activationActivity.getApplicationContext(), activationActivity.getResources().getString(R.string.recharge_success));
    }
}
