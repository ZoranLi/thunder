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
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.List;

/* compiled from: TaskCommentItemViewHolder */
public final class ar extends aq {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final TextView e;
    private final a f;
    private final View g;
    private TextView h;
    private final TextView i;
    private final TextView j;
    private final ImageView k;
    private final View l;
    private final ImageView m;
    private final ImageView n;
    private TextView o;
    private ImageView p;
    private View q;
    private UserInfoTagView r;
    private CommentInfo s;
    private boolean t = false;
    private boolean u = false;
    private ap v;

    public ar(View view, ap apVar, a aVar) {
        super(view);
        this.v = apVar;
        this.f = aVar;
        this.g = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.m = (ImageView) view.findViewById(R.id.iv_icon_extra);
        this.b = (TextView) view.findViewById(R.id.tv_name);
        this.c = (TextView) view.findViewById(R.id.tv_content);
        this.r = (UserInfoTagView) view.findViewById(R.id.view_user_info_tag);
        this.l = view.findViewById(R.id.lyt_target);
        this.j = (TextView) view.findViewById(R.id.tv_target);
        this.h = (TextView) view.findViewById(R.id.tv_location);
        this.d = (TextView) view.findViewById(R.id.tv_time);
        this.n = (ImageView) view.findViewById(R.id.iv_device);
        this.i = (TextView) view.findViewById(R.id.tv_speed);
        this.k = (ImageView) view.findViewById(R.id.iv_toggle);
        this.j.getViewTreeObserver().addOnPreDrawListener(new as(this));
        this.q = view.findViewById(R.id.lyt_good);
        this.p = (ImageView) view.findViewById(R.id.iv_good_icon);
        this.o = (TextView) view.findViewById(R.id.tv_good_count);
        this.e = (TextView) view.findViewById(R.id.tv_plus_one);
        view.findViewById(R.id.btn_reply).setOnClickListener(new aw(this));
        view.setOnClickListener(new ax(this));
        view.setOnLongClickListener(new ay(this));
        this.a.setOnClickListener(new az(this));
        this.b.setOnClickListener(new ba(this));
        this.j.setOnClickListener(new bb(this));
        this.k.setOnClickListener(new bc(this));
        this.q.setOnClickListener(new bd(this));
    }

    private void a(long j) {
        j = ConvertUtil.decimal2String(j, 10000, 10000, "万");
        if (j.trim().contentEquals("0")) {
            j = "";
        }
        this.o.setText(j);
    }

