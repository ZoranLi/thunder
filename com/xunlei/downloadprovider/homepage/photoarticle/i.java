package com.xunlei.downloadprovider.homepage.photoarticle;

import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.comment.entity.f;
import com.xunlei.downloadprovider.homepage.recommend.a.v;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.g.b;
import java.util.List;

/* compiled from: PhotoArticleDetailActivity */
final class i extends b {
    final /* synthetic */ PhotoArticleDetailActivity a;

    i(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void a(int i, f fVar) {
        StringBuilder stringBuilder = new StringBuilder("onCommentDataComplete--totalSize=");
        stringBuilder.append(i);
        stringBuilder.append("|data=");
        stringBuilder.append(fVar);
        this.a.a = 2;
        if (this.a.j != 0) {
            this.a.j.a(fVar);
            if (fVar != null) {
                this.a.r = fVar.c;
                this.a.b(this.a.r);
                PhotoArticleDetailActivity.a(this.a, fVar.e);
                i = fVar.c > this.a.j.b() ? 1 : 0;
                this.a.i.setLoadingMoreEnabled(i);
                if (i == 0) {
                    this.a.i.a(this.a.r);
                }
                if (this.a.d != 0) {
                    this.a.w.postDelayed(this.a.I, 800);
                    this.a.d = false;
                }
            }
        }
    }

    public final void a(f fVar) {
        new StringBuilder("onMoreCommentDataComplete--data=").append(fVar);
        this.a.a = 2;
        if (this.a.j != null) {
            boolean z = false;
            if (fVar == null) {
                this.a.i.setLoadingMoreEnabled(false);
                this.a.i.a(this.a.r);
                XLToast.showToast(this.a, "没有更多评论了");
                return;
            }
            List list = fVar.e;
            if (list != null) {
                if (list.size() != 0) {
                    PhotoArticleDetailActivity.a(this.a, list);
                    this.a.j.a(fVar);
                    this.a.i.a = false;
                    if (fVar.c > this.a.j.b()) {
                        z = true;
                    }
                    this.a.i.setLoadingMoreEnabled(z);
                    if (!z) {
                        this.a.i.a(this.a.r);
                    }
                    return;
                }
            }
            this.a.i.setLoadingMoreEnabled(false);
            this.a.i.a(this.a.r);
            XLToast.showToast(this.a, "没有更多评论了");
        }
    }

    public final void a(long j) {
        if (this.a.j != null) {
            this.a.b(PhotoArticleDetailActivity.x(this.a));
            a i = this.a.j;
            List list = i.b;
            int i2 = -1;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                aw awVar = (aw) list.get(i3);
                if (awVar.b != null && (awVar.b instanceof CommentInfo) && j == ((CommentInfo) awVar.b).getId()) {
                    list.remove(i3);
                    i2 = i3;
                    break;
                }
            }
            if (i2 >= 0) {
                i.a(false);
            }
        }
    }

    public final void b(f fVar) {
        new StringBuilder("onHotCommentDataComplete--data=").append(fVar);
        if (fVar != null && this.a.j == null) {
        }
    }

    public final void a(CommentInfo commentInfo) {
        long j;
        new StringBuilder("onCommentCommitted--newComment=").append(commentInfo);
        this.a.b(PhotoArticleDetailActivity.y(this.a));
        XLToast.showToast(this.a, "发送评论成功");
        boolean z = false;
        this.a.o.a(false);
        this.a.o.dismiss();
        this.a.o.a("");
        TargetCommentInfo targetCommentInfo = commentInfo.getTargetCommentList() != null ? (TargetCommentInfo) commentInfo.getTargetCommentList().get(0) : null;
        if (targetCommentInfo == null) {
            j = -1;
        } else {
            j = targetCommentInfo.getId();
        }
        long j2 = j;
        this.a.o.a(j2);
        a i = this.a.j;
        if (i.b.isEmpty()) {
            i.b.add(new aw(3, commentInfo));
        } else {
            i.b.add(0, new aw(3, commentInfo));
        }
        i.a(false);
        String str = "0";
        String e = this.a.f;
        String f = this.a.h();
        long id = commentInfo.getId();
        if (targetCommentInfo != null) {
            z = true;
        }
        y.a(true, str, e, f, j2, id, z);
    }

    public final void b(CommentInfo commentInfo) {
        StringBuilder stringBuilder = new StringBuilder("onCommentLikeCommitted--info=");
        stringBuilder.append(commentInfo);
        stringBuilder.append("|set=true");
    }

    public final void a(int i, List<v> list) {
        super.a(i, (List) list);
        if (this.a.j != 0) {
            i = this.a.j;
            i.i = list;
            if (i.h != null) {
                i.f.c = list;
                i.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("onError--type=");
        stringBuilder.append(i);
        stringBuilder.append("|errorCode=");
        stringBuilder.append(str);
        if (this.a.j != null) {
            if (i == 9) {
                XLToast.showToast(this.a, "删除评论失败");
            } else if (i != 12) {
                switch (i) {
                    case 3:
                        this.a.a = 1;
                        a i2 = this.a.j;
                        if (i2.e == null) {
                            i2.e = new aw(6, null);
                        }
                        i2.a(false);
                        return;
                    case 4:
                        if (TextUtils.isEmpty(this.a.o.a())) {
                            this.a.o.a(false);
                        } else {
                            this.a.o.a(true);
                        }
                        this.a.o.e = null;
                        CommentInfo commentInfo = this.a.o.b;
                        y.a(false, str, this.a.f, this.a.h(), commentInfo == null ? -1 : commentInfo.getId(), -1, commentInfo != null);
                        break;
                    default:
                        break;
                }
            } else {
                this.a.a = 1;
                this.a.i.a();
            }
        }
    }
}
