package com.xunlei.downloadprovider.shortvideo.ui;

import android.view.View;
import android.view.View.OnLongClickListener;

/* compiled from: PlayerUgcView */
final class b implements OnLongClickListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.k != null) {
            this.a.k.onLongClick(view);
        }
        return null;
    }
}
