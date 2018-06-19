package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnOpenSuccessListener;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class ab implements OnOpenSuccessListener {
    final /* synthetic */ XmpMediaPlayer a;

    ab(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onOpenSuccess() {
        int videoWidth = this.a.a.getVideoWidth();
        int videoHeight = this.a.a.getVideoHeight();
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            aj ajVar = (aj) it.next();
            ajVar.b();
            ajVar.b(videoWidth, videoHeight);
        }
        this.a.e = true;
    }
}
