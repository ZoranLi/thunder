package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;

/* compiled from: TaskCommentController */
final class d implements a {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void a(p pVar) {
        this.a.t.e = pVar;
        com.xunlei.downloadprovider.download.report.a.a(this.a.l, "input", pVar.a, "comment");
        if (!r.a().a(this.a.i, LoginFrom.DL_USER_DISCUSS_DEFAULT, this.a.G)) {
            this.a.a((String) pVar.b, this.a.t.b);
        }
    }
}
