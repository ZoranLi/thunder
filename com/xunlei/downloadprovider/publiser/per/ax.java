package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.downloadprovider.member.payment.a.e.a;
import com.xunlei.downloadprovider.publiser.common.recommendfollow.j;

/* compiled from: HistoryPublishItemFragment */
final class ax implements a {
    final /* synthetic */ HistoryPublishItemFragment a;

    ax(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final void a() {
        j.a(this.a.c, "success", "", "shortvideo_usercenter_auto");
        if (this.a.q != null) {
            this.a.q.e.setText("已关注");
            this.a.h.postDelayed(new ay(this), 500);
        }
    }

    public final void a(String str) {
        j.a(this.a.c, "fail", str, "shortvideo_usercenter_auto");
    }
}
