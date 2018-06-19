package com.xunlei.downloadprovider.member.login.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.c.j;
import java.util.ArrayList;

public class LoginDlgActivity extends BaseActivity {
    private static boolean o = true;
    private ImageView a;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private RelativeLayout g;
    private ImageView h;
    private TextView i;
    private d j;
    private h k;
    private LoginHelper l = LoginHelper.a();
    private String m;
    private AnimationDrawable n;
    private boolean p;
    private boolean q;
    private boolean r;
    private final Handler s = new Handler();
    private Runnable t;
    private BroadcastReceiver u = new ab(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login_dlg);
        this.j = new af(this);
        this.l.a(this.j);
        this.a = (ImageView) findViewById(R.id.iv_close);
        this.c = (TextView) findViewById(R.id.tv_third_login_weixin);
        this.d = (TextView) findViewById(R.id.tv_third_login_qq);
        this.e = (TextView) findViewById(R.id.tv_phone_login);
        this.f = (TextView) findViewById(R.id.tv_register_account);
        this.g = (RelativeLayout) findViewById(R.id.rl_login_animation_contain);
        this.g.setVisibility(8);
        this.h = (ImageView) findViewById(R.id.iv_login_animation);
        this.i = (TextView) findViewById(R.id.tv_login_msg);
        a(true);
        this.m = getIntent().getStringExtra("login_from");
        bundle = new ac(this);
        this.a.setOnClickListener(bundle);
        this.c.setOnClickListener(bundle);
        this.d.setOnClickListener(bundle);
        this.e.setOnClickListener(bundle);
        this.f.setOnClickListener(bundle);
        c.a((Context) this, "action_finish_login_dialog", this.u);
        String str = this.m;
        StatEvent build = HubbleEventBuilder.build("android_user_login", "user_login_float_show");
        build.add("from", str);
        ai.a(build);
    }

    private void c() {
        a(false);
        this.g.setVisibility(0);
        this.i.setTextColor(Color.parseColor("#979ba1"));
        this.i.setText("   登录中...");
        this.h.setBackgroundResource(R.drawable.login_dialog_animation);
        this.n = (AnimationDrawable) this.h.getBackground();
        this.n.setOneShot(false);
        this.n.start();
    }

    private void d() {
        a(true);
        this.g.setVisibility(8);
        if (this.t != null) {
            this.s.removeCallbacks(this.t);
        }
    }

    private void a(boolean z) {
        if (z) {
            this.c.setClickable(true);
            this.d.setClickable(true);
            this.e.setClickable(true);
            this.f.setClickable(true);
            return;
        }
        this.c.setClickable(false);
        this.d.setClickable(false);
        this.e.setClickable(false);
        this.f.setClickable(false);
    }

    protected void onResume() {
        super.onResume();
        if (this.l.b.b) {
            c();
        } else {
            d();
        }
        int i = 0;
        if (com.xunlei.downloadprovider.member.login.c.h.a().a.getInt(com.xunlei.downloadprovider.member.login.c.h.b(), 0) <= 1) {
            i = 1;
        }
        if (i != 0) {
            o = true;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.l.b(this.j);
    }

    public void finish() {
        super.finish();
        int i = 0;
        overridePendingTransition(0, 0);
        com.xunlei.downloadprovider.personal.message.d.a().c();
        LoginHelper loginHelper = this.l;
        if (!loginHelper.b.b) {
            l lVar = loginHelper.f;
            ArrayList arrayList = new ArrayList(lVar.c);
            while (i < arrayList.size()) {
                ((com.xunlei.downloadprovider.member.login.b.c) arrayList.get(i)).onLoginCanceled(true);
                i++;
            }
            lVar.c.clear();
        }
        c.a(this, this.u);
    }

    static /* synthetic */ void j(LoginDlgActivity loginDlgActivity) {
        loginDlgActivity.k = new ag(loginDlgActivity);
        loginDlgActivity.l.a(loginDlgActivity.k);
    }

    static /* synthetic */ void a(LoginDlgActivity loginDlgActivity, int i) {
        loginDlgActivity.a(false);
        if (loginDlgActivity.n != null) {
            loginDlgActivity.n.stop();
        }
        loginDlgActivity.g.setVisibility(0);
        loginDlgActivity.h.setBackgroundResource(R.drawable.login_animation_3);
        loginDlgActivity.i.setTextColor(Color.parseColor("#f26161"));
        loginDlgActivity.i.setText(j.a(i));
        loginDlgActivity.t = new ah(loginDlgActivity);
        loginDlgActivity.s.postDelayed(loginDlgActivity.t, 2000);
    }
}
