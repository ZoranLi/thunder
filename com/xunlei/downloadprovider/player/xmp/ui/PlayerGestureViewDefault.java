package com.xunlei.downloadprovider.player.xmp.ui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.aj;
import com.xunlei.xllib.android.c;
import com.xunlei.xllib.b.j;

public class PlayerGestureViewDefault extends FrameLayout {
    private a A;
    private OnGestureListener B = new ag(this);
    private aj C = new ai(this);
    private GestureDetector a;
    private State b = State.IDLE;
    private float c = -1.0f;
    private float d = -1.0f;
    private int e;
    private int f;
    private int g;
    private float h;
    private View i;
    private ImageView j;
    private ProgressBar k;
    private TextView l;
    private int m;
    private int n;
    private AudioManager o;
    private View p;
    private ImageView q;
    private ProgressBar r;
    private c s;
    private int t;
    private View u;
    private ProgressBar v;
    private boolean w;
    private ObjectAnimator x;
    private ObjectAnimator y;
    private ThunderXmpPlayer z;

    enum State {
        IDLE,
        POSITION,
        VOLUME,
        LIGHT
    }

    public interface a {
        boolean a();

        void b();

        void c();

        void d();

        boolean e();

        void f();
    }

    public PlayerGestureViewDefault(Context context) {
        super(context);
        b(context);
        a(context);
    }

    public PlayerGestureViewDefault(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
        a(context);
    }

