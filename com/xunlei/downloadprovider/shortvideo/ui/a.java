package com.xunlei.downloadprovider.shortvideo.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.LikeView;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.VideoTagView;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.player.a.b;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.item.BasePlayerView;
import com.xunlei.downloadprovider.player.xmp.ui.widget.PlayCompleteLikeGuideView;
import com.xunlei.downloadprovider.player.xmp.v;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.downloadprovider.publiser.campaign.p;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.b.c;
import com.xunlei.downloadprovidershare.k;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
/* compiled from: PlayerUgcView */
public class a<T> extends BasePlayerView implements OnClickListener, b, k {
    private int a;
    public a b;
    protected BaseVideoInfo c;
    public r<T> d;
    public boolean e = false;
    public Context f;
    private int g;
    private VideoUserInfo h;
    private com.xunlei.downloadprovider.player.a.a i;
    private Handler j = new Handler(Looper.getMainLooper());
    private OnLongClickListener k;
    private Runnable l = new e(this);
    private e m = new f(this);
    private Runnable n = new i(this);

    /* compiled from: PlayerUgcView */
    public class a {
        public TextView A;
        public FollowBtnView B;
        public View C;
        public VideoTagView D;
        public LottieAnimationView E;
        public ImageView F;
        public LottieAnimationView G;
        public LottieAnimationView H;
        public t I;
        final /* synthetic */ a J;
        public View a;
        public ImageView b;
        public TextView c;
        public LinearLayout d;
        public int e;
        public ImageView f;
        public TextView g;
        public View h;
        public FrameLayout i;
        public ImageView j;
        public View k;
        public View l;
        public View m;
        public ImageView n;
        public TextView o;
        public LikeView p;
        public TextView q;
        public View r;
        public TextView s;
        public View t;
        public ViewGroup u;
        public ImageView v;
        public TextView w;
        public TextView x;
        public UserInfoTagView y;
        public TextView z;

        public a(a aVar) {
            this.J = aVar;
        }
    }

    public boolean a(boolean z, long j) {
        return true;
    }

    public final boolean d() {
        return true;
    }

    public boolean e() {
        return false;
    }

    public boolean h() {
        return true;
    }

    public boolean i() {
        return false;
    }

