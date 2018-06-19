package com.xunlei.downloadprovider.player.xmp.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerCompletionViewDefault */
final class b implements OnClickListener {
    final /* synthetic */ PlayerCompletionViewDefault a;

    b(PlayerCompletionViewDefault playerCompletionViewDefault) {
        this.a = playerCompletionViewDefault;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.f();
            if (this.a.d != null) {
                this.a.d.onClick(view);
            }
        }
    }
}
