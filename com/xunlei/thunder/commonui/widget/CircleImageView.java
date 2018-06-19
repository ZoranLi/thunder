package com.xunlei.thunder.commonui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView.ScaleType;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.thunder.commonui.R;

public class CircleImageView extends RecycleImageView {
    private static final ScaleType a = ScaleType.CENTER_CROP;
    private static final Config b = Config.ARGB_8888;
    private static final int c = Color.parseColor("#88d1d1d1");
    private final RectF d;
    private final RectF e;
    private final Matrix f;
    private final Paint g;
    private final Paint h;
    private int i;
    private int j;
    private Bitmap k;
    private BitmapShader l;
    private int m;
    private int n;
    private float o;
    private float p;
    private boolean q;
    private boolean r;

    public CircleImageView(Context context) {
        super(context);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Matrix();
        this.g = new Paint();
        this.h = new Paint();
        this.i = c;
        this.j = 1;
        this.q = true;
        if (this.r != null) {
            a();
            this.r = null;
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        this.q = true;
        if (this.r != null) {
            a();
            this.r = false;
        }
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new RectF();
        this.e = new RectF();
        this.f = new Matrix();
        this.g = new Paint();
        this.h = new Paint();
        this.i = c;
        this.j = 1;
        super.setScaleType(a);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.CircleImageView, i, 0);
        this.j = context.getDimensionPixelSize(R.styleable.CircleImageView_border_width, 1);
        this.i = context.getColor(R.styleable.CircleImageView_border_color, c);
        context.recycle();
        this.q = true;
        if (this.r != null) {
            a();
            this.r = false;
        }
    }

    public ScaleType getScaleType() {
        return a;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    protected void onDraw(android.graphics.Canvas r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.getDrawable();	 Catch:{ Throwable -> 0x0036 }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Throwable -> 0x0036 }
    L_0x0006:
        return;	 Catch:{ Throwable -> 0x0036 }
    L_0x0007:
        r0 = r4.getWidth();	 Catch:{ Throwable -> 0x0036 }
        r0 = r0 / 2;	 Catch:{ Throwable -> 0x0036 }
        r0 = (float) r0;	 Catch:{ Throwable -> 0x0036 }
        r1 = r4.getHeight();	 Catch:{ Throwable -> 0x0036 }
        r1 = r1 / 2;	 Catch:{ Throwable -> 0x0036 }
        r1 = (float) r1;	 Catch:{ Throwable -> 0x0036 }
        r2 = r4.o;	 Catch:{ Throwable -> 0x0036 }
        r3 = r4.g;	 Catch:{ Throwable -> 0x0036 }
        r5.drawCircle(r0, r1, r2, r3);	 Catch:{ Throwable -> 0x0036 }
        r0 = r4.j;	 Catch:{ Throwable -> 0x0036 }
        if (r0 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x0036 }
    L_0x0020:
        r0 = r4.getWidth();	 Catch:{ Throwable -> 0x0036 }
        r0 = r0 / 2;	 Catch:{ Throwable -> 0x0036 }
        r0 = (float) r0;	 Catch:{ Throwable -> 0x0036 }
        r1 = r4.getHeight();	 Catch:{ Throwable -> 0x0036 }
        r1 = r1 / 2;	 Catch:{ Throwable -> 0x0036 }
        r1 = (float) r1;	 Catch:{ Throwable -> 0x0036 }
        r2 = r4.p;	 Catch:{ Throwable -> 0x0036 }
        r3 = r4.h;	 Catch:{ Throwable -> 0x0036 }
        r5.drawCircle(r0, r1, r2, r3);	 Catch:{ Throwable -> 0x0036 }
    L_0x0035:
        return;
    L_0x0036:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.thunder.commonui.widget.CircleImageView.onDraw(android.graphics.Canvas):void");
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        a();
    }

    public int getBorderColor() {
        return this.i;
    }

