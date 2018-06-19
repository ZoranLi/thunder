package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

/* compiled from: ClipTipViewController */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public final void run() {
        if (this.b.a.equals(f.a(this.b.d))) {
            if (!f.c()) {
                f.a(this.b.d, this.a, this.b.b, this.b.c, this.b.a);
            }
        }
    }
}
