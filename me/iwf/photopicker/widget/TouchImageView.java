package me.iwf.photopicker.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public class TouchImageView extends ImageView {
    private OnTouchListener A = null;
    private e B = null;
    private float a;
    private Matrix b;
    private Matrix c;
    private State d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float[] i;
    private Context j;
    private c k;
    private ScaleType l;
    private boolean m;
    private boolean n;
    private h o;
    private int p;
    private int q;
    private int r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private ScaleGestureDetector x;
    private GestureDetector y;
    private OnDoubleTapListener z = null;

    private enum State {
        NONE,
        DRAG,
        ZOOM,
        FLING,
        ANIMATE_ZOOM
    }

    @TargetApi(9)
    private class a {
        Scroller a;
        OverScroller b;
        boolean c;
        final /* synthetic */ TouchImageView d;

        public a(TouchImageView touchImageView, Context context) {
            this.d = touchImageView;
            if (VERSION.SDK_INT < 9) {
                this.c = true;
                this.a = new Scroller(context);
                return;
            }
            this.c = null;
            this.b = new OverScroller(context);
        }
    }

    private class b implements Runnable {
        final /* synthetic */ TouchImageView a;
        private long b;
        private float c;
        private float d;
        private float e;
        private float f;
        private boolean g;
        private AccelerateDecelerateInterpolator h = new AccelerateDecelerateInterpolator();
        private PointF i;
        private PointF j;

        b(TouchImageView touchImageView, float f, float f2, float f3, boolean z) {
            this.a = touchImageView;
            touchImageView.setState(State.ANIMATE_ZOOM);
            this.b = System.currentTimeMillis();
            this.c = touchImageView.a;
            this.d = f;
            this.g = z;
            f = touchImageView.a(f2, f3, false);
            this.e = f.x;
            this.f = f.y;
            this.i = touchImageView.b.getValues(touchImageView.i);
            this.j = new PointF((float) (touchImageView.p / 2), (float) (touchImageView.q / 2));
        }

        public final void run() {
            float interpolation = this.h.getInterpolation(Math.min(1.0f, ((float) (System.currentTimeMillis() - this.b)) / 500.0f));
            this.a.a(((double) (this.c + ((this.d - this.c) * interpolation))) / ((double) this.a.a), this.e, this.f, this.g);
            float f = this.i.x + ((this.j.x - this.i.x) * interpolation);
            float f2 = this.i.y + ((this.j.y - this.i.y) * interpolation);
            PointF b = this.a.b.getValues(this.a.i);
            this.a.b.postTranslate(f - b.x, f2 - b.y);
            this.a.c();
            this.a.setImageMatrix(this.a.b);
            if (this.a.B != null) {
                this.a.B;
            }
            if (interpolation < 1.0f) {
                TouchImageView.a(this.a, (Runnable) this);
            } else {
                this.a.setState(State.NONE);
            }
        }
    }

    private class c implements Runnable {
        a a;
        int b;
        int c;
        final /* synthetic */ TouchImageView d;

        c(TouchImageView touchImageView, int i, int i2) {
            int i3;
            int i4;
            int k;
            int i5;
            this.d = touchImageView;
            touchImageView.setState(State.FLING);
            this.a = new a(touchImageView, touchImageView.j);
            touchImageView.b.getValues(touchImageView.i);
            int i6 = (int) touchImageView.i[2];
            int i7 = (int) touchImageView.i[5];
            if (touchImageView.getImageWidth() > ((float) touchImageView.p)) {
                i3 = touchImageView.p - ((int) touchImageView.getImageWidth());
                i4 = 0;
            } else {
                i3 = i6;
                i4 = i3;
            }
            if (touchImageView.getImageHeight() > ((float) touchImageView.q)) {
                k = touchImageView.q - ((int) touchImageView.getImageHeight());
                i5 = 0;
            } else {
                k = i7;
                i5 = k;
            }
            touchImageView = this.a;
            if (touchImageView.c) {
                touchImageView.a.fling(i6, i7, i, i2, i3, i4, k, i5);
            } else {
                touchImageView.b.fling(i6, i7, i, i2, i3, i4, k, i5);
            }
            this.b = i6;
            this.c = i7;
        }

        public final void a() {
            if (this.a != null) {
                this.d.setState(State.NONE);
                a aVar = this.a;
                if (aVar.c) {
                    aVar.a.forceFinished(true);
                    return;
                }
                aVar.b.forceFinished(true);
            }
        }

        public final void run() {
            boolean isFinished;
            if (this.d.B != null) {
                this.d.B;
            }
            a aVar = this.a;
            if (aVar.c) {
                isFinished = aVar.a.isFinished();
            } else {
                isFinished = aVar.b.isFinished();
            }
            if (isFinished) {
                this.a = null;
                return;
            }
            aVar = this.a;
            if (aVar.c) {
                isFinished = aVar.a.computeScrollOffset();
            } else {
                aVar.b.computeScrollOffset();
                isFinished = aVar.b.computeScrollOffset();
            }
            if (isFinished) {
                int currX;
                int currY;
                aVar = this.a;
                if (aVar.c) {
                    currX = aVar.a.getCurrX();
                } else {
                    currX = aVar.b.getCurrX();
                }
                a aVar2 = this.a;
                if (aVar2.c) {
                    currY = aVar2.a.getCurrY();
                } else {
                    currY = aVar2.b.getCurrY();
                }
                int i = currX - this.b;
                int i2 = currY - this.c;
                this.b = currX;
                this.c = currY;
                this.d.b.postTranslate((float) i, (float) i2);
                this.d.b();
                this.d.setImageMatrix(this.d.b);
                TouchImageView.a(this.d, (Runnable) this);
            }
        }
    }

    private class d extends SimpleOnGestureListener {
        final /* synthetic */ TouchImageView a;

        private d(TouchImageView touchImageView) {
            this.a = touchImageView;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (this.a.z != null) {
                return this.a.z.onSingleTapConfirmed(motionEvent);
            }
            return this.a.performClick();
        }

        public final void onLongPress(MotionEvent motionEvent) {
            this.a.performLongClick();
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (this.a.k != null) {
                this.a.k.a();
            }
            this.a.k = new c(this.a, (int) f, (int) f2);
            TouchImageView.a(this.a, this.a.k);
            return super.onFling(motionEvent, motionEvent2, f, f2);
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            boolean onDoubleTap = this.a.z != null ? this.a.z.onDoubleTap(motionEvent) : false;
            if (this.a.d != State.NONE) {
                return onDoubleTap;
            }
            TouchImageView.a(this.a, new b(this.a, this.a.a == this.a.e ? this.a.f : this.a.e, motionEvent.getX(), motionEvent.getY(), false));
            return true;
        }

        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return this.a.z != null ? this.a.z.onDoubleTapEvent(motionEvent) : null;
        }
    }

    public interface e {
    }

    private class f implements OnTouchListener {
        final /* synthetic */ TouchImageView a;
        private PointF b;

        private f(TouchImageView touchImageView) {
            this.a = touchImageView;
            this.b = new PointF();
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.a.x.onTouchEvent(motionEvent);
            this.a.y.onTouchEvent(motionEvent);
            PointF pointF = new PointF(motionEvent.getX(), motionEvent.getY());
            if (this.a.d == State.NONE || this.a.d == State.DRAG || this.a.d == State.FLING) {
                int action = motionEvent.getAction();
                if (action != 6) {
                    switch (action) {
                        case 0:
                            this.b.set(pointF);
                            if (this.a.k != null) {
                                this.a.k.a();
                            }
                            this.a.setState(State.DRAG);
                            break;
                        case 1:
                            break;
                        case 2:
                            if (this.a.d == State.DRAG) {
                                float f = pointF.y - this.b.y;
                                this.a.b.postTranslate(TouchImageView.a(pointF.x - this.b.x, (float) this.a.p, this.a.getImageWidth()), TouchImageView.a(f, (float) this.a.q, this.a.getImageHeight()));
                                this.a.b();
                                this.b.set(pointF.x, pointF.y);
                                break;
                            }
                            break;
                        default:
                            break;
                    }
                }
                this.a.setState(State.NONE);
            }
            this.a.setImageMatrix(this.a.b);
            if (this.a.A != null) {
                this.a.A.onTouch(view, motionEvent);
            }
            if (this.a.B != null) {
                this.a.B;
            }
            return true;
        }
    }

    private class g extends SimpleOnScaleGestureListener {
        final /* synthetic */ TouchImageView a;

        private g(TouchImageView touchImageView) {
            this.a = touchImageView;
        }

        public final boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            this.a.setState(State.ZOOM);
            return true;
        }

        public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            this.a.a((double) scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY(), true);
            if (this.a.B != null) {
                this.a.B;
            }
            return true;
        }

        public final void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
            super.onScaleEnd(scaleGestureDetector);
            this.a.setState(State.NONE);
            this.a.a;
            Object obj = 1;
            if (this.a.a > this.a.f) {
                scaleGestureDetector = this.a.f;
            } else if (this.a.a < this.a.e) {
                scaleGestureDetector = this.a.e;
            } else {
                obj = null;
                scaleGestureDetector = null;
            }
            float f = scaleGestureDetector;
            if (obj != null) {
                TouchImageView.a(this.a, new b(this.a, f, (float) (this.a.p / 2), (float) (this.a.q / 2), true));
            }
        }
    }

    private class h {
        public float a;
        public float b;
        public float c;
        public ScaleType d;
        final /* synthetic */ TouchImageView e;

        public h(TouchImageView touchImageView, float f, float f2, float f3, ScaleType scaleType) {
            this.e = touchImageView;
            this.a = f;
            this.b = f2;
            this.c = f3;
            this.d = scaleType;
        }
    }

    static /* synthetic */ float a(float f, float f2, float f3) {
        return f3 <= f2 ? 0.0f : f;
    }

    private static float b(float f, float f2, float f3) {
        if (f3 <= f2) {
            f3 = f2 - f3;
            f2 = 0.0f;
        } else {
            f2 -= f3;
            f3 = 0.0f;
        }
        return f < f2 ? (-f) + f2 : f > f3 ? (-f) + f3 : 0.0f;
    }

    public TouchImageView(Context context) {
        super(context);
        a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public TouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        super.setClickable(true);
        this.j = context;
        this.x = new ScaleGestureDetector(context, new g());
        this.y = new GestureDetector(context, new d());
        this.b = new Matrix();
        this.c = new Matrix();
        this.i = new float[9];
        this.a = 1.0f;
        if (this.l == null) {
            this.l = ScaleType.FIT_CENTER;
        }
        this.e = 1.0f;
        this.f = 3.0f;
        this.g = 1061158912 * this.e;
        this.h = 1067450368 * this.f;
        setImageMatrix(this.b);
        setScaleType(ScaleType.MATRIX);
        setState(State.NONE);
        this.n = false;
        super.setOnTouchListener(new f());
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.A = onTouchListener;
    }

    public void setOnTouchImageViewListener(e eVar) {
        this.B = eVar;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.z = onDoubleTapListener;
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        a();
        d();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        a();
        d();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        a();
        d();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        a();
        d();
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != ScaleType.FIT_START) {
            if (scaleType != ScaleType.FIT_END) {
                if (scaleType == ScaleType.MATRIX) {
                    super.setScaleType(ScaleType.MATRIX);
                    return;
                }
                this.l = scaleType;
                if (this.n != null) {
                    setZoom(this);
                }
                return;
            }
        }
        throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
    }

    public ScaleType getScaleType() {
        return this.l;
    }

    public RectF getZoomedRect() {
        if (this.l == ScaleType.FIT_XY) {
            throw new UnsupportedOperationException("getZoomedRect() not supported with FIT_XY");
        }
        PointF a = a(0.0f, 0.0f, true);
        PointF a2 = a((float) this.p, (float) this.q, true);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        return new RectF(a.x / intrinsicWidth, a.y / intrinsicHeight, a2.x / intrinsicWidth, a2.y / intrinsicHeight);
    }

    private void a() {
        if (this.b != null && this.q != 0 && this.p != 0) {
            this.b.getValues(this.i);
            this.c.setValues(this.i);
            this.w = this.u;
            this.v = this.t;
            this.s = this.q;
            this.r = this.p;
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putFloat("saveScale", this.a);
        bundle.putFloat("matchViewHeight", this.u);
        bundle.putFloat("matchViewWidth", this.t);
        bundle.putInt("viewWidth", this.p);
        bundle.putInt("viewHeight", this.q);
        this.b.getValues(this.i);
        bundle.putFloatArray("matrix", this.i);
        bundle.putBoolean("imageRendered", this.m);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.a = bundle.getFloat("saveScale");
            this.i = bundle.getFloatArray("matrix");
            this.c.setValues(this.i);
            this.w = bundle.getFloat("matchViewHeight");
            this.v = bundle.getFloat("matchViewWidth");
            this.s = bundle.getInt("viewHeight");
            this.r = bundle.getInt("viewWidth");
            this.m = bundle.getBoolean("imageRendered");
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected void onDraw(Canvas canvas) {
        this.n = true;
        this.m = true;
        if (this.o != null) {
            a(this.o.a, this.o.b, this.o.c, this.o.d);
            this.o = null;
        }
        super.onDraw(canvas);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a();
    }

    public float getMaxZoom() {
        return this.f;
    }

    public void setMaxZoom(float f) {
        this.f = f;
        this.h = 1.25f * this.f;
    }

    public float getMinZoom() {
        return this.e;
    }

    public float getCurrentZoom() {
        return this.a;
    }

    public void setMinZoom(float f) {
        this.e = f;
        this.g = 0.75f * this.e;
    }

    private void a(float f, float f2, float f3, ScaleType scaleType) {
        if (this.n) {
            if (scaleType != this.l) {
                setScaleType(scaleType);
            }
            this.a = 1.0f;
            d();
            a((double) f, (float) (this.p / 2.8E-45f), (float) (this.q / 2.8E-45f), true);
            this.b.getValues(this.i);
            this.i[2] = -((f2 * getImageWidth()) - (((float) this.p) * PayBaseConstants.HALF_OF_FLOAT));
            this.i[5] = -((f3 * getImageHeight()) - (((float) this.q) * 1056964608));
            this.b.setValues(this.i);
            b();
            setImageMatrix(this.b);
            return;
        }
        this.o = new h(this, f, f2, f3, scaleType);
    }

    public void setZoom(TouchImageView touchImageView) {
        PointF scrollPosition = touchImageView.getScrollPosition();
        a(touchImageView.getCurrentZoom(), scrollPosition.x, scrollPosition.y, touchImageView.getScaleType());
    }

    public PointF getScrollPosition() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        PointF a = a((float) (this.p / 2), (float) (this.q / 2), true);
        a.x /= (float) intrinsicWidth;
        a.y /= (float) intrinsicHeight;
        return a;
    }

    private void b() {
        this.b.getValues(this.i);
        float f = this.i[2];
        float f2 = this.i[5];
        f = b(f, (float) this.p, getImageWidth());
        f2 = b(f2, (float) this.q, getImageHeight());
        if (f != 0.0f || f2 != 0.0f) {
            this.b.postTranslate(f, f2);
        }
    }

    private void c() {
        b();
        this.b.getValues(this.i);
        if (getImageWidth() < ((float) this.p)) {
            this.i[2] = (((float) this.p) - getImageWidth()) / 2.0f;
        }
        if (getImageHeight() < ((float) this.q)) {
            this.i[5] = (((float) this.q) - getImageHeight()) / 2.0f;
        }
        this.b.setValues(this.i);
    }

    private float getImageWidth() {
        return this.t * this.a;
    }

    private float getImageHeight() {
        return this.u * this.a;
    }

    protected void onMeasure(int i, int i2) {
        Drawable drawable = getDrawable();
        if (!(drawable == null || drawable.getIntrinsicWidth() == 0)) {
            if (drawable.getIntrinsicHeight() != 0) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int size = MeasureSpec.getSize(i);
                i = MeasureSpec.getMode(i);
                int size2 = MeasureSpec.getSize(i2);
                i2 = MeasureSpec.getMode(i2);
                this.p = a(i, size, intrinsicWidth);
                this.q = a(i2, size2, intrinsicHeight);
                setMeasuredDimension(this.p, this.q);
                d();
                return;
            }
        }
        setMeasuredDimension(0, 0);
    }

    private void d() {
        Drawable drawable = getDrawable();
        if (!(drawable == null || drawable.getIntrinsicWidth() == 0)) {
            if (drawable.getIntrinsicHeight() != 0) {
                if (this.b != null) {
                    if (this.c != null) {
                        float f;
                        float f2;
                        float f3;
                        int intrinsicWidth = drawable.getIntrinsicWidth();
                        int intrinsicHeight = drawable.getIntrinsicHeight();
                        float f4 = (float) intrinsicWidth;
                        float f5 = ((float) this.p) / f4;
                        float f6 = (float) intrinsicHeight;
                        float f7 = ((float) this.q) / f6;
                        switch (a.a[this.l.ordinal()]) {
                            case 1:
                                f5 = 1.0f;
                                break;
                            case 2:
                                f5 = Math.max(f5, f7);
                                break;
                            case 3:
                                f5 = Math.min(1.0f, Math.min(f5, f7));
                                f7 = f5;
                                break;
                            case 4:
                                break;
                            case 5:
                                f = ((float) this.p) - (f5 * f4);
                                f2 = ((float) this.q) - (f7 * f6);
                                this.t = ((float) this.p) - f;
                                this.u = ((float) this.q) - f2;
                                if ((this.a == 1.0f ? 1 : 0) == 0 || this.m) {
                                    if (this.v == 0.0f || this.w == 0.0f) {
                                        a();
                                    }
                                    this.c.getValues(this.i);
                                    this.i[0] = (this.t / f4) * this.a;
                                    this.i[4] = (this.u / f6) * this.a;
                                    f6 = this.i[2];
                                    f3 = this.i[5];
                                    a(2, f6, this.v * this.a, getImageWidth(), this.r, this.p, intrinsicWidth);
                                    a(5, f3, this.w * this.a, getImageHeight(), this.s, this.q, intrinsicHeight);
                                    this.b.setValues(this.i);
                                } else {
                                    this.b.setScale(f5, f7);
                                    this.b.postTranslate(f / 2.0f, f2 / 2.0f);
                                    this.a = 1.0f;
                                }
                                b();
                                setImageMatrix(this.b);
                            default:
                                throw new UnsupportedOperationException("TouchImageView does not support FIT_START or FIT_END");
                        }
                        f5 = Math.min(f5, f7);
                        f7 = f5;
                        f = ((float) this.p) - (f5 * f4);
                        f2 = ((float) this.q) - (f7 * f6);
                        this.t = ((float) this.p) - f;
                        this.u = ((float) this.q) - f2;
                        if (this.a == 1.0f) {
                        }
                        if ((this.a == 1.0f ? 1 : 0) == 0) {
                        }
                        a();
                        this.c.getValues(this.i);
                        this.i[0] = (this.t / f4) * this.a;
                        this.i[4] = (this.u / f6) * this.a;
                        f6 = this.i[2];
                        f3 = this.i[5];
                        a(2, f6, this.v * this.a, getImageWidth(), this.r, this.p, intrinsicWidth);
                        a(5, f3, this.w * this.a, getImageHeight(), this.s, this.q, intrinsicHeight);
                        this.b.setValues(this.i);
                        b();
                        setImageMatrix(this.b);
                    }
                }
            }
        }
    }

    private static int a(int i, int i2, int i3) {
        if (i != Integer.MIN_VALUE) {
            return i != 0 ? i2 : i3;
        } else {
            return Math.min(i3, i2);
        }
    }

    private void a(int i, float f, float f2, float f3, int i2, int i3, int i4) {
        i3 = (float) i3;
        if (f3 < i3) {
            this.i[i] = (i3 - (((float) i4) * this.i[0])) * 1056964608;
        } else if (f > 0) {
            this.i[i] = -((f3 - i3) * PayBaseConstants.HALF_OF_FLOAT);
        } else {
            this.i[i] = -((((Math.abs(f) + (((float) i2) * 1056964608)) / f2) * f3) - (i3 * 1056964608));
        }
    }

    private void setState(State state) {
        this.d = state;
    }

    public boolean canScrollHorizontally(int i) {
        this.b.getValues(this.i);
        float f = this.i[2];
        if (getImageWidth() < ((float) this.p)) {
            return false;
        }
        if (f >= -1.0f && i < 0) {
            return false;
        }
        if ((Math.abs(f) + ((float) this.p)) + 1.0f < getImageWidth() || i <= 0) {
            return true;
        }
        return false;
    }

    private void a(double d, float f, float f2, boolean z) {
        float f3;
        if (z) {
            z = this.g;
            f3 = this.h;
        } else {
            z = this.e;
            f3 = this.f;
        }
        float f4 = this.a;
        this.a = (float) (((double) this.a) * d);
        if (this.a > f3) {
            this.a = f3;
            d = (double) (f3 / f4);
        } else if (this.a < z) {
            this.a = z;
            d = (double) (z / f4);
        }
        d = (float) d;
        this.b.postScale(d, d, f, f2);
        c();
    }

    private PointF a(float f, float f2, boolean z) {
        this.b.getValues(this.i);
        float intrinsicWidth = (float) getDrawable().getIntrinsicWidth();
        float intrinsicHeight = (float) getDrawable().getIntrinsicHeight();
        float f3 = this.i[2];
        f = ((f - f3) * intrinsicWidth) / getImageWidth();
        f2 = ((f2 - this.i[5]) * intrinsicHeight) / getImageHeight();
        if (z) {
            f = Math.min(Math.max(f, 0.0f), intrinsicWidth);
            f2 = Math.min(Math.max(f2, 0.0f), intrinsicHeight);
        }
        return new PointF(f, f2);
    }

    public void setZoom(float f) {
        a(f, (float) PayBaseConstants.HALF_OF_FLOAT, (float) PayBaseConstants.HALF_OF_FLOAT, this.l);
    }

    static /* synthetic */ void a(TouchImageView touchImageView, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            touchImageView.postOnAnimation(runnable);
        } else {
            touchImageView.postDelayed(runnable, 16);
        }
    }
}
