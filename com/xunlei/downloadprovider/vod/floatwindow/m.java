package com.xunlei.downloadprovider.vod.floatwindow;

import com.xunlei.downloadprovider.vodnew.a.e.o.c;

/* compiled from: VodPlayerFloatWindow */
final class m implements c {
    final /* synthetic */ a a;

    m(a aVar) {
        this.a = aVar;
    }

    public final boolean a(com.xunlei.downloadprovider.vodnew.a.d.c cVar, int i, int i2) {
        a.v;
        cVar = new StringBuilder("onError, what : ");
        cVar.append(i);
        cVar.append(" extra : ");
        cVar.append(i2);
        this.a.f.d();
        this.a.f.setLoadingText("对不起，播放出错了！");
        return true;
    }
}
