package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.downloadprovider.player.xmp.c;
import com.xunlei.xllib.b.j;

public class PlayerOperationViewDefault extends FrameLayout {
    ThunderXmpPlayer a;
    boolean b;
    ViewGroup c;
    View d;
    TextView e;
    ViewGroup f;
    SeekBar g;
    ImageView h;
    TextView i;
    ImageView j;
    PlayerPosterView k;
    ImageView l;
    ProgressBar m;
    c n;
    private TextView o;
    private boolean p;
    private MediaPlayerLoadingView q;
    private Handler r = new am(this);
    private boolean s = true;
    private aj t = new as(this);

    static void e() {
    }

    public PlayerOperationViewDefault(Context context) {
        super(context);
        a(context);
    }

    public PlayerOperationViewDefault(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PlayerOperationViewDefault(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.player_default_operation_view, this, true);
        this.c = (ViewGroup) context.findViewById(R.id.title_layout);
        this.d = context.findViewById(R.id.btn_back);
        this.d.setOnClickListener(new an(this));
        this.e = (TextView) context.findViewById(R.id.tv_title);
        d();
        this.q = (MediaPlayerLoadingView) context.findViewById(R.id.loading_progress);
        this.k = (PlayerPosterView) context.findViewById(R.id.player_poster);
        this.l = (ImageView) context.findViewById(R.id.play_or_pause_btn);
        this.l.setOnClickListener(new ao(this));
        this.j = (ImageView) context.findViewById(R.id.btn_voice);
        if (this.p) {
            j();
        } else {
            f();
        }
        this.j.setOnClickListener(new ap(this));
        this.f = (ViewGroup) context.findViewById(R.id.bottom_layout);
        this.g = (SeekBar) context.findViewById(R.id.seek_bar);
        this.g.setOnSeekBarChangeListener(new aq(this));
        this.i = (TextView) context.findViewById(R.id.tv_play_time);
        this.o = (TextView) context.findViewById(R.id.tv_duration);
        this.h = (ImageView) context.findViewById(R.id.full_screen_btn);
        this.h.setOnClickListener(new ar(this));
        this.m = (ProgressBar) context.findViewById(R.id.progress_bar);
    }

    private void g() {
        if (this.a != null) {
            if (this.a.g() != 4) {
                if (this.a.g() != 1) {
                    this.l.setImageResource(R.drawable.ic_play_normal_index);
                    return;
                }
            }
            this.l.setImageResource(R.drawable.ic_pause_normal);
        }
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.a = thunderXmpPlayer;
        if (thunderXmpPlayer != null) {
            g();
            setSeekBarStatus(this.a.g());
            c();
            h();
        }
    }

    private void h() {
        int c = this.a.f.c();
        this.m.setMax(c);
        this.g.setMax(c);
        this.o.setText(j.a((long) c));
    }

    final void a() {
        if (this.r.hasMessages(1)) {
            this.r.removeMessages(1);
        }
    }

    final void b() {
        a();
        this.r.sendEmptyMessageDelayed(1, 2000);
    }

    final void c() {
        new StringBuilder("hideControl--isShowing=").append(this.b);
        a();
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(0);
        if (this.p) {
            j();
        }
        this.b = false;
        if (this.n != null) {
            this.n.a(false);
        }
    }

    private void i() {
        this.q.b();
        if (this.b) {
            this.l.setVisibility(0);
        }
    }

    public void setTitleVisiableInSmallScreen(boolean z) {
        this.s = z;
        d();
    }

    final void d() {
        if (this.s) {
            this.e.setVisibility(0);
        } else {
            this.e.setVisibility(8);
        }
    }

    public void setVisibleListener(c cVar) {
        this.n = cVar;
    }

    private void setSeekBarStatus(int i) {
        SeekBar seekBar = this.g;
        boolean z = true;
        if (i == 0 || i == 1) {
            z = false;
        }
        seekBar.setEnabled(z);
    }

    public aj getXmpPlayerListener() {
        return this.t;
    }

    private void j() {
        this.j.setVisibility(0);
    }

    final void f() {
        this.j.setVisibility(8);
    }

    public void setShouldShowVoiceBtn(boolean z) {
        this.p = z;
        if (this.b) {
            f();
        } else {
            j();
        }
    }

    static /* synthetic */ void d(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.c.setVisibility(8);
        playerOperationViewDefault.l.setVisibility(8);
        playerOperationViewDefault.f.setVisibility(8);
        playerOperationViewDefault.m.setVisibility(8);
    }

    static /* synthetic */ void e(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.l.setVisibility(8);
        playerOperationViewDefault.q.a();
    }

    static /* synthetic */ void g(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.i();
        playerOperationViewDefault.c.setVisibility(8);
        playerOperationViewDefault.l.setVisibility(8);
        playerOperationViewDefault.f.setVisibility(8);
        playerOperationViewDefault.m.setVisibility(8);
    }

    static /* synthetic */ void k(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.k.a();
        playerOperationViewDefault.i();
        playerOperationViewDefault.g();
        playerOperationViewDefault.b();
    }

    static /* synthetic */ void l(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.g();
        playerOperationViewDefault.a();
    }

    static /* synthetic */ void m(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.a();
        playerOperationViewDefault.g();
        playerOperationViewDefault.i();
    }

    static /* synthetic */ void n(PlayerOperationViewDefault playerOperationViewDefault) {
        playerOperationViewDefault.q.a();
        playerOperationViewDefault.c();
    }
}
