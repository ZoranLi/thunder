package com.xunlei.downloadprovider.homepage.youliao;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: YouliaoVideoFragment */
final class d implements OnClickListener {
    final /* synthetic */ YouliaoVideoFragment a;

    d(YouliaoVideoFragment youliaoVideoFragment) {
        this.a = youliaoVideoFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.b();
        }
    }
}
