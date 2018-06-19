package com.xunlei.downloadprovider.download.tasklist.list.feed.b;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: GotoTopBtnHelper */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(this.a.e);
        a aVar = (a) this.a.b.get(Integer.valueOf(this.a.e));
        if (aVar != null) {
            aVar.b.smoothScrollToPosition(0);
        }
    }
}
