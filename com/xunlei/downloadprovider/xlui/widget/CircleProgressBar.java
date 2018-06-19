package com.xunlei.downloadprovider.xlui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;

public class CircleProgressBar extends View {
    private Drawable a;
    private Drawable b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private SweepGradient i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private Paint r;
    private RectF s;
    private boolean t;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = null;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 1;
        this.r = null;
        this.s = null;
        this.t = true;
        setWillNotDraw(false);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.d = 100;
        this.e = 0;
        this.f = 0;
        this.k = 24;
        this.m = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
        this.l = 24;
        this.n = (int) TypedValue.applyDimension(1, 60.0f, displayMetrics);
        this.o = DipPixelUtil.dip2px(4.0f);
        this.g = getResources().getColor(R.color.blue_hover);
        this.h = getResources().getColor(R.color.blue_mormal);
        this.c = getResources().getColor(R.color.download_list_operate_bg);
        this.p = 0;
        this.q = 1;
        context = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar, i, 0);
        this.k = context.getDimensionPixelSize(2, this.k);
        this.l = context.getDimensionPixelSize(1, this.l);
        this.m = context.getDimensionPixelSize(4, this.m);
        this.n = context.getDimensionPixelSize(3, this.n);
        this.o = context.getDimensionPixelSize(5, this.o);
        this.c = context.getColor(12, this.c);
        this.g = context.getColor(6, this.g);
        this.h = context.getColor(7, this.h);
        this.p = context.getInt(0, this.p);
        attributeSet = context.getDrawable(8);
        if (attributeSet != null) {
            setImageDrawable(attributeSet);
        }
        setMax(context.getInt(9, this.d));
        setProgress(context.getInt(10, this.e));
        setSecondaryProgress(context.getInt(11, this.f));
        context.recycle();
    }

    public int getMax() {
        return this.d;
    }

    public void setMax(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i != this.d) {
            this.d = i;
            if (this.e > i) {
                this.e = i;
            }
            if (this.f > i) {
                this.f = i;
            }
            postInvalidate();
        }
    }

    public synchronized int getProgress() {
        return this.e;
    }

    public synchronized void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.d) {
            i = this.d;
        }
        if (i != this.e) {
            this.e = i;
            postInvalidate();
        }
    }

    public synchronized int getSecondaryProgress() {
        return this.f;
    }

    public synchronized void setSecondaryProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > this.d) {
            i = this.d;
        }
        if (i != this.f) {
            this.f = i;
            postInvalidate();
        }
    }

    public void setBackgroundResource(int i) {
        setBackgroundDrawable(getResources().getDrawable(i));
    }

    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    public void setProgressColor(int i) {
        this.g = getResources().getColor(i);
        postInvalidate();
    }

    public void setSecondaryProgressColor(int i) {
        this.h = getResources().getColor(i);
        postInvalidate();
    }

    public void setDrawProgress(boolean z) {
        this.t = z;
    }

    public void setUseGradient(boolean z) {
        this.j = z;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        Object obj;
        if (this.a == null || drawable == this.a) {
            obj = null;
        } else {
            this.a.setCallback(null);
            obj = 1;
        }
        this.a = drawable;
        if (obj != null) {
            a(getWidth(), getHeight());
            invalidate();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        Object obj;
        if (this.b == null || drawable == this.b) {
            obj = null;
        } else {
            this.b.setCallback(null);
            obj = 1;
        }
        this.b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            int measuredWidth = getMeasuredWidth();
            if (measuredWidth != 0 && measuredWidth < drawable.getMinimumWidth()) {
                requestLayout();
            }
        }
        if (obj != null) {
            b(getWidth(), getHeight());
            a();
            invalidate();
        }
    }

    private void a(int i, int i2) {
        if (this.a != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            this.a.setBounds(0, 0, (i - paddingRight) - paddingLeft, (i2 - getPaddingBottom()) - getPaddingTop());
        }
    }

    private void b(int i, int i2) {
        if (this.b != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            i = ((i - paddingRight) - paddingLeft) - (this.o * 2);
            i2 = ((i2 - getPaddingBottom()) - getPaddingTop()) - (2 * this.o);
            paddingLeft = this.b.getIntrinsicWidth();
            paddingRight = this.b.getIntrinsicHeight();
            if (paddingLeft <= i) {
                if (paddingRight <= i2) {
                    this.b.setBounds(0, 0, paddingLeft, paddingRight);
                }
            }
            this.b.setBounds(0, 0, i, i2);
        }
    }

    protected void drawableStateChanged() {
        a();
    }

    private void a() {
        if (this.b != null && this.b.isStateful()) {
            this.b.setState(getDrawableState());
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.b ? true : null;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            drawable = drawable.getBounds();
            int measuredWidth = getMeasuredWidth();
            int scrollX = (getScrollX() + getPaddingLeft()) + ((((measuredWidth - drawable.width()) - getPaddingLeft()) - getPaddingRight()) / 2);
            measuredWidth = (getScrollY() + getPaddingTop()) + ((((getMeasuredHeight() - drawable.height()) - getPaddingTop()) - getPaddingBottom()) / 2);
            invalidate(drawable.left + scrollX, drawable.top + measuredWidth, drawable.right + scrollX, drawable.bottom + measuredWidth);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        a(i, i2);
        b(i, i2);
    }

    private Paint getDrawPaint() {
        if (this.r == null) {
            this.r = new Paint();
        }
        return this.r;
    }

    private RectF getDrawRectF() {
        if (this.s == null) {
            this.s = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return this.s;
    }

    private RectF c(int i, int i2) {
        RectF drawRectF = getDrawRectF();
        drawRectF.set(-1.0f, -1.0f, (float) i, (float) i2);
        return drawRectF;
    }

    protected void onDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth();
        if (this.t) {
            canvas.save();
            float f = ((float) measuredWidth) / 2.0f;
            canvas2.rotate(-90.0f, f, f);
            canvas2.translate((float) paddingLeft, (float) paddingTop);
            float f2 = (r0.d > 0 ? ((float) r0.e) / ((float) r0.d) : 0.0f) * 360.0f;
            RectF drawRectF = getDrawRectF();
            Paint drawPaint = getDrawPaint();
            drawPaint.setAntiAlias(true);
            drawPaint.setColor(r0.c);
            drawPaint.setShader(null);
            drawPaint.setStyle(Style.STROKE);
            drawPaint.setStrokeWidth(5.0f);
            float f3 = 5.0f;
            Shader shader = null;
            canvas2.drawArc(drawRectF, 0.0f, 360.0f, true, drawPaint);
            if (0.0f < f2) {
                int i = (measuredWidth / 2) - paddingLeft;
                drawPaint = getDrawPaint();
                drawPaint.setAntiAlias(true);
                if (r0.j) {
                    drawPaint.setColor(-1);
                    if (r0.i == null) {
                        float f4 = (float) i;
                        r0.i = new SweepGradient(f4, f4, getResources().getColor(R.color.download_list_task_progress_firstacc), getResources().getColor(R.color.download_list_task_progress_secondacc));
                    }
                    drawPaint.setShader(r0.i);
                } else {
                    drawPaint.setShader(shader);
                    drawPaint.setColor(r0.g);
                }
                drawPaint.setStyle(Style.STROKE);
                drawPaint.setStrokeWidth(5.0f);
                canvas2.drawArc(drawRectF, 0.0f, f2, false, drawPaint);
            }
            canvas.restore();
        }
        if (r0.b != null) {
            canvas.save();
            Rect bounds = r0.b.getBounds();
            canvas2.translate((((float) (((measuredWidth - bounds.width()) - paddingLeft) - getPaddingRight())) / 2.0f) + ((float) paddingLeft), (((float) (((getMeasuredHeight() - bounds.height()) - paddingTop) - getPaddingBottom())) / 2.0f) + ((float) paddingTop));
            r0.b.draw(canvas2);
            canvas.restore();
        }
    }

    protected void onMeasure(int i, int i2) {
        i2 = 0;
        if (1 == this.q) {
            i = this.b;
            if (i != 0) {
                i2 = i.getIntrinsicWidth();
                i = i.getIntrinsicHeight();
                if (i2 > i) {
                    i2 = i;
                }
            }
            i2 += 2 * this.o;
            i = Math.max(this.k, Math.min(this.m, i2));
            i2 = Math.max(this.l, Math.min(this.n, i2));
            int min = Math.min(i, i2) + 1;
            c(min, min);
            a();
            setMeasuredDimension(resolveSize(i + (getPaddingLeft() + getPaddingRight()), MeasureSpec.makeMeasureSpec(10000, Integer.MIN_VALUE)), resolveSize(i2 + (getPaddingTop() + getPaddingBottom()), MeasureSpec.makeMeasureSpec(10000, Integer.MIN_VALUE)));
            return;
        }
        i = this.a;
        if (i != 0) {
            i2 = i.getIntrinsicWidth();
            i = i.getIntrinsicHeight();
            if (i2 > i) {
                i2 = i;
            }
        }
        i = Math.max(this.k, Math.min(this.m, i2));
        i2 = Math.max(this.l, Math.min(this.n, i2));
        min = Math.min(i, i2) + 1;
        c(min, min);
        a();
        setMeasuredDimension((i + (getPaddingLeft() + getPaddingRight())) & ViewCompat.MEASURED_SIZE_MASK, (i2 + (getPaddingTop() + getPaddingBottom())) & ViewCompat.MEASURED_SIZE_MASK);
    }
}
