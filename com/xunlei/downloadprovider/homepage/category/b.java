package com.xunlei.downloadprovider.homepage.category;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ShortVideoCategoryActivity */
final class b implements OnClickListener {
    final /* synthetic */ ShortVideoCategoryActivity a;

    b(ShortVideoCategoryActivity shortVideoCategoryActivity) {
        this.a = shortVideoCategoryActivity;
    }

    public final void onClick(View view) {
        v.b(this.a.c, "return");
        this.a.onBackPressed();
    }
}
