package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadDetailsActivityFragment */
final class ai implements OnClickListener {
    final /* synthetic */ z a;
    final /* synthetic */ DownloadDetailsActivityFragment b;

    ai(DownloadDetailsActivityFragment downloadDetailsActivityFragment, z zVar) {
        this.b = downloadDetailsActivityFragment;
        this.a = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.b.f != null) {
            a.d("cancel", this.b.f.mCreateOrigin);
        }
        this.a.dismiss();
    }
}
