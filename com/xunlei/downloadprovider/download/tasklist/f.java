package com.xunlei.downloadprovider.download.tasklist;

/* compiled from: TaskListPageFragment */
final class f implements Runnable {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void run() {
        if (this.a.b.d != null && this.a.a > 0) {
            this.a.a = 0;
            if (this.a.b.d.e < this.a.b.r.a()) {
                this.a.b.l();
            }
            this.a.b.d.notifyDataSetChanged();
            new StringBuilder("notifyDataSetChanged - PageIndex = ").append(this.a.b.b);
        }
    }
}
