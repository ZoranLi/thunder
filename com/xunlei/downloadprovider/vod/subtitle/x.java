package com.xunlei.downloadprovider.vod.subtitle;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: VodPlayerSubtitlePopupWindow */
final class x implements OnClickListener {
    final /* synthetic */ u a;

    x(u uVar) {
        this.a = uVar;
    }

    public final void onClick(View view) {
        if (this.a.b != null) {
            this.a.b.b();
        }
    }
}
