package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnSystemPlayerFailListener;
import java.util.Iterator;

/* compiled from: APlayerAndroidProxy */
final class c implements OnSystemPlayerFailListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onSystemPlayerFail() {
        Iterator it = this.a.l.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
