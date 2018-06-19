package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.c;
import com.xunlei.downloadprovider.player.xmp.d;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.xllib.b.j;

public class PlayerOperationViewDetail extends FrameLayout {
    private Handler A = new au(this);
    private aj B = new av(this);
    ThunderXmpPlayer a;
    boolean b;
    View c;
    TextView d;
    SeekBar e;
    ImageView f;
    ProgressBar g;
    PlayerPosterView h;
    private ViewGroup i;
    private ViewGroup j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private boolean n = true;
    private LottieAnimationView o;
    private View p;
    private ViewGroup q;
    private TextView r;
    private TextView s;
    private MediaPlayerLoadingView t;
    private View u;
    private c v;
    private d w;
    private View x;
    private y y;
    private ImageView z;

    public PlayerOperationViewDetail(Context context) {
        super(context);
        a(context);
    }

    public PlayerOperationViewDetail(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerOperationViewDetail(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_detail_operation_view, this, true);
        this.u = context.findViewById(R.id.operation_background);
        this.c = context.findViewById(R.id.btn_back);
        this.c.setOnClickListener(new ax(this));
        this.i = (ViewGroup) context.findViewById(R.id.title_layout);
        this.d = (TextView) context.findViewById(R.id.tv_title);
        this.d.setVisibility(8);
        this.j = (ViewGroup) context.findViewById(R.id.center_layout);
        this.t = (MediaPlayerLoadingView) context.findViewById(R.id.loading_progress);
        this.h = (PlayerPosterView) context.findViewById(R.id.player_poster);
        this.x = context.findViewById(R.id.covering_view);
        this.k = (ImageView) context.findViewById(R.id.play_or_pause_btn);
        this.k.setOnClickListener(new ay(this));
        this.l = (ImageView) context.findViewById(R.id.prev_play_btn);
        this.l.setOnClickListener(new az(this));
        this.m = (ImageView) context.findViewById(R.id.next_play_btn);
        this.m.setOnClickListener(new ba(this));
        this.o = (LottieAnimationView) context.findViewById(R.id.live_guide_view);
        this.p = context.findViewById(R.id.live_guide_layout);
        findViewById(R.id.live_guide_click_view).setOnClickListener(new bb(this));
        this.q = (ViewGroup) context.findViewById(R.id.bottom_layout);
        this.e = (SeekBar) context.findViewById(R.id.seek_bar);
        this.e.setOnSeekBarChangeListener(new bc(this));
        this.g = (ProgressBar) context.findViewById(R.id.progress_bar);
        this.r = (TextView) context.findViewById(R.id.tv_play_time);
        this.s = (TextView) context.findViewById(R.id.tv_duration);
        this.f = (ImageView) context.findViewById(R.id.full_screen_btn);
        this.f.setOnClickListener(new bd(this));
        this.z = (ImageView) findViewById(R.id.iv_gray_bg);
    }

    private void c() {
        if (this.a != null) {
            if (this.a.g() != 4) {
                if (this.a.g() != 1) {
                    this.k.setImageResource(R.drawable.ic_play_normal_index);
                    return;
                }
            }
            this.k.setImageResource(R.drawable.ic_pause_normal);
        }
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
        if (thunderXmpPlayer != null) {
            setSeekBarStatus(this.a.g());
            c();
            d();
        }
    }

