package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.PullToRefreshBase.d;
import com.xunlei.common.R;

public class PullToRefreshWebView extends PullToRefreshBase<WebView> {
    private static final d<WebView> a = new n();
    private final WebChromeClient b = new o(this);

    @TargetApi(9)
    final class a extends WebView {
        final /* synthetic */ PullToRefreshWebView a;

        public a(PullToRefreshWebView pullToRefreshWebView, Context context, AttributeSet attributeSet) {
            this.a = pullToRefreshWebView;
            super(context, attributeSet);
        }

        protected final boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            c.a(this.a, i, i3, i2, i4, (int) Math.max(0.0d, Math.floor((double) (((float) ((WebView) this.a.mRefreshableView).getContentHeight()) * ((WebView) this.a.mRefreshableView).getScale())) - ((double) ((getHeight() - getPaddingBottom()) - getPaddingTop()))), 2, 1.5f, z);
            return overScrollBy;
        }
    }

    public /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return a(context, attributeSet);
    }

    public PullToRefreshWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnRefreshListener((d) a);
        ((WebView) this.mRefreshableView).setWebChromeClient(this.b);
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }

    public WebView a(Context context, AttributeSet attributeSet) {
        WebView aVar;
        if (VERSION.SDK_INT >= 9) {
            aVar = new a(this, context, attributeSet);
        } else {
            aVar = new WebView(context, attributeSet);
        }
        aVar.setId(R.id.webview);
        return aVar;
    }

    public boolean isReadyForPullStart() {
        return ((WebView) this.mRefreshableView).getScrollY() == 0;
    }

    public boolean isReadyForPullEnd() {
        return ((float) ((WebView) this.mRefreshableView).getScrollY()) >= ((float) Math.floor((double) (((float) ((WebView) this.mRefreshableView).getContentHeight()) * ((WebView) this.mRefreshableView).getScale()))) - ((float) ((WebView) this.mRefreshableView).getHeight());
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
        super.onPtrRestoreInstanceState(bundle);
        ((WebView) this.mRefreshableView).restoreState(bundle);
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
        super.onPtrSaveInstanceState(bundle);
        ((WebView) this.mRefreshableView).saveState(bundle);
    }
}
