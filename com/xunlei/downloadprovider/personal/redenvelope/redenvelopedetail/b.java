package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

/* compiled from: RedEnvelopesDetailActivity */
final class b implements Runnable {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    b(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void run() {
        RedEnvelopesDetailActivity.d(this.a, this.a.s);
        this.a.u.postDelayed(this, 60000);
    }
}
