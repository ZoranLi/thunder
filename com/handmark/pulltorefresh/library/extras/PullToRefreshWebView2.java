package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2 extends PullToRefreshWebView {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final AtomicBoolean b = new AtomicBoolean(false);

    public PullToRefreshWebView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final WebView a(Context context, AttributeSet attributeSet) {
        return super.a(context, attributeSet);
    }

    protected boolean isReadyForPullStart() {
        ((WebView) getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
        return this.a.get();
    }

    protected boolean isReadyForPullEnd() {
        ((WebView) getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
        return this.b.get();
    }

    protected /* synthetic */ View createRefreshableView(Context context, AttributeSet attributeSet) {
        return super.a(context, attributeSet);
    }
}
