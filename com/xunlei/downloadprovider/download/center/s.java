package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;

/* compiled from: DownloadCenterActivityFragment */
final class s implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    s(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        PrivateSpaceMgr.a(this.a.getActivity(), "top_act_btn");
        if (this.a.h != null) {
            if (this.a.h.isShowing() != null) {
                this.a.h.dismiss();
            }
            this.a.h = null;
        }
    }
}
