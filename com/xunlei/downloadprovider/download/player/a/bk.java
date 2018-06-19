package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.download.XLFileExploreActivity;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleInfo;
import com.xunlei.downloadprovider.vod.subtitle.u.a;

/* compiled from: SubtitleController */
final class bk implements a {
    final /* synthetic */ ba a;

    bk(ba baVar) {
        this.a = baVar;
    }

    public final void a(int i, SubtitleInfo subtitleInfo, boolean z) {
        ba baVar = this.a;
        if (!baVar.v()) {
            if (z) {
                if (subtitleInfo == null) {
                    com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_nochose");
                } else if (baVar.d) {
                    com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_change");
                } else {
                    com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_choseone");
                }
            }
            baVar.d = subtitleInfo;
            baVar.b.a(baVar.m(), baVar.t(), baVar.s());
            baVar.b.a(subtitleInfo, i);
            if (subtitleInfo == null) {
                baVar.l = "close";
            }
        }
    }

    public final void a() {
        ba baVar = this.a;
        XLFileExploreActivity.a(baVar.o(), "选择字幕文件");
        com.xunlei.downloadprovider.player.a.c(baVar.m(), baVar.r(), "subtitle_local");
    }

    public final void b() {
        this.a.u();
    }
}
