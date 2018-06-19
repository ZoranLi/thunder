package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.taskdetails.newui.aw.a;

/* compiled from: DownloadDetailsActivityFragment */
final class s implements a {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    s(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a(boolean z) {
        if (z) {
            this.a.j();
        } else if (!this.a.f.getTaskStatus()) {
            this.a.H = false;
        } else if (this.a.i) {
            this.a.H = this.a.i.E();
        }
        this.a.G = true;
    }
}
