package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DetailOperationButtonLayout */
final class b implements OnClickListener {
    final /* synthetic */ DetailOperationButtonLayout a;

    b(DetailOperationButtonLayout detailOperationButtonLayout) {
        this.a = detailOperationButtonLayout;
    }

    public final void onClick(View view) {
        if (this.a.c != null) {
            a.b(this.a.c);
            if (this.a.d != null) {
                this.a.d;
                com.xunlei.downloadprovider.download.control.a.a(this.a.c);
            }
        }
    }
}
