package com.xunlei.downloadprovider.download.giftdispatch;

import com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog.ResultType;

/* compiled from: GiftDispatchingActivity */
final class a implements com.xunlei.downloadprovider.download.giftdispatch.widget.GetGiftAlertDialog.a {
    final /* synthetic */ GiftDispatchingActivity a;

    a(GiftDispatchingActivity giftDispatchingActivity) {
        this.a = giftDispatchingActivity;
    }

    public final void a() {
        this.a.finish();
    }

    public final void b() {
        if (this.a.s.equals(ResultType.get_failed)) {
            this.a.b();
            com.xunlei.downloadprovider.download.giftdispatch.utils.a.a().a(this.a.r);
            return;
        }
        if (this.a.s.equals(ResultType.give_out)) {
            this.a.finish();
        }
    }

    public final void c() {
        this.a.finish();
    }
}
