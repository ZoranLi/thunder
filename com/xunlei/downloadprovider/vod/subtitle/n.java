package com.xunlei.downloadprovider.vod.subtitle;

import com.umeng.message.proguard.k;

/* compiled from: SubtitleManager */
final class n extends r {
    final /* synthetic */ g a;

    n(g gVar) {
        this.a = gVar;
    }

    public final void a(SubtitleInfo subtitleInfo, int i) {
        i = g.a(i + 1);
        StringBuilder stringBuilder = new StringBuilder("字幕");
        stringBuilder.append(i);
        stringBuilder.append(k.s);
        stringBuilder.append(subtitleInfo.getFileLanguange());
        stringBuilder.append(k.t);
        subtitleInfo.setUiDisplayName(stringBuilder.toString());
    }
}
