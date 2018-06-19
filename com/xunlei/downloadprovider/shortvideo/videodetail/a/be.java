package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;
import com.xunlei.downloadprovider.download.taskdetails.ae;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.ay;
import com.xunlei.xllib.b.j;
import java.util.List;

/* compiled from: TaskCommentItemViewHolderNew */
public final class be extends aq {
    private ImageView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private a g;
    private View h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private View l;
    private ImageView m;
    private TextView n;
    private ImageView o;
    private View p;
    private ImageView q;
    private CommentInfo r;
    private boolean s = false;
    private boolean t = false;
    private ap u;
    private volatile long v = -1;

    public be(View view, ap apVar, a aVar) {
        super(view);
        this.u = apVar;
        this.g = aVar;
        this.h = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.m = (ImageView) view.findViewById(R.id.iv_icon_extra);
        this.b = (TextView) view.findViewById(R.id.tv_name);
        this.c = (TextView) view.findViewById(R.id.tv_content);
        this.l = view.findViewById(R.id.lyt_target);
        this.j = (TextView) view.findViewById(R.id.tv_target);
        this.d = (TextView) view.findViewById(R.id.tv_time);
        this.e = (TextView) view.findViewById(R.id.play_position);
        this.i = (TextView) view.findViewById(R.id.tv_speed);
        this.k = (ImageView) view.findViewById(R.id.iv_toggle);
        this.q = (ImageView) view.findViewById(R.id.iv_guide_pop);
        this.j.getViewTreeObserver().addOnPreDrawListener(new bf(this));
        this.p = view.findViewById(R.id.lyt_good);
        this.o = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.n = (TextView) view.findViewById(R.id.tv_good_count);
        this.f = (TextView) view.findViewById(R.id.tv_plus_one);
        view.findViewById(R.id.btn_reply).setOnClickListener(new bk(this));
        view.setOnClickListener(new bl(this));
        view.setOnLongClickListener(new bm(this));
        this.a.setOnClickListener(new bn(this));
        this.b.setOnClickListener(new bo(this));
        this.j.setOnClickListener(new bp(this));
        this.k.setOnClickListener(new bq(this));
        this.p.setOnClickListener(new br(this));
    }

