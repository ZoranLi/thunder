package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId = -1;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop = -1;
    private VelocityTracker mVelocityTracker;

    private class FlingRunnable implements Runnable {
        private final V mLayout;
        private final CoordinatorLayout mParent;

        FlingRunnable(CoordinatorLayout coordinatorLayout, V v) {
            this.mParent = coordinatorLayout;
            this.mLayout = v;
        }

        public void run() {
            if (!(this.mLayout == null || HeaderBehavior.this.mScroller == null)) {
                if (HeaderBehavior.this.mScroller.computeScrollOffset()) {
                    HeaderBehavior.this.setHeaderTopBottomOffset(this.mParent, this.mLayout, HeaderBehavior.this.mScroller.getCurrY());
                    ViewCompat.postOnAnimation(this.mLayout, this);
                    return;
                }
                HeaderBehavior.this.onFlingFinished(this.mParent, this.mLayout);
            }
        }
    }

    boolean canDragView(V v) {
        return false;
    }

    void onFlingFinished(CoordinatorLayout coordinatorLayout, V v) {
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (canDragView(v) && coordinatorLayout.isPointInChildBounds(v, x, y) != null) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                coordinatorLayout = this.mActivePointerId;
                if (coordinatorLayout != -1) {
                    coordinatorLayout = motionEvent.findPointerIndex(coordinatorLayout);
                    if (coordinatorLayout != -1) {
                        coordinatorLayout = (int) motionEvent.getY(coordinatorLayout);
                        if (Math.abs(coordinatorLayout - this.mLastMotionY) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = coordinatorLayout;
                            break;
                        }
                    }
                }
                break;
            default:
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int y;
        switch (motionEvent.getActionMasked()) {
            case 0:
                y = (int) motionEvent.getY();
                if (coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y) != null && canDragView(v) != null) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ensureVelocityTracker();
                    break;
                }
                return false;
            case 1:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    fling(coordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.mVelocityTracker.getYVelocity(this.mActivePointerId));
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                    y = this.mLastMotionY - findPointerIndex;
                    if (!this.mIsBeingDragged && Math.abs(y) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        y = y > 0 ? y - this.mTouchSlop : y + this.mTouchSlop;
                    }
                    int i = y;
                    if (this.mIsBeingDragged) {
                        this.mLastMotionY = findPointerIndex;
                        scroll(coordinatorLayout, v, i, getMaxDragOffset(v), 0);
                        break;
                    }
                }
                return false;
                break;
            case 3:
                break;
            default:
                break;
        }
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return true;
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int setHeaderTopBottomOffset(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        V topAndBottomOffset = getTopAndBottomOffset();
        if (i2 != 0 && topAndBottomOffset >= i2 && topAndBottomOffset <= i3) {
            v = MathUtils.clamp(i, i2, i3);
            if (topAndBottomOffset != v) {
                setTopAndBottomOffset(v);
                return topAndBottomOffset - v;
            }
        }
        return null;
    }

    int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    final int scroll(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    final boolean fling(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        V v2 = v;
        if (this.mFlingRunnable != null) {
            v2.removeCallbacks(r0.mFlingRunnable);
            r0.mFlingRunnable = null;
        }
        if (r0.mScroller == null) {
            r0.mScroller = new OverScroller(v2.getContext());
        }
        r0.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (r0.mScroller.computeScrollOffset()) {
            r0.mFlingRunnable = new FlingRunnable(coordinatorLayout, v2);
            ViewCompat.postOnAnimation(v2, r0.mFlingRunnable);
            return true;
        }
        onFlingFinished(coordinatorLayout, v2);
        return false;
    }

    int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }
}
