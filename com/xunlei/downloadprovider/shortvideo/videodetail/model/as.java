package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import com.xunlei.downloadprovider.comment.a.a;
import com.xunlei.downloadprovider.comment.a.b;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ShortMovieDetailDataLoader */
final class as implements a<Long> {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ CommentInfo d;
    final /* synthetic */ g e;

    as(g gVar, String str, String str2, int i, CommentInfo commentInfo) {
        this.e = gVar;
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = commentInfo;
    }

    public final /* synthetic */ void a(Object obj) {
        Long l = (Long) obj;
        CommentInfo commentInfo = new CommentInfo();
        commentInfo.setSourceId(this.e.o);
        commentInfo.setTime(System.currentTimeMillis());
        commentInfo.setId(l.longValue());
        commentInfo.setLikeCount(0);
        commentInfo.setLiked(null);
        commentInfo.setContent(this.a);
        commentInfo.setDownloadSpeed(this.b);
        commentInfo.setPlayPosition(this.c);
        commentInfo.setDevie("手机");
        commentInfo.setUserId(this.e.m.g.c());
        obj = this.e.m.g.d();
        if (obj == null || obj.trim().length() == 0) {
            obj = "迅雷用户";
        }
        commentInfo.setUserName(obj);
        commentInfo.setUserAvatar(this.e.m.e());
        commentInfo.setPreview(true);
        VideoUserInfo relatedUserInfo = commentInfo.getRelatedUserInfo();
        if (relatedUserInfo == null) {
            relatedUserInfo = new VideoUserInfo();
            commentInfo.setRelatedUserInfo(relatedUserInfo);
        }
        g.a(this.e, relatedUserInfo);
        commentInfo.setRelatedUserInfo(relatedUserInfo);
        if (this.e.q != null) {
            commentInfo.setPublisher(Long.parseLong(this.e.q.b().getUid()));
        } else {
            commentInfo.setPublisher(this.e.c);
        }
        if (this.d != null) {
            TargetCommentInfo targetCommentInfo = new TargetCommentInfo();
            targetCommentInfo.setContent(this.d.getContent());
            targetCommentInfo.setId(this.d.getId());
            targetCommentInfo.setUserName(this.d.getUserName());
            targetCommentInfo.setUserId(this.d.getUserId());
            targetCommentInfo.setUserAvatar(this.d.getUserAvatar());
            targetCommentInfo.setDevice(this.d.getDevie());
            List arrayList = new ArrayList(1);
            arrayList.add(targetCommentInfo);
            commentInfo.setReplyCommentList(arrayList);
            commentInfo.setReplyCount(1);
            commentInfo.setRelatedVideoInfo(this.d.getRelatedVideoInfo());
            commentInfo.setWebsiteInfo(this.d.getWebsiteInfo());
            commentInfo.setType(this.d.getType());
        }
        this.e.p.post(new at(this, commentInfo));
    }

    public final void a(b bVar) {
        this.e.p.post(new au(this, bVar));
    }
}
