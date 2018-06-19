package com.xunlei.downloadprovider.download.taskdetails.b;

import com.umeng.message.proguard.k;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.personal.user.c;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.ArrayList;

/* compiled from: TaskCommentController */
final class l implements a<f> {
    final /* synthetic */ b a;

    l(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void a(Object obj) {
        int i;
        f fVar = (f) obj;
        this.a.j.a(this.a.D);
        this.a.r = 2;
        this.a.n.clear();
        if (fVar == null || fVar.e == null) {
            i = 0;
        } else {
            i = fVar.e.size();
            this.a.C = fVar.c;
        }
        c cVar = new c();
        if (fVar == null) {
            cVar.a = 0;
        } else {
            cVar.a = (long) fVar.c;
        }
        b.f();
        String decimal2String = ConvertUtil.decimal2String((long) this.a.C, 10000, 10000, "万");
        if (!decimal2String.trim().contentEquals("0")) {
            aw w = this.a.E;
            StringBuilder stringBuilder = new StringBuilder("评论(");
            stringBuilder.append(decimal2String);
            stringBuilder.append(k.t);
            w.b = stringBuilder.toString();
        }
        if (i < 20) {
            this.a.o = false;
        } else {
            this.a.o = true;
        }
        if (i > 0) {
            this.a.j.a(this.a.x);
            this.a.j.a(this.a.y);
        } else if (i == 0) {
            this.a.j.a(this.a.x);
            this.a.j.a(this.a.y);
            this.a.z[0] = Boolean.valueOf(true);
            this.a.z[1] = Boolean.valueOf(true);
            this.a.j.c(this.a.x);
            com.xunlei.downloadprovider.download.report.a.b(this.a.l, "comment", this.a.i(), this.a.m());
            return;
        }
        b.a(this.a, fVar.e);
        ArrayList arrayList = new ArrayList();
        arrayList.add(0, this.a.E);
        for (CommentInfo commentInfo : fVar.e) {
            aw awVar = new aw(17, commentInfo);
            this.a.n.add(commentInfo);
            arrayList.add(awVar);
        }
        this.a.j.b(arrayList);
    }

    public final void a(b bVar) {
        this.a.j.a(this.a.D);
        this.a.r = 1;
        this.a.j.a(this.a.x);
        this.a.j.a(this.a.y);
        this.a.j.c(this.a.y);
        b.g();
    }
}
