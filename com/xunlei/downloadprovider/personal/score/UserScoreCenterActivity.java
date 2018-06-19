package com.xunlei.downloadprovider.personal.score;

import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.personal.user.b;
import com.xunlei.downloadprovider.personal.user.f;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.WebTitleBar;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

public class UserScoreCenterActivity extends BaseActivity {
    private WebTitleBar a;
    private CustomWebView c;
    private UnifiedLoadingView d;
    private ErrorBlankView e;
    private boolean f;
    private boolean g;
    private StaticHandler h;
    private MessageListener i = new a(this);

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_user_score_center);
        this.a = (WebTitleBar) findViewById(R.id.web_title_bar_score_center);
        this.c = (CustomWebView) findViewById(R.id.webView_score_center);
        this.d = (UnifiedLoadingView) findViewById(R.id.loading_view_score_center);
        this.e = (ErrorBlankView) findViewById(R.id.ev_show_score_center);
        bundle = getIntent();
        this.g = bundle.getBooleanExtra("key_is_signed_in", false);
        this.f = bundle.getBooleanExtra("key_is_need_request_signed_info", false);
        this.h = new StaticHandler(this.i);
        this.a.a(this.c);
        this.a.setTitleText(getString(R.string.user_center_score_item_title));
        a();
        d();
    }

    private void a() {
        if (this.f) {
            b();
        } else {
            c();
        }
    }

    private void b() {
        h.a().a(new b(this), h.b());
    }

    private void c() {
        if (!this.g) {
            h.a().a(new c(this), h.c());
        }
    }

    private void d() {
        if (this.g) {
            XLThreadPool.execute(new l(h.a(), new d(this)));
        }
    }

    public void onBackPressed() {
        if (this.c == null || !this.c.h()) {
            super.onBackPressed();
        } else {
            this.c.i();
        }
    }

    static /* synthetic */ void a(UserScoreCenterActivity userScoreCenterActivity, Bundle bundle) {
        if (bundle != null) {
            userScoreCenterActivity.d.hide();
            int i = bundle.getInt("extra_signed");
            bundle = bundle.getInt("extra_continues_sign");
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            userScoreCenterActivity.g = z;
            if (userScoreCenterActivity.g) {
                p pVar = new p(userScoreCenterActivity, bundle);
                pVar.show();
                pVar.a.setOnClickListener(new e(userScoreCenterActivity, pVar, bundle));
                pVar.b.setOnClickListener(new f(userScoreCenterActivity, pVar, bundle));
                bundle = String.valueOf(bundle);
                StatEvent build = HubbleEventBuilder.build("android_personal_click", "per_sign_alert");
                build.add("days", bundle);
                f.a(build);
                userScoreCenterActivity.d();
                b.a().b();
            }
        }
    }

    static /* synthetic */ void a(UserScoreCenterActivity userScoreCenterActivity) {
        userScoreCenterActivity.d.hide();
        userScoreCenterActivity.e.setErrorType(2);
        userScoreCenterActivity.e.setVisibility(0);
        userScoreCenterActivity.e.a("刷新", new g(userScoreCenterActivity));
    }

    static /* synthetic */ void b(UserScoreCenterActivity userScoreCenterActivity, Bundle bundle) {
        if (bundle != null) {
            String string = bundle.getString("extra_dui_ba_result");
            String string2 = bundle.getString("extra_dui_ba_url");
            if (ITagManager.SUCCESS.equals(string)) {
                userScoreCenterActivity.d.hide();
                if (!TextUtils.isEmpty(string2)) {
                    userScoreCenterActivity.c.setVisibility(0);
                    userScoreCenterActivity.c.a(string2);
                }
            }
        }
    }

    static /* synthetic */ void b(UserScoreCenterActivity userScoreCenterActivity) {
        userScoreCenterActivity.c();
        userScoreCenterActivity.d();
        userScoreCenterActivity.f = false;
        if (userScoreCenterActivity.g != null) {
            b.a().b();
        }
    }
}
