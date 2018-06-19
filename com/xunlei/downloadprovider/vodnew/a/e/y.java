package com.xunlei.downloadprovider.vodnew.a.e;

import com.aplayer.aplayerandroid.APlayerAndroid.PlayCompleteRet;
import com.xunlei.downloadprovider.vodnew.a.d.a.d;

/* compiled from: XLMediaPlayer */
final class y implements d {
    final /* synthetic */ o a;

    y(o oVar) {
        this.a = oVar;
    }

    public final void a(String str) {
        if (PlayCompleteRet.PLAYRE_RESULT_CLOSE.contentEquals(str) != null) {
            this.a.a.b((d) this);
            this.a.s = false;
            o.u;
            this.a.d();
        }
    }
}