    public void setTitleBarTopMargin(int i) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
        marginLayoutParams.topMargin = i;
        this.i.setLayoutParams(marginLayoutParams);
    }

    private void d() {
        int c = this.a.f.c();
        this.g.setMax(c);
        this.e.setMax(c);
        this.s.setText(j.a((long) c));
    }

    public final void a(boolean z) {
        new StringBuilder("show--isShowing=").append(this.b);
        e();
        this.u.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.q.setVisibility(0);
        this.g.setVisibility(8);
        if (!this.b) {
            if (z) {
                z = new AlphaAnimation(0.0f, 1.0f);
                z.setDuration(200);
                z.setStartOffset(200);
                this.u.startAnimation(z);
                this.i.startAnimation(z);
                this.j.startAnimation(z);
                this.q.startAnimation(z);
            }
            this.b = true;
            if (this.v != null) {
                this.v.a(true);
            }
        }
    }

    private void e() {
        this.A.removeMessages(1);
    }

    final void a() {
        e();
        this.A.sendEmptyMessageDelayed(1, 2000);
    }

    final void b(boolean z) {
        new StringBuilder("hideControl--isShowing=").append(this.b);
        e();
        this.u.setVisibility(8);
        this.i.setVisibility(8);
        this.j.setVisibility(8);
        this.q.setVisibility(8);
        this.g.setVisibility(0);
        if (this.b) {
            if (z) {
                z = new AlphaAnimation(1.0f, 0.0f);
                z.setDuration(200);
                this.u.startAnimation(z);
                this.i.startAnimation(z);
                this.j.startAnimation(z);
                this.q.startAnimation(z);
            }
            this.b = false;
            if (this.v) {
                this.v.a(false);
            }
        }
    }

    public static int getLivingBarSpaceY() {
        return BrothersApplication.getApplicationInstance().getResources().getDimensionPixelSize(R.dimen.short_movie_detail_living_bar_spacing_bottom) + BrothersApplication.getApplicationInstance().getResources().getDimensionPixelSize(R.dimen.short_movie_detail_living_bar_height);
    }

    public final void b() {
        f();
        this.k.setVisibility(8);
        this.t.a();
    }

    private void f() {
        this.A.removeMessages(2);
    }

    private void g() {
        f();
        this.k.setVisibility(0);
        this.t.b();
    }

    final void a(int i, boolean z) {
        if (z) {
            i = this.a.f.c();
        }
        this.g.setSecondaryProgress(i);
        this.e.setSecondaryProgress(i);
    }

    public void setVisiableListener(c cVar) {
        this.v = cVar;
    }

    final void a(int i) {
        if (i >= 0) {
            this.g.setProgress(i);
            this.e.setProgress(i);
            this.r.setText(j.a((long) i));
        }
    }

    public void setPrevPlayBtnVisible(boolean z) {
        if (z) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    public void setNextPlayBtnVisiable(boolean z) {
        if (z) {
            this.m.setVisibility(0);
        } else {
            this.m.setVisibility(8);
        }
    }

    private void setSeekBarStatus(int i) {
        SeekBar seekBar = this.e;
        boolean z = true;
        if (i == 0 || i == 1) {
            z = false;
        }
        seekBar.setEnabled(z);
    }

    public void setOnControllerClickListener(d dVar) {
        this.w = dVar;
    }

    public void setVideoInfo(y yVar) {
        this.y = yVar;
        if (yVar != null) {
            new StringBuilder("updateLiveGuideViewVisible. time: ").append(System.currentTimeMillis());
            if (a(this.y)) {
                new StringBuilder("updateLiveGuideViewVisiable--show--mIsFirstLiveShow=").append(this.n);
                this.p.setVisibility(0);
                if (this.n) {
                    post(new be(this));
                    this.n = false;
                }
                if (this.w != null) {
                    this.w.d();
                }
            } else {
                this.p.setVisibility(8);
            }
            this.d.setText(yVar.c);
        }
    }

    public void setGrayBgVisibility(int i) {
        this.z.setVisibility(i);
    }

    public aj getXmpPlayerListener() {
        return this.B;
    }

    public void setLiveGuideMarginBottom(int i) {
        LayoutParams layoutParams = (FrameLayout.LayoutParams) this.p.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(-2, -2);
        }
        layoutParams.bottomMargin = i;
        this.p.setLayoutParams(layoutParams);
    }

    public static boolean a(y yVar) {
        return (yVar == null || yVar.t == null || yVar.t.a() == null) ? null : true;
    }

    static /* synthetic */ void b(PlayerOperationViewDetail playerOperationViewDetail) {
        if (playerOperationViewDetail.h != null) {
            if (playerOperationViewDetail.h.getDrawable() != null) {
                playerOperationViewDetail.h.a();
            } else {
                playerOperationViewDetail.h.setVisibility(8);
            }
            playerOperationViewDetail.h = null;
        }
    }

    static /* synthetic */ void j(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.i.setVisibility(8);
        playerOperationViewDetail.j.setVisibility(8);
        playerOperationViewDetail.q.setVisibility(8);
        playerOperationViewDetail.g.setVisibility(8);
    }

    static /* synthetic */ void n(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.g();
        playerOperationViewDetail.i.setVisibility(8);
        playerOperationViewDetail.j.setVisibility(8);
        playerOperationViewDetail.q.setVisibility(8);
        playerOperationViewDetail.g.setVisibility(8);
    }

    static /* synthetic */ void o(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.c();
        playerOperationViewDetail.b(false);
        playerOperationViewDetail.A.sendEmptyMessageDelayed(3, 1000);
    }

    static /* synthetic */ void p(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.c();
        playerOperationViewDetail.e();
        playerOperationViewDetail.a(false);
    }

    static /* synthetic */ void q(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.e();
        playerOperationViewDetail.c();
        playerOperationViewDetail.g();
    }

    static /* synthetic */ void r(PlayerOperationViewDetail playerOperationViewDetail) {
        playerOperationViewDetail.x.setVisibility(0);
        playerOperationViewDetail.b(false);
        playerOperationViewDetail.b();
    }
}
