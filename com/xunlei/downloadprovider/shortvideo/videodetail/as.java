package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

/* compiled from: ShortMovieDetailFragment */
final class as implements OnDismissListener {
    final /* synthetic */ ShortMovieDetailFragment a;

    as(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.a.at = true;
        this.a.o.setText(this.a.A.b());
    }
}
