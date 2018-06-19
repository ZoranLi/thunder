package com.alibaba.sdk.android.feedback.windvane;

import android.webkit.WebView;
import android.widget.ProgressBar;
import com.alibaba.sdk.android.feedback.xblink.webview.HybridWebChromeClient;

public class CustomWebChromeClient extends HybridWebChromeClient {
    private ProgressBar progressbar;

    public CustomWebChromeClient(ProgressBar progressBar) {
        this.progressbar = progressBar;
    }

    public void onProgressChanged(WebView webView, int i) {
        if (this.progressbar != null) {
            this.progressbar.setProgress(i);
            if (i == 100) {
                this.progressbar.setVisibility(8);
            }
        }
        super.onProgressChanged(webView, i);
    }
}
