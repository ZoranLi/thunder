package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: DownloadTaskNameAndIconView */
final class g implements OnClickListener {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    g(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void onClick(View view) {
        this.a.O = b.a().a(this.a.J);
        if (this.a.O != null) {
            b.a().a(this.a.J, "dl_center_detail", "click_star", new h(this));
        } else {
            b.a().a(this.a.J, this.a.M.mWebsiteName, "", "dl_center_detail", new i(this));
        }
    }
}
