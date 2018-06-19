package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.xunlei.xllib.android.b;

/* compiled from: LongVideoDetailActivity */
final class n extends WebChromeClient {
    final /* synthetic */ LongVideoDetailActivity a;

    n(LongVideoDetailActivity longVideoDetailActivity) {
        this.a = longVideoDetailActivity;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (b.a(this.a) != null && TextUtils.isEmpty(str) == null && "null".equalsIgnoreCase(str) == null) {
            this.a.i = str;
            this.a.d.setText(str);
        }
    }
}
