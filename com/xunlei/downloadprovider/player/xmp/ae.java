package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnSeekCompleteListener;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class ae implements OnSeekCompleteListener {
    final /* synthetic */ XmpMediaPlayer a;

    ae(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onSeekComplete() {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).g();
        }
    }
}
