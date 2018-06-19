package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: DownloadFreeTrialBanner */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.a();
        this.a.d(8);
        a.b(this.a);
        if (this.a.b != null) {
            this.a.b.onClick(view);
        }
        if (this.a.a != null) {
            BannerManager.a().a(false, BannerManager$BannerType.TYPE_FREE_TRIAL, this.a.a.getTaskId(), null);
            a.l("download_bar_try");
            if (com.xunlei.downloadprovider.download.c.a.a().a(this.a.a.getTaskId()) == null) {
                com.xunlei.downloadprovider.download.c.a.a().b(this.a.a.getTaskId(), com.xunlei.downloadprovider.download.c.a.a);
            } else if (this.a.a.mVipChannelStatus == 16) {
                com.xunlei.downloadprovider.download.c.a.a().b(this.a.a.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
            } else {
                if (k.a(this.a.a, k.i(this.a.a)) != null) {
                    com.xunlei.downloadprovider.download.c.a.a().b(this.a.a.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
                } else {
                    com.xunlei.downloadprovider.download.c.a.a().b(this.a.a.getTaskId(), com.xunlei.downloadprovider.download.c.a.b);
                }
            }
        }
    }
}
