package com.xunlei.downloadprovider.member.register.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
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
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.common.register.XLRegisterUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.e.c;
import com.xunlei.downloadprovider.member.login.b.e.g;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.android.b;
import java.io.ByteArrayOutputStream;

public class MobileSetupActivity extends BaseActivity {
    private g A = new u(this);
    protected d a = new t(this);
    private TitleBar c;
    private EditText d;
    private TextView e;
    private TextView f;
    private EditText g;
    private EditText h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private View l;
    private View m;
    private TextView n;
    private ProgressDialog o;
    private String p;
    private int q;
    private String r;
    private long s = 0;
    private String t = "";
    private boolean u;
    private String v = "";
    private String w = "";
    private com.xunlei.downloadprovider.member.register.view.d x;
    private a y;
    private c z;

    private static class a {
        volatile boolean a = false;
        Handler b;
        Thread c;

        public interface a {
            void a(int i);
        }

        public a(a aVar) {
            this.b = new ai(this, Looper.getMainLooper(), aVar);
            this.c = new Thread(new aj(this));
        }
    }

    protected void a(TextView textView) {
    }

    public static void a(Context context, int i, String str) {
        a(context, i, str, "");
    }

    public static void a(Context context, int i, String str, String str2) {
        Intent xLIntent = new XLIntent(context, MobileSetupActivity.class);
        xLIntent.putExtra("type", i);
        xLIntent.putExtra("login_from", str);
        xLIntent.putExtra("phone_number", str2);
        if ((context instanceof LoginActivity) != 0) {
            xLIntent.putExtra("from", "login_home");
        } else if ((context instanceof MobileSetupActivity) != 0) {
            xLIntent.putExtra("from", "register_alert");
        }
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.mobile_login_regesiter_layout);
        XLRegisterUtil.getInstance().init(this, 40, "5.60.2.5510", AndroidConfig.getHubbleDeviceGUID(BrothersApplication.getApplicationInstance()), "34a062aaa22f906fca4fefe9fb3a3021", false);
        bundle = getIntent();
        int i = 0;
        this.q = bundle.getIntExtra("type", 0);
        this.p = bundle.getStringExtra("login_from");
        if (this.p == null) {
            this.p = "";
        }
        this.r = bundle.getStringExtra("phone_number");
        this.d = (EditText) findViewById(R.id.et_phone_num);
        this.e = (TextView) findViewById(R.id.tv_send_verify_code);
        this.f = (TextView) findViewById(R.id.tv_time_count_down);
        this.g = (EditText) findViewById(R.id.et_verify_code);
        this.l = findViewById(R.id.btn_submit);
        this.n = (TextView) findViewById(R.id.tv_register_protocol);
        if (this.q == 1) {
            if (this.r != null && "".equals(this.r) == null) {
                this.d.setText(this.r);
                this.d.setSelection(this.r.length());
            }
            this.n.setVisibility(0);
            bundle = this.n;
            CharSequence spannableString = new SpannableString(getString(R.string.register_user_protocol));
            spannableString.setSpan(new r(this), 0, spannableString.length(), 33);
            bundle.setText(getString(R.string.register_from_register_userprotocol));
            bundle.append(spannableString);
            bundle.setHighlightColor(0);
            bundle.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            this.n.setVisibility(8);
        }
        this.m = findViewById(R.id.iv_clear_verify_code);
        bundle = findViewById(R.id.layout_register_password);
        if (this.q != 2) {
            i = 8;
        }
        bundle.setVisibility(i);
        this.h = (EditText) findViewById(R.id.et_register_password);
        this.i = (ImageView) findViewById(R.id.iv_icon_mobile);
        this.j = (ImageView) findViewById(R.id.iv_icon_verify_code);
        this.k = (ImageView) findViewById(R.id.iv_icon_password);
        this.e.setOnClickListener(new aa(this));
        this.l.setOnClickListener(new ab(this));
        this.m.setOnClickListener(new ac(this));
        this.d.addTextChangedListener(new ad(this));
        this.d.setOnFocusChangeListener(new ae(this));
        this.g.setOnFocusChangeListener(new af(this));
        this.g.addTextChangedListener(new ag(this));
        this.h.setOnFocusChangeListener(new ah(this));
        this.c = new TitleBar((Activity) this);
        this.c.mLeft.setOnClickListener(new s(this));
        this.c.mTitle.setText(a());
        a(this.c.mRight1);
        LoginHelper.a().a(this.a);
    }

    protected void b() {
        this.r = this.d.getText().toString();
        this.g.setText("");
        b((int) R.string.register_msg_sending_sms_waiting);
        a("", true);
    }

    protected void c() {
        String d = d();
        String g = g();
        Object obj = this.h.getText().toString();
        if (i()) {
            if (this.q == 1) {
                LoginHelper a = LoginHelper.a();
                XLUserUtil.getInstance().userMobileLogin(d, g, this.w, a.q, "user_login_mms");
                a.f.a(a.k);
                b((int) R.string.register_msg_ing_waiting_login);
            } else if (TextUtils.isEmpty(obj)) {
                a((int) R.string.user_account_pwd_empty_hint);
            } else {
                LoginHelper a2 = LoginHelper.a();
                XLUserUtil.getInstance().userMobileRegister(d, g, this.w, obj, true, a2.q, null);
                b((int) R.string.register_msg_ing_waiting);
            }
        }
    }

    @NonNull
    protected final String d() {
        return this.d.getText().toString();
    }

    @NonNull
    protected final String g() {
        return this.g.getText().toString();
    }

    protected String a() {
        return getString(this.q == 2 ? R.string.register_mobilephone : R.string.login_mobile);
    }

    protected void onResume() {
        super.onResume();
        n();
        LoginHelper.a().p = this.A;
    }

    protected void onStop() {
        super.onStop();
        h();
        LoginHelper.a().p = null;
        XLRegisterUtil.getInstance().uninit();
    }

    protected void onDestroy() {
        super.onDestroy();
        LoginHelper.a().b(this.a);
        if (this.y != null) {
            this.y.a = true;
        }
    }

    private void k() {
        this.z = new v(this);
    }

    private void l() {
        if (this.x != null) {
            this.x.dismiss();
        }
    }

    final void a(String str) {
        com.xunlei.downloadprovider.member.register.view.a.a(this, 1, str).a();
    }

    private void b(String str) {
        h();
        com.xunlei.downloadprovider.member.register.view.a.a(this, 2, str).a();
    }

    protected final void a(int i) {
        b(getString(i));
    }

    protected final void b(int i) {
        h();
        this.o = new ProgressDialog(this);
        this.o.setProgressStyle(0);
        this.o.setMessage(getResources().getString(i));
        this.o.setCancelable(false);
        this.o.show();
    }

    protected final void h() {
        if (this.o != null) {
            this.o.dismiss();
            this.o = null;
        }
    }

    protected final boolean i() {
        if (b.a(this)) {
            return true;
        }
        a((int) R.string.user_account_no_net_hint);
        return false;
    }

    private boolean m() {
        Object d = d();
        if (TextUtils.isEmpty(d)) {
            b(getString(R.string.register_please_input_phone_number));
            return false;
        } else if (d.matches("^1[0-9]{10}$")) {
            return true;
        } else {
            b(getString(R.string.register_please_input_correct_phone_number));
            return false;
        }
    }

    private void a(String str, boolean z) {
        if (i()) {
            if (z) {
                b((int) true);
            }
            int i = 1;
            if (this.q) {
                i = 0;
            }
            int i2 = i;
            z = LoginHelper.a();
            XLUserUtil.getInstance().userMobileSendMessage(this.r, i2, this.v, str, z.q, null);
        }
    }

    protected final void j() {
        this.y = new a(new z(this));
        this.y.c.start();
    }

    private void a(View view) {
        if (view.requestFocus()) {
            ((InputMethodManager) getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    private void b(View view) {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void n() {
        if (this.d.getText().length() > 0) {
            if (this.g.getText().length() > 0) {
                this.l.setEnabled(true);
            } else {
                this.l.setEnabled(false);
            }
            this.e.setEnabled(true);
            return;
        }
        this.l.setEnabled(false);
        this.e.setEnabled(false);
    }

    static /* synthetic */ void a(MobileSetupActivity mobileSetupActivity, View view) {
        mobileSetupActivity.b(view);
        if (mobileSetupActivity.m() != null) {
            if (TextUtils.isEmpty(mobileSetupActivity.g()) != null) {
                mobileSetupActivity.b(mobileSetupActivity.getString(R.string.register_please_input_sms_verify_code));
                view = null;
            } else {
                view = true;
            }
            if (view != null) {
                mobileSetupActivity.c();
                if (mobileSetupActivity.q == 2) {
                    com.xunlei.downloadprovider.member.register.b.a(HubbleEventBuilder.build("android_phone_register", "phone_reg_submit"));
                }
            }
        }
        mobileSetupActivity.h();
        if (mobileSetupActivity.q == 2) {
            com.xunlei.downloadprovider.member.register.b.a(HubbleEventBuilder.build("android_phone_register", "phone_reg_submit"));
        }
    }

    static /* synthetic */ void a(MobileSetupActivity mobileSetupActivity, int i, String str, String str2) {
        mobileSetupActivity.h();
        if (i == 0) {
            mobileSetupActivity.w = str2;
            mobileSetupActivity.g.requestFocus();
            mobileSetupActivity.j();
            if (!(mobileSetupActivity.x == null || mobileSetupActivity.x.isShowing() == null)) {
                mobileSetupActivity.a("请继续输入短信验证码！");
            }
            mobileSetupActivity.l();
        } else if (i == 6) {
            if (!(mobileSetupActivity.x == null || mobileSetupActivity.x.isShowing() == null)) {
                mobileSetupActivity.x.dismiss();
            }
            mobileSetupActivity.x = new com.xunlei.downloadprovider.member.register.view.d(mobileSetupActivity);
            mobileSetupActivity.x.a = new w(mobileSetupActivity);
            mobileSetupActivity.x.show();
            mobileSetupActivity.k();
            LoginHelper.a().a(mobileSetupActivity.z);
        } else if (i != 33) {
            mobileSetupActivity.l();
            mobileSetupActivity.b(str);
        } else if (mobileSetupActivity.x != null) {
            str = mobileSetupActivity.x;
            com.xunlei.downloadprovider.member.register.view.a.a(str.getContext(), mobileSetupActivity.getResources().getString(R.string.login_verifycode_error));
            str.b();
            mobileSetupActivity.k();
            LoginHelper.a().a(mobileSetupActivity.z);
        }
        if (i == 0) {
            if (mobileSetupActivity.q == 2) {
                com.xunlei.downloadprovider.member.register.b.a("1", "");
            } else {
                com.xunlei.downloadprovider.member.register.b.b("1", "");
            }
        } else if (mobileSetupActivity.q == 2) {
            com.xunlei.downloadprovider.member.register.b.a("0", String.valueOf(i));
        } else {
            com.xunlei.downloadprovider.member.register.b.b("0", String.valueOf(i));
        }
    }

    static /* synthetic */ void a(MobileSetupActivity mobileSetupActivity, int i, String str) {
        boolean z = mobileSetupActivity.q == 1;
        long c = LoginHelper.a().g.c();
        String c2 = LoginHelper.a().c();
        if (i != 0) {
            mobileSetupActivity.b(str);
        } else {
            mobileSetupActivity.s = c;
            mobileSetupActivity.t = c2;
            mobileSetupActivity.u = true;
            if (!z) {
                com.xunlei.downloadprovider.member.register.b.b(mobileSetupActivity.p);
            }
        }
        if (i == 33) {
            mobileSetupActivity.g.setText("");
            mobileSetupActivity.a(mobileSetupActivity.g);
        }
        if (i != 0) {
            StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_login_fail");
            build.add("failtype", i);
            com.xunlei.downloadprovider.member.register.b.a(build);
        }
    }

    static /* synthetic */ void b(MobileSetupActivity mobileSetupActivity, int i, String str) {
        long c = LoginHelper.a().g.c();
        String c2 = LoginHelper.a().c();
        Object obj = 1;
        if (mobileSetupActivity.q != 1) {
            obj = null;
        }
        mobileSetupActivity.h();
        if (i == 0) {
            mobileSetupActivity.s = c;
            mobileSetupActivity.t = c2;
            if (obj == null) {
                com.xunlei.downloadprovider.member.register.b.b(mobileSetupActivity.p);
            }
            mobileSetupActivity.startActivity(new XLIntent(mobileSetupActivity, RegisterSuccessActivity.class));
            mobileSetupActivity.finish();
        } else if (i != 34) {
            mobileSetupActivity.b(str);
        } else {
            mobileSetupActivity.h();
            str = new XLAlertDialog(mobileSetupActivity);
            str.setTitle((CharSequence) "注册失败");
            str.setMessage((CharSequence) "该手机号已注册，请使用手机快捷登录");
            TextView textView = (TextView) str.findViewById(R.id.dlg_content);
            TextView textView2 = (TextView) str.findViewById(R.id.dlg_cancel_btn);
            TextView textView3 = (TextView) str.findViewById(R.id.dlg_confirm_btn);
            ((TextView) str.findViewById(R.id.dlg_title)).setTextSize(17.0f);
            textView.setTextSize(14.0f);
            textView2.setTextSize(15.0f);
            textView3.setTextSize(15.0f);
            str.setCancelButtonText((CharSequence) "取消");
            str.setConfirmButtonText((CharSequence) "手机快捷登录");
            str.setOnClickCancelButtonListener(new x(mobileSetupActivity));
            str.setOnClickConfirmButtonListener(new y(mobileSetupActivity));
            str.show();
        }
        if (i == 33) {
            mobileSetupActivity.g.setText("");
            mobileSetupActivity.a(mobileSetupActivity.g);
        }
        if (i != 0) {
            StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_register_fail");
            build.add("failtype", i);
            com.xunlei.downloadprovider.member.register.b.a(build);
        }
    }

    static /* synthetic */ void a(MobileSetupActivity mobileSetupActivity, int i, byte[] bArr, String str) {
        if (i == 0 && bArr != null) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != 0) {
                decodeByteArray.compress(CompressFormat.JPEG, 50, new ByteArrayOutputStream());
                if (mobileSetupActivity.x != null) {
                    mobileSetupActivity.x.a(decodeByteArray);
                }
                mobileSetupActivity.v = str;
                return;
            }
        }
        if (mobileSetupActivity.x != 0) {
            mobileSetupActivity.x.a();
        }
        mobileSetupActivity.a((int) R.string.register_error_msg_getVerifyFail_retry);
        mobileSetupActivity.v = 0;
    }

    static /* synthetic */ void a(MobileSetupActivity mobileSetupActivity, int i) {
        if (i > 0) {
            mobileSetupActivity.f.setText(String.format("%s秒后重新获取", new Object[]{Integer.valueOf(i)}));
            mobileSetupActivity.f.setVisibility(0);
            mobileSetupActivity.e.setVisibility(8);
            return;
        }
        mobileSetupActivity.f.setVisibility(8);
        mobileSetupActivity.e.setVisibility(0);
    }
}
