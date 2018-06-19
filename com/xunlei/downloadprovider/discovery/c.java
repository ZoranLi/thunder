package com.xunlei.downloadprovider.discovery;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.a;

/* compiled from: DiscoveryFragment */
final class c implements OnClickListener {
    final /* synthetic */ DiscoveryFragment a;

    c(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void onClick(View view) {
        a.a(this.a.getActivity());
        com.xunlei.downloadprovider.search.c.a.a("find", "bar");
    }
}
