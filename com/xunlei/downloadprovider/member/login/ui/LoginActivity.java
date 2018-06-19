package com.xunlei.downloadprovider.member.login.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.message.proguard.k;
import com.xunlei.common.commonview.AnimationDot;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.launch.guide.GuideActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.o;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.n;
import com.xunlei.downloadprovider.member.payment.external.Destination;
import com.xunlei.downloadprovider.member.register.a;
import com.xunlei.downloadprovider.member.register.view.MailBoxAssociateView;
import com.xunlei.xllib.android.XLIntent;
import com.xunlei.xllib.b.b;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends BaseActivity {
    public static boolean c = false;
    private View A;
    private ImageView B;
    private ImageView C;
    private LoginHelper D;
    private d E;
    private h F;
    private String G;
    private boolean H;
    private boolean I = true;
    private boolean J = true;
    private boolean K;
    private boolean L = false;
    private boolean M;
    private String N = "";
    private int O = -1;
    private int P;
    private boolean Q = false;
    private boolean R = false;
    private OnClickListener S = new p(this);
    long a;
    private View d;
    private ImageView e;
    private View f;
    private MailBoxAssociateView g;
    private EditText h;
    private View i;
    private View j;
    private TextView k;
    private View l;
    private TextView m;
    private AnimationDot n;
    private View o;
    private EditText p;
    private ImageView q;
    private View r;
    private ImageView s;
    private ImageView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private EditText x;
    private ImageView y;
    private View z;

    public static void a(Context context, String str, String str2) {
        Intent xLIntent = new XLIntent(context, LoginActivity.class);
        xLIntent.putExtra("login_dialog_register", str2);
        xLIntent.putExtra("login_from", str);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent();
        this.a = System.currentTimeMillis();
        if (bundle.hasExtra("login_from")) {
            this.N = bundle.getExtras().getString("login_from");
            String str = this.N;
            StatEvent build = HubbleEventBuilder.build("android_user_login", "user_login_click");
            build.add("from", str);
            ai.a(build);
        }
        this.R = bundle.getBooleanExtra("is_from_login_dlg", false);
        if ("login_dialog_register".equals(bundle.getStringExtra("login_dialog_register")) != null) {
            a("login_float");
        }
        this.D = LoginHelper.a();
        this.E = new i(this);
        this.D.a(this.E);
        setContentView(R.layout.login);
        this.d = findViewById(R.id.iv_close_login);
        if (c() != null) {
            this.d.setVisibility(4);
        } else {
            this.d.setVisibility(0);
        }
        this.d.setOnClickListener(new a(this));
        this.e = (ImageView) findViewById(R.id.iv_thunder_logo);
        this.v = (TextView) findViewById(R.id.tv_mobile_fast_login);
        this.v.setOnClickListener(new m(this));
        this.r = findViewById(R.id.login_verify_loading_layout);
        this.f = findViewById(R.id.layout_login_edit_text);
        this.g = (MailBoxAssociateView) findViewById(R.id.et_login_account);
        this.h = (EditText) findViewById(R.id.et_password);
        this.j = findViewById(R.id.iv_clear_username);
        this.i = findViewById(R.id.iv_clear_password);
        this.m = (TextView) findViewById(R.id.tv_login);
        this.l = findViewById(R.id.layout_btn_login);
        this.s = (ImageView) findViewById(R.id.iv_icon_account);
        this.t = (ImageView) findViewById(R.id.iv_icon_password);
        this.u = (ImageView) findViewById(R.id.iv_icon_verify_code);
        this.k = (TextView) findViewById(R.id.tv_forget_password);
        this.k.setOnClickListener(new u(this));
        this.j.setOnClickListener(new v(this));
        this.i.setOnClickListener(new w(this));
        this.g.addTextChangedListener(new a(this, this.j));
        this.g.setOnFocusChangeListener(new x(this));
        this.g.setOnClickListener(new y(this));
        this.h.setOnFocusChangeListener(new z(this));
        this.h.addTextChangedListener(new aa(this));
        this.g.setOnEditorActionListener(new b(this));
        this.h.setOnEditorActionListener(new c(this));
        this.l.setOnClickListener(new d(this));
        this.n = (AnimationDot) findViewById(R.id.login_animation_dot);
        this.o = findViewById(R.id.login_verifycode_bg);
        this.p = (EditText) findViewById(R.id.login_verifycode_edit_text);
        this.p.setOnFocusChangeListener(new e(this));
        this.p.addTextChangedListener(new f(this));
        this.q = (ImageView) findViewById(R.id.login_verify_code_image);
        this.q.setOnClickListener(new g(this));
        this.y = (ImageView) findViewById(R.id.thirdlogin_weixin);
        this.y.setOnClickListener(this.S);
        this.z = findViewById(R.id.thirdlogin_weibo);
        this.z.setOnClickListener(this.S);
        this.A = findViewById(R.id.thirdlogin_xiaomi_option);
        this.B = (ImageView) findViewById(R.id.thirdlogin_xiaomi);
        if (l.b() != null) {
            this.A.setVisibility(0);
            StatEvent build2 = HubbleEventBuilder.build("android_login_third", "login_button_show");
            build2.add("login_account", "xiaomi");
            a.a(build2);
        }
        this.B.setOnClickListener(this.S);
        this.C = (ImageView) findViewById(R.id.thirdlogin_qq);
        this.C.setOnClickListener(this.S);
        this.w = (TextView) findViewById(R.id.tv_register);
        this.w.setOnClickListener(new h(this));
        this.x = (EditText) findViewById(R.id.et_empty);
        this.x.requestFocus();
        this.O = -1;
    }

    protected void onResume() {
        super.onResume();
        g();
        if (!this.H) {
            com.xunlei.downloadprovider.member.login.c.h hVar = this.D.i;
            CharSequence string = hVar.a.getString("key_user_account_name", "");
            if (TextUtils.isEmpty(string)) {
                string = b.a(hVar.a.getString("key_user_account_name_v2", ""), "utf-8");
            } else {
                hVar.c(string);
                hVar.a.edit().putString("key_user_account_name", "").apply();
            }
            if (!(string == null || "".equals(string))) {
                this.g.setText(string);
                this.j.setVisibility(4);
                this.s.setImageDrawable(getResources().getDrawable(R.drawable.icon_account));
                this.h.requestFocus();
            }
        }
        if (this.D.b.b) {
            a(true, true);
        } else {
            a(false, com.xunlei.downloadprovider.member.login.b.l.b());
        }
        if (c) {
            c = false;
            d();
        }
    }

    protected void onPause() {
        super.onPause();
        this.H = true;
    }

    protected void onDestroy() {
        this.D.b(this.F);
        this.D.b(this.E);
        super.onDestroy();
        if (this.Q) {
            this.Q = false;
            BrothersApplication.getSingletonInstance().killMyself();
        }
    }

    public void onBackPressed() {
        if (!c()) {
            b();
        } else if (com.xunlei.downloadprovider.member.login.b.l.b()) {
            b();
        } else {
            if (c()) {
                this.O = 1001;
                finish();
                if (!LoginFrom.FORCE_LOGIN_LAUNCH.toString().equals(this.N)) {
                    n.b();
                    this.Q = true;
                    if (VERSION.SDK_INT >= 16) {
                        setResult(0);
                        finishAffinity();
                    }
                }
            }
        }
    }

    private void b() {
        a();
        ai.a(HubbleEventBuilder.build("android_user_login", "user_login_back"));
        if (h()) {
            i();
        } else {
            boolean z = false;
            if (getIntent().hasExtra("bundle_key_is_from_notification")) {
                z = getIntent().getExtras().getBoolean("bundle_key_is_from_notification", false);
            }
            if (z) {
                MainTabActivity.a((Activity) this);
            }
        }
        finish();
    }

    private static boolean c() {
        return com.xunlei.downloadprovider.d.d.a().e.a();
    }

    private void d() {
        a();
        Class cls = (Class) getIntent().getSerializableExtra(Destination.EXTRA_SUCCESS_DESTINATION);
        Intent intent = getIntent();
        if (cls != null) {
            intent.setClass(this, cls);
            startActivity(intent);
        } else if (intent.hasExtra("login_from") && h()) {
            i();
        }
        finish();
    }

    private void b(String str) {
        com.xunlei.downloadprovider.member.register.view.a.a(this, 2, str).a();
    }

    private void a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getString(i));
        stringBuilder.append(k.s);
        stringBuilder.append(this.P);
        stringBuilder.append(k.t);
        b(stringBuilder.toString());
    }

    public final void a(boolean z, boolean z2) {
        if (z) {
            this.j.setVisibility(true);
            this.l.setEnabled(false);
            this.m.setEnabled(false);
            this.m.setText("登录中");
            this.n.show();
            this.g.setTextColor(-7829368);
            this.g.setFocusable(false);
            this.g.setEnabled(false);
            this.h.setTextColor(-7829368);
            this.h.setFocusable(false);
            this.h.setEnabled(false);
            this.v.setEnabled(false);
            this.w.setEnabled(false);
            this.C.setEnabled(false);
            this.y.setEnabled(false);
            this.z.setEnabled(false);
            this.B.setEnabled(false);
            return;
        }
        this.n.hide();
        if (!z2) {
            this.m.setText(true);
            this.g.setTextColor(-16777216);
            this.g.setEnabled(true);
            this.g.setFocusableInTouchMode(true);
            this.h.setTextColor(-16777216);
            this.h.setEnabled(true);
            this.h.setFocusableInTouchMode(true);
            this.v.setEnabled(true);
            this.w.setEnabled(true);
            this.C.setEnabled(true);
            this.y.setEnabled(true);
            this.z.setEnabled(true);
            this.B.setEnabled(true);
        }
    }

    public final void a() {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(this.g.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromWindow(this.h.getWindowToken(), 0);
    }

    private void g() {
        boolean z = false;
        if (TextUtils.isEmpty(this.g.getText().toString().trim()) || this.h.length() <= 0) {
            a(false);
            return;
        }
        if (this.o.getVisibility() != 0 || (this.o.getVisibility() == 0 && this.p.length() > 0)) {
            z = true;
        }
        a(z);
    }

    public void finish() {
        setResult(this.O);
        super.finish();
        if (!c() || com.xunlei.downloadprovider.member.login.b.l.b()) {
            overridePendingTransition(R.anim.activity_slide_in_left, R.anim.activity_slide_out_right);
        }
    }

    private void a(boolean z) {
        this.l.setEnabled(z);
        this.m.setEnabled(z);
    }

    private boolean h() {
        return GuideActivity.class.getSimpleName().equals(this.N);
    }

    private void i() {
        Intent intent = getIntent();
        if (intent == null || !intent.hasExtra("download_url")) {
            MainTabActivity.b(this, "thunder", null);
            return;
        }
        String string = intent.getExtras().getString("download_url");
        String str = "";
        String str2 = "";
        String str3 = "";
        if (intent.hasExtra("download_title")) {
            str = intent.getExtras().getString("download_title");
        }
        if (intent.hasExtra("download_icon_url")) {
            str2 = intent.getExtras().getString("download_icon_url");
        }
        if (intent.hasExtra("download_report")) {
            str3 = intent.getStringExtra("download_report");
        }
        MainTabActivity.a(this, string, str, str2, str3);
    }

    private void a(String str) {
        StatEvent build = HubbleEventBuilder.build("android_phone_register", "phone_register_show");
        build.add("from", str);
        com.xunlei.downloadprovider.member.register.b.a(build);
        str = new Dialog(this, R.style.MMTheme.DataSheet);
        str.requestWindowFeature(1);
        str.setContentView(R.layout.register_panel);
        Window window = str.getWindow();
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.gravity = 80;
        window.setAttributes(attributes);
        window.findViewById(R.id.iv_close_register_panel).setOnClickListener(new n(this, str));
        View findViewById = window.findViewById(R.id.layout_xiaomi_option);
        if (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.equals("Xiaomi")) {
            findViewById.setVisibility(0);
        }
        findViewById = window.findViewById(R.id.weixin_register);
        View findViewById2 = window.findViewById(R.id.weibo_register);
        View findViewById3 = window.findViewById(R.id.qq_register);
        View findViewById4 = window.findViewById(R.id.xiaomi_register);
        View findViewById5 = window.findViewById(R.id.btn_mobile_phone_register);
        findViewById.setOnClickListener(this.S);
        findViewById2.setOnClickListener(this.S);
        findViewById3.setOnClickListener(this.S);
        findViewById4.setOnClickListener(this.S);
        findViewById5.setOnClickListener(new o(this, str));
        TextView textView = (TextView) window.findViewById(R.id.tv_register_protocol);
        CharSequence spannableString = new SpannableString(getString(R.string.register_user_protocol));
        spannableString.setSpan(new s(this), 0, spannableString.length(), 33);
        textView.setText(getString(R.string.register_from_register_userprotocol));
        textView.append(spannableString);
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        str.show();
    }

    static /* synthetic */ void b(LoginActivity loginActivity) {
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a((Context) loginActivity, "http://aq.xunlei.com/wap/forgetPwd.html", loginActivity.getString(R.string.user_forget_pwd), "");
        ai.a(HubbleEventBuilder.build("android_forget_password", "forget_password"));
    }

    static /* synthetic */ void k(LoginActivity loginActivity) {
        if (com.xunlei.xllib.android.b.a(loginActivity)) {
            String trim = loginActivity.g.getText().toString().trim();
            Object trim2 = loginActivity.h.getText().toString().trim();
            Object trim3 = loginActivity.p.getText().toString().trim();
            loginActivity.a();
            if (loginActivity.G == null) {
                loginActivity.G = "";
            }
            LoginHelper loginHelper = loginActivity.D;
            String str = loginActivity.G;
            if (!(TextUtils.isEmpty(trim) || TextUtils.isEmpty(trim2))) {
                loginHelper.c = trim;
                String str2 = "user_login_page";
                if (!TextUtils.isEmpty(trim3)) {
                    str2 = "user_login_has_verify_code";
                }
                String str3 = str2;
                loginHelper.b.b = true;
                loginHelper.b.c = false;
                loginHelper.b.e = false;
                loginHelper.f.a(loginHelper.k);
                com.xunlei.downloadprovider.member.login.b.l.a(trim, trim2, str, trim3, loginHelper.q, str3);
            }
            loginActivity.a(true, false);
            ai.a(HubbleEventBuilder.build("android_user_login", "user_login_submit"));
            return;
        }
        loginActivity.a((int) R.string.user_account_no_net_hint);
        loginActivity.a();
    }

    static /* synthetic */ void m(LoginActivity loginActivity) {
        if (!loginActivity.L) {
            loginActivity.L = true;
            if (loginActivity.M) {
                loginActivity.r.setVisibility(0);
            }
            loginActivity.D.a(new t(loginActivity));
        }
    }

    static /* synthetic */ void q(LoginActivity loginActivity) {
        loginActivity.F = new k(loginActivity);
        loginActivity.D.a(loginActivity.F);
        loginActivity.D.b();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.xunlei.downloadprovider.member.login.ui.LoginActivity r2, int r3) {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "showErrorTipByCode() errorCode=";
        r0.<init>(r1);
        r0.append(r3);
        r1 = " errorDesc=";
        r0.append(r1);
        r1 = com.xunlei.common.new_ptl.member.XLErrorCode.getErrorDesc(r3);
        r0.append(r1);
        r0 = 14;
        if (r3 == r0) goto L_0x00f9;
    L_0x001a:
        r0 = 28;
        if (r3 == r0) goto L_0x00f2;
    L_0x001e:
        r0 = 16781266; // 0x1000fd2 float:2.3521238E-38 double:8.291047E-317;
        if (r3 == r0) goto L_0x00eb;
    L_0x0023:
        r0 = 16781269; // 0x1000fd5 float:2.3521246E-38 double:8.2910485E-317;
        if (r3 == r0) goto L_0x00e4;
    L_0x0028:
        r0 = 16781283; // 0x1000fe3 float:2.3521285E-38 double:8.2910554E-317;
        if (r3 == r0) goto L_0x00e3;
    L_0x002d:
        r0 = 16781290; // 0x1000fea float:2.3521305E-38 double:8.291059E-317;
        if (r3 == r0) goto L_0x00dc;
    L_0x0032:
        switch(r3) {
            case 0: goto L_0x00db;
            case 1: goto L_0x00d4;
            case 2: goto L_0x00cd;
            case 3: goto L_0x00c6;
            case 4: goto L_0x00bf;
            case 5: goto L_0x00b8;
            case 6: goto L_0x009f;
            case 7: goto L_0x0098;
            case 8: goto L_0x0091;
            case 9: goto L_0x008a;
            case 10: goto L_0x0083;
            case 11: goto L_0x007c;
            case 12: goto L_0x0075;
            default: goto L_0x0035;
        };
    L_0x0035:
        switch(r3) {
            case 16781296: goto L_0x006e;
            case 16781297: goto L_0x00e3;
            default: goto L_0x0038;
        };
    L_0x0038:
        switch(r3) {
            case 16781306: goto L_0x0067;
            case 16781307: goto L_0x0066;
            case 16781308: goto L_0x00d4;
            default: goto L_0x003b;
        };
    L_0x003b:
        switch(r3) {
            case 16781310: goto L_0x005f;
            case 16781311: goto L_0x005f;
            default: goto L_0x003e;
        };
    L_0x003e:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r2.D;
        r1 = r1.e;
        r0.append(r1);
        r1 = "(";
        r0.append(r1);
        r0.append(r3);
        r3 = ")";
        r0.append(r3);
        r3 = r0.toString();
        r2.b(r3);
        return;
    L_0x005f:
        r3 = 2131363066; // 0x7f0a04fa float:1.834593E38 double:1.0530332697E-314;
        r2.a(r3);
        return;
    L_0x0066:
        return;
    L_0x0067:
        r3 = 2131363125; // 0x7f0a0535 float:1.834605E38 double:1.053033299E-314;
        r2.a(r3);
        return;
    L_0x006e:
        r3 = 2131363095; // 0x7f0a0517 float:1.834599E38 double:1.053033284E-314;
        r2.a(r3);
        return;
    L_0x0075:
        r3 = 2131363068; // 0x7f0a04fc float:1.8345934E38 double:1.0530332707E-314;
        r2.a(r3);
        return;
    L_0x007c:
        r3 = 2131363063; // 0x7f0a04f7 float:1.8345924E38 double:1.053033268E-314;
        r2.a(r3);
        return;
    L_0x0083:
        r3 = 2131363122; // 0x7f0a0532 float:1.8346044E38 double:1.0530332974E-314;
        r2.a(r3);
        return;
    L_0x008a:
        r3 = 2131363096; // 0x7f0a0518 float:1.8345991E38 double:1.0530332845E-314;
        r2.a(r3);
        return;
    L_0x0091:
        r3 = 2131363117; // 0x7f0a052d float:1.8346034E38 double:1.053033295E-314;
        r2.a(r3);
        return;
    L_0x0098:
        r3 = 2131363061; // 0x7f0a04f5 float:1.834592E38 double:1.0530332673E-314;
        r2.a(r3);
        return;
    L_0x009f:
        r3 = r2.K;
        if (r3 == 0) goto L_0x00b1;
    L_0x00a3:
        r3 = 2131362456; // 0x7f0a0298 float:1.8344693E38 double:1.0530329683E-314;
        r2.a(r3);
        r2 = r2.p;
        r3 = "";
        r2.setText(r3);
        return;
    L_0x00b1:
        r3 = 2131363176; // 0x7f0a0568 float:1.8346153E38 double:1.053033324E-314;
        r2.a(r3);
        return;
    L_0x00b8:
        r3 = 2131363106; // 0x7f0a0522 float:1.8346011E38 double:1.0530332895E-314;
        r2.a(r3);
        return;
    L_0x00bf:
        r3 = 2131363104; // 0x7f0a0520 float:1.8346007E38 double:1.0530332885E-314;
        r2.a(r3);
        return;
    L_0x00c6:
        r3 = 2131363090; // 0x7f0a0512 float:1.834598E38 double:1.0530332816E-314;
        r2.a(r3);
        return;
    L_0x00cd:
        r3 = 2131363060; // 0x7f0a04f4 float:1.8345918E38 double:1.053033267E-314;
        r2.a(r3);
        return;
    L_0x00d4:
        r3 = 2131363105; // 0x7f0a0521 float:1.834601E38 double:1.053033289E-314;
        r2.a(r3);
        return;
    L_0x00db:
        return;
    L_0x00dc:
        r3 = 2131363116; // 0x7f0a052c float:1.8346032E38 double:1.0530332944E-314;
        r2.a(r3);
        return;
    L_0x00e3:
        return;
    L_0x00e4:
        r3 = 2131363081; // 0x7f0a0509 float:1.834596E38 double:1.053033277E-314;
        r2.a(r3);
        return;
    L_0x00eb:
        r3 = 2131363084; // 0x7f0a050c float:1.8345967E38 double:1.0530332786E-314;
        r2.a(r3);
        return;
    L_0x00f2:
        r3 = 2131363123; // 0x7f0a0533 float:1.8346046E38 double:1.053033298E-314;
        r2.a(r3);
        return;
    L_0x00f9:
        r3 = 2131363083; // 0x7f0a050b float:1.8345965E38 double:1.053033278E-314;
        r2.a(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.login.ui.LoginActivity.b(com.xunlei.downloadprovider.member.login.ui.LoginActivity, int):void");
    }

    static /* synthetic */ void b(LoginActivity loginActivity, View view) {
        if (view.requestFocus()) {
            ((InputMethodManager) loginActivity.getSystemService("input_method")).showSoftInput(view, 1);
        }
    }

    static /* synthetic */ void c(LoginActivity loginActivity, String str) {
        if (o.b(str) == null) {
            loginActivity.finish();
        }
    }

    static /* synthetic */ void d(LoginActivity loginActivity, String str) {
        MailBoxAssociateView mailBoxAssociateView = loginActivity.g;
        int indexOf = str.indexOf("@");
        if (indexOf != -1) {
            int i = indexOf + 1;
            if (str.length() > i) {
                String substring = str.substring(i);
                String[] stringArray = loginActivity.getResources().getStringArray(R.array.mail_domain);
                List arrayList = new ArrayList();
                StringBuilder stringBuilder = new StringBuilder("@");
                stringBuilder.append(substring);
                substring = stringBuilder.toString();
                for (String str2 : stringArray) {
                    if (str2.startsWith(substring)) {
                        arrayList.add(str2);
                    }
                }
                stringArray = (String[]) arrayList.toArray(new String[arrayList.size()]);
                if (stringArray.length > 0) {
                    mailBoxAssociateView.a = new com.xunlei.downloadprovider.member.register.view.b(loginActivity, stringArray, str.substring(0, indexOf));
                } else {
                    mailBoxAssociateView.a = null;
                    mailBoxAssociateView.dismissDropDown();
                }
                mailBoxAssociateView.setAdapter(mailBoxAssociateView.a);
            }
        }
        mailBoxAssociateView.a = new com.xunlei.downloadprovider.member.register.view.b(loginActivity, mailBoxAssociateView.getResources().getStringArray(R.array.mail_domain), str.substring(0, str.length() - 1));
        mailBoxAssociateView.setAdapter(mailBoxAssociateView.a);
    }

    static /* synthetic */ void E(LoginActivity loginActivity) {
        if (!loginActivity.I) {
            loginActivity.a((int) R.string.register_error_msg_getVerifyFail_retry);
        }
        loginActivity.I = false;
        loginActivity.q.setImageResource(R.drawable.bg_validcode_fail);
        loginActivity.M = true;
    }
}
