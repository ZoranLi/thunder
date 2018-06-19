package com.xunlei.downloadprovider.download.speedup.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.alipay.sdk.util.h;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.util.ArrayList;

public class FlickerSingleProgressView extends View implements d {
    private float A;
    private float B;
    private long C;
    private Runnable D = new b(this);
    public Paint a = null;
    Bitmap b = null;
    Canvas c = null;
    boolean d;
    boolean e;
    private Paint f = null;
    private Paint g = null;
    private Paint h;
    private Matrix i;
    private float j;
    private LinearGradient k;
    private boolean l = null;
    private float m;
    private int n = 100;
    private float o;
    private int p = Color.parseColor("#1294f6");
    private float q = null;
    private int r;
    private int s;
    private int t = 1;
    private boolean u;
    private String v;
    private ArrayList<Float> w;
    private float x;
    private float y;
    private float z;

    public d getProgressControl() {
        return this;
    }

    public FlickerSingleProgressView(Context context) {
        super(context);
        h();
    }

    public FlickerSingleProgressView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        h();
    }

    public FlickerSingleProgressView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        h();
    }

    @TargetApi(21)
    public FlickerSingleProgressView(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        h();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
    }

    private boolean e() {
        return this.w.size() % 2 == 0;
    }

    private void f() {
        if (this.d && !this.u) {
            ArrayList a = c.a(this.v);
            int size = a.size();
            if (this.w.size() == size) {
                if (size > 0) {
                    size--;
                    if (((Float) this.w.get(size)).floatValue() == this.q) {
                        a.remove(size);
                    }
                }
                a.add(Float.valueOf(this.q));
            }
            this.w = a;
        }
    }

    private void g() {
        ArrayList a = c.a(this.v);
        if (a.size() != this.w.size()) {
            this.w = a;
        }
    }

    private void h() {
        boolean z = b.f() == 3;
        this.o = (float) DipPixelUtil.dip2px(1.5f);
        this.y = (float) DipPixelUtil.dip2px(3.0f);
        this.z = (float) DipPixelUtil.dip2px(2.5f);
        this.A = (float) DipPixelUtil.dip2px(2.0f);
        this.x = (float) DipPixelUtil.dip2px(4.0f);
        this.a = new Paint();
        if (z) {
            this.a.setColor(-1);
        } else {
            this.a.setColor(Color.parseColor("#efeff0"));
        }
        this.a.setStyle(Style.FILL);
        this.a.setAntiAlias(true);
        this.f = new Paint();
        this.f.setStyle(Style.FILL);
        this.f.setAntiAlias(true);
        this.g = new Paint();
        this.g.setColor(this.p);
        this.g.setStyle(Style.FILL);
        this.g.setAntiAlias(true);
        this.d = true;
        this.i = new Matrix();
        this.r = DipPixelUtil.dip2px((float) (this.t * 0));
        this.s = DipPixelUtil.dip2px((float) (2 * this.t));
        this.h = new Paint();
        this.h.setAntiAlias(true);
        if (z) {
            this.h.setColor(this.p);
        } else {
            this.h.setColor(Color.parseColor("#cfd0d5"));
        }
        this.u = false;
        this.w = new ArrayList();
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.b == 0 || this.b.getWidth() != i || this.b.getHeight() != i2) {
            this.j = i > 0 ? (float) i : 1065353216;
            if (i <= 0) {
                i = 1;
            }
            if (i2 <= 0) {
                i2 = 1;
            }
            this.b = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.c = new Canvas();
            this.c.setBitmap(this.b);
            this.l = true;
            m();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    private float getProgressGradientWidth() {
        float progressWidth = getProgressWidth() * 0.3f;
        return progressWidth < this.x ? this.x : progressWidth;
    }

    private float getProgressWidth() {
        return this.j * this.q;
    }

    private float getMaxTranslate() {
        return getProgressWidth() + getProgressGradientWidth();
    }

    private float getTranslateDx() {
        float progressWidth = getProgressWidth() * 0.04f;
        if (progressWidth > this.y && this.q > 0.6f) {
            return this.y;
        }
        if (progressWidth > this.z && this.q > PayBaseConstants.HALF_OF_FLOAT) {
            return this.z;
        }
        if (progressWidth <= this.A || this.q <= 0.4f) {
            return progressWidth > this.o ? this.o : progressWidth;
        } else {
            return this.A;
        }
    }

    private void i() {
        this.e = false;
        removeCallbacks(this.D);
        j();
        postInvalidate();
    }

    private void j() {
        k();
        this.i.setTranslate(0.0f, 0.0f);
        this.k.setLocalMatrix(this.i);
        this.f.setShader(this.k);
    }

    private void k() {
        if (this.i == null) {
            this.i = new Matrix();
        }
        if (this.k == null) {
            this.k = new LinearGradient(-getProgressGradientWidth(), 0.0f, 0.0f, 0.0f, new int[]{this.p, Color.parseColor("#1898f6"), Color.parseColor("#45b9f9"), Color.parseColor("#60ccfa"), Color.parseColor("#88e8fd"), this.p}, new float[]{0.0f, 0.01f, 0.33f, 0.66f, 0.99f, 1.0f}, TileMode.CLAMP);
        }
    }

    private void setProgress(int i) {
        i = (((float) i) * 1065353216) / ((float) this.n);
        this.l = this.q != i;
        this.q = i;
        this.w = c.a(this.v);
        if (this.w.size() > 0 && this.q < ((Float) this.w.get(this.w.size() - 1)).floatValue()) {
            l();
        }
    }

    private void l() {
        this.w = new ArrayList();
        c.b(this.v);
    }

    private void m() {
        if (this.l) {
            this.k = new LinearGradient(-getProgressGradientWidth(), 0.0f, 0.0f, 0.0f, new int[]{this.p, Color.parseColor("#1898f6"), Color.parseColor("#45b9f9"), Color.parseColor("#60ccfa"), Color.parseColor("#88e8fd"), this.p}, new float[]{0.0f, 0.01f, 0.33f, 0.66f, 0.99f, 1.0f}, TileMode.CLAMP);
            j();
            this.l = false;
        }
    }

    public void setMax(int i) {
        this.n = i;
    }

    public void setSaveKey(String str) {
        if (!TextUtils.equals(str, this.v)) {
            this.v = str;
            this.q = null;
            this.e = null;
            this.w = c.a(this.v);
        }
    }

    public String getSaveKey() {
        return this.v;
    }

    public final void a() {
        if (!(this.u || this.e || this.q >= 1.0f)) {
            StringBuilder stringBuilder = new StringBuilder("startGradientAnimation addProgress=");
            boolean z = this.d && !this.u && e();
            stringBuilder.append(z);
            g();
            if (e()) {
                f();
            }
            m();
            post(this.D);
            this.e = true;
        }
    }

    public final void b() {
        if (!this.u && this.e) {
            g();
            i();
            if (!e()) {
                f();
            }
        }
    }

    public final void c() {
        if (this.q < 1.0f) {
            this.u = true;
            new StringBuilder("fspv pause exec hideGradientAnimation=").append(this.e);
            if (this.e) {
                i();
            }
            invalidate();
        }
    }

    public final void d() {
        this.u = false;
        if (e()) {
            invalidate();
            return;
        }
        if (!this.e && this.q < 1.0f) {
            m();
            post(this.D);
            this.e = true;
        }
    }

    private String n() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.w != null) {
            int size = this.w.size();
            for (int i = 0; i < size; i++) {
                stringBuilder.append(this.w.get(i));
                stringBuilder.append(h.b);
            }
        }
        return stringBuilder.toString();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.drawColor(-1);
        this.c.drawRect(0.0f, (float) this.r, this.j, (float) (this.r + this.s), this.a);
        if (this.u) {
            this.c.drawRect(0.0f, (float) this.r, getProgressWidth(), (float) (this.r + this.s), this.h);
            canvas.drawBitmap(this.b, 0.0f, 0.0f, null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("progressdata=");
        stringBuilder.append(n());
        stringBuilder.append(";saveKey=");
        stringBuilder.append(getSaveKey());
        stringBuilder.append(";progresscache=");
        stringBuilder.append(c.c(this.v));
        this.c.drawRect(0.0f, (float) this.r, getProgressWidth(), (float) (this.r + this.s), this.f);
        canvas.drawBitmap(this.b, 0.0f, 0.0f, null);
    }

    public void setBackgroundPaintColor(int i) {
        this.a.setColor(i);
    }

    public final void a(int i) {
        boolean z = i >= 0 && i <= this.n;
        if (z) {
            setProgress(i);
            invalidate();
            if (this.q == 1065353216) {
                if (this.e != 0) {
                    b();
                }
                l();
                this.d = false;
            }
        }
    }

    static /* synthetic */ void j(FlickerSingleProgressView flickerSingleProgressView) {
        flickerSingleProgressView.k();
        flickerSingleProgressView.i.setTranslate(flickerSingleProgressView.m, 0.0f);
        flickerSingleProgressView.k.setLocalMatrix(flickerSingleProgressView.i);
    }
}
