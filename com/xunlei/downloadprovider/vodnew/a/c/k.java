package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnSeekCompleteListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.f;

/* compiled from: APlayerAndroidProxy */
final class k implements OnSeekCompleteListener {
    final /* synthetic */ a a;

    k(a aVar) {
        this.a = aVar;
    }

    public final void onSeekComplete() {
        for (f a : this.a.j) {
            a.a();
        }
    }
}
