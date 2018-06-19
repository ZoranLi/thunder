package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;

/* compiled from: HistoryPublishItemFragment */
final class ap implements c<Boolean> {
    final /* synthetic */ BaseVideoInfo a;
    final /* synthetic */ HistoryPublishItemFragment b;

    ap(HistoryPublishItemFragment historyPublishItemFragment, BaseVideoInfo baseVideoInfo) {
        this.b = historyPublishItemFragment;
        this.a = baseVideoInfo;
    }

    public final void onFail(String str) {
        XLToast.showToast(this.b.i, "视频删除失败");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        XLToast.showToast(this.b.i, "视频删除成功");
        HistoryPublishItemFragment.b(this.b, this.a.getVideoId());
    }
}
