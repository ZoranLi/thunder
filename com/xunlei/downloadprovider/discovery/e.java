package com.xunlei.downloadprovider.discovery;

import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: DiscoveryFragment */
final class e implements d {
    final /* synthetic */ DiscoveryFragment a;

    e(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        if (this.a.getActivity() && this.a.isAdded()) {
            this.a.getActivity().runOnUiThread(new f(this, i));
        }
    }
}