    public final void a(aw awVar) {
        if (awVar != null) {
            if (awVar.b instanceof CommentInfo) {
                Object city;
                long time;
                long j;
                this.s = (CommentInfo) awVar.b;
                this.t = false;
                this.j.setMaxLines(Integer.MAX_VALUE);
                this.e.setVisibility(8);
                this.k.setRotation(0.0f);
                String userAvatar = this.s.getUserAvatar();
                if (TextUtils.isEmpty(userAvatar)) {
                    this.a.setImageResource(R.drawable.ic_default_avatar);
                } else {
                    b.a();
                    b.a(userAvatar, this.a);
                }
                VideoUserInfo relatedUserInfo = this.s.getRelatedUserInfo();
                this.m.setVisibility(8);
                if (relatedUserInfo != null) {
                    this.r.setUserInfo(relatedUserInfo);
                    String province = relatedUserInfo.getProvince();
                    city = relatedUserInfo.getCity();
                    if (com.xunlei.downloadprovider.publiser.common.a.a.c(province)) {
                        city = province;
                    }
                    if (TextUtils.isEmpty(city)) {
                        this.h.setVisibility(8);
                    } else {
                        this.h.setText(com.xunlei.downloadprovider.publiser.common.a.a.a(city).replace("市", ""));
                        this.h.setVisibility(0);
                    }
                } else {
                    this.r.setVisibility(8);
                }
                this.b.setText(this.s.getUserName());
                this.b.setVisibility(0);
                if (this.s.getRelatedUserInfo() == null || !this.s.getRelatedUserInfo().isVip()) {
                    this.b.setTextColor(Color.parseColor("#5a6473"));
                } else {
                    this.b.setTextColor(Color.parseColor("#fc5546"));
                }
                CharSequence content = this.s.getContent();
                if (TextUtils.isEmpty(content)) {
                    this.c.setText("    ");
                } else {
                    this.c.setText(content);
                }
                List targetCommentList = this.s.getTargetCommentList();
                if (targetCommentList == null || targetCommentList.size() <= 0) {
                    this.l.setVisibility(8);
                } else {
                    TargetCommentInfo targetCommentInfo = (TargetCommentInfo) targetCommentList.get(0);
                    if (targetCommentInfo.getId() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(targetCommentInfo.getUserName());
                        stringBuilder.append(": ");
                        stringBuilder.append(targetCommentInfo.getContent());
                        CharSequence spannableString = new SpannableString(stringBuilder.toString());
                        spannableString.setSpan(new av(this, targetCommentInfo), 0, targetCommentInfo.getUserName().length(), 17);
                        this.j.setText(spannableString);
                        this.j.setMovementMethod(LinkMovementMethod.getInstance());
                        this.j.setFocusable(true);
                    } else {
                        this.j.setText("此条评论已被删除");
                    }
                    this.l.setVisibility(0);
                }
                city = this.s.getDevie();
                if (TextUtils.isEmpty(city) || city.equalsIgnoreCase("pc")) {
                    this.n.setImageLevel(1);
                } else {
                    this.n.setImageLevel(0);
                }
                userAvatar = this.s.getDownloadSpeed();
                if (!TextUtils.isEmpty(userAvatar)) {
                    aw awVar2;
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
                                if (a(userAvatar) == null) {
                                    this.i.setTextColor(Color.parseColor("#ff9600"));
                                } else {
                                    this.i.setTextColor(Color.parseColor("#969aa0"));
                                }
                                time = this.s.getTime();
                                if (time > 0) {
                                    j = this.v.d;
                                    if (j == -1) {
                                        j = System.currentTimeMillis();
                                        this.v.d = j;
                                    }
                                    this.d.setText(DateUtil.formatRelativeTime(time, j));
                                } else {
                                    this.d.setText("");
                                }
                                awVar = this.s.isLiked();
                                a(this.s.getLikeCount());
                                this.o.setEnabled(awVar ^ 1);
                                this.p.setEnabled(awVar ^ 1);
                                return;
                            }
                        }
                    }
                    awVar2 = null;
                    if (awVar2 != null) {
                        this.i.setText(userAvatar);
                        this.i.setVisibility(0);
                        if (a(userAvatar) == null) {
                            this.i.setTextColor(Color.parseColor("#969aa0"));
                        } else {
                            this.i.setTextColor(Color.parseColor("#ff9600"));
                        }
                        time = this.s.getTime();
                        if (time > 0) {
                            this.d.setText("");
                        } else {
                            j = this.v.d;
                            if (j == -1) {
                                j = System.currentTimeMillis();
                                this.v.d = j;
                            }
                            this.d.setText(DateUtil.formatRelativeTime(time, j));
                        }
                        awVar = this.s.isLiked();
                        a(this.s.getLikeCount());
                        this.o.setEnabled(awVar ^ 1);
                        this.p.setEnabled(awVar ^ 1);
                        return;
                    }
                }
                this.i.setVisibility(8);
                time = this.s.getTime();
                if (time > 0) {
                    j = this.v.d;
                    if (j == -1) {
                        j = System.currentTimeMillis();
                        this.v.d = j;
                    }
                    this.d.setText(DateUtil.formatRelativeTime(time, j));
                } else {
                    this.d.setText("");
                }
                awVar = this.s.isLiked();
                a(this.s.getLikeCount());
                this.o.setEnabled(awVar ^ 1);
                this.p.setEnabled(awVar ^ 1);
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.shortvideo.videodetail.a.ar.a(java.lang.String):boolean");
    }

    static /* synthetic */ void j(ar arVar) {
        arVar.k.animate().rotation(arVar.u ? 0.0f : 180.0f);
        arVar.j.setMaxLines(arVar.u ? 2 : Integer.MAX_VALUE);
        arVar.u ^= 1;
    }

    static /* synthetic */ void k(ar arVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(arVar.q.getContext(), R.anim.scale_in);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(arVar.q.getContext(), R.anim.scale_out);
        Animation loadAnimation3 = AnimationUtils.loadAnimation(arVar.q.getContext(), R.anim.scale_out2);
        loadAnimation.setAnimationListener(new at(arVar, loadAnimation2));
        loadAnimation3.setAnimationListener(new au(arVar));
        arVar.e.setVisibility(0);
        arVar.p.startAnimation(loadAnimation);
        arVar.e.startAnimation(loadAnimation3);
        if (arVar.s != null) {
            arVar.s.setLikeCount(arVar.s.getLikeCount() + 1);
            arVar.s.setLiked(true);
            arVar.a(arVar.s.getLikeCount());
        }
    }
}
