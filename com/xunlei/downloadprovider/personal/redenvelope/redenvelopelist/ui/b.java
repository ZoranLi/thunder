package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import com.xunlei.common.commonview.XLToast;

/* compiled from: RedEnvelopesActivity */
final class b implements Runnable {
    final /* synthetic */ RedEnvelopesActivity a;

    b(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void run() {
        this.a.m = false;
        XLToast.showToast(this.a, "房间信息获取失败，请重试一下");
    }
}
