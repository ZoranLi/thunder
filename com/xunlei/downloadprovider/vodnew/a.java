package com.xunlei.downloadprovider.vodnew;

import com.xunlei.downloadprovider.download.player.a.m$a;

/* compiled from: VodPlayerActivityFragment */
final class a implements m$a {
    final /* synthetic */ VodPlayerActivityFragment a;

    public final void a() {
    }

    a(VodPlayerActivityFragment vodPlayerActivityFragment) {
        this.a = vodPlayerActivityFragment;
    }

    public final void b() {
        VodPlayerActivityFragment.a();
        if (this.a.getActivity() != null) {
            this.a.getActivity().finish();
        }
    }
}
