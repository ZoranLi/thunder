package com.xunlei.downloadprovider.web.browser.a;

import com.tencent.smtt.sdk.DownloadListener;

/* compiled from: XLWebDownloadListener */
public class g implements DownloadListener {
    public DownloadListener a;

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        if (this.a != null) {
            this.a.onDownloadStart(str, str2, str3, str4, j);
        }
    }
}
