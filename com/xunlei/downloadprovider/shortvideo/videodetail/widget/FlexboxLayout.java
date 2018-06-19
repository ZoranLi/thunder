package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlexboxLayout extends ViewGroup {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Drawable f;
    private Drawable g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private SparseIntArray m;
    private List<a> n;
    private boolean[] o;

    public static class LayoutParams extends MarginLayoutParams {
        public int a = 1;
        public float b = 0.0f;
        public float c = 1.0f;
        public int d = -1;
        public float e = -1.0f;
        public int f;
        public int g;
        public int h = ViewCompat.MEASURED_SIZE_MASK;
        public int i = ViewCompat.MEASURED_SIZE_MASK;
        public boolean j;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.a = context.getInt(0, 1);
            this.b = context.getFloat(1, 0.0f);
            this.c = context.getFloat(2, 1.0f);
            this.d = context.getInt(4, -1);
            this.e = context.getFraction(3, 1, 1, -1.0f);
            this.f = context.getDimensionPixelSize(5, 0);
            this.g = context.getDimensionPixelSize(6, 0);
            this.h = context.getDimensionPixelSize(7, ViewCompat.MEASURED_SIZE_MASK);
            this.i = context.getDimensionPixelSize(8, ViewCompat.MEASURED_SIZE_MASK);
            this.j = context.getBoolean(9, false);
            context.recycle();
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.a = layoutParams.a;
            this.b = layoutParams.b;
            this.c = layoutParams.c;
            this.d = layoutParams.d;
            this.e = layoutParams.e;
            this.f = layoutParams.f;
            this.g = layoutParams.g;
            this.h = layoutParams.h;
            this.i = layoutParams.i;
            this.j = layoutParams.j;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams() {
            super(new android.view.ViewGroup.LayoutParams(-2, -2));
        }
    }

    private static class a implements Comparable<a> {
        int a;
        int b;

        private a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
            a aVar = (a) obj;
            if (this.b != aVar.b) {
                return this.b - aVar.b;
            }
            return this.a - aVar.a;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder("Order{order=");
            stringBuilder.append(this.b);
            stringBuilder.append(", index=");
            stringBuilder.append(this.a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private static boolean c(int i) {
        if (i != 0) {
            if (i != 1) {
                return false;
            }
        }
        return true;
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = new ArrayList();
        context = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i, 0);
        this.a = context.getInt(0, 0);
        this.b = context.getInt(1, 0);
        this.c = context.getInt(2, 0);
        this.d = context.getInt(3, 4);
        this.e = context.getInt(4, 5);
        attributeSet = context.getDrawable(5);
        if (attributeSet != null) {
            setDividerDrawableHorizontal(attributeSet);
            setDividerDrawableVertical(attributeSet);
        }
        attributeSet = context.getDrawable(6);
        if (attributeSet != null) {
            setDividerDrawableHorizontal(attributeSet);
        }
        attributeSet = context.getDrawable(7);
        if (attributeSet != null) {
            setDividerDrawableVertical(attributeSet);
        }
        attributeSet = context.getInt(8, 0);
        if (attributeSet != null) {
            this.i = attributeSet;
            this.h = attributeSet;
        }
        attributeSet = context.getInt(10, 0);
        if (attributeSet != null) {
            this.i = attributeSet;
        }
        attributeSet = context.getInt(9, 0);
        if (attributeSet != null) {
            this.h = attributeSet;
        }
        context.recycle();
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int childCount = getChildCount();
        if (this.m == null) {
            this.m = new SparseIntArray(childCount);
        }
        boolean z = true;
        if (this.m.size() == childCount) {
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                if (childAt != null && ((LayoutParams) childAt.getLayoutParams()).a != this.m.get(i3)) {
                    break;
                }
                i3++;
            }
            z = false;
        }
        if (z) {
            childCount = getChildCount();
            this.l = a(childCount, b(childCount));
        }
        if (this.o == null || this.o.length < getChildCount()) {
            this.o = new boolean[getChildCount()];
        }
        switch (this.a) {
            case 0:
            case 1:
                a(i, i2);
                break;
            case 2:
            case 3:
                b(i, i2);
                break;
            default:
                i2 = new StringBuilder("Invalid value for the flex direction is set: ");
                i2.append(this.a);
                throw new IllegalStateException(i2.toString());
        }
        Arrays.fill(this.o, false);
    }

    private View a(int i) {
        if (i >= 0) {
            if (i < this.l.length) {
                return getChildAt(this.l[i]);
            }
        }
        return 0;
    }

    private int[] a(int i, List<a> list) {
        Collections.sort(list);
        if (this.m == null) {
            this.m = new SparseIntArray(i);
        }
        this.m.clear();
        i = new int[i];
        int i2 = 0;
        for (a aVar : list) {
            i[i2] = aVar.a;
            this.m.append(i2, aVar.b);
            i2++;
        }
        return i;
    }

    @NonNull
    private List<a> b(int i) {
        List<a> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
            a aVar = new a();
            aVar.b = layoutParams.a;
            aVar.a = i2;
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private void a(int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        this.n.clear();
        int childCount = getChildCount();
        int paddingStart = ViewCompat.getPaddingStart(this);
        int paddingEnd = ViewCompat.getPaddingEnd(this);
        a aVar = new a();
        int i5 = paddingStart + paddingEnd;
        aVar.e = i5;
        int i6 = 0;
        a aVar2 = aVar;
        paddingStart = 0;
        int i7 = paddingStart;
        int i8 = i7;
        paddingEnd = Integer.MIN_VALUE;
        while (i7 < childCount) {
            int combineMeasuredStates;
            int i9;
            int i10;
            View a = a(i7);
            if (a != null) {
                if (a.getVisibility() == 8) {
                    aVar2.h++;
                    aVar2.i++;
                } else {
                    LayoutParams layoutParams;
                    LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                    if (layoutParams2.d == 4) {
                        aVar2.m.add(Integer.valueOf(i7));
                    }
                    int i11 = layoutParams2.width;
                    if (layoutParams2.e != -1.0f && mode == 1073741824) {
                        i11 = Math.round(((float) size) * layoutParams2.e);
                    }
                    a.measure(getChildMeasureSpec(i3, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, i11), getChildMeasureSpec(i4, ((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams2.height));
                    a(a);
                    combineMeasuredStates = ViewCompat.combineMeasuredStates(paddingStart, ViewCompat.getMeasuredState(a));
                    int max = Math.max(paddingEnd, (a.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin);
                    int measuredWidth = (a.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin;
                    LayoutParams layoutParams3 = layoutParams2;
                    i9 = mode;
                    i10 = size;
                    View view = a;
                    a aVar3 = aVar2;
                    int i12 = combineMeasuredStates;
                    combineMeasuredStates = i7;
                    if (a(mode, size, aVar2.e, measuredWidth, layoutParams3, i7, i8)) {
                        if (aVar3.a() > 0) {
                            a(aVar3);
                        }
                        aVar2 = new a();
                        aVar2.h = 1;
                        aVar2.e = i5;
                        layoutParams = layoutParams3;
                        max = (view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                        aVar3 = aVar2;
                        paddingEnd = 0;
                    } else {
                        layoutParams = layoutParams3;
                        aVar3.h++;
                        paddingEnd = i8 + 1;
                    }
                    paddingStart = max;
                    aVar3.e += (view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    aVar3.j += layoutParams.b;
                    aVar3.k += layoutParams.c;
                    aVar3.g = Math.max(aVar3.g, paddingStart);
                    if (d(combineMeasuredStates, paddingEnd)) {
                        aVar3.e += r8.k;
                        aVar3.f += r8.k;
                    }
                    if (r8.b != 2) {
                        aVar3.l = Math.max(aVar3.l, view.getBaseline() + layoutParams.topMargin);
                    } else {
                        aVar3.l = Math.max(aVar3.l, (view.getMeasuredHeight() - view.getBaseline()) + layoutParams.bottomMargin);
                    }
                    i8 = paddingEnd;
                    aVar2 = aVar3;
                    paddingEnd = paddingStart;
                    paddingStart = i12;
                    a(combineMeasuredStates, childCount, aVar2);
                    i7 = combineMeasuredStates + 1;
                    mode = i9;
                    size = i10;
                }
            }
            combineMeasuredStates = i7;
            i9 = mode;
            i10 = size;
            aVar2 = aVar2;
            a(combineMeasuredStates, childCount, aVar2);
            i7 = combineMeasuredStates + 1;
            mode = i9;
            size = i10;
        }
        a(r8.a, i3, i4);
        if (r8.d == 3) {
            for (a aVar4 : r8.n) {
                int i13 = Integer.MIN_VALUE;
                for (int i14 = i6; i14 < i6 + aVar4.h; i14++) {
                    View a2 = a(i14);
                    LayoutParams layoutParams4 = (LayoutParams) a2.getLayoutParams();
                    if (r8.b != 2) {
                        i13 = Math.max(i13, (a2.getHeight() + Math.max(aVar4.l - a2.getBaseline(), layoutParams4.topMargin)) + layoutParams4.bottomMargin);
                    } else {
                        i13 = Math.max(i13, (a2.getHeight() + layoutParams4.topMargin) + Math.max((aVar4.l - a2.getMeasuredHeight()) + a2.getBaseline(), layoutParams4.bottomMargin));
                    }
                }
                aVar4.g = i13;
                i6 += aVar4.h;
            }
        }
        a(r8.a, i3, i4, getPaddingTop() + getPaddingBottom());
        c(r8.a, r8.d);
        b(r8.a, i3, i4, paddingStart);
    }

    private void b(int i, int i2) {
        int i3;
        int i4 = i;
        int i5 = i2;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        this.n.clear();
        int childCount = getChildCount();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        a aVar = new a();
        int i6 = paddingTop + paddingBottom;
        aVar.e = i6;
        paddingBottom = Integer.MIN_VALUE;
        a aVar2 = aVar;
        paddingTop = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < childCount) {
            int i9;
            View a = a(i7);
            if (a != null) {
                if (a.getVisibility() == 8) {
                    aVar2.h++;
                    aVar2.i++;
                } else {
                    View view;
                    LayoutParams layoutParams;
                    LayoutParams layoutParams2 = (LayoutParams) a.getLayoutParams();
                    if (layoutParams2.d == 4) {
                        aVar2.m.add(Integer.valueOf(i7));
                    }
                    i3 = layoutParams2.height;
                    if (layoutParams2.e != -1.0f && mode == 1073741824) {
                        i3 = Math.round(((float) size) * layoutParams2.e);
                    }
                    a.measure(getChildMeasureSpec(i4, ((getPaddingLeft() + getPaddingRight()) + layoutParams2.leftMargin) + layoutParams2.rightMargin, layoutParams2.width), getChildMeasureSpec(i5, ((getPaddingTop() + getPaddingBottom()) + layoutParams2.topMargin) + layoutParams2.bottomMargin, i3));
                    a(a);
                    i4 = ViewCompat.combineMeasuredStates(paddingTop, ViewCompat.getMeasuredState(a));
                    int max = Math.max(paddingBottom, (a.getMeasuredWidth() + layoutParams2.leftMargin) + layoutParams2.rightMargin);
                    LayoutParams layoutParams3 = layoutParams2;
                    int i10 = i4;
                    View view2 = a;
                    a aVar3 = aVar2;
                    i9 = mode;
                    mode = i7;
                    if (a(mode, size, aVar2.e, (a.getMeasuredHeight() + layoutParams2.topMargin) + layoutParams2.bottomMargin, layoutParams3, i7, i8)) {
                        if (aVar3.a() > 0) {
                            a(aVar3);
                        }
                        aVar2 = new a();
                        aVar2.h = 1;
                        aVar2.e = i6;
                        view = view2;
                        layoutParams = layoutParams3;
                        max = (view.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                        paddingTop = 0;
                    } else {
                        layoutParams = layoutParams3;
                        view = view2;
                        aVar3.h++;
                        paddingTop = i8 + 1;
                        aVar2 = aVar3;
                    }
                    aVar2.e += (view.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                    aVar2.j += layoutParams.b;
                    aVar2.k += layoutParams.c;
                    aVar2.g = Math.max(aVar2.g, max);
                    if (d(mode, paddingTop)) {
                        aVar2.e += r8.j;
                    }
                    i8 = paddingTop;
                    paddingBottom = max;
                    paddingTop = i10;
                    a(mode, childCount, aVar2);
                    i7 = mode + 1;
                    mode = i9;
                    i4 = i;
                }
            }
            i9 = mode;
            mode = i7;
            aVar2 = aVar2;
            a(mode, childCount, aVar2);
            i7 = mode + 1;
            mode = i9;
            i4 = i;
        }
        i3 = i;
        a(r8.a, i3, i5);
        a(r8.a, i3, i5, getPaddingLeft() + getPaddingRight());
        c(r8.a, r8.d);
        b(r8.a, i3, i5, paddingTop);
    }

    private static void a(View view) {
        Object obj;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        Object obj2 = 1;
        if (view.getMeasuredWidth() < layoutParams.f) {
            measuredWidth = layoutParams.f;
        } else if (view.getMeasuredWidth() > layoutParams.h) {
            measuredWidth = layoutParams.h;
        } else {
            obj = null;
            if (measuredHeight < layoutParams.g) {
                measuredHeight = layoutParams.g;
            } else if (measuredHeight <= layoutParams.i) {
                measuredHeight = layoutParams.i;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                view.measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
        }
        obj = 1;
        if (measuredHeight < layoutParams.g) {
            measuredHeight = layoutParams.g;
        } else if (measuredHeight <= layoutParams.i) {
            obj2 = obj;
        } else {
            measuredHeight = layoutParams.i;
        }
        if (obj2 != null) {
            view.measure(MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    private void a(int i, int i2, a aVar) {
        if (i == i2 - 1 && aVar.a() != 0) {
            a(aVar);
        }
    }

    private void a(a aVar) {
        if (c(this.a)) {
            if ((this.i & 4) > 0) {
                aVar.e += this.k;
                aVar.f += this.k;
            }
        } else if ((this.h & 4) > 0) {
            aVar.e += this.j;
            aVar.f += this.j;
        }
        this.n.add(aVar);
    }

    private void a(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int i4 = i;
        int mode;
        switch (i4) {
            case 0:
            case 1:
                mode = MeasureSpec.getMode(i2);
                size = MeasureSpec.getSize(i2);
                if (mode != 1073741824) {
                    size = getLargestMainSize();
                }
                paddingLeft = getPaddingLeft() + getPaddingRight();
                break;
            case 2:
            case 3:
                mode = MeasureSpec.getMode(i3);
                size = MeasureSpec.getSize(i3);
                if (mode != 1073741824) {
                    size = getLargestMainSize();
                }
                paddingLeft = getPaddingTop() + getPaddingBottom();
                break;
            default:
                FlexboxLayout flexboxLayout = this;
                StringBuilder stringBuilder = new StringBuilder("Invalid flex direction: ");
                stringBuilder.append(i4);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
        int i5 = paddingLeft;
        int i6 = size;
        int i7 = 0;
        for (a aVar : this.n) {
            if (aVar.e < i6) {
                i7 = a(i2, i3, aVar, i4, i6, i5, i7, false);
            } else {
                i7 = b(i2, i3, aVar, i4, i6, i5, i7, false);
            }
        }
    }

    private int a(int i, int i2, a aVar, int i3, int i4, int i5, int i6, boolean z) {
        FlexboxLayout flexboxLayout = this;
        a aVar2 = aVar;
        int i7 = i4;
        if (aVar2.j > 0.0f) {
            if (i7 >= aVar2.e) {
                int i8;
                int round;
                int i9 = aVar2.e;
                float f = ((float) (i7 - aVar2.e)) / aVar2.j;
                aVar2.e = i5 + aVar2.f;
                if (!z) {
                    aVar2.g = Integer.MIN_VALUE;
                }
                int i10 = 0;
                int i11 = i6;
                float f2 = 0.0f;
                int i12 = 0;
                int i13 = i12;
                while (i10 < aVar2.h) {
                    float f3;
                    View a = a(i11);
                    if (a != null) {
                        if (a.getVisibility() == 8) {
                            i11++;
                        } else {
                            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                            boolean z2;
                            if (c(i3)) {
                                if (flexboxLayout.o[i11]) {
                                    i8 = i2;
                                } else {
                                    float measuredWidth = ((float) a.getMeasuredWidth()) + (layoutParams.b * f);
                                    if (i10 == aVar2.h - 1) {
                                        measuredWidth += f2;
                                        f2 = 0.0f;
                                    }
                                    round = Math.round(measuredWidth);
                                    if (round > layoutParams.h) {
                                        round = layoutParams.h;
                                        flexboxLayout.o[i11] = true;
                                        aVar2.j -= layoutParams.b;
                                        i8 = i2;
                                        z2 = true;
                                    } else {
                                        f2 += measuredWidth - ((float) round);
                                        double d = (double) f2;
                                        if (d > 1.0d) {
                                            round++;
                                            f2 = (float) (d - 1.0d);
                                        } else if (d < -1.0d) {
                                            round--;
                                            f2 = (float) (d + 1.0d);
                                        }
                                        i8 = i2;
                                    }
                                    boolean z3 = z2;
                                    a.measure(MeasureSpec.makeMeasureSpec(round, 1073741824), b(i8, layoutParams));
                                    i13 = Math.max(i13, (a.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin);
                                    i12 = z3;
                                }
                                aVar2.e += (a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                                round = i;
                                f3 = f;
                            } else {
                                i8 = i2;
                                if (flexboxLayout.o[i11]) {
                                    round = i;
                                    f3 = f;
                                } else {
                                    float measuredHeight = ((float) a.getMeasuredHeight()) + (layoutParams.b * f);
                                    if (i10 == aVar2.h - 1) {
                                        measuredHeight += f2;
                                        f2 = 0.0f;
                                    }
                                    int round2 = Math.round(measuredHeight);
                                    f3 = f;
                                    if (round2 > layoutParams.i) {
                                        round2 = layoutParams.i;
                                        flexboxLayout.o[i11] = true;
                                        aVar2.j -= layoutParams.b;
                                        round = i;
                                        z2 = true;
                                    } else {
                                        f2 += measuredHeight - ((float) round2);
                                        double d2 = (double) f2;
                                        if (d2 > 1.0d) {
                                            round2++;
                                            measuredHeight = (float) (d2 - 1.0d);
                                        } else {
                                            if (d2 < -1.0d) {
                                                round2--;
                                                measuredHeight = (float) (d2 + 1.0d);
                                            }
                                            round = i;
                                        }
                                        f2 = measuredHeight;
                                        round = i;
                                    }
                                    boolean z4 = z2;
                                    a.measure(a(round, layoutParams), MeasureSpec.makeMeasureSpec(round2, 1073741824));
                                    i13 = Math.max(i13, (a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
                                    i12 = z4;
                                }
                                aVar2.e += (a.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                            }
                            aVar2.g = Math.max(aVar2.g, i13);
                            i11++;
                            i10++;
                            f = f3;
                        }
                    }
                    round = i;
                    i8 = i2;
                    f3 = f;
                    i10++;
                    f = f3;
                }
                round = i;
                i8 = i2;
                if (!(i12 == 0 || i9 == aVar2.e)) {
                    a(round, i8, aVar2, i3, i7, i5, i6, true);
                }
                return i11;
            }
        }
        return i6 + aVar2.h;
    }

    private int b(int i, int i2, a aVar, int i3, int i4, int i5, int i6, boolean z) {
        FlexboxLayout flexboxLayout = this;
        a aVar2 = aVar;
        int i7 = i4;
        int i8 = aVar2.e;
        if (aVar2.k > 0.0f) {
            if (i7 <= aVar2.e) {
                int i9;
                int i10;
                float f = ((float) (aVar2.e - i7)) / aVar2.k;
                aVar2.e = i5 + aVar2.f;
                if (!z) {
                    aVar2.g = Integer.MIN_VALUE;
                }
                int i11 = 0;
                int i12 = i6;
                float f2 = 0.0f;
                int i13 = 0;
                int i14 = i13;
                while (i11 < aVar2.h) {
                    float f3;
                    View a = a(i12);
                    if (a != null) {
                        if (a.getVisibility() == 8) {
                            i12++;
                        } else {
                            LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                            boolean z2 = true;
                            float measuredWidth;
                            if (c(i3)) {
                                if (flexboxLayout.o[i12]) {
                                    i9 = i2;
                                    z2 = i13;
                                } else {
                                    measuredWidth = ((float) a.getMeasuredWidth()) - (layoutParams.c * f);
                                    if (i11 == aVar2.h - 1) {
                                        measuredWidth += f2;
                                        f2 = 0.0f;
                                    }
                                    i9 = Math.round(measuredWidth);
                                    if (i9 < layoutParams.f) {
                                        i9 = layoutParams.f;
                                        flexboxLayout.o[i12] = true;
                                        aVar2.k -= layoutParams.c;
                                    } else {
                                        f2 += measuredWidth - ((float) i9);
                                        double d = (double) f2;
                                        if (d > 1.0d) {
                                            i9++;
                                            f2 -= 1.0f;
                                        } else if (d < -1.0d) {
                                            i9--;
                                            f2 += 1.0f;
                                        }
                                        z2 = i13;
                                    }
                                    i13 = i9;
                                    a.measure(MeasureSpec.makeMeasureSpec(i13, 1073741824), b(i2, layoutParams));
                                    i14 = Math.max(i14, (a.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin);
                                }
                                aVar2.e += (a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                                f3 = f;
                                i10 = i;
                            } else {
                                boolean z3;
                                i9 = i2;
                                if (flexboxLayout.o[i12]) {
                                    f3 = f;
                                    i10 = i;
                                } else {
                                    measuredWidth = ((float) a.getMeasuredHeight()) - (layoutParams.c * f);
                                    if (i11 == aVar2.h - 1) {
                                        measuredWidth += f2;
                                        f2 = 0.0f;
                                    }
                                    int round = Math.round(measuredWidth);
                                    f3 = f;
                                    if (round < layoutParams.g) {
                                        round = layoutParams.g;
                                        flexboxLayout.o[i12] = true;
                                        aVar2.k -= layoutParams.c;
                                        i10 = i;
                                        z3 = true;
                                    } else {
                                        f2 += measuredWidth - ((float) round);
                                        double d2 = (double) f2;
                                        if (d2 > 1.0d) {
                                            round++;
                                            f2 -= 1.0f;
                                        } else if (d2 < -1.0d) {
                                            round--;
                                            f2 += 1.0f;
                                        }
                                        i10 = i;
                                    }
                                    a.measure(a(i10, layoutParams), MeasureSpec.makeMeasureSpec(round, 1073741824));
                                    i14 = Math.max(i14, (a.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin);
                                }
                                z2 = z3;
                                aVar2.e += (a.getMeasuredHeight() + layoutParams.topMargin) + layoutParams.bottomMargin;
                            }
                            aVar2.g = Math.max(aVar2.g, i14);
                            i12++;
                            i13 = z2;
                            i11++;
                            f = f3;
                            i7 = i4;
                        }
                    }
                    i9 = i2;
                    f3 = f;
                    i10 = i;
                    i11++;
                    f = f3;
                    i7 = i4;
                }
                i10 = i;
                i9 = i2;
                if (!(i13 == 0 || i8 == aVar2.e)) {
                    b(i10, i9, aVar2, i3, i4, i5, i6, true);
                }
                return i12;
            }
        }
        return i6 + aVar2.h;
    }

    private int a(int i, LayoutParams layoutParams) {
        i = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + layoutParams.leftMargin) + layoutParams.rightMargin, layoutParams.width);
        int size = MeasureSpec.getSize(i);
        if (size > layoutParams.h) {
            return MeasureSpec.makeMeasureSpec(layoutParams.h, MeasureSpec.getMode(i));
        }
        return size < layoutParams.f ? MeasureSpec.makeMeasureSpec(layoutParams.f, MeasureSpec.getMode(i)) : i;
    }

    private int b(int i, LayoutParams layoutParams) {
        i = getChildMeasureSpec(i, ((getPaddingTop() + getPaddingBottom()) + layoutParams.topMargin) + layoutParams.bottomMargin, layoutParams.height);
        int size = MeasureSpec.getSize(i);
        if (size > layoutParams.i) {
            return MeasureSpec.makeMeasureSpec(layoutParams.i, MeasureSpec.getMode(i));
        }
        return size < layoutParams.g ? MeasureSpec.makeMeasureSpec(layoutParams.g, MeasureSpec.getMode(i)) : i;
    }

    private void a(int i, int i2, int i3, int i4) {
        switch (i) {
            case 0:
            case 1:
                i = MeasureSpec.getMode(i3);
                i2 = MeasureSpec.getSize(i3);
                break;
            case 2:
            case 3:
                i = MeasureSpec.getMode(i2);
                i2 = MeasureSpec.getSize(i2);
                break;
            default:
                i3 = new StringBuilder("Invalid flex direction: ");
                i3.append(i);
                throw new IllegalArgumentException(i3.toString());
        }
        if (i == 1073741824) {
            i = getSumOfCrossSize() + i4;
            int i5 = 0;
            if (this.n.size() != 1) {
                if (this.n.size() >= 2 && i < i2) {
                    float f;
                    a aVar;
                    switch (this.e) {
                        case 1:
                            i2 -= i;
                            i = new a();
                            i.g = i2;
                            this.n.add(0, i);
                            break;
                        case 2:
                            i2 = (i2 - i) / 2;
                            i = new ArrayList();
                            i3 = new a();
                            i3.g = i2;
                            i2 = this.n.size();
                            while (i5 < i2) {
                                if (i5 == 0) {
                                    i.add(i3);
                                }
                                i.add((a) this.n.get(i5));
                                if (i5 == this.n.size() - 1) {
                                    i.add(i3);
                                }
                                i5++;
                            }
                            this.n = i;
                            return;
                        case 3:
                            i = ((float) (i2 - i)) / ((float) (this.n.size() - 1));
                            i2 = new ArrayList();
                            i3 = this.n.size();
                            f = 0.0f;
                            while (i5 < i3) {
                                i2.add((a) this.n.get(i5));
                                if (i5 != this.n.size() - 1) {
                                    a aVar2 = new a();
                                    if (i5 == this.n.size() - 2) {
                                        aVar2.g = Math.round(f + i);
                                        f = 0.0f;
                                    } else {
                                        aVar2.g = Math.round(i);
                                    }
                                    f += i - ((float) aVar2.g);
                                    if (f > 1.0f) {
                                        aVar2.g++;
                                        f -= 1.0f;
                                    } else if (f < -1.0f) {
                                        aVar2.g--;
                                        f += 1.0f;
                                    }
                                    i2.add(aVar2);
                                }
                                i5++;
                            }
                            this.n = i2;
                            return;
                        case 4:
                            i2 = (i2 - i) / (this.n.size() * 2);
                            i = new ArrayList();
                            i3 = new a();
                            i3.g = i2;
                            for (a aVar3 : this.n) {
                                i.add(i3);
                                i.add(aVar3);
                                i.add(i3);
                            }
                            this.n = i;
                            return;
                        case 5:
                            i = ((float) (i2 - i)) / ((float) this.n.size());
                            i2 = this.n.size();
                            i3 = 0;
                            while (i5 < i2) {
                                aVar3 = (a) this.n.get(i5);
                                f = ((float) aVar3.g) + i;
                                if (i5 == this.n.size() - 1) {
                                    f += i3;
                                    i3 = 0;
                                }
                                int round = Math.round(f);
                                i3 += f - ((float) round);
                                if (i3 > 1065353216) {
                                    round++;
                                    i3 -= 1065353216;
                                } else if (i3 < -1082130432) {
                                    round--;
                                    i3 += 1065353216;
                                }
                                aVar3.g = round;
                                i5++;
                            }
                            return;
                        default:
                            break;
                    }
                }
            }
            ((a) this.n.get(0)).g = i2 - i4;
        }
    }

    private void c(int i, int i2) {
        if (i2 == 4) {
            int i3 = 0;
            for (a aVar : this.n) {
                int i4 = i3;
                i3 = 0;
                while (i3 < aVar.h) {
                    View a = a(i4);
                    LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                    if (layoutParams.d == -1 || layoutParams.d == 4) {
                        switch (i) {
                            case 0:
                            case 1:
                                a(a, aVar.g);
                                break;
                            case 2:
                            case 3:
                                b(a, aVar.g);
                                break;
                            default:
                                StringBuilder stringBuilder = new StringBuilder("Invalid flex direction: ");
                                stringBuilder.append(i);
                                throw new IllegalArgumentException(stringBuilder.toString());
                        }
                    }
                    i3++;
                    i4++;
                }
                i3 = i4;
            }
            return;
        }
        for (a aVar2 : this.n) {
            for (Integer intValue : aVar2.m) {
                View a2 = a(intValue.intValue());
                switch (i) {
                    case 0:
                    case 1:
                        a(a2, aVar2.g);
                        break;
                    case 2:
                    case 3:
                        b(a2, aVar2.g);
                        break;
                    default:
                        stringBuilder = new StringBuilder("Invalid flex direction: ");
                        stringBuilder.append(i);
                        throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
        }
    }

    private static void a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(MeasureSpec.makeMeasureSpec(view.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(Math.max((i - layoutParams.topMargin) - layoutParams.bottomMargin, 0), 1073741824));
    }

    private static void b(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(MeasureSpec.makeMeasureSpec(Math.max((i - layoutParams.leftMargin) - layoutParams.rightMargin, 0), 1073741824), MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 1073741824));
    }

    private void b(int i, int i2, int i3, int i4) {
        int largestMainSize;
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        int mode2 = MeasureSpec.getMode(i3);
        int size2 = MeasureSpec.getSize(i3);
        switch (i) {
            case 0:
            case 1:
                i = (getSumOfCrossSize() + getPaddingTop()) + getPaddingBottom();
                largestMainSize = getLargestMainSize();
                break;
            case 2:
            case 3:
                i = getLargestMainSize();
                largestMainSize = (getSumOfCrossSize() + getPaddingLeft()) + getPaddingRight();
                break;
            default:
                i3 = new StringBuilder("Invalid flex direction: ");
                i3.append(i);
                throw new IllegalArgumentException(i3.toString());
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = ViewCompat.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            i2 = ViewCompat.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            i2 = ViewCompat.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode != 1073741824) {
            i2 = new StringBuilder("Unknown width mode is set: ");
            i2.append(mode);
            throw new IllegalStateException(i2.toString());
        } else {
            if (size < largestMainSize) {
                i4 = ViewCompat.combineMeasuredStates(i4, 16777216);
            }
            i2 = ViewCompat.resolveSizeAndState(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i) {
                i4 = ViewCompat.combineMeasuredStates(i4, 256);
                i = size2;
            }
            i = ViewCompat.resolveSizeAndState(i, i3, i4);
        } else if (mode2 == 0) {
            i = ViewCompat.resolveSizeAndState(i, i3, i4);
        } else if (mode2 != 1073741824) {
            i2 = new StringBuilder("Unknown height mode is set: ");
            i2.append(mode2);
            throw new IllegalStateException(i2.toString());
        } else {
            if (size2 < i) {
                i4 = ViewCompat.combineMeasuredStates(i4, 256);
            }
            i = ViewCompat.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(i2, i);
    }

    private boolean a(int i, int i2, int i3, int i4, LayoutParams layoutParams, int i5, int i6) {
        if (this.b == 0) {
            return false;
        }
        if (layoutParams.j != null) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        if (c(this.a) != 0) {
            if (d(i5, i6) != 0) {
                i4 += this.k;
            }
            if ((this.i & 4) > 0) {
                i4 += this.k;
            }
        } else {
            if (d(i5, i6) != 0) {
                i4 += this.j;
            }
            if ((this.h & 4) > 0) {
                i4 += this.j;
            }
        }
        if (i2 < i3 + i4) {
            return true;
        }
        return false;
    }

    private int getLargestMainSize() {
        int i = Integer.MIN_VALUE;
        for (a aVar : this.n) {
            i = Math.max(i, aVar.e);
        }
        return i;
    }

    private int getSumOfCrossSize() {
        int size = this.n.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            a aVar = (a) this.n.get(i);
            if (d(i)) {
                if (c(this.a)) {
                    i2 += this.j;
                } else {
                    i2 += this.k;
                }
            }
            if (e(i)) {
                if (c(this.a)) {
                    i2 += this.j;
                } else {
                    i2 += this.k;
                }
            }
            i2 += aVar.g;
            i++;
        }
        return i2;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        boolean z2 = false;
        switch (this.a) {
            case 0:
                a(layoutDirection == 1, i, i2, i3, i4);
                return;
            case 1:
                a(layoutDirection != 1, i, i2, i3, i4);
                return;
            case 2:
                if (layoutDirection == 1) {
                    z2 = true;
                }
                a(this.b == 2 ? z2 ^ 1 : z2, false, i, i2, i3, i4);
                return;
            case 3:
                if (layoutDirection == 1) {
                    z2 = true;
                }
                a(this.b == 2 ? z2 ^ 1 : z2, true, i, i2, i3, i4);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Invalid flex direction is set: ");
                stringBuilder.append(this.a);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private void a(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i5 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.n.size();
        int i6 = paddingTop;
        int i7 = 0;
        paddingTop = paddingBottom;
        paddingBottom = 0;
        while (paddingBottom < size) {
            float f;
            float f2;
            float f3;
            int i8;
            int i9;
            a aVar = (a) r0.n.get(paddingBottom);
            if (d(paddingBottom)) {
                paddingTop -= r0.j;
                i6 += r0.j;
            }
            switch (r0.c) {
                case 0:
                    f = (float) paddingLeft;
                    f2 = (float) (i5 - paddingRight);
                    break;
                case 1:
                    f = (float) ((i5 - aVar.e) + paddingRight);
                    f2 = (float) (aVar.e - paddingLeft);
                    break;
                case 2:
                    f = ((float) paddingLeft) + (((float) (i5 - aVar.e)) / 2.0f);
                    f2 = ((float) (i5 - paddingRight)) - (((float) (i5 - aVar.e)) / 2.0f);
                    break;
                case 3:
                    f = (float) paddingLeft;
                    int a = aVar.a();
                    f2 = ((float) (i5 - aVar.e)) / (a != 1 ? (float) (a - 1) : 1.0f);
                    f3 = (float) (i5 - paddingRight);
                    break;
                case 4:
                    int a2 = aVar.a();
                    f3 = a2 != 0 ? ((float) (i5 - aVar.e)) / ((float) a2) : 0.0f;
                    float f4 = f3 / 2.0f;
                    f = ((float) paddingLeft) + f4;
                    float f5 = f3;
                    f3 = ((float) (i5 - paddingRight)) - f4;
                    f2 = f5;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Invalid justifyContent is set: ");
                    stringBuilder.append(r0.c);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            f3 = f2;
            f2 = 0.0f;
            f2 = Math.max(f2, 0.0f);
            float f6 = f3;
            f3 = f;
            int i10 = i7;
            i7 = 0;
            while (i7 < aVar.h) {
                int i11;
                int i12;
                int i13;
                View a3 = a(i10);
                if (a3 != null) {
                    i11 = paddingLeft;
                    i8 = paddingRight;
                    if (a3.getVisibility() == 8) {
                        i10++;
                        i12 = paddingBottom;
                        i13 = i5;
                        i9 = size;
                    } else {
                        float f7;
                        View view;
                        LayoutParams layoutParams = (LayoutParams) a3.getLayoutParams();
                        f3 += (float) layoutParams.leftMargin;
                        f6 -= (float) layoutParams.rightMargin;
                        if (d(i10, i7)) {
                            f3 += (float) r0.k;
                            f6 -= (float) r0.k;
                        }
                        float f8 = f6;
                        f6 = f3;
                        i13 = i5;
                        if (r0.b != 2) {
                            i12 = paddingBottom;
                            i9 = size;
                            f7 = f6;
                            view = a3;
                            i5 = i10;
                            if (z) {
                                a(view, aVar, r0.b, r0.d, Math.round(f8) - view.getMeasuredWidth(), i6, Math.round(f8), i6 + view.getMeasuredHeight());
                            } else {
                                a(view, aVar, r0.b, r0.d, Math.round(f7), i6, Math.round(f7) + view.getMeasuredWidth(), i6 + view.getMeasuredHeight());
                            }
                        } else if (z) {
                            i9 = size;
                            f7 = f6;
                            i12 = paddingBottom;
                            view = a3;
                            int i14 = r0.b;
                            i5 = i10;
                            a(a3, aVar, i14, r0.d, Math.round(f8) - a3.getMeasuredWidth(), paddingTop - a3.getMeasuredHeight(), Math.round(f8), paddingTop);
                        } else {
                            i12 = paddingBottom;
                            i9 = size;
                            f7 = f6;
                            view = a3;
                            i5 = i10;
                            a(view, aVar, r0.b, r0.d, Math.round(f7), paddingTop - view.getMeasuredHeight(), Math.round(f7) + view.getMeasuredWidth(), paddingTop);
                        }
                        f6 = f7 + ((((float) view.getMeasuredWidth()) + f2) + ((float) layoutParams.rightMargin));
                        f8 -= (((float) view.getMeasuredWidth()) + f2) + ((float) layoutParams.leftMargin);
                        i10 = i5 + 1;
                        aVar.a = Math.min(aVar.a, view.getLeft() - layoutParams.leftMargin);
                        aVar.b = Math.min(aVar.b, view.getTop() - layoutParams.topMargin);
                        aVar.c = Math.max(aVar.c, view.getRight() + layoutParams.rightMargin);
                        aVar.d = Math.max(aVar.d, view.getBottom() + layoutParams.bottomMargin);
                        f3 = f6;
                        f6 = f8;
                    }
                } else {
                    i11 = paddingLeft;
                    i8 = paddingRight;
                    i12 = paddingBottom;
                    i13 = i5;
                    i9 = size;
                    i5 = i10;
                }
                i7++;
                paddingLeft = i11;
                paddingRight = i8;
                i5 = i13;
                size = i9;
                paddingBottom = i12;
            }
            i8 = paddingRight;
            i9 = size;
            i6 += aVar.g;
            paddingTop -= aVar.g;
            paddingBottom++;
            i7 = i10;
            paddingLeft = paddingLeft;
            i5 = i5;
        }
    }

    private static void a(View view, a aVar, int i, int i2, int i3, int i4, int i5, int i6) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.d != -1) {
            i2 = layoutParams.d;
        }
        int i7 = aVar.g;
        switch (i2) {
            case 0:
            case 4:
                if (i != 2) {
                    view.layout(i3, i4 + layoutParams.topMargin, i5, i6 + layoutParams.topMargin);
                    return;
                } else {
                    view.layout(i3, i4 - layoutParams.bottomMargin, i5, i6 - layoutParams.bottomMargin);
                    return;
                }
            case 1:
                if (i != 2) {
                    i4 += i7;
                    view.layout(i3, (i4 - view.getMeasuredHeight()) - layoutParams.bottomMargin, i5, i4 - layoutParams.bottomMargin);
                    return;
                }
                view.layout(i3, ((i4 - i7) + view.getMeasuredHeight()) + layoutParams.topMargin, i5, ((i6 - i7) + view.getMeasuredHeight()) + layoutParams.topMargin);
                return;
            case 2:
                i7 = (((i7 - view.getMeasuredHeight()) + layoutParams.topMargin) - layoutParams.bottomMargin) / 2;
                if (i == 2) {
                    i4 -= i7;
                    view.layout(i3, i4, i5, view.getMeasuredHeight() + i4);
                    break;
                }
                i4 += i7;
                view.layout(i3, i4, i5, view.getMeasuredHeight() + i4);
                return;
            case 3:
                if (i != 2) {
                    aVar = Math.max(aVar.l - view.getBaseline(), layoutParams.topMargin);
                    view.layout(i3, i4 + aVar, i5, i6 + aVar);
                    return;
                }
                aVar = Math.max((aVar.l - view.getMeasuredHeight()) + view.getBaseline(), layoutParams.bottomMargin);
                view.layout(i3, i4 - aVar, i5, i6 - aVar);
                return;
            default:
                break;
        }
    }

    private void a(boolean z, boolean z2, int i, int i2, int i3, int i4) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i5 = i4 - i2;
        int i6 = (i3 - i) - paddingRight;
        paddingRight = this.n.size();
        int i7 = i6;
        int i8 = 0;
        i6 = paddingLeft;
        paddingLeft = 0;
        while (paddingLeft < paddingRight) {
            float f;
            float f2;
            float f3;
            int i9;
            int i10;
            int i11;
            a aVar = (a) r0.n.get(paddingLeft);
            if (d(paddingLeft)) {
                i6 += r0.k;
                i7 -= r0.k;
            }
            switch (r0.c) {
                case 0:
                    f = (float) paddingTop;
                    f2 = (float) (i5 - paddingBottom);
                    break;
                case 1:
                    f = (float) ((i5 - aVar.e) + paddingBottom);
                    f2 = (float) (aVar.e - paddingTop);
                    break;
                case 2:
                    f = ((float) paddingTop) + (((float) (i5 - aVar.e)) / 2.0f);
                    f2 = ((float) (i5 - paddingBottom)) - (((float) (i5 - aVar.e)) / 2.0f);
                    break;
                case 3:
                    f = (float) paddingTop;
                    int a = aVar.a();
                    f2 = ((float) (i5 - aVar.e)) / (a != 1 ? (float) (a - 1) : 1.0f);
                    f3 = (float) (i5 - paddingBottom);
                    break;
                case 4:
                    int a2 = aVar.a();
                    f3 = a2 != 0 ? ((float) (i5 - aVar.e)) / ((float) a2) : 0.0f;
                    float f4 = f3 / 2.0f;
                    f = ((float) paddingTop) + f4;
                    float f5 = f3;
                    f3 = ((float) (i5 - paddingBottom)) - f4;
                    f2 = f5;
                    break;
                default:
                    StringBuilder stringBuilder = new StringBuilder("Invalid justifyContent is set: ");
                    stringBuilder.append(r0.c);
                    throw new IllegalStateException(stringBuilder.toString());
            }
            f3 = f2;
            f2 = 0.0f;
            f2 = Math.max(f2, 0.0f);
            float f6 = f3;
            f3 = f;
            int i12 = i8;
            i8 = 0;
            while (i8 < aVar.h) {
                int i13;
                int i14;
                View a3 = a(i12);
                int i15;
                if (a3 != null) {
                    i13 = paddingTop;
                    i9 = paddingBottom;
                    if (a3.getVisibility() == 8) {
                        i12++;
                        i10 = paddingRight;
                        i14 = paddingLeft;
                        i11 = i5;
                    } else {
                        float f7;
                        float f8;
                        View view;
                        LayoutParams layoutParams = (LayoutParams) a3.getLayoutParams();
                        f3 += (float) layoutParams.topMargin;
                        f6 -= (float) layoutParams.bottomMargin;
                        if (d(i12, i8)) {
                            f3 += (float) r0.j;
                            f6 -= (float) r0.j;
                        }
                        if (!z) {
                            i10 = paddingRight;
                            i14 = paddingLeft;
                            i11 = i5;
                            f7 = f3;
                            f8 = f6;
                            view = a3;
                            i15 = i12;
                            if (z2) {
                                a(view, aVar, false, r0.d, i6, Math.round(f8) - view.getMeasuredHeight(), i6 + view.getMeasuredWidth(), Math.round(f8));
                            } else {
                                a(view, aVar, false, r0.d, i6, Math.round(f7), i6 + view.getMeasuredWidth(), Math.round(f7) + view.getMeasuredHeight());
                            }
                        } else if (z2) {
                            i10 = paddingRight;
                            f7 = f3;
                            i11 = i5;
                            f8 = f6;
                            i14 = paddingLeft;
                            view = a3;
                            i15 = i12;
                            a(a3, aVar, true, r0.d, i7 - a3.getMeasuredWidth(), Math.round(f6) - a3.getMeasuredHeight(), i7, Math.round(f6));
                        } else {
                            i10 = paddingRight;
                            i14 = paddingLeft;
                            i11 = i5;
                            f7 = f3;
                            f8 = f6;
                            view = a3;
                            i15 = i12;
                            a(view, aVar, true, r0.d, i7 - view.getMeasuredWidth(), Math.round(f7), i7, Math.round(f7) + view.getMeasuredHeight());
                        }
                        f3 = f7 + ((((float) view.getMeasuredHeight()) + f2) + ((float) layoutParams.bottomMargin));
                        f6 = f8 - ((((float) view.getMeasuredHeight()) + f2) + ((float) layoutParams.topMargin));
                        i12 = i15 + 1;
                        aVar.a = Math.min(aVar.a, view.getLeft() - layoutParams.leftMargin);
                        aVar.b = Math.min(aVar.b, view.getTop() - layoutParams.topMargin);
                        aVar.c = Math.max(aVar.c, view.getRight() + layoutParams.rightMargin);
                        aVar.d = Math.max(aVar.d, view.getBottom() + layoutParams.bottomMargin);
                    }
                } else {
                    i13 = paddingTop;
                    i9 = paddingBottom;
                    i10 = paddingRight;
                    i14 = paddingLeft;
                    i11 = i5;
                    i15 = i12;
                }
                i8++;
                paddingTop = i13;
                paddingBottom = i9;
                paddingRight = i10;
                i5 = i11;
                paddingLeft = i14;
            }
            i9 = paddingBottom;
            i10 = paddingRight;
            i11 = i5;
            i6 += aVar.g;
            i7 -= aVar.g;
            paddingLeft++;
            paddingTop = paddingTop;
            i8 = i12;
        }
    }

    private static void a(View view, a aVar, boolean z, int i, int i2, int i3, int i4, int i5) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.d != -1) {
            i = layoutParams.d;
        }
        aVar = aVar.g;
        switch (i) {
            case 0:
            case 3:
            case 4:
                if (z) {
                    view.layout(i2 - layoutParams.rightMargin, i3, i4 - layoutParams.rightMargin, i5);
                    return;
                } else {
                    view.layout(i2 + layoutParams.leftMargin, i3, i4 + layoutParams.leftMargin, i5);
                    return;
                }
            case 1:
                if (z) {
                    view.layout(((i2 - aVar) + view.getMeasuredWidth()) + layoutParams.leftMargin, i3, ((i4 - aVar) + view.getMeasuredWidth()) + layoutParams.leftMargin, i5);
                    return;
                } else {
                    view.layout(((i2 + aVar) - view.getMeasuredWidth()) - layoutParams.rightMargin, i3, ((i4 + aVar) - view.getMeasuredWidth()) - layoutParams.rightMargin, i5);
                    return;
                }
            case 2:
                aVar = (((aVar - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(layoutParams)) - MarginLayoutParamsCompat.getMarginEnd(layoutParams)) / 2;
                if (z) {
                    view.layout(i2 - aVar, i3, i4 - aVar, i5);
                    break;
                } else {
                    view.layout(i2 + aVar, i3, i4 + aVar, i5);
                    return;
                }
            default:
                break;
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.g != null || this.f != null) {
            if (this.h != 0 || this.i != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                boolean z = false;
                boolean z2 = true;
                boolean z3;
                switch (this.a) {
                    case 0:
                        z3 = layoutDirection == 1;
                        if (this.b == 2) {
                            z = true;
                        }
                        a(canvas, z3, z);
                        return;
                    case 1:
                        z3 = layoutDirection != 1;
                        if (this.b == 2) {
                            z = true;
                        }
                        a(canvas, z3, z);
                        return;
                    case 2:
                        if (layoutDirection != 1) {
                            z2 = false;
                        }
                        if (this.b == 2) {
                            z2 ^= 1;
                        }
                        b(canvas, z2, false);
                        return;
                    case 3:
                        if (layoutDirection == 1) {
                            z = true;
                        }
                        if (this.b == 2) {
                            z ^= 1;
                        }
                        b(canvas, z, true);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        Canvas canvas2 = canvas;
        int paddingLeft = getPaddingLeft();
        int i = 0;
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.n.size();
        int i2 = 0;
        int i3 = i2;
        while (i2 < size) {
            a aVar = (a) r0.n.get(i2);
            int i4 = i3;
            for (i3 = i; i3 < aVar.h; i3++) {
                View a = a(i4);
                if (!(a == null || a.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                    if (d(i4, i3)) {
                        int right;
                        if (z) {
                            right = a.getRight() + layoutParams.rightMargin;
                        } else {
                            right = (a.getLeft() - layoutParams.leftMargin) - r0.k;
                        }
                        a(canvas2, right, aVar.b, aVar.g);
                    }
                    if (i3 == aVar.h - 1 && (r0.i & 4) > 0) {
                        if (z) {
                            i = (a.getLeft() - layoutParams.leftMargin) - r0.k;
                        } else {
                            i = a.getRight() + layoutParams.rightMargin;
                        }
                        a(canvas2, i, aVar.b, aVar.g);
                    }
                    i4++;
                }
            }
            if (d(i2)) {
                if (z2) {
                    i = aVar.d;
                } else {
                    i = aVar.b - r0.j;
                }
                b(canvas2, paddingLeft, i, max);
            }
            if (e(i2) && (r0.h & 4) > 0) {
                if (z2) {
                    i = aVar.b - r0.j;
                } else {
                    i = aVar.d;
                }
                b(canvas2, paddingLeft, i, max);
            }
            i2++;
            i3 = i4;
            i = 0;
        }
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        Canvas canvas2 = canvas;
        int paddingTop = getPaddingTop();
        int i = 0;
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.n.size();
        int i2 = 0;
        int i3 = i2;
        while (i2 < size) {
            a aVar = (a) r0.n.get(i2);
            int i4 = i3;
            for (i3 = i; i3 < aVar.h; i3++) {
                View a = a(i4);
                if (!(a == null || a.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) a.getLayoutParams();
                    if (d(i4, i3)) {
                        int bottom;
                        if (z2) {
                            bottom = a.getBottom() + layoutParams.bottomMargin;
                        } else {
                            bottom = (a.getTop() - layoutParams.topMargin) - r0.j;
                        }
                        b(canvas2, aVar.a, bottom, aVar.g);
                    }
                    if (i3 == aVar.h - 1 && (r0.h & 4) > 0) {
                        if (z2) {
                            i = (a.getTop() - layoutParams.topMargin) - r0.j;
                        } else {
                            i = a.getBottom() + layoutParams.bottomMargin;
                        }
                        b(canvas2, aVar.a, i, aVar.g);
                    }
                    i4++;
                }
            }
            if (d(i2)) {
                if (z) {
                    i = aVar.c;
                } else {
                    i = aVar.a - r0.k;
                }
                a(canvas2, i, paddingTop, max);
            }
            if (e(i2) && (r0.i & 4) > 0) {
                if (z) {
                    i = aVar.a - r0.k;
                } else {
                    i = aVar.c;
                }
                a(canvas2, i, paddingTop, max);
            }
            i2++;
            i3 = i4;
            i = 0;
        }
    }

    private void a(Canvas canvas, int i, int i2, int i3) {
        if (this.g != null) {
            this.g.setBounds(i, i2, this.k + i, i3 + i2);
            this.g.draw(canvas);
        }
    }

    private void b(Canvas canvas, int i, int i2, int i3) {
        if (this.f != null) {
            this.f.setBounds(i, i2, i3 + i, this.j + i2);
            this.f.draw(canvas);
        }
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getFlexDirection() {
        return this.a;
    }

    public void setFlexDirection(int i) {
        if (this.a != i) {
            this.a = i;
            requestLayout();
        }
    }

    public int getFlexWrap() {
        return this.b;
    }

    public void setFlexWrap(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.c;
    }

    public void setJustifyContent(int i) {
        if (this.c != i) {
            this.c = i;
            requestLayout();
        }
    }

    public int getAlignItems() {
        return this.d;
    }

    public void setAlignItems(int i) {
        if (this.d != i) {
            this.d = i;
            requestLayout();
        }
    }

    public int getAlignContent() {
        return this.e;
    }

    public void setAlignContent(int i) {
        if (this.e != i) {
            this.e = i;
            requestLayout();
        }
    }

    public List<a> getFlexLines() {
        List<a> arrayList = new ArrayList(this.n.size());
        for (a aVar : this.n) {
            if (aVar.a() != 0) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f;
    }

    public Drawable getDividerDrawableVertical() {
        return this.g;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.f) {
            this.f = drawable;
            if (drawable != null) {
                this.j = drawable.getIntrinsicHeight();
            } else {
                this.j = null;
            }
            a();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.g) {
            this.g = drawable;
            if (drawable != null) {
                this.k = drawable.getIntrinsicWidth();
            } else {
                this.k = null;
            }
            a();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.i;
    }

    public int getShowDividerHorizontal() {
        return this.h;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.i) {
            this.i = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.h) {
            this.h = i;
            requestLayout();
        }
    }

    private void a() {
        if (this.f == null && this.g == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean d(int i) {
        if (i >= 0) {
            if (i < this.n.size()) {
                for (int i2 = 0; i2 < i; i2++) {
                    if (((a) this.n.get(i2)).a() > 0) {
                        i = 0;
                        break;
                    }
                }
                i = 1;
                if (i != 0) {
                    if (c(this.a) != 0) {
                        if ((this.h & 1) != 0) {
                            return true;
                        }
                        return false;
                    } else if ((this.i & 1) != 0) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (c(this.a) != 0) {
                    if ((this.h & 2) != 0) {
                        return true;
                    }
                    return false;
                } else if ((this.i & 2) != 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    private boolean e(int i) {
        if (i >= 0) {
            if (i < this.n.size()) {
                for (i++; i < this.n.size(); i++) {
                    if (((a) this.n.get(i)).a() > 0) {
                        return false;
                    }
                }
                return c(this.a) != 0 ? (this.h & 4) != 0 : (this.i & 4) != 0;
            }
        }
        return false;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        int childCount = getChildCount();
        List b = b(childCount);
        a aVar = new a();
        if (view == null || !(layoutParams instanceof LayoutParams)) {
            aVar.b = 1;
        } else {
            aVar.b = ((LayoutParams) layoutParams).a;
        }
        if (i != -1) {
            if (i != childCount) {
                if (i < getChildCount()) {
                    aVar.a = i;
                    for (int i2 = i; i2 < childCount; i2++) {
                        a aVar2 = (a) b.get(i2);
                        aVar2.a++;
                    }
                } else {
                    aVar.a = childCount;
                }
                b.add(aVar);
                this.l = a(childCount + 1, b);
                super.addView(view, i, layoutParams);
            }
        }
        aVar.a = childCount;
        b.add(aVar);
        this.l = a(childCount + 1, b);
        super.addView(view, i, layoutParams);
    }

    private boolean d(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View a = a(i - i3);
            if (a != null && a.getVisibility() != 8) {
                i = 0;
                break;
            }
        }
        i = 1;
        return i != 0 ? c(this.a) != 0 ? (this.i & 1) != 0 : (this.h & 1) != 0 : c(this.a) != 0 ? (this.i & 2) != 0 : (this.h & 2) != 0;
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
