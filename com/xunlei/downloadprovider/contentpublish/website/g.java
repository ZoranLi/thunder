package com.xunlei.downloadprovider.contentpublish.website;

import android.os.Handler;
import android.os.Message;

/* compiled from: WebsiteDetailFragment */
final class g extends Handler {
    final /* synthetic */ WebsiteDetailFragment a;

    g(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void handleMessage(Message message) {
        if (message.what == 203) {
            this.a.aa[1] = Boolean.valueOf(false);
            this.a.y.b(this.a.E);
        }
    }
}
