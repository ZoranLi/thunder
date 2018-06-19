package com.xunlei.downloadprovider.personal.a.c;

import com.xunlei.downloadprovider.personal.liked.LikeContentActivity;

/* compiled from: UserFixedBtnViewHolder */
final class r implements Runnable {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        LikeContentActivity.a(this.a.a.itemView.getContext());
    }
}
