package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnBufferListener;
import com.xunlei.downloadprovider.player.xmp.XmpMediaPlayer.BufferingState;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class af implements OnBufferListener {
    final /* synthetic */ XmpMediaPlayer a;

    af(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onBuffer(int i) {
        BufferingState bufferingState;
        if (i == 100) {
            bufferingState = BufferingState.END;
            this.a.f = false;
        } else if (this.a.f) {
            bufferingState = BufferingState.BUFFERING;
        } else {
            this.a.f = true;
            bufferingState = BufferingState.START;
        }
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).a(bufferingState, i);
        }
    }
}
