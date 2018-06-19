package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: ShortMovieDetailFragment */
final class bd implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ CommentInfo b;
    final /* synthetic */ ShortMovieDetailFragment c;

    bd(ShortMovieDetailFragment shortMovieDetailFragment, String str, CommentInfo commentInfo) {
        this.c = shortMovieDetailFragment;
        this.a = str;
        this.b = commentInfo;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
