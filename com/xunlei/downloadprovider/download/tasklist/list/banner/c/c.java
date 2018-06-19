package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.c.a;

/* compiled from: DownloadFreeTrialBanner */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.j == 0) {
            this.a.l.setVisibility(4);
        }
        if (a.a().g) {
            a.a(this.a, view);
        } else {
            a.a(this.a, view, true);
        }
    }
}
