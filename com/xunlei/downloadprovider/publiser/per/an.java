package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: HistoryPublishItemFragment */
final class an implements a {
    final /* synthetic */ am a;

    an(am amVar) {
        this.a = amVar;
    }

    public final void a() {
        HistoryPublishItemFragment.a(this.a.b, this.a.a);
    }

    public final void a(String str) {
        XLToast.showToast(this.a.b.i, "删除失败");
    }
}
