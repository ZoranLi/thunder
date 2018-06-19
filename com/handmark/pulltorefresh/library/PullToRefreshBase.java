package com.handmark.pulltorefresh.library;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.handmark.pulltorefresh.library.a.h;
import com.xunlei.common.R;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout {
    static final boolean DEBUG = false;
    static final int DEMO_SCROLL_INTERVAL = 225;
    static final float FRICTION = 2.0f;
    static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 600;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    static final boolean USE_HW_LAYERS = false;
    private Mode mCurrentMode;
    private g mCurrentSmoothScrollRunnable;
    private boolean mFilterTouchEvents = true;
    private com.handmark.pulltorefresh.library.a.f mFooterLayout;
    private int mHeaderHeight;
    private com.handmark.pulltorefresh.library.a.f mHeaderLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged = false;
    public boolean mIsPressing;
    private float mLastMotionX;
    private float mLastMotionY;
    private int mLastValue;
    private boolean mLayoutVisibilityChangesEnabled = true;
    private AnimationStyle mLoadingAnimationStyle = AnimationStyle.getDefault();
    private Mode mMode = Mode.getDefault();
    private b<T> mOnPullEventListener;
    private c mOnPullScrollListener;
    private d<T> mOnRefreshListener;
    protected e<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled = true;
    protected T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    private boolean mScrollingWhileRefreshingEnabled = false;
    private boolean mShowViewWhileRefreshing = true;
    protected State mState = State.RESET;
    private int mTouchSlop;

    public enum AnimationStyle {
        ROTATE,
        FLIP;

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i) {
            if (i != 1) {
                return ROTATE;
            }
            return FLIP;
        }

        final com.handmark.pulltorefresh.library.a.f createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            if (j.d[ordinal()] != 2) {
                return new h(context, mode, orientation, typedArray);
            }
            return new com.handmark.pulltorefresh.library.a.b(context, mode, orientation, typedArray);
        }
    }

    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        private int mIntValue;

        static Mode mapIntToValue(int i) {
            for (Mode mode : values()) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        private Mode(int i) {
            this.mIntValue = i;
        }

        final boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : true;
        }

        public final boolean showHeaderLoadingLayout() {
            if (this != PULL_FROM_START) {
                if (this != BOTH) {
                    return false;
                }
            }
            return true;
        }

        public final boolean showFooterLoadingLayout() {
            if (!(this == PULL_FROM_END || this == BOTH)) {
                if (this != MANUAL_REFRESH_ONLY) {
                    return false;
                }
            }
            return true;
        }

        final int getIntValue() {
            return this.mIntValue;
        }
    }

    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        static State mapIntToValue(int i) {
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        private State(int i) {
            this.mIntValue = i;
        }

        final int getIntValue() {
            return this.mIntValue;
        }
    }

    public interface a {
        void a();
    }

    public interface b<V extends View> {
    }

    public interface c {
    }

    public interface d<V extends View> {
        void a(PullToRefreshBase<V> pullToRefreshBase);
    }

    public interface e<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    interface f {
        void a();
    }

    final class g implements Runnable {
        boolean a = true;
        final /* synthetic */ PullToRefreshBase b;
        private final Interpolator c;
        private final int d;
        private final int e;
        private final long f;
        private f g;
        private long h = -1;
        private int i = -1;

        public g(PullToRefreshBase pullToRefreshBase, int i, int i2, long j, f fVar) {
            this.b = pullToRefreshBase;
            this.e = i;
            this.d = i2;
            this.c = pullToRefreshBase.mScrollAnimationInterpolator;
            this.f = j;
            this.g = fVar;
        }

        public final void run() {
            if (this.h == -1) {
                this.h = System.currentTimeMillis();
            } else {
                this.i = this.e - Math.round(((float) (this.e - this.d)) * this.c.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.h) * 1000) / this.f, 1000), 0)) / 1000.0f));
                this.b.setScrollValue(this.i);
            }
            if (!this.a || this.d == this.i) {
                if (this.g != null) {
                    this.g.a();
                }
                return;
            }
            View view = this.b;
            if (VERSION.SDK_INT >= 16) {
                view.postOnAnimation(this);
            } else {
                view.postDelayed(this, 16);
            }
        }
    }

    public abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return 600;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return 325;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
    }

    public abstract boolean isReadyForPullEnd();

    public abstract boolean isReadyForPullStart();

    protected boolean needResetToHeadBegin() {
        return true;
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
    }

    public void scrollToTopAndRefreshing() {
    }

    public void setScrollBar(int i) {
    }

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mMode = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mMode = mode;
        this.mLoadingAnimationStyle = animationStyle;
        init(context, null);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        View refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    public final boolean demo() {
        if (this.mMode.showHeaderLoadingLayout() && isReadyForPullStart()) {
            smoothScrollToAndBack((-getHeaderSize()) * 2);
            return true;
        } else if (!this.mMode.showFooterLoadingLayout() || !isReadyForPullEnd()) {
            return false;
        } else {
            smoothScrollToAndBack(getFooterSize() * 2);
            return true;
        }
    }

    public final Mode getCurrentMode() {
        return this.mCurrentMode;
    }

    public final boolean getFilterTouchEvents() {
        return this.mFilterTouchEvents;
    }

    public final a getLoadingLayoutProxy() {
        return getLoadingLayoutProxy(true, true);
    }

    public final a getLoadingLayoutProxy(boolean z, boolean z2) {
        return createLoadingLayoutProxy(z, z2);
    }

    public final Mode getMode() {
        return this.mMode;
    }

    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.mShowViewWhileRefreshing;
    }

    public final State getState() {
        return this.mState;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.mMode.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        if (VERSION.SDK_INT >= 9 && this.mOverScrollEnabled) {
            if (this.mRefreshableView.getOverScrollMode() != 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean isRefreshing() {
        if (this.mState != State.REFRESHING) {
            if (this.mState != State.MANUAL_REFRESHING) {
                return false;
            }
        }
        return true;
    }

    protected boolean canForceHeaderScroll() {
        return ((this.mState == State.REFRESHING && this.mCurrentMode == Mode.PULL_FROM_START) || this.mState == State.MANUAL_REFRESHING) ? false : true;
    }

    public final boolean isScrollingWhileRefreshingEnabled() {
        return this.mScrollingWhileRefreshingEnabled;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 3) {
            if (action != 1) {
                if (action != 0 && this.mIsBeingDragged) {
                    return true;
                }
                float y;
                if (action != 0) {
                    if (action == 2) {
                        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
                            return true;
                        }
                        if (isReadyForPull()) {
                            float f;
                            y = motionEvent.getY();
                            motionEvent = motionEvent.getX();
                            float f2;
                            if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
                                f = y - this.mLastMotionY;
                                f2 = motionEvent - this.mLastMotionX;
                            } else {
                                f = motionEvent - this.mLastMotionX;
                                f2 = y - this.mLastMotionY;
                            }
                            float abs = Math.abs(f);
                            if (abs > ((float) this.mTouchSlop) && (!this.mFilterTouchEvents || abs > Math.abs(r3))) {
                                if (this.mMode.showHeaderLoadingLayout() && f >= 1.0f && isReadyForPullStart()) {
                                    this.mLastMotionY = y;
                                    this.mLastMotionX = motionEvent;
                                    this.mIsBeingDragged = true;
                                    if (this.mMode == Mode.BOTH) {
                                        this.mCurrentMode = Mode.PULL_FROM_START;
                                    }
                                } else if (this.mMode.showFooterLoadingLayout() && f <= -1.0f && isReadyForPullEnd()) {
                                    this.mLastMotionY = y;
                                    this.mLastMotionX = motionEvent;
                                    this.mIsBeingDragged = true;
                                    if (this.mMode == Mode.BOTH) {
                                        this.mCurrentMode = Mode.PULL_FROM_END;
                                    }
                                }
                            }
                        }
                    }
                } else if (isReadyForPull()) {
                    y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    motionEvent = motionEvent.getX();
                    this.mInitialMotionX = motionEvent;
                    this.mLastMotionX = motionEvent;
                    this.mIsBeingDragged = false;
                }
                new StringBuilder("BeingDragger:  ============ ").append(this.mIsBeingDragged);
                return this.mIsBeingDragged;
            }
        }
        this.mIsBeingDragged = false;
        return false;
    }

    public void onRefreshComplete() {
        if (isRefreshing()) {
            setState(State.RESET, new boolean[0]);
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        StringBuilder stringBuilder = new StringBuilder("touch action ");
        stringBuilder.append(motionEvent.getAction());
        stringBuilder.append(" y ");
        stringBuilder.append(motionEvent.getY());
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.mIsPressing = true;
                if (isReadyForPull()) {
                    float y = motionEvent.getY();
                    this.mInitialMotionY = y;
                    this.mLastMotionY = y;
                    motionEvent = motionEvent.getX();
                    this.mInitialMotionX = motionEvent;
                    this.mLastMotionX = motionEvent;
                    return true;
                }
                break;
            case 1:
            case 3:
                this.mIsPressing = false;
                if (this.mIsBeingDragged != null) {
                    this.mIsBeingDragged = false;
                    if (this.mState == State.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
                        setState(State.REFRESHING, true);
                        return true;
                    } else if (isRefreshing() != null) {
                        if (needResetToHeadBegin() != null) {
                            smoothScrollTo(-getHeaderSize());
                        } else {
                            smoothScrollTo(0);
                        }
                        return true;
                    } else {
                        setState(State.RESET, new boolean[0]);
                        return true;
                    }
                }
                break;
            case 2:
                this.mIsPressing = true;
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = motionEvent.getY();
                    this.mLastMotionX = motionEvent.getX();
                    pullEvent();
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.mScrollingWhileRefreshingEnabled = z;
    }

    public final void setFilterTouchEvents(boolean z) {
        this.mFilterTouchEvents = z;
    }

    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.mMode) {
            this.mMode = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(b<T> bVar) {
        this.mOnPullEventListener = bVar;
    }

    public void setOnPullScrollListener(c cVar) {
        this.mOnPullScrollListener = cVar;
    }

    public final void setOnRefreshListener(d<T> dVar) {
        this.mOnRefreshListener = dVar;
        this.mOnRefreshListener2 = null;
    }

    public final void setOnRefreshListener(e<T> eVar) {
        this.mOnRefreshListener2 = eVar;
        this.mOnRefreshListener = null;
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.mOverScrollEnabled = z;
    }

    public final void setRefreshing() {
        setRefreshing(true);
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            setState(State.MANUAL_REFRESHING, z);
        }
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.mScrollAnimationInterpolator = interpolator;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.mShowViewWhileRefreshing = z;
    }

    final void setState(State state, boolean... zArr) {
        this.mState = state;
        switch (j.b[this.mState.ordinal()]) {
            case 1:
                onReset();
                return;
            case 2:
                onPullToRefresh();
                return;
            case 3:
                onReleaseToRefresh();
                return;
            case 4:
            case 5:
                onRefreshing(zArr[null]);
                break;
            default:
                break;
        }
    }

    protected final void headerRefreshingForce() {
        this.mState = State.MANUAL_REFRESHING;
        this.mCurrentMode = Mode.PULL_FROM_START;
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.f();
        }
        smoothScrollTo(-getHeaderSize(), new f(this));
    }

    protected final void addViewInternal(View view, int i, LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void addViewInternal(View view, LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected com.handmark.pulltorefresh.library.a.f createLoadingLayout(Context context, Mode mode, TypedArray typedArray) {
        return this.mLoadingAnimationStyle.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
    }

    protected b createLoadingLayoutProxy(boolean z, boolean z2) {
        b bVar = new b();
        if (z && this.mMode.showHeaderLoadingLayout()) {
            bVar.a(this.mHeaderLayout);
        }
        if (z2 && this.mMode.showFooterLoadingLayout()) {
            bVar.a(this.mFooterLayout);
        }
        return bVar;
    }

    protected final void disableLoadingLayoutVisibilityChanges() {
        this.mLayoutVisibilityChangesEnabled = false;
    }

    protected final com.handmark.pulltorefresh.library.a.f getFooterLayout() {
        return this.mFooterLayout;
    }

    protected final int getFooterSize() {
        return this.mFooterLayout.getContentSize();
    }

    protected final com.handmark.pulltorefresh.library.a.f getHeaderLayout() {
        return this.mHeaderLayout;
    }

    protected final int getHeaderSize() {
        if (this.mHeaderHeight == 0) {
            this.mHeaderHeight = this.mHeaderLayout.getContentSize();
        }
        return this.mHeaderHeight;
    }

    public FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    protected void onPullToRefresh() {
        switch (j.c[this.mCurrentMode.ordinal()]) {
            case 1:
                this.mFooterLayout.e();
                return;
            case 2:
                this.mHeaderLayout.e();
                break;
            default:
                break;
        }
    }

    protected void onRefreshing(boolean z) {
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.f();
        }
        if (this.mMode.showFooterLoadingLayout()) {
            this.mFooterLayout.f();
        }
        if (!z) {
            callRefreshListener();
        } else if (this.mShowViewWhileRefreshing) {
            f gVar = new g(this);
            if (j.c[this.mCurrentMode.ordinal()] != 1) {
                smoothScrollTo(-getHeaderSize(), gVar);
            } else {
                smoothScrollTo(getFooterSize(), gVar);
            }
        } else {
            smoothScrollTo(false);
        }
    }

    protected void onReleaseToRefresh() {
        if (j.c[this.mCurrentMode.ordinal()] == 1) {
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.mLayoutVisibilityChangesEnabled = true;
        this.mHeaderLayout.g();
        this.mFooterLayout.g();
        smoothScrollTo(0);
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt(STATE_MODE, 0)));
            this.mCurrentMode = Mode.mapIntToValue(bundle.getInt(STATE_CURRENT_MODE, 0));
            this.mScrollingWhileRefreshingEnabled = bundle.getBoolean(STATE_SCROLLING_REFRESHING_ENABLED, false);
            this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, true);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            State mapIntToValue = State.mapIntToValue(bundle.getInt(STATE_STATE, 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                setState(mapIntToValue, true);
            }
            onPtrRestoreInstanceState(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle(9);
        onPtrSaveInstanceState(bundle);
        bundle.putInt(STATE_STATE, this.mState.getIntValue());
        bundle.putInt(STATE_MODE, this.mMode.getIntValue());
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.getIntValue());
        bundle.putBoolean(STATE_SCROLLING_REFRESHING_ENABLED, this.mScrollingWhileRefreshingEnabled);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new h(this));
    }

    protected final void refreshLoadingViewsSize() {
        int maximumPullScroll = (int) (((float) getMaximumPullScroll()) * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        switch (j.a[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (this.mMode.showHeaderLoadingLayout()) {
                    this.mHeaderLayout.setWidth(maximumPullScroll);
                    paddingLeft = -maximumPullScroll;
                } else {
                    paddingLeft = 0;
                }
                if (!this.mMode.showFooterLoadingLayout()) {
                    paddingRight = 0;
                    break;
                }
                this.mFooterLayout.setWidth(maximumPullScroll);
                paddingRight = -maximumPullScroll;
                break;
            case 2:
                if (this.mMode.showHeaderLoadingLayout()) {
                    this.mHeaderLayout.setHeight(maximumPullScroll);
                    paddingTop = -maximumPullScroll;
                } else {
                    paddingTop = 0;
                }
                if (!this.mMode.showFooterLoadingLayout()) {
                    paddingBottom = 0;
                    break;
                }
                this.mFooterLayout.setHeight(maximumPullScroll);
                paddingBottom = -maximumPullScroll;
                break;
            default:
                break;
        }
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    protected final void refreshRefreshableViewSize(int i, int i2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        switch (j.a[getPullToRefreshScrollDirection().ordinal()]) {
            case 1:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                break;
            case 2:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.mRefreshableViewWrapper.requestLayout();
                    break;
                }
                break;
            default:
                break;
        }
    }

    @SuppressLint({"InlinedApi"})
    protected final void setScrollValue(int i) {
        int maximumPullScroll = getMaximumPullScroll();
        i = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.mLayoutVisibilityChangesEnabled) {
            if (i < 0) {
                this.mHeaderLayout.setVisibility(0);
                this.mHeaderLayout.a(i, this.mState, this.mCurrentMode);
            } else if (i > 0) {
                this.mFooterLayout.setVisibility(0);
                this.mFooterLayout.a(i, this.mState, this.mCurrentMode);
            } else {
                this.mHeaderLayout.setVisibility(4);
                this.mFooterLayout.setVisibility(4);
            }
        }
        if (canUseLayer()) {
            View view = this.mRefreshableViewWrapper;
            int i2 = i != 0 ? 2 : 0;
            if (VERSION.SDK_INT >= 11) {
                view.setLayerType(i2, null);
            }
        }
        if (this.mState == State.MANUAL_REFRESHING || getMode() != Mode.PULL_FROM_START || this.mIsPressing || i >= 0 || i >= this.mLastValue) {
            switch (j.a[getPullToRefreshScrollDirection().ordinal()]) {
                case 1:
                    scrollTo(i, 0);
                    break;
                case 2:
                    scrollTo(0, i);
                    break;
                default:
                    break;
            }
            this.mLastValue = i;
        }
    }

    boolean canUseLayer() {
        int i = VERSION.SDK_INT;
        return false;
    }

    protected final void smoothScrollTo(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration());
    }

    protected final void smoothScrollTo(int i, f fVar) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration(), 0, fVar);
    }

    protected final void smoothScrollToLonger(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDurationLonger());
    }

    protected void updateUIForMode() {
        LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.mHeaderLayout.getParent()) {
            removeView(this.mHeaderLayout);
        }
        if (this.mMode.showHeaderLoadingLayout()) {
            addViewInternal(this.mHeaderLayout, 0, loadingLayoutLayoutParams);
        }
        if (this == this.mFooterLayout.getParent()) {
            removeView(this.mFooterLayout);
        }
        if (this.mMode.showFooterLoadingLayout()) {
            addViewInternal(this.mFooterLayout, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.mCurrentMode = this.mMode != Mode.BOTH ? this.mMode : Mode.PULL_FROM_START;
    }

    private void addRefreshableView(Context context, T t) {
        this.mRefreshableViewWrapper = new FrameLayout(context);
        this.mRefreshableViewWrapper.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LinearLayout.LayoutParams(-1, -1));
    }

    private void callRefreshListener() {
        if (this.mOnRefreshListener != null) {
            this.mOnRefreshListener.a(this);
            return;
        }
        if (this.mOnRefreshListener2 != null) {
            if (this.mCurrentMode == Mode.PULL_FROM_START) {
                this.mOnRefreshListener2.onPullDownToRefresh(this);
            } else if (this.mCurrentMode == Mode.PULL_FROM_END) {
                this.mOnRefreshListener2.onPullUpToRefresh(this);
            }
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh, 0, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrMode)) {
            this.mMode = Mode.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAnimationStyle)) {
            this.mLoadingAnimationStyle = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrAnimationStyle, 0));
        }
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.mRefreshableView);
        this.mHeaderLayout = createLoadingLayout(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.mFooterLayout = createLoadingLayout(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrRefreshableViewBackground) != null) {
            context = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrRefreshableViewBackground);
            if (context != null) {
                this.mRefreshableView.setBackgroundDrawable(context);
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAdapterViewBackground) != null) {
            StringBuilder stringBuilder = new StringBuilder("You're using the deprecated ");
            stringBuilder.append("ptrAdapterViewBackground");
            stringBuilder.append(" attr, please switch over to ");
            stringBuilder.append("ptrRefreshableViewBackground");
            context = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrAdapterViewBackground);
            if (context != null) {
                this.mRefreshableView.setBackgroundDrawable(context);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrOverScroll) != null) {
            this.mOverScrollEnabled = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrOverScroll, true);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled) != null) {
            this.mScrollingWhileRefreshingEnabled = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrFooterRefreshViewShow) != null && obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrFooterRefreshViewShow, true) == null) {
            setFooterViewNotShow();
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrHeaderRefreshViewShow) != null && obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrHeaderRefreshViewShow, true) == null) {
            setHeaderViewNotShow();
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean isReadyForPull() {
        int i = j.c[this.mMode.ordinal()];
        if (i != 4) {
            switch (i) {
                case 1:
                    return isReadyForPullEnd();
                case 2:
                    return isReadyForPullStart();
                default:
                    return false;
            }
        }
        if (!isReadyForPullEnd()) {
            if (!isReadyForPullStart()) {
                return false;
            }
        }
        return true;
    }

    private void pullEvent() {
        float f;
        float f2;
        int round;
        int headerSize;
        if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            f = this.mInitialMotionY;
            f2 = this.mLastMotionY;
        } else {
            f = this.mInitialMotionX;
            f2 = this.mLastMotionX;
        }
        if (j.c[this.mCurrentMode.ordinal()] != 1) {
            round = Math.round(Math.min(f - f2, 0.0f) / FRICTION);
            headerSize = getHeaderSize();
        } else {
            round = Math.round(Math.max(f - f2, 0.0f) / FRICTION);
            headerSize = getFooterSize();
        }
        setScrollValue(round);
        if (!(round == 0 || isRefreshing())) {
            float abs = ((float) Math.abs(round)) / ((float) headerSize);
            if (j.c[this.mCurrentMode.ordinal()] != 1) {
                this.mHeaderLayout.b(abs);
            } else {
                this.mFooterLayout.b(abs);
            }
            if (!isRefreshing()) {
                if (this.mState != State.PULL_TO_REFRESH && headerSize >= Math.abs(round)) {
                    setState(State.PULL_TO_REFRESH, new boolean[0]);
                } else if (this.mState == State.PULL_TO_REFRESH && headerSize < Math.abs(round)) {
                    setState(State.RELEASE_TO_REFRESH, new boolean[0]);
                }
            }
        }
    }

    private LinearLayout.LayoutParams getLoadingLayoutLayoutParams() {
        if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return new LinearLayout.LayoutParams(-1, -2);
        }
        return new LinearLayout.LayoutParams(-2, -1);
    }

    private int getMaximumPullScroll() {
        if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            return Math.round(((float) getHeight()) / FRICTION);
        }
        return Math.round(((float) getWidth()) / FRICTION);
    }

    private final void smoothScrollTo(int i, long j) {
        smoothScrollTo(i, j, 0, null);
    }

    private final void smoothScrollTo(int i, long j, long j2, f fVar) {
        int scrollY;
        if (this.mCurrentSmoothScrollRunnable != null) {
            Runnable runnable = this.mCurrentSmoothScrollRunnable;
            runnable.a = false;
            runnable.b.removeCallbacks(runnable);
        }
        if (j.a[getPullToRefreshScrollDirection().ordinal()] != 1) {
            scrollY = getScrollY();
        } else {
            scrollY = getScrollX();
        }
        int i2 = scrollY;
        if (i2 != i) {
            if (this.mScrollAnimationInterpolator == null) {
                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            this.mCurrentSmoothScrollRunnable = new g(this, i2, i, j, fVar);
            if (j2 > 0) {
                postDelayed(this.mCurrentSmoothScrollRunnable, j2);
                return;
            }
            post(this.mCurrentSmoothScrollRunnable);
        }
    }

    private final void smoothScrollToAndBack(int i) {
        smoothScrollTo(i, 600, 0, new i(this));
    }

    public void setHeaderViewNotShow() {
        if (this.mHeaderLayout != null) {
            this.mHeaderLayout.setVisibility(4);
            this.mHeaderLayout.removeAllViews();
        }
    }

    public void setFooterViewNotShow() {
        if (this.mFooterLayout != null) {
            com.handmark.pulltorefresh.library.a.f.d();
            this.mFooterLayout.setVisibility(4);
            this.mFooterLayout.removeAllViews();
        }
    }
}
