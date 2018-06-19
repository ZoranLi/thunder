package com.xunlei.downloadprovider.download.giftdispatch;

import com.xunlei.downloadprovider.download.giftdispatch.utils.a.a;
import java.util.List;

/* compiled from: GiftDispatchingActivity */
final class b implements a {
    final /* synthetic */ GiftDispatchingActivity a;

    b(GiftDispatchingActivity giftDispatchingActivity) {
        this.a = giftDispatchingActivity;
    }

    public final void a(List<com.xunlei.downloadprovider.download.giftdispatch.a.a> list) {
        this.a.runOnUiThread(new c(this, list));
    }

    public final void a() {
        this.a.runOnUiThread(new d(this));
    }

    public final void b() {
        this.a.runOnUiThread(new e(this));
    }
}
