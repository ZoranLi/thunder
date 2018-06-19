package com.xunlei.downloadprovider.discovery.kuainiao;

import com.xunlei.common.commonview.XLToast;

/* compiled from: KuaiNiaoFragment */
final class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ KuaiNiaoFragment b;

    c(KuaiNiaoFragment kuaiNiaoFragment, String str) {
        this.b = kuaiNiaoFragment;
        this.a = str;
    }

    public final void run() {
        XLToast.showToast(this.b.mActivity, this.a);
    }
}
