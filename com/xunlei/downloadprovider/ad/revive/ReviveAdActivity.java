package com.xunlei.downloadprovider.ad.revive;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO;
import com.xunlei.downloadprovider.ad.common.i;
import com.xunlei.downloadprovider.ad.common.report.j;
import com.xunlei.downloadprovider.ad.splash.a.a;
import com.xunlei.downloadprovider.ad.splash.a.q;
import com.xunlei.downloadprovider.ad.splash.b.b;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.d.e;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.downloadprovider.service.DownloadService.c;
import com.xunlei.xllib.android.XLIntent;

public class ReviveAdActivity extends BaseActivity implements OnClickListener, c {
    public static final String a = "ReviveAdActivity";
    private ViewGroup c;
    private View d;
    private a e = null;
    private i f = null;
    private boolean g = false;

    public final void a(DownloadService downloadService) {
    }

    public void onBackPressed() {
    }

    public void onClick(View view) {
    }

    public static void a(Context context) {
        a(context, false);
    }

    public static void a(Context context, boolean z) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(context, ReviveAdActivity.class);
        xLIntent.setFlags(1073741824);
        xLIntent.putExtra("is_from_fake_exit_app", z);
        context.startActivity(xLIntent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().setFormat(-3);
        setContentView(R.layout.activity_revive_ad);
        a();
        this.c = (ViewGroup) findViewById(R.id.view_gdt_splash);
        this.d = findViewById(R.id.include_default_loading_img_start);
        this.d.setVisibility(0);
        if (this.g != null) {
            bundle = 2;
        } else {
            boolean z = true;
        }
        int i = bundle;
        if (d.a().p.b() == null) {
            com.xunlei.downloadprovider.ad.common.report.a.a("launch ad switch off");
            finish();
            return;
        }
        b.a(i);
        if (com.xunlei.xllib.android.b.a(this) == null) {
            j.b(THUNDER_AD_INFO.SPLASH.getPositionId(), -17, "无网络");
            finish();
            return;
        }
        this.f = new i(Math.max(e.a().e.b(), 3));
        this.f.a(new a(this));
        this.f.a();
        this.e = new q(i, this, this.c, new b(this), this.f);
        this.e.e();
    }

    protected void onResume() {
        super.onResume();
        new StringBuilder("DownloadService.getInstance() == null: ").append(DownloadService.a() == null);
        if (DownloadService.a() == null) {
            DownloadService.a(this);
        } else {
            DownloadService.a();
        }
        if (this.e != null) {
            this.e.f();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.e != null) {
            this.e.g();
        }
    }

    protected void onStop() {
        super.onStop();
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().e = -1;
        com.xunlei.downloadprovider.ad.revive.a.a.a.a().d = -1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.e != null) {
            this.e.h();
        }
        if (this.f != null) {
            this.f.a.clear();
            this.f.d.cancel();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a();
    }

    private void a() {
        if (getIntent() != null) {
            this.g = getIntent().getBooleanExtra("is_from_fake_exit_app", false);
        }
    }

    static /* synthetic */ void b(ReviveAdActivity reviveAdActivity) {
        reviveAdActivity.c.setVisibility(0);
        reviveAdActivity.d.setVisibility(8);
    }
}
