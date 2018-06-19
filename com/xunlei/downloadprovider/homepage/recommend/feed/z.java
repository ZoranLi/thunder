package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.choiceness.d;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.af;
import com.xunlei.downloadprovider.player.xmp.ui.item.BasePlayerView;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovidershare.k;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FeedVideoItemView */
public class z extends BasePlayerView {
    private ThunderXmpPlayer A;
    private int B;
    private boolean C;
    private LayoutParams D;
    private k E = new ah(this);
    protected y a;
    protected FrameLayout b;
    protected ImageView c;
    protected TextView d;
    protected ImageView e;
    protected TextView f;
    protected TextView g;
    protected FeedItemShareLayout h;
    List<String> i = new ArrayList();
    protected q j;
    protected int k;
    private boolean l = false;
    private FrameLayout m;
    private FeedVideoItemBottomView n;
    private ImageView o;
    private TextView p;
    private PopupWindow q;
    private AlphaAnimation r;
    private int s;
    private int t;
    private a u;
    private FrameLayout v;
    private e w;
    private com.xunlei.downloadprovider.e.b.a x;
    private aa y;
    private LoginHelper z = LoginHelper.a();

    protected String getFormatType() {
        return "video";
    }

    public String getPlayerPage() {
        return "feedflow";
    }

