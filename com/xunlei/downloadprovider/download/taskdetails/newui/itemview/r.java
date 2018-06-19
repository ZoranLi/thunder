package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.f.a;

/* compiled from: DownloadTaskNameAndIconView_New */
final class r implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView_New a;

    r(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        this.a = downloadTaskNameAndIconView_New;
    }

    public final void onClick(View view) {
        DownloadTaskNameAndIconView_New.a("sniff_view_web", this.a.M);
        a.a("dl_center_detail", this.a.G, false);
        if (this.a.ae != null && this.a.M != null) {
            view = this.a.ae.b();
            if (view != null) {
                this.a.M;
                view.c();
            }
        }
    }
}