    private void a(long j) {
        j = ConvertUtil.decimal2String(j, 10000, 10000, "万");
        if (j.trim().contentEquals("0")) {
            j = "";
        }
        this.n.setText(j);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof CommentInfo) {
                long time;
                long j;
                TextView textView;
                StringBuilder stringBuilder;
                StringBuilder stringBuilder2;
                ImageView imageView;
                this.r = (CommentInfo) awVar.b;
                this.s = false;
                this.j.setMaxLines(Integer.MAX_VALUE);
                this.f.setVisibility(8);
                this.k.setRotation(0.0f);
                String userAvatar = this.r.getUserAvatar();
                if (TextUtils.isEmpty(userAvatar)) {
                    this.a.setImageResource(R.drawable.ic_default_avatar);
                } else {
                    b.a();
                    b.a(userAvatar, this.a);
                }
                VideoUserInfo relatedUserInfo = this.r.getRelatedUserInfo();
                if (relatedUserInfo != null) {
                    int a = ay.a(relatedUserInfo.getVipInfo());
                    if (a != 0) {
                        this.m.setImageResource(a);
                        this.m.setVisibility(0);
                    } else {
                        this.m.setVisibility(8);
                    }
                } else {
                    this.m.setVisibility(8);
                }
                this.b.setText(this.r.getUserName());
                this.b.setVisibility(0);
                if (this.r.getRelatedUserInfo() == null || !this.r.getRelatedUserInfo().isVip()) {
                    this.b.setTextColor(Color.parseColor("#5a6473"));
                } else {
                    this.b.setTextColor(Color.parseColor("#fc5546"));
                }
                CharSequence content = this.r.getContent();
                if (TextUtils.isEmpty(content)) {
                    this.c.setText("    ");
                } else {
                    this.c.setText(content);
                }
                List targetCommentList = this.r.getTargetCommentList();
                if (targetCommentList == null || targetCommentList.size() <= 0) {
                    this.l.setVisibility(8);
                } else {
                    TargetCommentInfo targetCommentInfo = (TargetCommentInfo) targetCommentList.get(0);
                    if (targetCommentInfo.getId() > 0) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(targetCommentInfo.getUserName());
                        stringBuilder3.append(": ");
                        stringBuilder3.append(targetCommentInfo.getContent());
                        CharSequence spannableString = new SpannableString(stringBuilder3.toString());
                        spannableString.setSpan(new bi(this, targetCommentInfo), 0, targetCommentInfo.getUserName().length(), 17);
                        this.j.setText(spannableString);
                        this.j.setMovementMethod(LinkMovementMethod.getInstance());
                        this.j.setFocusable(true);
                    } else {
                        this.j.setText("此条评论已被删除");
                    }
                    this.l.setVisibility(0);
                }
                userAvatar = this.r.getDownloadSpeed();
                if (!TextUtils.isEmpty(userAvatar)) {
                    aw awVar2;
                    Drawable drawable;
                    if (!TextUtils.isEmpty(userAvatar)) {
                        int indexOf = userAvatar.indexOf(77);
                        if (indexOf < 0) {
                            indexOf = userAvatar.indexOf("m");
                        }
                        if (indexOf >= 0) {
                            awVar2 = true;
                            if (awVar2 != null) {
                                this.i.setText(userAvatar);
                                this.i.setVisibility(0);
                                if (a(userAvatar)) {
                                    this.i.setTextColor(Color.parseColor("#969aa0"));
                                    this.i.setCompoundDrawables(null, null, null, null);
                                } else {
                                    this.i.setTextColor(Color.parseColor("#ff9600"));
                                    drawable = this.i.getContext().getResources().getDrawable(R.drawable.ic_task_comment_network_speed_high);
                                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                                    this.i.setCompoundDrawablePadding(DipPixelUtil.dip2px(3.0f));
                                    this.i.setCompoundDrawables(null, null, drawable, null);
                                }
                                time = this.r.getTime();
                                if (time > 0) {
                                    j = this.u.d;
                                    if (j == -1) {
                                        j = System.currentTimeMillis();
                                        this.u.d = j;
                                    }
                                    this.d.setText(DateUtil.formatRelativeTime(time, j));
                                } else {
                                    this.d.setText("");
                                }
                                if (this.v == this.r.getId()) {
                                    this.q.setVisibility(0);
                                } else {
                                    this.q.setVisibility(8);
                                }
                                if (com.xunlei.downloadprovider.download.taskdetails.b.b.a(this.r)) {
                                    if (this.r.getPlayPosition() > 500) {
                                        textView = this.e;
                                        stringBuilder = new StringBuilder("播到");
                                        stringBuilder.append(j.a((long) this.r.getPlayPosition()));
                                        textView.setText(stringBuilder.toString());
                                    } else {
                                        textView = this.e;
                                        stringBuilder2 = new StringBuilder("播到");
                                        stringBuilder2.append(j.a((long) (this.r.getPlayPosition() + 500)));
                                        textView.setText(stringBuilder2.toString());
                                    }
                                    this.e.setVisibility(0);
                                    imageView = this.q;
                                    if (!ae.a()) {
                                        imageView.setVisibility(0);
                                        BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).edit().putBoolean("download_showed_comment_guide", true).apply();
                                        this.v = this.r.getId();
                                        new Handler(Looper.getMainLooper()).postDelayed(new bj(this, imageView), 3000);
                                    }
                                } else {
                                    this.e.setVisibility(8);
                                }
                                awVar = this.r.isLiked();
                                a(this.r.getLikeCount());
                                this.n.setEnabled(awVar ^ 1);
                                this.o.setEnabled(awVar ^ 1);
                                return;
                            }
                        }
                    }
                    awVar2 = null;
                    if (awVar2 != null) {
                        this.i.setText(userAvatar);
                        this.i.setVisibility(0);
                        if (a(userAvatar)) {
                            this.i.setTextColor(Color.parseColor("#969aa0"));
                            this.i.setCompoundDrawables(null, null, null, null);
                        } else {
                            this.i.setTextColor(Color.parseColor("#ff9600"));
                            drawable = this.i.getContext().getResources().getDrawable(R.drawable.ic_task_comment_network_speed_high);
                            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                            this.i.setCompoundDrawablePadding(DipPixelUtil.dip2px(3.0f));
                            this.i.setCompoundDrawables(null, null, drawable, null);
                        }
                        time = this.r.getTime();
                        if (time > 0) {
                            this.d.setText("");
                        } else {
                            j = this.u.d;
                            if (j == -1) {
                                j = System.currentTimeMillis();
                                this.u.d = j;
                            }
                            this.d.setText(DateUtil.formatRelativeTime(time, j));
                        }
                        if (this.v == this.r.getId()) {
                            this.q.setVisibility(8);
                        } else {
                            this.q.setVisibility(0);
                        }
                        if (com.xunlei.downloadprovider.download.taskdetails.b.b.a(this.r)) {
                            this.e.setVisibility(8);
                        } else {
                            if (this.r.getPlayPosition() > 500) {
                                textView = this.e;
                                stringBuilder2 = new StringBuilder("播到");
                                stringBuilder2.append(j.a((long) (this.r.getPlayPosition() + 500)));
                                textView.setText(stringBuilder2.toString());
                            } else {
                                textView = this.e;
                                stringBuilder = new StringBuilder("播到");
                                stringBuilder.append(j.a((long) this.r.getPlayPosition()));
                                textView.setText(stringBuilder.toString());
                            }
                            this.e.setVisibility(0);
                            imageView = this.q;
                            if (ae.a()) {
                                imageView.setVisibility(0);
                                BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).edit().putBoolean("download_showed_comment_guide", true).apply();
                                this.v = this.r.getId();
                                new Handler(Looper.getMainLooper()).postDelayed(new bj(this, imageView), 3000);
                            }
                        }
                        awVar = this.r.isLiked();
                        a(this.r.getLikeCount());
                        this.n.setEnabled(awVar ^ 1);
                        this.o.setEnabled(awVar ^ 1);
                        return;
                    }
                }
                this.i.setVisibility(8);
                time = this.r.getTime();
                if (time > 0) {
                    j = this.u.d;
                    if (j == -1) {
                        j = System.currentTimeMillis();
                        this.u.d = j;
                    }
                    this.d.setText(DateUtil.formatRelativeTime(time, j));
                } else {
                    this.d.setText("");
                }
                if (this.v == this.r.getId()) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                if (com.xunlei.downloadprovider.download.taskdetails.b.b.a(this.r)) {
                    if (this.r.getPlayPosition() > 500) {
                        textView = this.e;
                        stringBuilder = new StringBuilder("播到");
                        stringBuilder.append(j.a((long) this.r.getPlayPosition()));
                        textView.setText(stringBuilder.toString());
                    } else {
                        textView = this.e;
                        stringBuilder2 = new StringBuilder("播到");
                        stringBuilder2.append(j.a((long) (this.r.getPlayPosition() + 500)));
                        textView.setText(stringBuilder2.toString());
                    }
                    this.e.setVisibility(0);
                    imageView = this.q;
                    if (ae.a()) {
                        imageView.setVisibility(0);
                        BrothersApplication.getApplicationInstance().getSharedPreferences("download_task_sp_name", 0).edit().putBoolean("download_showed_comment_guide", true).apply();
                        this.v = this.r.getId();
                        new Handler(Looper.getMainLooper()).postDelayed(new bj(this, imageView), 3000);
                    }
                } else {
                    this.e.setVisibility(8);
                }
                awVar = this.r.isLiked();
                a(this.r.getLikeCount());
                this.n.setEnabled(awVar ^ 1);
                this.o.setEnabled(awVar ^ 1);
                return;
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }

    private static boolean a(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 77;
        r1 = r2.indexOf(r1);
        if (r1 >= 0) goto L_0x0012;
    L_0x000c:
        r1 = "m";
        r1 = r2.indexOf(r1);
    L_0x0012:
        if (r1 >= 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r2 = r2.substring(r0, r1);
        r2 = java.lang.Float.parseFloat(r2);	 Catch:{ NumberFormatException -> 0x0026 }
        r1 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r2 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1));
        if (r2 >= 0) goto L_0x0024;
    L_0x0023:
        return r0;
    L_0x0024:
        r2 = 1;
        return r2;
    L_0x0026:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.shortvideo.videodetail.a.be.a(java.lang.String):boolean");
    }

    static /* synthetic */ void j(be beVar) {
        beVar.k.animate().rotation(beVar.t ? 0.0f : 180.0f);
        beVar.j.setMaxLines(beVar.t ? 2 : Integer.MAX_VALUE);
        beVar.t ^= 1;
    }

    static /* synthetic */ void k(be beVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(beVar.p.getContext(), R.anim.scale_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(beVar.p.getContext(), R.anim.scale_out);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(beVar.p.getContext(), R.anim.scale_out2);
        loadAnimation.setAnimationListener(new bg(beVar, loadAnimation2));
        loadAnimation3.setAnimationListener(new bh(beVar));
        beVar.f.setVisibility(0);
        beVar.o.startAnimation(loadAnimation);
        beVar.f.startAnimation(loadAnimation3);
        if (beVar.r != null) {
            beVar.r.setLikeCount(beVar.r.getLikeCount() + 1);
            beVar.r.setLiked(true);
            beVar.a(beVar.r.getLikeCount());
        }
    }
}
