package com.xunlei.downloadprovider.download.tasklist.list.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: CooperationCardViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.k != null) {
            view = this.a.k;
            if (view.i != null) {
                view.a.a.remove(view.i);
                view.i = null;
                view.notifyDataSetChanged();
            }
        }
        f.a(BrothersApplication.getApplicationInstance(), "exchange_download_card_close_time", System.currentTimeMillis() / 1000);
    }
}
