package com.xunlei.downloadprovider.download.giftdispatch.widget;

import com.xunlei.common.commonview.XLToast;

/* compiled from: DispatchingItemView */
final class c implements Runnable {
    final /* synthetic */ DispatchingItemView a;

    c(DispatchingItemView dispatchingItemView) {
        this.a = dispatchingItemView;
    }

    public final void run() {
        this.a.g = false;
        XLToast.showToast(this.a.getContext(), "房间信息获取失败，请重试一下");
    }
}
