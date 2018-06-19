package com.xunlei.downloadprovider.vod.recordpublish.flowlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.view.InputDeviceCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewDebug.IntToString;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    List<a> a = new ArrayList();
    private final LayoutConfiguration b;
    private boolean c = false;

    public static class LayoutParams extends MarginLayoutParams {
        public boolean a = false;
        @ExportedProperty(mapping = {@IntToString(from = 0, to = "NONE"), @IntToString(from = 48, to = "TOP"), @IntToString(from = 80, to = "BOTTOM"), @IntToString(from = 3, to = "LEFT"), @IntToString(from = 5, to = "RIGHT"), @IntToString(from = 16, to = "CENTER_VERTICAL"), @IntToString(from = 112, to = "FILL_VERTICAL"), @IntToString(from = 1, to = "CENTER_HORIZONTAL"), @IntToString(from = 7, to = "FILL_HORIZONTAL"), @IntToString(from = 17, to = "CENTER"), @IntToString(from = 119, to = "FILL")})
        public int b = 0;
        public float c = -1.0f;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;
        private int j;
        private int k;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.XlpsFlowLayout_LayoutParams);
            try {
                this.a = context.getBoolean(1, false);
                this.b = context.getInt(0, 0);
                this.c = context.getFloat(2, -1.0f);
            } finally {
                context.recycle();
            }
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        final void a(int i, int i2) {
            this.j = i;
            this.k = i2;
        }
    }

    public FlowLayout(Context context) {
        super(context);
        this.b = new LayoutConfiguration(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new LayoutConfiguration(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        a aVar;
        int i3 = i;
        int i4 = i2;
        int size = (MeasureSpec.getSize(i) - getPaddingRight()) - getPaddingLeft();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int i5 = this.b.a == 0 ? size : size2;
        if (r0.b.a == 0) {
            size = size2;
        }
        if (r0.b.a != 0) {
            mode = mode2;
        }
        r0.a.clear();
        a aVar2 = new a(i5, r0.b);
        r0.a.add(aVar2);
        int childCount = getChildCount();
        a aVar3 = aVar2;
        size2 = 0;
        int i6 = 0;
        while (size2 < childCount) {
            LayoutParams layoutParams;
            int i7;
            i6 = size2 + 1;
            View childAt = getChildAt(size2);
            if (childAt.getVisibility() != 8) {
                Object obj;
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                childAt.measure(getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), layoutParams.width), getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom(), layoutParams.height));
                i7 = r0.b.g;
                int i8 = r0.b.h;
                layoutParams.d = i7;
                layoutParams.e = i8;
                if (r0.b.a == 0) {
                    layoutParams.g = childAt.getMeasuredWidth();
                    layoutParams.h = childAt.getMeasuredHeight();
                } else {
                    layoutParams.g = childAt.getMeasuredHeight();
                    layoutParams.h = childAt.getMeasuredWidth();
                }
                if (!layoutParams.a) {
                    if (mode != 0) {
                        if (aVar3.b.a == 0) {
                            i7 = childAt.getMeasuredWidth();
                        } else {
                            i7 = childAt.getMeasuredHeight();
                        }
                        if ((aVar3.f + i7 <= aVar3.c ? 1 : null) == null) {
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        if (r0.a.size() <= 0 && r0.b.f == r0.a.size()) {
                            i6--;
                            break;
                        }
                        aVar3 = new a(i5, r0.b);
                        if (r0.b.a == 1 || r0.b.e != 1) {
                            r0.a.add(aVar3);
                        } else {
                            r0.a.add(0, aVar3);
                        }
                    }
                    if (r0.b.a == 0 || r0.b.e != 1) {
                        aVar3.a(aVar3.a.size(), childAt);
                    } else {
                        aVar3.a(0, childAt);
                    }
                }
                obj = 1;
                if (obj != null) {
                    if (r0.a.size() <= 0) {
                    }
                    aVar3 = new a(i5, r0.b);
                    if (r0.b.a == 1) {
                    }
                    r0.a.add(aVar3);
                }
                if (r0.b.a == 0) {
                }
                aVar3.a(aVar3.a.size(), childAt);
            }
            size2 = i6;
        }
        r0.c = i6 < childCount;
        if (i6 < childCount) {
            removeViews(i6, childCount - i6);
        }
        childCount = 0;
        for (a aVar4 : r0.a) {
            aVar4.a(childCount);
            childCount += aVar4.g;
            i6 = 0;
            for (View layoutParams2 : aVar4.a) {
                layoutParams = (LayoutParams) layoutParams2.getLayoutParams();
                layoutParams.f = i6;
                i6 += layoutParams.g + layoutParams.d;
            }
        }
        childCount = 0;
        for (a aVar42 : r0.a) {
            childCount = Math.max(childCount, aVar42.d);
        }
        size2 = aVar3.h + aVar3.e;
        mode = a(mode, i5, childCount);
        size = a(mode2, size, size2);
        List<a> list = r0.a;
        i5 = list.size();
        if (i5 > 0) {
            aVar42 = (a) list.get(i5 - 1);
            size -= aVar42.e + aVar42.h;
            i7 = 0;
            for (a aVar32 : list) {
                i6 = getGravity();
                int round = Math.round((float) ((size * 1) / i5));
                i8 = aVar32.d;
                int i9 = aVar32.e;
                Rect rect = new Rect();
                rect.top = i7;
                int i10 = size;
                rect.left = 0;
                rect.right = mode;
                rect.bottom = (i9 + round) + i7;
                Rect rect2 = new Rect();
                Gravity.apply(i6, i8, i9, rect, rect2);
                i7 += round;
                aVar32.i += rect2.left;
                aVar32.a(rect2.top);
                i6 = rect2.width();
                int i11 = aVar32.f - aVar32.d;
                aVar32.d = i6;
                aVar32.f = i6 + i11;
                size = rect2.height();
                i6 = aVar32.g - aVar32.e;
                aVar32.g = size;
                aVar32.e = size - i6;
                size = i10;
            }
        }
        for (a aVar5 : r0.a) {
            b(aVar5);
            a(aVar5);
        }
        size = getPaddingLeft() + getPaddingRight();
        mode = getPaddingBottom() + getPaddingTop();
        if (r0.b.a == 0) {
            size += childCount;
            mode += size2;
        } else {
            size += size2;
            mode += childCount;
        }
        setMeasuredDimension(resolveSize(size, i3), resolveSize(mode, i4));
    }

    private static int a(int i, int i2, int i3) {
        if (i != Integer.MIN_VALUE) {
            return (i == 0 || i != 1073741824) ? i3 : i2;
        } else {
            return Math.min(i3, i2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = getChildCount();
        for (boolean z2 = false; z2 < z; z2++) {
            i2 = getChildAt(z2);
            LayoutParams layoutParams = (LayoutParams) i2.getLayoutParams();
            i2.layout(layoutParams.j + layoutParams.leftMargin, layoutParams.k + layoutParams.topMargin, (layoutParams.j + layoutParams.leftMargin) + i2.getMeasuredWidth(), (layoutParams.k + layoutParams.topMargin) + i2.getMeasuredHeight());
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild = super.drawChild(canvas, view, j);
        if (this.b.b) {
            float right;
            float top;
            float f;
            Paint paint;
            float f2;
            Paint a = a((int) InputDeviceCompat.SOURCE_ANY);
            Paint a2 = a((int) SupportMenu.CATEGORY_MASK);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.rightMargin > 0) {
                right = (float) view.getRight();
                top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                f = top;
                paint = a;
                canvas.drawLine(right, top, right + ((float) layoutParams.rightMargin), f, paint);
                canvas.drawLine((((float) layoutParams.rightMargin) + right) - 4.0f, top - 4.0f, right + ((float) layoutParams.rightMargin), f, paint);
                canvas.drawLine((((float) layoutParams.rightMargin) + right) - 4.0f, top + 4.0f, right + ((float) layoutParams.rightMargin), f, paint);
            }
            if (layoutParams.leftMargin > 0) {
                right = (float) view.getLeft();
                top = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                f = top;
                paint = a;
                canvas.drawLine(right, top, right - ((float) layoutParams.leftMargin), f, paint);
                canvas.drawLine((right - ((float) layoutParams.leftMargin)) + 4.0f, top - 4.0f, right - ((float) layoutParams.leftMargin), f, paint);
                canvas.drawLine((right - ((float) layoutParams.leftMargin)) + 4.0f, top + 4.0f, right - ((float) layoutParams.leftMargin), f, paint);
            }
            if (layoutParams.bottomMargin > 0) {
                right = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                top = (float) view.getBottom();
                f2 = right;
                paint = a;
                canvas.drawLine(right, top, f2, top + ((float) layoutParams.bottomMargin), paint);
                canvas.drawLine(right - 4.0f, (((float) layoutParams.bottomMargin) + top) - 4.0f, f2, top + ((float) layoutParams.bottomMargin), paint);
                canvas.drawLine(right + 4.0f, (((float) layoutParams.bottomMargin) + top) - 4.0f, f2, top + ((float) layoutParams.bottomMargin), paint);
            }
            if (layoutParams.topMargin > 0) {
                right = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                top = (float) view.getTop();
                f2 = right;
                paint = a;
                canvas.drawLine(right, top, f2, top - ((float) layoutParams.topMargin), paint);
                canvas.drawLine(right - 4.0f, (top - ((float) layoutParams.topMargin)) + 4.0f, f2, top - ((float) layoutParams.topMargin), paint);
                canvas.drawLine(right + 4.0f, (top - ((float) layoutParams.topMargin)) + 4.0f, f2, top - ((float) layoutParams.topMargin), paint);
            }
            if (layoutParams.a) {
                float top2;
                if (r0.b.a == 0) {
                    f = (float) view.getLeft();
                    top2 = ((float) view.getTop()) + (((float) view.getHeight()) / 2.0f);
                    canvas.drawLine(f, top2 - 6.0f, f, top2 + 6.0f, a2);
                } else {
                    top2 = ((float) view.getLeft()) + (((float) view.getWidth()) / 2.0f);
                    float top3 = (float) view.getTop();
                    canvas.drawLine(top2 - 6.0f, top3, top2 + 6.0f, top3, a2);
                }
            }
        }
        return drawChild;
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    private static Paint a(int i) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(1073741824);
        return paint;
    }

    public int getOrientation() {
        return this.b.a;
    }

    public void setOrientation(int i) {
        this.b.a(i);
        requestLayout();
    }

    public void setDebugDraw(boolean z) {
        this.b.b = z;
        invalidate();
    }

    public float getWeightDefault() {
        return this.b.c;
    }

    public void setWeightDefault(float f) {
        this.b.a(f);
        requestLayout();
    }

    public int getGravity() {
        return this.b.d;
    }

    public void setGravity(int i) {
        this.b.b(i);
        requestLayout();
    }

    public int getLayoutDirection() {
        if (this.b == null) {
            return 0;
        }
        return this.b.e;
    }

    public void setLayoutDirection(int i) {
        this.b.c(i);
        requestLayout();
    }

    private void a(a aVar) {
        for (View view : aVar.a) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (this.b.a == 0) {
                layoutParams.a((getPaddingLeft() + aVar.i) + layoutParams.f, (getPaddingTop() + aVar.h) + layoutParams.i);
                view.measure(MeasureSpec.makeMeasureSpec(layoutParams.g, 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.h, 1073741824));
            } else {
                layoutParams.a((getPaddingLeft() + aVar.h) + layoutParams.i, (getPaddingTop() + aVar.i) + layoutParams.f);
                view.measure(MeasureSpec.makeMeasureSpec(layoutParams.h, 1073741824), MeasureSpec.makeMeasureSpec(layoutParams.g, 1073741824));
            }
        }
    }

    private void b(a aVar) {
        int size = aVar.a.size();
        if (size > 0) {
            float f = 0.0f;
            for (View layoutParams : aVar.a) {
                f += a((LayoutParams) layoutParams.getLayoutParams());
            }
            LayoutParams layoutParams2 = (LayoutParams) ((View) aVar.a.get(size - 1)).getLayoutParams();
            int i = aVar.d - (layoutParams2.g + layoutParams2.f);
            int i2 = 0;
            for (View layoutParams3 : aVar.a) {
                int i3;
                LayoutParams layoutParams4 = (LayoutParams) layoutParams3.getLayoutParams();
                float a = a(layoutParams4);
                if ((layoutParams4.b != 0 ? 1 : 0) != 0) {
                    i3 = layoutParams4.b;
                } else {
                    i3 = this.b.d;
                }
                int round = Math.round((((float) i) * a) / f);
                int i4 = layoutParams4.g + layoutParams4.d;
                int i5 = layoutParams4.h + layoutParams4.e;
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = i2;
                rect.right = (i4 + round) + i2;
                rect.bottom = aVar.e;
                Rect rect2 = new Rect();
                Gravity.apply(i3, i4, i5, rect, rect2);
                i2 += round;
                layoutParams4.f = rect2.left + layoutParams4.f;
                layoutParams4.i = rect2.top;
                layoutParams4.g = rect2.width() - layoutParams4.d;
                layoutParams4.h = rect2.height() - layoutParams4.e;
            }
        }
    }

    private float a(LayoutParams layoutParams) {
        if ((layoutParams.c >= 0.0f ? 1 : null) != null) {
            return layoutParams.c;
        }
        return this.b.c;
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public /* synthetic */ android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
