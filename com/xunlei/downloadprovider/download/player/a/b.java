package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: AudioTrackController */
final class b implements e {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void a(c cVar) {
        this.a.r();
        if (this.a.a() != null) {
            this.a.a = this.a.a().audioTrackIndex;
            if (this.a.a >= null && this.a.f() != null) {
                cVar = this.a.f().a;
                this.a.g;
                cVar = com.xunlei.downloadprovider.vod.audiotrack.b.a(cVar, this.a.a);
                a.b;
                StringBuilder stringBuilder = new StringBuilder("onPrepared, 恢复音轨 : ");
                stringBuilder.append(this.a.a);
                stringBuilder.append(" ：");
                stringBuilder.append(cVar);
            }
        }
    }
}
