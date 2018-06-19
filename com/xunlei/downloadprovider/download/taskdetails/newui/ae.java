package com.xunlei.downloadprovider.download.taskdetails.newui;

/* compiled from: DownloadDetailsActivityFragment */
final class ae implements Runnable {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public final void run() {
        if (this.a.a.a.H && this.a.a.a.i != null) {
            this.a.a.a.i.b(false);
        }
        this.a.a.a.a(false, this.a.a.a.H);
        this.a.a.a.H = false;
    }
}
