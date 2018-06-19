package com.xunlei.downloadprovider.vod.floatwindow;

import android.content.Context;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class VodPlayerFloatWindowView extends RelativeLayout implements OnClickListener {
    public static final String a = "VodPlayerFloatWindowView";
    protected ProgressBar b;
    protected View c;
    protected TextView d;
    protected TextView e;
    protected TextView f;
    ImageView g;
    ImageView h;
    public Runnable i = new o(this);
    private SurfaceView j;
    private ImageView k;
    private ImageView l;
    private TextView m;
    private a n;

    public interface a {
        void a();

        void b();

        void c();
    }

    public VodPlayerFloatWindowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VodPlayerFloatWindowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VodPlayerFloatWindowView(Context context) {
        super(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected void onFinishInflate() {
        this.b = (ProgressBar) findViewById(R.id.skb_bottom_progress);
        this.c = findViewById(R.id.lyt_playing_error_view);
        this.c.setVisibility(8);
        this.d = (TextView) this.c.findViewById(R.id.tv_text);
        this.e = (TextView) this.c.findViewById(R.id.tv_retry);
        this.j = (SurfaceView) findViewById(R.id.surfaceView);
        this.j.setVisibility(0);
        this.f = (TextView) findViewById(R.id.tv_subtitle);
        this.g = (ImageView) findViewById(R.id.iv_close);
        this.k = (ImageView) findViewById(R.id.iv_fullscreen);
        this.l = (ImageView) findViewById(R.id.iv_float_window_pause);
        this.e.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.m = (TextView) findViewById(R.id.player_loading_text);
        this.h = (ImageView) findViewById(R.id.player_poster_image);
    }

    public SurfaceView getSurfaceView() {
        return this.j;
    }

    public int getPauseButtonVisibility() {
        return this.l.getVisibility();
    }

    public final void a(boolean z) {
        if (z) {
            this.l.setImageResource(R.drawable.ic_play_normal_index);
            this.l.removeCallbacks(this.i);
        } else {
            this.l.setImageResource(R.drawable.ic_pause_selector);
            this.l.removeCallbacks(this.i);
            this.l.postDelayed(this.i, 2500);
        }
        this.g.setVisibility(0);
        this.k.setVisibility(0);
        if (this.m.getVisibility()) {
            this.l.setVisibility(0);
        }
    }

    public final void a() {
        this.l.removeCallbacks(this.i);
        this.l.setVisibility(8);
        this.g.setVisibility(8);
        this.k.setVisibility(8);
    }

    private void e() {
        this.m.setVisibility(8);
        this.m.setText(R.string.vod_player_default_loading_text);
    }

    public void setLoadingText(CharSequence charSequence) {
        this.m.setText(charSequence);
    }

    public final void a(String str) {
        this.f.setText(str);
    }

    public void setSubtitleColor(@ColorInt int i) {
        this.f.setTextColor(i);
    }

    public final void a(int i, int i2, int i3) {
        this.b.setMax(i);
        if (i2 >= 0) {
            this.b.setProgress(i2);
        }
        if (i3 >= 0) {
            this.b.setSecondaryProgress(i3);
        }
    }

    public void setClickListener(a aVar) {
        this.n = aVar;
    }

    public final void b() {
        a(true);
        e();
    }

    public final void c() {
        a(false);
        e();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                if (this.n != null) {
                    this.n.b();
                    return;
                }
                break;
            case R.id.iv_fullscreen:
                if (this.n != null) {
                    this.n.c();
                    break;
                }
                break;
            case R.id.iv_float_window_pause:
                if (this.n != null) {
                    this.n.a();
                    return;
                }
                break;
            case R.id.tv_retry:
                if (this.n != null) {
                    return;
                }
                break;
            default:
                break;
        }
    }

    public final void d() {
        this.m.setVisibility(0);
        this.l.setVisibility(8);
    }
}
