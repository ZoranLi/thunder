package com.xunlei.downloadprovider.member.login.authphone;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.personal.user.account.k;
import com.xunlei.xllib.android.b;

public class AuthDlgActivity extends BaseActivity {
    private static final String c = "AuthDlgActivity";
    a a;
    private EditText d;
    private TextView e;
    private TextView f;
    private EditText g;
    private ImageView h;
    private ImageView i;
    private View j;
    private View k;
    private ProgressDialog l;
    private ImageView m;
    private boolean n;
    private String o;
    private String p;
    private String q;

    private static class a {
        volatile boolean a = false;
        Handler b;
        Thread c;

        interface a {
            void a(int i);
        }

        a(a aVar) {
            this.b = new m(this, Looper.getMainLooper(), aVar);
            this.c = new Thread(new n(this));
        }
    }

    protected final int e() {
        return 0;
    }

    protected final boolean q_() {
        return true;
    }

    public static void a(Context context, String str, p pVar) {
        if (pVar != null) {
            r.a().a(pVar);
        }
        pVar = new Intent(context, AuthDlgActivity.class);
        pVar.putExtra("from", str);
        if ((context instanceof Activity) == null) {
            pVar.setFlags(268435456);
        }
        context.startActivity(pVar);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.login_auth_dlg_layout);
        this.p = getIntent().getStringExtra("from");
        this.m = (ImageView) findViewById(R.id.iv_auth_close);
        this.d = (EditText) findViewById(R.id.et_phone_num);
        this.e = (TextView) findViewById(R.id.tv_send_verify_code);
        this.f = (TextView) findViewById(R.id.tv_time_count_down);
        this.g = (EditText) findViewById(R.id.et_verify_code);
        this.j = findViewById(R.id.btn_submit);
        TextView textView = (TextView) findViewById(R.id.tv_register_protocol);
        if (!(this.o == null || "".equals(this.o))) {
            this.d.setText(this.o);
            this.d.setSelection(this.o.length());
        }
        textView.setVisibility(8);
        CharSequence spannableString = new SpannableString(getString(R.string.register_user_protocol));
        spannableString.setSpan(new a(this), 0, spannableString.length(), 33);
        textView.setText(getString(R.string.register_from_register_userprotocol));
        textView.append(spannableString);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.k = findViewById(R.id.iv_clear_verify_code);
        this.h = (ImageView) findViewById(R.id.iv_icon_mobile);
        this.i = (ImageView) findViewById(R.id.iv_icon_verify_code);
        this.e.setOnClickListener(new e(this));
        this.j.setOnClickListener(new f(this));
        this.k.setOnClickListener(new g(this));
        this.d.addTextChangedListener(new h(this));
        this.d.setOnFocusChangeListener(new i(this));
        this.g.setOnFocusChangeListener(new j(this));
        this.g.addTextChangedListener(new k(this));
        this.m.setOnClickListener(new l(this));
        k.e(this.p);
    }

    protected final void a() {
        boolean z;
        this.o = this.d.getText().toString();
        this.g.setText("");
        if (b.a(this)) {
            z = true;
        } else {
            a((int) R.string.user_account_no_net_hint);
            z = false;
        }
        if (z) {
            b();
            this.l = new ProgressDialog(this);
            this.l.setProgressStyle(0);
            this.l.setMessage(getResources().getString(R.string.register_msg_sending_sms_waiting));
            this.l.setCancelable(false);
            this.l.show();
            Object obj = this.d.getText().toString();
            if (!TextUtils.isEmpty(obj)) {
                r.a().a(new c(this), obj);
            }
        }
    }

    @NonNull
    private String d() {
        return this.d.getText().toString();
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
        super.finish();
        overridePendingTransition(0, 0);
        r.c = false;
    }

    public void onBackPressed() {
        if (!this.n) {
            int b = o.b(this.p);
            boolean z = false;
            r.a().a(false, true, b == 1);
            String str = this.p;
            if (b == 2) {
                z = true;
            }
            k.a(str, z);
            super.onBackPressed();
        }
    }

    protected void onDestroy() {
        if (this.a != null) {
            this.a.a = true;
        }
        r.a().a.clear();
        super.onDestroy();
    }

    protected final void a(String str) {
        b();
        com.xunlei.downloadprovider.member.register.view.a.a(this, 2, str).a();
    }

    protected final void a(int i) {
        a(getString(i));
    }

    protected final void b() {
        if (this.l != null) {
            this.l.dismiss();
            this.l = null;
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
        if (this.d.getText().length() > 0) {
            if (this.g.getText().length() > 0) {
                this.j.setEnabled(true);
            } else {
                this.j.setEnabled(false);
            }
            this.e.setEnabled(true);
            return;
        }
        this.j.setEnabled(false);
        this.e.setEnabled(false);
    }

    static /* synthetic */ void a(AuthDlgActivity authDlgActivity, View view) {
        authDlgActivity.a(view);
        if (authDlgActivity.g() != null) {
            if (TextUtils.isEmpty(authDlgActivity.g.getText().toString()) != null) {
                authDlgActivity.a(authDlgActivity.getString(R.string.register_please_input_sms_verify_code));
                view = null;
            } else {
                view = 1;
            }
            if (view != null) {
                view = authDlgActivity.d();
                if (!TextUtils.isEmpty(view)) {
                    Object obj = authDlgActivity.g.getText().toString();
                    if (!TextUtils.isEmpty(obj)) {
                        authDlgActivity.n = true;
                        r.a().a(new d(authDlgActivity, view), view, obj, authDlgActivity.q);
                    }
                }
                return;
            }
        }
        authDlgActivity.b();
    }

    static /* synthetic */ void a(AuthDlgActivity authDlgActivity, int i) {
        if (i > 0) {
            authDlgActivity.f.setText(String.format("%s秒后重新获取", new Object[]{Integer.valueOf(i)}));
            authDlgActivity.f.setVisibility(0);
            authDlgActivity.e.setVisibility(8);
            return;
        }
        authDlgActivity.f.setVisibility(8);
        authDlgActivity.e.setVisibility(0);
    }

    static /* synthetic */ void a(boolean z) {
        if (z) {
            r.a().a(true, false, true);
        } else {
            r.a().a(true, false, false);
        }
    }
}
