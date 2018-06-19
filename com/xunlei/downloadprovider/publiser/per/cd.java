package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: PublisherActivity */
final class cd implements a {
    final /* synthetic */ PublisherActivity a;

    public final void a() {
    }

    cd(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void a(String str) {
        if (this.a.isFinishing() == null) {
            XLToast.showToast(this.a, "取消关注失败，请重试");
            this.a.b(true);
        }
    }
}
