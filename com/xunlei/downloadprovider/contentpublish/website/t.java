package com.xunlei.downloadprovider.contentpublish.website;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: WebsiteDetailFragment */
final class t implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ CommentInfo b;
    final /* synthetic */ WebsiteDetailFragment c;

    t(WebsiteDetailFragment websiteDetailFragment, String str, CommentInfo commentInfo) {
        this.c = websiteDetailFragment;
        this.a = str;
        this.b = commentInfo;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
