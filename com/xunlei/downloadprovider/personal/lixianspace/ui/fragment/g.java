package com.xunlei.downloadprovider.personal.lixianspace.ui.fragment;

import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import java.util.List;

/* compiled from: LXDownloadEntryFragment */
final class g extends b {
    final /* synthetic */ LXDownloadEntryFragment a;

    g(LXDownloadEntryFragment lXDownloadEntryFragment) {
        this.a = lXDownloadEntryFragment;
    }

    public final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        if (this.a.isAlive()) {
            LXDownloadEntryFragment.a(this.a, lXTaskInfo, i, str);
        }
    }

    public final void b(List<LXTaskInfo> list, int i) {
        if (this.a.isAlive() != 0) {
            LXDownloadEntryFragment.a(this.a, (List) list);
        }
    }

    public final void a(long j, int i) {
        if (this.a.isAlive()) {
            LXDownloadEntryFragment.a(this.a, j, i);
        }
    }

    public final void a() {
        if (this.a.isAlive()) {
            this.a.c();
        }
    }

    public final void a(List<LXTaskInfo> list, int i) {
        if (this.a.isAlive()) {
            LXDownloadEntryFragment.a(this.a, (List) list, i);
        }
    }
}
