package com.xunlei.downloadprovider.personal.redenvelope.redenvelopedetail;

import com.xunlei.common.commonview.XLToast;

/* compiled from: RedEnvelopesDetailActivity */
final class h implements Runnable {
    final /* synthetic */ RedEnvelopesDetailActivity a;

    h(RedEnvelopesDetailActivity redEnvelopesDetailActivity) {
        this.a = redEnvelopesDetailActivity;
    }

    public final void run() {
        this.a.w = false;
        XLToast.showToast(this.a, "房间信息获取失败，请重试一下");
    }
}
