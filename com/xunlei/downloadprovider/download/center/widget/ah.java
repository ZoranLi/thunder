package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTaskMoreOperationDialog */
final class ah implements OnClickListener {
    final /* synthetic */ af a;

    ah(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        a.b("share", a.a(this.a.g), this.a.j);
        this.a.dismiss();
        if (this.a.h != null) {
            this.a.h.a(this.a.g, "", "", "", null);
        }
    }
}
