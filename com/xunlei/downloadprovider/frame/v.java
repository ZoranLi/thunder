package com.xunlei.downloadprovider.frame;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MainTabActivity */
final class v implements OnClickListener {
    final /* synthetic */ MainTabActivity a;

    v(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onClick(View view) {
        view = this.a;
        if (view.g != null) {
            view.g.setVisibility(8);
        }
    }
}
