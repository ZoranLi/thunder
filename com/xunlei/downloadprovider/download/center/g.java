package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView.b;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;

/* compiled from: DownloadCenterActivityFragment */
final class g implements b {
    final /* synthetic */ DownloadCenterActivityFragment a;

    g(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void a(boolean z) {
        if (z) {
            z = this.a.n;
            if (z.h.m.getCurrentItem() < 3) {
                ((TaskListPageFragment) z.a(z.h.m.getCurrentItem())).d();
            }
            return;
        }
        z = this.a.n;
        if (z.h.m.getCurrentItem() < 3) {
            ((TaskListPageFragment) z.a(z.h.m.getCurrentItem())).e();
        }
        this.a.e.setTitle(this.a.getActivity().getResources().getString(R.string.download_list_select_title));
    }
}
