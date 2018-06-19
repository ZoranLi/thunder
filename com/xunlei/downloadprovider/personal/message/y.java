package com.xunlei.downloadprovider.personal.message;

import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.personal.message.data.q;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.b;

/* compiled from: MessageItemFragment */
final class y extends b {
    final /* synthetic */ MessageItemFragment a;

    y(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        super.a(str, bVar);
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        XLToast.showToast(this.a.d, "发送评论成功");
        this.a.p.a(false);
        this.a.p.dismiss();
        this.a.p.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        this.a.p.a(j);
        q.a(null, "success", commentInfo.getSourceId(), String.valueOf(j), String.valueOf(commentInfo.getId()), ((MessageInfo) this.a.p.b).getType());
    }

    public final void a(int i, String str) {
        if (i == 4) {
            if (TextUtils.isEmpty(this.a.p.a()) == 0) {
                this.a.p.a(true);
            } else {
                this.a.p.a(false);
            }
            i = this.a.p.b;
            String str2 = "fail";
            String str3 = str;
            q.a(str3, str2, i.getSourceId(), String.valueOf(i.getId()), null, ((MessageInfo) i).getType());
            return;
        }
        if (i == 9) {
            XLToast.showToast(this.a.d, "删除评论失败");
        }
    }

    public final void b(CommentInfo commentInfo) {
        commentInfo.setLiked(true);
    }

    public final void a(long j) {
        this.a.a(j);
        XLToast.showToast(this.a.d, "删除评论成功");
    }
}
