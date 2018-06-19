package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout.DefaultBehavior;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@DefaultBehavior(Behavior.class)
public class AppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private boolean mCollapsed;
    private boolean mCollapsible;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    private boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private List<OnOffsetChangedListener> mListeners;
    private int mPendingAction;
    private int[] mTmpStatesArray;
    private int mTotalScrollRange;

    public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
        static final int COLLAPSIBLE_FLAGS = 10;
        static final int FLAG_QUICK_RETURN = 5;
        static final int FLAG_SNAP = 17;
        public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
        public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
        public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
        public static final int SCROLL_FLAG_SCROLL = 1;
        public static final int SCROLL_FLAG_SNAP = 16;
        int mScrollFlags = 1;
        Interpolator mScrollInterpolator;

        @RestrictTo({Scope.LIBRARY_GROUP})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ScrollFlags {
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout_Layout);
            this.mScrollFlags = attributeSet.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (attributeSet.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.mScrollInterpolator = AnimationUtils.loadInterpolator(context, attributeSet.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            attributeSet.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(android.widget.LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @RequiresApi(19)
        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.mScrollFlags = layoutParams.mScrollFlags;
            this.mScrollInterpolator = layoutParams.mScrollInterpolator;
        }

        public void setScrollFlags(int i) {
            this.mScrollFlags = i;
        }

        public int getScrollFlags() {
            return this.mScrollFlags;
        }

        public void setScrollInterpolator(Interpolator interpolator) {
            this.mScrollInterpolator = interpolator;
        }

        public Interpolator getScrollInterpolator() {
            return this.mScrollInterpolator;
        }

        boolean isCollapsible() {
            return (this.mScrollFlags & 1) == 1 && (this.mScrollFlags & 10) != 0;
        }
    }

    public interface OnOffsetChangedListener {
        void onOffsetChanged(AppBarLayout appBarLayout, int i);
    }

    public static class Behavior extends HeaderBehavior<AppBarLayout> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout = -1;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private DragCallback mOnDragCallback;

        public static abstract class DragCallback {
            public abstract boolean canDrag(@NonNull AppBarLayout appBarLayout);
        }

        protected static class SavedState extends AbsSavedState {
            public static final Creator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
                public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new SavedState(parcel, classLoader);
                }

                public final SavedState createFromParcel(Parcel parcel) {
                    return new SavedState(parcel, null);
                }

                public final SavedState[] newArray(int i) {
                    return new SavedState[i];
                }
            };
            boolean firstVisibleChildAtMinimumHeight;
            int firstVisibleChildIndex;
            float firstVisibleChildPercentageShown;

            public SavedState(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.firstVisibleChildIndex = parcel.readInt();
                this.firstVisibleChildPercentageShown = parcel.readFloat();
                this.firstVisibleChildAtMinimumHeight = parcel.readByte() != null ? true : null;
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }

            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.firstVisibleChildIndex);
                parcel.writeFloat(this.firstVisibleChildPercentageShown);
                parcel.writeByte((byte) this.firstVisibleChildAtMinimumHeight);
            }
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
        }

        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, View view2, int i, int i2) {
            coordinatorLayout = ((i & 2) == null || appBarLayout.hasScrollableChildren() == null || coordinatorLayout.getHeight() - view.getHeight() > appBarLayout.getHeight()) ? null : true;
            if (!(coordinatorLayout == null || this.mOffsetAnimator == null)) {
                this.mOffsetAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return coordinatorLayout;
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            if (i2 != 0) {
                if (i2 < 0) {
                    view = -appBarLayout.getTotalScrollRange();
                    i = appBarLayout.getDownNestedPreScrollRange() + view;
                } else {
                    view = -appBarLayout.getUpNestedPreScrollRange();
                    i = 0;
                }
                int i4 = view;
                int i5 = i;
                if (i4 != i5) {
                    iArr[1] = scroll(coordinatorLayout, appBarLayout, i2, i4, i5);
                }
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                scroll(coordinatorLayout, appBarLayout, i4, -appBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
            if (i == 0) {
                snapToChildIfNeeded(coordinatorLayout, appBarLayout);
            }
            this.mLastNestedScrollingChildRef = new WeakReference(view);
        }

        public void setDragCallback(@Nullable DragCallback dragCallback) {
            this.mOnDragCallback = dragCallback;
        }

        private void animateOffsetTo(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, float f) {
            int round;
            int abs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            f = Math.abs(f);
            if (f > 0.0f) {
                round = 3 * Math.round(1000.0f * (((float) abs) / f));
            } else {
                round = (int) (((((float) abs) / ((float) appBarLayout.getHeight())) + 1.0f) * 150.0f);
            }
            animateOffsetWithDuration(coordinatorLayout, appBarLayout, i, round);
        }

        private void animateOffsetWithDuration(final CoordinatorLayout coordinatorLayout, final AppBarLayout appBarLayout, int i, int i2) {
            if (getTopBottomOffsetForScrollingSibling() == i) {
                if (!(this.mOffsetAnimator == null || this.mOffsetAnimator.isRunning() == null)) {
                    this.mOffsetAnimator.cancel();
                }
                return;
            }
            if (this.mOffsetAnimator == null) {
                this.mOffsetAnimator = new ValueAnimator();
                this.mOffsetAnimator.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
                this.mOffsetAnimator.addUpdateListener(new AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Behavior.this.setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, ((Integer) valueAnimator.getAnimatedValue()).intValue());
                    }
                });
            } else {
                this.mOffsetAnimator.cancel();
            }
            this.mOffsetAnimator.setDuration((long) Math.min(i2, 600));
            this.mOffsetAnimator.setIntValues(new int[]{r0, i});
            this.mOffsetAnimator.start();
        }

        private int getChildIndexOnOffset(AppBarLayout appBarLayout, int i) {
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                int i3 = -i;
                if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(appBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = appBarLayout.getChildAt(childIndexOnOffset);
                int scrollFlags = ((LayoutParams) childAt.getLayoutParams()).getScrollFlags();
                if ((scrollFlags & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (childIndexOnOffset == appBarLayout.getChildCount() - 1) {
                        i2 += appBarLayout.getTopInset();
                    }
                    if (checkFlag(scrollFlags, 2)) {
                        i2 += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(scrollFlags, 5)) {
                        int minimumHeight = ViewCompat.getMinimumHeight(childAt) + i2;
                        if (topBottomOffsetForScrollingSibling < minimumHeight) {
                            i = minimumHeight;
                        } else {
                            i2 = minimumHeight;
                        }
                    }
                    if (topBottomOffsetForScrollingSibling < (i2 + i) / 2) {
                        i = i2;
                    }
                    animateOffsetTo(coordinatorLayout, appBarLayout, MathUtils.clamp(i, -appBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3, int i4) {
            if (((android.support.design.widget.CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).height != -2) {
                return super.onMeasureChild(coordinatorLayout, appBarLayout, i, i2, i3, i4);
            }
            coordinatorLayout.onMeasureChild(appBarLayout, i, i2, MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            i = super.onLayoutChild(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            int i2;
            if (this.mOffsetToChildIndexOnLayout >= 0 && (pendingAction & 8) == 0) {
                View childAt = appBarLayout.getChildAt(this.mOffsetToChildIndexOnLayout);
                i2 = -childAt.getBottom();
                if (this.mOffsetToChildIndexOnLayoutIsMinHeight) {
                    i2 += ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset();
                } else {
                    i2 += Math.round(((float) childAt.getHeight()) * this.mOffsetToChildIndexOnLayoutPerc);
                }
                setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, i2);
            } else if (pendingAction != 0) {
                i2 = (pendingAction & 4) != 0 ? 1 : 0;
                if ((pendingAction & 2) != 0) {
                    pendingAction = -appBarLayout.getUpNestedPreScrollRange();
                    if (i2 != 0) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, pendingAction, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, pendingAction);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (i2 != 0) {
                        animateOffsetTo(coordinatorLayout, appBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(coordinatorLayout, appBarLayout, 0);
                    }
                }
            }
            appBarLayout.resetPendingAction();
            this.mOffsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -appBarLayout.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, getTopAndBottomOffset(), 0, true);
            appBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            return i;
        }

        boolean canDragView(AppBarLayout appBarLayout) {
            if (this.mOnDragCallback != null) {
                return this.mOnDragCallback.canDrag(appBarLayout);
            }
            if (this.mLastNestedScrollingChildRef == null) {
                return true;
            }
            View view = (View) this.mLastNestedScrollingChildRef.get();
            if (view != null && view.isShown() && view.canScrollVertically(-1) == null) {
                return true;
            }
            return null;
        }

        void onFlingFinished(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            snapToChildIfNeeded(coordinatorLayout, appBarLayout);
        }

        int getMaxDragOffset(AppBarLayout appBarLayout) {
            return -appBarLayout.getDownNestedScrollRange();
        }

        int getScrollRangeForDragFling(AppBarLayout appBarLayout) {
            return appBarLayout.getTotalScrollRange();
        }

        int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i4 = 0;
            if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                this.mOffsetDelta = 0;
            } else {
                int clamp = MathUtils.clamp(i, i2, i3);
                if (topBottomOffsetForScrollingSibling != clamp) {
                    i = appBarLayout.hasChildWithInterpolator() != 0 ? interpolateOffset(appBarLayout, clamp) : clamp;
                    i2 = setTopAndBottomOffset(i);
                    i4 = topBottomOffsetForScrollingSibling - clamp;
                    this.mOffsetDelta = clamp - i;
                    if (i2 == 0 && appBarLayout.hasChildWithInterpolator() != 0) {
                        coordinatorLayout.dispatchDependentViewsChanged(appBarLayout);
                    }
                    appBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(coordinatorLayout, appBarLayout, clamp, clamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                }
            }
            return i4;
        }

        @VisibleForTesting
        boolean isOffsetAnimatorRunning() {
            return this.mOffsetAnimator != null && this.mOffsetAnimator.isRunning();
        }

        private int interpolateOffset(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = appBarLayout.getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Interpolator scrollInterpolator = layoutParams.getScrollInterpolator();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else {
                    if (scrollInterpolator != null) {
                        childCount = layoutParams.getScrollFlags();
                        if ((childCount & 1) != 0) {
                            i2 = 0 + ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin);
                            if ((childCount & 2) != 0) {
                                i2 -= ViewCompat.getMinimumHeight(childAt);
                            }
                        }
                        if (ViewCompat.getFitsSystemWindows(childAt)) {
                            i2 -= appBarLayout.getTopInset();
                        }
                        if (i2 > 0) {
                            appBarLayout = (float) i2;
                            return Integer.signum(i) * (childAt.getTop() + Math.round(appBarLayout * scrollInterpolator.getInterpolation(((float) (abs - childAt.getTop())) / appBarLayout)));
                        }
                    }
                    return i;
                }
            }
            return i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void updateAppBarLayoutDrawableState(android.support.design.widget.CoordinatorLayout r6, android.support.design.widget.AppBarLayout r7, int r8, int r9, boolean r10) {
            /*
            r5 = this;
            r0 = getAppBarChildOnOffset(r7, r8);
            if (r0 == 0) goto L_0x0058;
        L_0x0006:
            r1 = r0.getLayoutParams();
            r1 = (android.support.design.widget.AppBarLayout.LayoutParams) r1;
            r1 = r1.getScrollFlags();
            r2 = r1 & 1;
            r3 = 0;
            if (r2 == 0) goto L_0x0041;
        L_0x0015:
            r2 = android.support.v4.view.ViewCompat.getMinimumHeight(r0);
            r4 = 1;
            if (r9 <= 0) goto L_0x002f;
        L_0x001c:
            r9 = r1 & 12;
            if (r9 == 0) goto L_0x002f;
        L_0x0020:
            r8 = -r8;
            r9 = r0.getBottom();
            r9 = r9 - r2;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x0041;
        L_0x002d:
            r3 = r4;
            goto L_0x0041;
        L_0x002f:
            r9 = r1 & 2;
            if (r9 == 0) goto L_0x0041;
        L_0x0033:
            r8 = -r8;
            r9 = r0.getBottom();
            r9 = r9 - r2;
            r0 = r7.getTopInset();
            r9 = r9 - r0;
            if (r8 < r9) goto L_0x0041;
        L_0x0040:
            goto L_0x002d;
        L_0x0041:
            r8 = r7.setCollapsedState(r3);
            r9 = android.os.Build.VERSION.SDK_INT;
            r0 = 11;
            if (r9 < r0) goto L_0x0058;
        L_0x004b:
            if (r10 != 0) goto L_0x0055;
        L_0x004d:
            if (r8 == 0) goto L_0x0058;
        L_0x004f:
            r6 = r5.shouldJumpElevationState(r6, r7);
            if (r6 == 0) goto L_0x0058;
        L_0x0055:
            r7.jumpDrawablesToCurrentState();
        L_0x0058:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.Behavior.updateAppBarLayoutDrawableState(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        private boolean shouldJumpElevationState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            coordinatorLayout = coordinatorLayout.getDependents(appBarLayout);
            appBarLayout = coordinatorLayout.size();
            int i = 0;
            while (i < appBarLayout) {
                android.support.design.widget.CoordinatorLayout.Behavior behavior = ((android.support.design.widget.CoordinatorLayout.LayoutParams) ((View) coordinatorLayout.get(i)).getLayoutParams()).getBehavior();
                if (!(behavior instanceof ScrollingViewBehavior)) {
                    i++;
                } else if (((ScrollingViewBehavior) behavior).getOverlayTop() != null) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        private static View getAppBarChildOnOffset(AppBarLayout appBarLayout, int i) {
            i = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (i >= childAt.getTop() && i <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.mOffsetDelta;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            coordinatorLayout = super.onSaveInstanceState(coordinatorLayout, appBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = appBarLayout.getChildCount();
            boolean z = false;
            int i = 0;
            while (i < childCount) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset > 0 || bottom < 0) {
                    i++;
                } else {
                    Parcelable savedState = new SavedState(coordinatorLayout);
                    savedState.firstVisibleChildIndex = i;
                    if (bottom == ViewCompat.getMinimumHeight(childAt) + appBarLayout.getTopInset()) {
                        z = true;
                    }
                    savedState.firstVisibleChildAtMinimumHeight = z;
                    savedState.firstVisibleChildPercentageShown = ((float) bottom) / ((float) childAt.getHeight());
                    return savedState;
                }
            }
            return coordinatorLayout;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                super.onRestoreInstanceState(coordinatorLayout, appBarLayout, savedState.getSuperState());
                this.mOffsetToChildIndexOnLayout = savedState.firstVisibleChildIndex;
                this.mOffsetToChildIndexOnLayoutPerc = savedState.firstVisibleChildPercentageShown;
                this.mOffsetToChildIndexOnLayoutIsMinHeight = savedState.firstVisibleChildAtMinimumHeight;
                return;
            }
            super.onRestoreInstanceState(coordinatorLayout, appBarLayout, parcelable);
            this.mOffsetToChildIndexOnLayout = -1;
        }
    }

    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public /* bridge */ /* synthetic */ int getLeftAndRightOffset() {
            return super.getLeftAndRightOffset();
        }

        public /* bridge */ /* synthetic */ int getTopAndBottomOffset() {
            return super.getTopAndBottomOffset();
        }

        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return super.onLayoutChild(coordinatorLayout, view, i);
        }

        public /* bridge */ /* synthetic */ boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(coordinatorLayout, view, i, i2, i3, i4);
        }

        public /* bridge */ /* synthetic */ boolean setLeftAndRightOffset(int i) {
            return super.setLeftAndRightOffset(i);
        }

        public /* bridge */ /* synthetic */ boolean setTopAndBottomOffset(int i) {
            return super.setTopAndBottomOffset(i);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, R.styleable.ScrollingViewBehavior_Layout);
            setOverlayTop(context.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            context.recycle();
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(coordinatorLayout, view, view2);
            return null;
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout findFirstDependency = findFirstDependency(coordinatorLayout.getDependencies(view));
            if (findFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                view = this.mTempRect1;
                view.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (view.contains(rect) == null) {
                    findFirstDependency.setExpanded(false, z ^ 1);
                    return true;
                }
            }
            return false;
        }

        private void offsetChildAsNeeded(CoordinatorLayout coordinatorLayout, View view, View view2) {
            coordinatorLayout = ((android.support.design.widget.CoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (coordinatorLayout instanceof Behavior) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((Behavior) coordinatorLayout).mOffsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        float getOverlapRatioForOffset(View view) {
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                view = getAppBarLayoutOffset(appBarLayout);
                if (downNestedPreScrollRange != 0 && totalScrollRange + view <= downNestedPreScrollRange) {
                    return 0.0f;
                }
                totalScrollRange -= downNestedPreScrollRange;
                if (totalScrollRange != 0) {
                    return 1.0f + (((float) view) / ((float) totalScrollRange));
                }
            }
            return 0.0f;
        }

        private static int getAppBarLayoutOffset(AppBarLayout appBarLayout) {
            appBarLayout = ((android.support.design.widget.CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).getBehavior();
            return appBarLayout instanceof Behavior ? ((Behavior) appBarLayout).getTopBottomOffsetForScrollingSibling() : null;
        }

        AppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = (View) list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        int getScrollRange(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.getScrollRange(view);
        }
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
        this.mPendingAction = 0;
        setOrientation(1);
        ThemeUtils.checkAppCompatTheme(context);
        if (VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider(this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, 0, R.style.Widget_Design_AppBarLayout);
        }
        context = context.obtainStyledAttributes(attributeSet, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
        ViewCompat.setBackground(this, context.getDrawable(R.styleable.AppBarLayout_android_background));
        if (context.hasValue(R.styleable.AppBarLayout_expanded) != null) {
            setExpanded(context.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (VERSION.SDK_INT >= 21 && context.hasValue(R.styleable.AppBarLayout_elevation) != null) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, (float) context.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (VERSION.SDK_INT >= 26) {
            if (context.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster) != null) {
                setKeyboardNavigationCluster(context.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (context.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus) != null) {
                setTouchscreenBlocksFocus(context.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        context.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return AppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        if (onOffsetChangedListener != null && !this.mListeners.contains(onOffsetChangedListener)) {
            this.mListeners.add(onOffsetChangedListener);
        }
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        if (this.mListeners != null && onOffsetChangedListener != null) {
            this.mListeners.remove(onOffsetChangedListener);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        invalidateScrollRanges();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        invalidateScrollRanges();
        z = false;
        this.mHaveChildWithInterpolator = false;
        boolean childCount = getChildCount();
        while (z < childCount) {
            if (((LayoutParams) getChildAt(z).getLayoutParams()).getScrollInterpolator() != 0) {
                this.mHaveChildWithInterpolator = true;
                break;
            }
            z++;
        }
        updateCollapsible();
    }

    private void updateCollapsible() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).isCollapsible()) {
                z = true;
                break;
            }
        }
        setCollapsibleState(z);
    }

    private void invalidateScrollRanges() {
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
    }

    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        int i = 0;
        z = (z ? true : true) | (z2 ? true : false);
        if (z3) {
            i = 8;
        }
        this.mPendingAction = z | i;
        requestLayout();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (VERSION.SDK_INT >= 19 && (layoutParams instanceof android.widget.LinearLayout.LayoutParams)) {
            return new LayoutParams((android.widget.LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    boolean hasChildWithInterpolator() {
        return this.mHaveChildWithInterpolator;
    }

    public final int getTotalScrollRange() {
        if (this.mTotalScrollRange != -1) {
            return this.mTotalScrollRange;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = layoutParams.mScrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += (measuredHeight + layoutParams.topMargin) + layoutParams.bottomMargin;
            if ((i3 & 2) != 0) {
                i2 -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2 - getTopInset());
        this.mTotalScrollRange = childCount;
        return childCount;
    }

    boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    int getDownNestedPreScrollRange() {
        if (this.mDownPreScrollRange != -1) {
            return this.mDownPreScrollRange;
        }
        int childCount;
        int i = 0;
        for (childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = layoutParams.mScrollFlags;
            if ((i2 & 5) != 5) {
                if (i > 0) {
                    break;
                }
            } else {
                i += layoutParams.topMargin + layoutParams.bottomMargin;
                if ((i2 & 8) != 0) {
                    i += ViewCompat.getMinimumHeight(childAt);
                } else if ((i2 & 2) != 0) {
                    i += measuredHeight - ViewCompat.getMinimumHeight(childAt);
                } else {
                    i += measuredHeight - getTopInset();
                }
            }
        }
        childCount = Math.max(0, i);
        this.mDownPreScrollRange = childCount;
        return childCount;
    }

    int getDownNestedScrollRange() {
        if (this.mDownScrollRange != -1) {
            return this.mDownScrollRange;
        }
        int childCount = getChildCount();
        int i = 0;
        int i2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + (layoutParams.topMargin + layoutParams.bottomMargin);
            int i3 = layoutParams.mScrollFlags;
            if ((i3 & 1) == 0) {
                break;
            }
            i2 += measuredHeight;
            if ((i3 & 2) != 0) {
                i2 -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                break;
            }
            i++;
        }
        childCount = Math.max(0, i2);
        this.mDownScrollRange = childCount;
        return childCount;
    }

    void dispatchOffsetUpdates(int i) {
        if (this.mListeners != null) {
            int size = this.mListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnOffsetChangedListener onOffsetChangedListener = (OnOffsetChangedListener) this.mListeners.get(i2);
                if (onOffsetChangedListener != null) {
                    onOffsetChangedListener.onOffsetChanged(this, i);
                }
            }
        }
    }

    final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        minimumHeight = getChildCount();
        minimumHeight = minimumHeight > 0 ? ViewCompat.getMinimumHeight(getChildAt(minimumHeight - 1)) : 0;
        if (minimumHeight != 0) {
            return (minimumHeight * 2) + topInset;
        }
        return getHeight() / 3;
    }

    protected int[] onCreateDrawableState(int i) {
        if (this.mTmpStatesArray == null) {
            this.mTmpStatesArray = new int[2];
        }
        int[] iArr = this.mTmpStatesArray;
        i = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.mCollapsible ? R.attr.state_collapsible : -R.attr.state_collapsible;
        int i2 = (this.mCollapsible && this.mCollapsed) ? R.attr.state_collapsed : -R.attr.state_collapsed;
        iArr[1] = i2;
        return mergeDrawableStates(i, iArr);
    }

    private boolean setCollapsibleState(boolean z) {
        if (this.mCollapsible == z) {
            return false;
        }
        this.mCollapsible = z;
        refreshDrawableState();
        return true;
    }

    boolean setCollapsedState(boolean z) {
        if (this.mCollapsed == z) {
            return false;
        }
        this.mCollapsed = z;
        refreshDrawableState();
        return true;
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
        }
    }

    int getPendingAction() {
        return this.mPendingAction;
    }

    void resetPendingAction() {
        this.mPendingAction = 0;
    }

    @VisibleForTesting
    final int getTopInset() {
        return this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : 0;
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }
}
