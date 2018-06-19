package com.xunlei.downloadprovider.homepage.download;

import com.xunlei.downloadprovider.discovery.kuainiao.KuaiNiaoActivity;
import com.xunlei.downloadprovider.homepage.download.DownloadBriefInfoView.a;

/* compiled from: DownloadTabFragment */
final class v implements a {
    final /* synthetic */ DownloadTabFragment a;

    v(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void a() {
        com.xunlei.downloadprovider.download.control.a.a(this.a.getActivity(), false);
    }

    public final void b() {
        com.xunlei.downloadprovider.download.report.a.a("top_kuainiao", false);
        this.a.startActivity(KuaiNiaoActivity.a(this.a.getActivity(), "k_an_shoulei_hytq_xzgl_try"));
    }

    public final void c() {
        com.xunlei.downloadprovider.download.control.a.a(this.a.getActivity(), true);
    }
}
