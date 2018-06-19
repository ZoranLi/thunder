package com.xunlei.downloadprovider.homepage.cinecism;

import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.b;
import com.xunlei.downloadprovider.web.base.core.CustomWebView;
import org.json.JSONObject;

/* compiled from: CinecismDetailActivity */
final class i extends b {
    final /* synthetic */ CinecismDetailActivity a;

    i(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void a(long j) {
        CinecismDetailActivity.a;
        this.a.b(CinecismDetailActivity.t(this.a));
        if (this.a.p != null) {
            CustomWebView a = this.a.p;
            StringBuilder stringBuilder = new StringBuilder("javascript:window.user_del_comment(");
            stringBuilder.append(j);
            stringBuilder.append(k.t);
            a.a(stringBuilder.toString());
        }
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        CinecismDetailActivity.a;
        new StringBuilder("onCommentCommitted--newComment=").append(commentInfo);
        this.a.b(CinecismDetailActivity.u(this.a));
        XLToast.showToast(this.a, "发送评论成功");
        boolean z = false;
        this.a.j.a(false);
        this.a.j.dismiss();
        this.a.j.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        this.a.j.a(j);
        JSONObject toJSONObject = commentInfo.toJSONObject();
        if (this.a.p != null) {
            CustomWebView a = this.a.p;
            StringBuilder stringBuilder = new StringBuilder("javascript:window.user_add_comment(");
            stringBuilder.append(toJSONObject.toString());
            stringBuilder.append(k.t);
            a.a(stringBuilder.toString());
        }
        j = 0;
        if (targetCommentInfo != null) {
            z = true;
            j = targetCommentInfo.getId();
        }
        z.a(this.a.e, this.a.c(), j, commentInfo.getId(), z, "success", "");
    }

    public final void a(int i, String str) {
        CinecismDetailActivity.a;
        StringBuilder stringBuilder = new StringBuilder("onError--type=");
        stringBuilder.append(i);
        stringBuilder.append("|errorCode=");
        stringBuilder.append(str);
        if (i == 4) {
            int i2;
            if (TextUtils.isEmpty(this.a.j.a()) == 0) {
                this.a.j.a(true);
            } else {
                this.a.j.a(false);
            }
            this.a.j.e = null;
            i = this.a.j.b;
            long j = 0;
            if (i != 0) {
                j = i.getId();
                i2 = 1;
            } else {
                i2 = 0;
            }
            z.a(this.a.e, this.a.c(), j, -1, i2, "fail", str);
        } else if (i == 9) {
            XLToast.showToast(this.a, "删除评论失败");
        }
    }
}
