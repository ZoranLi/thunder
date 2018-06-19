package com.xunlei.downloadprovider.publiser.per;

import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.b;

/* compiled from: HistoryDynamicItemFragment */
final class w extends b {
    final /* synthetic */ HistoryDynamicItemFragment a;

    w(HistoryDynamicItemFragment historyDynamicItemFragment) {
        this.a = historyDynamicItemFragment;
    }

    public final void a(String str, com.xunlei.downloadprovider.shortvideo.videodetail.model.b bVar) {
        super.a(str, bVar);
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        XLToast.showToast(this.a.b, "发送评论成功");
        this.a.i.a(false);
        this.a.i.dismiss();
        this.a.i.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        this.a.i.a(j);
        String valueOf = String.valueOf(j);
        String sourceId = commentInfo.getSourceId();
        String a = HistoryDynamicItemFragment.a(commentInfo.getType());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commentInfo.getId());
        a.a(valueOf, sourceId, a, stringBuilder.toString(), "success", "");
    }

    public final void a(int i, String str) {
        if (i == 4) {
            if (TextUtils.isEmpty(this.a.i.a()) == 0) {
                this.a.i.a(true);
            } else {
                this.a.i.a(false);
            }
            i = this.a.i.b;
            String sourceId = i.getSourceId();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i.getId());
            a.a(stringBuilder.toString(), sourceId, HistoryDynamicItemFragment.a(i.getType()), "", "fail", str);
            return;
        }
        if (i == 9) {
            XLToast.showToast(this.a.b, "删除评论失败");
        }
    }

    public final void b(CommentInfo commentInfo) {
        commentInfo.setLiked(true);
    }

    public final void a(long j) {
        HistoryDynamicItemFragment.a(this.a, j);
        XLToast.showToast(this.a.b, "删除评论成功");
    }
}
