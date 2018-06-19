package com.xunlei.downloadprovider.contentpublish.website.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovidershare.k;

/* compiled from: WebsiteCardView */
public class a extends FrameLayout {
    private static int x = d.a().b.r();
    public UserInfoTagView a;
    private ViewGroup b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private FollowBtnView h;
    private TextView i;
    private WebsiteView j;
    private LikeView k;
    private TextView l;
    private View m;
    private TextView n;
    private View o;
    private View p;
    private View q;
    private n r;
    private k s;
    private OnClickListener t;
    private OnLongClickListener u;
    private WebsiteInfo v;
    private VideoUserInfo w;
    private e y = new d(this);

    public boolean a(long j) {
        return true;
    }

    public a(@NonNull Context context, n nVar) {
        super(context);
        this.r = nVar;
        context = LayoutInflater.from(getContext()).inflate(R.layout.website_card, this);
        this.b = (ViewGroup) context.findViewById(R.id.layout_user_info);
        this.c = (ImageView) context.findViewById(R.id.publisher_icon);
        this.d = (TextView) context.findViewById(R.id.publisher_name);
        this.a = (UserInfoTagView) context.findViewById(R.id.view_user_info_tag);
        this.h = (FollowBtnView) context.findViewById(R.id.tv_follow_btn);
        this.f = (TextView) context.findViewById(R.id.tv_update_time);
        this.g = (TextView) context.findViewById(R.id.tv_update_time_right);
        this.e = (TextView) context.findViewById(R.id.tv_from_youliao_shot);
        this.e.setText("分享链接");
        this.e.setVisibility(0);
        this.i = (TextView) context.findViewById(R.id.tv_description);
        this.j = (WebsiteView) context.findViewById(R.id.layout_website_view);
        this.j.setOnLongClickListener(new b(this));
        this.j.setOnClickListener(new e(this));
        this.n = (TextView) context.findViewById(R.id.item_share_count);
        this.o = context.findViewById(R.id.share_count_layout);
        this.k = (LikeView) context.findViewById(R.id.like_count_layout);
        this.l = (TextView) context.findViewById(R.id.item_comment_count);
        this.m = context.findViewById(R.id.comment_count_layout);
        this.p = context.findViewById(R.id.ll_share_comment);
        this.q = context.findViewById(R.id.layout_website_bottom);
    }

    public final void a(WebsiteInfo websiteInfo, VideoUserInfo videoUserInfo) {
        this.v = websiteInfo;
        this.w = videoUserInfo;
        setOnClickListener(new f(this));
        if (!TextUtils.isEmpty(videoUserInfo.getUid())) {
            if (!TextUtils.isEmpty(videoUserInfo.getNickname())) {
                if (TextUtils.isEmpty(videoUserInfo.getPortraitUrl())) {
                    this.c.setImageResource(R.drawable.feedflow_icon_default);
                } else {
                    b.a();
                    b.a(videoUserInfo.getPortraitUrl(), this.c);
                }
                this.d.setText(videoUserInfo.getNickname());
                this.a.setUserInfo(videoUserInfo);
                this.b.setOnClickListener(new h(this, videoUserInfo));
                if (a(websiteInfo.c)) {
                    this.f.setVisibility(8);
                    if (videoUserInfo.isPub()) {
                        this.e.setVisibility(0);
                    } else {
                        this.e.setVisibility(8);
                    }
                } else {
                    this.f.setVisibility(0);
                    this.e.setVisibility(0);
                    CharSequence formatRelativeTime3 = DateUtil.formatRelativeTime3(websiteInfo.c);
                    TextView textView = this.f;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(formatRelativeTime3);
                    stringBuilder.append(" ");
                    textView.setText(stringBuilder.toString());
                    this.g.setText(formatRelativeTime3);
                }
                setFollowBtn(videoUserInfo);
                setDescription(websiteInfo);
                this.j.a(websiteInfo);
                switch (x) {
                    case 2:
                        this.i.setVisibility(8);
                        this.p.setVisibility(0);
                        this.q.setVisibility(8);
                        break;
                    case 3:
                        this.i.setVisibility(8);
                        this.p.setVisibility(8);
                        this.q.setVisibility(0);
                        this.q.setOnClickListener(new g(this));
                        break;
                    default:
                        this.i.setVisibility(0);
                        this.p.setVisibility(0);
                        this.q.setVisibility(8);
                        break;
                }
                setShareInfo$7a4d7137(websiteInfo);
                this.o.setOnClickListener(new i(this));
                if (websiteInfo.l > null) {
                    this.l.setText("评论");
                } else {
                    this.l.setText(ConvertUtil.decimal2String((long) websiteInfo.l, 10000, 10000, "万"));
                }
                this.m.setOnClickListener(new m(this));
                setLikeInfo(websiteInfo);
            }
        }
        this.c.setImageResource(R.drawable.feedflow_icon_default);
        this.d.setText("迅雷用户");
        this.a.setUserInfo(videoUserInfo);
        this.b.setOnClickListener(new h(this, videoUserInfo));
        if (a(websiteInfo.c)) {
            this.f.setVisibility(8);
            if (videoUserInfo.isPub()) {
                this.e.setVisibility(8);
            } else {
                this.e.setVisibility(0);
            }
        } else {
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            CharSequence formatRelativeTime32 = DateUtil.formatRelativeTime3(websiteInfo.c);
            TextView textView2 = this.f;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(formatRelativeTime32);
            stringBuilder2.append(" ");
            textView2.setText(stringBuilder2.toString());
            this.g.setText(formatRelativeTime32);
        }
        setFollowBtn(videoUserInfo);
        setDescription(websiteInfo);
        this.j.a(websiteInfo);
        switch (x) {
            case 2:
                this.i.setVisibility(8);
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                break;
            case 3:
                this.i.setVisibility(8);
                this.p.setVisibility(8);
                this.q.setVisibility(0);
                this.q.setOnClickListener(new g(this));
                break;
            default:
                this.i.setVisibility(0);
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                break;
        }
        setShareInfo$7a4d7137(websiteInfo);
        this.o.setOnClickListener(new i(this));
        if (websiteInfo.l > null) {
            this.l.setText(ConvertUtil.decimal2String((long) websiteInfo.l, 10000, 10000, "万"));
        } else {
            this.l.setText("评论");
        }
        this.m.setOnClickListener(new m(this));
        setLikeInfo(websiteInfo);
    }

