package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: WebsitePublishActivity */
final class aw extends c {
    final /* synthetic */ WebsitePublishActivity a;

    aw(WebsitePublishActivity websitePublishActivity) {
        this.a = websitePublishActivity;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z) {
            this.a.a();
        }
    }
}
