package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.diffdev.OAuthListener;
import java.util.ArrayList;
import java.util.List;

final class c implements Runnable {
    final /* synthetic */ b ad;

    c(b bVar) {
        this.ad = bVar;
    }

    public final void run() {
        List<OAuthListener> arrayList = new ArrayList();
        arrayList.addAll(this.ad.ac.Z);
        for (OAuthListener onQrcodeScanned : arrayList) {
            onQrcodeScanned.onQrcodeScanned();
        }
    }
}
