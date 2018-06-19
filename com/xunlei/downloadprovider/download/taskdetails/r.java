package com.xunlei.downloadprovider.download.taskdetails;

import android.support.v4.app.FragmentActivity;
import com.xunlei.downloadprovider.download.taskdetails.DownloadCenterDetailFragment.b;

/* compiled from: DownloadCenterDetailFragment */
final class r implements Runnable {
    final /* synthetic */ DownloadCenterDetailFragment a;

    r(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void run() {
        FragmentActivity activity = this.a.getActivity();
        if (activity instanceof b) {
            ((b) activity).a();
        }
    }
}
