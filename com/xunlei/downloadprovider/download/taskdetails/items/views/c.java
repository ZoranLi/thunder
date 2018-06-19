package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DetailOperationButtonLayout */
final class c implements OnClickListener {
    final /* synthetic */ DetailOperationButtonLayout a;

    c(DetailOperationButtonLayout detailOperationButtonLayout) {
        this.a = detailOperationButtonLayout;
    }

    public final void onClick(View view) {
        if (this.a.c != null && this.a.d != null) {
            this.a.d.c(this.a.c);
            a.c(this.a.c);
        }
    }
}
