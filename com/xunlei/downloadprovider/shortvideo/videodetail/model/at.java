package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: ShortMovieDetailDataLoader */
final class at implements Runnable {
    final /* synthetic */ CommentInfo a;
    final /* synthetic */ as b;

    at(as asVar, CommentInfo commentInfo) {
        this.b = asVar;
        this.a = commentInfo;
    }

    public final void run() {
        if (this.b.e.a != null) {
            this.b.e.a.a(this.a);
        }
    }
}
