package com.xunlei.downloadprovider.download.player.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DownloadVodPlayerController */
final class u implements OnClickListener {
    final /* synthetic */ m a;

    u(m mVar) {
        this.a = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (m.w(this.a) != null) {
            m.w(this.a).dismiss();
            m.x(this.a);
        }
    }
}
