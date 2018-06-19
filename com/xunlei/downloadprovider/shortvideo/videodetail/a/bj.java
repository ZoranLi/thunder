package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.widget.ImageView;

/* compiled from: TaskCommentItemViewHolderNew */
final class bj implements Runnable {
    final /* synthetic */ ImageView a;
    final /* synthetic */ be b;

    bj(be beVar, ImageView imageView) {
        this.b = beVar;
        this.a = imageView;
    }

    public final void run() {
        this.b.v = -1;
        this.a.setVisibility(8);
    }
}
