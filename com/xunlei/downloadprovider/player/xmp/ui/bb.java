package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerOperationViewDetail */
final class bb implements OnClickListener {
    final /* synthetic */ PlayerOperationViewDetail a;

    bb(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void onClick(View view) {
        if (this.a.w != null) {
            this.a.w.c();
        }
    }
}
