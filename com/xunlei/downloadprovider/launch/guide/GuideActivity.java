package com.xunlei.downloadprovider.launch.guide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.launch.guide.b.b;
import com.xunlei.downloadprovider.launch.guide.b.c;
import com.xunlei.downloadprovider.launch.guide.b.e;
import com.xunlei.downloadprovider.launch.guide.p.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.LoginHelper.LoginPageType;
import com.xunlei.downloadprovider.member.login.b.e$a;
import com.xunlei.downloadprovider.member.login.ui.LoginActivity;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.register.ui.AuthMobileActivity;
import com.xunlei.downloadprovider.xlui.widget.extendviewpager.CircleIndicator;
import com.xunlei.downloadprovider.xlui.widget.extendviewpager.autoscrollviewpager.AutoScrollViewPager;
import com.xunlei.xllib.android.XLIntent;

public class GuideActivity extends BaseActivity implements p$b {
    private static final String a = "GuideActivity";
    private a c = null;
    private AutoScrollViewPager d = null;
    private n e = null;
    private CircleIndicator f = null;
    private TextView g = null;
    private ViewStub h = null;
    private OnPageChangeListener i = new c(this);

    public void onBackPressed() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        if (j.c(this) != null) {
            j.a(getWindow());
        }
        setContentView(R.layout.guide_activity);
        bundle = new m(new l(), this);
        this.d = (AutoScrollViewPager) findViewById(R.id.view_pager_guide);
        this.f = (CircleIndicator) findViewById(R.id.indicator_guide);
        this.g = (TextView) findViewById(R.id.btn_guide_skip);
        this.h = (ViewStub) findViewById(R.id.view_stub_bottom);
        this.e = new n(this, this, this.c);
        this.e.c();
        this.d.setInterval(2000);
        this.d.setAutoScrollDurationFactor(3.0d);
        this.d.addOnPageChangeListener(this.i);
        this.d.setAdapter(this.e);
        this.f.setViewPager(this.d);
        this.g.setOnClickListener(new b(this));
        this.c.a();
    }

    protected void onResume() {
        super.onResume();
        this.c.b();
    }

    protected void onPause() {
        super.onPause();
        this.c.c();
    }

    protected void onDestroy() {
        super.onDestroy();
        this.c.e();
        if (this.d != null) {
            this.d.removeOnPageChangeListener(this.i);
        }
    }

    public void finish() {
        super.finish();
        this.c.d();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.c.a(i, i2);
    }

    public final void a(int i) {
        this.g.setVisibility(i);
    }

    public final void a() {
        MainTabActivity.b(this, "thunder", null);
        finish();
    }

    public final void a(String str, String str2, String str3, String str4) {
        MainTabActivity.a(this, str, str2, str3, str4);
        finish();
    }

    public final void b() {
        LoginHelper.a().a(LoginPageType.LOGIN_PAGE, (Context) this, null, LoginFrom.GUIDE_PAGE, -1, null);
        finish();
    }

    public final void b(String str, String str2, String str3, String str4) {
        Intent xLIntent = new XLIntent((Context) this, LoginActivity.class);
        xLIntent.putExtra("login_from", getClass().getSimpleName());
        xLIntent.putExtra("download_url", str);
        xLIntent.putExtra("download_title", str2);
        xLIntent.putExtra("download_icon_url", str3);
        xLIntent.putExtra("download_report", str4);
        startActivity(xLIntent);
        finish();
    }

    public final void a(e$a com_xunlei_downloadprovider_member_login_b_e_a) {
        LoginHelper.a().a(com_xunlei_downloadprovider_member_login_b_e_a, LoginFrom.GUIDE.toString(), "install_guide");
    }

    public final void b(e$a com_xunlei_downloadprovider_member_login_b_e_a) {
        LoginHelper.a().b(com_xunlei_downloadprovider_member_login_b_e_a, LoginFrom.GUIDE.toString(), "install_guide");
    }

    public final void c() {
        Intent xLIntent = new XLIntent((Context) this, AuthMobileActivity.class);
        xLIntent.putExtra("from", "");
        startActivityForResult(xLIntent, 1000);
    }

    public final void a(a aVar) {
        this.c = aVar;
    }

    public final void a(boolean z) {
        if (z) {
            z = new b(this, this.h, this.c);
        } else {
            z = new c(this, this.h, this.c);
        }
    }

    public final void b(int i) {
        if (i == this.d.getCurrentItem()) {
            this.c.a(this.e.b(i));
        }
        this.d.setCurrentItem(i);
    }

    public final void d() {
        Class cls = e.class;
        int childCount = this.d.getChildCount();
        new StringBuilder("refreshItemClass: ").append(cls.getName());
        for (int i = 0; i < childCount; i++) {
            View childAt = this.d.getChildAt(i);
            StringBuilder stringBuilder = new StringBuilder("childView.getClass(): ");
            stringBuilder.append(childAt.getClass().getName());
            stringBuilder.append(" childView.getClass() == refreshItemClass: ");
            stringBuilder.append(childAt.getClass() == cls);
            if ((childAt instanceof com.xunlei.downloadprovider.launch.guide.b.a) && childAt.getClass() == cls) {
                ((com.xunlei.downloadprovider.launch.guide.b.a) childAt).a(i);
            }
        }
    }

    public final void g() {
        this.d.a();
    }

    public final void h() {
        this.d.b();
    }
}
