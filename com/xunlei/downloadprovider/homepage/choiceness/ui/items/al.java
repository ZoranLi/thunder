package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.android.shortvideo.ShortVideoInterface.b;
import com.xunlei.android.shortvideo.ShortVideoTask.STATUS;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: ChoicenessUgcPlayerView */
final class al implements b {
    final /* synthetic */ boolean a;
    final /* synthetic */ ak b;

    al(ak akVar, boolean z) {
        this.b = akVar;
        this.a = z;
    }

    public final void a(String str, STATUS status, int i) {
        this.b.g.b.setPreloadPlayUrl(str);
        this.b.a((BaseVideoInfo) this.b.g.b, (VideoUserInfo) this.b.g.a, this.a, true);
    }
}
