package com.xunlei.tdlive.control;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.tdlive.sdk.R;

@SuppressLint({"AppCompatCustomView"})
public class RoundImageView extends ImageView {
    public static final int CORNER_ALL = 15;
    public static final int CORNER_BOTTOM = 12;
    public static final int CORNER_BOTTOM_LEFT = 4;
    public static final int CORNER_BOTTOM_RIGHT = 8;
    public static final int CORNER_LEFT = 5;
    public static final int CORNER_RIGHT = 10;
    public static final int CORNER_TOP = 3;
    public static final int CORNER_TOP_LEFT = 1;
    public static final int CORNER_TOP_RIGHT = 2;
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_ROUND = 1;
    private int a;
    private int b;
    private Paint c;
    private Paint d;
    private Matrix e;
    private BitmapShader f;
    private Drawable g;
    private Bitmap h;
    private int i;
    private RectF j;
    private int k;
    private int l;
    private int m;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new Matrix();
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.d = new Paint();
        this.d.setAntiAlias(true);
        if (attributeSet != null) {
            context = context.obtainStyledAttributes(attributeSet, R.styleable.RoundImageView);
            this.b = context.getDimensionPixelSize(R.styleable.RoundImageView_borderRadius, (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
            this.a = context.getInt(R.styleable.RoundImageView_type, 0);
            this.k = context.getDimensionPixelSize(R.styleable.RoundImageView_borderLineWidth, (int) TypedValue.applyDimension(1, 0.0f, getResources().getDisplayMetrics()));
            this.l = context.getColor(R.styleable.RoundImageView_borderLineColor, 0);
            context.recycle();
        }
        this.m = 15;
    }

    public void setBorderRadius(int i) {
        setBorderRadius(i, 15);
    }

    public void setBorderRadius(int i, int i2) {
        this.m = i2;
        i = dp2px(i);
        if (this.b != i) {
            this.b = i;
            invalidate();
        }
    }

    public void setType(int i) {
        if (this.a != i) {
            this.a = i;
            if (!(this.a == 1 || this.a == 0)) {
                this.a = 0;
            }
            requestLayout();
        }
    }

    public int dp2px(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    protected void onDraw(Canvas canvas) {
        if (getDrawable() != null) {
            float f = ((float) this.i) / 2.0f;
            a();
            if (this.a == 1) {
                if (this.j == null) {
                    this.j = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
                }
                canvas.drawRoundRect(this.j, (float) this.b, (float) this.b, this.c);
                int i = this.m ^ 15;
                if ((i & 1) != 0) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.b, (float) this.b, this.c);
                }
                if ((i & 2) != 0) {
                    canvas.drawRect(this.j.right - ((float) this.b), 0.0f, this.j.right, (float) this.b, this.c);
                }
                if ((i & 4) != 0) {
                    canvas.drawRect(0.0f, this.j.bottom - ((float) this.b), (float) this.b, this.j.bottom, this.c);
                }
                if ((i & 8) != 0) {
                    canvas.drawRect(this.j.right - ((float) this.b), this.j.bottom - ((float) this.b), this.j.right, this.j.bottom, this.c);
                }
                return;
            }
            canvas.drawCircle(f, f, f - ((float) this.k), this.c);
            if (this.k > 0) {
                this.d.setStyle(Style.STROKE);
                this.d.setColor(this.l);
                this.d.setStrokeWidth((float) this.k);
                canvas.drawCircle(f, f, f - PayBaseConstants.HALF_OF_FLOAT, this.d);
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.j = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.a == 0) {
            this.i = Math.min(getMeasuredWidth(), getMeasuredHeight());
            setMeasuredDimension(this.i, this.i);
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.g) {
            this.g = null;
        }
        super.invalidateDrawable(drawable);
    }

    private void a() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap a = a(drawable);
            if (a != null) {
                this.f = new BitmapShader(a, TileMode.CLAMP, TileMode.CLAMP);
                float f = 1.0f;
                if (this.a == 0) {
                    f = (((float) this.i) * 1.0f) / ((float) Math.min(a.getWidth(), a.getHeight()));
                } else if (this.a == 1) {
                    f = Math.max((((float) getWidth()) * 1.0f) / ((float) a.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a.getHeight()));
                }
                this.e.setScale(f, f);
                this.f.setLocalMatrix(this.e);
                this.c.setShader(this.f);
            }
        }
    }

    private android.graphics.Bitmap a(android.graphics.drawable.Drawable r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r5 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ Throwable -> 0x003f }
        if (r0 == 0) goto L_0x000b;	 Catch:{ Throwable -> 0x003f }
    L_0x0004:
        r5 = (android.graphics.drawable.BitmapDrawable) r5;	 Catch:{ Throwable -> 0x003f }
        r5 = r5.getBitmap();	 Catch:{ Throwable -> 0x003f }
        return r5;	 Catch:{ Throwable -> 0x003f }
    L_0x000b:
        r0 = r4.g;	 Catch:{ Throwable -> 0x003f }
        r0 = r5.equals(r0);	 Catch:{ Throwable -> 0x003f }
        if (r0 != 0) goto L_0x003f;	 Catch:{ Throwable -> 0x003f }
    L_0x0013:
        r4.g = r5;	 Catch:{ Throwable -> 0x003f }
        r0 = r4.h;	 Catch:{ Throwable -> 0x003f }
        if (r0 == 0) goto L_0x0021;	 Catch:{ Throwable -> 0x003f }
    L_0x0019:
        r0 = r4.h;	 Catch:{ Throwable -> 0x003f }
        r0.recycle();	 Catch:{ Throwable -> 0x003f }
        r0 = 0;	 Catch:{ Throwable -> 0x003f }
        r4.h = r0;	 Catch:{ Throwable -> 0x003f }
    L_0x0021:
        r0 = r5.getIntrinsicWidth();	 Catch:{ Throwable -> 0x003f }
        r1 = r5.getIntrinsicHeight();	 Catch:{ Throwable -> 0x003f }
        r2 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Throwable -> 0x003f }
        r2 = android.graphics.Bitmap.createBitmap(r0, r1, r2);	 Catch:{ Throwable -> 0x003f }
        r4.h = r2;	 Catch:{ Throwable -> 0x003f }
        r2 = new android.graphics.Canvas;	 Catch:{ Throwable -> 0x003f }
        r3 = r4.h;	 Catch:{ Throwable -> 0x003f }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x003f }
        r3 = 0;	 Catch:{ Throwable -> 0x003f }
        r5.setBounds(r3, r3, r0, r1);	 Catch:{ Throwable -> 0x003f }
        r5.draw(r2);	 Catch:{ Throwable -> 0x003f }
    L_0x003f:
        r5 = r4.h;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.control.RoundImageView.a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }
}
