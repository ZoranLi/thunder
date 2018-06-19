package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.xunlei.downloadprovider.personal.lixianspace.b.u;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.d.i;
import com.xunlei.downloadprovider.personal.lixianspace.ui.c.k.a;

/* compiled from: LXDownloadEntryFragment */
final class h implements a {
    final /* synthetic */ LXDownloadEntryFragment a;

    h(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void a(LXTaskInfo lXTaskInfo) {
        LXDownloadEntryFragment.b(this.a, lXTaskInfo);
    }

    public final void b(LXTaskInfo lXTaskInfo) {
        LXDownloadEntryFragment.a(this.a, "正在创建");
        new i("lx_tag:default").a(new u(lXTaskInfo), lXTaskInfo.a);
    }
}
