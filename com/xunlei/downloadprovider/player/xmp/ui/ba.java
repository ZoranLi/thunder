package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerOperationViewDetail */
final class ba implements OnClickListener {
    final /* synthetic */ PlayerOperationViewDetail a;

    ba(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void onClick(View view) {
        if (this.a.w != null) {
            this.a.w.b();
        }
    }
}
