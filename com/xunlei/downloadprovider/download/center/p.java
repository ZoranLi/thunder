package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadCenterActivityFragment */
final class p implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    p(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            if (this.a.h.isShowing() != null) {
                this.a.h.dismiss();
            }
            this.a.h = null;
        }
    }
}
