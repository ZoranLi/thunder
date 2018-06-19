package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadDetailsActivityFragment */
final class ab implements OnClickListener {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    ab(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onClick(View view) {
        if (this.a.getContext() != null) {
            this.a.z.a(this.a.getContext());
        }
    }
}
