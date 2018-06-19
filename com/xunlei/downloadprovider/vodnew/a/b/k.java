package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.g.c;

/* compiled from: PlayerSubtitleDecorator */
final class k implements c {
    final /* synthetic */ j a;

    k(j jVar) {
        this.a = jVar;
    }

    public final void a(SubtitleManifest subtitleManifest) {
        this.a.c = subtitleManifest;
        if (this.a.j != null) {
            this.a.j.a(subtitleManifest);
        }
    }
}
