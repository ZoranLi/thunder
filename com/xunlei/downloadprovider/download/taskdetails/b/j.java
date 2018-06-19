package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.downloadprovider.comment.entity.CommentInfo;

/* compiled from: TaskCommentController */
final class j implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ CommentInfo b;
    final /* synthetic */ b c;

    j(b bVar, String str, CommentInfo commentInfo) {
        this.c = bVar;
        this.a = str;
        this.b = commentInfo;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
