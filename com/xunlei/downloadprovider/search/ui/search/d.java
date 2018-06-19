package com.xunlei.downloadprovider.search.ui.search;

/* compiled from: LoadingUIStatus */
final class d implements Runnable {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        if (this.a.c.d == null || !this.a.c.d.equals(this.a.a)) {
            String str = ab.a;
            new StringBuilder("cancel run key: ").append(this.a.a);
            return;
        }
        this.a.c.c = true;
        if (this.a.c.a != null) {
            if (this.a.c.b != null) {
                this.a.c.b.hide();
                this.a.c.a.run();
                this.a.c.a = null;
                str = ab.a;
                new StringBuilder("post run key: ").append(this.a.a);
            }
        }
    }
}
