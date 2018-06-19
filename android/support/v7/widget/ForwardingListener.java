package android.support.v7.widget;

import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.view.menu.ShowableListMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;

@RestrictTo({Scope.LIBRARY_GROUP})
public abstract class ForwardingListener implements OnAttachStateChangeListener, OnTouchListener {
    private int mActivePointerId;
    private Runnable mDisallowIntercept;
    private boolean mForwarding;
    private final int mLongPressTimeout;
    private final float mScaledTouchSlop;
    final View mSrc;
    private final int mTapTimeout;
    private final int[] mTmpLocation = new int[2];
    private Runnable mTriggerLongPress;

    private class DisallowIntercept implements Runnable {
        DisallowIntercept() {
        }

        public void run() {
            ViewParent parent = ForwardingListener.this.mSrc.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    private class TriggerLongPress implements Runnable {
        TriggerLongPress() {
        }

        public void run() {
            ForwardingListener.this.onLongPress();
        }
    }

    public abstract ShowableListMenu getPopup();

    public void onViewAttachedToWindow(View view) {
    }

    public ForwardingListener(View view) {
        this.mSrc = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.mScaledTouchSlop = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.mTapTimeout = ViewConfiguration.getTapTimeout();
        this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        view = this.mForwarding;
        if (view != null) {
            if (onTouchForwarded(motionEvent) == null) {
                if (onForwardingStopped() != null) {
                    motionEvent = null;
                }
            }
            motionEvent = 1;
        } else {
            motionEvent = (onTouchObserved(motionEvent) == null || onForwardingStarted() == null) ? null : 1;
            if (motionEvent != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.mSrc.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.mForwarding = motionEvent;
        if (motionEvent == null) {
            if (view == null) {
                return false;
            }
        }
        return true;
    }

    public void onViewDetachedFromWindow(View view) {
        this.mForwarding = null;
        this.mActivePointerId = -1;
        if (this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
        }
    }

    public boolean onForwardingStarted() {
        ShowableListMenu popup = getPopup();
        if (!(popup == null || popup.isShowing())) {
            popup.show();
        }
        return true;
    }

    protected boolean onForwardingStopped() {
        ShowableListMenu popup = getPopup();
        if (popup != null && popup.isShowing()) {
            popup.dismiss();
        }
        return true;
    }

    private boolean onTouchObserved(MotionEvent motionEvent) {
        View view = this.mSrc;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                if (this.mDisallowIntercept == null) {
                    this.mDisallowIntercept = new DisallowIntercept();
                }
                view.postDelayed(this.mDisallowIntercept, (long) this.mTapTimeout);
                if (this.mTriggerLongPress == null) {
                    this.mTriggerLongPress = new TriggerLongPress();
                }
                view.postDelayed(this.mTriggerLongPress, (long) this.mLongPressTimeout);
                break;
            case 1:
            case 3:
                clearCallbacks();
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex >= 0 && pointInView(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.mScaledTouchSlop) == null) {
                    clearCallbacks();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
            default:
                break;
        }
        return false;
    }

    private void clearCallbacks() {
        if (this.mTriggerLongPress != null) {
            this.mSrc.removeCallbacks(this.mTriggerLongPress);
        }
        if (this.mDisallowIntercept != null) {
            this.mSrc.removeCallbacks(this.mDisallowIntercept);
        }
    }

    void onLongPress() {
        clearCallbacks();
        View view = this.mSrc;
        if (view.isEnabled()) {
            if (!view.isLongClickable()) {
                if (onForwardingStarted()) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                    this.mForwarding = true;
                }
            }
        }
    }

    private boolean onTouchForwarded(MotionEvent motionEvent) {
        View view = this.mSrc;
        ShowableListMenu popup = getPopup();
        if (popup != null) {
            if (popup.isShowing()) {
                DropDownListView dropDownListView = (DropDownListView) popup.getListView();
                if (dropDownListView != null) {
                    if (dropDownListView.isShown()) {
                        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
                        toGlobalMotionEvent(view, obtainNoHistory);
                        toLocalMotionEvent(dropDownListView, obtainNoHistory);
                        boolean onForwardedEvent = dropDownListView.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
                        obtainNoHistory.recycle();
                        motionEvent = motionEvent.getActionMasked();
                        motionEvent = (motionEvent == 1 || motionEvent == 3) ? null : 1;
                        if (!onForwardedEvent || motionEvent == null) {
                            return false;
                        }
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    private static boolean pointInView(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return (f < f4 || f2 < f4 || f >= ((float) (view.getRight() - view.getLeft())) + f3 || f2 >= ((float) (view.getBottom() - view.getTop())) + f3) ? null : true;
    }

    private boolean toLocalMotionEvent(View view, MotionEvent motionEvent) {
        int[] iArr = this.mTmpLocation;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) (-iArr[null]), (float) (-iArr[1]));
        return true;
    }

    private boolean toGlobalMotionEvent(View view, MotionEvent motionEvent) {
        int[] iArr = this.mTmpLocation;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation((float) iArr[null], (float) iArr[1]);
        return true;
    }
}
