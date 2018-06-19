package com.xunlei.downloadprovider.personal.message;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.CommentSateInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.StateSyncManager.SourceFrom;

/* compiled from: MessageItemFragment */
final class aa implements OnClickListener {
    final /* synthetic */ MessageItemFragment a;

    aa(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onClick(View view) {
        this.a.q.dismiss();
        CommentInfo commentInfo = (MessageInfo) this.a.q.f;
        if (!(commentInfo == null || commentInfo.isLiked())) {
            MessageItemFragment.a(commentInfo);
            this.a.a((MessageInfo) commentInfo);
            this.a.s.a(commentInfo);
            CommentSateInfo commentSateInfo = new CommentSateInfo();
            commentSateInfo.a = commentInfo.getId();
            commentSateInfo.d = commentInfo.getRelateGcid();
            commentSateInfo.b = commentInfo.isLiked();
            commentSateInfo.e = commentInfo.getUserId();
            commentSateInfo.c = commentInfo.getLikeCount();
            StateSyncManager.a(this.a.d, SourceFrom.PAGE_PERSONAL_SPACE, commentSateInfo);
            String sourceId = commentInfo.getSourceId();
            long id = commentInfo.getId();
            view = HubbleEventBuilder.build("android_personal_account", "personal_space_discuss_zan");
            view.addString("movieid", sourceId);
            view.addString("discussid", String.valueOf(id));
            ThunderReport.reportEvent(view);
        }
    }
}
