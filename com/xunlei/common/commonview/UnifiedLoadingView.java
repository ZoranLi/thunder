package com.xunlei.common.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class UnifiedLoadingView extends FrameLayout {
    public static final int TYPE_BAR = 1;
    public static final int TYPE_PAGE = 2;
    private IWebpageProgress mCurProgressView;
    private SimpleLoadingPageView mPageLoadingView;
    private int mType;
    private WebpageProgressBar mWebPorgressBar;

    public UnifiedLoadingView(Context context) {
        this(context, null);
    }

    public UnifiedLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnifiedLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 2;
        initViews(context);
    }

    private void initViews(Context context) {
        this.mPageLoadingView = new SimpleLoadingPageView(context, SimpleLoadingPageView.TYPE_ALL_WHITE_BG);
        this.mWebPorgressBar = new WebpageProgressBar(context);
        this.mCurProgressView = this.mPageLoadingView;
        addView(this.mWebPorgressBar, new LayoutParams(-1, (int) (context.getResources().getDisplayMetrics().density * 2.0f), 48));
        addView(this.mPageLoadingView, new LayoutParams(-1, -1, 17));
        this.mCurProgressView = this.mPageLoadingView;
        this.mType = 2;
    }

    public void setType(int i) {
        if (this.mType != i) {
            this.mCurProgressView.hide();
            this.mType = i;
            if (this.mType == 1) {
                this.mCurProgressView = this.mWebPorgressBar;
            } else {
                this.mCurProgressView = this.mPageLoadingView;
            }
            this.mCurProgressView.show();
        }
    }

    public void show() {
        super.setVisibility(0);
        this.mCurProgressView.show();
    }

    public void hide() {
        hide(8);
    }

    private void hide(int i) {
        this.mCurProgressView.hide();
        super.setVisibility(i);
    }

    public void setPageLoadingViewBgColor(int i) {
        if (this.mPageLoadingView != null) {
            this.mPageLoadingView.setBackgroundColor(i);
        }
    }

    public void hidePageLoadingViewBack() {
        if (this.mPageLoadingView != null) {
            this.mPageLoadingView.hideBlackBackground();
        }
    }

    public void setContentLayoutParams(int i) {
        LayoutParams layoutParams = (LayoutParams) this.mPageLoadingView.getLayoutParams();
        if (layoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, -2);
            layoutParams2.topMargin = i;
            layoutParams2.gravity = 48;
            this.mPageLoadingView.setLayoutParams(layoutParams2);
            return;
        }
        layoutParams.topMargin = i;
        layoutParams.height = -2;
        layoutParams.gravity = 48;
        requestLayout();
    }

    public void setVisibility(int i) {
        if (i == 0) {
            show();
        } else {
            hide(i);
        }
    }
}
