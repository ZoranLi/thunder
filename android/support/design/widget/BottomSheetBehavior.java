package android.support.design.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

public class BottomSheetBehavior<V extends View> extends Behavior<V> {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    int mActivePointerId;
    private BottomSheetCallback mCallback;
    private final Callback mDragCallback = new Callback() {
        public boolean tryCaptureView(View view, int i) {
            if (BottomSheetBehavior.this.mState == 1 || BottomSheetBehavior.this.mTouchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.mState == 3 && BottomSheetBehavior.this.mActivePointerId == i) {
                View view2 = (View) BottomSheetBehavior.this.mNestedScrollingChildRef.get();
                if (!(view2 == null || view2.canScrollVertically(-1) == 0)) {
                    return false;
                }
            }
            return BottomSheetBehavior.this.mViewRef != 0 && BottomSheetBehavior.this.mViewRef.get() == view;
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        public void onViewDragStateChanged(int i) {
            if (i == 1) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            int i = 4;
            if (f2 < 0.0f) {
                f = BottomSheetBehavior.this.mMinOffset;
            } else if (BottomSheetBehavior.this.mHideable && BottomSheetBehavior.this.shouldHide(view, f2)) {
                f = BottomSheetBehavior.this.mParentHeight;
                i = 5;
                if (BottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(view.getLeft(), f) != null) {
                    BottomSheetBehavior.this.setStateInternal(i);
                }
                BottomSheetBehavior.this.setStateInternal(2.8E-45f);
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
                return;
            } else {
                if (f2 == 0.0f) {
                    f = view.getTop();
                    if (Math.abs(f - BottomSheetBehavior.this.mMinOffset) < Math.abs(f - BottomSheetBehavior.this.mMaxOffset)) {
                        f = BottomSheetBehavior.this.mMinOffset;
                    } else {
                        f = BottomSheetBehavior.this.mMaxOffset;
                    }
                } else {
                    f = BottomSheetBehavior.this.mMaxOffset;
                }
                if (BottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(view.getLeft(), f) != null) {
                    BottomSheetBehavior.this.setStateInternal(2.8E-45f);
                    ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
                    return;
                }
                BottomSheetBehavior.this.setStateInternal(i);
            }
            i = 3;
            if (BottomSheetBehavior.this.mViewDragHelper.settleCapturedViewAt(view.getLeft(), f) != null) {
                BottomSheetBehavior.this.setStateInternal(2.8E-45f);
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
                return;
            }
            BottomSheetBehavior.this.setStateInternal(i);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return MathUtils.clamp(i, BottomSheetBehavior.this.mMinOffset, BottomSheetBehavior.this.mHideable != 0 ? BottomSheetBehavior.this.mParentHeight : BottomSheetBehavior.this.mMaxOffset);
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        public int getViewVerticalDragRange(View view) {
            if (BottomSheetBehavior.this.mHideable != null) {
                return BottomSheetBehavior.this.mParentHeight - BottomSheetBehavior.this.mMinOffset;
            }
            return BottomSheetBehavior.this.mMaxOffset - BottomSheetBehavior.this.mMinOffset;
        }
    };
    boolean mHideable;
    private boolean mIgnoreEvents;
    private int mInitialY;
    private int mLastNestedScrollDy;
    int mMaxOffset;
    private float mMaximumVelocity;
    int mMinOffset;
    private boolean mNestedScrolled;
    WeakReference<View> mNestedScrollingChildRef;
    int mParentHeight;
    private int mPeekHeight;
    private boolean mPeekHeightAuto;
    private int mPeekHeightMin;
    private boolean mSkipCollapsed;
    int mState = 4;
    boolean mTouchingScrollingChild;
    private VelocityTracker mVelocityTracker;
    ViewDragHelper mViewDragHelper;
    WeakReference<V> mViewRef;

    public static abstract class BottomSheetCallback {
        public abstract void onSlide(@NonNull View view, float f);

        public abstract void onStateChanged(@NonNull View view, int i);
    }

    private class SettleRunnable implements Runnable {
        private final int mTargetState;
        private final View mView;

        SettleRunnable(View view, int i) {
            this.mView = view;
            this.mTargetState = i;
        }

        public void run() {
            if (BottomSheetBehavior.this.mViewDragHelper == null || !BottomSheetBehavior.this.mViewDragHelper.continueSettling(true)) {
                BottomSheetBehavior.this.setStateInternal(this.mTargetState);
            } else {
                ViewCompat.postOnAnimation(this.mView, this);
            }
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface State {
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
        final int state;

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue peekValue = attributeSet.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(attributeSet.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(attributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setSkipCollapsed(attributeSet.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        attributeSet.recycle();
        this.mMaximumVelocity = (float) ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), this.mState);
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.state != 1) {
            if (savedState.state != 2) {
                this.mState = savedState.state;
                return;
            }
        }
        this.mState = 4;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            ViewCompat.setFitsSystemWindows(v, true);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.mParentHeight = coordinatorLayout.getHeight();
        if (this.mPeekHeightAuto != 0) {
            if (this.mPeekHeightMin == 0) {
                this.mPeekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            i = Math.max(this.mPeekHeightMin, this.mParentHeight - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            i = this.mPeekHeight;
        }
        this.mMinOffset = Math.max(0, this.mParentHeight - v.getHeight());
        this.mMaxOffset = Math.max(this.mParentHeight - i, this.mMinOffset);
        if (this.mState == 3) {
            ViewCompat.offsetTopAndBottom(v, this.mMinOffset);
        } else if (this.mHideable != 0 && this.mState == 5) {
            ViewCompat.offsetTopAndBottom(v, this.mParentHeight);
        } else if (this.mState == 4) {
            ViewCompat.offsetTopAndBottom(v, this.mMaxOffset);
        } else if (this.mState == 1 || this.mState == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.mViewDragHelper == 0) {
            this.mViewDragHelper = ViewDragHelper.create(coordinatorLayout, this.mDragCallback);
        }
        this.mViewRef = new WeakReference(v);
        this.mNestedScrollingChildRef = new WeakReference(findScrollingChild(v));
        return true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                reset();
            }
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            if (actionMasked != 3) {
                switch (actionMasked) {
                    case 0:
                        int x = (int) motionEvent.getX();
                        this.mInitialY = (int) motionEvent.getY();
                        View view = this.mNestedScrollingChildRef != null ? (View) this.mNestedScrollingChildRef.get() : null;
                        if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.mInitialY)) {
                            this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                            this.mTouchingScrollingChild = true;
                        }
                        v = (this.mActivePointerId == -1 && coordinatorLayout.isPointInChildBounds(v, x, this.mInitialY) == null) ? 1 : null;
                        this.mIgnoreEvents = v;
                        break;
                    case 1:
                        break;
                    default:
                        break;
                }
            }
            this.mTouchingScrollingChild = false;
            this.mActivePointerId = -1;
            if (this.mIgnoreEvents != null) {
                this.mIgnoreEvents = false;
                return false;
            }
            if (this.mIgnoreEvents == null && this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent) != null) {
                return true;
            }
            View view2 = (View) this.mNestedScrollingChildRef.get();
            return actionMasked == 2 && view2 != null && !this.mIgnoreEvents && this.mState != 1 && coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) == null && Math.abs(((float) this.mInitialY) - motionEvent.getY()) > ((float) this.mViewDragHelper.getTouchSlop());
        } else {
            this.mIgnoreEvents = true;
            return false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (v.isShown() == null) {
            return false;
        }
        coordinatorLayout = motionEvent.getActionMasked();
        if (this.mState == 1 && coordinatorLayout == null) {
            return true;
        }
        this.mViewDragHelper.processTouchEvent(motionEvent);
        if (coordinatorLayout == null) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (coordinatorLayout == 2 && this.mIgnoreEvents == null && Math.abs(((float) this.mInitialY) - motionEvent.getY()) > ((float) this.mViewDragHelper.getTouchSlop())) {
            this.mViewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        if (this.mIgnoreEvents == null) {
            return true;
        }
        return false;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        this.mLastNestedScrollDy = 0;
        this.mNestedScrolled = false;
        if ((i & 2) != null) {
            return true;
        }
        return false;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        if (view == ((View) this.mNestedScrollingChildRef.get())) {
            coordinatorLayout = v.getTop();
            i = coordinatorLayout - i2;
            if (i2 > 0) {
                if (i < this.mMinOffset) {
                    iArr[1] = coordinatorLayout - this.mMinOffset;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    setStateInternal(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    setStateInternal(1);
                }
            } else if (i2 < 0 && view.canScrollVertically(-1) == null) {
                if (i > this.mMaxOffset) {
                    if (this.mHideable == null) {
                        iArr[1] = coordinatorLayout - this.mMaxOffset;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(4);
                    }
                }
                iArr[1] = i2;
                ViewCompat.offsetTopAndBottom(v, -i2);
                setStateInternal(1);
            }
            dispatchOnSlide(v.getTop());
            this.mLastNestedScrollDy = i2;
            this.mNestedScrolled = true;
        }
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view) {
        int i = 3;
        if (v.getTop() == this.mMinOffset) {
            setStateInternal(3);
            return;
        }
        if (this.mNestedScrollingChildRef != null && view == this.mNestedScrollingChildRef.get()) {
            if (this.mNestedScrolled != null) {
                if (this.mLastNestedScrollDy > null) {
                    coordinatorLayout = this.mMinOffset;
                } else if (this.mHideable == null || shouldHide(v, getYVelocity()) == null) {
                    if (this.mLastNestedScrollDy == null) {
                        coordinatorLayout = v.getTop();
                        if (Math.abs(coordinatorLayout - this.mMinOffset) < Math.abs(coordinatorLayout - this.mMaxOffset)) {
                            coordinatorLayout = this.mMinOffset;
                        } else {
                            coordinatorLayout = this.mMaxOffset;
                        }
                    } else {
                        coordinatorLayout = this.mMaxOffset;
                    }
                    i = 4;
                } else {
                    coordinatorLayout = this.mParentHeight;
                    i = 5;
                }
                if (this.mViewDragHelper.smoothSlideViewTo(v, v.getLeft(), coordinatorLayout) != null) {
                    setStateInternal(2);
                    ViewCompat.postOnAnimation(v, new SettleRunnable(v, i));
                } else {
                    setStateInternal(i);
                }
                this.mNestedScrolled = null;
            }
        }
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return (view != this.mNestedScrollingChildRef.get() || (this.mState == 3 && super.onNestedPreFling(coordinatorLayout, v, view, f, f2) == null)) ? null : true;
    }

    public final void setPeekHeight(int i) {
        boolean z = true;
        if (i != -1) {
            if (!this.mPeekHeightAuto) {
                if (this.mPeekHeight != i) {
                }
            }
            this.mPeekHeightAuto = false;
            this.mPeekHeight = Math.max(0, i);
            this.mMaxOffset = this.mParentHeight - i;
            if (!z) {
            }
        } else if (this.mPeekHeightAuto == 0) {
            this.mPeekHeightAuto = true;
            if (!z && this.mState == 4 && this.mViewRef != 0) {
                View view = (View) this.mViewRef.get();
                if (view != null) {
                    view.requestLayout();
                    return;
                }
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
    }

    public final int getPeekHeight() {
        return this.mPeekHeightAuto ? -1 : this.mPeekHeight;
    }

    public void setHideable(boolean z) {
        this.mHideable = z;
    }

    public boolean isHideable() {
        return this.mHideable;
    }

    public void setSkipCollapsed(boolean z) {
        this.mSkipCollapsed = z;
    }

    public boolean getSkipCollapsed() {
        return this.mSkipCollapsed;
    }

    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.mCallback = bottomSheetCallback;
    }

    public final void setState(final int i) {
        if (i != this.mState) {
            if (this.mViewRef == null) {
                if (i == 4 || i == 3 || (this.mHideable && i == 5)) {
                    this.mState = i;
                }
                return;
            }
            final View view = (View) this.mViewRef.get();
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(view)) {
                    view.post(new Runnable() {
                        public void run() {
                            BottomSheetBehavior.this.startSettlingAnimation(view, i);
                        }
                    });
                } else {
                    startSettlingAnimation(view, i);
                }
            }
        }
    }

    public final int getState() {
        return this.mState;
    }

    void setStateInternal(int i) {
        if (this.mState != i) {
            this.mState = i;
            View view = (View) this.mViewRef.get();
            if (!(view == null || this.mCallback == null)) {
                this.mCallback.onStateChanged(view, i);
            }
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    boolean shouldHide(View view, float f) {
        if (this.mSkipCollapsed) {
            return true;
        }
        if (view.getTop() >= this.mMaxOffset && Math.abs((((float) view.getTop()) + (f * HIDE_FRICTION)) - ((float) this.mMaxOffset)) / ((float) this.mPeekHeight) > 0.5f) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    View findScrollingChild(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    private float getYVelocity() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        return this.mVelocityTracker.getYVelocity(this.mActivePointerId);
    }

    void startSettlingAnimation(View view, int i) {
        int i2;
        if (i == 4) {
            i2 = this.mMaxOffset;
        } else if (i == 3) {
            i2 = this.mMinOffset;
        } else if (this.mHideable && i == 5) {
            i2 = this.mParentHeight;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Illegal state argument: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (this.mViewDragHelper.smoothSlideViewTo(view, view.getLeft(), i2)) {
            setStateInternal(2);
            ViewCompat.postOnAnimation(view, new SettleRunnable(view, i));
            return;
        }
        setStateInternal(i);
    }

    void dispatchOnSlide(int i) {
        View view = (View) this.mViewRef.get();
        if (!(view == null || this.mCallback == null)) {
            if (i > this.mMaxOffset) {
                this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mParentHeight - this.mMaxOffset)));
                return;
            }
            this.mCallback.onSlide(view, ((float) (this.mMaxOffset - i)) / ((float) (this.mMaxOffset - this.mMinOffset)));
        }
    }

    @VisibleForTesting
    int getPeekHeightMin() {
        return this.mPeekHeightMin;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        v = v.getLayoutParams();
        if (v instanceof LayoutParams) {
            v = ((LayoutParams) v).getBehavior();
            if (v instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) v;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }
}
