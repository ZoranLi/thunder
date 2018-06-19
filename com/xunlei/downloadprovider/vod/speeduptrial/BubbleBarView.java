package com.xunlei.downloadprovider.vod.speeduptrial;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import com.xunlei.downloadprovider.R;

public class BubbleBarView extends DimenView implements AnimatorListener, AnimationListener {
    public static final int a = DimenView.a(30.0f);
    private static final String j = "#323232";
    private static final String k = "#094b7d";
    private static final String l = "#239ffd";
    private static final long m = 500;
    private static final long n = 500;
    private static final int o = DimenView.a(95.0f);
    public int b;
    public ValueAnimator c;
    public ValueAnimator d;
    public TranslateAnimation e;
    TranslateAnimation f;
    public boolean g;
    public a h;
    private Bitmap p;
    private Bitmap q;
    private Paint r;
    private Paint s;
    private Paint t;
    private float u;
    private int v;
    private int w = 100;
    private int x = null;
    private RectF y;
    private RectF z;

    public interface a {
        void a(BubbleBarView bubbleBarView);

        void b(BubbleBarView bubbleBarView);

        void c(BubbleBarView bubbleBarView);

        void d(BubbleBarView bubbleBarView);

        void e(BubbleBarView bubbleBarView);

        void f(BubbleBarView bubbleBarView);

        void g(BubbleBarView bubbleBarView);

        void h(BubbleBarView bubbleBarView);

        void i(BubbleBarView bubbleBarView);

        void j(BubbleBarView bubbleBarView);
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public BubbleBarView(Context context) {
        super(context);
        c();
    }

    public BubbleBarView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public BubbleBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    public final boolean a() {
        return this.x == this.w;
    }

    public void setMax(int i) {
        this.w = i;
    }

    public void setCallback(a aVar) {
        this.h = aVar;
    }

    private void c() {
        this.g = false;
        this.u = DimenView.b(4.0f);
        this.b = a;
        this.v = a;
        this.p = BitmapFactory.decodeResource(getResources(), R.drawable.lightning);
        this.q = BitmapFactory.decodeResource(getResources(), R.drawable.lightning_back);
        this.r = new Paint(1);
        this.r.setColor(Color.parseColor(j));
        this.r.setStyle(Style.FILL);
        this.s = new Paint(1);
        this.s.setColor(Color.parseColor(l));
        this.t = new Paint(1);
        this.t.setColor(Color.parseColor(k));
        this.c = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(m);
        this.c.addUpdateListener(new b(this));
        this.c.addListener(this);
        this.d = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f}).setDuration(m);
        this.d.addUpdateListener(new c(this));
        this.d.addListener(this);
        this.e = new TranslateAnimation((float) o, 0.0f, 0.0f, 0.0f);
        this.e.setFillAfter(true);
        this.e.setDuration(n);
        this.e.setAnimationListener(this);
        this.f = new TranslateAnimation(0.0f, (float) o, 0.0f, 0.0f);
        this.f.setFillAfter(true);
        this.f.setDuration(n);
        this.f.setAnimationListener(this);
    }

    public float getProgressRate() {
        return (((float) this.x) * 1.0f) / ((float) this.w);
    }

    public void setExitAnimRightMargin(float f) {
        this.f = new TranslateAnimation(0.0f, (float) (o + DimenView.a(f)), 0.0f, 0.0f);
        this.f.setFillAfter(true);
        this.f.setDuration(n);
        this.f.setAnimationListener(this);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.y = new RectF((float) (this.b - this.v), 0.0f, (float) this.b, (float) this.v);
        this.z = new RectF(0.0f, 0.0f, (float) this.b, (float) this.v);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.b, this.v);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.z, (float) (this.v / 2), (float) (this.v / 2), this.r);
        canvas.drawArc(this.y, -90.0f, 360.0f, true, this.t);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.y, -90.0f - ((1.0f - getProgressRate()) * 360.0f), 360.0f * (1.0f - getProgressRate()), true, this.s);
        if (a()) {
            canvas.drawBitmap(this.q, (((float) this.b) - this.u) - DimenView.b(22.0f), this.u, null);
        } else {
            canvas.drawBitmap(this.p, (((float) this.b) - this.u) - DimenView.b(22.0f), this.u, null);
        }
    }

    public void onAnimationStart(Animator animator) {
        this.g = true;
        if (this.h != null) {
            if (animator == this.c) {
                this.h.e(this);
            } else if (animator == this.d) {
                this.h.g(this);
            }
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.g = false;
        if (this.h != null) {
            if (animator == this.c) {
                this.h.f(this);
            } else if (animator == this.d) {
                this.h.h(this);
            }
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.g = null;
    }

    public void onAnimationStart(Animation animation) {
        this.g = true;
        if (this.h != null) {
            if (animation == this.e) {
                this.h.a(this);
            } else if (animation == this.f) {
                this.h.c(this);
            }
        }
    }

    public void onAnimationEnd(Animation animation) {
        this.g = false;
        if (this.h != null) {
            if (animation == this.e) {
                this.h.b(this);
            } else if (animation == this.f) {
                this.h.d(this);
            }
        }
    }

    public void setProgress(int i) {
        Object obj = (i < 0 || i > this.w) ? null : 1;
        if (obj != null) {
            if (a() && i < this.w) {
                this.h.j(this);
            }
            if (this.x < this.w && i == this.w && this.h != null) {
                this.h.i(this);
            }
            this.x = i;
            invalidate();
        }
    }
}
