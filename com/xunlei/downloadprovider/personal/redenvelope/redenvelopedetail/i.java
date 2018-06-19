package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: RedEnvelopesDetailActivity */
final class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ RedEnvelopesDetailActivity b;

    i(RedEnvelopesDetailActivity redEnvelopesDetailActivity, String str) {
        this.b = redEnvelopesDetailActivity;
        this.a = str;
    }

    public final void run() {
        a.a().openUserLivePlayRoom(this.b, this.a, XLLiveRoomPlayFrom.SL_DOWNLOAD_GIFT_CLICK);
    }
}
