package com.xunlei.downloadprovider.vod.player;

import android.app.Activity;
import android.content.Context;
import android.widget.PopupWindow.OnDismissListener;
import com.xunlei.downloadprovider.download.player.a;

/* compiled from: VodPlayerBasePopupWindow */
final class e implements OnDismissListener {
    final /* synthetic */ Context a;
    final /* synthetic */ d b;

    e(d dVar, Context context) {
        this.b = dVar;
        this.a = context;
    }

    public final void onDismiss() {
        if (this.a != null && (this.a instanceof Activity)) {
            a.a((Activity) this.a);
        }
        if (this.b.a != null) {
            this.b.a.onDismiss();
        }
    }
}