    public z(Context context, a aVar) {
        super(context);
        this.u = aVar;
        this.p = new TextView(getContext());
        this.p.setText("+1");
        this.p.setTextSize(2, 12.0f);
        this.p.setTextColor(-15559434);
        this.q = new PopupWindow(this.p, -2, -2);
        this.q.setFocusable(false);
        this.q.setOutsideTouchable(true);
        this.q.setBackgroundDrawable(new ColorDrawable(0));
        this.r = new AlphaAnimation(1.0f, 0.0f);
        this.r.setDuration(1300);
        context = getContext();
        aVar = LayoutInflater.from(context).inflate(R.layout.short_video_item, this);
        int dimension = (int) context.getResources().getDimension(R.dimen.feed_video_view_height_top);
        this.B = dimension;
        context = (int) context.getResources().getDimension(R.dimen.feed_video_view_item_spacing);
        this.m = (FrameLayout) aVar.findViewById(R.id.layout_top);
        this.D = new LayoutParams(-1, dimension);
        this.D.topMargin = context;
        this.m.setLayoutParams(this.D);
        this.b = (FrameLayout) this.m.findViewById(R.id.layout_video_container);
        this.c = (ImageView) this.m.findViewById(R.id.iv_video_preview);
        this.d = (TextView) this.m.findViewById(R.id.tv_video_title);
        this.e = (ImageView) this.m.findViewById(R.id.play_icon);
        this.v = (FrameLayout) this.m.findViewById(R.id.layout_video_play_count_and_duration);
        this.g = (TextView) this.v.findViewById(R.id.tv_play_count);
        this.f = (TextView) this.v.findViewById(R.id.tv_duration);
        this.h = (FeedItemShareLayout) this.m.findViewById(R.id.layout_share);
        this.n = (FeedVideoItemBottomView) aVar.findViewById(R.id.layout_bottom_bar);
        this.o = this.n.getSubjectIconImageView();
        context = getContext();
        d();
        this.d.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        this.d.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_gradient_top_bottom));
        this.f.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        this.g.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        context = getContext();
        this.c.setOnClickListener(new al(this));
        this.n.setOnBottomActionBarClickListener(new am(this, context));
        a.a().c = new ao(this);
        this.r.setAnimationListener(new ap(this));
        this.h.setClickReplayListener(new aq(this));
        this.h.setClickFollowListener(new ar(this));
    }

    public final void a(int i, y yVar) {
        this.k = i;
        this.h.setFeedVideoItemModel(yVar);
        i = new StringBuilder("setFeedVideoModel--model=");
        i.append(yVar);
        i.append("|player=");
        i.append(getPlayer());
        i.append("|this=");
        i.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.a != yVar) {
            this.a = yVar;
            if (getPlayer() != 0) {
                getPlayer().r();
            }
        }
        k.a();
        if (k.c(1, String.valueOf(this.a.a.getVideoId())) != 0) {
            this.a.a();
            i = this.a;
            int likeCount = this.a.a.getLikeCount();
            k.a();
            i.a(Math.max(likeCount, k.d(1, String.valueOf(this.a.a.getVideoId()))));
        }
        if (this.a != 0) {
            this.n.getCommentNumTextView().setText("");
            this.n.getSubjectNameTextView().setText(this.a.b.getNickname());
            this.d.setText(this.a.a.getTitle());
            i = new StringBuilder("model=");
            i.append(this.a.a.getTitle());
            i.append("|player=");
            i.append(getPlayer());
            i = this.a.a.getCommentCount();
            if (i == 0) {
                this.n.getCommentNumTextView().setText("");
            } else {
                this.n.getCommentNumTextView().setText(j.a((long) i));
            }
            this.s = this.a.a.getShareCount();
            if (this.s == 0) {
                this.n.getShareCountTextView().setText("");
            } else {
                this.n.getShareCountTextView().setText(j.a((long) this.s));
            }
            this.t = this.a.a.getLikeCount();
            if (this.a.a.hasLike() == 0) {
                if (this.i.contains(this.a.a.getVideoId()) == 0) {
                    if (this.t == 0) {
                        this.n.getLikeTextView().setText("");
                        this.n.getLikeImageView().setEnabled(true);
                    } else {
                        this.n.getLikeTextView().setText(j.a((long) this.t));
                        this.n.getLikeTextView().setSelected(false);
                        this.n.getLikeImageView().setEnabled(true);
                    }
                    e();
                }
            }
            this.n.getLikeTextView().setSelected(true);
            this.n.getLikeImageView().setEnabled(false);
            k.a();
            i = k.d(1, String.valueOf(this.a.a.getVideoId()));
            k.a();
            if (k.c(1, String.valueOf(this.a.a.getVideoId())) == null || this.i.contains(this.a.a.getVideoId()) != null) {
                this.n.getLikeTextView().setText(j.a((long) this.t));
            } else {
                this.n.getLikeTextView().setText(j.a((long) i));
            }
            e();
        }
        b();
    }

    private void b() {
        if (TextUtils.isEmpty(String.valueOf(this.a.a.getPublisherId())) || !b.a().b(this.a.a.getPublisherId())) {
            this.a.a(false);
            this.h.a(false);
            this.h.setFeedFollowTitleText(this.a.b.getNickname());
        } else {
            this.a.a(true);
            this.h.a(true);
        }
        if (this.a.c.a && l.c()) {
            this.h.a(true);
            return;
        }
        this.h.a(false);
        this.h.setFeedFollowTitleText(this.a.b.getNickname());
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.w != null) {
            f.a().b(1, this.w);
        }
        if (this.x != null) {
            com.xunlei.downloadprovider.e.b.b.a();
            com.xunlei.downloadprovider.e.b.b.b(this.x);
        }
    }

    public final void a() {
        if (this.c.getHeight() != 0 && ((double) (((float) this.c.getWidth()) / ((float) this.c.getHeight()))) > 2.5d) {
            return;
        }
        if (this.a == null) {
            d();
            return;
        }
        ImageView imgVthumb;
        boolean z;
        String portraitUrl = this.a.b.getPortraitUrl();
        if (portraitUrl == null) {
            this.n.getSubjectIconImageView().setImageDrawable(getResources().getDrawable(R.drawable.feed_subject_icon_default));
        } else {
            com.xunlei.downloadprovider.homepage.choiceness.b.a();
            com.xunlei.downloadprovider.homepage.choiceness.b.a(portraitUrl, this.n.getSubjectIconImageView());
        }
        String coverUrl = this.a.a.getCoverUrl();
        this.c.setScaleType(ScaleType.FIT_CENTER);
        com.xunlei.downloadprovider.homepage.choiceness.b a = com.xunlei.downloadprovider.homepage.choiceness.b.a();
        View view = this.c;
        int posterWidth = this.a.a.getPosterWidth();
        int posterHeight = this.a.a.getPosterHeight();
        Context context = view.getContext();
        if (view.getWidth() != 0) {
            if (view.getHeight() != 0) {
                StringBuilder stringBuilder = new StringBuilder("displayGaussBlurPosterImage--startLoading--view=");
                stringBuilder.append(ViewUtil.getViewAddress(view));
                stringBuilder.append("|posterWidth=");
                stringBuilder.append(posterWidth);
                stringBuilder.append("|posterHeight=");
                stringBuilder.append(posterHeight);
                stringBuilder.append("|url=");
                stringBuilder.append(coverUrl);
                String a2 = (posterWidth <= 0 || posterHeight <= 0) ? coverUrl : com.xunlei.downloadprovider.homepage.choiceness.a.a(coverUrl, posterWidth, posterHeight, view);
                com.xunlei.downloadprovider.homepage.choiceness.b.a(context, a2).into(new d(a, view, view, posterWidth, posterHeight, coverUrl));
                imgVthumb = this.n.getImgVthumb();
                z = true;
                if (this.a.b() == 1) {
                    z = false;
                }
                m.a(imgVthumb, z, this.a.b.getKind());
            }
        }
        a.a(coverUrl, view, null);
        imgVthumb = this.n.getImgVthumb();
        z = true;
        if (this.a.b() == 1) {
            z = false;
        }
        m.a(imgVthumb, z, this.a.b.getKind());
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.w == 0) {
            this.w = new aa(this);
            f.a().a(1, this.w);
        } else {
            f.a().a(this.w);
            f.a().a(1, this.w);
        }
        if (this.x == 0) {
            this.x = new aj(this);
        }
        com.xunlei.downloadprovider.e.b.b.a();
        com.xunlei.downloadprovider.e.b.b.a(this.x);
        if (this.y == 0) {
            this.y = new ak(this);
        }
        ab.a().a(this.y);
    }

    public void setIsFirstElement(boolean z) {
        if (this.l != z) {
            this.l = z;
            if (z) {
                this.D.topMargin = 0;
                this.m.setLayoutParams(this.D);
                return;
            }
            this.D.topMargin = (int) getContext().getResources().getDimension(R.dimen.feed_video_view_item_spacing);
            this.m.setLayoutParams(this.D);
        }
    }

    protected final void a(From from) {
        y yVar = this.a;
        if (yVar != null) {
            this.u.b = false;
            if (this.j != null) {
                this.j.c = true;
            }
            ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
            aVar.u = from;
            aVar.s = true;
            aVar.t = true;
            aVar.r = false;
            aVar.q = yVar.d;
            aVar.a = yVar.a.getVideoId();
            aVar.b = yVar.a.getGcid();
            aVar.c = yVar.a.getTitle();
            aVar.d = yVar.a.getPlayUrl();
            aVar.e = yVar.a.getCoverUrl();
            aVar.f = yVar.a.getLikeCount();
            aVar.g = yVar.a.hasLike();
            aVar.l = yVar.b.getNickname();
            aVar.n = yVar.b();
            aVar.v = yVar.a;
            aVar.w = yVar.b;
            a(aVar);
        }
    }

    public PlayerTag getPlayerTag() {
        return PlayerTag.FEED;
    }

    protected final void a(boolean z) {
        if (com.xunlei.xllib.android.b.a(getContext())) {
            boolean z2 = true;
            if (com.xunlei.xllib.android.b.d(getContext())) {
                String str;
                if (this.a == null) {
                    str = "";
                } else {
                    str = String.valueOf(this.a.a.getVideoId());
                }
                z2 = ak.a().a(str, getContext(), new ad(this, z));
            }
            if (z2) {
                b(z);
            }
            return;
        }
        XLToast.showNoNetworkToast(getContext());
    }

    protected void b(boolean z) {
        this.C = z;
        ak a = ak.a();
        ThunderXmpPlayer a2 = a.a(PlayerTag.FEED, this.a.a.getPlayUrl());
        if (a2 == null) {
            a2 = a.a(PlayerTag.FEED);
        }
        d(a2);
        a2.a((BaseActivity) getContext(), (PlayerContainer) this);
        y yVar = new y(String.valueOf(this.a.a.getVideoId()), this.a.a.getPlayUrl(), this.a.a.getTitle());
        yVar.o = this.a.a.getCoverUrl();
        yVar.k = "feedflow";
        yVar.f = this.a.a.getGcid();
        yVar.r = this.a.a.getPublisherId();
        yVar.n = this.a.d;
        yVar.p = this.c.getScaleType();
        yVar.a(this.c.getDrawable());
        yVar.g = z;
        a2.a(yVar);
        this.a.f = false;
    }

    protected From getVideoDetailFrom() {
        return From.FEED_FLOW;
    }

    protected final boolean g() {
        if (!c()) {
            return false;
        }
        VideoFeedReporter.a(this.a.a.getVideoId(), "doubleclick");
        return true;
    }

    private boolean c() {
        if (!this.i.contains(this.a.a.getVideoId())) {
            if (!this.a.a.hasLike()) {
                this.q.showAsDropDown(this.n.getClickLinearLayout(), DipPixelUtil.dip2px(37.0f), -DipPixelUtil.dip2px(46.0f));
                this.p.startAnimation(this.r);
                this.n.getLikeTextView().setSelected(true);
                this.n.getLikeImageView().setEnabled(false);
                setLikeBtnAnimation(getContext());
                f.a().a(getContext(), new com.xunlei.downloadprovider.e.a.d(this.a.a.getVideoId(), this.a.a.getGcid(), this.a.a.getLikeCount()), null);
                return true;
            }
        }
        return false;
    }

    private void setLikeBtnAnimation(Context context) {
        Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.scale_in);
        loadAnimation.setAnimationListener(new ai(this, AnimationUtils.loadAnimation(context, R.anim.scale_out)));
        this.n.getLikeImageView().startAnimation(loadAnimation);
    }

    private void d() {
        this.c.setImageDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.feed_video_item_view_default_preview_color)));
        this.o.setImageDrawable(getResources().getDrawable(R.drawable.feedflow_icon_default));
    }

    public void setFeedVideoAdapter(q qVar) {
        this.j = qVar;
    }

    public ViewGroup getContainerLayout() {
        return this.b;
    }

    public void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        new StringBuilder("onPlayerAttach--player=").append(thunderXmpPlayer);
        this.A = thunderXmpPlayer;
        e();
    }

    public void b(ThunderXmpPlayer thunderXmpPlayer) {
        super.b(thunderXmpPlayer);
        new StringBuilder("onPlayerDetach--player=").append(thunderXmpPlayer);
        e();
        this.A = null;
    }

    public VideoViewType getVideoViewType() {
        return VideoViewType.ADAPTIVE_VIEW_TYPE;
    }

    private void e() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z = this.a.f;
        if ((getPlayer() != null ? 1 : 0) != 0) {
            i = 8;
            i2 = i;
            i3 = i2;
            i4 = i3;
            i5 = i4;
            i6 = i5;
        } else if (z) {
            b();
            FeedItemShareLayout feedItemShareLayout = this.h;
            if (feedItemShareLayout.b == null) {
                feedItemShareLayout.b = AnimationUtils.loadAnimation(feedItemShareLayout.getActivity(), R.anim.anim_feed_btn_show);
                feedItemShareLayout.a.startAnimation(feedItemShareLayout.b);
                feedItemShareLayout.b.setAnimationListener(new l(feedItemShareLayout));
            }
            i4 = 0;
            i6 = i4;
            i = 8;
            i2 = i;
            i3 = i2;
            i5 = i3;
        } else {
            CharSequence charSequence;
            if (this.a.a.getPlayCount() == 0) {
                this.g.setText("");
                i = 8;
            } else {
                TextView textView = this.g;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(j.a((long) this.a.a.getPlayCount()));
                stringBuilder.append("次观看");
                textView.setText(stringBuilder.toString());
                i = 0;
            }
            TextView textView2 = this.f;
            i3 = this.a.a.getDuration();
            if (i3 < 0) {
                charSequence = "00:00";
            } else if (i3 == 0) {
                charSequence = "00:00";
            } else {
                i4 = i3 / 60;
                if (i4 == 0) {
                    StringBuilder stringBuilder2 = new StringBuilder("00:");
                    stringBuilder2.append(com.xunlei.downloadprovider.player.xmp.b.a.a(i3));
                    charSequence = stringBuilder2.toString();
                } else {
                    i3 %= 60;
                    StringBuilder stringBuilder3;
                    if (i4 / 60 == 0) {
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(com.xunlei.downloadprovider.player.xmp.b.a.a(i4));
                        stringBuilder3.append(Constants.COLON_SEPARATOR);
                        stringBuilder3.append(com.xunlei.downloadprovider.player.xmp.b.a.a(i3));
                        charSequence = stringBuilder3.toString();
                    } else {
                        i4 %= 60;
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(com.xunlei.downloadprovider.player.xmp.b.a.a(i4));
                        stringBuilder3.append(Constants.COLON_SEPARATOR);
                        stringBuilder3.append(com.xunlei.downloadprovider.player.xmp.b.a.a(i3));
                        charSequence = stringBuilder3.toString();
                    }
                }
            }
            textView2.setText(charSequence);
            i2 = i;
            i = 0;
            i3 = i;
            i5 = i3;
            i6 = i5;
            i4 = 8;
        }
        if (i == 8) {
            this.v.setVisibility(8);
        } else {
            this.v.setVisibility(0);
        }
        this.f.setVisibility(i);
        this.g.setVisibility(i2);
        this.d.setVisibility(i3);
        this.h.setVisibility(i4);
        this.e.setVisibility(i5);
        this.c.setVisibility(i6);
    }

    protected void d(ThunderXmpPlayer thunderXmpPlayer) {
        thunderXmpPlayer.o = "feedflow";
        thunderXmpPlayer.a(PlayerTag.FEED);
        thunderXmpPlayer.c(new ae(this, thunderXmpPlayer));
        thunderXmpPlayer.s = new af(this, thunderXmpPlayer);
        thunderXmpPlayer.n = this.k;
        thunderXmpPlayer.a(true);
        thunderXmpPlayer.a(new af((Activity) getContext()));
        thunderXmpPlayer.t = new ag(this);
    }

    static /* synthetic */ void e(z zVar) {
        if (zVar.a != null && zVar.c()) {
            VideoFeedReporter.a(zVar.a.a.getVideoId(), "bottom");
        }
    }

    static /* synthetic */ void a(z zVar, long j) {
        if (l.c()) {
            zVar.h.setFollowBtnClickable(false);
            b.a().a(j, true, new ab(zVar));
            return;
        }
        VideoFeedReporter.a(zVar.a.a.getVideoId(), String.valueOf(zVar.a.a.getPublisherId()), zVar.a.b.getKind(), l.c(), "skip_login", "");
        zVar.h.a(false);
        zVar.z.a(zVar.getContext(), new ac(zVar), LoginFrom.FEED_FOLLOW, null);
    }

    static /* synthetic */ void k(z zVar) {
        if (zVar.a != null) {
            ReportActivity.a(zVar.getContext(), 1, zVar.a.a.getVideoId(), zVar.a.a.getGcid(), DispatchConstants.OTHER);
        }
    }
}
