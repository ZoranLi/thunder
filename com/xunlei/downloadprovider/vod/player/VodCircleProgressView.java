package com.xunlei.downloadprovider.vod.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class VodCircleProgressView extends View {
    private int a;
    private int b;
    private int c;
    private Paint d;
    private Bitmap e;
    private RectF f;
    private float g;
    private int h;
    private int i;
    private int j;
    private RectF k;
    private float l;
    private float m;
    private Rect n;

    public VodCircleProgressView(Context context) {
        super(context);
        a(context);
    }

    public VodCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public VodCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setBackgroundColor(0);
        this.a = a(context, 12.0f);
        int a = a(context, 18.7f);
        this.c = a;
        this.b = a;
        this.h = a(context, 1.2f);
        this.g = (((float) Math.min(this.b, this.c)) / 2.0f) - (((float) this.h) / 2.0f);
        this.i = Color.parseColor("#FFEB7849");
        this.j = -1;
        this.e = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_download_accelerate_circle);
        this.f = new RectF();
        context = (((float) (this.b - this.a)) / 1073741824) + (((float) this.h) / 2.0f);
        float f = (((float) (this.c - this.a)) / 2.0f) + (((float) this.h) / 2.0f);
        this.f.set(context, f, ((float) this.a) + context, ((float) this.a) + f);
        this.n = new Rect();
        context = (((float) this.e.getWidth()) * 1052549552) / 1073741824;
        f = (((float) this.e.getHeight()) * 0.36842108f) / 2.0f;
        this.n.set((int) context, (int) f, (int) (((float) this.e.getWidth()) - context), (int) (((float) this.e.getHeight()) - f));
        this.k = new RectF();
        f = (((float) this.c) / 2.0f) - this.g;
        this.k.set((((float) this.b) / 1073741824) - this.g, f, (((float) this.b) / 2.0f) + this.g, (((float) this.c) / 2.0f) + this.g);
        this.l = -90.0f;
        this.m = 100.0f;
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setStyle(Style.STROKE);
        this.d.setStrokeWidth((float) this.h);
    }

    private static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + PayBaseConstants.HALF_OF_FLOAT);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.b, this.c);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.e, this.n, this.f, this.d);
        this.d.setColor(this.i);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.k, 0.0f, 360.0f, false, this.d);
        this.d.setColor(this.j);
        canvas2.drawArc(this.k, this.l, this.m, false, this.d);
    }

    public void setProgress(float f) {
        this.m = 360.0f * ((f * 1.0f) / 100.0f);
        postInvalidate();
    }
}
