package com.xunlei.downloadprovider.download.player.views.center;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PlayerCenterViewGroup */
final class b implements OnClickListener {
    final /* synthetic */ PlayerCenterViewGroup a;

    b(PlayerCenterViewGroup playerCenterViewGroup) {
        this.a = playerCenterViewGroup;
    }

    public final void onClick(View view) {
        if (this.a.f != null) {
            this.a.f.a();
        }
    }
}
