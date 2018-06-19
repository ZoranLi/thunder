package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: BaseListFragment */
final class c implements OnClickListener {
    final /* synthetic */ BaseListFragment a;

    c(BaseListFragment baseListFragment) {
        this.a = baseListFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.f();
        }
    }
}
