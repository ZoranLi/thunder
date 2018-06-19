package com.xunlei.downloadprovider.homepage.recommend;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.choiceness.ui.RefreshPromptView;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter.RefreshType;
import com.xunlei.downloadprovider.homepage.recommend.feed.p;
import com.xunlei.downloadprovider.homepage.recommend.feed.q;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

/* compiled from: SummaryMoviesFeedView */
public final class b extends FrameLayout {
    q a;
    a b = new a(this.n);
    boolean c;
    private SummaryMoviesListFragment d;
    private ErrorBlankView e;
    private RefreshPromptView f;
    private PullToRefreshListView g;
    private p h;
    private p i;
    private Handler j = new Handler();
    private e<ListView> k;
    private com.xunlei.downloadprovider.player.a.a l = new com.xunlei.downloadprovider.player.a.a(getContext());
    private RefreshType m = RefreshType.manul_pull;
    private a.a n = new n(this);

    public final void setRefreshType(RefreshType refreshType) {
        this.m = refreshType;
    }

    public b(Context context, SummaryMoviesListFragment summaryMoviesListFragment) {
        super(context);
        this.d = summaryMoviesListFragment;
        context = getContext();
        this.g = new PullToRefreshListView(context);
        this.g.setLayoutParams(new LayoutParams(-1, -1));
        this.g.setMode(Mode.PULL_FROM_START);
        this.g.a = true;
        ((ListView) this.g.getRefreshableView()).setDividerHeight(0);
        this.a = new q(context, (ListView) this.g.getRefreshableView(), this.b, this.l);
        this.g.setAdapter(this.a);
        this.g.setScrollingWhileRefreshingEnabled(true);
        this.g.setDividerDrawable(null);
        this.g.setShowDividers(0);
        this.g.getLoadingLayoutProxy().setBgColorForRefreshingView(R.color.common_content_bkg_color);
        ((ListView) this.g.getRefreshableView()).setDividerHeight(0);
        addView(this.g);
        this.e = new ErrorBlankView(context);
        this.e.setVisibility(8);
        this.e.setActionButtonListener(new c(this));
        this.e.setOnTouchListener(new d(this));
        addView(this.e);
        summaryMoviesListFragment = new RefreshPromptView(context);
        summaryMoviesListFragment.setBackgroundColor(Color.parseColor("#f2dceffe"));
        summaryMoviesListFragment.setTextColor(Color.parseColor("#1294f6"));
        summaryMoviesListFragment.setTextSize(12.0f);
        summaryMoviesListFragment.setSingleLine(true);
        summaryMoviesListFragment.setGravity(17);
        summaryMoviesListFragment.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        addView(summaryMoviesListFragment, new ViewGroup.LayoutParams(-1, DipPixelUtil.dip2px(37.0f)));
        this.f = summaryMoviesListFragment;
        this.l.a = (ViewGroup) this.g.getRefreshableView();
        this.h = new e(this);
        this.i = new h(this);
        ((ListView) this.g.getRefreshableView()).setOnTouchListener(new k(this));
        this.g.setOnRefreshListener(new l(this));
        this.g.setOnScrollListener(new m(this));
    }

    public final void a() {
        if (this.g != null && this.g.getRefreshableView() != null) {
            this.g.c();
        }
    }

    static /* synthetic */ void a(b bVar, boolean z, boolean z2, int i) {
        StringBuilder stringBuilder = new StringBuilder("onRefreshComplete--isPullUpRefresh=");
        stringBuilder.append(z);
        stringBuilder.append("|isRefreshSuccess=");
        stringBuilder.append(z2);
        stringBuilder.append("|size=");
        stringBuilder.append(i);
        bVar.m = RefreshType.manul_pull;
        bVar.a.isEmpty();
        bVar.g.onRefreshComplete();
        bVar.b.a = false;
        if (z2) {
            if (i >= 8) {
                bVar.g.setFooterNeedShow(true);
            } else {
                bVar.g.setFooterNeedShow(false);
            }
            bVar.a.a(com.xunlei.downloadprovider.homepage.recommend.feed.a.a().d);
        }
        Context context = bVar.getContext();
        boolean a = com.xunlei.xllib.android.b.a(context);
        if (bVar.a.isEmpty()) {
            if (a) {
                bVar.e.setErrorType(0);
            } else {
                bVar.e.setErrorType(2);
            }
            bVar.e.setVisibility(0);
        } else {
            bVar.e.setVisibility(8);
        }
        if (!bVar.a.isEmpty()) {
            if (!a) {
                XLToast.showNoNetworkToast(context);
            } else if (z2) {
                if (!z) {
                    if (i != 0) {
                        bVar.f.a(i);
                        return;
                    }
                }
                bVar.f.a();
            } else {
                XLToast.showToast(context, "网络异常");
            }
        }
    }
}
