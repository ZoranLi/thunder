package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public final class GestureDetectorCompat {
    private final GestureDetectorCompatImpl mImpl;

    interface GestureDetectorCompatImpl {
        boolean isLongpressEnabled();

        boolean onTouchEvent(MotionEvent motionEvent);

        void setIsLongpressEnabled(boolean z);

        void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener);
    }

    static class GestureDetectorCompatImplBase implements GestureDetectorCompatImpl {
        private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
        private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
        private static final int LONG_PRESS = 2;
        private static final int SHOW_PRESS = 1;
        private static final int TAP = 3;
        private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
        private boolean mAlwaysInBiggerTapRegion;
        private boolean mAlwaysInTapRegion;
        MotionEvent mCurrentDownEvent;
        boolean mDeferConfirmSingleTap;
        OnDoubleTapListener mDoubleTapListener;
        private int mDoubleTapSlopSquare;
        private float mDownFocusX;
        private float mDownFocusY;
        private final Handler mHandler;
        private boolean mInLongPress;
        private boolean mIsDoubleTapping;
        private boolean mIsLongpressEnabled;
        private float mLastFocusX;
        private float mLastFocusY;
        final OnGestureListener mListener;
        private int mMaximumFlingVelocity;
        private int mMinimumFlingVelocity;
        private MotionEvent mPreviousUpEvent;
        boolean mStillDown;
        private int mTouchSlopSquare;
        private VelocityTracker mVelocityTracker;

        private class GestureHandler extends Handler {
            GestureHandler() {
            }

            GestureHandler(Handler handler) {
                super(handler.getLooper());
            }

            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        GestureDetectorCompatImplBase.this.mListener.onShowPress(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                        return;
                    case 2:
                        GestureDetectorCompatImplBase.this.dispatchLongPress();
                        return;
                    case 3:
                        if (GestureDetectorCompatImplBase.this.mDoubleTapListener == null) {
                            return;
                        }
                        if (GestureDetectorCompatImplBase.this.mStillDown == null) {
                            GestureDetectorCompatImplBase.this.mDoubleTapListener.onSingleTapConfirmed(GestureDetectorCompatImplBase.this.mCurrentDownEvent);
                            return;
                        } else {
                            GestureDetectorCompatImplBase.this.mDeferConfirmSingleTap = true;
                            return;
                        }
                    default:
                        StringBuilder stringBuilder = new StringBuilder("Unknown message ");
                        stringBuilder.append(message);
                        throw new RuntimeException(stringBuilder.toString());
                }
            }
        }

        public GestureDetectorCompatImplBase(Context context, OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.mHandler = new GestureHandler(handler);
            } else {
                this.mHandler = new GestureHandler();
            }
            this.mListener = onGestureListener;
            if ((onGestureListener instanceof OnDoubleTapListener) != null) {
                setOnDoubleTapListener((OnDoubleTapListener) onGestureListener);
            }
            init(context);
        }

        private void init(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.mListener == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            } else {
                this.mIsLongpressEnabled = true;
                context = ViewConfiguration.get(context);
                int scaledTouchSlop = context.getScaledTouchSlop();
                int scaledDoubleTapSlop = context.getScaledDoubleTapSlop();
                this.mMinimumFlingVelocity = context.getScaledMinimumFlingVelocity();
                this.mMaximumFlingVelocity = context.getScaledMaximumFlingVelocity();
                this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
                this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
            }
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDoubleTapListener = onDoubleTapListener;
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mIsLongpressEnabled = z;
        }

        public boolean isLongpressEnabled() {
            return this.mIsLongpressEnabled;
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            int i;
            int action = motionEvent.getAction();
            if (this.mVelocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            }
            this.mVelocityTracker.addMovement(motionEvent);
            action &= 255;
            boolean z = action == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = f;
            for (i = 0; i < pointerCount; i++) {
                if (actionIndex != i) {
                    f += motionEvent.getX(i);
                    f2 += motionEvent.getY(i);
                }
            }
            float f3 = (float) (z ? pointerCount - 1 : pointerCount);
            f /= f3;
            f2 /= f3;
            int pointerId;
            switch (action) {
                case 0:
                    if (this.mDoubleTapListener != null) {
                        boolean hasMessages = this.mHandler.hasMessages(3);
                        if (hasMessages) {
                            this.mHandler.removeMessages(3);
                        }
                        if (this.mCurrentDownEvent == null || this.mPreviousUpEvent == null || !hasMessages || !isConsideredDoubleTap(this.mCurrentDownEvent, this.mPreviousUpEvent, motionEvent)) {
                            this.mHandler.sendEmptyMessageDelayed(3, (long) DOUBLE_TAP_TIMEOUT);
                        } else {
                            this.mIsDoubleTapping = true;
                            action = (this.mDoubleTapListener.onDoubleTap(this.mCurrentDownEvent) | 0) | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                            this.mLastFocusX = f;
                            this.mDownFocusX = f;
                            this.mLastFocusY = f2;
                            this.mDownFocusY = f2;
                            if (this.mCurrentDownEvent != null) {
                                this.mCurrentDownEvent.recycle();
                            }
                            this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                            this.mAlwaysInTapRegion = true;
                            this.mAlwaysInBiggerTapRegion = true;
                            this.mStillDown = true;
                            this.mInLongPress = false;
                            this.mDeferConfirmSingleTap = false;
                            if (this.mIsLongpressEnabled) {
                                this.mHandler.removeMessages(2);
                                this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) LONGPRESS_TIMEOUT));
                            }
                            this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
                            return action | this.mListener.onDown(motionEvent);
                        }
                    }
                    action = 0;
                    this.mLastFocusX = f;
                    this.mDownFocusX = f;
                    this.mLastFocusY = f2;
                    this.mDownFocusY = f2;
                    if (this.mCurrentDownEvent != null) {
                        this.mCurrentDownEvent.recycle();
                    }
                    this.mCurrentDownEvent = MotionEvent.obtain(motionEvent);
                    this.mAlwaysInTapRegion = true;
                    this.mAlwaysInBiggerTapRegion = true;
                    this.mStillDown = true;
                    this.mInLongPress = false;
                    this.mDeferConfirmSingleTap = false;
                    if (this.mIsLongpressEnabled) {
                        this.mHandler.removeMessages(2);
                        this.mHandler.sendEmptyMessageAtTime(2, (this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT)) + ((long) LONGPRESS_TIMEOUT));
                    }
                    this.mHandler.sendEmptyMessageAtTime(1, this.mCurrentDownEvent.getDownTime() + ((long) TAP_TIMEOUT));
                    return action | this.mListener.onDown(motionEvent);
                case 1:
                    this.mStillDown = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.mIsDoubleTapping) {
                        motionEvent = this.mDoubleTapListener.onDoubleTapEvent(motionEvent) | null;
                    } else {
                        if (this.mInLongPress) {
                            this.mHandler.removeMessages(3);
                            this.mInLongPress = false;
                        } else if (this.mAlwaysInTapRegion) {
                            z = this.mListener.onSingleTapUp(motionEvent);
                            if (this.mDeferConfirmSingleTap && this.mDoubleTapListener != null) {
                                this.mDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                            motionEvent = z;
                        } else {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                            f3 = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(f3) <= ((float) this.mMinimumFlingVelocity)) {
                                if (Math.abs(xVelocity) > ((float) this.mMinimumFlingVelocity)) {
                                }
                            }
                            motionEvent = this.mListener.onFling(this.mCurrentDownEvent, motionEvent, xVelocity, f3);
                        }
                        motionEvent = null;
                    }
                    if (this.mPreviousUpEvent != null) {
                        this.mPreviousUpEvent.recycle();
                    }
                    this.mPreviousUpEvent = obtain;
                    if (this.mVelocityTracker != null) {
                        this.mVelocityTracker.recycle();
                        this.mVelocityTracker = null;
                    }
                    this.mIsDoubleTapping = false;
                    this.mDeferConfirmSingleTap = false;
                    this.mHandler.removeMessages(1);
                    this.mHandler.removeMessages(2);
                    break;
                case 2:
                    if (this.mInLongPress) {
                        return false;
                    }
                    float f4 = this.mLastFocusX - f;
                    f3 = this.mLastFocusY - f2;
                    if (this.mIsDoubleTapping) {
                        return false | this.mDoubleTapListener.onDoubleTapEvent(motionEvent);
                    }
                    if (this.mAlwaysInTapRegion) {
                        pointerCount = (int) (f - this.mDownFocusX);
                        pointerId = (int) (f2 - this.mDownFocusY);
                        pointerCount = (pointerCount * pointerCount) + (pointerId * pointerId);
                        if (pointerCount > this.mTouchSlopSquare) {
                            motionEvent = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, f3);
                            this.mLastFocusX = f;
                            this.mLastFocusY = f2;
                            this.mAlwaysInTapRegion = false;
                            this.mHandler.removeMessages(3);
                            this.mHandler.removeMessages(1);
                            this.mHandler.removeMessages(2);
                        } else {
                            motionEvent = null;
                        }
                        if (pointerCount > this.mTouchSlopSquare) {
                            this.mAlwaysInBiggerTapRegion = false;
                            break;
                        }
                    } else if (Math.abs(f4) < 1.0f && Math.abs(f3) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.mListener.onScroll(this.mCurrentDownEvent, motionEvent, f4, f3);
                        this.mLastFocusX = f;
                        this.mLastFocusY = f2;
                        return onScroll;
                    }
                    break;
                case 3:
                    cancel();
                    return false;
                case 5:
                    this.mLastFocusX = f;
                    this.mDownFocusX = f;
                    this.mLastFocusY = f2;
                    this.mDownFocusY = f2;
                    cancelTaps();
                    return false;
                case 6:
                    this.mLastFocusX = f;
                    this.mDownFocusX = f;
                    this.mLastFocusY = f2;
                    this.mDownFocusY = f2;
                    this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumFlingVelocity);
                    action = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(action);
                    float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                    f3 = this.mVelocityTracker.getYVelocity(pointerId2);
                    for (actionIndex = 0; actionIndex < pointerCount; actionIndex++) {
                        if (actionIndex != action) {
                            i = motionEvent.getPointerId(actionIndex);
                            if ((this.mVelocityTracker.getXVelocity(i) * xVelocity2) + (this.mVelocityTracker.getYVelocity(i) * f3) < 0.0f) {
                                this.mVelocityTracker.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                default:
                    return false;
            }
            return motionEvent;
        }

        private void cancel() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
            this.mIsDoubleTapping = false;
            this.mStillDown = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private void cancelTaps() {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(3);
            this.mIsDoubleTapping = false;
            this.mAlwaysInTapRegion = false;
            this.mAlwaysInBiggerTapRegion = false;
            this.mDeferConfirmSingleTap = false;
            if (this.mInLongPress) {
                this.mInLongPress = false;
            }
        }

        private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.mAlwaysInBiggerTapRegion || motionEvent3.getEventTime() - motionEvent2.getEventTime() > ((long) DOUBLE_TAP_TIMEOUT)) {
                return false;
            }
            motionEvent2 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            motionEvent = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((motionEvent2 * motionEvent2) + (motionEvent * motionEvent) < this.mDoubleTapSlopSquare) {
                return true;
            }
            return false;
        }

        void dispatchLongPress() {
            this.mHandler.removeMessages(3);
            this.mDeferConfirmSingleTap = false;
            this.mInLongPress = true;
            this.mListener.onLongPress(this.mCurrentDownEvent);
        }
    }

    static class GestureDetectorCompatImplJellybeanMr2 implements GestureDetectorCompatImpl {
        private final GestureDetector mDetector;

        public GestureDetectorCompatImplJellybeanMr2(Context context, OnGestureListener onGestureListener, Handler handler) {
            this.mDetector = new GestureDetector(context, onGestureListener, handler);
        }

        public boolean isLongpressEnabled() {
            return this.mDetector.isLongpressEnabled();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            return this.mDetector.onTouchEvent(motionEvent);
        }

        public void setIsLongpressEnabled(boolean z) {
            this.mDetector.setIsLongpressEnabled(z);
        }

        public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
            this.mDetector.setOnDoubleTapListener(onDoubleTapListener);
        }
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public GestureDetectorCompat(Context context, OnGestureListener onGestureListener, Handler handler) {
        if (VERSION.SDK_INT > 17) {
            this.mImpl = new GestureDetectorCompatImplJellybeanMr2(context, onGestureListener, handler);
        } else {
            this.mImpl = new GestureDetectorCompatImplBase(context, onGestureListener, handler);
        }
    }

    public final boolean isLongpressEnabled() {
        return this.mImpl.isLongpressEnabled();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mImpl.onTouchEvent(motionEvent);
    }

    public final void setIsLongpressEnabled(boolean z) {
        this.mImpl.setIsLongpressEnabled(z);
    }

    public final void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.mImpl.setOnDoubleTapListener(onDoubleTapListener);
    }
}
