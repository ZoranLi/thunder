package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoActivity;
import com.xunlei.downloadprovider.download.center.widget.DownloadBriefInfoHeaderView.a;
import com.xunlei.downloadprovider.personal.settings.RoomCleanActivity;

/* compiled from: DownloadCenterActivityFragment */
final class ab implements a {
    final /* synthetic */ DownloadCenterActivityFragment a;

    ab(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void a() {
        com.xunlei.downloadprovider.download.control.a.a(this.a.getActivity(), false);
    }

    public final void a(int i, String str) {
        if (b.a() != null) {
            this.a.z = c.a().a(i);
        }
        if (this.a.z != 0) {
            com.xunlei.downloadprovider.cooperation.a.a.b(str, "");
            b.a().a(this.a.getActivity(), this.a.z, "");
        }
    }

    public final void b() {
        com.xunlei.downloadprovider.cooperation.a.a.b(l.c(1004), "");
        RoomCleanActivity.a(this.a.getActivity(), 1004);
    }

    public final void c() {
        com.xunlei.downloadprovider.download.report.a.a("top_kuainiao", false);
        this.a.startActivity(KuaiNiaoActivity.a(this.a.getActivity(), "k_an_shoulei_hytq_xzgl_try"));
    }

    public final void d() {
        com.xunlei.downloadprovider.download.control.a.a(this.a.getActivity(), true);
    }
}
