package com.xunlei.downloadprovider.download.taskdetails.b;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.b;

/* compiled from: TaskCommentController */
final class r extends b {
    final /* synthetic */ b a;

    r(b bVar) {
        this.a = bVar;
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        super.a(str, bVar);
    }

    public final void a(CommentInfo commentInfo) {
        XLToast.showToast(this.a.i, "发送评论成功");
        b.a(this.a, commentInfo);
    }

    public final void a(int i, String str) {
        if (i == 4) {
            b.a(this.a, str);
            return;
        }
        if (i == 9) {
            XLToast.showToast(this.a.i, "删除评论失败");
        }
    }

    public final void b(CommentInfo commentInfo) {
        commentInfo.getBaseCommentInfo().setLiked(true);
    }

    public final void a(long j) {
        b.a(this.a, j);
        XLToast.showToast(this.a.i, "删除评论成功");
    }
}
