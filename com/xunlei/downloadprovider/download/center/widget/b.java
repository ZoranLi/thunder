package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadBriefInfoHeaderView */
final class b implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ String b;
    final /* synthetic */ DownloadBriefInfoHeaderView c;

    b(DownloadBriefInfoHeaderView downloadBriefInfoHeaderView, int i, String str) {
        this.c = downloadBriefInfoHeaderView;
        this.a = i;
        this.b = str;
    }

    public final void onClick(View view) {
        if (this.c.J != null) {
            this.c.J.a(this.a, this.b);
        }
    }
}
