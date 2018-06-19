package com.xunlei.downloadprovider.homepage.cinecism.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.f.c;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.d;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.cinecism.CinecismDetailActivity;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.s;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.k;

@SuppressLint({"ViewConstructor"})
/* compiled from: CinecismCardView */
public class a extends FrameLayout implements OnClickListener {
    private d a;
    private a b;
    private int c;
    private com.xunlei.downloadprovider.homepage.cinecism.a d;
    private k e = new f(this);
    private e f = new g(this);

    /* compiled from: CinecismCardView */
    private class a {
        View a;
        ImageView b;
        TextView c;
        UserInfoTagView d;
        TextView e;
        TextView f;
        FrameLayout g;
        TextView h;
        TextViewFixTouchConsume i;
        ImageView j;
        LinearLayout k;
        ImageView l;
        ImageView m;
        ImageView n;
        TextView o;
        TextView p;
        TextView q;
        LikeView r;
        TextView s;
        View t;
        TextView u;
        View v;
        FollowBtnView w;
        final /* synthetic */ a x;

        private a(a aVar) {
            this.x = aVar;
        }
    }

    public a(@NonNull Context context, com.xunlei.downloadprovider.homepage.cinecism.a aVar) {
        super(context);
        context = LayoutInflater.from(context).inflate(R.layout.choiceness_cinecism_item, this);
        a aVar2 = new a();
        aVar2.a = context.findViewById(R.id.publisher_layout);
        aVar2.b = (ImageView) context.findViewById(R.id.publisher_icon);
        aVar2.c = (TextView) context.findViewById(R.id.publisher_name);
        aVar2.d = (UserInfoTagView) context.findViewById(R.id.view_user_info_tag);
        aVar2.e = (TextView) context.findViewById(R.id.tv_update_time);
        aVar2.e.setVisibility(8);
        aVar2.f = (TextView) context.findViewById(R.id.tv_from_youliao_shot);
        aVar2.f.setVisibility(8);
        aVar2.g = (FrameLayout) context.findViewById(R.id.cinecism_poster_layout);
        aVar2.h = (TextView) context.findViewById(R.id.cinecism_title);
        aVar2.i = (TextViewFixTouchConsume) context.findViewById(R.id.cinecism_summary);
        aVar2.j = (ImageView) context.findViewById(R.id.cinecism_poster);
        aVar2.k = (LinearLayout) context.findViewById(R.id.three_image_layout);
        aVar2.l = (ImageView) context.findViewById(R.id.cinecism_poster1);
        aVar2.m = (ImageView) context.findViewById(R.id.cinecism_poster2);
        aVar2.n = (ImageView) context.findViewById(R.id.cinecism_poster3);
        aVar2.o = (TextView) context.findViewById(R.id.tv_update_time_right);
        aVar2.p = (TextView) context.findViewById(R.id.tv_cinecism_show);
        aVar2.q = (TextView) context.findViewById(R.id.tv_cinecism_image_number);
        aVar2.r = (LikeView) context.findViewById(R.id.like_count_layout);
        aVar2.s = (TextView) context.findViewById(R.id.item_comment_count);
        aVar2.t = context.findViewById(R.id.comment_count_layout);
        aVar2.u = (TextView) context.findViewById(R.id.item_share_count);
        aVar2.v = context.findViewById(R.id.share_count_layout);
        aVar2.w = (FollowBtnView) context.findViewById(R.id.tv_follow_btn);
        this.b = aVar2;
        int a = s.a();
        int i = (a / 16) * 9;
        LayoutParams layoutParams = this.b.g.getLayoutParams();
        layoutParams.width = a;
        layoutParams.height = i;
        this.b.g.setLayoutParams(layoutParams);
        context.setOnClickListener(new b(this));
        this.d = aVar;
    }

