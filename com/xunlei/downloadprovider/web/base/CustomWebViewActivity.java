package com.xunlei.downloadprovider.web.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.choiceness.ui.RefreshPromptView;
import com.xunlei.downloadprovider.web.base.core.BaseWebViewActivity;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.CustomWebViewPullToRefreshLayout;
import com.xunlei.downloadprovider.web.base.core.WebTitleBar;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.downloadprovider.web.base.core.ak;
import com.xunlei.xllib.android.XLIntent;

public class CustomWebViewActivity extends BaseWebViewActivity {
    protected WebTitleBar a;
    protected CustomWebViewPullToRefreshLayout c;
    protected RefreshPromptView d;
    protected WebChromeClient e = new c(this);
    private ag i = new a(this);

    protected final void g() {
        if (this.c != null) {
            this.c.onRefreshComplete();
        }
    }

    public void a() {
        super.a();
        setContentView(R.layout.activity_custom_web_view);
        this.c = (CustomWebViewPullToRefreshLayout) findViewById(R.id.webView);
        this.c.setOnRefreshListener(new b(this));
        this.c.setMode(Mode.DISABLED);
        this.f = (CustomWebView) this.c.getRefreshableView();
        this.f.setWebChromeClient(this.e);
        this.f.a(this.i);
        this.d = (RefreshPromptView) findViewById(R.id.refresh_prompt);
        this.d.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        b();
    }

    public void b() {
        this.a = (WebTitleBar) findViewById(R.id.title_bar);
        this.a.a(this.f);
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("title");
            if (!ak.a(stringExtra)) {
                this.a.setTitleText(stringExtra);
            }
        }
    }

    protected final void a(String str) {
        if (this.d != null && !TextUtils.isEmpty(str)) {
            this.d.a(str);
        }
    }

    protected void f_() {
        g();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a.a();
        a.a((Activity) this, i, i2, intent);
    }

    public static void a(Context context, String str, String str2, String str3, Class<? extends CustomWebViewActivity> cls) {
        Intent xLIntent = new XLIntent(context, cls);
        xLIntent.putExtra("from", str);
        xLIntent.putExtra("url", str2);
        xLIntent.putExtra("title", str3);
        if ((context instanceof Activity) == null) {
            xLIntent.addFlags(268435456);
        }
        context.startActivity(xLIntent);
    }
}
