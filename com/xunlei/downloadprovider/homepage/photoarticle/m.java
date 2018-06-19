package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;

/* compiled from: PhotoArticleDetailActivity */
final class m implements a {
    final /* synthetic */ PhotoArticleDetailActivity a;

    m(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void a(View view, int i, Object obj) {
        StringBuilder stringBuilder = new StringBuilder("onItemViewClicked--clickedView=");
        stringBuilder.append(view);
        stringBuilder.append("|action=");
        stringBuilder.append(i);
        stringBuilder.append("|data=");
        stringBuilder.append(obj);
        if (i == 0) {
            this.a.g();
        } else if (i != 9) {
            CommentInfo commentInfo;
            switch (i) {
                case 11:
                    commentInfo = (CommentInfo) obj;
                    this.a.m.a(commentInfo);
                    view = this.a.f;
                    i = this.a.h();
                    long id = commentInfo.getId();
                    LoginHelper.a();
                    obj = l.b();
                    StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_discuss_zan");
                    build.add("news_id", view);
                    build.add("author_id", i);
                    build.add("discussid", id);
                    build.add("is_login", obj);
                    y.a(build);
                    return;
                case 12:
                    commentInfo = (CommentInfo) obj;
                    if (commentInfo.isPreview() != null) {
                        XLToast.showToast(this.a, "此评论暂时无法回复");
                        return;
                    }
                    PhotoArticleDetailActivity photoArticleDetailActivity = this.a;
                    i = new StringBuilder("回复 ");
                    i.append(commentInfo.getUserName());
                    PhotoArticleDetailActivity.b(photoArticleDetailActivity, i.toString());
                    this.a.o.a(commentInfo);
                    y.b("discuss", this.a.f, this.a.h());
                    return;
                default:
                    switch (i) {
                        case 14:
                        case 15:
                            commentInfo = (CommentInfo) obj;
                            if (commentInfo != null) {
                                this.a.m.e();
                                this.a.m.f();
                                com.xunlei.downloadprovider.personal.user.account.m.a(this.a, commentInfo.getUserId(), "per", commentInfo.getUserName(), commentInfo.getUserAvatar(), From.NEWS_DETAIL_DISCUSSER);
                                return;
                            }
                            return;
                        default:
                            break;
                    }
            }
        } else {
            PhotoArticleDetailActivity.a(this.a, (CommentInfo) obj);
        }
    }
}
