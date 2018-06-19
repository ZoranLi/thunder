package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnFirstFrameRenderListener;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class ai implements OnFirstFrameRenderListener {
    final /* synthetic */ XmpMediaPlayer a;

    ai(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onFirstFrameRender() {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).h();
        }
    }
}
