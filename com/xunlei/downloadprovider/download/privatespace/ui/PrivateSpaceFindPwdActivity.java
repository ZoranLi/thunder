package com.xunlei.downloadprovider.download.privatespace.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.InputDeviceCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.privatespace.a.a.a;
import com.xunlei.downloadprovider.download.privatespace.a.a.c;
import com.xunlei.downloadprovider.download.privatespace.a.a.h;
import com.xunlei.downloadprovider.download.privatespace.a.a.i;
import com.xunlei.downloadprovider.download.privatespace.a.b.f;
import com.xunlei.downloadprovider.download.privatespace.a.b.g;
import com.xunlei.downloadprovider.download.privatespace.a.b.j;
import com.xunlei.downloadprovider.download.privatespace.v;
import com.xunlei.downloadprovider.download.privatespace.v$a;
import com.xunlei.downloadprovider.download.privatespace.widget.CountDownView;
import com.xunlei.downloadprovider.download.privatespace.widget.VerifyCodeSendView;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.register.view.d;
import com.xunlei.xllib.android.b;
import org.android.spdy.TnetStatusCode;

public class PrivateSpaceFindPwdActivity extends BaseActivity {
    private VerifyCodeSendView a;
    private EditText c;
    private EditText d;
    private EditText e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private View i;
    private View j;
    private ImageView k;
    private a l = new a();
    private h m = new d(this);
    private h n = new e(this);
    private d o;
    private i p;
    private MessageListener q = new h(this);
    private StaticHandler r;
    private boolean s = false;
    private v$a t = new i(this);
    private XLWaitingDialog u;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.private_space_find_pwd_activity);
        bundle = new TitleBar((Activity) this);
        bundle.mLeft.setOnClickListener(new c(this));
        bundle.mTitle.setText("重置私人空间密码");
        this.a = (VerifyCodeSendView) findViewById(R.id.un_bind_verify_code_view);
        this.a.setOnClickListener(new a(this));
        this.c = (EditText) findViewById(R.id.et_phone_num);
        this.d = (EditText) findViewById(R.id.et_verify_code);
        this.i = findViewById(R.id.btn_submit);
        this.j = findViewById(R.id.iv_clear_verify_code);
        this.e = (EditText) findViewById(R.id.et_new_password);
        this.g = (ImageView) findViewById(R.id.iv_icon_verify_code);
        this.f = (ImageView) findViewById(R.id.iv_icon_mobile);
        this.h = (ImageView) findViewById(R.id.iv_icon_password);
        this.k = (ImageView) findViewById(R.id.password_visible_re_iv);
        if (!TextUtils.isEmpty(LoginHelper.a().i())) {
            this.c.setText(String.format("您已绑定手机：%s", new Object[]{bundle}));
            this.c.setBackgroundDrawable(null);
            this.f.setVisibility(8);
            this.c.setGravity(16);
            this.c.setPadding(0, 0, 0, 0);
            this.c.setFocusable(false);
            this.c.setFocusableInTouchMode(false);
            this.c.setTextSize(1, 13.0f);
            bundle = new LayoutParams(-2, getResources().getDimensionPixelOffset(R.dimen.dp_30));
            bundle.addRule(11);
            bundle.addRule(15);
            this.a.setLayoutParams(bundle);
        }
        this.i.setEnabled(false);
        this.i.setOnClickListener(new j(this));
        this.j.setOnClickListener(new k(this));
        this.c.addTextChangedListener(new l(this));
        this.c.setOnFocusChangeListener(new m(this));
        this.d.setOnFocusChangeListener(new n(this));
        this.d.addTextChangedListener(new o(this));
        this.e.setOnFocusChangeListener(new p(this));
        this.e.addTextChangedListener(new q(this));
        this.k.setOnClickListener(new b(this));
        this.r = new StaticHandler(this.q);
    }

    private String b() {
        if (a.a()) {
            return LoginHelper.a().i();
        }
        return this.c.getText().toString().trim();
    }

    private String c() {
        return this.d.getText().toString().trim();
    }

    private String d() {
        return this.e.getText().toString().trim();
    }

    protected void onDestroy() {
        if (this.a != null) {
            this.a.a();
        }
        a.b();
        g();
        i();
        this.r.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    public static void a(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, PrivateSpaceFindPwdActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }
    }

    private void g() {
        if (this.o != null) {
            this.o.dismiss();
        }
    }

    private void h() {
        a("密码重置中");
        v.c(d(), this.t);
    }

    private void a(String str) {
        if (this.u == null) {
            this.u = new XLWaitingDialog(this);
        }
        this.u.setProHintStr(str);
        this.u.show();
    }

    private void i() {
        if (this.u != null) {
            this.u.dismiss();
        }
    }

    private boolean j() {
        if (b.a(this)) {
            return true;
        }
        XLToast.showLongToast(this, getString(R.string.user_account_no_net_hint));
        return false;
    }

    private boolean a() {
        if ((TextUtils.isEmpty(LoginHelper.a().i()) ^ 1) != 0) {
            return true;
        }
        Object b = b();
        if (TextUtils.isEmpty(b)) {
            XLToast.showToast(this, getString(R.string.register_please_input_phone_number));
            return false;
        } else if (b.matches("^1[0-9]{10}$")) {
            return true;
        } else {
            XLToast.showToast(this, getString(R.string.register_please_input_correct_phone_number));
            return false;
        }
    }

    static /* synthetic */ void a(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        if (privateSpaceFindPwdActivity.j() && privateSpaceFindPwdActivity.a()) {
            CountDownView countDownView = privateSpaceFindPwdActivity.a;
            if (((long) countDownView.c) <= 0) {
                countDownView.a = InputDeviceCompat.SOURCE_KEYBOARD;
            } else {
                if ((258 == countDownView.a ? 1 : null) != null) {
                    countDownView.a();
                }
                countDownView.a = 258;
                if (countDownView.d == null) {
                    countDownView.d = new com.xunlei.downloadprovider.download.privatespace.widget.a(countDownView, (long) (countDownView.c * 1000), (long) (countDownView.b * 1000));
                }
                countDownView.d.start();
            }
            a aVar = privateSpaceFindPwdActivity.l;
            Object b = privateSpaceFindPwdActivity.b();
            i iVar = privateSpaceFindPwdActivity.p;
            h hVar = privateSpaceFindPwdActivity.m;
            aVar.b = null;
            if (!TextUtils.isEmpty(b)) {
                com.xunlei.downloadprovider.member.payment.network.d bVar = new com.xunlei.downloadprovider.download.privatespace.a.a.b(aVar, hVar);
                if (a.a()) {
                    new g(a.a, iVar).a(bVar);
                } else {
                    new j(a.a, b, iVar).a(bVar);
                }
            } else if (hVar != null) {
                hVar.a(TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR, "请输入手机号");
            }
            privateSpaceFindPwdActivity.p = null;
        }
    }

    static /* synthetic */ void b(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        if (privateSpaceFindPwdActivity.j() && privateSpaceFindPwdActivity.a()) {
            Object obj;
            Object obj2 = null;
            if (TextUtils.isEmpty(privateSpaceFindPwdActivity.c())) {
                XLToast.showToast(privateSpaceFindPwdActivity, privateSpaceFindPwdActivity.getString(R.string.register_please_input_sms_verify_code));
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                String d = privateSpaceFindPwdActivity.d();
                if (TextUtils.isEmpty(d)) {
                    XLToast.showToast(privateSpaceFindPwdActivity, "请输入新的私人空间密码");
                } else {
                    if (d.length() >= 6) {
                        if (d.length() <= 12) {
                            obj2 = 1;
                        }
                    }
                    XLToast.showToast(privateSpaceFindPwdActivity, "密码长度不对");
                }
                if (obj2 != null) {
                    privateSpaceFindPwdActivity.a("密码重置中");
                    if (privateSpaceFindPwdActivity.s) {
                        privateSpaceFindPwdActivity.h();
                    } else {
                        a aVar = privateSpaceFindPwdActivity.l;
                        Object b = privateSpaceFindPwdActivity.b();
                        String c = privateSpaceFindPwdActivity.c();
                        privateSpaceFindPwdActivity = privateSpaceFindPwdActivity.n;
                        if (TextUtils.isEmpty(b)) {
                            if (privateSpaceFindPwdActivity != null) {
                                privateSpaceFindPwdActivity.a(TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR, "请输入手机号");
                            }
                        } else if (aVar.b == null) {
                            if (privateSpaceFindPwdActivity != null) {
                                privateSpaceFindPwdActivity.a(TnetStatusCode.EASY_REASON_HANDSHAKE_ERROR, "请先发送短信验证码");
                            }
                        } else {
                            com.xunlei.downloadprovider.member.payment.network.d cVar = new c(aVar, privateSpaceFindPwdActivity);
                            String str = aVar.b.b;
                            String str2 = aVar.b.a;
                            if (a.a() != null) {
                                new f(a.a, str2, str, c).a(cVar);
                            } else {
                                new com.xunlei.downloadprovider.download.privatespace.a.b.i(a.a, b, str2, str, c).a(cVar);
                            }
                        }
                    }
                }
            }
        }
    }

    static /* synthetic */ void d(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        if (!(TextUtils.isEmpty(privateSpaceFindPwdActivity.b()) || TextUtils.isEmpty(privateSpaceFindPwdActivity.c()))) {
            if (!TextUtils.isEmpty(privateSpaceFindPwdActivity.d())) {
                privateSpaceFindPwdActivity.i.setEnabled(true);
                return;
            }
        }
        privateSpaceFindPwdActivity.i.setEnabled(false);
    }

    static /* synthetic */ void t(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        if (privateSpaceFindPwdActivity.o == null) {
            privateSpaceFindPwdActivity.o = new d(privateSpaceFindPwdActivity);
            privateSpaceFindPwdActivity.o.a = new f(privateSpaceFindPwdActivity);
            privateSpaceFindPwdActivity.o.a(false);
        }
        if (!privateSpaceFindPwdActivity.o.isShowing()) {
            privateSpaceFindPwdActivity.o.show();
        }
    }

    static /* synthetic */ void u(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        if (privateSpaceFindPwdActivity.o != null) {
            privateSpaceFindPwdActivity.o.a();
            privateSpaceFindPwdActivity.o.a(false);
        }
        XLToast.showToast(privateSpaceFindPwdActivity, privateSpaceFindPwdActivity.getString(R.string.register_error_msg_getVerifyFail_retry));
        privateSpaceFindPwdActivity.p = null;
    }
}
