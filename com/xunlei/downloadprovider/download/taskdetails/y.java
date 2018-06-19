package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.download.center.widget.DownloadCenterSelectFileTitleView.b;
import java.util.ArrayList;

/* compiled from: DownloadCenterDetailFragment */
final class y implements b {
    final /* synthetic */ DownloadCenterDetailFragment a;

    y(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void a(boolean z) {
        if (this.a.a != null) {
            TaskDetailFragment a = this.a.a;
            if (a.b.a(z)) {
                if (a.c != null) {
                    a.c.notifyDataSetChanged();
                }
                if (a.f != null) {
                    if (z) {
                        a.f.a(a.b.c());
                        return;
                    }
                    a.f.a(new ArrayList());
                }
            }
        }
    }
}
