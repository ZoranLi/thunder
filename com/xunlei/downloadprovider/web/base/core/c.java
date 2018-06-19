package com.xunlei.downloadprovider.web.base.core;

import android.os.Handler;
import android.os.Message;

/* compiled from: CustomWebView */
final class c extends Handler {
    final /* synthetic */ CustomWebView a;

    c(CustomWebView customWebView) {
        this.a = customWebView;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                CustomWebView.a(this.a);
                return;
            case 2:
                CustomWebView.b(this.a);
                break;
            default:
                break;
        }
    }
}
