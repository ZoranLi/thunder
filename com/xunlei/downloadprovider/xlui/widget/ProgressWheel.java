package com.xunlei.downloadprovider.xlui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.xunlei.downloadprovider.R;

public class ProgressWheel extends View {
    private RectF A = new RectF();
    private RectF B = new RectF();
    private float C = 2.0f;
    private int D = 10;
    private float E = 0.0f;
    private String F = "";
    private String[] G = new String[0];
    boolean a = false;
    private int b = 0;
    private int c = 0;
    private int d = 100;
    private int e = 80;
    private int f = 60;
    private int g = 20;
    private int h = 20;
    private int i = 20;
    private float j = 0.0f;
    private int k = 5;
    private int l = 5;
    private int m = 5;
    private int n = 5;
    private int o = -1442840576;
    private int p = -1442840576;
    private int q = 0;
    private int r = -1428300323;
    private int s = -16777216;
    private Paint t = new Paint();
    private Paint u = new Paint();
    private Paint v = new Paint();
    private Paint w = new Paint();
    private Paint x = new Paint();
    private RectF y = new RectF();
    private RectF z = new RectF();

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel);
        this.g = (int) context.getDimension(10, (float) this.g);
        this.h = (int) context.getDimension(5, (float) this.h);
        this.C = (float) ((int) context.getDimension(6, this.C));
        this.f = (int) context.getDimension(11, (float) this.f);
        this.D = context.getInteger(7, this.D);
        if (this.D < null) {
            this.D = 10;
        }
        if (context.hasValue(0) != null) {
            setText(context.getString(0));
        }
        this.o = context.getColor(3, this.o);
        this.s = context.getColor(1, this.s);
        this.r = context.getColor(4, this.r);
        this.q = context.getColor(8, this.q);
        this.p = context.getColor(12, this.p);
        this.i = (int) context.getDimension(2, (float) this.i);
        this.j = context.getDimension(13, this.j);
        context.recycle();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        measuredWidth = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        i2 = MeasureSpec.getMode(i2);
        i = MeasureSpec.getMode(i);
        if (i2 == 0 || i == 0) {
            measuredWidth = Math.max(measuredHeight, measuredWidth);
        } else if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        }
        setMeasuredDimension((getPaddingLeft() + measuredWidth) + getPaddingRight(), (measuredWidth + getPaddingTop()) + getPaddingBottom());
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i;
        this.b = i2;
        i = Math.min(this.c, this.b);
        i2 = this.c - i;
        i3 = (this.b - i) / 2;
        this.k = getPaddingTop() + i3;
        this.l = getPaddingBottom() + i3;
        i2 /= 2;
        this.m = getPaddingLeft() + i2;
        this.n = getPaddingRight() + i2;
        i = getWidth();
        i2 = getHeight();
        this.y = new RectF(((float) this.m) + (((float) this.g) * 1.5f), ((float) this.k) + (((float) this.g) * 1.5f), ((float) (i - this.n)) - (((float) this.g) * 1.5f), ((float) (i2 - this.l)) - (1.5f * ((float) this.g)));
        this.z = new RectF((float) (this.m + this.g), (float) (this.k + this.g), (float) ((i - this.n) - this.g), (float) ((i2 - this.l) - this.g));
        this.B = new RectF((this.z.left + (((float) this.h) / 1073741824)) + (this.j / 1073741824), (this.z.top + (((float) this.h) / 2.0f)) + (this.j / 2.0f), (this.z.right - (((float) this.h) / 2.0f)) - (this.j / 2.0f), (this.z.bottom - (((float) this.h) / 2.0f)) - (this.j / 2.0f));
        this.A = new RectF((this.z.left - (((float) this.h) / 1073741824)) - (this.j / 1073741824), (this.z.top - (((float) this.h) / 2.0f)) - (this.j / 2.0f), (this.z.right + (((float) this.h) / 2.0f)) + (this.j / 2.0f), (this.z.bottom + (((float) this.h) / 2.0f)) + (this.j / 2.0f));
        this.d = ((i - this.n) - this.g) / 2;
        this.e = (this.d - this.g) + 1;
        this.t.setColor(this.o);
        this.t.setAntiAlias(true);
        this.t.setStyle(Style.STROKE);
        this.t.setStrokeWidth((float) this.g);
        this.v.setColor(this.r);
        this.v.setAntiAlias(true);
        this.v.setStyle(Style.STROKE);
        this.v.setStrokeWidth((float) this.h);
        this.u.setColor(this.q);
        this.u.setAntiAlias(true);
        this.u.setStyle(Style.FILL);
        this.w.setColor(this.s);
        this.w.setStyle(Style.FILL);
        this.w.setAntiAlias(true);
        this.w.setTextSize((float) this.i);
        this.x.setColor(this.p);
        this.x.setAntiAlias(true);
        this.x.setStyle(Style.STROKE);
        this.x.setStrokeWidth(this.j);
        invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.y, 360.0f, 360.0f, false, this.u);
        canvas.drawArc(this.z, 360.0f, 360.0f, false, this.v);
        canvas2.drawArc(this.A, 360.0f, 360.0f, false, this.x);
        if (this.a) {
            canvas.drawArc(this.z, this.E - 90.0f, (float) this.f, false, this.t);
        } else {
            canvas.drawArc(this.z, -90.0f, this.E, false, this.t);
        }
        float descent = ((this.w.descent() - this.w.ascent()) / 2.0f) - this.w.descent();
        for (String str : this.G) {
            canvas.drawText(str, ((float) (getWidth() / 2)) - (this.w.measureText(str) / 2.0f), ((float) (getHeight() / 2)) + descent, this.w);
        }
        if (this.a != null) {
            this.E += this.C;
            if (this.E > 360.0f) {
                this.E = null;
            }
            postInvalidateDelayed((long) this.D);
        }
    }

    public void setProgress(int i) {
        this.a = false;
        this.E = (float) i;
        postInvalidate();
    }

    public void setText(String str) {
        this.F = str;
        this.G = this.F.split("\n");
    }

    public int getCircleRadius() {
        return this.e;
    }

    public void setCircleRadius(int i) {
        this.e = i;
    }

    public int getBarLength() {
        return this.f;
    }

    public void setBarLength(int i) {
        this.f = i;
    }

    public int getBarWidth() {
        return this.g;
    }

    public void setBarWidth(int i) {
        this.g = i;
        if (this.t != 0) {
            this.t.setStrokeWidth((float) this.g);
        }
    }

    public int getTextSize() {
        return this.i;
    }

    public void setTextSize(int i) {
        this.i = i;
        if (this.w != 0) {
            this.w.setTextSize((float) this.i);
        }
    }

    public int getPaddingTop() {
        return this.k;
    }

    public void setPaddingTop(int i) {
        this.k = i;
    }

    public int getPaddingBottom() {
        return this.l;
    }

    public void setPaddingBottom(int i) {
        this.l = i;
    }

    public int getPaddingLeft() {
        return this.m;
    }

    public void setPaddingLeft(int i) {
        this.m = i;
    }

    public int getPaddingRight() {
        return this.n;
    }

    public void setPaddingRight(int i) {
        this.n = i;
    }

    public int getBarColor() {
        return this.o;
    }

    public void setBarColor(int i) {
        this.o = i;
        if (this.t != 0) {
            this.t.setColor(this.o);
        }
    }

    public int getCircleColor() {
        return this.q;
    }

    public void setCircleColor(int i) {
        this.q = i;
        if (this.u != 0) {
            this.u.setColor(this.q);
        }
    }

    public int getRimColor() {
        return this.r;
    }

    public void setRimColor(int i) {
        this.r = i;
        if (this.v != 0) {
            this.v.setColor(this.r);
        }
    }

    public Shader getRimShader() {
        return this.v.getShader();
    }

    public void setRimShader(Shader shader) {
        this.v.setShader(shader);
    }

    public int getTextColor() {
        return this.s;
    }

    public void setTextColor(int i) {
        this.s = i;
        if (this.w != 0) {
            this.w.setColor(this.s);
        }
    }

    public float getSpinSpeed() {
        return this.C;
    }

    public void setSpinSpeed(float f) {
        this.C = f;
    }

    public int getRimWidth() {
        return this.h;
    }

    public void setRimWidth(int i) {
        this.h = i;
        if (this.v != 0) {
            this.v.setStrokeWidth((float) this.h);
        }
    }

    public int getDelayMillis() {
        return this.D;
    }

    public void setDelayMillis(int i) {
        this.D = i;
    }

    public int getContourColor() {
        return this.p;
    }

    public void setContourColor(int i) {
        this.p = i;
        if (this.x != 0) {
            this.x.setColor(this.p);
        }
    }

    public float getContourSize() {
        return this.j;
    }

    public void setContourSize(float f) {
        this.j = f;
        if (this.x != null) {
            this.x.setStrokeWidth(this.j);
        }
    }

    public int getProgress() {
        return (int) this.E;
    }
}
