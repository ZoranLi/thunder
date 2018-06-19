package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.xunlei.downloadprovider.personal.lixianspace.b.o;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.ui.c.i.a;

/* compiled from: LXDownloadEntryFragment */
final class i implements a {
    final /* synthetic */ LXDownloadEntryFragment a;

    i(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void a(LXTaskInfo lXTaskInfo) {
        LXDownloadEntryFragment.a(this.a, "正在删除");
        new com.xunlei.downloadprovider.personal.lixianspace.d.i("lx_tag:default").a(new o(lXTaskInfo), lXTaskInfo.a);
    }
}
