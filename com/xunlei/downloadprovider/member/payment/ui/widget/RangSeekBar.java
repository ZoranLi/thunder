package com.xunlei.downloadprovider.member.payment.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.util.ArrayList;
import java.util.List;

public class RangSeekBar extends ImageView {
    public static final Integer a = Integer.valueOf(0);
    public static final Integer b = Integer.valueOf(100);
    private float A;
    private boolean B;
    private Integer C;
    public List<Integer> c;
    private Integer d;
    private Integer e;
    private double f;
    private double g;
    private float h;
    private final int i;
    private RectF j;
    private float k;
    private final Bitmap l;
    private final Paint m;
    private final float n;
    private final float o;
    private final float p;
    private int q;
    private double r;
    private double s;
    private a t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private boolean z;

    public interface a {
        void a();
    }

    public RangSeekBar(Context context) {
        super(context);
        this.i = 15;
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.pay_seekbar_thumb_normal);
        this.m = new Paint(1);
        this.n = (float) this.l.getWidth();
        this.o = this.n * 1056964608;
        this.p = PayBaseConstants.HALF_OF_FLOAT * ((float) this.l.getHeight());
        this.r = 0.0d;
        this.s = 1.0d;
        this.u = DipPixelUtil.dip2px(8.0f);
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = Integer.valueOf(0);
        this.c = new ArrayList();
        a((AttributeSet) null);
    }

    public RangSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = 15;
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.pay_seekbar_thumb_normal);
        this.m = new Paint(1);
        this.n = (float) this.l.getWidth();
        this.o = this.n * 1056964608;
        this.p = PayBaseConstants.HALF_OF_FLOAT * ((float) this.l.getHeight());
        this.r = 0.0d;
        this.s = 1.0d;
        this.u = DipPixelUtil.dip2px(8.0f);
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = Integer.valueOf(0);
        this.c = new ArrayList();
        a(attributeSet);
    }

    public RangSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 15;
        this.l = BitmapFactory.decodeResource(getResources(), R.drawable.pay_seekbar_thumb_normal);
        this.m = new Paint(1);
        this.n = (float) this.l.getWidth();
        this.o = this.n * 1056964608;
        this.p = 1056964608 * ((float) this.l.getHeight());
        this.r = 0.0d;
        this.s = 1.0d;
        this.u = DipPixelUtil.dip2px(8.0f);
        this.y = false;
        this.z = false;
        this.B = false;
        this.C = Integer.valueOf(0);
        this.c = new ArrayList();
        a(attributeSet);
    }

    public final void a(Integer num, Integer num2) {
        this.d = num;
        this.e = num2;
        a();
        this.c.clear();
        num = this.e.intValue() / 31;
        if (num == null) {
            setVisibility(8);
            this.c.add(this.e);
        } else {
            int i = 0;
            if (this.e.intValue() % 31 == null) {
                this.c.add(Integer.valueOf(0));
                while (i < num) {
                    i++;
                    this.c.add(Integer.valueOf(i * 31));
                }
            } else if (this.e.intValue() % 31 != null) {
                this.c.add(Integer.valueOf(0));
                while (i < num) {
                    i++;
                    if (i != num) {
                        this.c.add(Integer.valueOf(i * 31));
                    } else {
                        this.c.add(this.e);
                    }
                }
            }
        }
        invalidate();
    }

    private void a() {
        this.f = this.d.doubleValue();
        this.g = this.e.doubleValue();
    }

    private static Integer a(TypedArray typedArray, int i, int i2) {
        if (typedArray.peekValue(i) == null) {
            return Integer.valueOf(i2);
        }
        return Integer.valueOf(typedArray.getInteger(i, i2));
    }

    private Integer a(double d) {
        return Integer.valueOf((int) (((double) Math.round((this.f + (d * (this.g - this.f))) * 100.0d)) / 100.0d));
    }

    public void setOnRangeSeekBarChangeListener(a aVar) {
        this.t = aVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x;
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.A = motionEvent.getX();
                setPressed(true);
                this.B = true;
                b();
                this.z = false;
                break;
            case 1:
                x = motionEvent.getX();
                this.y = true;
                if (this.B) {
                    setNormalizedMaxValue(a(x));
                    this.B = false;
                    setPressed(false);
                } else {
                    this.B = true;
                    setNormalizedMaxValue(a(x));
                    this.B = false;
                }
                invalidate();
                if (this.t != null) {
                    motionEvent = this.t;
                    this.C.intValue();
                    motionEvent.a();
                }
                this.z = false;
                break;
            case 2:
                x = motionEvent.getX();
                if (this.B) {
                    b(a(x));
                } else if (Math.abs(x - this.A) > ((float) this.q)) {
                    setPressed(true);
                    invalidate();
                    this.B = true;
                    b(a(x));
                    b();
                }
                this.z = true;
                break;
            case 3:
                if (this.B != null) {
                    this.B = false;
                    setPressed(false);
                }
                invalidate();
                this.z = false;
                break;
            default:
                break;
        }
        return true;
    }

    private void b(double d) {
        this.s = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.r)));
        invalidate();
    }

    private void setNormalizedMaxValue(double d) {
        if (a(d).intValue() > this.C.intValue()) {
            d = a(a(d).intValue(), true);
        } else {
            d = a(a(d).intValue(), false);
            if (d == ((Integer) this.c.get(0)).intValue()) {
                d = ((Integer) this.c.get(1)).intValue();
            }
        }
        this.C = Integer.valueOf(d);
        d = Integer.valueOf(d);
        if (0.0d == this.g - this.f) {
            d = 0.0d;
        } else {
            d = (d.doubleValue() - this.f) / (this.g - this.f);
        }
        this.s = Math.max(0.0d, Math.min(1.0d, Math.max(d, this.r)));
        invalidate();
    }

    private double a(float f) {
        float width = (float) getWidth();
        if (width <= this.k * 2.0f) {
            return 0.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, (double) ((f - this.k) / (width - (2.0f * this.k)))));
    }

    private float c(double d) {
        return (float) (((double) this.k) + (d * ((double) (((float) getWidth()) - (2.0f * this.k)))));
    }

    private void b() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    protected void onMeasure(int i, int i2) {
        i = MeasureSpec.getMode(i) != 0 ? MeasureSpec.getSize(i) : 200;
        int height = this.l.getHeight() + (DipPixelUtil.dip2px(13.0f) * 2);
        if (MeasureSpec.getMode(i2) != 0) {
            height = Math.min(height, MeasureSpec.getSize(i2));
        }
        setMeasuredDimension(i, height);
    }

    protected void onDraw(Canvas canvas) {
        this.m.setTextSize((float) this.v);
        this.m.setStyle(Style.FILL);
        this.m.setColor(-1117969);
        this.m.setAntiAlias(true);
        this.k = this.h + this.o;
        this.j.left = this.k;
        this.j.right = ((float) getWidth()) - this.k;
        canvas.drawRoundRect(this.j, (float) this.u, (float) this.u, this.m);
        this.j.left = c(this.r);
        this.j.right = c(this.s);
        this.m.setColor(-15559434);
        canvas.drawRoundRect(this.j, (float) this.u, (float) this.u, this.m);
        float c = c(this.s);
        Bitmap bitmap = this.l;
        if (getCurrentStepIndex() != 0) {
            if (getCurrentStepIndex() == this.c.size() - 1) {
                c -= 2.0f * this.o;
            } else {
                c -= this.o;
            }
        }
        canvas.drawBitmap(bitmap, c, (float) this.x, this.m);
        if (!(getCurrentStepIndex() == 0 || this.y || this.z)) {
            this.y = true;
        }
        if (this.y && getCurrentStepIndex() != 0) {
            String str;
            this.m.setTextSize((float) this.v);
            this.m.setColor(-15559434);
            int dip2px = DipPixelUtil.dip2px(4.0f);
            if (getCurrentStepIndex() == this.c.size() - 1) {
                str = "全部";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(getCurrentStepIndex());
                stringBuilder.append("个月");
                str = stringBuilder.toString();
            }
            float measureText = this.m.measureText(str) - ((float) dip2px);
            if (getCurrentStepIndex() == this.c.size() - 1) {
                c = c(this.s) - measureText;
            } else {
                c = c(this.s) - (measureText * PayBaseConstants.HALF_OF_FLOAT);
            }
            canvas.drawText(str, c, (float) (this.w + this.v), this.m);
            this.y = false;
        }
        super.onDraw(canvas);
    }

    public void setCurrentCoordValue(int i) {
        if (i != -1 || this.c.size() <= 0) {
            i *= 31;
            if (i > this.e.intValue()) {
                i = this.e.intValue();
            }
            if (i == 0 && this.c != null && this.c.size() > 0) {
                i = ((Integer) this.c.get(0)).intValue();
            }
        } else {
            i = ((Integer) this.c.get(this.c.size() - 1)).intValue();
        }
        this.C = Integer.valueOf(i);
        this.y = true;
        b(((double) i) / ((double) this.e.intValue()));
    }

    public int getCurrentCoordValue() {
        return this.C.intValue();
    }

    private int a(int i, boolean z) {
        if (i >= ((Integer) this.c.get(this.c.size() - 1)).intValue()) {
            return ((Integer) this.c.get(this.c.size() - true)).intValue();
        }
        int i2 = 0;
        if (i <= ((Integer) this.c.get(1)).intValue()) {
            return ((Integer) this.c.get(0)).intValue();
        }
        int intValue = this.C.intValue();
        while (i2 < this.c.size()) {
            int intValue2 = ((Integer) this.c.get(i2)).intValue();
            int i3 = 31;
            if (z) {
                if (i2 == this.c.size() - 1) {
                    i3 = ((Integer) this.c.get(i2)).intValue() - ((Integer) this.c.get(i2 - 1)).intValue();
                }
                if (intValue2 - i < i3 && intValue2 > i) {
                }
                i2++;
            } else {
                if (i2 == this.c.size() - 2) {
                    i3 = ((Integer) this.c.get(i2 + 1)).intValue() - ((Integer) this.c.get(i2)).intValue();
                }
                if (i - intValue2 < i3 && intValue2 < i) {
                }
                i2++;
            }
            intValue = intValue2;
        }
        return intValue;
    }

    private int getCurrentStepIndex() {
        for (int i = 0; i < this.c.size(); i++) {
            if (this.C.equals(this.c.get(i))) {
                return i;
            }
        }
        return 0;
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            this.d = a;
            this.e = b;
            a();
        } else {
            attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.RangeSeekBar, 0, 0);
            a(a(attributeSet, 0, a.intValue()), a(attributeSet, 1, b.intValue()));
            attributeSet.recycle();
        }
        this.h = (float) DipPixelUtil.dip2px(2.0f);
        this.v = DipPixelUtil.dip2px(11.0f);
        this.w = DipPixelUtil.dip2px(6.0f);
        this.x = (this.v + DipPixelUtil.dip2px(8.0f)) + this.w;
        float dip2px = ((float) DipPixelUtil.dip2px(15.0f)) / 2.0f;
        this.j = new RectF(this.k, (((float) this.x) + this.p) - dip2px, ((float) getWidth()) - this.k, (((float) this.x) + this.p) + dip2px);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.q = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
