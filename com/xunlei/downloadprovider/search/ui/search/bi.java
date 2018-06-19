package com.xunlei.downloadprovider.search.ui.search;

import android.webkit.WebView;
import com.xunlei.downloadprovider.web.base.core.CustomWebView.b;

/* compiled from: SearchOperateActivity */
final class bi implements b {
    final /* synthetic */ SearchOperateActivity a;

    bi(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final void a(WebView webView) {
        SearchOperateActivity.a(this.a, false);
    }

    public final void a() {
        SearchOperateActivity.a(this.a, true);
    }
}
