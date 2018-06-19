package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.view.ViewGroup;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ChoicenessQuickCommentHelper */
final class f implements a<Long> {
    final /* synthetic */ p a;
    final /* synthetic */ m b;
    final /* synthetic */ ViewGroup c;
    final /* synthetic */ b d;

    f(b bVar, p pVar, m mVar, ViewGroup viewGroup) {
        this.d = bVar;
        this.a = pVar;
        this.b = mVar;
        this.c = viewGroup;
    }

    public final /* synthetic */ void a(Object obj) {
        obj = (Long) obj;
        if (this.d.b != null) {
            this.d.b.getQuickCommentView().setClickEnable(true);
            XLToast.showToast(this.d.a, "发送评论成功");
            List list = this.d.f;
            if (list == null) {
                list = new ArrayList();
            }
            CommentInfo commentInfo = new CommentInfo();
            commentInfo.setUserName(LoginHelper.a().g.d());
            commentInfo.setContent(this.a.b);
            commentInfo.setUserId(LoginHelper.a().g.c());
            commentInfo.setGcid(this.b.b.getGcid());
            commentInfo.setSourceId(this.b.b.getVideoId());
            list.add(0, commentInfo);
            this.b.c = list;
            this.d.a(this.c, this.b, list);
            this.b.b.setCommentCount(this.b.b.getCommentCount() + 1);
            if (this.d.g != null) {
                this.d.g.c();
            }
            if (obj == null) {
                obj = Long.valueOf(-1);
            }
            ChoicenessReporter.a(this.b, this.a, true, obj.longValue(), -1);
        }
    }

    public final void a(b bVar) {
        if (this.d.b != null) {
            this.d.b.getQuickCommentView().setClickEnable(true);
            ChoicenessReporter.a(this.b, this.a, false, -1, bVar.a);
        }
    }
}
