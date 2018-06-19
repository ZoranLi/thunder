package com.xunlei.downloadprovider.ad.feedvideo;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.ad.d.i;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.homepage.recommend.feed.y;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.a.b;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;
import com.xunlei.downloadprovider.player.xmp.ui.af;
import com.xunlei.downloadprovider.player.xmp.ui.item.BasePlayerView;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.xllib.b.j;
import java.util.concurrent.TimeUnit;

/* compiled from: FeedVideoADItemView */
public final class h extends BasePlayerView implements b {
    protected FrameLayout a;
    protected ImageView b;
    protected TextView c;
    protected ImageView d;
    protected TextView e;
    protected int f;
    private boolean g = null;
    private FrameLayout h;
    private FeedVideoItemADBottomView i;
    private ImageView j;
    private FrameLayout k;
    private y l;
    private l m;
    private boolean n;
    private a o;
    private boolean p;
    private i q;
    private LayoutParams r;

    public final boolean c() {
        return false;
    }

    protected final String getFormatType() {
        return "video";
    }

    public final View getPlayerContainerView() {
        return this;
    }

    public final String getPlayerPage() {
        return "feedflow";
    }

    public h(Context context, a aVar) {
        super(context);
        this.o = aVar;
        context = getContext();
        aVar = LayoutInflater.from(context).inflate(R.layout.short_video_ad_item, this);
        int dimension = (int) context.getResources().getDimension(R.dimen.feed_video_view_height_top);
        context = (int) context.getResources().getDimension(R.dimen.feed_video_view_item_spacing);
        this.h = (FrameLayout) aVar.findViewById(R.id.layout_top);
        this.r = new LayoutParams(-1, dimension);
        this.r.topMargin = context;
        this.h.setLayoutParams(this.r);
        this.a = (FrameLayout) this.h.findViewById(R.id.layout_video_container);
        this.b = (ImageView) this.h.findViewById(R.id.iv_video_preview);
        this.c = (TextView) this.h.findViewById(R.id.tv_video_title);
        this.d = (ImageView) this.h.findViewById(R.id.play_icon);
        this.k = (FrameLayout) this.h.findViewById(R.id.layout_video_play_count_and_duration);
        this.e = (TextView) this.k.findViewById(R.id.tv_duration);
        this.i = (FeedVideoItemADBottomView) aVar.findViewById(R.id.layout_bottom_bar);
        this.j = this.i.getSubjectIconImageView();
        context = getContext();
        e();
        this.c.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        this.c.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_gradient_top_bottom));
        this.e.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        this.b.setOnClickListener(new i(this));
        this.i.setOnClickListener(new j(this));
    }

    public final void a(int i, l lVar, y yVar) {
        e();
        this.f = i;
        this.l = yVar;
        if (this.m != lVar) {
            this.m = lVar;
            if (this.m.b() == 0 || this.m.b().equals("") != 0) {
                this.n = false;
            } else {
                this.n = true;
            }
            this.m.v = STYLES_INFO.FEED_IMG;
            if (a.b().a(this.m, getMovieId(), this) != 0) {
                a.b();
                if (a.c(getMovieId()) == 0) {
                    this.m.a(this);
                    a.b().a(getMovieId());
                }
            }
            if (getPlayer() != 0) {
                getPlayer().r();
            }
        }
        if (this.m != 0) {
            this.i.getSubjectNameTextView().setText(this.m.j());
            this.c.setText(this.m.m());
            i = this.i.getTvTag();
            if (i != 0) {
                i.setText(f.a(this.m, R.string.choiceness_ad_source_guanggao));
            }
            i = this.i.getTvOpen();
            if (i != 0) {
                i.setText(o.a(this.m));
            }
            h();
            a();
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void a() {
        if (this.m == null) {
            e();
            return;
        }
        String k = this.m.k();
        if (k == null) {
            this.i.getSubjectIconImageView().setImageDrawable(getResources().getDrawable(R.drawable.feed_subject_icon_default));
        } else {
            com.xunlei.downloadprovider.homepage.choiceness.b.a();
            com.xunlei.downloadprovider.homepage.choiceness.b.a(k, this.i.getSubjectIconImageView());
        }
        com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.m.l(), this.b, null);
    }

    protected final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public final void setIsFirstElement(boolean z) {
        if (this.g != z) {
            this.g = z;
            if (z) {
                this.r.topMargin = 0;
                this.h.setLayoutParams(this.r);
                return;
            }
            this.r.topMargin = (int) getContext().getResources().getDimension(R.dimen.feed_video_view_item_spacing);
            this.h.setLayoutParams(this.r);
        }
    }

    public final PlayerTag getPlayerTag() {
        return PlayerTag.FEED;
    }

    protected final void a(boolean z) {
        if (com.xunlei.xllib.android.b.a(getContext())) {
            boolean z2 = true;
            if (com.xunlei.xllib.android.b.d(getContext())) {
                z2 = ak.a().a(this.l.a.getVideoId(), getContext(), new k(this, z));
            }
            if (z2) {
                b(z);
            }
            return;
        }
        XLToast.showNoNetworkToast(getContext());
    }

    protected final void b(boolean z) {
        this.p = z;
        ak a = ak.a();
        ThunderXmpPlayer a2 = a.a(PlayerTag.FEED, this.m.b());
        if (a2 == null) {
            a2 = a.a(PlayerTag.FEED);
        }
        a2.o = "feedflow";
        a2.a(PlayerTag.FEED);
        a2.c(new l(this, a2));
        a2.s = new m(this, a2);
        a2.n = this.f;
        a2.a(true);
        a2.a(new af((Activity) getContext()));
        a2.t = new n(this);
        a2.a((BaseActivity) getContext(), (PlayerContainer) this);
        com.xunlei.downloadprovider.player.xmp.y yVar = new com.xunlei.downloadprovider.player.xmp.y(this.l.a.getVideoId(), this.m.b(), this.m.m());
        yVar.o = this.l.a.getCoverUrl();
        yVar.k = "feed_ad";
        yVar.f = this.l.a.getVideoId();
        yVar.p = this.b.getScaleType();
        yVar.a(this.b.getDrawable());
        yVar.g = z;
        yVar.h = false;
        a2.a(yVar);
    }

    protected final From getVideoDetailFrom() {
        return From.FEED_FLOW;
    }

    public final String getMovieId() {
        return this.l != null ? this.l.a.getVideoId() : "";
    }

    public final l getBaseAdapterModel() {
        return this.m;
    }

    private void e() {
        this.b.setImageDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.feed_video_item_view_default_preview_color)));
        this.b.setTag(this.b.getId(), null);
        this.j.setImageDrawable(getResources().getDrawable(R.drawable.feedflow_icon_default));
        this.j.setTag(this.j.getId(), null);
    }

    public final ViewGroup getContainerLayout() {
        return this.a;
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        new StringBuilder("onPlayerAttach--player=").append(thunderXmpPlayer);
        if (!(this.o == null || this.n == null)) {
            this.o.a((b) this);
        }
        h();
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
        super.b(thunderXmpPlayer);
        new StringBuilder("onPlayerDetach--player=").append(thunderXmpPlayer);
        if (!(this.o == null || this.n == null)) {
            this.o.a(null);
        }
        h();
    }

    public final VideoViewType getVideoViewType() {
        return VideoViewType.ADAPTIVE_VIEW_TYPE;
    }

    private void h() {
        int i;
        int i2;
        int i3;
        ImageView imageView;
        boolean booleanValue = a.b().b.get(getMovieId()) == null ? false : ((Boolean) a.b().b.get(getMovieId())).booleanValue();
        int i4 = 1;
        if ((getPlayer() != null ? 1 : 0) != 0) {
            i = 8;
        } else if (booleanValue) {
            if (this.q == null) {
                this.q = new i(this.m, getContext());
            }
            this.q.c = 1;
            i iVar = this.q;
            iVar.a = this.m;
            if (iVar.b != null) {
                iVar.a(iVar.b);
            }
            iVar = this.q;
            if (iVar.b != null) {
                View findViewById = iVar.b.findViewById(R.id.float_container);
                if (findViewById != null && findViewById.getVisibility() == 8) {
                    if (i4 == 0) {
                        this.q.b();
                    } else {
                        this.q.a(this.h);
                    }
                    this.q.d = new o(this);
                    i2 = 0;
                    i = 8;
                    i3 = i;
                    i4 = i3;
                    if (!this.n) {
                        i = 8;
                    }
                    if (i == 8) {
                        this.k.setVisibility(8);
                    } else {
                        this.k.setVisibility(0);
                    }
                    this.e.setVisibility(i);
                    this.c.setVisibility(i3);
                    imageView = this.d;
                    if (this.n) {
                        i4 = 8;
                    }
                    imageView.setVisibility(i4);
                    this.b.setVisibility(i2);
                }
            }
            i4 = 0;
            if (i4 == 0) {
                this.q.a(this.h);
            } else {
                this.q.b();
            }
            this.q.d = new o(this);
            i2 = 0;
            i = 8;
            i3 = i;
            i4 = i3;
            if (this.n) {
                i = 8;
            }
            if (i == 8) {
                this.k.setVisibility(0);
            } else {
                this.k.setVisibility(8);
            }
            this.e.setVisibility(i);
            this.c.setVisibility(i3);
            imageView = this.d;
            if (this.n) {
                i4 = 8;
            }
            imageView.setVisibility(i4);
            this.b.setVisibility(i2);
        } else {
            this.e.setText(j.a(TimeUnit.SECONDS.toMillis((long) this.m.v())));
            if (this.q != null) {
                this.q.a();
            }
            i = 0;
        }
        i3 = i;
        i4 = i3;
        i2 = i4;
        if (this.n) {
            i = 8;
        }
        if (i == 8) {
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
        }
        this.e.setVisibility(i);
        this.c.setVisibility(i3);
        imageView = this.d;
        if (this.n) {
            i4 = 8;
        }
        imageView.setVisibility(i4);
        this.b.setVisibility(i2);
    }

    public final boolean b() {
        if (!(a.b().b.get(getMovieId()) == null ? false : ((Boolean) a.b().b.get(getMovieId())).booleanValue())) {
            a(true);
        }
        return true;
    }

    public final boolean d() {
        return this.n;
    }

    public final int getPosition() {
        return this.f;
    }

    static /* synthetic */ void a(h hVar, View view) {
        if (hVar.m.w()) {
            String s = hVar.m.s();
            if (!TextUtils.isEmpty(s)) {
                TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(hVar.m), s, null);
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                downloadAdditionInfo.b = hVar.m.p();
                downloadAdditionInfo.a = hVar.m.o();
                downloadAdditionInfo.f = true;
                g.a();
                g.a(s, hVar.m.o(), taskStatInfo, downloadAdditionInfo);
            }
        }
        hVar.m.onClick(view);
    }
}
