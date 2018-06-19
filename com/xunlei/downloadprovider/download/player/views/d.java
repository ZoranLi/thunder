package com.xunlei.downloadprovider.download.player.views;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: ThunderCommandDialog */
final class d implements OnClickListener {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onClick(View view) {
        a.d(this.a.a, this.a.b.a, "close");
        this.a.dismiss();
    }
}
