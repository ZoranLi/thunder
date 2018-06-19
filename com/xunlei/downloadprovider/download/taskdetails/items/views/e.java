package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DetailOperationButtonLayout */
final class e implements OnClickListener {
    final /* synthetic */ DetailOperationButtonLayout a;

    e(DetailOperationButtonLayout detailOperationButtonLayout) {
        this.a = detailOperationButtonLayout;
    }

    public final void onClick(View view) {
        if (this.a.a != null && this.a.c != null) {
            view = this.a.a.b();
            if (view != null) {
                view.a(this.a.c);
            }
        }
    }
}
