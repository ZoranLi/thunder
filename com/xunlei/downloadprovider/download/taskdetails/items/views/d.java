package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DetailOperationButtonLayout */
final class d implements OnClickListener {
    final /* synthetic */ DetailOperationButtonLayout a;

    d(DetailOperationButtonLayout detailOperationButtonLayout) {
        this.a = detailOperationButtonLayout;
    }

    public final void onClick(View view) {
        if (this.a.c != null && this.a.d != null) {
            if (this.a.c.mIsFileMissing != null) {
                this.a.d.b(this.a.c);
            } else {
                this.a.d.c(this.a.c);
            }
            if (this.a.q != null) {
                this.a.q.d();
            }
            a.a("dl_retry", this.a.c);
        }
    }
}
