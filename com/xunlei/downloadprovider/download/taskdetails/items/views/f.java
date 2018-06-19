package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.f.a;

/* compiled from: DownloadTaskNameAndIconView */
final class f implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    f(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void onClick(View view) {
        DownloadTaskNameAndIconView.a("sniff_view_web", this.a.M);
        a.a("dl_center_detail", this.a.J, false);
        if (this.a.af != null && this.a.M != null) {
            view = this.a.af.b();
            if (view != null) {
                this.a.M;
                view.c();
            }
        }
    }
}
