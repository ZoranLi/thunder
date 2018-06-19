package com.xunlei.downloadprovider.download.tasklist.list.b;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CooperationCardViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.h != null && this.a.h.a != null) {
            com.xunlei.downloadprovider.cooperation.ui.b.a().a(this.a.getContext(), this.a.h.a, "");
        }
    }
}
