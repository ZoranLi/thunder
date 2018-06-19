package com.tencent.smtt.sdk;

class ab implements Runnable {
    final /* synthetic */ aa a;

    ab(aa aaVar) {
        this.a = aaVar;
    }

    public void run() {
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
    }
}
