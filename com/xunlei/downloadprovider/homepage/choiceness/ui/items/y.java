package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.photoarticle.PhotoArticleDetailActivity;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.s;
import com.xunlei.downloadprovidershare.k;

/* compiled from: ChoicenessPhotoArticleView */
public final class y extends FrameLayout implements OnClickListener, b<c> {
    private static final int b = getPosterWidth();
    private static final int c = DipPixelUtil.dip2px(3.0f);
    a a;
    private c d;
    private i e;
    private k f = new ad(this);
    private e g = new ae(this);

    /* compiled from: ChoicenessPhotoArticleView */
    private class a {
        View a;
        ImageView b;
        TextView c;
        UserInfoTagView d;
        TextView e;
        View f;
        ImageView g;
        ViewGroup h;
        ImageView i;
        ImageView j;
        ImageView k;
        TextView l;
        LikeView m;
        TextView n;
        View o;
        TextView p;
        View q;
        FollowBtnView r;
        TextView s;
        final /* synthetic */ y t;

        private a(y yVar) {
            this.t = yVar;
        }
    }

    @NonNull
    public final String getReportContentType() {
        return "news";
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, com.xunlei.downloadprovider.homepage.choiceness.a.a.e eVar) {
        c cVar = (c) eVar;
        this.d = cVar;
        a aVar = (a) getTag();
        this.a = aVar;
        iVar = cVar.a;
        i2 = cVar.b;
        aVar.e.setText(iVar.c);
        if (TextUtils.isEmpty(i2.getUid()) == null) {
            if (TextUtils.isEmpty(i2.getNickname()) == null) {
                aVar.a.setVisibility(0);
                if (TextUtils.isEmpty(i2.getPortraitUrl()) != null) {
                    aVar.b.setImageResource(R.drawable.feedflow_icon_default);
                } else {
                    com.xunlei.downloadprovider.homepage.choiceness.b.a();
                    com.xunlei.downloadprovider.homepage.choiceness.b.a(i2.getPortraitUrl(), aVar.b);
                }
                aVar.c.setText(i2.getNickname());
                aVar.d.setUserInfo(i2);
                aVar.a.setOnClickListener(this);
                aVar.r.setVisibility(0);
                aVar.r.setUserInfo(i2);
                aVar.r.setFollowListener(new ac(this));
                i2 = iVar.e;
                if ((d.a().b.p() != 3 ? i2.size() : 1) != 3) {
                    aVar.g.setVisibility(8);
                    aVar.f.setVisibility(8);
                    aVar.h.setVisibility(0);
                    aVar.h.getLayoutParams().height = b;
                    view = new LayoutParams(b, b);
                    view.rightMargin = c;
                    aVar.i.setLayoutParams(view);
                    aVar.j.setLayoutParams(view);
                    aVar.k.setLayoutParams(new LayoutParams(b, b));
                    com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(0), aVar.i, null);
                    com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(1), aVar.j, null);
                    com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(2), aVar.k, null);
                    aVar.h.requestLayout();
                } else {
                    aVar.g.setVisibility(0);
                    aVar.f.setVisibility(0);
                    aVar.h.setVisibility(8);
                    if (i2.size() <= null) {
                        com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(0), aVar.g, new ab(this));
                    } else {
                        aVar.g.setImageResource(R.drawable.choiceness_icon_default);
                    }
                }
                if (iVar.i > 0) {
                    this.a.n.setText("评论");
                } else {
                    this.a.n.setText(ConvertUtil.decimal2String((long) iVar.i, 10000, 10000, "万"));
                }
                aVar.o.setOnClickListener(this);
                b(aVar, iVar);
                aVar.m.b();
                aVar.m.setOnClickListener(this);
                c(aVar, iVar);
                aVar.q.setOnClickListener(this);
            }
        }
        aVar.a.setVisibility(0);
        aVar.b.setImageResource(R.drawable.feedflow_icon_default);
        aVar.c.setText("迅雷用户");
        aVar.d.setUserInfo(i2);
        aVar.a.setOnClickListener(this);
        aVar.r.setVisibility(0);
        aVar.r.setUserInfo(i2);
        aVar.r.setFollowListener(new ac(this));
        i2 = iVar.e;
        if (d.a().b.p() != 3) {
        }
        if ((d.a().b.p() != 3 ? i2.size() : 1) != 3) {
            aVar.g.setVisibility(0);
            aVar.f.setVisibility(0);
            aVar.h.setVisibility(8);
            if (i2.size() <= null) {
                aVar.g.setImageResource(R.drawable.choiceness_icon_default);
            } else {
                com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(0), aVar.g, new ab(this));
            }
        } else {
            aVar.g.setVisibility(8);
            aVar.f.setVisibility(8);
            aVar.h.setVisibility(0);
            aVar.h.getLayoutParams().height = b;
            view = new LayoutParams(b, b);
            view.rightMargin = c;
            aVar.i.setLayoutParams(view);
            aVar.j.setLayoutParams(view);
            aVar.k.setLayoutParams(new LayoutParams(b, b));
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(0), aVar.i, null);
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(1), aVar.j, null);
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a((String) i2.get(2), aVar.k, null);
            aVar.h.requestLayout();
        }
        if (iVar.i > 0) {
            this.a.n.setText(ConvertUtil.decimal2String((long) iVar.i, 10000, 10000, "万"));
        } else {
            this.a.n.setText("评论");
        }
        aVar.o.setOnClickListener(this);
        b(aVar, iVar);
        aVar.m.b();
        aVar.m.setOnClickListener(this);
        c(aVar, iVar);
        aVar.q.setOnClickListener(this);
    }

    public y(Context context, i iVar) {
        super(context);
        this.e = iVar;
        context = LayoutInflater.from(context).inflate(R.layout.choiceness_photo_article_item, this, true);
        iVar = new a();
        iVar.a = context.findViewById(R.id.publisher_layout);
        iVar.b = (ImageView) context.findViewById(R.id.publisher_icon);
        iVar.c = (TextView) context.findViewById(R.id.publisher_name);
        iVar.e = (TextView) context.findViewById(R.id.article_title);
        iVar.f = context.findViewById(R.id.tv_article_icon);
        iVar.g = (ImageView) context.findViewById(R.id.article_poster);
        iVar.h = (ViewGroup) context.findViewById(R.id.layout_3_poster);
        iVar.i = (ImageView) iVar.h.findViewById(R.id.iv_poster_1);
        iVar.j = (ImageView) iVar.h.findViewById(R.id.iv_poster_2);
        iVar.k = (ImageView) iVar.h.findViewById(R.id.iv_poster_3);
        iVar.l = (TextView) context.findViewById(R.id.tv_update_time);
        iVar.l.setVisibility(8);
        iVar.m = (LikeView) context.findViewById(R.id.like_count_layout);
        iVar.n = (TextView) context.findViewById(R.id.item_comment_count);
        iVar.o = context.findViewById(R.id.comment_count_layout);
        iVar.p = (TextView) context.findViewById(R.id.item_share_count);
        iVar.q = context.findViewById(R.id.share_count_layout);
        iVar.r = (FollowBtnView) context.findViewById(R.id.tv_follow_btn);
        iVar.d = (UserInfoTagView) context.findViewById(R.id.view_user_info_tag);
        iVar.s = (TextView) context.findViewById(R.id.tv_from_youliao_shot);
        iVar.s.setVisibility(8);
        iVar.g.setOnClickListener(new z(this));
        context.setOnClickListener(new aa(this));
        setTag(iVar);
        context = iVar.g;
        iVar = s.a();
        int i = (iVar * 9) / 16;
        ViewGroup.LayoutParams layoutParams = context.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(iVar, i);
        } else {
            layoutParams.width = iVar;
            layoutParams.height = i;
        }
        context.setLayoutParams(layoutParams);
    }

    private static int getPosterWidth() {
        Resources resources = BrothersApplication.getApplicationInstance().getResources();
        return (int) (((((float) resources.getDisplayMetrics().widthPixels) - (2.0f * resources.getDimension(R.dimen.common_padding_left_normal))) - ((float) (2 * DipPixelUtil.dip2px(3.0f)))) / 3.0f);
    }

    private static void b(a aVar, PhotoArticleInfo photoArticleInfo) {
        aVar.m.a(photoArticleInfo.g, photoArticleInfo.h);
    }

    public final void onClick(View view) {
        view = view.getId();
        if (view != R.id.publisher_layout) {
            boolean z = false;
            if (view == R.id.share_count_layout) {
                view = com.xunlei.downloadprovider.f.c.a("home_choiceness", this.d.a);
                com.xunlei.downloadprovider.f.a.a();
                com.xunlei.downloadprovider.f.a.a((Activity) getContext(), view, this.f);
                ChoicenessReporter.a(this.d, false, getReportContentType());
            } else if (view == R.id.comment_count_layout) {
                PhotoArticleDetailActivity.a(getContext(), "home_collect_discuss", this.d.a, this.d.b, true);
            } else if (view == R.id.like_count_layout) {
                if (this.d.a.g == null) {
                    view = this.d.a;
                    this.a.m.a();
                    com.xunlei.downloadprovider.e.a.d dVar = new com.xunlei.downloadprovider.e.a.d(view.a, view.a, view.h);
                    dVar.a = 9;
                    f.a().a(getContext(), dVar, null);
                    com.xunlei.downloadprovider.homepage.follow.b.a().e(this.d.a.f);
                    z = true;
                }
                if (z) {
                    ChoicenessReporter.a(this.d, "", getReportContentType());
                }
            }
        } else {
            view = this.d.a;
            VideoUserInfo videoUserInfo = this.d.b;
            String nickname = videoUserInfo.getNickname();
            String portraitUrl = videoUserInfo.getPortraitUrl();
            m.a(getContext(), view.f, videoUserInfo.getKind(), nickname, portraitUrl, From.HOME_COLLECT_NEWS);
            ChoicenessReporter.a(this.d.b.getKind(), getReportContentType());
        }
    }

    public final void a() {
        PhotoArticleDetailActivity.a(getContext(), "home_collect_card", this.d.a, this.d.b, false);
        ChoicenessReporter.a(this.d);
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f.a().b(9, this.g);
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.a().a(9, this.g);
    }

    private static void c(a aVar, PhotoArticleInfo photoArticleInfo) {
        if (photoArticleInfo.j <= 0) {
            aVar.p.setText("分享");
        } else {
            aVar.p.setText(ConvertUtil.decimal2String((long) photoArticleInfo.j, 10000, 10000, "万"));
        }
    }

    static /* synthetic */ void b(y yVar) {
        if (yVar.d != null) {
            PhotoArticleInfo photoArticleInfo = yVar.d.a;
            photoArticleInfo.j++;
            com.xunlei.downloadprovider.e.b.b.a();
            com.xunlei.downloadprovider.e.b.b.a(photoArticleInfo.a);
            c(yVar.a, photoArticleInfo);
        }
    }
}
