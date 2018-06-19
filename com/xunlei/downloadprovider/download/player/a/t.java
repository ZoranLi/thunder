package com.xunlei.downloadprovider.download.player.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DownloadVodPlayerController */
final class t implements OnClickListener {
    final /* synthetic */ OnClickListener a;
    final /* synthetic */ m b;

    t(m mVar, OnClickListener onClickListener) {
        this.b = mVar;
        this.a = onClickListener;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (m.w(this.b) != null) {
            m.w(this.b).dismiss();
            m.x(this.b);
        }
        this.a.onClick(dialogInterface, i);
    }
}