    public a(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context);
        this.f = context;
        this.i = aVar;
        this.a = s.a();
        this.g = this.a;
        context = LayoutInflater.from(context).inflate(R.layout.auto_play_limit_item, this, true);
        aVar = new a(this);
        this.b = aVar;
        aVar.a = context;
        aVar.b = (ImageView) context.findViewById(R.id.iv_top_rank);
        aVar.d = (LinearLayout) context.findViewById(R.id.linear_parent_view);
        aVar.h = context.findViewById(R.id.item_icon_layout);
        aVar.i = (FrameLayout) context.findViewById(R.id.item_player_container);
        aVar.j = (ImageView) context.findViewById(R.id.item_poster);
        aVar.j.setOnLongClickListener(new b(this));
        aVar.k = context.findViewById(R.id.tv_original_icon);
        aVar.l = context.findViewById(R.id.layout_video_status_reviewing);
        aVar.m = context.findViewById(R.id.layout_video_status_not_pass);
        aVar.n = (ImageView) context.findViewById(R.id.play_icon);
        aVar.c = (TextView) context.findViewById(R.id.item_title);
        aVar.f = (ImageView) context.findViewById(R.id.iv_gradient_bg);
        aVar.o = (TextView) context.findViewById(R.id.item_play_count);
        aVar.p = (LikeView) context.findViewById(R.id.like_count_layout);
        aVar.g = (TextView) context.findViewById(R.id.item_duration);
        aVar.q = (TextView) context.findViewById(R.id.item_comment_count);
        aVar.r = context.findViewById(R.id.comment_count_layout);
        aVar.u = (ViewGroup) context.findViewById(R.id.publisher_layout);
        aVar.v = (ImageView) context.findViewById(R.id.publisher_icon);
        aVar.w = (TextView) context.findViewById(R.id.publisher_name);
        aVar.x = (TextView) context.findViewById(R.id.tv_from_youliao_shot);
        aVar.y = (UserInfoTagView) context.findViewById(R.id.view_user_info_tag);
        aVar.z = (TextView) context.findViewById(R.id.tv_update_time);
        aVar.A = (TextView) context.findViewById(R.id.tv_update_time_right);
        aVar.B = (FollowBtnView) context.findViewById(R.id.tv_follow_btn);
        aVar.s = (TextView) context.findViewById(R.id.item_share_count);
        aVar.t = context.findViewById(R.id.share_count_layout);
        aVar.D = (VideoTagView) context.findViewById(R.id.video_tag_view);
        aVar.E = (LottieAnimationView) context.findViewById(R.id.lottie_view_share);
        aVar.F = (ImageView) context.findViewById(R.id.iv_red_packet_icon);
        aVar.G = (LottieAnimationView) context.findViewById(R.id.lottie_share1);
        aVar.H = (LottieAnimationView) context.findViewById(R.id.lottie_share2);
        aVar.I = new t(context);
        setTag(aVar);
        context = getLayoutParams();
        if (context == null) {
            context = new LayoutParams(-1, -2);
        } else {
            context.width = -1;
            context.height = -2;
        }
        setLayoutParams(context);
    }

    public r<T> getReportStrategy() {
        return this.d;
    }

    public void a(int i, BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, r<T> rVar) {
        this.d = rVar;
        if (videoUserInfo == null) {
            videoUserInfo = new VideoUserInfo();
        }
        if (!(this.c == baseVideoInfo && this.h == videoUserInfo)) {
            if (getPlayer() != null) {
                getPlayer().r();
            }
            this.c = baseVideoInfo;
            this.h = videoUserInfo;
        }
        this.b.a.setOnClickListener(new j(this));
        a aVar = (a) getTag();
        this.b = aVar;
        aVar.e = i;
        i = baseVideoInfo.getTitle();
        if (TextUtils.isEmpty(i) && this.c.getAudioInfo() == null) {
            aVar.c.setVisibility(8);
        } else {
            p.a(aVar.c, i, this.c.getAudioInfo(), aVar.D.getFrom());
            aVar.c.setVisibility(0);
            aVar.c.setOnClickListener(new o(this));
        }
        aVar.g.setText(j.a(baseVideoInfo.getDuration()));
        n();
        i = baseVideoInfo.getCoverUrl();
        int posterWidth = baseVideoInfo.getPosterWidth();
        int posterHeight = baseVideoInfo.getPosterHeight();
        if (!TextUtils.isEmpty(i)) {
            StringBuilder stringBuilder = new StringBuilder("displayPoster--posterWidth=");
            stringBuilder.append(posterWidth);
            stringBuilder.append("|posterHeight=");
            stringBuilder.append(posterHeight);
            stringBuilder.append("|url=");
            stringBuilder.append(i);
            ImageView imageView = aVar.j;
            imageView.setScaleType(ScaleType.CENTER_CROP);
            if (posterWidth != 0) {
                if (posterHeight != 0) {
                    a(posterWidth, posterHeight);
                    com.xunlei.downloadprovider.homepage.choiceness.b.a().a(i, imageView, null);
                }
            }
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(i, imageView, new p(this));
        }
        aVar.j.setOnClickListener(this);
        a(baseVideoInfo, videoUserInfo, aVar);
        if (TextUtils.isEmpty(videoUserInfo.getUid()) == 0) {
            if (TextUtils.isEmpty(videoUserInfo.getNickname()) == 0) {
                aVar.u.setVisibility(0);
                if (TextUtils.isEmpty(videoUserInfo.getPortraitUrl()) != 0) {
                    aVar.v.setImageResource(R.drawable.feedflow_icon_default);
                } else {
                    com.xunlei.downloadprovider.homepage.choiceness.b.a();
                    com.xunlei.downloadprovider.homepage.choiceness.b.a(videoUserInfo.getPortraitUrl(), aVar.v);
                }
                aVar.w.setText(videoUserInfo.getNickname());
                if (baseVideoInfo.isFromYouLiaoShot() == 0) {
                    aVar.x.setVisibility(0);
                } else {
                    aVar.x.setVisibility(8);
                }
                aVar.y.setUserInfo(videoUserInfo);
                i = a(this.h.isPub(), baseVideoInfo.getUplineTime());
                if (i == 0) {
                    aVar.z.setVisibility(0);
                    videoUserInfo = DateUtil.formatRelativeTime3(baseVideoInfo.getUplineTime());
                    aVar.z.setText(videoUserInfo);
                    aVar.A.setText(videoUserInfo);
                } else {
                    aVar.z.setVisibility(8);
                    aVar.A.setVisibility(8);
                }
                i = (i == 0 && i() == 0) ? 1 : 0;
                BaseVideoInfo.setVideoPlatformTextView(aVar.x, baseVideoInfo.getVideoType(), i);
                aVar.u.setOnClickListener(this);
                if (h() == 0) {
                    aVar.B.setVisibility(0);
                    aVar.B.setUserInfo(this.h);
                    aVar.B.setFollowListener(new k(this));
                } else {
                    aVar.B.setVisibility(8);
                }
                i = baseVideoInfo.getPlayCount();
                if ((getPlayer() == null ? 1 : 0) == 0) {
                    if (i == 0) {
                        aVar.o.setVisibility(0);
                        aVar.o.setText(getResources().getString(R.string.choiceness_play_count, new Object[]{j.a((long) i)}));
                        q();
                        aVar.r.setOnClickListener(this);
                        if (baseVideoInfo != null) {
                            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                            if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, baseVideoInfo.getVideoId()) != 0) {
                                baseVideoInfo.setHasLike(true);
                                i = baseVideoInfo.getLikeCount();
                                com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                                baseVideoInfo.setLikeCount(Math.max(i, com.xunlei.downloadprovider.homepage.recommend.feed.k.d(1, baseVideoInfo.getVideoId())));
                            }
                        }
                        b(aVar, baseVideoInfo);
                        aVar.p.b();
                        aVar.p.setOnClickListener(this);
                        c(aVar, baseVideoInfo);
                        aVar.t.setOnClickListener(this);
                        i = aVar.D;
                        this.c.getTitle();
                        p.a();
                        baseVideoInfo = this.c.getLocationInfo();
                        this.c.getAudioInfo();
                        i.setTags$6ba6a892(baseVideoInfo);
                        aVar.x.setOnClickListener(this);
                    }
                }
                aVar.o.setVisibility(8);
                q();
                aVar.r.setOnClickListener(this);
                if (baseVideoInfo != null) {
                    com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                    if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, baseVideoInfo.getVideoId()) != 0) {
                        baseVideoInfo.setHasLike(true);
                        i = baseVideoInfo.getLikeCount();
                        com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                        baseVideoInfo.setLikeCount(Math.max(i, com.xunlei.downloadprovider.homepage.recommend.feed.k.d(1, baseVideoInfo.getVideoId())));
                    }
                }
                b(aVar, baseVideoInfo);
                aVar.p.b();
                aVar.p.setOnClickListener(this);
                c(aVar, baseVideoInfo);
                aVar.t.setOnClickListener(this);
                i = aVar.D;
                this.c.getTitle();
                p.a();
                baseVideoInfo = this.c.getLocationInfo();
                this.c.getAudioInfo();
                i.setTags$6ba6a892(baseVideoInfo);
                aVar.x.setOnClickListener(this);
            }
        }
        aVar.u.setVisibility(0);
        aVar.v.setImageResource(R.drawable.feedflow_icon_default);
        aVar.w.setText("迅雷用户");
        if (baseVideoInfo.isFromYouLiaoShot() == 0) {
            aVar.x.setVisibility(8);
        } else {
            aVar.x.setVisibility(0);
        }
        aVar.y.setUserInfo(videoUserInfo);
        i = a(this.h.isPub(), baseVideoInfo.getUplineTime());
        if (i == 0) {
            aVar.z.setVisibility(8);
            aVar.A.setVisibility(8);
        } else {
            aVar.z.setVisibility(0);
            videoUserInfo = DateUtil.formatRelativeTime3(baseVideoInfo.getUplineTime());
            aVar.z.setText(videoUserInfo);
            aVar.A.setText(videoUserInfo);
        }
        if (i == 0) {
        }
        BaseVideoInfo.setVideoPlatformTextView(aVar.x, baseVideoInfo.getVideoType(), i);
        aVar.u.setOnClickListener(this);
        if (h() == 0) {
            aVar.B.setVisibility(8);
        } else {
            aVar.B.setVisibility(0);
            aVar.B.setUserInfo(this.h);
            aVar.B.setFollowListener(new k(this));
        }
        i = baseVideoInfo.getPlayCount();
        if (getPlayer() == null) {
        }
        if ((getPlayer() == null ? 1 : 0) == 0) {
            if (i == 0) {
                aVar.o.setVisibility(0);
                aVar.o.setText(getResources().getString(R.string.choiceness_play_count, new Object[]{j.a((long) i)}));
                q();
                aVar.r.setOnClickListener(this);
                if (baseVideoInfo != null) {
                    com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                    if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, baseVideoInfo.getVideoId()) != 0) {
                        baseVideoInfo.setHasLike(true);
                        i = baseVideoInfo.getLikeCount();
                        com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                        baseVideoInfo.setLikeCount(Math.max(i, com.xunlei.downloadprovider.homepage.recommend.feed.k.d(1, baseVideoInfo.getVideoId())));
                    }
                }
                b(aVar, baseVideoInfo);
                aVar.p.b();
                aVar.p.setOnClickListener(this);
                c(aVar, baseVideoInfo);
                aVar.t.setOnClickListener(this);
                i = aVar.D;
                this.c.getTitle();
                p.a();
                baseVideoInfo = this.c.getLocationInfo();
                this.c.getAudioInfo();
                i.setTags$6ba6a892(baseVideoInfo);
                aVar.x.setOnClickListener(this);
            }
        }
        aVar.o.setVisibility(8);
        q();
        aVar.r.setOnClickListener(this);
        if (baseVideoInfo != null) {
            com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
            if (com.xunlei.downloadprovider.homepage.recommend.feed.k.c(1, baseVideoInfo.getVideoId()) != 0) {
                baseVideoInfo.setHasLike(true);
                i = baseVideoInfo.getLikeCount();
                com.xunlei.downloadprovider.homepage.recommend.feed.k.a();
                baseVideoInfo.setLikeCount(Math.max(i, com.xunlei.downloadprovider.homepage.recommend.feed.k.d(1, baseVideoInfo.getVideoId())));
            }
        }
        b(aVar, baseVideoInfo);
        aVar.p.b();
        aVar.p.setOnClickListener(this);
        c(aVar, baseVideoInfo);
        aVar.t.setOnClickListener(this);
        i = aVar.D;
        this.c.getTitle();
        p.a();
        baseVideoInfo = this.c.getLocationInfo();
        this.c.getAudioInfo();
        i.setTags$6ba6a892(baseVideoInfo);
        aVar.x.setOnClickListener(this);
    }

    public final void n() {
        this.j.removeCallbacks(this.n);
        if (this.b != null && this.b.C != null) {
            this.b.C.setVisibility(8);
        }
    }

    private static void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, a aVar) {
        aVar.k.setVisibility(8);
        aVar.l.setVisibility(8);
        aVar.m.setVisibility(8);
        int i = 0;
        if (baseVideoInfo.getStatus() == -1) {
            baseVideoInfo = aVar.l;
        } else if (baseVideoInfo.getStatus() == 0) {
            baseVideoInfo = aVar.m;
        } else {
            aVar = aVar.k;
            if (videoUserInfo.isPub() != null || baseVideoInfo.isFromShot() == null) {
                baseVideoInfo = aVar;
                i = 8;
            } else {
                baseVideoInfo = aVar;
            }
        }
        baseVideoInfo.setVisibility(i);
    }

    public ControlType getPlayerControllerType() {
        return ControlType.AUTO_PLAY;
    }

    protected final boolean f() {
        r();
        return true;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_poster:
                r();
                return;
            case R.id.publisher_layout:
                view = this.c;
                VideoUserInfo videoUserInfo = this.h;
                String nickname = videoUserInfo.getNickname();
                String portraitUrl = videoUserInfo.getPortraitUrl();
                m.a(getContext(), view.getPublisherId(), videoUserInfo.getKind(), nickname, portraitUrl, this.d.c(), view.getGcid(), view.getVideoId());
                return;
            case R.id.tv_from_youliao_shot:
                if (d.a().r.i() != null) {
                    if (this.c.isFromYouLiao() == null) {
                        if (this.c.isFromXLLive() != null) {
                            a(2);
                            break;
                        }
                    }
                    a(1);
                    return;
                }
                break;
            case R.id.share_count_layout:
                if (s() != null) {
                    com.xunlei.downloadprovider.homepage.redpacket.j.a().a((Activity) getContext(), this.d.e(), this.c, this, m());
                    this.d.b(this.e);
                }
                return;
            case R.id.comment_count_layout:
                if (s() != null) {
                    a(true, true);
                    this.d.b();
                }
                return;
            case R.id.like_count_layout:
                a();
                return;
            default:
                break;
        }
    }

    private void r() {
        if (s()) {
            a(false, false);
            this.d.a();
        }
    }

    public final void o() {
        if (s()) {
            a(false, false);
            this.d.a();
        }
    }

    public boolean a() {
        if (!s() || !p()) {
            return false;
        }
        if (getPlayer() != null) {
            getPlayer().b(true);
        }
        this.d.a("bottom");
        return true;
    }

    public boolean g() {
        if (!s() || !p()) {
            return false;
        }
        this.d.a("doubleclick");
        return true;
    }

    public c m() {
        return com.xunlei.downloadprovidershare.b.a.b();
    }

    public final void a(boolean z, boolean z2) {
        a(this.c, this.h, z, this.d.d(), z2);
    }

    public void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, From from, boolean z2) {
        com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a aVar = new com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a();
        aVar.u = from;
        aVar.s = z;
        aVar.t = z2;
        aVar.r = false;
        aVar.q = baseVideoInfo.getServerExtData();
        aVar.a = baseVideoInfo.getVideoId();
        aVar.b = baseVideoInfo.getGcid();
        aVar.c = baseVideoInfo.getTitle();
        aVar.d = baseVideoInfo.getPlayUrl();
        aVar.e = baseVideoInfo.getCoverUrl();
        aVar.f = baseVideoInfo.getLikeCount();
        aVar.g = baseVideoInfo.hasLike();
        aVar.l = videoUserInfo.getNickname();
        aVar.n = videoUserInfo.getPubExtra().a;
        aVar.v = baseVideoInfo;
        aVar.w = videoUserInfo;
        a(aVar);
    }

    public void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z) {
        a(baseVideoInfo, videoUserInfo, z, false);
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, boolean z2) {
        if (baseVideoInfo != null) {
            if (com.xunlei.xllib.android.b.a(getContext())) {
                boolean z3 = true;
                if (com.xunlei.xllib.android.b.d(getContext())) {
                    z3 = ak.a().a(this.c.getVideoId(), getContext(), new l(this, baseVideoInfo, videoUserInfo, z, z2));
                }
                if (z3) {
                    b(baseVideoInfo, videoUserInfo, z, z2);
                }
                return;
            }
            XLToast.showNoNetworkToast(getContext());
        }
    }

    private void b(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, boolean z2) {
        ThunderXmpPlayer j = j();
        boolean z3 = true;
        if (baseVideoInfo.getStatus() != 1) {
            z3 = false;
        }
        j.v = z3;
        String preloadPlayUrl = baseVideoInfo.getPreloadPlayUrl();
        if (TextUtils.isEmpty(preloadPlayUrl)) {
            preloadPlayUrl = baseVideoInfo.getPlayUrl();
        }
        y yVar = new y(baseVideoInfo.getVideoId(), preloadPlayUrl, baseVideoInfo.getTitle());
        yVar.a = baseVideoInfo.getPlayUrl();
        yVar.o = baseVideoInfo.getCoverUrl();
        yVar.k = this.d.f();
        yVar.e = baseVideoInfo.getDuration();
        yVar.f = baseVideoInfo.getGcid();
        yVar.r = baseVideoInfo.getPublisherId();
        yVar.g = z;
        yVar.n = baseVideoInfo.getServerExtData();
        yVar.p = this.b.j.getScaleType();
        yVar.a(this.b.j.getDrawable());
        yVar.s = z2;
        yVar.t = videoUserInfo.getLiveExtra();
        if (j.m() != null) {
            j.e();
        } else {
            j.a(yVar);
        }
    }

    private void a(int i) {
        if (i == 1) {
            if (ApkHelper.isApkPackageInstalled(getContext(), "cn.kuaipan.android") != 0) {
                ApkHelper.launchAppByPackageName(getContext(), "cn.kuaipan.android");
                i = "open";
            } else {
                i = getContext();
                if (i != 0) {
                    new com.xunlei.downloadprovider.publiser.campaign.d(i, this.d.j(), new m(this)).show();
                }
                i = "download";
            }
            com.xunlei.downloadprovider.cooperation.a.a.b(this.d.j(), i, "youliao");
            return;
        }
        if (i == 2 && ApkHelper.isApkPackageInstalled(getContext(), "com.xunlei.tdlive") == 0) {
            i = getContext();
            if (i != 0) {
                new com.xunlei.downloadprovider.publiser.campaign.a(i, this.d.j(), new n(this)).show();
            }
        }
    }

    public ViewGroup getContainerLayout() {
        return this.b.i;
    }

    protected final void a(int i, int i2) {
        int i3;
        if (i != 0) {
            if (i2 != 0) {
                if (i > i2) {
                    i3 = this.a;
                    i2 = (i2 * this.a) / i;
                } else {
                    i3 = (i * this.g) / i2;
                    i2 = this.g;
                }
                i = this.b.h.getLayoutParams();
                i.width = i3;
                i.height = i2;
                this.b.h.setLayoutParams(i);
                i = new StringBuilder("adjustScreen--width=");
                i.append(i3);
                i.append("|height=");
                i.append(i2);
            }
        }
        i3 = this.a;
        i2 = this.g;
        i = this.b.h.getLayoutParams();
        i.width = i3;
        i.height = i2;
        this.b.h.setLayoutParams(i);
        i = new StringBuilder("adjustScreen--width=");
        i.append(i3);
        i.append("|height=");
        i.append(i2);
    }

    private void a(BaseVideoInfo baseVideoInfo) {
        if (e() && baseVideoInfo != null) {
            try {
                if (!TextUtils.isEmpty(baseVideoInfo.getVideoId()) && com.xunlei.downloadprovider.homepage.follow.b.a().b(baseVideoInfo.getPublisherId()) == null) {
                    baseVideoInfo = this.b;
                    if (baseVideoInfo.C == null) {
                        baseVideoInfo.C = ((ViewStub) findViewById(R.id.choiceness_popwindow)).inflate();
                    }
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) baseVideoInfo.C.getLayoutParams();
                    layoutParams.topMargin = this.b.B.getBottom();
                    this.b.C.setVisibility(layoutParams.topMargin > null ? null : 8);
                    this.j.removeCallbacks(this.n);
                    this.j.postDelayed(this.n, 3000);
                }
            } catch (BaseVideoInfo baseVideoInfo2) {
                baseVideoInfo2.getMessage();
            }
        }
    }

    private static void b(a aVar, BaseVideoInfo baseVideoInfo) {
        aVar.p.a(baseVideoInfo.hasLike(), baseVideoInfo.getLikeCount());
    }

    private static void c(a aVar, BaseVideoInfo baseVideoInfo) {
        if (baseVideoInfo.getShareCount() <= 0) {
            aVar.s.setText("分享");
        } else {
            aVar.s.setText(ConvertUtil.decimal2String((long) baseVideoInfo.getShareCount(), 10000, 10000, "万"));
        }
    }

    protected final void a(int i, int i2, long j) {
        Animation alphaAnimation = new AlphaAnimation((float) i, (float) i2);
        this.b.t.setAnimation(alphaAnimation);
        alphaAnimation.setDuration(j);
        alphaAnimation.start();
    }

    public final void q() {
        if (this.c.getCommentCount() <= 0) {
            this.b.q.setText("评论");
        } else {
            this.b.q.setText(ConvertUtil.decimal2String((long) this.c.getCommentCount(), 10000, 10000, "万"));
        }
    }

    public void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType == ShareOperationType.REPORT) {
            ReportActivity.a(getContext(), 1, this.c.getVideoId(), this.c.getGcid(), this.d.k());
        }
        this.d.a(shareOperationType, this.c.getVideoId(), shareOperationType.getReportShareTo());
    }

    public void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        if (i == 0) {
            com.xunlei.downloadprovider.homepage.redpacket.j.a().a(getContext(), fVar);
            com.xunlei.downloadprovider.homepage.recommend.a.a.a().a(this.c.getVideoId(), 1, this.c.getGcid(), "share_success");
            if (this.c != null) {
                this.c.setShareCount(this.c.getShareCount() + 1);
                c(this.b, this.c);
            }
        }
        a(this.c);
        this.d.a(i, shareOperationType, this.e);
    }

    public String getPlayerPage() {
        return this.d.g();
    }

    public PlayerTag getPlayerTag() {
        return this.d.h();
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            com.xunlei.downloadprovider.e.a.f.a().a(1, this.m);
            return;
        }
        if (this.b.E.getVisibility() == 0) {
            this.b.E.c();
            this.b.E.setVisibility(8);
            this.b.F.setVisibility(0);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.xunlei.downloadprovider.e.a.f.a().b(1, this.m);
    }

    public int getListPosition() {
        return this.b.e;
    }

    protected final void c(ThunderXmpPlayer thunderXmpPlayer) {
        super.c(thunderXmpPlayer);
        thunderXmpPlayer.c(new g(this, thunderXmpPlayer));
    }

    public void a(ThunderXmpPlayer thunderXmpPlayer, int i) {
        if (this.h != null) {
            if (!this.h.isFollowed()) {
                com.xunlei.downloadprovider.player.xmp.e eVar = thunderXmpPlayer.i;
                if (eVar != null) {
                    thunderXmpPlayer = com.xunlei.downloadprovider.player.xmp.a.a.a(eVar, i, thunderXmpPlayer.f.c());
                    if (thunderXmpPlayer != null) {
                        eVar.a();
                        StringBuilder stringBuilder = new StringBuilder("onPlayPositionChange--position=");
                        stringBuilder.append(i);
                        stringBuilder.append("|canShowFollowAnimation=");
                        stringBuilder.append(thunderXmpPlayer);
                        thunderXmpPlayer = this.b.B;
                        if (thunderXmpPlayer.getVisibility() == 0) {
                            thunderXmpPlayer.a();
                        } else {
                            LocalBroadcastManager.getInstance(thunderXmpPlayer.getContext()).sendBroadcast(new Intent("action_start_follow_guide_animation"));
                        }
                    }
                }
            }
        }
    }

    public void a(ThunderXmpPlayer thunderXmpPlayer, String str) {
        ThunderXmpPlayer thunderXmpPlayer2 = thunderXmpPlayer;
        int i = 1;
        if (this.c.getStatus() == 1 && d.a().b.n()) {
            if (!r0.c.hasLike()) {
                com.xunlei.downloadprovider.player.xmp.ui.widget.PlayCompleteLikeGuideView.a hVar = new h(r0, thunderXmpPlayer2);
                if (thunderXmpPlayer.s()) {
                    int i2;
                    thunderXmpPlayer2.x = hVar;
                    if (thunderXmpPlayer2.w != null) {
                        ViewUtil.removeViewFromParent(thunderXmpPlayer2.w);
                    }
                    thunderXmpPlayer2.w = new PlayCompleteLikeGuideView(thunderXmpPlayer2.e);
                    thunderXmpPlayer2.g.addView(thunderXmpPlayer2.w);
                    PlayCompleteLikeGuideView playCompleteLikeGuideView = thunderXmpPlayer2.w;
                    playCompleteLikeGuideView.c = new v(thunderXmpPlayer2);
                    AnimationDrawable animationDrawable = playCompleteLikeGuideView.getAnimationDrawable();
                    if (animationDrawable != null) {
                        int i3 = 0;
                        i2 = i3;
                        while (i3 < animationDrawable.getNumberOfFrames()) {
                            i2 += animationDrawable.getDuration(i3);
                            i3++;
                        }
                    } else {
                        i2 = 0;
                    }
                    Object obj = playCompleteLikeGuideView.a;
                    List arrayList = new ArrayList();
                    AnimatorSet animatorSet = new AnimatorSet();
                    arrayList.add(ObjectAnimator.ofFloat(obj, View.TRANSLATION_Y, new float[]{(float) DipPixelUtil.dip2px(7.0f)}).setDuration(300));
                    Property property = View.TRANSLATION_Y;
                    float[] fArr = new float[1];
                    float f = 0.0f;
                    fArr[0] = 0.0f;
                    arrayList.add(ObjectAnimator.ofFloat(obj, property, fArr).setDuration(200));
                    int i4 = playCompleteLikeGuideView.b;
                    while (i4 > 0) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        Property property2 = View.ROTATION;
                        float[] fArr2 = new float[i];
                        fArr2[0] = 30.0f;
                        ObjectAnimator duration = ObjectAnimator.ofFloat(obj, property2, fArr2).setDuration(250);
                        Property property3 = View.ROTATION;
                        fArr2 = new float[i];
                        fArr2[0] = -30.0f;
                        ObjectAnimator duration2 = ObjectAnimator.ofFloat(obj, property3, fArr2).setDuration(150);
                        Property property4 = View.ROTATION;
                        float[] fArr3 = new float[i];
                        fArr3[0] = f;
                        Object obj2 = obj;
                        ObjectAnimator duration3 = ObjectAnimator.ofFloat(obj, property4, fArr3).setDuration(250);
                        ValueAnimator duration4 = ValueAnimator.ofInt(new int[]{0, 0}).setDuration(250);
                        animatorSet2.playSequentially(new Animator[]{duration, duration2, duration3, duration4});
                        animatorSet2.addListener(new com.xunlei.downloadprovider.player.xmp.ui.widget.e(playCompleteLikeGuideView));
                        arrayList.add(animatorSet2);
                        i4--;
                        i = 1;
                        obj = obj2;
                        f = 0.0f;
                    }
                    animatorSet.playSequentially(arrayList);
                    animatorSet.setStartDelay((long) i2);
                    playCompleteLikeGuideView.getAnimationDrawable().start();
                    animatorSet.start();
                    playCompleteLikeGuideView.a(i2);
                    String str2 = thunderXmpPlayer2.o;
                    StatEvent build = HubbleEventBuilder.build("android_play_shortvideo", "zan_video_end_guide");
                    build.add("tabid", str2);
                    ThunderReport.reportEvent(build);
                }
                return;
            }
        }
        thunderXmpPlayer.f();
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        if (this.b != null) {
            if (this.b.k.getVisibility() == null) {
                postDelayed(this.l, 2000);
            }
            this.b.l.setVisibility(8);
            this.b.m.setVisibility(8);
            this.b.o.setVisibility(8);
            this.b.j.setVisibility(4);
            this.b.n.setVisibility(8);
            this.b.f.setVisibility(8);
            this.b.g.setVisibility(8);
        }
        if (this.i != null) {
            this.i.a((b) this);
        }
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
        super.b(thunderXmpPlayer);
        if (this.b != null) {
            thunderXmpPlayer = getHandler();
            if (thunderXmpPlayer != null) {
                thunderXmpPlayer.removeCallbacks(this.l);
            }
            if (this.c.getPlayCount() > null) {
                this.b.o.setVisibility(0);
            }
            this.b.j.setVisibility(0);
            this.b.n.setVisibility(0);
            this.b.f.setVisibility(0);
            this.b.g.setVisibility(0);
            a(this.c, this.h, this.b);
        }
        if (this.i != null) {
            this.i.a(null);
        }
    }

    public View getPlayerContainerView() {
        return this.b.i;
    }

    public final boolean b() {
        a(this.c, this.h, true);
        return true;
    }

    public final boolean c() {
        ThunderXmpPlayer player = getPlayer();
        if (player != null) {
            player.r();
        }
        return true;
    }

    public int getPosition() {
        return this.b.e;
    }

    public VideoViewType getVideoViewType() {
        return VideoViewType.FILL_PARENT;
    }

    public BaseVideoInfo getShortVideo() {
        return this.c;
    }

    public VideoUserInfo getUserInfo() {
        return this.h;
    }

    private boolean s() {
        if (this.c.getStatus() == -1) {
            XLToast.showToast(getContext(), "内容审核中，请稍后再试");
            return false;
        } else if (this.c.getStatus() != 0) {
            return true;
        } else {
            XLToast.showToast(getContext(), "内容未通过审核");
            return false;
        }
    }

    protected final void k() {
        if (this.k != null) {
            this.k.onLongClick(null);
        }
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        super.setOnLongClickListener(onLongClickListener);
        this.k = onLongClickListener;
    }

    public final boolean p() {
        if (this.c.hasLike()) {
            return false;
        }
        BaseVideoInfo baseVideoInfo = this.c;
        this.b.p.a();
        com.xunlei.downloadprovider.e.a.f.a().a(getContext(), new com.xunlei.downloadprovider.e.a.d(baseVideoInfo.getVideoId(), baseVideoInfo.getGcid(), baseVideoInfo.getLikeCount()), null);
        long publisherId = baseVideoInfo.getPublisherId();
        com.xunlei.downloadprovider.homepage.follow.b.a().e(publisherId);
        if (com.xunlei.downloadprovider.homepage.follow.b.a().d(publisherId)) {
            a(baseVideoInfo);
        }
        return true;
    }
}
