package com.xunlei.downloadprovider.player.xmp;

import com.aplayer.aplayerandroid.APlayerAndroid.OnPlayCompleteListener;
import com.aplayer.aplayerandroid.APlayerAndroid.PlayCompleteRet;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class ac implements OnPlayCompleteListener {
    final /* synthetic */ XmpMediaPlayer a;

    ac(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void onPlayComplete(String str) {
        this.a.a();
        this.a.e = false;
        if (PlayCompleteRet.PLAYRE_RESULT_COMPLETE.equals(str)) {
            str = this.a.c.iterator();
            while (str.hasNext()) {
                ((aj) str.next()).a();
            }
        } else if (PlayCompleteRet.PLAYRE_RESULT_CLOSE.equals(str)) {
            str = this.a.c.iterator();
            while (str.hasNext()) {
                ((aj) str.next()).f();
            }
        } else {
            this.a.g = true;
            Iterator it = this.a.c.iterator();
            while (it.hasNext()) {
                ((aj) it.next()).a(str);
            }
        }
    }
}
