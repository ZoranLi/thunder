package com.xunlei.downloadprovider.personal.lixianspace.ui;

import com.xunlei.downloadprovider.member.payment.external.PayAction;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.LXDownloadEntryFragment.a;

/* compiled from: LXSpaceActivity */
final class e implements a {
    final /* synthetic */ LXSpaceActivity a;

    e(LXSpaceActivity lXSpaceActivity) {
        this.a = lXSpaceActivity;
    }

    public final void a() {
        com.xunlei.downloadprovider.personal.lixianspace.c.a.a("black");
        LXSpaceActivity.c(this.a);
    }

    public final void b() {
        com.xunlei.downloadprovider.personal.lixianspace.a.a(this.a, "novip_black", new PayAction(PayUtil$OrderType.OPEN));
    }
}
