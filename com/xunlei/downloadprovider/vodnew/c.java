package com.xunlei.downloadprovider.vodnew;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VodPlayerActivityFragment */
final class c implements OnClickListener {
    final /* synthetic */ VodPlayerActivityFragment a;

    c(VodPlayerActivityFragment vodPlayerActivityFragment) {
        this.a = vodPlayerActivityFragment;
    }

    public final void onClick(View view) {
        if (this.a.getActivity() != null) {
            this.a.getActivity().finish();
        }
    }
}
