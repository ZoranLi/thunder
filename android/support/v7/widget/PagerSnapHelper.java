package android.support.v7.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.SmoothScroller.Action;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.DisplayMetrics;
import android.view.View;

public class PagerSnapHelper extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    @Nullable
    private OrientationHelper mHorizontalHelper;
    @Nullable
    private OrientationHelper mVerticalHelper;

    @Nullable
    public int[] calculateDistanceToFinalSnap(@NonNull LayoutManager layoutManager, @NonNull View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToCenter(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Nullable
    public View findSnapView(LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findCenterView(layoutManager, getVerticalHelper(layoutManager));
        }
        return layoutManager.canScrollHorizontally() ? findCenterView(layoutManager, getHorizontalHelper(layoutManager)) : null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findTargetSnapPosition(android.support.v7.widget.RecyclerView.LayoutManager r6, int r7, int r8) {
        /*
        r5 = this;
        r0 = r6.getItemCount();
        r1 = -1;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = 0;
        r3 = r6.canScrollVertically();
        if (r3 == 0) goto L_0x0018;
    L_0x000f:
        r2 = r5.getVerticalHelper(r6);
        r2 = r5.findStartView(r6, r2);
        goto L_0x0026;
    L_0x0018:
        r3 = r6.canScrollHorizontally();
        if (r3 == 0) goto L_0x0026;
    L_0x001e:
        r2 = r5.getHorizontalHelper(r6);
        r2 = r5.findStartView(r6, r2);
    L_0x0026:
        if (r2 != 0) goto L_0x0029;
    L_0x0028:
        return r1;
    L_0x0029:
        r2 = r6.getPosition(r2);
        if (r2 != r1) goto L_0x0030;
    L_0x002f:
        return r1;
    L_0x0030:
        r1 = r6.canScrollHorizontally();
        r3 = 0;
        r4 = 1;
        if (r1 == 0) goto L_0x003e;
    L_0x0038:
        if (r7 <= 0) goto L_0x003c;
    L_0x003a:
        r7 = r4;
        goto L_0x0041;
    L_0x003c:
        r7 = r3;
        goto L_0x0041;
    L_0x003e:
        if (r8 <= 0) goto L_0x003c;
    L_0x0040:
        goto L_0x003a;
    L_0x0041:
        r8 = r6 instanceof android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
        if (r8 == 0) goto L_0x005c;
    L_0x0045:
        r6 = (android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider) r6;
        r0 = r0 - r4;
        r6 = r6.computeScrollVectorForPosition(r0);
        if (r6 == 0) goto L_0x005c;
    L_0x004e:
        r8 = r6.x;
        r0 = 0;
        r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
        if (r8 < 0) goto L_0x005b;
    L_0x0055:
        r6 = r6.y;
        r6 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r6 >= 0) goto L_0x005c;
    L_0x005b:
        r3 = r4;
    L_0x005c:
        if (r3 == 0) goto L_0x0062;
    L_0x005e:
        if (r7 == 0) goto L_0x0061;
    L_0x0060:
        r2 = r2 - r4;
    L_0x0061:
        return r2;
    L_0x0062:
        if (r7 == 0) goto L_0x0065;
    L_0x0064:
        r2 = r2 + r4;
    L_0x0065:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.PagerSnapHelper.findTargetSnapPosition(android.support.v7.widget.RecyclerView$LayoutManager, int, int):int");
    }

    protected LinearSmoothScroller createSnapScroller(LayoutManager layoutManager) {
        if ((layoutManager instanceof ScrollVectorProvider) == null) {
            return null;
        }
        return new LinearSmoothScroller(this.mRecyclerView.getContext()) {
            protected void onTargetFound(View view, State state, Action action) {
                view = PagerSnapHelper.this.calculateDistanceToFinalSnap(PagerSnapHelper.this.mRecyclerView.getLayoutManager(), view);
                state = view[null];
                view = view[1];
                int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(state), Math.abs(view)));
                if (calculateTimeForDeceleration > 0) {
                    action.update(state, view, calculateTimeForDeceleration, this.mDecelerateInterpolator);
                }
            }

            protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            protected int calculateTimeForScrolling(int i) {
                return Math.min(100, super.calculateTimeForScrolling(i));
            }
        };
    }

    private int distanceToCenter(@NonNull LayoutManager layoutManager, @NonNull View view, OrientationHelper orientationHelper) {
        int decoratedStart = orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) / 2);
        if (layoutManager.getClipToPadding() != null) {
            layoutManager = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            layoutManager = orientationHelper.getEnd() / 2;
        }
        return decoratedStart - layoutManager;
    }

    @Nullable
    private View findCenterView(LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int startAfterPadding;
        if (layoutManager.getClipToPadding()) {
            startAfterPadding = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() / 2);
        } else {
            startAfterPadding = orientationHelper.getEnd() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int abs = Math.abs((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) / 2)) - startAfterPadding);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    @Nullable
    private View findStartView(LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int childCount = layoutManager.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = layoutManager.getChildAt(i2);
            int decoratedStart = orientationHelper.getDecoratedStart(childAt);
            if (decoratedStart < i) {
                view = childAt;
                i = decoratedStart;
            }
        }
        return view;
    }

    @NonNull
    private OrientationHelper getVerticalHelper(@NonNull LayoutManager layoutManager) {
        if (this.mVerticalHelper == null || this.mVerticalHelper.mLayoutManager != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    @NonNull
    private OrientationHelper getHorizontalHelper(@NonNull LayoutManager layoutManager) {
        if (this.mHorizontalHelper == null || this.mHorizontalHelper.mLayoutManager != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }
}
