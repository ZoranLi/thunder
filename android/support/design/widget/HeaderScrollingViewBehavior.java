package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.math.MathUtils;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

abstract class HeaderScrollingViewBehavior extends ViewOffsetBehavior<View> {
    private int mOverlayTop;
    final Rect mTempRect1 = new Rect();
    final Rect mTempRect2 = new Rect();
    private int mVerticalLayoutGap = 0;

    private static int resolveGravity(int i) {
        return i == 0 ? 8388659 : i;
    }

    abstract View findFirstDependency(List<View> list);

    float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        HeaderScrollingViewBehavior headerScrollingViewBehavior = this;
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                View view2;
                if (!ViewCompat.getFitsSystemWindows(findFirstDependency) || ViewCompat.getFitsSystemWindows(view)) {
                    view2 = view;
                } else {
                    view2 = view;
                    ViewCompat.setFitsSystemWindows(view2, true);
                    if (ViewCompat.getFitsSystemWindows(view2)) {
                        view2.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.onMeasureChild(view2, i, i2, MeasureSpec.makeMeasureSpec((size - findFirstDependency.getMeasuredHeight()) + getScrollRange(findFirstDependency), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    protected void layoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
        View findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
        if (findFirstDependency != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = this.mTempRect1;
            rect.set(coordinatorLayout.getPaddingLeft() + layoutParams.leftMargin, findFirstDependency.getBottom() + layoutParams.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - layoutParams.rightMargin, ((coordinatorLayout.getHeight() + findFirstDependency.getBottom()) - coordinatorLayout.getPaddingBottom()) - layoutParams.bottomMargin);
            WindowInsetsCompat lastWindowInsets = coordinatorLayout.getLastWindowInsets();
            if (!(lastWindowInsets == null || ViewCompat.getFitsSystemWindows(coordinatorLayout) == null || ViewCompat.getFitsSystemWindows(view) != null)) {
                rect.left += lastWindowInsets.getSystemWindowInsetLeft();
                rect.right -= lastWindowInsets.getSystemWindowInsetRight();
            }
            coordinatorLayout = this.mTempRect2;
            GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, coordinatorLayout, i);
            i = getOverlapPixelsForOffset(findFirstDependency);
            view.layout(coordinatorLayout.left, coordinatorLayout.top - i, coordinatorLayout.right, coordinatorLayout.bottom - i);
            this.mVerticalLayoutGap = coordinatorLayout.top - findFirstDependency.getBottom();
            return;
        }
        super.layoutChild(coordinatorLayout, view, i);
        this.mVerticalLayoutGap = null;
    }

    final int getOverlapPixelsForOffset(View view) {
        return this.mOverlayTop == 0 ? 0 : MathUtils.clamp((int) (getOverlapRatioForOffset(view) * ((float) this.mOverlayTop)), 0, this.mOverlayTop);
    }

    int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    final int getVerticalLayoutGap() {
        return this.mVerticalLayoutGap;
    }

    public final void setOverlayTop(int i) {
        this.mOverlayTop = i;
    }

    public final int getOverlayTop() {
        return this.mOverlayTop;
    }
}
