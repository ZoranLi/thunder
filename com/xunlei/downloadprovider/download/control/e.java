package com.xunlei.downloadprovider.download.control;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

/* compiled from: DownloadCenterControl */
public final class e implements OnClickListener {
    final /* synthetic */ List a;
    final /* synthetic */ a b;

    public e(a aVar, List list) {
        this.b = aVar;
        this.a = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        p.a().a(this.a, true);
    }
}
