package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayCompleteLikeGuideView */
final class d implements OnClickListener {
    final /* synthetic */ PlayCompleteLikeGuideView a;

    d(PlayCompleteLikeGuideView playCompleteLikeGuideView) {
        this.a = playCompleteLikeGuideView;
    }

    public final void onClick(View view) {
        if (this.a.c != null) {
            this.a.c.onClick(this.a.b);
        }
        this.a.a(true);
    }
}