    public final void a(d dVar, int i) {
        if (dVar != null) {
            a aVar;
            StringBuilder stringBuilder = new StringBuilder("bindData:id");
            stringBuilder.append(dVar.a.a);
            stringBuilder.append(",type:");
            stringBuilder.append(i);
            this.c = i;
            this.a = dVar;
            i = dVar.a;
            VideoUserInfo videoUserInfo = dVar.b;
            if (this.c == 49 && (i.o == null || i.o.size() < 3)) {
                this.c = 47;
            }
            a aVar2 = this.b;
            if (!TextUtils.isEmpty(videoUserInfo.getUid())) {
                if (!TextUtils.isEmpty(videoUserInfo.getNickname())) {
                    aVar2.a.setVisibility(0);
                    if (TextUtils.isEmpty(videoUserInfo.getPortraitUrl())) {
                        aVar2.b.setImageResource(R.drawable.feedflow_icon_default);
                    } else {
                        b.a();
                        b.a(videoUserInfo.getPortraitUrl(), aVar2.b);
                    }
                    aVar2.c.setText(videoUserInfo.getNickname());
                    aVar2.d.setUserInfo(videoUserInfo);
                    this.b.a.setOnClickListener(this);
                    aVar = this.b;
                    aVar.w.setUserInfo(dVar.b);
                    aVar.w.setFollowListener(new c(this));
                    dVar = this.b;
                    dVar.h.setText(i.b);
                    dVar.i.setText(i.c);
                    a(dVar.i, i.c, "全文", Color.parseColor("#1AA3FF"));
                    if (this.c != 49) {
                        b.a().a((String) i.o.get(0), dVar.l, null);
                        b.a().a((String) i.o.get(1), dVar.m, null);
                        b.a().a((String) i.o.get(2), dVar.n, null);
                        dVar.k.setVisibility(0);
                        dVar.j.setVisibility(8);
                    } else {
                        dVar.k.setVisibility(8);
                        dVar.j.setVisibility(0);
                        if (TextUtils.isEmpty(i.d)) {
                            b.a().a(i.d, dVar.j, null);
                        } else {
                            dVar.j.setImageResource(R.drawable.choiceness_icon_default);
                        }
                    }
                    dVar.o.setText(DateUtil.formatRelativeTime3(this.a.a.k));
                    if (i.j <= 0) {
                        dVar.p.setText(getResources().getString(R.string.cinecism_show_time, new Object[]{j.a((long) r0)}));
                        dVar.p.setVisibility(0);
                    } else {
                        dVar.p.setVisibility(8);
                    }
                    if (i.p <= 0) {
                        dVar.q.setText(getResources().getString(R.string.cinecism_image_number, new Object[]{Integer.valueOf(r0)}));
                        dVar.q.setVisibility(0);
                    } else {
                        dVar.q.setVisibility(8);
                    }
                    if (this.c != 49) {
                        if (this.c == 47) {
                            dVar.e.setVisibility(8);
                            if (i.h > null) {
                                this.b.s.setText("评论");
                            } else {
                                this.b.s.setText(ConvertUtil.decimal2String((long) i.h, 10000, 10000, "万"));
                            }
                            this.b.t.setOnClickListener(this);
                            dVar = this.b;
                            b(dVar, i);
                            dVar.r.b();
                            this.b.r.setOnClickListener(this);
                            c(this.b, i);
                            this.b.v.setOnClickListener(this);
                        }
                    }
                    if (!TextUtils.isEmpty(i.n)) {
                        dVar.e.setText(getResources().getString(R.string.cinecism_movie_name, new Object[]{i.n}));
                        dVar.e.setVisibility(0);
                    } else if (TextUtils.isEmpty(i.m)) {
                        dVar.e.setText(getResources().getString(R.string.cinecism_movie_name, new Object[]{i.m}));
                        dVar.e.setVisibility(0);
                    } else {
                        dVar.e.setVisibility(8);
                    }
                    if (i.h > null) {
                        this.b.s.setText(ConvertUtil.decimal2String((long) i.h, 10000, 10000, "万"));
                    } else {
                        this.b.s.setText("评论");
                    }
                    this.b.t.setOnClickListener(this);
                    dVar = this.b;
                    b(dVar, i);
                    dVar.r.b();
                    this.b.r.setOnClickListener(this);
                    c(this.b, i);
                    this.b.v.setOnClickListener(this);
                }
            }
            aVar2.a.setVisibility(0);
            aVar2.b.setImageResource(R.drawable.feedflow_icon_default);
            aVar2.c.setText("迅雷用户");
            aVar2.d.setUserInfo(videoUserInfo);
            this.b.a.setOnClickListener(this);
            aVar = this.b;
            aVar.w.setUserInfo(dVar.b);
            aVar.w.setFollowListener(new c(this));
            dVar = this.b;
            dVar.h.setText(i.b);
            dVar.i.setText(i.c);
            a(dVar.i, i.c, "全文", Color.parseColor("#1AA3FF"));
            if (this.c != 49) {
                dVar.k.setVisibility(8);
                dVar.j.setVisibility(0);
                if (TextUtils.isEmpty(i.d)) {
                    dVar.j.setImageResource(R.drawable.choiceness_icon_default);
                } else {
                    b.a().a(i.d, dVar.j, null);
                }
            } else {
                b.a().a((String) i.o.get(0), dVar.l, null);
                b.a().a((String) i.o.get(1), dVar.m, null);
                b.a().a((String) i.o.get(2), dVar.n, null);
                dVar.k.setVisibility(0);
                dVar.j.setVisibility(8);
            }
            dVar.o.setText(DateUtil.formatRelativeTime3(this.a.a.k));
            if (i.j <= 0) {
                dVar.p.setVisibility(8);
            } else {
                dVar.p.setText(getResources().getString(R.string.cinecism_show_time, new Object[]{j.a((long) r0)}));
                dVar.p.setVisibility(0);
            }
            if (i.p <= 0) {
                dVar.q.setVisibility(8);
            } else {
                dVar.q.setText(getResources().getString(R.string.cinecism_image_number, new Object[]{Integer.valueOf(r0)}));
                dVar.q.setVisibility(0);
            }
            if (this.c != 49) {
                if (this.c == 47) {
                    dVar.e.setVisibility(8);
                    if (i.h > null) {
                        this.b.s.setText("评论");
                    } else {
                        this.b.s.setText(ConvertUtil.decimal2String((long) i.h, 10000, 10000, "万"));
                    }
                    this.b.t.setOnClickListener(this);
                    dVar = this.b;
                    b(dVar, i);
                    dVar.r.b();
                    this.b.r.setOnClickListener(this);
                    c(this.b, i);
                    this.b.v.setOnClickListener(this);
                }
            }
            if (!TextUtils.isEmpty(i.n)) {
                dVar.e.setText(getResources().getString(R.string.cinecism_movie_name, new Object[]{i.n}));
                dVar.e.setVisibility(0);
            } else if (TextUtils.isEmpty(i.m)) {
                dVar.e.setVisibility(8);
            } else {
                dVar.e.setText(getResources().getString(R.string.cinecism_movie_name, new Object[]{i.m}));
                dVar.e.setVisibility(0);
            }
            if (i.h > null) {
                this.b.s.setText(ConvertUtil.decimal2String((long) i.h, 10000, 10000, "万"));
            } else {
                this.b.s.setText("评论");
            }
            this.b.t.setOnClickListener(this);
            dVar = this.b;
            b(dVar, i);
            dVar.r.b();
            this.b.r.setOnClickListener(this);
            c(this.b, i);
            this.b.v.setOnClickListener(this);
        }
    }

