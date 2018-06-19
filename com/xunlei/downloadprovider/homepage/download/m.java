package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTabFragment */
final class m implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    m(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        a.a("top_act_start", false);
        this.a.b.b();
        if (this.a.j != null) {
            if (this.a.j.isShowing() != null) {
                this.a.j.dismiss();
            }
            this.a.j = null;
        }
    }
}
