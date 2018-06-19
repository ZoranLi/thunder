package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;

/* compiled from: ChoicenessQuickCommentHelper */
final class h implements a<f> {
    final /* synthetic */ m a;
    final /* synthetic */ b b;

    public final void a(b bVar) {
    }

    h(b bVar, m mVar) {
        this.b = bVar;
        this.a = mVar;
    }

    public final /* synthetic */ void a(Object obj) {
        f fVar = (f) obj;
        if (!(fVar == null || fVar.e == null || this.a == null)) {
            if (fVar.a.equals(this.a.b.getGcid())) {
                if (this.b.c) {
                    this.b.f = fVar.e;
                    obj = this.b.f.iterator();
                    while (obj.hasNext()) {
                        ((CommentInfo) obj.next()).setGcid(this.a.b.getGcid());
                    }
                }
            }
        }
    }
}
