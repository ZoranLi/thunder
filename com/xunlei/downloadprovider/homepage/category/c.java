package com.xunlei.downloadprovider.homepage.category;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: ShortVideoCategoryActivity */
final class c implements OnClickListener {
    final /* synthetic */ ShortVideoCategoryActivity a;

    c(ShortVideoCategoryActivity shortVideoCategoryActivity) {
        this.a = shortVideoCategoryActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.f.setVisibility(8);
            this.a.a();
        }
    }
}
