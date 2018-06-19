package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: HistoryPublishWebsiteViewHolder */
final class bl implements a {
    final /* synthetic */ bk a;

    bl(bk bkVar) {
        this.a = bkVar;
    }

    public final void a() {
        XLToast.showToast(this.a.a, "删除成功");
        this.a.b.c.b(this.a.b.d);
        this.a.b.a.a(13, null);
    }

    public final void a(String str) {
        XLToast.showToast(this.a.a, "删除失败");
    }
}
