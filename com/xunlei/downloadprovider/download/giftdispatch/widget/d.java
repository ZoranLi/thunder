package com.xunlei.downloadprovider.download.giftdispatch.widget;

import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: DispatchingItemView */
final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ DispatchingItemView b;

    d(DispatchingItemView dispatchingItemView, String str) {
        this.b = dispatchingItemView;
        this.a = str;
    }

    public final void run() {
        a.a().openUserLivePlayRoom(this.b.getContext(), this.a, XLLiveRoomPlayFrom.SL_DOWNLOAD_GIFT_CLICK);
    }
}
