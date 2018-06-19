package com.xunlei.downloadprovider.discovery;

/* compiled from: DiscoveryFragment */
final class g implements com.xunlei.downloadprovider.member.login.b.g {
    final /* synthetic */ DiscoveryFragment a;

    g(DiscoveryFragment discoveryFragment) {
        this.a = discoveryFragment;
    }

    public final void onLogout() {
        if (this.a.getActivity() != null && this.a.isAdded()) {
            this.a.getActivity().runOnUiThread(new h(this));
        }
    }
}
