package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.ArrayList;

/* compiled from: TaskCommentController */
final class m implements a<f> {
    final /* synthetic */ b a;

    m(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        f fVar = (f) obj;
        this.a.q = 2;
        this.a.j.a(this.a.s);
        if (!(fVar == null || fVar.e == null)) {
            if (!fVar.e.isEmpty()) {
                b.a(this.a, fVar.e);
                ArrayList arrayList = new ArrayList();
                for (CommentInfo commentInfo : fVar.e) {
                    arrayList.add(new aw(17, commentInfo));
                    this.a.n.add(commentInfo);
                }
                this.a.j.a(arrayList);
                if (fVar.e.size() < 20) {
                    this.a.o = false;
                }
                return;
            }
        }
        this.a.o = false;
    }

    public final void a(b bVar) {
        this.a.q = 1;
        this.a.j.a(this.a.s);
    }
}
