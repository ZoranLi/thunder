package com.xunlei.downloadprovider.personal.lixianspace.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;

/* compiled from: LXBtFileExplorerActivity */
final class a extends b {
    final /* synthetic */ LXBtFileExplorerActivity a;

    a(LXBtFileExplorerActivity lXBtFileExplorerActivity) {
        this.a = lXBtFileExplorerActivity;
    }

    public final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        this.a.b();
        if ((i == 0 ? true : null) == null) {
            XLToast.showToast(this.a, str);
        } else {
            this.a.finish();
        }
    }
}
