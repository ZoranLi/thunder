package com.xunlei.downloadprovider.homepage.download.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadTabEditTitleBar */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.d != null) {
            this.a.d.a(false);
            this.a.f.setVisibility(0);
            this.a.g.setVisibility(8);
        }
    }
}
