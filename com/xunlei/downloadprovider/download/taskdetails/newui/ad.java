package com.xunlei.downloadprovider.download.taskdetails.newui;

/* compiled from: DownloadDetailsActivityFragment */
final class ad implements Runnable {
    final /* synthetic */ ac a;

    ad(ac acVar) {
        this.a = acVar;
    }

    public final void run() {
        this.a.a.g.h();
        if (this.a.a.getActivity() != null) {
            this.a.a.getActivity().runOnUiThread(new ae(this));
        }
    }
}
