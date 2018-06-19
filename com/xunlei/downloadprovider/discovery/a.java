package com.xunlei.downloadprovider.discovery;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.xllib.android.b;

/* compiled from: DiscoveryFragment */
final class a implements OnClickListener {
    final /* synthetic */ DiscoveryFragment a;

    a(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            DiscoveryFragment.a(this.a);
            view = d.a();
            view.u = new b(this);
            view.i();
        }
    }
}
