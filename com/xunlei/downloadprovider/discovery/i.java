package com.xunlei.downloadprovider.discovery;

import com.xunlei.downloadprovider.member.login.b.h;

/* compiled from: DiscoveryFragment */
final class i implements h {
    final /* synthetic */ DiscoveryFragment a;

    i(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void onRefreshUserInfoCompleted(boolean z, int i) {
        if (this.a.getActivity() && this.a.isAdded() && i == 0) {
            this.a.getActivity().runOnUiThread(new j(this));
        }
    }
}