    public PlayerGestureViewDefault(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.thunder_media_player_gesture_view, this, true);
        this.i = findViewById(R.id.position_layout);
        this.l = (TextView) findViewById(R.id.position_view);
        this.j = (ImageView) findViewById(R.id.position_icon);
        this.k = (ProgressBar) findViewById(R.id.position_progress);
        this.p = findViewById(R.id.volume_layout);
        this.q = (ImageView) findViewById(R.id.volume_icon);
        this.r = (ProgressBar) findViewById(R.id.volume_progress);
        this.r.setMax(this.m);
        this.u = findViewById(R.id.light_layout);
        this.v = (ProgressBar) findViewById(R.id.light_progress);
        this.v.setMax(255);
        this.a = new GestureDetector(context, this.B);
        this.a.setIsLongpressEnabled(true);
    }

    private void b(Context context) {
        this.o = (AudioManager) context.getSystemService("audio");
        this.m = this.o.getStreamMaxVolume(3);
        this.s = c.a(context);
        if (this.s != null) {
            this.t = this.s.a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = (motionEvent.getAction() & 255) == 1;
        if (this.a.onTouchEvent(motionEvent) != null || !z) {
            return true;
        }
        new StringBuilder("onTouchUp--mState=").append(this.b);
        new StringBuilder("animationToResetState--mState=").append(this.b);
        switch (aj.a[this.b.ordinal()]) {
            case 1:
                break;
            case 2:
                if (getDuration() > null) {
                    b(this.i);
                    this.z.a(this.g);
                    break;
                }
                break;
            case 3:
                b(this.p);
                b();
                break;
            case 4:
                b(this.u);
                if (this.s != null) {
                    this.t = c.a(this.z.e);
                    break;
                }
                break;
            default:
                break;
        }
        this.b = State.IDLE;
        return true;
    }

    public void setMediaPlayer(ThunderXmpPlayer thunderXmpPlayer) {
        this.z = thunderXmpPlayer;
    }

    private void setMediaDuration(int i) {
        int width = getWidth();
        if (width > 0) {
            this.e = i;
            this.h = ((float) i) / ((float) width);
            this.k.setMax(i);
        }
    }

    private void setTouchDownPosition(int i) {
        this.f = i;
    }

    public void setShouldDetectorGestureMove(boolean z) {
        this.w = z;
    }

    private void a(int i) {
        if (i < 0) {
            this.j.setImageResource(R.drawable.player_gesture_go_back_icon);
        } else {
            this.j.setImageResource(R.drawable.player_gesture_go_forward_icon);
        }
    }

    private void b(int i) {
        if (i == 0) {
            this.q.setImageResource(R.drawable.player_gesture_silent_icon);
        } else {
            this.q.setImageResource(R.drawable.player_gesture_volume_icon);
        }
    }

    private void b() {
        this.n = this.o.getStreamVolume(3);
    }

    private void a(View view) {
        new StringBuilder("showStateLayout--layout=").append(view);
        if (this.x != null) {
            this.x.cancel();
            this.x = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f});
        ofFloat.setDuration(200);
        view.setVisibility(0);
        ofFloat.start();
        this.y = ofFloat;
    }

    private void b(View view) {
        new StringBuilder("startHideAnimation--layout=").append(view);
        if (this.y != null) {
            this.y.cancel();
            this.y = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f});
        ofFloat.setDuration(500);
        ofFloat.addListener(new ah(this, view));
        ofFloat.start();
        this.x = ofFloat;
    }

    public final void a() {
        this.b = State.IDLE;
        this.u.setVisibility(8);
        this.p.setVisibility(8);
        this.i.setVisibility(8);
    }

    public void setOnGestureListener(a aVar) {
        this.A = aVar;
    }

    private int getDuration() {
        if (this.e <= 0) {
            setMediaDuration(this.z.f.c());
        }
        return this.e;
    }

    public aj getXmpPlayerListener() {
        return this.C;
    }

    static /* synthetic */ boolean a(PlayerGestureViewDefault playerGestureViewDefault, float f, float f2) {
        playerGestureViewDefault = playerGestureViewDefault.getResources().getDisplayMetrics();
        int i = playerGestureViewDefault.widthPixels;
        playerGestureViewDefault = playerGestureViewDefault.heightPixels;
        if (f >= 50.0f && f <= ((float) (i - 50)) && f2 >= 50.0f) {
            if (f2 <= ((float) (playerGestureViewDefault - 50))) {
                return true;
            }
        }
        return null;
    }

    static /* synthetic */ void b(PlayerGestureViewDefault playerGestureViewDefault, int i) {
        playerGestureViewDefault.b = State.POSITION;
        if (playerGestureViewDefault.getDuration() > 0) {
            if (playerGestureViewDefault.A != null) {
                playerGestureViewDefault.A.c();
            }
            playerGestureViewDefault.a(i);
            playerGestureViewDefault.i.setAlpha(1.0f);
            playerGestureViewDefault.a(playerGestureViewDefault.i);
        }
    }

    static /* synthetic */ void g(PlayerGestureViewDefault playerGestureViewDefault) {
        playerGestureViewDefault.b = State.VOLUME;
        playerGestureViewDefault.b();
        playerGestureViewDefault.b(playerGestureViewDefault.n);
        playerGestureViewDefault.p.setAlpha(1.0f);
        playerGestureViewDefault.a(playerGestureViewDefault.p);
        if (playerGestureViewDefault.A != null) {
            playerGestureViewDefault.A.d();
        }
    }

    static /* synthetic */ void h(PlayerGestureViewDefault playerGestureViewDefault) {
        playerGestureViewDefault.b = State.LIGHT;
        playerGestureViewDefault.u.setAlpha(1.0f);
        playerGestureViewDefault.a(playerGestureViewDefault.u);
        if (playerGestureViewDefault.A != null) {
            playerGestureViewDefault.A.b();
        }
    }

    static /* synthetic */ void a(PlayerGestureViewDefault playerGestureViewDefault, int i, int i2) {
        i = j.a((long) i);
        i2 = j.a((long) i2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" / ");
        stringBuilder.append(i2);
        i2 = stringBuilder.toString();
        CharSequence spannableStringBuilder = new SpannableStringBuilder(i2);
        i2 = i2.indexOf(i);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1294f6")), i2, i.length() + i2, 34);
        playerGestureViewDefault.l.setText(spannableStringBuilder);
    }
}
