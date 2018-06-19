package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: YouliaoVideoCardView */
final class d implements OnClickListener {
    final /* synthetic */ YouliaoVideoCardView a;

    d(YouliaoVideoCardView youliaoVideoCardView) {
        this.a = youliaoVideoCardView;
    }

    public final void onClick(View view) {
        if (this.a.k != null) {
            this.a.k.onClick(view);
        }
    }
}
