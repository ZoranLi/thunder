package com.xunlei.downloadprovider.member.register.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.e;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.personal.user.account.h;
import com.xunlei.downloadprovider.personal.user.account.m;

public class RegisterSuccessActivity extends BaseActivity {
    public static boolean a;
    private int c = 1;
    private StaticHandler d;
    private LoginHelper e;
    private View f;
    private TextView g;
    private View h;
    private View i;
    private ImageView j;
    private EditText k;
    private ImageView l;
    private ImageView m;
    private View n;
    private View o;
    private View p;
    private final int q = 109;
    private String r;
    private boolean s = false;
    private boolean t;
    private h u;
    private k v;
    private e.h w = new at(this);
    private final com.xunlei.downloadprovider.member.login.b.h x = new au(this);
    private MessageListener y = new al(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_register_success);
        a = true;
        this.e = LoginHelper.a();
        this.u = new h(this, getApplicationContext());
        this.f = findViewById(R.id.titlebar_left);
        this.g = (TextView) findViewById(R.id.titlebar_title);
        this.g.setText("完善个人资料");
        this.i = findViewById(R.id.layout_name_and_gender);
        this.h = findViewById(R.id.layout_avatar);
        this.j = (ImageView) findViewById(R.id.iv_user_avatar);
        this.k = (EditText) findViewById(R.id.et_nickname);
        this.l = (ImageView) findViewById(R.id.iv_icon_nickname);
        this.m = (ImageView) findViewById(R.id.iv_clear_nickname);
        this.n = findViewById(R.id.layout_btn_gender_male);
        this.o = findViewById(R.id.layout_btn_gender_female);
        this.p = findViewById(R.id.btn_complete);
        com.xunlei.downloadprovider.personal.user.account.k.a(HubbleEventBuilder.build("android_personal_account", "register_name_gender_show"));
        this.f.setOnClickListener(new ak(this));
        this.j.setOnClickListener(new am(this));
        this.k.addTextChangedListener(new an(this));
        this.k.setOnFocusChangeListener(new ao(this));
        this.m.setOnClickListener(new ap(this));
        bundle = new aq(this);
        this.n.setOnClickListener(bundle);
        this.o.setOnClickListener(bundle);
        this.p.setOnClickListener(new ar(this));
    }

    protected void onResume() {
        super.onResume();
        this.e.a(this.x);
        this.d = new StaticHandler(this.y);
        this.e.l = this.w;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.e.b(this.x);
        this.e.b(this.v);
        a = false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.u.a(i, i2, intent, "phone_register_login");
        this.t = true;
        super.onActivityResult(i, i2, intent);
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.u.getClass();
        if (i == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                m.b(this);
            } else {
                this.u.b("account_center");
            }
        }
    }

    static /* synthetic */ boolean f(RegisterSuccessActivity registerSuccessActivity) {
        if (!registerSuccessActivity.n.isSelected()) {
            if (registerSuccessActivity.o.isSelected() == null) {
                return null;
            }
        }
        return true;
    }

    static /* synthetic */ void b(RegisterSuccessActivity registerSuccessActivity, boolean z) {
        if (z) {
            registerSuccessActivity.n.setSelected(true);
            registerSuccessActivity.o.setSelected(false);
            return;
        }
        registerSuccessActivity.n.setSelected(false);
        registerSuccessActivity.o.setSelected(true);
    }

    static /* synthetic */ String j(RegisterSuccessActivity registerSuccessActivity) {
        if (registerSuccessActivity.n.isSelected()) {
            return "m";
        }
        return registerSuccessActivity.o.isSelected() != null ? f.a : "u";
    }

    static /* synthetic */ void m(RegisterSuccessActivity registerSuccessActivity) {
        registerSuccessActivity.c = 2;
        registerSuccessActivity.h.setVisibility(0);
        registerSuccessActivity.i.setVisibility(8);
        com.xunlei.downloadprovider.personal.user.account.k.a(HubbleEventBuilder.build("android_personal_account", "register_head_change_show"));
    }
}
