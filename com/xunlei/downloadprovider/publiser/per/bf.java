package com.xunlei.downloadprovider.publiser.per;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.c;

/* compiled from: HistoryPublishVideoItemViewHolder */
final class bf implements c<Boolean> {
    final /* synthetic */ be a;

    bf(be beVar) {
        this.a = beVar;
    }

    public final void onFail(String str) {
        XLToast.showToast(this.a.a, "视频删除失败");
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        XLToast.showToast(this.a.a, "视频删除成功");
        this.a.b.d.b(this.a.b.e);
        this.a.b.b.a(13, null);
    }
}
