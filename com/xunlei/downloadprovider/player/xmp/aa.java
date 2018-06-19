package com.xunlei.downloadprovider.player.xmp;

import com.xunlei.downloadprovider.player.xmp.m.a;
import java.util.Iterator;

/* compiled from: XmpMediaPlayer */
final class aa implements a {
    final /* synthetic */ XmpMediaPlayer a;

    aa(XmpMediaPlayer xmpMediaPlayer) {
        this.a = xmpMediaPlayer;
    }

    public final void a(int i) {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).a(i);
        }
    }

    public final void a(int i, boolean z) {
        Iterator it = this.a.c.iterator();
        while (it.hasNext()) {
            ((aj) it.next()).a(i, z);
        }
    }
}
