package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnPlayStateChangeListener;

/* compiled from: APlayerAndroidProxy */
final class g implements OnPlayStateChangeListener {
    final /* synthetic */ a a;

    g(a aVar) {
        this.a = aVar;
    }

    public final void onPlayStateChange(int i, int i2) {
        i = this.a.f.iterator();
        while (i.hasNext() != 0) {
            i.next();
        }
    }
}