    public void setBorderColor(int i) {
        if (i != this.i) {
            this.i = i;
            this.h.setColor(this.i);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.j;
    }

    public void setBorderWidth(int i) {
        if (i != this.j) {
            this.j = i;
            a();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.k = bitmap;
        a();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.k = a(drawable);
        a();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.k = a(getDrawable());
        a();
    }

    private static android.graphics.Bitmap a(android.graphics.drawable.Drawable r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r6 instanceof android.graphics.drawable.BitmapDrawable;
        if (r1 == 0) goto L_0x000f;
    L_0x0008:
        r6 = (android.graphics.drawable.BitmapDrawable) r6;
        r6 = r6.getBitmap();
        return r6;
    L_0x000f:
        r1 = r6 instanceof android.graphics.drawable.TransitionDrawable;
        r2 = 1;
        if (r1 == 0) goto L_0x0027;
    L_0x0014:
        r1 = r6;	 Catch:{ Exception -> 0x0027 }
        r1 = (android.graphics.drawable.TransitionDrawable) r1;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getDrawable(r2);	 Catch:{ Exception -> 0x0027 }
        r3 = r1 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ Exception -> 0x0027 }
        if (r3 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x0027 }
    L_0x001f:
        r1 = (android.graphics.drawable.BitmapDrawable) r1;	 Catch:{ Exception -> 0x0027 }
        r1 = r1.getBitmap();	 Catch:{ Exception -> 0x0027 }
        return r1;
    L_0x0026:
        r6 = r1;
    L_0x0027:
        r1 = r6 instanceof android.graphics.drawable.ColorDrawable;	 Catch:{ OutOfMemoryError -> 0x005e }
        if (r1 == 0) goto L_0x002d;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x002b:
        r1 = r2;	 Catch:{ OutOfMemoryError -> 0x005e }
        goto L_0x0043;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x002d:
        r1 = r6.getIntrinsicWidth();	 Catch:{ OutOfMemoryError -> 0x005e }
        if (r1 <= 0) goto L_0x0038;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x0033:
        r1 = r6.getIntrinsicWidth();	 Catch:{ OutOfMemoryError -> 0x005e }
        goto L_0x0039;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x0038:
        r1 = r2;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x0039:
        r3 = r6.getIntrinsicHeight();	 Catch:{ OutOfMemoryError -> 0x005e }
        if (r3 <= 0) goto L_0x0043;	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x003f:
        r2 = r6.getIntrinsicHeight();	 Catch:{ OutOfMemoryError -> 0x005e }
    L_0x0043:
        r3 = b;	 Catch:{ OutOfMemoryError -> 0x005e }
        r1 = android.graphics.Bitmap.createBitmap(r1, r2, r3);	 Catch:{ OutOfMemoryError -> 0x005e }
        r2 = new android.graphics.Canvas;	 Catch:{ OutOfMemoryError -> 0x005e }
        r2.<init>(r1);	 Catch:{ OutOfMemoryError -> 0x005e }
        r3 = r2.getWidth();	 Catch:{ OutOfMemoryError -> 0x005e }
        r4 = r2.getHeight();	 Catch:{ OutOfMemoryError -> 0x005e }
        r5 = 0;	 Catch:{ OutOfMemoryError -> 0x005e }
        r6.setBounds(r5, r5, r3, r4);	 Catch:{ OutOfMemoryError -> 0x005e }
        r6.draw(r2);	 Catch:{ OutOfMemoryError -> 0x005e }
        return r1;
    L_0x005e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.thunder.commonui.widget.CircleImageView.a(android.graphics.drawable.Drawable):android.graphics.Bitmap");
    }

    private void a() {
        if (!this.q) {
            this.r = true;
        } else if (this.k != null) {
            float height;
            float width;
            this.l = new BitmapShader(this.k, TileMode.CLAMP, TileMode.CLAMP);
            this.g.setAntiAlias(true);
            this.g.setShader(this.l);
            this.h.setStyle(Style.STROKE);
            this.h.setAntiAlias(true);
            this.h.setColor(this.i);
            this.h.setStrokeWidth((float) this.j);
            this.n = this.k.getHeight();
            this.m = this.k.getWidth();
            float f = 0.0f;
            this.e.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.p = Math.min((this.e.height() - ((float) this.j)) / 2.0f, (this.e.width() - ((float) this.j)) / 2.0f);
            this.d.set((float) this.j, (float) this.j, this.e.width() - ((float) this.j), this.e.height() - ((float) this.j));
            this.o = Math.min(this.d.height() / 2.0f, this.d.width() / 2.0f);
            this.f.set(null);
            if (((float) this.m) * this.d.height() > this.d.width() * ((float) this.n)) {
                height = this.d.height() / ((float) this.n);
                width = (this.d.width() - (((float) this.m) * height)) * PayBaseConstants.HALF_OF_FLOAT;
            } else {
                height = this.d.width() / ((float) this.m);
                f = (this.d.height() - (((float) this.n) * height)) * PayBaseConstants.HALF_OF_FLOAT;
                width = 0.0f;
            }
            this.f.setScale(height, height);
            this.f.postTranslate((float) (((int) (width + PayBaseConstants.HALF_OF_FLOAT)) + this.j), (float) (((int) (f + PayBaseConstants.HALF_OF_FLOAT)) + this.j));
            this.l.setLocalMatrix(this.f);
            invalidate();
        }
    }
}
