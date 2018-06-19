package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vod.subtitle.s.a;

/* compiled from: SubtitleController */
final class bm implements a {
    final /* synthetic */ ba a;

    bm(ba baVar) {
        this.a = baVar;
    }

    public final void a(int i) {
        ba baVar = this.a;
        if (baVar.d != null) {
            baVar.d.setOffset(i);
        }
        baVar.a.a(509, String.valueOf(i));
        com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_tongbu");
    }

    public final void b(int i) {
        ba baVar = this.a;
        baVar.c.setSubtitleColor(i);
        baVar.i.setTextColor(i);
        com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_color_change");
    }
}
