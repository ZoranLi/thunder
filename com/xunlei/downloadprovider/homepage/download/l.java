package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTabFragment */
final class l implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    l(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        if (this.a.j != null) {
            if (this.a.j.isShowing() != null) {
                this.a.j.dismiss();
            }
            this.a.j = null;
        }
    }
}
