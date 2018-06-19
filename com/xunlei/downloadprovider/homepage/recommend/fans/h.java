package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: BaseRecyViewFragment */
final class h implements OnClickListener {
    final /* synthetic */ BaseRecyViewFragment a;

    h(BaseRecyViewFragment baseRecyViewFragment) {
        this.a = baseRecyViewFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.h();
        }
    }
}
