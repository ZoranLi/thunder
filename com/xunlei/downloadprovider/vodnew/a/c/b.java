package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnReCreateHwDecoderListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.e;

/* compiled from: APlayerAndroidProxy */
final class b implements OnReCreateHwDecoderListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onReCreateHwDecoder() {
        for (e a : this.a.c) {
            a.a();
        }
    }
}
