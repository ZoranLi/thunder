package com.xunlei.downloadprovider.homepage.download.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTabEditTitleBar */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            this.a.f.setVisibility(8);
            this.a.g.setVisibility(0);
            this.a.d.a(true);
        }
    }
}
