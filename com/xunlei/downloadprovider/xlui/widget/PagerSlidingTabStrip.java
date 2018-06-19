package com.xunlei.downloadprovider.xlui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.xunlei.downloadprovider.R;
import java.util.HashMap;
import java.util.Map;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private int A;
    private Drawable B;
    private int C;
    public OnPageChangeListener a;
    public Map<Object, OnClickListener> b;
    private final b c;
    private LinearLayout d;
    private ViewPager e;
    private Mode f;
    private int g;
    private int h;
    private float i;
    private float j;
    private Paint k;
    private Paint l;
    private int m;
    private int n;
    private int o;
    private a p;
    private boolean q;
    private boolean r;
    private boolean s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    public enum Mode {
        SLOID_TABS,
        SCROLLTABS
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new c();
        int a;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.a);
        }
    }

    public interface a {
    }

    private class b implements OnPageChangeListener {
        final /* synthetic */ PagerSlidingTabStrip a;

        private b(PagerSlidingTabStrip pagerSlidingTabStrip) {
            this.a = pagerSlidingTabStrip;
        }

        public final void onPageScrolled(int i, float f, int i2) {
            this.a.h = i;
            this.a.j = this.a.i;
            this.a.i = f;
            StringBuilder stringBuilder = new StringBuilder(" positionOffset: ");
            stringBuilder.append(this.a.i);
            stringBuilder.append(" lastOffset: ");
            stringBuilder.append(this.a.j);
            if (this.a.C == -1) {
                PagerSlidingTabStrip.a(this.a, i, (int) (((float) this.a.d.getChildAt(i).getWidth()) * f));
            }
            this.a.invalidate();
            if (this.a.a != null) {
                this.a.a.onPageScrolled(i, f, i2);
            }
        }

        public final void onPageScrollStateChanged(int i) {
            if (i == 0) {
                PagerSlidingTabStrip.a(this.a, this.a.e.getCurrentItem(), 0);
                this.a.C = -1;
            }
            if (this.a.a != null) {
                this.a.a.onPageScrollStateChanged(i);
            }
        }

        public final void onPageSelected(int i) {
            this.a.g = i;
            if (this.a.a != null) {
                this.a.a.onPageSelected(i);
            }
        }
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new b();
        this.f = Mode.SLOID_TABS;
        this.b = new HashMap();
        this.g = 0;
        this.h = 0;
        this.i = 0.0f;
        this.j = 0.0f;
        this.m = -10066330;
        this.n = 436207616;
        this.o = 436207616;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = 0;
        this.u = 12;
        this.v = 1;
        this.w = 100;
        this.x = 0;
        this.y = 2;
        this.z = 20;
        this.A = 2;
        this.C = -1;
        setFillViewport(true);
        setWillNotDraw(false);
        this.d = new LinearLayout(context);
        this.d.setOrientation(0);
        this.d.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.d);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.t = (int) TypedValue.applyDimension(1, (float) this.t, displayMetrics);
        this.u = (int) TypedValue.applyDimension(1, (float) this.u, displayMetrics);
        this.v = (int) TypedValue.applyDimension(1, (float) this.v, displayMetrics);
        this.w = (int) TypedValue.applyDimension(1, (float) this.w, displayMetrics);
        this.y = (int) TypedValue.applyDimension(1, (float) this.y, displayMetrics);
        this.z = (int) TypedValue.applyDimension(1, (float) this.z, displayMetrics);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.PagerSlidingTabStrip);
        this.n = attributeSet.getColor(1, this.n);
        this.o = attributeSet.getColor(2, this.o);
        this.t = attributeSet.getDimensionPixelSize(4, this.t);
        this.u = attributeSet.getDimensionPixelSize(5, this.u);
        attributeSet.recycle();
        this.k = new Paint();
        this.k.setAntiAlias(true);
        this.k.setStyle(Style.FILL);
        this.l = new Paint();
        this.l.setAntiAlias(true);
        this.l.setStrokeWidth((float) this.v);
        this.B = context.getResources().getDrawable(R.drawable.tab_flag);
    }

    public a getOnTabClickListener() {
        return this.p;
    }

    public void setOnTabClickListener(a aVar) {
        this.p = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        this.e = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.c);
        getViewTreeObserver().addOnGlobalLayoutListener(new a(this));
    }

    public Mode getCurrentMode() {
        return this.f;
    }

    public void setCurrentMode(Mode mode) {
        this.f = mode;
    }

    public void setTabWidth(int i) {
        this.w = i;
    }

    public void setIndicatorWidth(int i) {
        this.z = i;
    }

    public final void a(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (this.f == Mode.SLOID_TABS) {
            this.d.setWeightSum((float) (this.d.getChildCount() + 1));
            layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.weight = 1.0f;
        } else {
            this.d.setWeightSum(0.0f);
            layoutParams = new LinearLayout.LayoutParams(this.w, -1);
        }
        view.setOnClickListener(new b(this));
        this.d.addView(view, layoutParams);
        new StringBuilder("childCount:").append(this.d.getChildCount());
    }

    private void b(int i) {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        i = this.d.getChildAt(i);
        i.getLocationInWindow(iArr2);
        if (iArr2[0] < 0) {
            scrollTo(i.getLeft(), 0);
            return;
        }
        if (iArr2[0] + i.getWidth() > iArr[0] + getWidth()) {
            scrollTo((i.getLeft() - getWidth()) + i.getWidth(), 0);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode()) {
            if (this.d.getChildCount() != 0) {
                View childAt;
                int height = getHeight();
                this.k.setColor(this.m);
                View childAt2 = this.d.getChildAt(this.h);
                float left = ((float) childAt2.getLeft()) + ((((float) childAt2.getWidth()) - ((float) this.z)) / 2.0f);
                if (this.i > 0.0f && this.h < this.d.getChildCount() - 1) {
                    childAt = this.d.getChildAt(this.h + 1);
                    float left2 = (float) childAt.getLeft();
                    childAt.getRight();
                    left += ((left2 + ((((float) childAt.getWidth()) - ((float) this.z)) / 2.0f)) - left) * this.i;
                }
                this.B.setBounds((int) left, (height - this.y) - this.A, (int) (left + ((float) this.z)), height - this.A);
                this.B.draw(canvas);
                this.k.setColor(this.n);
                canvas.drawRect(0.0f, (float) (height - this.t), (float) this.d.getWidth(), (float) height, this.k);
                if (this.r) {
                    this.l.setColor(this.o);
                    for (int i = 0; i < this.d.getChildCount() - 1; i++) {
                        childAt = this.d.getChildAt(i);
                        canvas.drawLine((float) childAt.getRight(), (float) this.u, (float) childAt.getRight(), (float) (height - this.u), this.l);
                    }
                }
            }
        }
    }

    public int getCurrentTabIndext() {
        return this.g;
    }

    public View getCurrentTabView() {
        return a(this.g);
    }

    public void setUnderlineColor(int i) {
        this.n = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.n = getResources().getColor(i);
        invalidate();
    }

    public int getUnderlineColor() {
        return this.n;
    }

    public void setDividerColor(int i) {
        this.o = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.o = getResources().getColor(i);
        invalidate();
    }

    public int getDividerColor() {
        return this.o;
    }

    public void setUnderlineHeight(int i) {
        this.t = i;
        invalidate();
    }

    public int getUnderlineHeight() {
        return this.t;
    }

    public void setDividerPadding(int i) {
        this.u = i;
        invalidate();
    }

    public int getDividerPadding() {
        return this.u;
    }

    public void setShowDivider(boolean z) {
        this.r = z;
    }

    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.a = onPageChangeListener;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.g = savedState.a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.g;
        return savedState;
    }

    public final View a(int i) {
        this.d.getChildCount();
        return this.d != null ? this.d.getChildAt(i) : 0;
    }

    public void setCurrentTab(int i) {
        if (this.g != i) {
            this.C = i;
            this.g = i;
            b(i);
            this.e.setCurrentItem(i);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip r9, int r10, int r11) {
        /*
        r0 = r9.d;
        r0 = r0.getChildCount();
        r1 = 1;
        r0 = r0 - r1;
        if (r10 == r0) goto L_0x0157;
    L_0x000a:
        r0 = r9.d;
        r0 = r0.getChildCount();
        if (r0 == 0) goto L_0x0157;
    L_0x0012:
        if (r11 == 0) goto L_0x0157;
    L_0x0014:
        r11 = r9.d;
        r11 = r11.getChildAt(r10);
        r0 = 2;
        r2 = new int[r0];
        r9.getLocationInWindow(r2);
        r3 = new int[r0];
        r11.getLocationInWindow(r3);
        r4 = 0;
        r5 = r3[r4];
        if (r5 < 0) goto L_0x003c;
    L_0x002a:
        r3 = r3[r4];
        r11 = r11.getWidth();
        r3 = r3 + r11;
        r11 = r2[r4];
        r5 = r9.getWidth();
        r11 = r11 + r5;
        if (r3 > r11) goto L_0x003c;
    L_0x003a:
        r11 = r1;
        goto L_0x003d;
    L_0x003c:
        r11 = r4;
    L_0x003d:
        r3 = new int[r0];
        r5 = r9.d;
        r6 = r9.g;
        r5 = r5.getChildAt(r6);
        r6 = new java.lang.StringBuilder;
        r7 = " position: ";
        r6.<init>(r7);
        r6.append(r10);
        r7 = " currentPostion: ";
        r6.append(r7);
        r7 = r9.g;
        r6.append(r7);
        r5.getLocationInWindow(r3);
        r6 = r3[r4];
        if (r6 >= 0) goto L_0x006a;
    L_0x0062:
        r10 = r5.getLeft();
        r9.scrollTo(r10, r4);
        return;
    L_0x006a:
        r3 = r3[r4];
        r6 = r5.getWidth();
        r3 = r3 + r6;
        r6 = r2[r4];
        r7 = r9.getWidth();
        r6 = r6 + r7;
        if (r3 <= r6) goto L_0x008c;
    L_0x007a:
        r10 = r5.getLeft();
        r11 = r9.getWidth();
        r10 = r10 - r11;
        r11 = r5.getWidth();
        r10 = r10 + r11;
        r9.scrollTo(r10, r4);
        return;
    L_0x008c:
        r0 = new int[r0];
        r3 = r9.d;
        r10 = r10 + r1;
        r10 = r3.getChildAt(r10);
        r10.getLocationInWindow(r0);
        r3 = r0[r4];
        if (r3 < 0) goto L_0x00ae;
    L_0x009c:
        r0 = r0[r4];
        r3 = r10.getWidth();
        r0 = r0 + r3;
        r2 = r2[r4];
        r3 = r9.getWidth();
        r2 = r2 + r3;
        if (r0 > r2) goto L_0x00ae;
    L_0x00ac:
        r0 = r1;
        goto L_0x00af;
    L_0x00ae:
        r0 = r4;
    L_0x00af:
        if (r11 == 0) goto L_0x00b6;
    L_0x00b1:
        if (r0 != 0) goto L_0x00b4;
    L_0x00b3:
        goto L_0x00b6;
    L_0x00b4:
        r2 = r4;
        goto L_0x00b7;
    L_0x00b6:
        r2 = r1;
    L_0x00b7:
        if (r2 == 0) goto L_0x0157;
    L_0x00b9:
        r2 = r9.i;
        r3 = 0;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x00c8;
    L_0x00c0:
        r2 = r9.j;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 <= 0) goto L_0x00c8;
    L_0x00c6:
        r9.j = r3;
    L_0x00c8:
        r2 = r9.i;
        r5 = r9.j;
        r2 = r2 - r5;
        r5 = (double) r2;
        r7 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1));
        if (r2 <= 0) goto L_0x00d8;
    L_0x00d4:
        r2 = r9.i;
        r9.j = r2;
    L_0x00d8:
        r2 = r9.i;
        r5 = r9.j;
        r2 = r2 - r5;
        r10 = r10.getWidth();
        if (r11 == 0) goto L_0x00e8;
    L_0x00e3:
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 >= 0) goto L_0x00ec;
    L_0x00e7:
        return;
    L_0x00e8:
        r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r3 > 0) goto L_0x0157;
    L_0x00ec:
        r10 = (float) r10;
        r10 = r10 * r2;
        r10 = (int) r10;
        r3 = new java.lang.StringBuilder;
        r5 = " needScrollDis: ";
        r3.<init>(r5);
        r3.append(r10);
        r5 = " currentVisible:";
        r3.append(r5);
        r3.append(r11);
        if (r10 != 0) goto L_0x0108;
    L_0x0103:
        if (r11 == 0) goto L_0x0106;
    L_0x0105:
        goto L_0x0109;
    L_0x0106:
        r1 = -1;
        goto L_0x0109;
    L_0x0108:
        r1 = r10;
    L_0x0109:
        if (r11 != 0) goto L_0x010d;
    L_0x010b:
        if (r1 > 0) goto L_0x0157;
    L_0x010d:
        if (r0 != 0) goto L_0x0111;
    L_0x010f:
        if (r1 < 0) goto L_0x0157;
    L_0x0111:
        r10 = r9.getScrollX();
        r10 = r10 + r1;
        r3 = new java.lang.StringBuilder;
        r5 = "getScroll:  ";
        r3.<init>(r5);
        r5 = r9.getScrollX();
        r3.append(r5);
        r5 = "   scroll toLeft: ";
        r3.append(r5);
        r3.append(r10);
        r5 = " needScrollDis ";
        r3.append(r5);
        r3.append(r1);
        r1 = " ratio: ";
        r3.append(r1);
        r3.append(r2);
        r1 = new java.lang.StringBuilder;
        r2 = " currentVisible: ";
        r1.<init>(r2);
        r1.append(r11);
        r11 = " nextVisible: ";
        r1.append(r11);
        r1.append(r0);
        r11 = r9.x;
        if (r10 == r11) goto L_0x0157;
    L_0x0152:
        r9.x = r10;
        r9.scrollTo(r10, r4);
    L_0x0157:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip.a(com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip, int, int):void");
    }
}
