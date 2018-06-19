package com.xunlei.downloadprovider.download.create;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: ClipboardHandler */
final class p implements Runnable {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void run() {
        XLToast.showToast(BrothersApplication.getApplicationInstance(), "您的迅雷口令已失效或不存在！");
    }
}
