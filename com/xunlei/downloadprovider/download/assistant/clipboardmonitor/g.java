package com.xunlei.downloadprovider.download.assistant.clipboardmonitor;

/* compiled from: ClipTipViewController */
final class g implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ String d;
    final /* synthetic */ f e;

    g(f fVar, int i, String str, boolean z, String str2) {
        this.e = fVar;
        this.a = i;
        this.b = str;
        this.c = z;
        this.d = str2;
    }

    public final void run() {
        if (this.a == 1) {
            f.a(this.e, this.b, this.c, this.d, null);
        } else {
            f.a(this.e, this.b, this.d);
        }
    }
}
