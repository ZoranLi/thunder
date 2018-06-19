package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnBufferListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.a;

/* compiled from: APlayerAndroidProxy */
final class j implements OnBufferListener {
    final /* synthetic */ a a;

    j(a aVar) {
        this.a = aVar;
    }

    public final void onBuffer(int i) {
        for (a a : this.a.i) {
            a.a(i);
        }
    }
}
