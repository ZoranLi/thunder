package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.frame.BaseCacheViewFragment;
import com.xunlei.downloadprovider.homepage.choiceness.ui.RefreshPromptView;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import com.xunlei.downloadprovider.web.base.core.CustomWebViewPullToRefreshLayout;
import com.xunlei.downloadprovider.web.base.core.ag;
import com.xunlei.downloadprovider.web.base.f;

public abstract class PullToRefreshWebFragment extends BaseCacheViewFragment {
    protected CustomWebViewPullToRefreshLayout a;
    protected RefreshPromptView b;
    protected CustomWebView c;
    protected String d;
    protected String e;
    protected String f;
    private ag g = new k(this);
    private ag h = new l(this);
    private boolean i = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.d = bundle.getString("url");
            this.e = bundle.getString("from");
            this.f = bundle.getString("title");
        }
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.lx_space_web_fragment, viewGroup, false);
        a(inflate);
        return inflate;
    }

    @CallSuper
    protected void a(View view) {
        this.a = (CustomWebViewPullToRefreshLayout) view.findViewById(R.id.webView);
        this.a.setOnRefreshListener(new j(this));
        this.a.setMode(Mode.DISABLED);
        this.c = (CustomWebView) this.a.getRefreshableView();
        this.c.a(this.h);
        this.b = (RefreshPromptView) view.findViewById(R.id.refresh_prompt);
        this.b.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        this.c.a(this.g);
        if (this.c.getJsInterfaceClientSettings() != null) {
            this.c.getJsInterfaceClientSettings().a("space/space_lixian", "space/space_lixian");
        }
        if (TextUtils.isEmpty(this.d) == null) {
            this.c.a(this.d);
        }
        this.c.setFrom(this.e);
        f.a(this.e, this.d);
    }

    public void onResume() {
        super.onResume();
        this.c.e();
    }

    public void onPause() {
        this.c.f();
        super.onPause();
    }

    public void onDestroy() {
        this.c.d();
        super.onDestroy();
    }

    protected final void c() {
        if (this.a != null) {
            this.a.onRefreshComplete();
        }
    }

    protected final void a(String str) {
        if (this.b != null && !TextUtils.isEmpty(str)) {
            this.b.a(str);
        }
    }

    protected void a() {
        c();
    }

    public final void d() {
        a();
    }

    public boolean onBackPressed() {
        if (this.c != null) {
            this.c.g();
        }
        if (!this.c.h()) {
            return super.onBackPressed();
        }
        this.c.i();
        return true;
    }
}
