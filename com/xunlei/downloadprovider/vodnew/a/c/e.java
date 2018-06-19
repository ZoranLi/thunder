package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnFirstFrameRenderListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.b;

/* compiled from: APlayerAndroidProxy */
final class e implements OnFirstFrameRenderListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onFirstFrameRender() {
        for (b a : this.a.d) {
            a.a();
        }
    }
}
