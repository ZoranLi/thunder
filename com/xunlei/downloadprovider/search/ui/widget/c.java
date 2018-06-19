package com.xunlei.downloadprovider.search.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.engine.task.n;

/* compiled from: HomeTitleBar */
final class c implements OnClickListener {
    final /* synthetic */ HomeTitleBar a;

    c(HomeTitleBar homeTitleBar) {
        this.a = homeTitleBar;
    }

    public final void onClick(View view) {
        if (this.a.c.isUnreadShow() != null) {
            n.a();
            n.l();
        }
        a.a(this.a.getContext(), this.a.e.toString());
    }
}
