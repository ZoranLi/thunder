package com.xunlei.downloadprovider.download.giftdispatch;

import com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog.ResultType;

/* compiled from: GiftDispatchingActivity */
final class e implements Runnable {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        this.a.a.p.hide();
        this.a.a.s = ResultType.give_out;
        this.a.a.a();
    }
}
