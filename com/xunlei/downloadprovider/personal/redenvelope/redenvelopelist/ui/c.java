package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: RedEnvelopesActivity */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ RedEnvelopesActivity b;

    c(RedEnvelopesActivity redEnvelopesActivity, String str) {
        this.b = redEnvelopesActivity;
        this.a = str;
    }

    public final void run() {
        a.a().openUserLivePlayRoom(this.b, this.a, XLLiveRoomPlayFrom.SL_DOWNLOAD_GIFT_CLICK);
    }
}
