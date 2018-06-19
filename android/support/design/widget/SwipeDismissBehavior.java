package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.support.v4.widget.ViewDragHelper.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SwipeDismissBehavior<V extends View> extends Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    float mAlphaEndSwipeDistance = PayBaseConstants.HALF_OF_FLOAT;
    float mAlphaStartSwipeDistance = 0.0f;
    private final Callback mDragCallback = new Callback() {
        private static final int INVALID_POINTER_ID = -1;
        private int mActivePointerId = -1;
        private int mOriginalCapturedViewLeft;

        public boolean tryCaptureView(View view, int i) {
            return (this.mActivePointerId != -1 || SwipeDismissBehavior.this.canSwipeDismissView(view) == null) ? null : true;
        }

        public void onViewCaptured(View view, int i) {
            this.mActivePointerId = i;
            this.mOriginalCapturedViewLeft = view.getLeft();
            view = view.getParent();
            if (view != null) {
                view.requestDisallowInterceptTouchEvent(1);
            }
        }

        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.mListener != null) {
                SwipeDismissBehavior.this.mListener.onDragStateChanged(i);
            }
        }

        public void onViewReleased(View view, float f, float f2) {
            this.mActivePointerId = -1;
            f2 = view.getWidth();
            if (shouldDismiss(view, f) != null) {
                f = view.getLeft() < this.mOriginalCapturedViewLeft ? this.mOriginalCapturedViewLeft - f2 : this.mOriginalCapturedViewLeft + f2;
                f2 = Float.MIN_VALUE;
            } else {
                f = this.mOriginalCapturedViewLeft;
                f2 = 0.0f;
            }
            if (SwipeDismissBehavior.this.mViewDragHelper.settleCapturedViewAt(f, view.getTop()) != null) {
                ViewCompat.postOnAnimation(view, new SettleRunnable(view, f2));
                return;
            }
            if (!(f2 == null || SwipeDismissBehavior.this.mListener == null)) {
                SwipeDismissBehavior.this.mListener.onDismiss(view);
            }
        }

        private boolean shouldDismiss(View view, float f) {
            if (f != 0.0f) {
                view = ViewCompat.getLayoutDirection(view) == 1 ? 1 : null;
                if (SwipeDismissBehavior.this.mSwipeDirection == 2) {
                    return true;
                }
                if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                    return view != null ? f < 0.0f : f > 0.0f;
                } else {
                    if (SwipeDismissBehavior.this.mSwipeDirection == 1) {
                        return view != null ? f > 0.0f : f < 0.0f;
                    } else {
                        return false;
                    }
                }
            }
            return Math.abs(view.getLeft() - this.mOriginalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.mDragDismissThreshold);
        }

        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int i3;
            i2 = ViewCompat.getLayoutDirection(view) == 1 ? 1 : 0;
            if (SwipeDismissBehavior.this.mSwipeDirection == 0) {
                if (i2 != 0) {
                    i2 = this.mOriginalCapturedViewLeft - view.getWidth();
                    i3 = this.mOriginalCapturedViewLeft;
                } else {
                    i2 = this.mOriginalCapturedViewLeft;
                    i3 = view.getWidth() + this.mOriginalCapturedViewLeft;
                }
            } else if (SwipeDismissBehavior.this.mSwipeDirection != 1) {
                i2 = this.mOriginalCapturedViewLeft - view.getWidth();
                i3 = view.getWidth() + this.mOriginalCapturedViewLeft;
            } else if (i2 != 0) {
                i2 = this.mOriginalCapturedViewLeft;
                i3 = view.getWidth() + this.mOriginalCapturedViewLeft;
            } else {
                i2 = this.mOriginalCapturedViewLeft - view.getWidth();
                i3 = this.mOriginalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(i2, i, i3);
        }

        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            i2 = ((float) this.mOriginalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.mAlphaStartSwipeDistance);
            i3 = ((float) this.mOriginalCapturedViewLeft) + (((float) view.getWidth()) * SwipeDismissBehavior.this.mAlphaEndSwipeDistance);
            i = (float) i;
            if (i <= i2) {
                view.setAlpha(1.0f);
            } else if (i >= i3) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(0.0f, 1065353216 - SwipeDismissBehavior.fraction(i2, i3, i), 1.0f));
            }
        }
    };
    float mDragDismissThreshold = PayBaseConstants.HALF_OF_FLOAT;
    private boolean mInterceptingEvents;
    OnDismissListener mListener;
    private float mSensitivity = 0.0f;
    private boolean mSensitivitySet;
    int mSwipeDirection = 2;
    ViewDragHelper mViewDragHelper;

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    private class SettleRunnable implements Runnable {
        private final boolean mDismiss;
        private final View mView;

        SettleRunnable(View view, boolean z) {
            this.mView = view;
            this.mDismiss = z;
        }

        public void run() {
            if (SwipeDismissBehavior.this.mViewDragHelper == null || !SwipeDismissBehavior.this.mViewDragHelper.continueSettling(true)) {
                if (this.mDismiss && SwipeDismissBehavior.this.mListener != null) {
                    SwipeDismissBehavior.this.mListener.onDismiss(this.mView);
                }
                return;
            }
            ViewCompat.postOnAnimation(this.mView, this);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    private @interface SwipeDirection {
    }

    static float fraction(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    public boolean canSwipeDismissView(@NonNull View view) {
        return true;
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.mListener = onDismissListener;
    }

    public void setSwipeDirection(int i) {
        this.mSwipeDirection = i;
    }

    public void setDragDismissDistance(float f) {
        this.mDragDismissThreshold = clamp(0.0f, f, 1.0f);
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.mAlphaStartSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.mAlphaEndSwipeDistance = clamp(0.0f, f, 1.0f);
    }

    public void setSensitivity(float f) {
        this.mSensitivity = f;
        this.mSensitivitySet = true;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.mInterceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 3) {
            switch (actionMasked) {
                case 0:
                    this.mInterceptingEvents = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
                    z = this.mInterceptingEvents;
                    break;
                case 1:
                    break;
                default:
                    break;
            }
        }
        this.mInterceptingEvents = false;
        if (!z) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return this.mViewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mViewDragHelper == null) {
            return null;
        }
        this.mViewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        if (this.mViewDragHelper == null) {
            if (this.mSensitivitySet) {
                viewGroup = ViewDragHelper.create(viewGroup, this.mSensitivity, this.mDragCallback);
            } else {
                viewGroup = ViewDragHelper.create(viewGroup, this.mDragCallback);
            }
            this.mViewDragHelper = viewGroup;
        }
    }

    static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public int getDragState() {
        return this.mViewDragHelper != null ? this.mViewDragHelper.getViewDragState() : 0;
    }
}
