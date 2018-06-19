package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.alipay.sdk.util.h;
import java.util.List;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild2, NestedScrollingParent, ScrollingView {
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    static final int ANIMATED_SCROLL_GAP = 250;
    private static final int INVALID_POINTER = -1;
    static final float MAX_SCROLL_FACTOR = 0.5f;
    private static final int[] SCROLLVIEW_STYLEABLE = new int[]{16843130};
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    private EdgeEffect mEdgeGlowBottom;
    private EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;

    public interface OnScrollChangeListener {
        void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.scrollPosition);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("HorizontalScrollView.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" scrollPosition=");
            stringBuilder.append(this.scrollPosition);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle) != null) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (nestedScrollView.isEnabled() == null) {
                return false;
            }
            if (i == 4096) {
                i = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.smoothScrollTo(0, i);
                return true;
            } else if (i != 8192) {
                return false;
            } else {
                i = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                if (i == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.smoothScrollTo(0, i);
                return true;
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int scrollRange = nestedScrollView.getScrollRange();
                if (scrollRange > 0) {
                    accessibilityNodeInfoCompat.setScrollable(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        accessibilityNodeInfoCompat.addAction(8192);
                    }
                    if (nestedScrollView.getScrollY() < scrollRange) {
                        accessibilityNodeInfoCompat.addAction(4096);
                    }
                }
            }
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    private static int clamp(int i, int i2, int i3) {
        if (i2 < i3) {
            if (i >= 0) {
                return i2 + i > i3 ? i3 - i2 : i;
            }
        }
        return 0;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        initScrollView();
        context = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i, 0);
        setFillViewport(context.getBoolean(0, false));
        context.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.setNestedScrollingEnabled(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    public boolean startNestedScroll(int i) {
        return this.mChildHelper.startNestedScroll(i);
    }

    public boolean startNestedScroll(int i, int i2) {
        return this.mChildHelper.startNestedScroll(i, i2);
    }

    public void stopNestedScroll() {
        this.mChildHelper.stopNestedScroll();
    }

    public void stopNestedScroll(int i) {
        this.mChildHelper.stopNestedScroll(i);
    }

    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.hasNestedScrollingParent();
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.mChildHelper.hasNestedScrollingParent(i);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mChildHelper.dispatchNestedPreFling(f, f2);
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.mParentHelper.onStopNestedScroll(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        view = getScrollY();
        scrollBy(0, i4);
        int scrollY = getScrollY() - view;
        dispatchNestedScroll(0, scrollY, 0, i4 - scrollY, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return null;
        }
        flingWithNestedDispatch((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        return scrollY < verticalFadingEdgeLength ? ((float) scrollY) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        return bottom < verticalFadingEdgeLength ? ((float) bottom) / ((float) verticalFadingEdgeLength) : 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
        this.mOnScrollChangeListener = onScrollChangeListener;
    }

    private boolean canScroll() {
        boolean z = false;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            z = true;
        }
        return z;
    }

    public boolean isFillViewport() {
        return this.mFillViewport;
    }

    public void setFillViewport(boolean z) {
        if (z != this.mFillViewport) {
            this.mFillViewport = z;
            requestLayout();
        }
    }

    public boolean isSmoothScrollingEnabled() {
        return this.mSmoothScrollingEnabled;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.mSmoothScrollingEnabled = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mOnScrollChangeListener != null) {
            this.mOnScrollChangeListener.onScrollChange(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mFillViewport && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            i2 = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (i2.getMeasuredHeight() < measuredHeight) {
                i2.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) i2.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!super.dispatchKeyEvent(keyEvent)) {
            if (executeKeyEvent(keyEvent) == null) {
                return null;
            }
        }
        return true;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        boolean z = false;
        int i = 130;
        if (canScroll()) {
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 62) {
                    switch (keyCode) {
                        case 19:
                            if (keyEvent.isAltPressed() != null) {
                                z = fullScroll(33);
                                break;
                            }
                            z = arrowScroll(33);
                            break;
                        case 20:
                            if (keyEvent.isAltPressed() != null) {
                                z = fullScroll(130);
                                break;
                            }
                            z = arrowScroll(130);
                            break;
                        default:
                            break;
                    }
                }
                if (keyEvent.isShiftPressed() != null) {
                    i = 33;
                }
                pageScroll(i);
            }
            return z;
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            keyEvent = findFocus();
            if (keyEvent == this) {
                keyEvent = null;
            }
            Object findNextFocus = FocusFinder.getInstance().findNextFocus(this, keyEvent, 130);
            if (findNextFocus == null || findNextFocus == this || findNextFocus.requestFocus(130) == null) {
                return false;
            }
            return true;
        }
    }

    private boolean inChild(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void initOrResetVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        action &= 255;
        if (action != 6) {
            switch (action) {
                case 0:
                    action = (int) motionEvent.getY();
                    if (!inChild((int) motionEvent.getX(), action)) {
                        this.mIsBeingDragged = false;
                        recycleVelocityTracker();
                        break;
                    }
                    this.mLastMotionY = action;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mScroller.computeScrollOffset();
                    this.mIsBeingDragged = this.mScroller.isFinished() ^ 1;
                    startNestedScroll(2, 0);
                    break;
                case 1:
                case 3:
                    this.mIsBeingDragged = false;
                    this.mActivePointerId = -1;
                    recycleVelocityTracker();
                    if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()) != null) {
                        ViewCompat.postInvalidateOnAnimation(this);
                    }
                    stopNestedScroll(0);
                    break;
                case 2:
                    action = this.mActivePointerId;
                    if (action != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(action);
                        if (findPointerIndex != -1) {
                            action = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(action - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = action;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                motionEvent = getParent();
                                if (motionEvent != null) {
                                    motionEvent.requestDisallowInterceptTouchEvent(true);
                                    break;
                                }
                            }
                        }
                        motionEvent = new StringBuilder("Invalid pointerId=");
                        motionEvent.append(action);
                        motionEvent.append(" in onInterceptTouchEvent");
                        break;
                    }
                    break;
                default:
                    break;
            }
        }
        onSecondaryPointerUp(motionEvent);
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NestedScrollView nestedScrollView = this;
        MotionEvent motionEvent2 = motionEvent;
        initVelocityTrackerIfNotExists();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            nestedScrollView.mNestedYOffset = 0;
        }
        obtain.offsetLocation(0.0f, (float) nestedScrollView.mNestedYOffset);
        ViewParent parent;
        switch (actionMasked) {
            case 0:
                if (getChildCount() != 0) {
                    boolean isFinished = nestedScrollView.mScroller.isFinished() ^ true;
                    nestedScrollView.mIsBeingDragged = isFinished;
                    if (isFinished) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!nestedScrollView.mScroller.isFinished()) {
                        nestedScrollView.mScroller.abortAnimation();
                    }
                    nestedScrollView.mLastMotionY = (int) motionEvent.getY();
                    nestedScrollView.mActivePointerId = motionEvent2.getPointerId(0);
                    startNestedScroll(2, 0);
                    break;
                }
                return false;
            case 1:
                VelocityTracker velocityTracker = nestedScrollView.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) nestedScrollView.mMaximumVelocity);
                actionMasked = (int) velocityTracker.getYVelocity(nestedScrollView.mActivePointerId);
                if (Math.abs(actionMasked) > nestedScrollView.mMinimumVelocity) {
                    flingWithNestedDispatch(-actionMasked);
                } else if (nestedScrollView.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                nestedScrollView.mActivePointerId = -1;
                endDrag();
                break;
            case 2:
                int findPointerIndex = motionEvent2.findPointerIndex(nestedScrollView.mActivePointerId);
                if (findPointerIndex != -1) {
                    int y = (int) motionEvent2.getY(findPointerIndex);
                    int i = nestedScrollView.mLastMotionY - y;
                    if (dispatchNestedPreScroll(0, i, nestedScrollView.mScrollConsumed, nestedScrollView.mScrollOffset, 0)) {
                        i -= nestedScrollView.mScrollConsumed[1];
                        obtain.offsetLocation(0.0f, (float) nestedScrollView.mScrollOffset[1]);
                        nestedScrollView.mNestedYOffset += nestedScrollView.mScrollOffset[1];
                    }
                    if (!nestedScrollView.mIsBeingDragged && Math.abs(i) > nestedScrollView.mTouchSlop) {
                        parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                        nestedScrollView.mIsBeingDragged = true;
                        if (i > 0) {
                            i -= nestedScrollView.mTouchSlop;
                        } else {
                            i += nestedScrollView.mTouchSlop;
                        }
                    }
                    int i2 = i;
                    if (nestedScrollView.mIsBeingDragged) {
                        boolean z;
                        int i3;
                        int i4;
                        int i5;
                        int scrollY;
                        nestedScrollView.mLastMotionY = y - nestedScrollView.mScrollOffset[1];
                        int scrollY2 = getScrollY();
                        i = getScrollRange();
                        actionMasked = getOverScrollMode();
                        if (actionMasked != 0) {
                            if (actionMasked != 1 || i <= 0) {
                                z = false;
                                i3 = i;
                                i4 = i2;
                                i5 = findPointerIndex;
                                if (overScrollByCompat(0, i2, 0, getScrollY(), 0, i, 0, 0, true) && !hasNestedScrollingParent(0)) {
                                    nestedScrollView.mVelocityTracker.clear();
                                }
                                scrollY = getScrollY() - scrollY2;
                                if (dispatchNestedScroll(0, scrollY, 0, i4 - scrollY, nestedScrollView.mScrollOffset, 0)) {
                                    if (z) {
                                        ensureGlows();
                                        actionMasked = scrollY2 + i4;
                                        if (actionMasked >= 0) {
                                            EdgeEffectCompat.onPull(nestedScrollView.mEdgeGlowTop, ((float) i4) / ((float) getHeight()), motionEvent2.getX(i5) / ((float) getWidth()));
                                            if (!nestedScrollView.mEdgeGlowBottom.isFinished()) {
                                                nestedScrollView.mEdgeGlowBottom.onRelease();
                                            }
                                        } else {
                                            scrollY = i5;
                                            if (actionMasked > i3) {
                                                EdgeEffectCompat.onPull(nestedScrollView.mEdgeGlowBottom, ((float) i4) / ((float) getHeight()), 1.0f - (motionEvent2.getX(scrollY) / ((float) getWidth())));
                                                if (!nestedScrollView.mEdgeGlowTop.isFinished()) {
                                                    nestedScrollView.mEdgeGlowTop.onRelease();
                                                }
                                            }
                                        }
                                        if (!(nestedScrollView.mEdgeGlowTop == null || (nestedScrollView.mEdgeGlowTop.isFinished() && nestedScrollView.mEdgeGlowBottom.isFinished()))) {
                                            ViewCompat.postInvalidateOnAnimation(this);
                                            break;
                                        }
                                    }
                                }
                                nestedScrollView.mLastMotionY -= nestedScrollView.mScrollOffset[1];
                                obtain.offsetLocation(0.0f, (float) nestedScrollView.mScrollOffset[1]);
                                nestedScrollView.mNestedYOffset += nestedScrollView.mScrollOffset[1];
                                break;
                            }
                        }
                        z = true;
                        i3 = i;
                        i4 = i2;
                        i5 = findPointerIndex;
                        nestedScrollView.mVelocityTracker.clear();
                        scrollY = getScrollY() - scrollY2;
                        if (dispatchNestedScroll(0, scrollY, 0, i4 - scrollY, nestedScrollView.mScrollOffset, 0)) {
                            if (z) {
                                ensureGlows();
                                actionMasked = scrollY2 + i4;
                                if (actionMasked >= 0) {
                                    scrollY = i5;
                                    if (actionMasked > i3) {
                                        EdgeEffectCompat.onPull(nestedScrollView.mEdgeGlowBottom, ((float) i4) / ((float) getHeight()), 1.0f - (motionEvent2.getX(scrollY) / ((float) getWidth())));
                                        if (nestedScrollView.mEdgeGlowTop.isFinished()) {
                                            nestedScrollView.mEdgeGlowTop.onRelease();
                                        }
                                    }
                                } else {
                                    EdgeEffectCompat.onPull(nestedScrollView.mEdgeGlowTop, ((float) i4) / ((float) getHeight()), motionEvent2.getX(i5) / ((float) getWidth()));
                                    if (nestedScrollView.mEdgeGlowBottom.isFinished()) {
                                        nestedScrollView.mEdgeGlowBottom.onRelease();
                                    }
                                }
                                ViewCompat.postInvalidateOnAnimation(this);
                                break;
                            }
                        }
                        nestedScrollView.mLastMotionY -= nestedScrollView.mScrollOffset[1];
                        obtain.offsetLocation(0.0f, (float) nestedScrollView.mScrollOffset[1]);
                        nestedScrollView.mNestedYOffset += nestedScrollView.mScrollOffset[1];
                        break;
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Invalid pointerId=");
                stringBuilder.append(nestedScrollView.mActivePointerId);
                stringBuilder.append(" in onTouchEvent");
                break;
                break;
            case 3:
                if (nestedScrollView.mIsBeingDragged && getChildCount() > 0 && nestedScrollView.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                nestedScrollView.mActivePointerId = -1;
                endDrag();
                break;
            case 5:
                actionMasked = motionEvent.getActionIndex();
                nestedScrollView.mLastMotionY = (int) motionEvent2.getY(actionMasked);
                nestedScrollView.mActivePointerId = motionEvent2.getPointerId(actionMasked);
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                nestedScrollView.mLastMotionY = (int) motionEvent2.getY(motionEvent2.findPointerIndex(nestedScrollView.mActivePointerId));
                break;
            default:
                break;
        }
        if (nestedScrollView.mVelocityTracker != null) {
            nestedScrollView.mVelocityTracker.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0) {
            if (motionEvent.getAction() == 8) {
                if (!this.mIsBeingDragged) {
                    motionEvent = motionEvent.getAxisValue(9);
                    if (motionEvent != 0.0f) {
                        motionEvent = (int) (motionEvent * getVerticalScrollFactorCompat());
                        int scrollRange = getScrollRange();
                        int scrollY = getScrollY();
                        motionEvent = scrollY - motionEvent;
                        if (motionEvent < null) {
                            motionEvent = null;
                        } else if (motionEvent > scrollRange) {
                            motionEvent = scrollRange;
                        }
                        if (motionEvent != scrollY) {
                            super.scrollTo(getScrollX(), motionEvent);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.mVerticalScrollFactor;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean overScrollByCompat(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z3;
        NestedScrollView nestedScrollView = this;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || !z4) {
                z4 = false;
                if (overScrollMode != 0) {
                    if (overScrollMode == 1 || !z5) {
                        z2 = false;
                        overScrollMode = i3 + i;
                        i9 = z4 ? 0 : i7;
                        i10 = i4 + i2;
                        i11 = z2 ? 0 : i8;
                        i12 = -i9;
                        i9 += i5;
                        i13 = -i11;
                        i11 += i6;
                        if (overScrollMode <= i9) {
                            z3 = true;
                            i12 = i9;
                        } else if (overScrollMode >= i12) {
                            z3 = true;
                        } else {
                            i12 = overScrollMode;
                            z3 = false;
                        }
                        if (i10 <= i11) {
                            i13 = i11;
                        } else if (i10 >= i13) {
                            i13 = i10;
                            z4 = false;
                            if (z4 && !hasNestedScrollingParent(1)) {
                                nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
                            }
                            onOverScrolled(i12, i13, z3, z4);
                            if (!z3) {
                                if (!z4) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        z4 = true;
                        nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
                        onOverScrolled(i12, i13, z3, z4);
                        if (z3) {
                            if (!z4) {
                                return false;
                            }
                        }
                        return true;
                    }
                }
                z2 = true;
                overScrollMode = i3 + i;
                if (z4) {
                }
                i10 = i4 + i2;
                if (z2) {
                }
                i12 = -i9;
                i9 += i5;
                i13 = -i11;
                i11 += i6;
                if (overScrollMode <= i9) {
                    z3 = true;
                    i12 = i9;
                } else if (overScrollMode >= i12) {
                    i12 = overScrollMode;
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (i10 <= i11) {
                    i13 = i11;
                } else if (i10 >= i13) {
                    i13 = i10;
                    z4 = false;
                    nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
                    onOverScrolled(i12, i13, z3, z4);
                    if (z3) {
                        if (!z4) {
                            return false;
                        }
                    }
                    return true;
                }
                z4 = true;
                nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z3, z4);
                if (z3) {
                    if (!z4) {
                        return false;
                    }
                }
                return true;
            }
        }
        z4 = true;
        if (overScrollMode != 0) {
            if (overScrollMode == 1) {
            }
            z2 = false;
            overScrollMode = i3 + i;
            if (z4) {
            }
            i10 = i4 + i2;
            if (z2) {
            }
            i12 = -i9;
            i9 += i5;
            i13 = -i11;
            i11 += i6;
            if (overScrollMode <= i9) {
                z3 = true;
                i12 = i9;
            } else if (overScrollMode >= i12) {
                z3 = true;
            } else {
                i12 = overScrollMode;
                z3 = false;
            }
            if (i10 <= i11) {
                i13 = i11;
            } else if (i10 >= i13) {
                i13 = i10;
                z4 = false;
                nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
                onOverScrolled(i12, i13, z3, z4);
                if (z3) {
                    if (!z4) {
                        return false;
                    }
                }
                return true;
            }
            z4 = true;
            nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i13, z3, z4);
            if (z3) {
                if (!z4) {
                    return false;
                }
            }
            return true;
        }
        z2 = true;
        overScrollMode = i3 + i;
        if (z4) {
        }
        i10 = i4 + i2;
        if (z2) {
        }
        i12 = -i9;
        i9 += i5;
        i13 = -i11;
        i11 += i6;
        if (overScrollMode <= i9) {
            z3 = true;
            i12 = i9;
        } else if (overScrollMode >= i12) {
            i12 = overScrollMode;
            z3 = false;
        } else {
            z3 = true;
        }
        if (i10 <= i11) {
            i13 = i11;
        } else if (i10 >= i13) {
            i13 = i10;
            z4 = false;
            nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
            onOverScrolled(i12, i13, z3, z4);
            if (z3) {
                if (!z4) {
                    return false;
                }
            }
            return true;
        }
        z4 = true;
        nestedScrollView.mScroller.springBack(i12, i13, 0, 0, 0, getScrollRange());
        onOverScrolled(i12, i13, z3, z4);
        if (z3) {
            if (!z4) {
                return false;
            }
        }
        return true;
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View findFocusableViewInBounds(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        int size = focusables.size();
        int i3 = 0;
        View view = null;
        for (int i4 = i3; i4 < size; i4++) {
            View view2 = (View) focusables.get(i4);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                int i5 = (i >= top || bottom >= i2) ? 0 : 1;
                if (view == null) {
                    view = view2;
                    i3 = i5;
                } else {
                    Object obj = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (i3 != 0) {
                        if (!(i5 == 0 || obj == null)) {
                        }
                    } else if (i5 != 0) {
                        view = view2;
                        i3 = 1;
                    } else if (obj == null) {
                    }
                    view = view2;
                }
            }
        }
        return view;
    }

    public boolean pageScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.mTempRect.top + height > childAt.getBottom()) {
                    this.mTempRect.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            if (this.mTempRect.top < 0) {
                this.mTempRect.top = 0;
            }
        }
        this.mTempRect.bottom = this.mTempRect.top + height;
        return scrollAndFocus(i, this.mTempRect.top, this.mTempRect.bottom);
    }

    public boolean fullScroll(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.mTempRect.top = 0;
        this.mTempRect.bottom = height;
        if (i2 != 0) {
            int childCount = getChildCount();
            if (childCount > 0) {
                this.mTempRect.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
                this.mTempRect.top = this.mTempRect.bottom - height;
            }
        }
        return scrollAndFocus(i, this.mTempRect.top, this.mTempRect.bottom);
    }

    private boolean scrollAndFocus(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        height += scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View findFocusableViewInBounds = findFocusableViewInBounds(z2, i2, i3);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i2 < scrollY || i3 > height) {
            doScrollY(z2 ? i2 - scrollY : i3 - height);
            z = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i);
        }
        return z;
    }

    public boolean arrowScroll(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom());
                if (bottom < maxScrollAmount) {
                    maxScrollAmount = bottom;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            doScrollY(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
            findNextFocus.requestFocus(i);
        }
        if (!(findFocus == null || findFocus.isFocused() == 0 || isOffScreen(findFocus) == 0)) {
            i = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(i);
        }
        return true;
    }

    private boolean isOffScreen(View view) {
        return isWithinDeltaOfScreen(view, 0, getHeight()) == null;
    }

    private boolean isWithinDeltaOfScreen(View view, int i, int i2) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return (this.mTempRect.bottom + i < getScrollY() || this.mTempRect.top - i > getScrollY() + i2) ? null : true;
    }

    private void doScrollY(int i) {
        if (i != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i);
                return;
            }
            scrollBy(0, i);
        }
    }

    public final void smoothScrollBy(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
                i = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, i)) - scrollY);
                ViewCompat.postInvalidateOnAnimation(this);
            } else {
                if (!this.mScroller.isFinished()) {
                    this.mScroller.abortAnimation();
                }
                scrollBy(i, i2);
            }
            this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void smoothScrollTo(int i, int i2) {
        smoothScrollBy(i - getScrollX(), i2 - getScrollY());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        if (scrollY < 0) {
            bottom -= scrollY;
        } else if (scrollY > max) {
            bottom += scrollY - max;
        }
        return bottom;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            r10.mScroller.getCurrX();
            int currY = r10.mScroller.getCurrY();
            int i = currY - r10.mLastScrollerY;
            if (dispatchNestedPreScroll(0, i, r10.mScrollConsumed, null, 1)) {
                i -= r10.mScrollConsumed[1];
            }
            int i2 = i;
            if (i2 != 0) {
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i3 = scrollY;
                overScrollByCompat(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
                int scrollY2 = getScrollY() - i3;
                if (!dispatchNestedScroll(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                    int i4;
                    int overScrollMode = getOverScrollMode();
                    if (overScrollMode != 0) {
                        if (overScrollMode != 1 || scrollRange <= 0) {
                            i4 = 0;
                            if (i4 != 0) {
                                ensureGlows();
                                if (currY > 0 && i3 > 0) {
                                    r10.mEdgeGlowTop.onAbsorb((int) r10.mScroller.getCurrVelocity());
                                } else if (currY >= scrollRange && i3 < scrollRange) {
                                    r10.mEdgeGlowBottom.onAbsorb((int) r10.mScroller.getCurrVelocity());
                                }
                            }
                        }
                    }
                    i4 = 1;
                    if (i4 != 0) {
                        ensureGlows();
                        if (currY > 0) {
                        }
                        r10.mEdgeGlowBottom.onAbsorb((int) r10.mScroller.getCurrVelocity());
                    }
                }
            }
            r10.mLastScrollerY = currY;
            ViewCompat.postInvalidateOnAnimation(this);
            return;
        }
        if (hasNestedScrollingParent(1)) {
            stopNestedScroll(1);
        }
        r10.mLastScrollerY = 0;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        view = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (view != null) {
            scrollBy(0, view);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z) {
        rect = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z2 = rect != null;
        if (z2) {
            if (z) {
                scrollBy(0, rect);
            } else {
                smoothScrollBy(0, rect);
            }
        }
        return z2;
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        int i = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i2 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i2 -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i2 && rect.top > scrollY) {
            if (rect.height() > height) {
                rect = (rect.top - scrollY) + null;
            } else {
                rect = (rect.bottom - i2) + null;
            }
            i = Math.min(rect, getChildAt(0).getBottom() - i2);
        } else if (rect.top < scrollY && rect.bottom < i2) {
            if (rect.height() > height) {
                i = 0 - (i2 - rect.bottom);
            } else {
                i = 0 - (scrollY - rect.top);
            }
            i = Math.max(i, -getScrollY());
        }
        return i;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        View findNextFocus;
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        if (rect == null) {
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, null, i);
        } else {
            findNextFocus = FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        }
        if (findNextFocus == null || isOffScreen(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z);
    }

    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mIsLayoutDirty = false;
        if (!(this.mChildToScrollTo == 0 || isViewDescendantOf(this.mChildToScrollTo, this) == 0)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (this.mIsLaidOut == 0) {
            if (this.mSavedState != 0) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            i = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > i) {
                scrollTo(getScrollX(), i);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        i = findFocus();
        if (i != 0) {
            if (this != i) {
                if (isWithinDeltaOfScreen(i, 0, i4) != 0) {
                    i.getDrawingRect(this.mTempRect);
                    offsetDescendantRectToMyCoords(i, this.mTempRect);
                    doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
                }
            }
        }
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        view = view.getParent();
        if (!(view instanceof ViewGroup) || isViewDescendantOf(view, view2) == null) {
            return null;
        }
        return true;
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            startNestedScroll(2, 1);
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.mLastScrollerY = getScrollY();
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    private void flingWithNestedDispatch(int i) {
        boolean z;
        float f;
        int scrollY = getScrollY();
        if (scrollY > 0 || i > 0) {
            if (scrollY >= getScrollRange()) {
                if (i < 0) {
                }
            }
            z = true;
            f = (float) i;
            if (!dispatchNestedPreFling(0.0f, f)) {
                dispatchNestedFling(0.0f, f, z);
                fling(i);
            }
        }
        z = false;
        f = (float) i;
        if (!dispatchNestedPreFling(0.0f, f)) {
            dispatchNestedFling(0.0f, f, z);
            fling(i);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        if (this.mEdgeGlowTop != null) {
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            i = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            i2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (i != getScrollX() || i2 != getScrollY()) {
                super.scrollTo(i, i2);
            }
        }
    }

    private void ensureGlows() {
        if (getOverScrollMode() == 2) {
            this.mEdgeGlowTop = null;
            this.mEdgeGlowBottom = null;
        } else if (this.mEdgeGlowTop == null) {
            Context context = getContext();
            this.mEdgeGlowTop = new EdgeEffect(context);
            this.mEdgeGlowBottom = new EdgeEffect(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mEdgeGlowTop != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.mEdgeGlowTop.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.mEdgeGlowTop.setSize(width, getHeight());
                if (this.mEdgeGlowTop.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.mEdgeGlowBottom.isFinished()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(180.0f, (float) width, 0.0f);
                this.mEdgeGlowBottom.setSize(width, height);
                if (this.mEdgeGlowBottom.draw(canvas)) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.mSavedState = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }
}
