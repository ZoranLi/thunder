package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTabFragment */
final class n implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    n(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        a.a("top_act_pause", false);
        view = this.a.b;
        com.xunlei.downloadprovider.download.control.a.c();
        if (this.a.j != null) {
            if (this.a.j.isShowing() != null) {
                this.a.j.dismiss();
            }
            this.a.j = null;
        }
    }
}
