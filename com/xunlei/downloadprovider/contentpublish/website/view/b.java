package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: WebsiteCardView */
final class b implements OnLongClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean onLongClick(View view) {
        return this.a.u != null ? this.a.u.onLongClick(view) : null;
    }
}