    private static void b(a aVar, CinecismInfo cinecismInfo) {
        aVar.r.a(cinecismInfo.f, cinecismInfo.g);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.publisher_layout) {
            view = this.a.b;
            String nickname = view.getNickname();
            String portraitUrl = view.getPortraitUrl();
            m.a(getContext(), this.a.a.e, view.getKind(), nickname, portraitUrl, this.d.h());
            ChoicenessReporter.a(view.getKind(), this.d.g());
        } else if (view != R.id.share_count_layout) {
            boolean z = true;
            if (view == R.id.comment_count_layout) {
                CinecismDetailActivity.a(getContext(), this.d.g(), this.a.a, this.a.b, true);
                this.d.d();
            } else if (view == R.id.like_count_layout) {
                view = this.a.a;
                if (view.f) {
                    z = false;
                } else {
                    this.b.r.a();
                    com.xunlei.downloadprovider.e.a.d dVar = new com.xunlei.downloadprovider.e.a.d(view.a, view.a, view.g);
                    dVar.a = 8;
                    f.a().a(getContext(), dVar, null);
                    com.xunlei.downloadprovider.homepage.follow.b.a().e(view.e);
                }
                if (z) {
                    this.d.b();
                }
            }
        } else {
            view = c.a(this.d.f(), this.a.a);
            com.xunlei.downloadprovidershare.b.c b = com.xunlei.downloadprovidershare.b.a.b();
            long c = LoginHelper.a().g.c();
            if (c > 0 && this.a.a.e == c) {
                b.a(ShareOperationType.REPORT);
            }
            com.xunlei.downloadprovider.f.a.a();
            com.xunlei.downloadprovider.f.a.b((Activity) getContext(), view, this.e, b);
            this.d.e();
        }
    }

    public final void a() {
        CinecismDetailActivity.a(getContext(), this.d.g(), this.a.a, this.a.b, false);
        this.d.a();
    }

    private synchronized void a(TextView textView, String str, String str2, int i) {
        int a = (com.xunlei.xllib.android.d.a(getContext()) - textView.getPaddingLeft()) - textView.getPaddingRight();
        str = str.replaceAll("\n", "\t");
        TextPaint paint = textView.getPaint();
        int lineStart = new StaticLayout(str, paint, a, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineStart(2);
        int[] iArr = new int[]{0};
        StringBuilder stringBuilder = new StringBuilder("…");
        stringBuilder.append(str2);
        int measureText = (int) paint.measureText(stringBuilder.toString());
        TextUtils.ellipsize(str.substring(lineStart, str.length()), paint, (float) (a - measureText), TruncateAt.END, false, new d(this, iArr));
        if (iArr[0] != 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str.substring(0, lineStart + iArr[0]));
            stringBuilder2.append("…");
            stringBuilder2.append(str2);
            str = stringBuilder2.toString();
            CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new e(this, i), str.length() - str2.length(), str.length(), 17);
            textView.setText(spannableStringBuilder);
            textView.setMovementMethod(com.xunlei.downloadprovider.homepage.cinecism.ui.TextViewFixTouchConsume.a.a());
            textView.setFocusable(false);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f.a().b(8, this.f);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        f.a().a(8, this.f);
    }

    public com.xunlei.downloadprovider.homepage.cinecism.a getReportStrategy() {
        return this.d;
    }

    public void setFollowBtnVisibility(int i) {
        this.b.w.setVisibility(i);
    }

    public void setUserInfoTagVisibility(int i) {
        this.b.d.setVisibility(i);
    }

    public void setRightPublishTimeVisibility(int i) {
        this.b.o.setVisibility(i);
    }

    public void setPublisherLayoutOnClickListener(OnClickListener onClickListener) {
        this.b.a.setOnClickListener(onClickListener);
    }

    private static void c(a aVar, CinecismInfo cinecismInfo) {
        if (cinecismInfo.i <= 0) {
            aVar.u.setText("分享");
        } else {
            aVar.u.setText(ConvertUtil.decimal2String((long) cinecismInfo.i, 10000, 10000, "万"));
        }
    }

    static /* synthetic */ void c(a aVar) {
        if (aVar.a != null) {
            CinecismInfo cinecismInfo = aVar.a.a;
            cinecismInfo.i++;
            com.xunlei.downloadprovider.e.b.b.a();
            com.xunlei.downloadprovider.e.b.b.a(cinecismInfo.a);
            c(aVar.b, cinecismInfo);
        }
    }
}
