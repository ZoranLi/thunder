package com.xunlei.downloadprovider.download.taskdetails.items;

import com.xunlei.downloadprovider.download.taskdetails.items.a.b;

/* compiled from: DetailWebSourceInfoViewHolder */
final class v implements Runnable {
    final /* synthetic */ q a;

    v(q qVar) {
        this.a = qVar;
    }

    public final void run() {
        this.a.i.setSelected(true);
        if (this.a.f != null) {
            b c = this.a.f.c();
            if (c != null) {
                c.a(true);
            }
            q.k(this.a);
        }
    }
}
