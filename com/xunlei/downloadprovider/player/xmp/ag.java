package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnShowSubtitleListener;

/* compiled from: XmpMediaPlayer */
final class ag implements OnShowSubtitleListener {
    final /* synthetic */ XmpMediaPlayer a;

    ag(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onShowSubtitle(String str) {
        str = this.a.c.iterator();
        while (str.hasNext()) {
            str.next();
        }
    }
}
