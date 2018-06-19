package com.xunlei.downloadprovider.loading;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.ad.splash.a.a;
import com.xunlei.downloadprovider.ad.splash.a.q;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.frame.MainTabActivity;
import com.xunlei.downloadprovider.frame.MainTabSpec$Tab;
import com.xunlei.downloadprovider.h.j;
import com.xunlei.downloadprovider.launch.LaunchActivity;
import com.xunlei.downloadprovider.launch.e.b;
import com.xunlei.downloadprovider.launch.guide.GuideActivity;
import com.xunlei.downloadprovider.publiser.common.guide.a.e;
import com.xunlei.downloadprovider.publiser.common.guide.a.h;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.downloadprovider.pushmessage.p;
import com.xunlei.xllib.android.XLIntent;

public class LoadingActivity extends BaseActivity {
    public static final String a = "com.xunlei.downloadprovider.loading.LoadingActivity";
    public boolean c = false;
    private View d;
    private ViewGroup e;
    private View f;
    private ImageView g;
    private View h;
    private ImageView i;
    private boolean j;
    private boolean k = false;
    private a l = null;
    private i m = null;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o.a((Context) this);
        if (LaunchActivity.a == null) {
            startActivity(new XLIntent((Context) this, LaunchActivity.class));
            finish();
            return;
        }
        bundle = com.xunlei.downloadprovider.ad.revive.a.a.a.a();
        long currentTimeMillis = System.currentTimeMillis();
        bundle.b = c.a() == 0;
        bundle.a = currentTimeMillis;
        BrothersApplication.sLaunchAnalysisReport.c = SystemClock.elapsedRealtime();
        new StringBuilder("traceLoadingActivityCreate:").append(b.a());
        bundle = new StringBuilder();
        bundle.append(BrothersApplication.timeTag());
        bundle.append(" onCreate ");
        getWindow().setFlags(1024, 1024);
        if (j.c(this) != null) {
            j.a(getWindow());
        }
        getWindow().setFormat(-3);
        setContentView(R.layout.loadingactivity);
        this.d = findViewById(R.id.loading_layout);
        this.e = (ViewGroup) findViewById(R.id.view_gdt_splash);
        this.f = findViewById(R.id.bottom_layout);
        this.f.setVisibility(8);
        this.g = (ImageView) findViewById(R.id.loading_img_start);
        this.h = findViewById(R.id.include_default_loading_img_start);
        this.i = (ImageView) findViewById(R.id.loading_first);
        this.i.setVisibility(8);
        c.c(this);
        p.a();
        bundle = com.xunlei.downloadprovider.publiser.common.guide.a.a();
        bundle.a = com.xunlei.downloadprovider.publiser.common.guide.a.b();
        com.xunlei.downloadprovider.publiser.common.guide.a.a bVar = new com.xunlei.downloadprovider.publiser.common.guide.a.b();
        bVar.a(new e());
        bVar.a(new h());
        bVar.a(new com.xunlei.downloadprovider.publiser.common.guide.a.i());
        bundle.b = bVar;
        bundle.b.a(bundle.a);
        bundle.a.a(bundle.b);
        bundle.a.a();
        if (this.d.getBackground() == null) {
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            this.h.setVisibility(0);
            if (com.xunlei.downloadprovider.launch.d.a.b() != -1) {
                this.i.setVisibility(0);
                this.i.setImageResource(com.xunlei.downloadprovider.launch.d.a.b());
                return;
            }
            this.i.setVisibility(8);
        }
    }

    private boolean a() {
        StringBuilder stringBuilder = new StringBuilder("jumpWhenCanClick this.hasWindowFocus():");
        stringBuilder.append(hasWindowFocus());
        stringBuilder.append("  can jump: ");
        stringBuilder.append(this.c);
        if (this.c) {
            b();
            return true;
        }
        this.c = true;
        return false;
    }

    public void onResume() {
        super.onResume();
        if (!this.k) {
            this.k = true;
            if (!com.xunlei.downloadprovider.ad.revive.a.a.a.a().b) {
                com.xunlei.downloadprovider.ad.revive.a.a.a.a().c = System.currentTimeMillis();
            }
            if (c.b()) {
                com.xunlei.downloadprovider.ad.common.report.a.a("guide image");
            } else if (d.a().p.b()) {
                com.xunlei.downloadprovider.ad.splash.b.b.a(0);
                if (com.xunlei.xllib.android.b.a(this)) {
                    this.m = new i(Math.max(com.xunlei.downloadprovider.d.e.a().e.b(), 3));
                    this.m.a(new a(this));
                    this.m.a();
                    this.l = new q(0, this, this.e, new b(this), this.m);
                    this.l.e();
                } else {
                    com.xunlei.downloadprovider.ad.common.report.j.b(THUNDER_AD_INFO.SPLASH.getPositionId(), -17, "无网络");
                    b();
                }
            } else {
                com.xunlei.downloadprovider.ad.common.report.a.a("launch ad switch off");
                b();
            }
            BrothersApplication.sLaunchAnalysisReport.d = SystemClock.elapsedRealtime();
            new StringBuilder("traceLoadingActivityDisplay:").append(b.a());
        }
        this.j = true;
        if (c.b()) {
            if (c.c()) {
                startActivity(new XLIntent((Context) this, GuideActivity.class));
                finish();
                overridePendingTransition(R.anim.translate_between_interface_right_in, R.anim.translate_between_interface_left_out);
                BrothersApplication.sLaunchAnalysisReport.b();
            } else if (com.xunlei.downloadprovider.launch.guide.a.a.a()) {
                b();
            }
        }
        if (!a() && this.l != null) {
            this.l.f();
        }
    }

    protected void onPause() {
        super.onPause();
        this.j = false;
        this.c = false;
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().c = -1;
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().d = -1;
        if (this.l != null) {
            this.l.g();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        moveTaskToBack(1);
        return false;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.l != null) {
            this.l.h();
        }
        com.xunlei.downloadprovider.ad.splash.c.a.b();
        if (this.m != null) {
            this.m.a.clear();
            this.m.d.cancel();
        }
    }

    private void b() {
        new StringBuilder("doGoToMainTab isActivityVisible: ").append(this.j);
        MainTabActivity.b(this, MainTabSpec$Tab.THUNDER.getTag(), null);
        BrothersApplication.sLaunchAnalysisReport.b();
        c.d();
        finish();
    }

    static /* synthetic */ void c(LoadingActivity loadingActivity) {
        loadingActivity.i.setVisibility(8);
        loadingActivity.d.setVisibility(8);
        loadingActivity.e.setVisibility(0);
        loadingActivity.f.setVisibility(0);
    }
}
