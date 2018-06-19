package com.xunlei.downloadprovider.web.website.e;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CollectionUpdateViewHolder */
final class b implements OnClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        com.xunlei.downloadprovider.web.website.g.b.a();
        com.xunlei.downloadprovider.web.website.g.b.f();
        if (this.a.z != null) {
            this.a.z.g = false;
            this.a.z.notifyDataSetChanged();
        }
    }
}
