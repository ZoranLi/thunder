package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerCompletionViewDetail */
final class d implements OnClickListener {
    final /* synthetic */ PlayerCompletionViewDetail a;

    d(PlayerCompletionViewDetail playerCompletionViewDetail) {
        this.a = playerCompletionViewDetail;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.f();
            if (this.a.e != null) {
                this.a.e;
            }
        }
    }
}
