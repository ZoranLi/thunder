package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.ay;
import java.util.List;

/* compiled from: CommentItemViewHolder */
public final class n extends aq {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final TextView e;
    private final a f;
    private final View g;
    private final TextView h;
    private final ImageView i;
    private final View j;
    private View k;
    private TextView l;
    private ImageView m;
    private View n;
    private CommentInfo o;
    private boolean p = false;
    private boolean q = false;
    private ImageView r;
    private ImageView s;

    public n(View view, a aVar) {
        super(view);
        this.f = aVar;
        this.g = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.k = view.findViewById(R.id.iv_publisher);
        this.b = (TextView) view.findViewById(R.id.tv_name);
        this.c = (TextView) view.findViewById(R.id.tv_content);
        this.j = view.findViewById(R.id.lyt_target);
        this.h = (TextView) view.findViewById(R.id.tv_target);
        this.d = (TextView) view.findViewById(R.id.tv_time);
        this.i = (ImageView) view.findViewById(R.id.iv_toggle);
        this.r = (ImageView) view.findViewById(R.id.iv_gender);
        this.s = (ImageView) view.findViewById(R.id.iv_icon_extra);
        this.h.getViewTreeObserver().addOnPreDrawListener(new o(this));
        this.n = view.findViewById(R.id.lyt_good);
        this.m = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.l = (TextView) view.findViewById(R.id.tv_good_count);
        this.e = (TextView) view.findViewById(R.id.tv_plus_one);
        view.findViewById(R.id.btn_reply).setOnClickListener(new s(this));
        view.setOnClickListener(new t(this));
        view.setOnLongClickListener(new u(this));
        this.a.setOnClickListener(new v(this));
        this.b.setOnClickListener(new w(this));
        this.h.setOnClickListener(new x(this));
        this.i.setOnClickListener(new y(this));
        this.n.setOnClickListener(new z(this));
    }

    private void a(long j) {
        j = ConvertUtil.decimal2String(j, 10000, 10000, "万");
        if (j.trim().contentEquals("0")) {
            j = "";
        }
        this.l.setText(j);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof CommentInfo) {
                this.o = (CommentInfo) awVar.b;
                this.p = false;
                this.h.setMaxLines(Integer.MAX_VALUE);
                this.e.setVisibility(8);
                this.i.setRotation(0.0f);
                String userAvatar = this.o.getUserAvatar();
                if (TextUtils.isEmpty(userAvatar)) {
                    this.a.setImageResource(R.drawable.ic_default_avatar_new);
                } else {
                    b.a();
                    b.a(userAvatar, this.a);
                }
                this.k.setVisibility(this.o.isPublisher() ? 0 : 8);
                if (this.o.getRelatedUserInfo().getGender() == Gender.MALE) {
                    this.r.setImageResource(R.drawable.user_info_tag_gender_male_mini);
                    this.r.setVisibility(0);
                } else if (this.o.getRelatedUserInfo().getGender() == Gender.FEMALE) {
                    this.r.setImageResource(R.drawable.user_info_tag_gender_female_mini);
                    this.r.setVisibility(0);
                } else {
                    this.r.setVisibility(8);
                }
                this.b.setText(this.o.getUserName());
                this.b.setVisibility(0);
                if (this.o.getRelatedUserInfo() == null || !this.o.getRelatedUserInfo().isVip()) {
                    this.b.setTextColor(Color.parseColor("#5a6473"));
                } else {
                    this.b.setTextColor(Color.parseColor("#fc5546"));
                }
                VideoUserInfo relatedUserInfo = this.o.getRelatedUserInfo();
                if (relatedUserInfo != null) {
                    int a = ay.a(relatedUserInfo.getVipInfo());
                    if (a != 0) {
                        this.s.setImageResource(a);
                        this.s.setVisibility(0);
                    } else {
                        this.s.setVisibility(8);
                    }
                } else {
                    this.s.setVisibility(8);
                }
                CharSequence content = this.o.getContent();
                if (TextUtils.isEmpty(content)) {
                    this.c.setText("    ");
                } else {
                    this.c.setText(content);
                }
                List targetCommentList = this.o.getTargetCommentList();
                if (targetCommentList == null || targetCommentList.size() <= 0) {
                    this.j.setVisibility(8);
                } else {
                    TargetCommentInfo targetCommentInfo = (TargetCommentInfo) targetCommentList.get(0);
                    if (targetCommentInfo.getId() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(targetCommentInfo.getUserName());
                        stringBuilder.append(": ");
                        stringBuilder.append(targetCommentInfo.getContent());
                        CharSequence spannableString = new SpannableString(stringBuilder.toString());
                        spannableString.setSpan(new r(this, targetCommentInfo), 0, targetCommentInfo.getUserName().length(), 17);
                        this.h.setText(spannableString);
                        this.h.setMovementMethod(LinkMovementMethod.getInstance());
                        this.h.setFocusable(true);
                    } else {
                        this.h.setText("此条评论已被删除");
                    }
                    this.j.setVisibility(0);
                }
                long time = this.o.getTime();
                if (time > 0) {
                    this.d.setText(DateUtil.formatRelativeTime(time));
                } else {
                    this.d.setText("");
                }
                awVar = this.o.isLiked();
                a(this.o.getLikeCount());
                this.l.setEnabled(awVar ^ 1);
                this.m.setEnabled(awVar ^ 1);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }

    static /* synthetic */ void j(n nVar) {
        nVar.i.animate().rotation(nVar.q ? 0.0f : 180.0f);
        nVar.h.setMaxLines(nVar.q ? 2 : Integer.MAX_VALUE);
        nVar.q ^= 1;
    }

    static /* synthetic */ void k(n nVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(nVar.n.getContext(), R.anim.scale_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(nVar.n.getContext(), R.anim.scale_out);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(nVar.n.getContext(), R.anim.scale_out2);
        loadAnimation.setAnimationListener(new p(nVar, loadAnimation2));
        loadAnimation3.setAnimationListener(new q(nVar));
        nVar.e.setVisibility(0);
        nVar.m.startAnimation(loadAnimation);
        nVar.e.startAnimation(loadAnimation3);
        if (nVar.o != null) {
            nVar.o.setLikeCount(nVar.o.getLikeCount() + 1);
            nVar.o.setLiked(true);
            nVar.a(nVar.o.getLikeCount());
        }
    }
}
