package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.taskdetails.newui.d.a;

/* compiled from: DownloadDetailsActivityFragment */
final class y implements a {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    y(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a() {
        DownloadDetailsActivityFragment.t(this.a);
    }

    public final void a(int i) {
        if (this.a.i != null && this.a.j) {
            this.a.i.H();
        }
        switch (i) {
            case 1:
                this.a.c();
                return;
            case 2:
                if (this.a.g != 0) {
                    DownloadDetailsActivityFragment.x(this.a);
                    return;
                }
                return;
            case 3:
                DownloadDetailsActivityFragment.y(this.a);
                return;
            case 4:
                DownloadDetailsActivityFragment.z(this.a);
                return;
            case 5:
                if (this.a.f != 0) {
                    this.a.a("dl_more_open_type");
                    if (this.a.getActivity() != 0) {
                        d.a(this.a.getActivity(), this.a.f.mLocalFileName, true);
                        break;
                    }
                }
                break;
            default:
                break;
        }
    }
}
