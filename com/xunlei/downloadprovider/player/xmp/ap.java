package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.android.shortvideo.ShortVideoInterface.b;
import com.xunlei.android.shortvideo.ShortVideoTask.STATUS;

/* compiled from: XmpPlayerManager */
final class ap implements b {
    final /* synthetic */ b a;
    final /* synthetic */ ak b;

    ap(ak akVar, b bVar) {
        this.b = akVar;
        this.a = bVar;
    }

    public final void a(String str, STATUS status, int i) {
        StringBuilder stringBuilder = new StringBuilder("preloadVideo--onCreatePlayTaskSuccess--status=");
        stringBuilder.append(status);
        stringBuilder.append("|errCode=");
        stringBuilder.append(i);
        stringBuilder.append("|url=");
        stringBuilder.append(str);
        this.b.h.post(new aq(this, str, status, i));
    }
}