    private void setFollowBtn(VideoUserInfo videoUserInfo) {
        this.h.setUserInfo(videoUserInfo);
        this.h.setFollowListener(new k(this));
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            f.a().a(5, this.y);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f.a().b(5, this.y);
    }

    private void setLikeCountAndState(WebsiteInfo websiteInfo) {
        this.k.a(websiteInfo.j, websiteInfo.k);
    }

    public void setFollowBtnVisibility(int i) {
        this.h.setVisibility(i);
    }

    public void setPublishTimeVisibility(int i) {
        this.f.setVisibility(i);
    }

    public void setRightPublishTimeVisibility(int i) {
        this.g.setVisibility(i);
    }

    public n getReportStrategy() {
        return this.r;
    }

    public void setOnDeleteClickListener(OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void setPublisherLayoutOnClickListener(OnClickListener onClickListener) {
        this.b.setOnClickListener(onClickListener);
        if (onClickListener == null) {
            this.b.setClickable(false);
        }
    }

    public void setOnLongClickListener(@Nullable OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.u = onLongClickListener;
    }

    private void setDescription(WebsiteInfo websiteInfo) {
        if (TextUtils.isEmpty(websiteInfo.d)) {
            this.i.setVisibility(8);
            return;
        }
        this.i.setText(websiteInfo.d);
        this.i.setVisibility(0);
        this.i.setOnLongClickListener(new l(this));
    }

    private void setShareInfo$7a4d7137(WebsiteInfo websiteInfo) {
        if (websiteInfo.m <= 0) {
            this.n.setText("分享");
        } else {
            this.n.setText(ConvertUtil.decimal2String((long) websiteInfo.m, 10000, 10000, "万"));
        }
    }

    private void setLikeInfo(WebsiteInfo websiteInfo) {
        if (websiteInfo != null) {
            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
            if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(5, websiteInfo.a)) {
                websiteInfo.j = true;
                int i = websiteInfo.k;
                com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                websiteInfo.k = Math.max(i, com.xunlei.downloadprovider.homepage.recommend.feed.k.d(5, websiteInfo.a));
            }
        }
        setLikeCountAndState(websiteInfo);
        this.k.setOnClickListener(new c(this, websiteInfo));
    }

    static /* synthetic */ boolean d(a aVar) {
        if (aVar.v.n == 0) {
            XLToast.showToast(aVar.getContext(), "内容审核中，请稍后再试");
            return false;
        } else if (aVar.v.n != 2) {
            return true;
        } else {
            XLToast.showToast(aVar.getContext(), "内容已下线");
            return false;
        }
    }

    static /* synthetic */ void h(a aVar) {
        if (aVar.v != null) {
            aVar.v.m++;
            aVar.setShareInfo$7a4d7137(aVar.v);
        }
    }
}
