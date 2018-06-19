package com.xunlei.downloadprovider.personal.settings.ui;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import com.xunlei.downloadprovider.R;

public class ChartView extends FrameLayout {
    private static final String d = "ChartView";
    private int A;
    private int B;
    private a C;
    public ValueAnimator a;
    public ValueAnimator b;
    public float c;
    private Context e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j = 270.0f;
    private float k;
    private RectF l;
    private Paint m;
    private Paint n;
    private Paint o;
    private Paint p;
    private Paint q;
    private Paint r;
    private Bitmap s;
    private Bitmap t;
    private float u;
    private float v;
    private float w;
    private boolean x = true;
    private int y;
    private float z;

    public interface a {
        void a(float f, int i);
    }

    public ChartView(Context context) {
        super(context);
        this.e = context;
        a(context);
    }

    public ChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = context;
        a(context);
    }

    public ChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = context;
        a(context);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(this.s.getHeight(), 1073741824));
        this.f = ((float) (getMeasuredWidth() / 2)) - this.k;
        this.g = ((float) (this.s.getHeight() / 2)) - this.k;
        this.h = ((float) (getMeasuredWidth() / 2)) + this.k;
        this.i = ((float) (this.s.getHeight() / 2)) + this.k;
        this.l = new RectF(this.f, this.g, this.h, this.i);
        this.A = getMeasuredWidth();
        this.B = getMeasuredHeight();
    }

    protected void onDraw(Canvas canvas) {
        if (this.x) {
            float width = (float) this.t.getWidth();
            float height = (float) this.t.getHeight();
            float width2 = (float) this.s.getWidth();
            float height2 = (float) this.s.getHeight();
            if (this.C != null) {
                this.C.a(this.z, this.B);
            }
            float f = width / 2.0f;
            float f2 = height2 / 2.0f;
            float f3 = f2 - (height / 2.0f);
            canvas.clipRect(((float) (getMeasuredWidth() / 2)) - f, f3, (((float) (getMeasuredWidth() / 2)) - f) + width, height + f3);
            canvas.save();
            this.u += 4.0f;
            canvas.rotate(this.u, (float) (getMeasuredWidth() / 2), f2);
            canvas.drawBitmap(this.t, ((float) (getMeasuredWidth() / 2)) - f, f3, null);
            canvas.restore();
            float f4 = width2 / 2.0f;
            canvas.clipRect(((float) (getMeasuredWidth() / 2)) - f4, 0.0f, (((float) (getMeasuredWidth() / 2)) - f4) + width2, height2, Op.UNION);
            canvas.save();
            this.v += 10.0f;
            canvas.rotate(this.u, (float) (getMeasuredWidth() / 2), f2);
            canvas.drawBitmap(this.s, ((float) (getMeasuredWidth() / 2)) - f4, 0.0f, null);
            canvas.restore();
            return;
        }
        new StringBuilder("onDraw ange=").append(this.w);
        if (this.w < this.c) {
            canvas.drawArc(this.l, this.j, this.w + 2.0f, true, this.n);
            return;
        }
        canvas.drawArc(this.l, this.j, this.c, true, this.n);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.l, this.c + this.j, this.w - this.c, true, this.m);
    }

    public void setRadius(float f) {
        this.k = f;
    }

    public void setCleanAnimateListener(a aVar) {
        this.C = aVar;
    }

    private void a(Context context) {
        this.m = new Paint();
        this.m.setAntiAlias(true);
        this.m.setStyle(Style.FILL);
        this.m.setTextSize((float) DipPixelUtil.dip2px(15.0f));
        this.m.setColor(Color.parseColor("#ebebeb"));
        this.n = new Paint();
        this.n.setAntiAlias(true);
        this.n.setStyle(Style.FILL);
        this.n.setTextSize((float) DipPixelUtil.dip2px(15.0f));
        this.n.setColor(Color.parseColor("#ffa63c"));
        this.o = new Paint();
        this.o.setAntiAlias(true);
        this.o.setStyle(Style.FILL);
        this.o.setColor(Color.parseColor("#5092E3"));
        this.p = new Paint();
        this.p.setAntiAlias(true);
        this.p.setStrokeWidth((float) DipPixelUtil.dip2px(5.0f));
        this.p.setStyle(Style.STROKE);
        this.p.setColor(Color.parseColor("#9B9B9B"));
        this.q = new Paint();
        this.q.setTextSize((float) DipPixelUtil.dip2px(15.0f));
        this.q.setColor(Color.parseColor("#9B9B9B"));
        this.r = new Paint();
        this.r.setTextSize((float) DipPixelUtil.sp2pix(14.0f));
        this.r.setColor(Color.parseColor("#999999"));
        this.r.setTextAlign(Align.CENTER);
        this.t = BitmapFactory.decodeResource(context.getResources(), R.drawable.electric_icon);
        this.s = BitmapFactory.decodeResource(context.getResources(), R.drawable.circle_rotate_icon);
        this.k = (float) (this.s.getWidth() / 2);
        if (this.a == null) {
            context = PropertyValuesHolder.ofFloat("angle", new float[]{0.0f, 360.0f});
            this.a = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{context});
            this.a.setDuration(1000);
            this.a.setInterpolator(new LinearInterpolator());
            this.a.addUpdateListener(new a(this));
        }
        if (this.b == null) {
            context = PropertyValuesHolder.ofInt(RequestHeaders.COLUMN_VALUE, new int[]{1, 100});
            this.b = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{context});
            this.b.setInterpolator(new LinearInterpolator());
            this.b.setDuration(2000);
            this.b.addUpdateListener(new b(this));
            this.b.addListener(new c(this));
            this.b.setRepeatCount(-1);
        }
    }
}
