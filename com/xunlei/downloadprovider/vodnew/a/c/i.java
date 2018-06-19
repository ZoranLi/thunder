package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnPlayCompleteListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.d;

/* compiled from: APlayerAndroidProxy */
final class i implements OnPlayCompleteListener {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public final void onPlayComplete(String str) {
        for (d a : this.a.h) {
            a.a(str);
        }
    }
}
