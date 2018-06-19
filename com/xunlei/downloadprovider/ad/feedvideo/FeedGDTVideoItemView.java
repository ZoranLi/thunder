package com.xunlei.downloadprovider.ad.feedvideo;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.ADConst.THUNDER_AD_INFO.STYLES_INFO;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.common.f;
import com.xunlei.downloadprovider.ad.common.o;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.homepage.recommend.feed.y;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.a.b;

public final class FeedGDTVideoItemView extends FrameLayout implements b {
    protected FrameLayout a;
    protected ImageView b;
    protected TextView c;
    protected ImageView d;
    protected int e;
    private boolean f = false;
    private FrameLayout g;
    private FeedVideoItemADBottomView h;
    private ImageView i;
    private boolean j = false;
    private y k;
    private l l;
    private a m;
    private NativeMediaADData n;
    private MediaView o;
    private boolean p;
    private XLAlertDialog q = null;
    private long r;
    private PLAY_STATUS s = PLAY_STATUS.PLAY_INIT;
    private LayoutParams t;

    public final boolean d() {
        return true;
    }

    public final View getPlayerContainerView() {
        return this;
    }

    public FeedGDTVideoItemView(Context context, a aVar) {
        super(context);
        this.m = aVar;
        context = getContext();
        aVar = LayoutInflater.from(context).inflate(R.layout.short_video_gdt_ad_item, this);
        context = (int) context.getResources().getDimension(R.dimen.feed_video_view_item_spacing);
        this.g = (FrameLayout) aVar.findViewById(R.id.layout_top);
        this.t = new LayoutParams(-1, -2);
        this.t.topMargin = context;
        this.g.setLayoutParams(this.t);
        this.a = (FrameLayout) this.g.findViewById(R.id.layout_video_container);
        this.b = (ImageView) this.g.findViewById(R.id.iv_video_preview);
        this.c = (TextView) this.g.findViewById(R.id.tv_video_title);
        this.d = (ImageView) this.g.findViewById(R.id.gdt_play_icon);
        this.h = (FeedVideoItemADBottomView) aVar.findViewById(R.id.layout_bottom_bar);
        this.o = (MediaView) aVar.findViewById(R.id.media_view_gdt);
        aVar.findViewById(R.id.btn_error).setVisibility(8);
        aVar.findViewById(R.id.loading_view).setVisibility(8);
        aVar.findViewById(R.id.play_icon).setVisibility(8);
        this.i = this.h.getSubjectIconImageView();
        context = getContext();
        f();
        this.c.setTextColor(context.getResources().getColor(R.color.feed_video_title_view_text_color));
        this.c.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.bg_gradient_top_bottom));
        this.b.setOnClickListener(new c(this));
        this.h.setOnClickListener(new d(this));
    }

    public final void a(int i, l lVar, y yVar) {
        f();
        this.e = i;
        this.k = yVar;
        if (this.l != lVar) {
            this.l = lVar;
            i = this.l.G();
            if ((i instanceof NativeMediaADData) != null) {
                Object obj = (NativeMediaADData) i;
                if (this.n != obj) {
                    this.n = obj;
                    i = System.currentTimeMillis();
                    this.r = i;
                    this.n.setMediaListener(new b(this, i));
                }
            } else {
                this.n = null;
            }
            this.l.v = STYLES_INFO.FEED_IMG;
            if (a.b().a(this.l, getMovieId(), this) != 0) {
                a.b();
                if (a.c(getMovieId()) == 0) {
                    this.l.a((View) this);
                    a.b().a(getMovieId());
                }
            }
        }
        if (this.l != 0) {
            this.h.getSubjectNameTextView().setText(this.l.j());
            this.c.setText(this.l.m());
            i = this.h.getTvTag();
            if (i != 0) {
                i.setText(f.a(this.l, (int) R.string.choiceness_ad_source_guanggao));
            }
            i = this.h.getTvOpen();
            if (i != 0) {
                i.setText(o.a(this.l));
            }
            this.s = PLAY_STATUS.PLAY_INIT;
            g();
            if (this.l == 0) {
                f();
                return;
            }
            i = this.l.k();
            if (i == 0) {
                this.h.getSubjectIconImageView().setImageDrawable(getResources().getDrawable(R.drawable.feed_subject_icon_default));
            } else {
                com.xunlei.downloadprovider.homepage.choiceness.b.a();
                com.xunlei.downloadprovider.homepage.choiceness.b.a(i, this.h.getSubjectIconImageView());
            }
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.l.l(), this.b, null);
        }
    }

    public final l getBaseAdapterModel() {
        return this.l;
    }

    private boolean e() {
        return this.n != null && this.n.isVideoLoaded();
    }

    private void a(boolean z) {
        this.p = z;
        if (e() && this.n) {
            this.n.bindView(this.o, true);
            this.n.play();
            this.n.setVolumeOn(this.p);
        } else if (!e() && this.n) {
            this.n.preLoadVideo();
        }
        if (!this.j && this.m) {
            z = this.m.c;
            if (z) {
                z.c();
                this.m.a(null);
            }
        }
        if (this.m) {
            this.m.a(this);
        }
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public final void a() {
        if (e() && this.n != null) {
            this.n.stop();
        }
        if (this.m != null) {
            this.m.a(null);
        }
        this.s = PLAY_STATUS.PLAY_INIT;
        g();
    }

    public final void setIsFirstElement(boolean z) {
        if (this.f != z) {
            this.f = z;
            if (z) {
                this.t.topMargin = 0;
                this.g.setLayoutParams(this.t);
                return;
            }
            this.t.topMargin = (int) getContext().getResources().getDimension(R.dimen.feed_video_view_item_spacing);
            this.g.setLayoutParams(this.t);
        }
    }

    public final String getMovieId() {
        return this.k != null ? this.k.a.getVideoId() : "";
    }

    private void f() {
        this.b.setImageDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.feed_video_item_view_default_preview_color)));
        this.b.setTag(this.b.getId(), null);
        a();
        g();
        this.i.setImageDrawable(getResources().getDrawable(R.drawable.feedflow_icon_default));
        this.i.setTag(this.i.getId(), null);
    }

    private void g() {
        int i;
        int i2 = 8;
        switch (g.a[this.s.ordinal()]) {
            case 1:
            case 5:
                i = 0;
                i2 = i;
                break;
            case 2:
            case 3:
            case 4:
                break;
            default:
                break;
        }
        i = 8;
        this.c.setVisibility(0);
        this.d.setVisibility(i2);
        this.b.setVisibility(i);
    }

    public final boolean b() {
        this.j = true;
        a(false);
        return true;
    }

    public final boolean c() {
        a();
        return true;
    }

    public final int getPosition() {
        return this.e;
    }

    static /* synthetic */ boolean a(FeedGDTVideoItemView feedGDTVideoItemView, long j) {
        return j == feedGDTVideoItemView.r ? true : null;
    }

    static /* synthetic */ void d(FeedGDTVideoItemView feedGDTVideoItemView) {
        if (feedGDTVideoItemView.e() && feedGDTVideoItemView.n != null) {
            feedGDTVideoItemView.n.stop();
        }
    }

    static /* synthetic */ void e(FeedGDTVideoItemView feedGDTVideoItemView) {
        if (!feedGDTVideoItemView.e() || feedGDTVideoItemView.n == null) {
            feedGDTVideoItemView.a(feedGDTVideoItemView.p);
        } else {
            feedGDTVideoItemView.n.resume();
            feedGDTVideoItemView.s = PLAY_STATUS.PLAY_START;
        }
        feedGDTVideoItemView.g();
    }

    static /* synthetic */ void a(FeedGDTVideoItemView feedGDTVideoItemView, boolean z) {
        if (z) {
            z = new e(feedGDTVideoItemView);
            OnClickListener fVar = new f(feedGDTVideoItemView);
            if (feedGDTVideoItemView.q == null) {
                feedGDTVideoItemView.q = new XLAlertDialog(feedGDTVideoItemView.getContext());
                feedGDTVideoItemView.q.setTitle("温馨提示");
                feedGDTVideoItemView.q.setMessage("当前为移动网络，开始播放视频？");
                feedGDTVideoItemView.q.setConfirmButtonText("确认");
                feedGDTVideoItemView.q.setCancelButtonText("取消");
            }
            feedGDTVideoItemView.q.setOnClickConfirmButtonListener(z);
            feedGDTVideoItemView.q.setOnClickCancelButtonListener(fVar);
            if (feedGDTVideoItemView.q) {
                feedGDTVideoItemView.q.show();
            }
            return;
        }
        feedGDTVideoItemView.j = false;
        feedGDTVideoItemView.a(true);
    }

    static /* synthetic */ void a(FeedGDTVideoItemView feedGDTVideoItemView, View view) {
        if (feedGDTVideoItemView.l.w()) {
            String s = feedGDTVideoItemView.l.s();
            if (!TextUtils.isEmpty(s)) {
                TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(feedGDTVideoItemView.l), s, null);
                DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                downloadAdditionInfo.b = feedGDTVideoItemView.l.p();
                downloadAdditionInfo.a = feedGDTVideoItemView.l.o();
                downloadAdditionInfo.f = true;
                g.a();
                g.a(s, feedGDTVideoItemView.l.o(), taskStatInfo, downloadAdditionInfo);
            }
        }
        feedGDTVideoItemView.l.onClick(view);
    }

    static /* synthetic */ void i(FeedGDTVideoItemView feedGDTVideoItemView) {
        if (feedGDTVideoItemView.q != null) {
            feedGDTVideoItemView.q.dismiss();
        }
    }
}
