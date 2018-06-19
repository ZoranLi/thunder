package com.xunlei.downloadprovider.personal.lixianspace.expansion.columnview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.util.LinkedList;
import java.util.List;

public class ColumnChartView extends View {
    public a a;
    public List<a> b;
    private int c;
    private int d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private float k;
    private float l;
    private Drawable m;
    private BitmapShader n;
    private boolean o;
    private boolean p;

    private static class a {
        public float a;
        String b;
        float c;
        float d;
        float e;
        float f;
        int g;
        int h;
        int i;
        int j;
        float k;
        float l;
        float m;
        float n;
        float o;
        int p;
        int q;
        float r;
        float s;
        int t;
        int u;
        int v;

        private a() {
        }
    }

    public ColumnChartView(Context context) {
        super(context);
        this.b = new LinkedList();
        b();
        a();
    }

    public ColumnChartView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnChartView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new LinkedList();
        b();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnChartView, i, 0);
        if (context != null) {
            this.a.c = (float) context.getDimensionPixelSize(1, 100);
            this.a.d = (float) context.getDimensionPixelSize(2, 100);
            this.a.e = (float) context.getDimensionPixelSize(5, 30);
            this.a.f = (float) context.getDimensionPixelSize(0, 50);
            this.a.g = context.getColor(3, getResources().getColor(R.color.colorColumNormal));
            this.a.h = context.getColor(4, getResources().getColor(R.color.colorColumSelect));
            this.a.i = context.getInteger(6, 10);
            this.a.j = context.getColor(7, getResources().getColor(R.color.colorColumSplitLine));
            this.a.k = (float) context.getDimensionPixelSize(8, 50);
            this.o = context.getBoolean(9, false);
        }
        a();
    }

    public void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        int i2 = 0;
        for (i = 0; i < this.a.i; i++) {
            float f = (float) this.c;
            float f2 = (float) i;
            float f3 = (this.l * f2) + this.a.c;
            if (i == 0) {
                f3 += this.a.l;
            } else if (i == this.a.i - 1) {
                f3 -= this.a.l;
            }
            float f4 = f3;
            canvas.drawLine(0.0f, f4, f, (f2 * this.l) + this.a.c, this.e);
        }
        i = this.b.size();
        if (i > 0) {
            f2 = ((float) this.d) - this.a.d;
            int i3 = i - 1;
            f3 = (((float) this.c) - ((2.0f * this.a.f) + (this.a.e * ((float) i)))) / ((float) i3);
            f4 = (f2 - this.a.c) / this.a.a;
            while (i2 < i) {
                this.h.setColor(this.a.g);
                this.f.setColor(this.a.p);
                this.g.setColor(this.a.t);
                a aVar = (a) this.b.get(i2);
                RectF rectF = new RectF();
                rectF.left = this.a.f + (((float) i2) * (this.a.e + f3));
                rectF.top = f2 - (aVar.a * f4);
                rectF.right = rectF.left + this.a.e;
                rectF.bottom = f2;
                if (aVar.b) {
                    this.h.setColor(this.a.h);
                }
                canvas.drawRect(rectF, this.h);
                if (!TextUtils.isEmpty(aVar.d)) {
                    if (aVar.b) {
                        this.f.setColor(this.a.q);
                    }
                    float measureText = this.f.measureText(aVar.d);
                    float f5 = this.f.getFontMetrics().descent;
                    float f6 = this.f.getFontMetrics().ascent;
                    float f7 = rectF.left - ((measureText - this.a.e) * PayBaseConstants.HALF_OF_FLOAT);
                    measureText = rectF.top - (f5 + this.a.n);
                    canvas.drawText(aVar.d, f7, measureText, this.f);
                    if (aVar.b) {
                        f5 = rectF.left + (this.a.e * PayBaseConstants.HALF_OF_FLOAT);
                        measureText = ((measureText + f6) - this.a.n) - (this.a.k * PayBaseConstants.HALF_OF_FLOAT);
                        canvas.drawCircle(f5, measureText, (this.a.k * PayBaseConstants.HALF_OF_FLOAT) + this.a.m, this.i);
                        canvas.save();
                        canvas.translate(f5 - (this.a.k * PayBaseConstants.HALF_OF_FLOAT), measureText - (this.a.k * PayBaseConstants.HALF_OF_FLOAT));
                        canvas.drawCircle(this.a.k * PayBaseConstants.HALF_OF_FLOAT, this.a.k * PayBaseConstants.HALF_OF_FLOAT, this.a.k * PayBaseConstants.HALF_OF_FLOAT, this.j);
                        canvas.restore();
                    }
                }
                if (!TextUtils.isEmpty(aVar.c)) {
                    if (i2 == i3) {
                        this.g.setColor(this.a.u);
                    }
                    canvas.drawText(aVar.c, rectF.left - ((this.g.measureText(aVar.c) - this.a.e) * PayBaseConstants.HALF_OF_FLOAT), (rectF.bottom + this.a.r) - this.g.getFontMetrics().ascent, this.g);
                }
                i2++;
            }
        }
        if (this.o) {
            Paint paint = new Paint();
            paint.setColor(this.a.j);
            paint.setStrokeWidth(this.a.l);
            Paint paint2 = paint;
            canvas.drawLine(0.0f, 0.0f, (float) this.c, 0.0f, paint2);
            canvas.drawLine(0.0f, (float) this.d, (float) this.c, (float) this.d, paint2);
            canvas.drawLine(0.0f, 0.0f, 0.0f, (float) this.d, paint2);
            canvas.drawLine((float) this.c, 0.0f, (float) this.c, (float) this.d, paint2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.c = i;
        this.d = i2;
        if (this.a != 0 && this.c > 0 && this.d > 0) {
            this.k = ((float) this.d) - (this.a.c + this.a.d);
            this.l = this.k / ((float) (this.a.i - 1));
        }
    }

    private void a() {
        if (!this.p) {
            this.p = true;
            this.e = new Paint();
            this.e.setAntiAlias(true);
            this.e.setStyle(Style.FILL);
            this.e.setColor(this.a.j);
            this.e.setStrokeWidth(this.a.l);
            this.h = new Paint();
            this.h.setAntiAlias(true);
            this.h.setColor(this.a.g);
            this.f = new Paint();
            this.f.setAntiAlias(true);
            this.f.setColor(this.a.p);
            this.f.setTextSize(this.a.o);
            this.g = new Paint();
            this.g.setAntiAlias(true);
            this.g.setColor(this.a.t);
            this.g.setTextSize(this.a.s);
            this.i = new Paint();
            this.i.setAntiAlias(true);
            this.i.setColor(this.a.q);
            this.i.setStyle(Style.STROKE);
            this.i.setStrokeWidth(this.a.m);
            this.j = new Paint();
            this.j.setAntiAlias(true);
            c();
        }
    }

    private void b() {
        if (this.a == null) {
            this.a = new a();
            this.a.l = 2.0f;
            this.a.m = 2.0f;
            this.a.n = (float) a(3.0f);
            this.a.o = (float) d();
            this.a.p = getResources().getColor(R.color.colorColumTopTextColor);
            this.a.q = getResources().getColor(R.color.colorColumTopSelectTextColor);
            this.a.r = (float) a(5.0f);
            this.a.s = (float) d();
            this.a.t = getResources().getColor(R.color.colorColumBottomTextColor);
            this.a.u = getResources().getColor(R.color.colorColumLastBottomTextColor);
            this.a.a = 500.0f;
        }
    }

    private void c() {
        Bitmap a = a(this.m);
        if (a == null) {
            Drawable createFromPath = Drawable.createFromPath(this.a.b);
            if (createFromPath != null) {
                int intrinsicWidth = createFromPath.getIntrinsicWidth();
                int intrinsicHeight = createFromPath.getIntrinsicHeight();
                Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                createFromPath.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                createFromPath.draw(canvas);
                a = createBitmap;
            } else {
                a = null;
            }
            if (a == null && this.a.v > 0) {
                a = a(getResources().getDrawable(this.a.v));
            }
        }
        if (a != null) {
            this.n = null;
            this.n = new BitmapShader(a, TileMode.CLAMP, TileMode.CLAMP);
            float min = this.a.k / ((float) Math.min(a.getHeight(), a.getWidth()));
            Matrix matrix = new Matrix();
            matrix.setScale(min, min);
            this.n.setLocalMatrix(matrix);
            this.j.setShader(this.n);
        }
    }

    private static Bitmap a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    @SuppressLint({"DefaultLocale"})
    private int a(float f) {
        return (int) ((f * getContext().getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    private int d() {
        return (int) ((9.0f * getContext().getResources().getDisplayMetrics().scaledDensity) + PayBaseConstants.HALF_OF_FLOAT);
    }

    public void setColumnSelectIcon(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a.b = str;
        }
    }

    public void setColumnSelectIcon(int i) {
        if (i > 0) {
            this.a.b = null;
            this.a.v = i;
            c();
        }
    }

    public void setColumnSelectIcon(Drawable drawable) {
        if (drawable != null) {
            this.a.b = null;
            this.a.v = 0;
            this.m = drawable;
            c();
            invalidate();
        }
    }
}
