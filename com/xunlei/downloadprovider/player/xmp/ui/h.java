package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerCompletionViewDetail */
final class h implements OnClickListener {
    final /* synthetic */ PlayerCompletionViewDetail a;

    h(PlayerCompletionViewDetail playerCompletionViewDetail) {
        this.a = playerCompletionViewDetail;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.e.e();
        }
    }
}
