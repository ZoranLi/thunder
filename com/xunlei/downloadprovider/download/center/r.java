package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterActivityFragment */
final class r implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    r(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        a.a("top_act_pause", false);
        view = this.a.d;
        com.xunlei.downloadprovider.download.control.a.c();
        if (this.a.h != null) {
            if (this.a.h.isShowing() != null) {
                this.a.h.dismiss();
            }
            this.a.h = null;
        }
    }
}
