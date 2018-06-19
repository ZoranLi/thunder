package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: DownloadTaskNameAndIconView_New */
final class s implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView_New a;

    s(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        this.a = downloadTaskNameAndIconView_New;
    }

    public final void onClick(View view) {
        this.a.O = b.a().a(this.a.G);
        if (this.a.O != null) {
            b.a().a(this.a.G, "dl_center_detail", "click_star", new t(this));
        } else {
            b.a().a(this.a.G, this.a.M.mWebsiteName, "", "dl_center_detail", new u(this));
        }
    }
}
