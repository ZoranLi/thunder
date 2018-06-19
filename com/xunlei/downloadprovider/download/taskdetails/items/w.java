package com.xunlei.downloadprovider.download.taskdetails.items;

import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailWebSourceInfoViewHolder */
final class w implements Runnable {
    final /* synthetic */ q a;

    w(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        this.a.i.setSelected(false);
        if (this.a.f != null) {
            b c = this.a.f.c();
            if (c != null) {
                c.a(false);
            }
            q.k(this.a);
        }
    }
}
