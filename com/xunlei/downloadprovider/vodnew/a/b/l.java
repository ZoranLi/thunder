package com.xunlei.downloadprovider.vodnew.a.b;

import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.g.b;

/* compiled from: PlayerSubtitleDecorator */
final class l implements b {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public final void a(SubtitleManifest subtitleManifest) {
        this.a.c = subtitleManifest;
        if (this.a.h != null) {
            this.a.h.a(subtitleManifest);
        }
    }
}
