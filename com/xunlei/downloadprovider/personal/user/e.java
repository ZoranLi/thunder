package com.xunlei.downloadprovider.personal.user;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: FeedBackActivity */
final class e extends WebChromeClient {
    final /* synthetic */ FeedBackActivity a;

    e(FeedBackActivity feedBackActivity) {
        this.a = feedBackActivity;
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        Object extra = webView.getHitTestResult().getExtra();
        if (!TextUtils.isEmpty(extra)) {
            Context context = webView.getContext();
            if (context instanceof FeedBackActivity) {
                a.a();
                a.a(context, extra, false, BrowserFrom.FEEDBACK_PAGE);
            }
        }
        return super.onCreateWindow(webView, z, z2, message);
    }
}
