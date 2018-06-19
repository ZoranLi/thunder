package com.xunlei.downloadprovider.member.register.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.d.b.d;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.register.view.a;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.xllib.android.b;

public class AuthMobileActivity extends BaseActivity {
    public static boolean a = false;
    private static final String d = "AuthMobileActivity";
    a c;
    private EditText e;
    private TextView f;
    private TextView g;
    private EditText h;
    private ImageView i;
    private ImageView j;
    private View k;
    private View l;
    private ProgressDialog m;
    private LinearLayout n;
    private ImageView o;
    private boolean p;
    private String q;
    private String r;
    private String s;
    private d t;

    protected final int e() {
        return 0;
    }

    protected final boolean q_() {
        return true;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AuthMobileActivity.class);
        intent.putExtra("from", str);
        context.startActivity(intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mobile_auth_layout);
        this.t = com.xunlei.downloadprovider.d.d.a().e;
        this.r = getIntent().getStringExtra("from");
        this.o = (ImageView) findViewById(R.id.iv_close_auth);
        this.n = (LinearLayout) findViewById(R.id.ll_contain);
        this.e = (EditText) findViewById(R.id.et_phone_num);
        this.f = (TextView) findViewById(R.id.tv_send_verify_code);
        this.g = (TextView) findViewById(R.id.tv_time_count_down);
        this.h = (EditText) findViewById(R.id.et_verify_code);
        this.k = findViewById(R.id.btn_submit);
        if (this.q != null && "".equals(this.q) == null) {
            this.e.setText(this.q);
            this.e.setSelection(this.q.length());
        }
        this.l = findViewById(R.id.iv_clear_verify_code);
        this.i = (ImageView) findViewById(R.id.iv_icon_mobile);
        this.j = (ImageView) findViewById(R.id.iv_icon_verify_code);
        this.f.setOnClickListener(new a(this));
        this.k.setOnClickListener(new g(this));
        this.l.setOnClickListener(new h(this));
        this.e.addTextChangedListener(new i(this));
        this.e.setOnFocusChangeListener(new j(this));
        this.h.setOnFocusChangeListener(new k(this));
        this.h.addTextChangedListener(new l(this));
        this.o.setOnClickListener(new m(this));
        this.n.setOnClickListener(new n(this));
        k.e("");
    }

    protected final void a() {
        boolean z;
        this.q = this.e.getText().toString();
        this.h.setText("");
        if (b.a(this)) {
            z = true;
        } else {
            a((int) R.string.user_account_no_net_hint);
            z = false;
        }
        if (z) {
            b();
            this.m = new ProgressDialog(this);
            this.m.setProgressStyle(0);
            this.m.setMessage(getResources().getString(R.string.register_msg_sending_sms_waiting));
            this.m.setCancelable(false);
            this.m.show();
            String obj = this.e.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                r.a().a(new e(this), obj);
            }
        }
    }

    @NonNull
    private String d() {
        return this.e.getText().toString();
    }

    protected void onResume() {
        super.onResume();
        h();
    }

    protected void onStop() {
        super.onStop();
        b();
    }

    public void finish() {
        r.c = false;
        if (com.xunlei.downloadprovider.d.d.a().e.a()) {
            if (!this.p) {
                if (com.xunlei.downloadprovider.d.d.a().e.b() == 1) {
                    a = true;
                    setResult(-1, new Intent().putExtra("result", this.p));
                }
                super.finish();
                overridePendingTransition(0, 0);
            }
        }
        setResult(-1, new Intent().putExtra("result", this.p));
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void onBackPressed() {
        k.a(this.r, this.t.b() == 2);
        if (this.t.b() == 2) {
            b();
            XLAlertDialog xLAlertDialog = new XLAlertDialog(this);
            xLAlertDialog.setTitle("提示");
            xLAlertDialog.setMessage("中断手机认证，账号将退出登录，是否确认退出？");
            TextView textView = (TextView) xLAlertDialog.findViewById(R.id.dlg_content);
            TextView textView2 = (TextView) xLAlertDialog.findViewById(R.id.dlg_cancel_btn);
            TextView textView3 = (TextView) xLAlertDialog.findViewById(R.id.dlg_confirm_btn);
            ((TextView) xLAlertDialog.findViewById(R.id.dlg_title)).setTextSize(17.0f);
            textView.setTextSize(14.0f);
            textView2.setTextSize(15.0f);
            textView3.setTextSize(15.0f);
            xLAlertDialog.setCancelButtonText("退出");
            xLAlertDialog.setConfirmButtonText("取消");
            xLAlertDialog.setOnClickCancelButtonListener(new b(this));
            xLAlertDialog.setOnClickConfirmButtonListener(new c(this));
            xLAlertDialog.show();
            k.a(HubbleEventBuilder.build("android_personal_account", "account_certification_force_pop_show"));
            return;
        }
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.c != null) {
            this.c.a = true;
        }
    }

    protected final void a(String str) {
        b();
        a.a(this, 2, str).a();
    }

    protected final void a(int i) {
        a(getString(i));
    }

    protected final void b() {
        if (this.m != null) {
            this.m.dismiss();
            this.m = null;
        }
    }

    private boolean g() {
        Object d = d();
        if (TextUtils.isEmpty(d)) {
            a(getString(R.string.register_please_input_phone_number));
            return false;
        } else if (d.matches("^1[0-9]{10}$")) {
            return true;
        } else {
            a(getString(R.string.register_please_input_correct_phone_number));
            return false;
        }
    }

    private void a(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void h() {
        if (this.e.getText().length() > 0) {
            if (this.h.getText().length() > 0) {
                this.k.setEnabled(true);
            } else {
                this.k.setEnabled(false);
            }
            this.f.setEnabled(true);
            return;
        }
        this.k.setEnabled(false);
        this.f.setEnabled(false);
    }

    static /* synthetic */ void a(AuthMobileActivity authMobileActivity, View view) {
        authMobileActivity.a(view);
        if (authMobileActivity.g() != null) {
            if (TextUtils.isEmpty(authMobileActivity.h.getText().toString()) != null) {
                authMobileActivity.a(authMobileActivity.getString(R.string.register_please_input_sms_verify_code));
                view = null;
            } else {
                view = true;
            }
            if (view != null) {
                view = authMobileActivity.d();
                if (!TextUtils.isEmpty(view)) {
                    Object obj = authMobileActivity.h.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        r.a().a(new f(authMobileActivity, view), view, obj, authMobileActivity.s);
                    }
                }
                return;
            }
        }
        authMobileActivity.b();
    }

    static /* synthetic */ void a(AuthMobileActivity authMobileActivity, int i) {
        if (i > 0) {
            authMobileActivity.g.setText(String.format("%s秒后重新获取", new Object[]{Integer.valueOf(i)}));
            authMobileActivity.g.setVisibility(0);
            authMobileActivity.f.setVisibility(8);
            return;
        }
        authMobileActivity.g.setVisibility(8);
        authMobileActivity.f.setVisibility(0);
    }
}
