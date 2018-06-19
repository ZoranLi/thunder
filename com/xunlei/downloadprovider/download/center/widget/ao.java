package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.util.a;

/* compiled from: DownloadTaskMoreOperationDialog */
final class ao implements OnClickListener {
    final /* synthetic */ af a;

    ao(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            a.a(this.a.g, this.a.getContext());
            this.a.dismiss();
        }
    }
}
