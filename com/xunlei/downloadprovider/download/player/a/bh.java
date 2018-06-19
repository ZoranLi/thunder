package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.g.b;

/* compiled from: SubtitleController */
final class bh implements b {
    final /* synthetic */ ba a;

    bh(ba baVar) {
        this.a = baVar;
    }

    public final void a(SubtitleManifest subtitleManifest) {
        if (!(this.a.v() || subtitleManifest == null || subtitleManifest.getListCount() <= 0)) {
            this.a.a(subtitleManifest, false, false, true);
        }
    }
}
