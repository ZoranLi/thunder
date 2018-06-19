package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

/* compiled from: RedEnvelopesActivity */
final class l implements Runnable {
    final /* synthetic */ RedEnvelopesActivity a;

    l(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void run() {
        RedEnvelopesActivity.o(this.a);
        this.a.q.postDelayed(this, 60000);
    }
}
