package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.g.c;

/* compiled from: SubtitleController */
final class bf implements c {
    final /* synthetic */ ba a;

    bf(ba baVar) {
        this.a = baVar;
    }

    public final void a(SubtitleManifest subtitleManifest) {
        if (!this.a.v()) {
            ba.m;
            new StringBuilder("onSubtitleManifestReady=>").append(subtitleManifest == null ? 0 : subtitleManifest.getListCount());
            if (subtitleManifest == null || subtitleManifest.getListCount() <= 0) {
                this.a.j = "fail";
                return;
            }
            this.a.a(subtitleManifest, true, false, true);
            this.a.j = "success";
        }
    }
}
