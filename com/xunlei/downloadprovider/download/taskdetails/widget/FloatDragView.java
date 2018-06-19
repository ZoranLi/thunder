package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;
import android.widget.Scroller;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.util.j;

public class FloatDragView extends ViewGroup {
    private int A;
    private boolean B = false;
    private int C = 0;
    private final int a = -10;
    private final int b = 800;
    private final float c = 2.5f;
    private final int d = 2;
    private float e = 8.0f;
    private int f;
    private float g = 0.0f;
    private float h = 0.0f;
    private Scroller i;
    private boolean j = false;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o = false;
    private VelocityTracker p;
    private int q;
    private boolean r = true;
    private boolean s = false;
    private int t;
    private int u;
    private int v;
    private a w;
    private int x;
    private int y = -1;
    private boolean z;

    public interface a {
        void a(float f);

        void a(int i);
    }

    public FloatDragView(Context context) {
        super(context);
        a(context, null);
    }

    public FloatDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public FloatDragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
    }

    @TargetApi(21)
    public FloatDragView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.e = (float) ViewConfiguration.get(context).getScaledTouchSlop();
        this.i = new Scroller(context, new LinearInterpolator());
        context = context.obtainStyledAttributes(attributeSet, R.styleable.BLContainer);
        this.t = context.getDimensionPixelOffset(0, 0);
        this.x = context.getDimensionPixelOffset(1, 0);
        this.u = context.getInt(2, 11);
        context.recycle();
    }

    public void setLockScroll(boolean z) {
        this.s = z;
    }

    @IdRes
    public int getContentNestedScrollViewId() {
        return this.y;
    }

    public void setContentNestedScrollViewId(@IdRes int i) {
        this.y = i;
        invalidate();
    }

    public void computeScroll() {
        if (this.i.computeScrollOffset()) {
            scrollBy(0, this.i.getCurrY() - this.f);
            this.f = getScrollY();
            postInvalidate();
            return;
        }
        if (this.o) {
            this.o = false;
            if (this.i.getCurrY() > 0) {
                if (this.w != null) {
                    this.w.a(12);
                }
            } else if (this.i.getCurrY() < 0) {
                if (this.w != null) {
                    this.w.a(10);
                }
            } else if (this.w != null) {
                this.w.a(11);
            }
            this.f = 0;
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        StringBuilder stringBuilder = new StringBuilder("l: ");
        stringBuilder.append(i);
        stringBuilder.append(" t: ");
        stringBuilder.append(i2);
        stringBuilder.append(" oldl: ");
        stringBuilder.append(i3);
        stringBuilder.append(" oldt: ");
        stringBuilder.append(i4);
        if (this.w != 0) {
            i3 = (this.k - (this.t == 0 ? this.k - this.n : this.t)) - this.n;
            if (i2 > 0) {
                this.w.a((-((float) i2)) / ((float) this.t));
            } else if (i2 < 0) {
                this.w.a((-((float) i2)) / ((float) i3));
            } else {
                this.w.a((float) 0);
            }
            j.a().a = true;
            j.a().b = System.currentTimeMillis();
        }
    }

    public void scrollBy(int i, int i2) {
        super.scrollBy(i, i2);
        i = (float) getScrollY();
        float f = (float) (this.k / 2);
        if (!(this.w == null || i2 == 0)) {
            if (this.t == 0) {
                if (i > f - ((float) this.n)) {
                    this.g = (f - i) / ((float) this.n);
                    if (this.g >= 0) {
                    }
                } else if (i < (-(f - ((float) this.n)))) {
                    this.h = (i + f) / ((float) this.n);
                    if (this.h >= 0) {
                    }
                } else if (this.g != 0 && this.g != 1065353216) {
                    this.g = 1.0f;
                } else if (!(this.h == 0 || this.h == 1065353216)) {
                    this.h = 1.0f;
                }
            } else if (i > ((float) (this.t - this.n))) {
                this.g = (((float) this.t) - i) / ((float) this.n);
                if (this.g >= 0) {
                }
            } else if (i < (-(((f - ((float) this.t)) + f) - ((float) this.n)))) {
                this.h = (i + ((f - ((float) this.t)) + f)) / ((float) this.n);
                if (this.h >= 0) {
                }
            } else if (this.g != 0 && this.g != 1065353216) {
                this.g = 1.0f;
            } else if (!(this.h == 0 || this.h == 1065353216)) {
                this.h = 1.0f;
            }
        }
    }

    public void setScrollEnable(boolean z) {
        this.r = z;
    }

    private void b() {
        int scrollY = getScrollY();
        this.p.computeCurrentVelocity(1);
        float yVelocity = this.p.getYVelocity();
        if (((double) Math.abs(yVelocity)) > 0.1d) {
            if (this.u == 10 && yVelocity < 0.0f) {
                c(yVelocity);
                return;
            } else if (this.u == 11 && yVelocity < 0.0f) {
                a(yVelocity);
                return;
            } else if (this.u == 11 && yVelocity > 0.0f) {
                b(yVelocity);
                return;
            } else if (this.u == 12 && yVelocity > 0.0f && scrollY > this.m) {
                c(yVelocity);
                return;
            }
        }
        if (scrollY > this.l) {
            a(yVelocity);
        } else if (scrollY < this.m) {
            b(yVelocity);
        } else if (scrollY > 0) {
            c(yVelocity);
        } else {
            this.u = 11;
            c(yVelocity);
        }
    }

    private void a(float f) {
        int i;
        if (Math.abs(f) < 2.5f) {
            f = 2.5f;
        }
        int scrollY = getScrollY();
        if (this.t == 0) {
            i = (this.k / 2) - scrollY;
        } else {
            i = this.t - scrollY;
        }
        int i2 = i;
        this.v = this.u;
        this.u = 12;
        this.f = scrollY;
        int abs = 2 * ((int) Math.abs(((float) i2) / f));
        f = new StringBuilder("playFixAnimationUp scrollY: ");
        f.append(scrollY);
        f.append(" scrollDest: ");
        f.append(i2);
        this.i.startScroll(0, scrollY, 0, i2, abs);
        invalidate();
    }

    private void b(float f) {
        int i;
        if (Math.abs(f) < 2.5f) {
            f = 2.5f;
        }
        int scrollY = getScrollY();
        this.v = this.u;
        this.u = 10;
        if (this.t == 0) {
            i = ((-this.k) / 2) - scrollY;
        } else {
            i = (((-this.k) / 2) - ((this.k / 2) - this.t)) - scrollY;
        }
        this.f = scrollY;
        int abs = (int) (0.2f * Math.abs(((float) i) - (((float) this.n) / f)));
        f = new StringBuilder("playFixAnimationDown scrollY: ");
        f.append(scrollY);
        f.append(" scrollDest - mTitleHeight: ");
        f.append(i - this.n);
        this.i.startScroll(0, scrollY, 0, i - this.n, abs);
        invalidate();
    }

    private void c(float f) {
        if (Math.abs(f) < 2.5f) {
            f = 2.5f;
        }
        int scrollY = getScrollY();
        this.v = this.u;
        this.u = 11;
        int i = -scrollY;
        this.f = scrollY;
        int abs = 2 * ((int) Math.abs(((float) i) / f));
        f = new StringBuilder("playFixAnimationIdle scrollY: ");
        f.append(scrollY);
        f.append(" scrollDest: ");
        f.append(i);
        this.i.startScroll(0, scrollY, 0, i, abs);
        invalidate();
    }

    public void setIdleY(int i) {
        this.t = i;
        this.k = 0;
        invalidate();
    }

    public final void setVisibilityState$2563266(boolean z) {
        this.v = this.u;
        this.u = 12;
        this.f = getScrollY();
        if (z) {
            this.o = true;
            this.i.startScroll(0, getScrollY(), 0, this.t + (-this.f), 800);
        } else {
            scrollTo(false, this.t);
        }
        invalidate();
        requestLayout();
    }

    public void setListener(a aVar) {
        this.w = aVar;
    }

    public final void a() {
        scrollTo(0, 0);
        this.A = 0;
        this.v = 11;
        this.u = 11;
    }

    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i3 = 0;
            int i4 = i3;
            while (true) {
                boolean z = true;
                int i5 = childCount - 1;
                if (i3 < i5) {
                    View childAt = getChildAt(i3);
                    if (i3 != 0 || !"view_tag_value_top".equals(childAt.getTag())) {
                        z = false;
                    }
                    this.B = z;
                    if (childAt.getVisibility() != 0) {
                        this.C = 0;
                    }
                    if (childAt.getVisibility() != 8) {
                        measureChild(childAt, i, i2);
                        i4 += childAt.getMeasuredHeight();
                        if (i3 == 0 && "view_tag_value_top".equals(childAt.getTag())) {
                            this.C = childAt.getMeasuredHeight();
                        }
                    }
                    i3++;
                } else {
                    View childAt2 = getChildAt(i5);
                    int size = (MeasureSpec.getSize(i2) - i4) + getTopHeight();
                    measureChild(childAt2, i, MeasureSpec.makeMeasureSpec(size, 1073741824));
                    StringBuilder stringBuilder = new StringBuilder("onMeasure:");
                    stringBuilder.append(size);
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuilder.append(childAt2.getMeasuredHeight());
                    setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
                    return;
                }
            }
        }
        super.onMeasure(i, i2);
    }

    private int getTopHeight() {
        return this.B ? this.C : 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        if (z <= false) {
            int i5;
            int topHeight = (this.t + i2) - getTopHeight();
            int i6 = 0;
            while (true) {
                i5 = z - 1;
                if (i6 >= i5) {
                    break;
                }
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8) {
                    int measuredHeight = childAt.getMeasuredHeight() + topHeight;
                    childAt.layout(i, topHeight, i3, measuredHeight);
                    topHeight = measuredHeight;
                }
                i6++;
            }
            if (!(this.k && this.l && this.m)) {
                if (this.t) {
                    this.l = this.t / 2;
                    this.m = ((-(i4 - i2)) / 2) + this.t;
                } else {
                    this.l = (i4 - i2) / 4;
                    this.m = -this.l;
                }
                this.k = getMeasuredHeight() - topHeight;
            }
            z = getChildAt(i5);
            z.layout(i, topHeight, i3, Math.max(i4, z.getMeasuredHeight() + topHeight));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean c() {
        /*
        r5 = this;
        r0 = r5.getChildCount();
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r5.getChildCount();
        r2 = 1;
        r0 = r0 - r2;
        r0 = r5.getChildAt(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x0014:
        return r1;
    L_0x0015:
        r3 = r5.getContentNestedScrollView();
        r4 = r3 instanceof android.widget.ListView;
        if (r4 == 0) goto L_0x0044;
    L_0x001d:
        r3 = (android.widget.ListView) r3;
        r0 = r3.getFirstVisiblePosition();
        if (r0 <= 0) goto L_0x0027;
    L_0x0025:
        r0 = r2;
        goto L_0x0028;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        if (r0 != 0) goto L_0x0065;
    L_0x002a:
        r4 = r5.getChildCount();
        if (r4 <= 0) goto L_0x0065;
    L_0x0030:
        r4 = r3.getChildAt(r1);
        if (r4 == 0) goto L_0x0065;
    L_0x0036:
        r0 = r4.getTop();
        r3 = r3.getPaddingTop();
        if (r0 >= r3) goto L_0x0042;
    L_0x0040:
        r0 = r2;
        goto L_0x0065;
    L_0x0042:
        r0 = r1;
        goto L_0x0065;
    L_0x0044:
        r4 = r3 instanceof android.support.v7.widget.RecyclerView;
        if (r4 == 0) goto L_0x0066;
    L_0x0048:
        r3 = (android.support.v7.widget.RecyclerView) r3;
        r0 = r3.getLayoutManager();
        r4 = r3.getChildCount();
        if (r4 <= 0) goto L_0x0042;
    L_0x0054:
        r0 = r0.findViewByPosition(r1);
        if (r0 == 0) goto L_0x0040;
    L_0x005a:
        r0 = r0.getTop();
        r3 = r3.getPaddingTop();
        if (r0 >= r3) goto L_0x0042;
    L_0x0064:
        goto L_0x0040;
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = r0.getScrollY();
        if (r0 >= 0) goto L_0x006d;
    L_0x006c:
        return r2;
    L_0x006d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.taskdetails.widget.FloatDragView.c():boolean");
    }

    @Nullable
    private View getContentNestedScrollView() {
        return this.y > 0 ? findViewById(this.y) : null;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1 && this.z) {
            this.z = false;
            onTouchEvent(motionEvent);
            View contentNestedScrollView = getContentNestedScrollView();
            View childAt;
            if (contentNestedScrollView instanceof ListView) {
                ListView listView = (ListView) contentNestedScrollView;
                if (listView != null) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                    listView.onTouchEvent(motionEvent);
                    for (motionEvent = null; motionEvent < listView.getChildCount(); motionEvent++) {
                        childAt = listView.getChildAt(motionEvent);
                        if (childAt != null) {
                            childAt.setPressed(false);
                        }
                    }
                }
            } else if (contentNestedScrollView instanceof RecyclerView) {
                RecyclerView recyclerView = (RecyclerView) contentNestedScrollView;
                if (recyclerView != null) {
                    motionEvent = MotionEvent.obtain(motionEvent);
                    motionEvent.setAction(3);
                    recyclerView.onTouchEvent(motionEvent);
                    for (motionEvent = null; motionEvent < recyclerView.getChildCount(); motionEvent++) {
                        childAt = recyclerView.getChildAt(motionEvent);
                        if (childAt != null) {
                            childAt.setPressed(false);
                        }
                    }
                }
            }
            return true;
        } else if (this.z) {
            onTouchEvent(motionEvent);
            return true;
        } else {
            if (getScrollY() == this.t && a(motionEvent) && actionMasked == 2) {
                int y = (int) (motionEvent.getY() - ((float) this.A));
                if (motionEvent.getHistorySize() > 0) {
                    if (((float) ((int) (motionEvent.getY() - ((float) ((int) motionEvent.getHistoricalY(0)))))) > this.e && !c()) {
                        actionMasked = 1;
                        if (actionMasked != 0) {
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        if (onInterceptTouchEvent(motionEvent)) {
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        if (this.i.isFinished()) {
                            this.q = motionEvent.getPointerId(0);
                            this.A = (int) motionEvent.getY();
                            this.z = true;
                            onTouchEvent(motionEvent);
                            return true;
                        }
                        this.i.forceFinished(true);
                        return true;
                    }
                } else if (((float) y) > this.e) {
                    actionMasked = c() ^ 1;
                    if (actionMasked != 0) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (onInterceptTouchEvent(motionEvent)) {
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.i.isFinished()) {
                        this.q = motionEvent.getPointerId(0);
                        this.A = (int) motionEvent.getY();
                        this.z = true;
                        onTouchEvent(motionEvent);
                        return true;
                    }
                    this.i.forceFinished(true);
                    return true;
                }
            }
            actionMasked = 0;
            if (actionMasked != 0) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (onInterceptTouchEvent(motionEvent)) {
                return super.dispatchTouchEvent(motionEvent);
            }
            if (this.i.isFinished()) {
                this.i.forceFinished(true);
                return true;
            }
            this.q = motionEvent.getPointerId(0);
            this.A = (int) motionEvent.getY();
            this.z = true;
            onTouchEvent(motionEvent);
            return true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
        r6 = this;
        r0 = r7.getActionMasked();
        r1 = r6.r;
        r2 = 0;
        if (r1 == 0) goto L_0x00f0;
    L_0x0009:
        r1 = r6.s;
        if (r1 == 0) goto L_0x000f;
    L_0x000d:
        goto L_0x00f0;
    L_0x000f:
        r1 = r6.c();
        if (r1 == 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r6.j;
        r3 = 1;
        if (r1 == 0) goto L_0x001c;
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = 2;
        if (r0 != r1) goto L_0x0024;
    L_0x001f:
        r4 = r6.j;
        if (r4 == 0) goto L_0x0024;
    L_0x0023:
        return r3;
    L_0x0024:
        r4 = r6.u;
        r5 = 12;
        if (r4 != r5) goto L_0x0037;
    L_0x002a:
        r4 = r6.a(r7);
        if (r4 == 0) goto L_0x0037;
    L_0x0030:
        r4 = r6.a(r7);
        if (r4 != 0) goto L_0x0037;
    L_0x0036:
        return r2;
    L_0x0037:
        r4 = r6.t;
        r5 = r6.getScrollY();
        if (r5 != r4) goto L_0x0081;
    L_0x003f:
        r4 = r6.a(r7);
        if (r4 == 0) goto L_0x0081;
    L_0x0045:
        if (r0 != r1) goto L_0x0081;
    L_0x0047:
        r0 = r7.getHistorySize();
        r1 = r7.getY();
        r4 = r6.A;
        r4 = (float) r4;
        r1 = r1 - r4;
        r1 = (int) r1;
        if (r0 <= 0) goto L_0x0071;
    L_0x0056:
        r0 = r7.getHistoricalY(r2);
        r0 = (int) r0;
        r7 = r7.getY();
        r0 = (float) r0;
        r7 = r7 - r0;
        r7 = (int) r7;
        r7 = (float) r7;
        r0 = r6.e;
        r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r7 <= 0) goto L_0x0070;
    L_0x0069:
        r7 = r6.c();
        if (r7 != 0) goto L_0x0070;
    L_0x006f:
        return r3;
    L_0x0070:
        return r2;
    L_0x0071:
        r7 = (float) r1;
        r0 = r6.e;
        r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r7 <= 0) goto L_0x0080;
    L_0x0078:
        r7 = r6.c();
        if (r7 != 0) goto L_0x007f;
    L_0x007e:
        return r3;
    L_0x007f:
        return r2;
    L_0x0080:
        return r2;
    L_0x0081:
        r1 = 5;
        r4 = -10;
        if (r0 == r1) goto L_0x00d3;
    L_0x0086:
        switch(r0) {
            case 0: goto L_0x00b1;
            case 1: goto L_0x00aa;
            case 2: goto L_0x008a;
            default: goto L_0x0089;
        };
    L_0x0089:
        goto L_0x00ee;
    L_0x008a:
        r0 = r7.getY();
        r1 = r6.A;
        r1 = (float) r1;
        r0 = r0 - r1;
        r0 = (int) r0;
        r0 = java.lang.Math.abs(r0);
        r7 = r6.a(r7);
        if (r7 == 0) goto L_0x00a7;
    L_0x009d:
        r7 = (float) r0;
        r0 = r6.e;
        r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1));
        if (r7 <= 0) goto L_0x00a7;
    L_0x00a4:
        r6.j = r3;
        goto L_0x00ef;
    L_0x00a7:
        r6.j = r2;
        goto L_0x00ee;
    L_0x00aa:
        r6.q = r4;
        r7 = r6.j;
        if (r7 == 0) goto L_0x00ee;
    L_0x00b0:
        goto L_0x00ef;
    L_0x00b1:
        r0 = r6.a(r7);
        if (r0 == 0) goto L_0x00ee;
    L_0x00b7:
        r0 = r6.i;
        r0 = r0.isFinished();
        if (r0 != 0) goto L_0x00c5;
    L_0x00bf:
        r7 = r6.i;
        r7.forceFinished(r3);
        return r3;
    L_0x00c5:
        r0 = r7.getPointerId(r2);
        r6.q = r0;
        r7 = r7.getY();
        r7 = (int) r7;
        r6.A = r7;
        goto L_0x00ee;
    L_0x00d3:
        r0 = r6.a(r7);
        if (r0 == 0) goto L_0x00ee;
    L_0x00d9:
        r0 = r6.q;
        if (r0 != r4) goto L_0x00ee;
    L_0x00dd:
        r0 = r7.getActionIndex();
        r0 = r7.getPointerId(r0);
        r6.q = r0;
        r7 = r7.getY();
        r7 = (int) r7;
        r6.A = r7;
    L_0x00ee:
        r3 = r2;
    L_0x00ef:
        return r3;
    L_0x00f0:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.taskdetails.widget.FloatDragView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        if ((a(motionEvent) || this.j) && this.r) {
            if (!this.s) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.A = (int) motionEvent.getY();
                        this.q = motionEvent.getPointerId(0);
                        break;
                    case 1:
                        this.o = true;
                        this.j = false;
                        b();
                        this.p.clear();
                        this.q = -10;
                        break;
                    case 2:
                        this.j = true;
                        int historySize = motionEvent.getHistorySize();
                        if (historySize == 0) {
                            historySize = (int) motionEvent.getY();
                            i = this.A - historySize;
                            this.A = historySize;
                            a(i);
                        } else {
                            while (i < historySize) {
                                int historicalY = (int) motionEvent.getHistoricalY(i);
                                int i2 = this.A - historicalY;
                                this.A = historicalY;
                                a(i2);
                                i++;
                            }
                        }
                        this.p.addMovement(motionEvent);
                        break;
                    case 5:
                        if (this.q == -10) {
                            if (!this.i.isFinished()) {
                                this.i.forceFinished(true);
                            }
                            this.q = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.A = (int) motionEvent.getY();
                            break;
                        }
                        break;
                    case 6:
                        if (this.q != -10 && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.q) {
                            this.o = true;
                            this.j = false;
                            b();
                            this.p.clear();
                            this.q = -10;
                            break;
                        }
                    default:
                        break;
                }
                return true;
            }
        }
        return false;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.p = VelocityTracker.obtain();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.p.recycle();
    }

    private boolean a(MotionEvent motionEvent) {
        View firstVisibleChild = getFirstVisibleChild();
        if (firstVisibleChild == null) {
            return false;
        }
        int x = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        if (x <= 0 || x >= firstVisibleChild.getRight() || motionEvent <= firstVisibleChild.getTop() - getScrollY()) {
            return false;
        }
        return true;
    }

    private View getFirstVisibleChild() {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void a(int i) {
        if (this.t == 0) {
            if (getScrollY() + i > this.k / 2) {
                i = (this.k / 2) - getScrollY();
            } else if (getScrollY() + i < (-this.k) / 2) {
                i = ((-this.k) / 2) - getScrollY();
            }
        } else if (getScrollY() + i > this.t) {
            i = this.t - getScrollY();
        } else if (getScrollY() + i < ((-this.k) / 2) - ((this.k / 2) - this.t)) {
            i = (((-this.k) / 2) - ((this.k / 2) - this.t)) - getScrollY();
        }
        scrollBy(0, i);
    }

    public int getVisibilityState() {
        return this.u;
    }
}
