package com.xunlei.downloadprovider.vodnew.a.c;

import com.aplayer.aplayerandroid.APlayerAndroid.OnOpenSuccessListener;
import java.util.Iterator;

/* compiled from: APlayerAndroidProxy */
final class f implements OnOpenSuccessListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onOpenSuccess() {
        Iterator it = this.a.e.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
