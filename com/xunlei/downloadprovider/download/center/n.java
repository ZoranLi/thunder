package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterActivityFragment */
final class n implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    n(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        a.a("top_act_delete", false);
        if (this.a.h != null) {
            if (this.a.h.isShowing() != null) {
                this.a.h.dismiss();
            }
            this.a.h = null;
        }
        DownloadCenterActivityFragment.n(this.a);
    }
}
