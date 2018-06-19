package com.xunlei.downloadprovider.download.player.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: DownloadVodPlayerController */
final class ab implements OnClickListener {
    ab() {
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (m.P() != null) {
            m.P().dismiss();
            m.Q();
        }
    }
}
