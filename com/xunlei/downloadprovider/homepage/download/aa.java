package com.xunlei.downloadprovider.homepage.download;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.download.center.widget.z;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTabFragment */
final class aa implements OnClickListener {
    final /* synthetic */ String a;
    final /* synthetic */ z b;
    final /* synthetic */ DownloadTabFragment c;

    aa(DownloadTabFragment downloadTabFragment, String str, z zVar) {
        this.c = downloadTabFragment;
        this.a = str;
        this.b = zVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        a.d("cancel", this.a);
        this.b.dismiss();
    }
}
