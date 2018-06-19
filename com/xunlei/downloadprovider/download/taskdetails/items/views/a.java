package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;

/* compiled from: DetailOperationButtonLayout */
final class a implements OnClickListener {
    final /* synthetic */ DetailOperationButtonLayout a;

    a(DetailOperationButtonLayout detailOperationButtonLayout) {
        this.a = detailOperationButtonLayout;
    }

    public final void onClick(View view) {
        if (this.a.c != null && this.a.d != null) {
            this.a.d.a(this.a.c.getTaskId(), PayFrom.DOWNLOAD_TASK_DETAIL_SPEEDUP);
            com.xunlei.downloadprovider.download.report.a.a(this.a.c);
        }
    }
}
