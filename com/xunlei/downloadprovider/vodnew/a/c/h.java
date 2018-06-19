package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnOpenCompleteListener;
import com.xunlei.downloadprovider.vodnew.a.d.a.c;

/* compiled from: APlayerAndroidProxy */
final class h implements OnOpenCompleteListener {
    final /* synthetic */ a a;

    h(a aVar) {
        this.a = aVar;
    }

    public final void onOpenComplete(boolean z) {
        for (c a : this.a.g) {
            a.a(z);
        }
    }
}
