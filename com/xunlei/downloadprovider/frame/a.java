package com.xunlei.downloadprovider.frame;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: BaseViewPagerFragment */
final class a implements OnClickListener {
    final /* synthetic */ BaseViewPagerFragment a;

    a(BaseViewPagerFragment baseViewPagerFragment) {
        this.a = baseViewPagerFragment;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.e.a();
        }
    }
}
