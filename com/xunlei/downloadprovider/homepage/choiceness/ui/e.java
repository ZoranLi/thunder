package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;

/* compiled from: ChoicenessQuickCommentHelper */
final class e extends c {
    final /* synthetic */ p a;
    final /* synthetic */ d b;

    e(d dVar, p pVar) {
        this.b = dVar;
        this.a = pVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z) {
            b.a(this.b.d, this.b.a, this.b.b, this.a);
        }
    }
}
