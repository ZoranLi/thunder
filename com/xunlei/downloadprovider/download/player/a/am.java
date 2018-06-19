package com.xunlei.downloadprovider.download.player.a;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerMenuController */
final class am implements OnClickListener {
    final /* synthetic */ af a;

    am(af afVar) {
        this.a = afVar;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.e.postDelayed(new an(this), 100);
        }
    }
}
