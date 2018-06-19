package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnReCreateHwDecoderListener;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class ah implements OnReCreateHwDecoderListener {
    final /* synthetic */ XmpMediaPlayer a;

    ah(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onReCreateHwDecoder() {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).c();
        }
    }
}
