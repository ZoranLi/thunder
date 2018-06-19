package com.xunlei.downloadprovider.vodnew.a.e;

import com.aplayer.aplayerandroid.APlayerAndroid.PlayCompleteRet;
import com.xunlei.downloadprovider.vodnew.a.d.a.d;

/* compiled from: XLMediaPlayer */
final class s implements d {
    final /* synthetic */ o a;

    s(o oVar) {
        this.a = oVar;
    }

    public final void a(String str) {
        o.u;
        this.a.r = false;
        this.a.s = false;
        if (PlayCompleteRet.PLAYRE_RESULT_COMPLETE.contentEquals(str)) {
            if (this.a.x == null || this.a.a.o() != null) {
                this.a.c(7);
                if (this.a.j != null) {
                    this.a.j.a(this.a);
                    return;
                }
            }
            this.a.a();
        } else if (PlayCompleteRet.PLAYRE_RESULT_CLOSE.contentEquals(str)) {
            o.u;
        } else if (PlayCompleteRet.PLAYRE_RESULT_OPENRROR.contentEquals(str) != null) {
            o.u;
        } else {
            o.u;
            if (this.a.b() != null) {
                o.u;
                new StringBuilder("错误原因： ").append(this.a.b().e);
            }
            this.a.c(6);
            if (this.a.n != null) {
                this.a.n.a(this.a, 2, 0);
            }
        }
    }
}
