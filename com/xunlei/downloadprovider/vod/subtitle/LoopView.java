package com.xunlei.downloadprovider.vod.subtitle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class LoopView extends View {
    private static final int A = ((int) (Resources.getSystem().getDisplayMetrics().density * 15.0f));
    private Context B;
    private GestureDetector C;
    private Paint D;
    private Paint E;
    private Paint F;
    private int G;
    private int H = 0;
    private float I;
    private Rect J = new Rect();
    private int K;
    private int L;
    Handler a;
    e b;
    ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
    ScheduledFuture<?> d;
    List<y> e;
    int f;
    int g;
    int h;
    int i;
    int j;
    float k;
    boolean l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    String[] t;
    int u;
    int v;
    int w;
    int x;
    long y = 0;
    private float z = 1.05f;

    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    public void setLineSpacingMultiplier(float f) {
        if (f > 1.0f) {
            this.k = f;
        }
    }

    public void setCenterTextColor(int i) {
        this.i = i;
        this.E.setColor(i);
    }

    public void setOuterTextColor(int i) {
        this.h = i;
        this.D.setColor(i);
    }

    public void setDividerColor(int i) {
        this.j = i;
        this.F.setColor(i);
    }

    public LoopView(Context context) {
        super(context);
        a(context, null);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.B = context;
        this.a = new c(this);
        this.C = new GestureDetector(context, new b(this));
        this.C.setIsLongpressEnabled(false);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.androidWheelView);
        this.f = context.getDimensionPixelSize(0, A);
        this.k = context.getFloat(1, 2.78f);
        this.i = context.getColor(2, -13553359);
        this.h = context.getColor(3, -5263441);
        this.j = context.getColor(4, -3815995);
        this.p = context.getInteger(7, 0);
        this.z = context.getFloat(8, 1.0f);
        this.s = context.getInteger(5, 9);
        if (this.s % 2 == 0) {
            this.s = 9;
        }
        this.l = context.getBoolean(6, true);
        context.recycle();
        this.t = new String[this.s];
        this.o = 0;
        this.D = new Paint();
        this.D.setColor(this.h);
        this.D.setAntiAlias(true);
        this.D.setTextSize((float) this.f);
        this.E = new Paint();
        this.E.setColor(this.i);
        this.E.setAntiAlias(true);
        this.E.setTextScaleX(this.z);
        this.E.setTextSize((float) this.f);
        this.F = new Paint();
        this.F.setColor(this.j);
        this.F.setStrokeWidth(1.0f * getResources().getDisplayMetrics().density);
        this.F.setAntiAlias(true);
    }

    public void setItemsVisibleCount(int i) {
        if (!(i % 2 == 0 || i == this.s)) {
            this.s = i;
            this.t = new String[this.s];
        }
    }

    private void b() {
        if (this.e == null || this.e.isEmpty()) {
            this.e = new ArrayList(5);
            this.e.add(new y("-1.0", -1000));
            this.e.add(new y("-0.5", -500));
            this.e.add(new y("0", 0));
            this.e.add(new y("0.5", 500));
            this.e.add(new y("1.0", 1000));
        }
        this.v = getMeasuredWidth();
        this.u = getMeasuredHeight();
        if (this.v != 0) {
            if (this.u != 0) {
                this.K = getPaddingLeft();
                this.L = getPaddingRight();
                this.x = this.u / 2;
                this.w = this.u;
                this.g = (int) (((float) this.w) / (this.k * ((float) this.s)));
                this.m = (int) ((((float) this.u) - (this.k * ((float) this.g))) / 2.0f);
                this.n = (int) ((((float) this.u) + (this.k * ((float) this.g))) / 2.0f);
                if (this.p == -1) {
                    if (this.l) {
                        this.p = (this.e.size() + 1) / 2;
                    } else {
                        this.p = 0;
                    }
                }
                this.q = this.p;
            }
        }
    }

    final void a(ACTION action) {
        a();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            action = this.k * ((float) this.g);
            this.H = (int) (((((float) this.o) % action) + action) % action);
            if (((float) this.H) > action / 2.0f) {
                this.H = (int) (action - ((float) this.H));
            } else {
                this.H = -this.H;
            }
        }
        this.d = this.c.scheduleWithFixedDelay(new f(this, this.H), 0, 10, TimeUnit.MILLISECONDS);
    }

    public final void a() {
        if (this.d != null && !this.d.isCancelled()) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.f = (int) (this.B.getResources().getDisplayMetrics().density * f);
            this.D.setTextSize((float) this.f);
            this.E.setTextSize((float) this.f);
        }
    }

    public final void setInitPosition(int i) {
        if (i < 0) {
            this.p = 0;
            return;
        }
        if (this.e != null && this.e.size() > i) {
            this.p = i;
        }
    }

    public final void setValueChangeListener(e eVar) {
        this.b = eVar;
    }

    public final void setItems(List<y> list) {
        this.e = list;
        b();
        invalidate();
    }

    public final int getSelectedItemValue() {
        if (this.e != null && this.G >= 0) {
            if (this.G < this.e.size()) {
                return ((y) this.e.get(this.G)).b;
            }
        }
        return 0;
    }

    public void setScaleX(float f) {
        this.z = f;
    }

    public void setCurrentPosition(int i) {
        if (this.e != null) {
            if (!this.e.isEmpty()) {
                int size = this.e.size();
                if (i >= 0 && i < size) {
                    this.p = i;
                    this.o = 0;
                    this.H = 0;
                    invalidate();
                }
            }
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.e != null) {
            int i;
            int i2;
            this.r = (int) (((float) this.o) / (this.k * ((float) this.g)));
            this.q = this.p + (this.r % this.e.size());
            if (this.l) {
                if (this.q < 0) {
                    this.q = this.e.size() + this.q;
                }
                if (this.q > this.e.size() - 1) {
                    this.q -= this.e.size();
                }
            } else {
                if (this.q < 0) {
                    this.q = 0;
                }
                if (this.q > this.e.size() - 1) {
                    this.q = this.e.size() - 1;
                }
            }
            int i3 = (int) (((float) this.o) % (this.k * ((float) this.g)));
            for (i = 0; i < this.s; i++) {
                i2 = this.q - ((this.s / 2) - i);
                if (this.l) {
                    while (i2 < 0) {
                        i2 += this.e.size();
                    }
                    while (i2 > this.e.size() - 1) {
                        i2 -= this.e.size();
                    }
                    this.t[i] = ((y) this.e.get(i2)).a;
                } else if (i2 < 0) {
                    this.t[i] = "";
                } else if (i2 > this.e.size() - 1) {
                    this.t[i] = "";
                } else {
                    this.t[i] = ((y) this.e.get(i2)).a;
                }
            }
            canvas.drawLine((float) this.K, (float) this.m, (float) (this.v - this.L), (float) this.m, this.F);
            canvas.drawLine((float) this.K, (float) this.n, (float) (this.v - this.L), (float) this.n, this.F);
            this.E.setTextSize(9.0f * getResources().getDisplayMetrics().scaledDensity);
            canvas.drawText("S", ((float) this.v) - (20.0f * getResources().getDisplayMetrics().density), ((float) this.m) + (21.0f * getResources().getDisplayMetrics().density), this.E);
            this.E.setTextSize((float) this.f);
            for (i = 0; i < this.s; i++) {
                canvas.save();
                float f = ((float) this.g) * this.k;
                double d = (double) (((((float) i) * f) - ((float) i3)) + ((f - ((float) this.g)) / 2.0f));
                if (d < ((double) this.u)) {
                    if (d > ((double) (-this.g))) {
                        int i4 = (int) d;
                        double abs = 1.0d - Math.abs(((d + ((double) (((float) this.g) / 2.0f))) - ((double) (((float) this.u) / 2.0f))) / ((double) (((float) this.u) / 2.0f)));
                        d = 0.5d;
                        if (abs >= 0.5d) {
                            d = abs;
                        }
                        canvas.translate(0.0f, (float) i4);
                        float f2 = (float) d;
                        canvas.scale(f2, f2, ((float) this.v) / 2.0f, 0.0f);
                        if (i4 <= this.m && this.g + i4 >= this.m) {
                            canvas.save();
                            canvas.clipRect(0, 0, this.v, this.m - i4);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.D, this.J), (float) this.g, this.D);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0, this.m - i4, this.v, (int) f);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.E, this.J), (float) this.g, this.E);
                            canvas.restore();
                        } else if (i4 <= this.n && this.g + i4 >= this.n) {
                            canvas.save();
                            canvas.clipRect(0, 0, this.v, this.n - i4);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.E, this.J), (float) this.g, this.E);
                            canvas.restore();
                            canvas.save();
                            canvas.clipRect(0, this.n - i4, this.v, (int) f);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.D, this.J), (float) this.g, this.D);
                            canvas.restore();
                        } else if (i4 < this.m || this.g + i4 > this.n) {
                            canvas.clipRect(0, 0, this.v, (int) f);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.D, this.J), (float) this.g, this.D);
                        } else {
                            canvas.clipRect(0, 0, this.v, (int) f);
                            canvas.drawText(this.t[i], (float) a(this.t[i], this.E, this.J), (float) this.g, this.E);
                            i2 = a(this.t[i]);
                            if (i2 != this.G) {
                                this.G = i2;
                            }
                        }
                        canvas.restore();
                    }
                }
                canvas.restore();
            }
        }
    }

    public final int a(String str) {
        if (this.e != null) {
            if (!this.e.isEmpty()) {
                int size = this.e.size();
                for (int i = 0; i < size; i++) {
                    if (TextUtils.equals(((y) this.e.get(i)).a, str)) {
                        return i;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    private int a(String str, Paint paint, Rect rect) {
        paint.getTextBounds(str, 0, str.length(), rect);
        return (this.v - ((int) (((float) rect.width()) * this.z))) / 2;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        b();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.C.onTouchEvent(motionEvent);
        float f = this.k * ((float) this.g);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.y = System.currentTimeMillis();
            a();
            this.I = motionEvent.getRawY();
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!onTouchEvent) {
                r0 = ((((float) this.o) % f) + f) % f;
                this.H = (int) ((((float) (((int) (((Math.acos((double) ((((float) this.x) - motionEvent.getY()) / ((float) this.x))) * ((double) this.x)) + ((double) (f / 1073741824))) / ((double) f))) - (this.s / 2))) * f) - r0);
                if (System.currentTimeMillis() - this.y > 120) {
                    a(ACTION.DAGGLE);
                }
            }
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        } else {
            r0 = this.I - motionEvent.getRawY();
            this.I = motionEvent.getRawY();
            this.o = (int) (((float) this.o) + r0);
            if (this.l == null) {
                motionEvent = ((float) (-this.p)) * f;
                r0 = ((float) ((this.e.size() - 1) - this.p)) * f;
                if (((float) this.o) < motionEvent) {
                    this.o = (int) motionEvent;
                } else if (((float) this.o) > r0) {
                    this.o = (int) r0;
                }
            }
        }
        invalidate();
        return true;
    }
}
