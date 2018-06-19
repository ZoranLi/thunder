package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Handler;
import android.os.Message;

/* compiled from: WebsiteEditActivity */
final class an extends Handler {
    final /* synthetic */ WebsiteEditActivity a;

    an(WebsiteEditActivity websiteEditActivity) {
        this.a = websiteEditActivity;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            WebsiteEditActivity.a(this.a);
        }
    }
}
