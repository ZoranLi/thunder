package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;

/* compiled from: DownloadTabFragment */
final class o implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    o(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        PrivateSpaceMgr.a(this.a.getActivity(), "top_act_btn");
        if (this.a.j != null) {
            if (this.a.j.isShowing() != null) {
                this.a.j.dismiss();
            }
            this.a.j = null;
        }
    }
}
