package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.xunlei.downloadprovider.member.payment.ui.a.a.a.a;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;

/* compiled from: LXDownloadEntryFragment */
final class c implements a {
    final /* synthetic */ LXDownloadEntryFragment a;

    c(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void a(com.xunlei.downloadprovider.member.payment.ui.a.a.a aVar, int i) {
        LXDownloadEntryFragment.a(this.a, (LXTaskInfo) aVar.c(i - this.a.e.getHeaderViewsCount()));
    }
}
