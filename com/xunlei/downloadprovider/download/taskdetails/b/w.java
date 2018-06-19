package com.xunlei.downloadprovider.download.taskdetails.b;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: TaskCommentController */
final class w implements OnClickListener {
    final /* synthetic */ b a;

    w(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        String str;
        view = this.a.t.b;
        long id = view == null ? -1 : view.getBaseCommentInfo().getId();
        view = id == -1 ? "comment_send" : "reply_send";
        if (id == -1) {
            str = "0";
        } else {
            str = String.valueOf(id);
        }
        a.c(this.a.l, str, view);
        if (r.a().a(this.a.i, LoginFrom.DL_USER_DISCUSS, this.a.F) == null) {
            this.a.b();
        }
    }
}
