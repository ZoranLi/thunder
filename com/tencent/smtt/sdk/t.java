package com.tencent.smtt.sdk;

class t implements Runnable {
    final /* synthetic */ s a;

    t(s sVar) {
        this.a = sVar;
    }

    public void run() {
        if (!TbsShareManager.forceLoadX5FromTBSDemo(this.a.b.getContext()) && TbsDownloader.needDownload(this.a.b.getContext(), false)) {
            TbsDownloader.startDownload(this.a.b.getContext());
        }
    }
}
