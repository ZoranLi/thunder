package com.xunlei.downloadprovider.web.base.core;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class CustomWebViewPullToRefreshLayout extends PullToRefreshBase<CustomWebView> {
    public CustomWebViewPullToRefreshLayout(Context context) {
        super(context);
    }

    public CustomWebViewPullToRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomWebViewPullToRefreshLayout(Context context, Mode mode) {
        super(context, mode);
    }

    public CustomWebViewPullToRefreshLayout(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    protected boolean isReadyForPullStart() {
        return ((CustomWebView) this.mRefreshableView).getWebViewScrollY() == 0;
    }

    protected boolean isReadyForPullEnd() {
        return ((float) ((CustomWebView) this.mRefreshableView).getWebViewScrollY()) >= ((float) Math.floor((double) (((float) ((CustomWebView) this.mRefreshableView).getContentHeight()) * ((CustomWebView) this.mRefreshableView).getScale()))) - ((float) ((CustomWebView) this.mRefreshableView).getWebViewHeight());
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
        super.onPtrRestoreInstanceState(bundle);
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
        super.onPtrSaveInstanceState(bundle);
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return new CustomWebView(context, attributeSet);
    }
}
