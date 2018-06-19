package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnSurfaceDestroyListener;
import java.util.Iterator;

/* compiled from: APlayerAndroidProxy */
final class l implements OnSurfaceDestroyListener {
    final /* synthetic */ a a;

    l(a aVar) {
        this.a = aVar;
    }

    public final void onSurfaceDestroy() {
        Iterator it = this.a.k.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
