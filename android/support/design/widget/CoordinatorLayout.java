package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.annotation.VisibleForTesting;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = new ThreadLocal();
    private static final Pool<Rect> sRectPool = new SynchronizedPool(12);
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph<View> mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    OnHierarchyChangeListener mOnHierarchyChangeListener;
    private OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List<View> mTempList1;

    public static abstract class Behavior<V extends View> {
        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Rect rect) {
            return false;
        }

        @ColorInt
        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        public void onAttachedToLayoutParams(@NonNull LayoutParams layoutParams) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f, float f2) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v) {
            return getScrimOpacity(coordinatorLayout, v) > null ? true : null;
        }

        public static void setTag(View view, Object obj) {
            ((LayoutParams) view.getLayoutParams()).mBehaviorTag = obj;
        }

        public static Object getTag(View view) {
            return ((LayoutParams) view.getLayoutParams()).mBehaviorTag;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
            return i2 == 0 ? onStartNestedScroll(coordinatorLayout, v, view, view2, i) : null;
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i, int i2) {
            if (i2 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v, view, view2, i);
            }
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i) {
            if (i == 0) {
                onStopNestedScroll(coordinatorLayout, v, view);
            }
        }

        public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                onNestedScroll(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i, int i2, @NonNull int[] iArr, int i3) {
            if (i3 == 0) {
                onNestedPreScroll(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
            return BaseSavedState.EMPTY_STATE;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface DispatchChangeEvent {
    }

    private class HierarchyChangeListener implements OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.onChildViewsChanged(2);
            if (CoordinatorLayout.this.mOnHierarchyChangeListener != null) {
                CoordinatorLayout.this.mOnHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public static class LayoutParams extends MarginLayoutParams {
        public int anchorGravity = 0;
        public int dodgeInsetEdges = 0;
        public int gravity = 0;
        public int insetEdge = 0;
        public int keyline = -1;
        View mAnchorDirectChild;
        int mAnchorId = -1;
        View mAnchorView;
        Behavior mBehavior;
        boolean mBehaviorResolved = false;
        Object mBehaviorTag;
        private boolean mDidAcceptNestedScrollNonTouch;
        private boolean mDidAcceptNestedScrollTouch;
        private boolean mDidBlockInteraction;
        private boolean mDidChangeAfterNestedScroll;
        int mInsetOffsetX;
        int mInsetOffsetY;
        final Rect mLastChildRect = new Rect();

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.gravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.mAnchorId = obtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.anchorGravity = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.keyline = obtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.insetEdge = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.dodgeInsetEdges = obtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.mBehaviorResolved = obtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.mBehaviorResolved) {
                this.mBehavior = CoordinatorLayout.parseBehavior(context, attributeSet, obtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            obtainStyledAttributes.recycle();
            if (this.mBehavior != null) {
                this.mBehavior.onAttachedToLayoutParams(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        @IdRes
        public int getAnchorId() {
            return this.mAnchorId;
        }

        public void setAnchorId(@IdRes int i) {
            invalidateAnchor();
            this.mAnchorId = i;
        }

        @Nullable
        public Behavior getBehavior() {
            return this.mBehavior;
        }

        public void setBehavior(@Nullable Behavior behavior) {
            if (this.mBehavior != behavior) {
                if (this.mBehavior != null) {
                    this.mBehavior.onDetachedFromLayoutParams();
                }
                this.mBehavior = behavior;
                this.mBehaviorTag = null;
                this.mBehaviorResolved = true;
                if (behavior != null) {
                    behavior.onAttachedToLayoutParams(this);
                }
            }
        }

        void setLastChildRect(Rect rect) {
            this.mLastChildRect.set(rect);
        }

        Rect getLastChildRect() {
            return this.mLastChildRect;
        }

        boolean checkAnchorChanged() {
            return this.mAnchorView == null && this.mAnchorId != -1;
        }

        boolean didBlockInteraction() {
            if (this.mBehavior == null) {
                this.mDidBlockInteraction = false;
            }
            return this.mDidBlockInteraction;
        }

        boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mDidBlockInteraction) {
                return true;
            }
            coordinatorLayout = (this.mBehavior != null ? this.mBehavior.blocksInteractionBelow(coordinatorLayout, view) : null) | this.mDidBlockInteraction;
            this.mDidBlockInteraction = coordinatorLayout;
            return coordinatorLayout;
        }

        void resetTouchBehaviorTracking() {
            this.mDidBlockInteraction = false;
        }

        void resetNestedScroll(int i) {
            setNestedScrollAccepted(i, false);
        }

        void setNestedScrollAccepted(int i, boolean z) {
            switch (i) {
                case 0:
                    this.mDidAcceptNestedScrollTouch = z;
                    return;
                case 1:
                    this.mDidAcceptNestedScrollNonTouch = z;
                    break;
                default:
                    break;
            }
        }

        boolean isNestedScrollAccepted(int i) {
            switch (i) {
                case 0:
                    return this.mDidAcceptNestedScrollTouch;
                case 1:
                    return this.mDidAcceptNestedScrollNonTouch;
                default:
                    return false;
            }
        }

        boolean getChangedAfterNestedScroll() {
            return this.mDidChangeAfterNestedScroll;
        }

        void setChangedAfterNestedScroll(boolean z) {
            this.mDidChangeAfterNestedScroll = z;
        }

        void resetChangedAfterNestedScroll() {
            this.mDidChangeAfterNestedScroll = false;
        }

        boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (!(view2 == this.mAnchorDirectChild || shouldDodge(view2, ViewCompat.getLayoutDirection(coordinatorLayout)))) {
                if (this.mBehavior == null || this.mBehavior.layoutDependsOn(coordinatorLayout, view, view2) == null) {
                    return null;
                }
            }
            return true;
        }

        void invalidateAnchor() {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
        }

        View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
            if (this.mAnchorId == -1) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return null;
            }
            if (this.mAnchorView == null || !verifyAnchorView(view, coordinatorLayout)) {
                resolveAnchorView(view, coordinatorLayout);
            }
            return this.mAnchorView;
        }

        private void resolveAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            this.mAnchorView = coordinatorLayout.findViewById(this.mAnchorId);
            if (this.mAnchorView != null) {
                if (this.mAnchorView != coordinatorLayout) {
                    View view2 = this.mAnchorView;
                    View parent = this.mAnchorView.getParent();
                    while (parent != coordinatorLayout && parent != null) {
                        if (parent != view) {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                            parent = parent.getParent();
                        } else if (coordinatorLayout.isInEditMode() != null) {
                            this.mAnchorDirectChild = null;
                            this.mAnchorView = null;
                            return;
                        } else {
                            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                        }
                    }
                    this.mAnchorDirectChild = view2;
                } else if (coordinatorLayout.isInEditMode() != null) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                } else {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
            } else if (coordinatorLayout.isInEditMode()) {
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Could not find CoordinatorLayout descendant view with id ");
                stringBuilder.append(coordinatorLayout.getResources().getResourceName(this.mAnchorId));
                stringBuilder.append(" to anchor view ");
                stringBuilder.append(view);
                throw new IllegalStateException(stringBuilder.toString());
            }
        }

        private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
            if (this.mAnchorView.getId() != this.mAnchorId) {
                return false;
            }
            View view2 = this.mAnchorView;
            View parent = this.mAnchorView.getParent();
            while (parent != coordinatorLayout) {
                if (parent != null) {
                    if (parent != view) {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                        parent = parent.getParent();
                    }
                }
                this.mAnchorDirectChild = null;
                this.mAnchorView = null;
                return false;
            }
            this.mAnchorDirectChild = view2;
            return true;
        }

        private boolean shouldDodge(View view, int i) {
            view = GravityCompat.getAbsoluteGravity(((LayoutParams) view.getLayoutParams()).insetEdge, i);
            return (view == null || (GravityCompat.getAbsoluteGravity(this.dodgeInsetEdges, i) & view) != view) ? null : true;
        }
    }

    class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        public boolean onPreDraw() {
            CoordinatorLayout.this.onChildViewsChanged(0);
            return true;
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        public int compare(View view, View view2) {
            view = ViewCompat.getZ(view);
            view2 = ViewCompat.getZ(view2);
            if (view > view2) {
                return -1;
            }
            return view < view2 ? 1 : null;
        }
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
        SparseArray<Parcelable> behaviorStates;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int readInt = parcel.readInt();
            int[] iArr = new int[readInt];
            parcel.readIntArray(iArr);
            parcel = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray(readInt);
            for (classLoader = null; classLoader < readInt; classLoader++) {
                this.behaviorStates.append(iArr[classLoader], parcel[classLoader]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int i2 = 0;
            int size = this.behaviorStates != null ? this.behaviorStates.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            while (i2 < size) {
                iArr[i2] = this.behaviorStates.keyAt(i2);
                parcelableArr[i2] = (Parcelable) this.behaviorStates.valueAt(i2);
                i2++;
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }

    private static int resolveAnchoredChildGravity(int i) {
        return i == 0 ? 17 : i;
    }

    private static int resolveGravity(int i) {
        if ((i & 7) == 0) {
            i |= GravityCompat.START;
        }
        return (i & 112) == 0 ? i | 48 : i;
    }

    private static int resolveKeylineGravity(int i) {
        return i == 0 ? 8388661 : i;
    }

    static {
        Package packageR = CoordinatorLayout.class.getPackage();
        WIDGET_PACKAGE_NAME = packageR != null ? packageR.getName() : null;
        if (VERSION.SDK_INT >= 21) {
            TOP_SORTED_CHILDREN_COMPARATOR = new ViewElevationComparator();
        } else {
            TOP_SORTED_CHILDREN_COMPARATOR = null;
        }
    }

    @NonNull
    private static Rect acquireTempRect() {
        Rect rect = (Rect) sRectPool.acquire();
        return rect == null ? new Rect() : rect;
    }

    private static void releaseTempRect(@NonNull Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new DirectedAcyclicGraph();
        this.mTempList1 = new ArrayList();
        this.mTempDependenciesList = new ArrayList();
        this.mTempIntPair = new int[2];
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        ThemeUtils.checkAppCompatTheme(context);
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, R.style.Widget_Design_CoordinatorLayout);
        int i2 = 0;
        i = attributeSet.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (i != 0) {
            context = context.getResources();
            this.mKeylines = context.getIntArray(i);
            context = context.getDisplayMetrics().density;
            i = this.mKeylines.length;
            while (i2 < i) {
                this.mKeylines[i2] = (int) (((float) this.mKeylines[i2]) * context);
                i2++;
            }
        }
        this.mStatusBarBackground = attributeSet.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        attributeSet.recycle();
        setupForInsets();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
    }

    public void setOnHierarchyChangeListener(OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mLastInsets == null && ViewCompat.getFitsSystemWindows(this)) {
            ViewCompat.requestApplyInsets(this);
        }
        this.mIsAttachedToWindow = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        resetTouchBehaviors();
        if (this.mNeedsPreDrawListener && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        if (this.mNestedScrollingTarget != null) {
            onStopNestedScroll(this.mNestedScrollingTarget);
        }
        this.mIsAttachedToWindow = false;
    }

    public void setStatusBarBackground(@Nullable Drawable drawable) {
        if (this.mStatusBarBackground != drawable) {
            Drawable drawable2 = null;
            if (this.mStatusBarBackground != null) {
                this.mStatusBarBackground.setCallback(null);
            }
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            this.mStatusBarBackground = drawable2;
            if (this.mStatusBarBackground != null) {
                if (this.mStatusBarBackground.isStateful() != null) {
                    this.mStatusBarBackground.setState(getDrawableState());
                }
                DrawableCompat.setLayoutDirection(this.mStatusBarBackground, ViewCompat.getLayoutDirection(this));
                this.mStatusBarBackground.setVisible(getVisibility() == 0, false);
                this.mStatusBarBackground.setCallback(this);
            }
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.mStatusBarBackground;
        int i = 0;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.mStatusBarBackground) {
                return null;
            }
        }
        return true;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.mStatusBarBackground != null && this.mStatusBarBackground.isVisible() != z) {
            this.mStatusBarBackground.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(@DrawableRes int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.getDrawable(getContext(), i) : 0);
    }

    public void setStatusBarBackgroundColor(@ColorInt int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        if (ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat)) {
            return windowInsetsCompat;
        }
        this.mLastInsets = windowInsetsCompat;
        boolean z = false;
        boolean z2 = windowInsetsCompat != null && windowInsetsCompat.getSystemWindowInsetTop() > 0;
        this.mDrawStatusBarBackground = z2;
        if (!this.mDrawStatusBarBackground && getBackground() == null) {
            z = true;
        }
        setWillNotDraw(z);
        windowInsetsCompat = dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
        requestLayout();
        return windowInsetsCompat;
    }

    final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    private void resetTouchBehaviors() {
        if (this.mBehaviorTouchView != null) {
            Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
            if (behavior != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                behavior.onTouchEvent(this, this.mBehaviorTouchView, obtain);
                obtain.recycle();
            }
            this.mBehaviorTouchView = null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((LayoutParams) getChildAt(i).getLayoutParams()).resetTouchBehaviorTracking();
        }
        this.mDisallowInterceptReset = false;
    }

    private void getTopSortedChildren(List<View> list) {
        list.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        int i = childCount - 1;
        while (i >= 0) {
            list.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
            i--;
        }
        if (TOP_SORTED_CHILDREN_COMPARATOR != null) {
            Collections.sort(list, TOP_SORTED_CHILDREN_COMPARATOR);
        }
    }

    private boolean performIntercept(MotionEvent motionEvent, int i) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        List list = this.mTempList1;
        getTopSortedChildren(list);
        int size = list.size();
        boolean z = false;
        boolean z2 = z;
        MotionEvent motionEvent3 = null;
        for (int i2 = z2; i2 < size; i2++) {
            View view = (View) list.get(i2);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Behavior behavior = layoutParams.getBehavior();
            if ((z || r8) && actionMasked != 0) {
                if (behavior != null) {
                    if (motionEvent3 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent3 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    switch (i) {
                        case 0:
                            behavior.onInterceptTouchEvent(r0, view, motionEvent3);
                            break;
                        case 1:
                            behavior.onTouchEvent(r0, view, motionEvent3);
                            break;
                        default:
                            break;
                    }
                }
            } else {
                if (!(z || behavior == null)) {
                    switch (i) {
                        case 0:
                            z = behavior.onInterceptTouchEvent(r0, view, motionEvent2);
                            break;
                        case 1:
                            z = behavior.onTouchEvent(r0, view, motionEvent2);
                            break;
                        default:
                            break;
                    }
                    if (z) {
                        r0.mBehaviorTouchView = view;
                    }
                }
                z2 = layoutParams.didBlockInteraction();
                boolean isBlockingInteractionBelow = layoutParams.isBlockingInteractionBelow(r0, view);
                z2 = isBlockingInteractionBelow && !z2;
                if (isBlockingInteractionBelow && !z2) {
                    list.clear();
                    return z;
                }
            }
        }
        list.clear();
        return z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetTouchBehaviors();
        }
        motionEvent = performIntercept(motionEvent, 0);
        if (actionMasked == 1 || actionMasked == 3) {
            resetTouchBehaviors();
        }
        return motionEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean performIntercept;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (this.mBehaviorTouchView == null) {
            performIntercept = performIntercept(motionEvent, 1);
            if (performIntercept) {
            }
            motionEvent2 = null;
            if (this.mBehaviorTouchView == null) {
                z |= super.onTouchEvent(motionEvent);
            } else if (performIntercept) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 || actionMasked == 3) {
                resetTouchBehaviors();
            }
            return z;
        }
        performIntercept = false;
        Behavior behavior = ((LayoutParams) this.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (behavior != null) {
            z = behavior.onTouchEvent(this, this.mBehaviorTouchView, motionEvent);
        }
        motionEvent2 = null;
        if (this.mBehaviorTouchView == null) {
            z |= super.onTouchEvent(motionEvent);
        } else if (performIntercept) {
            long uptimeMillis2 = SystemClock.uptimeMillis();
            motionEvent2 = MotionEvent.obtain(uptimeMillis2, uptimeMillis2, 3, 0.0f, 0.0f, 0);
            super.onTouchEvent(motionEvent2);
        }
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        resetTouchBehaviors();
        return z;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.mDisallowInterceptReset) {
            resetTouchBehaviors();
            this.mDisallowInterceptReset = true;
        }
    }

    private int getKeyline(int i) {
        if (this.mKeylines == null) {
            StringBuilder stringBuilder = new StringBuilder("No keylines defined for ");
            stringBuilder.append(this);
            stringBuilder.append(" - attempted index lookup ");
            stringBuilder.append(i);
            return 0;
        }
        if (i >= 0) {
            if (i < this.mKeylines.length) {
                return this.mKeylines[i];
            }
        }
        stringBuilder = new StringBuilder("Keyline index ");
        stringBuilder.append(i);
        stringBuilder.append(" out of range for ");
        stringBuilder.append(this);
        return 0;
    }

    static Behavior parseBehavior(Context context, AttributeSet attributeSet, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(context.getPackageName());
            stringBuilder.append(str);
            str = stringBuilder.toString();
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(WIDGET_PACKAGE_NAME)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(WIDGET_PACKAGE_NAME);
            stringBuilder2.append('.');
            stringBuilder2.append(str);
            str = stringBuilder2.toString();
        }
        try {
            Map map = (Map) sConstructors.get();
            if (map == null) {
                map = new HashMap();
                sConstructors.set(map);
            }
            Constructor constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, true, context.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(new Object[]{context, attributeSet});
        } catch (Context context2) {
            stringBuilder = new StringBuilder("Could not inflate Behavior subclass ");
            stringBuilder.append(str);
            throw new RuntimeException(stringBuilder.toString(), context2);
        }
    }

    android.support.design.widget.CoordinatorLayout.LayoutParams getResolvedLayoutParams(android.view.View r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = r5.getLayoutParams();
        r0 = (android.support.design.widget.CoordinatorLayout.LayoutParams) r0;
        r1 = r0.mBehaviorResolved;
        if (r1 != 0) goto L_0x0053;
    L_0x000a:
        r5 = r5.getClass();
        r1 = 0;
    L_0x000f:
        if (r5 == 0) goto L_0x0020;
    L_0x0011:
        r1 = android.support.design.widget.CoordinatorLayout.DefaultBehavior.class;
        r1 = r5.getAnnotation(r1);
        r1 = (android.support.design.widget.CoordinatorLayout.DefaultBehavior) r1;
        if (r1 != 0) goto L_0x0020;
    L_0x001b:
        r5 = r5.getSuperclass();
        goto L_0x000f;
    L_0x0020:
        if (r1 == 0) goto L_0x0050;
    L_0x0022:
        r5 = r1.value();	 Catch:{ Exception -> 0x0039 }
        r2 = 0;	 Catch:{ Exception -> 0x0039 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0039 }
        r5 = r5.getDeclaredConstructor(r3);	 Catch:{ Exception -> 0x0039 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0039 }
        r5 = r5.newInstance(r2);	 Catch:{ Exception -> 0x0039 }
        r5 = (android.support.design.widget.CoordinatorLayout.Behavior) r5;	 Catch:{ Exception -> 0x0039 }
        r0.setBehavior(r5);	 Catch:{ Exception -> 0x0039 }
        goto L_0x0050;
    L_0x0039:
        r5 = new java.lang.StringBuilder;
        r2 = "Default behavior class ";
        r5.<init>(r2);
        r1 = r1.value();
        r1 = r1.getName();
        r5.append(r1);
        r1 = " could not be instantiated. Did you forget a default constructor?";
        r5.append(r1);
    L_0x0050:
        r5 = 1;
        r0.mBehaviorResolved = r5;
    L_0x0053:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.getResolvedLayoutParams(android.view.View):android.support.design.widget.CoordinatorLayout$LayoutParams");
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.clear();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams resolvedLayoutParams = getResolvedLayoutParams(childAt);
            resolvedLayoutParams.findAnchorView(this, childAt);
            this.mChildDag.addNode(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (resolvedLayoutParams.dependsOn(this, childAt, childAt2)) {
                        if (!this.mChildDag.contains(childAt2)) {
                            this.mChildDag.addNode(childAt2);
                        }
                        this.mChildDag.addEdge(childAt2, childAt);
                    }
                }
            }
        }
        this.mDependencySortedChildren.addAll(this.mChildDag.getSortedList());
        Collections.reverse(this.mDependencySortedChildren);
    }

    void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    public void onMeasureChild(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        CoordinatorLayout coordinatorLayout = this;
        prepareChildren();
        ensurePreDrawListener();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        Object obj = layoutDirection == 1 ? 1 : null;
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + paddingBottom;
        paddingTop = getSuggestedMinimumWidth();
        paddingBottom = getSuggestedMinimumHeight();
        Object obj2 = (coordinatorLayout.mLastInsets == null || !ViewCompat.getFitsSystemWindows(this)) ? null : 1;
        int size3 = coordinatorLayout.mDependencySortedChildren.size();
        int i6 = paddingTop;
        int i7 = paddingBottom;
        int i8 = 0;
        int i9 = 0;
        while (i9 < size3) {
            int i10;
            int i11;
            View view = (View) coordinatorLayout.mDependencySortedChildren.get(i9);
            if (view.getVisibility() != 8) {
                int i12;
                int max;
                int i13;
                int i14;
                Behavior behavior;
                View view2;
                int i15;
                int i16;
                int i17;
                View view3;
                View view4;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.keyline < 0 || mode == 0) {
                    i12 = i7;
                    i10 = i8;
                } else {
                    paddingTop = getKeyline(layoutParams.keyline);
                    i12 = i7;
                    i7 = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), layoutDirection) & 7;
                    i10 = i8;
                    if ((i7 == 3 && obj == null) || (i7 == 5 && obj != null)) {
                        i8 = 0;
                        max = Math.max(0, (size - paddingRight) - paddingTop);
                        if (obj2 != null) {
                        }
                        i13 = i;
                        i14 = i2;
                        behavior = layoutParams.getBehavior();
                        if (behavior != null) {
                            view2 = view;
                            i15 = i6;
                            i11 = size3;
                            i16 = i12;
                            i17 = i10;
                            i10 = i9;
                            onMeasureChild(view2, i13, max, i14, 0);
                        } else {
                            view3 = view;
                            i16 = i12;
                            view2 = view3;
                            i17 = i10;
                            i15 = i6;
                            i10 = i9;
                            i11 = size3;
                            if (!behavior.onMeasureChild(coordinatorLayout, view3, i13, max, i14, 0)) {
                                onMeasureChild(view2, i13, max, i14, 0);
                            }
                        }
                        view4 = view2;
                        paddingBottom = Math.max(i15, ((i4 + view4.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                        i7 = Math.max(i16, ((i5 + view4.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                        i8 = View.combineMeasuredStates(i17, view4.getMeasuredState());
                        i6 = paddingBottom;
                    } else if ((i7 == 5 && obj == null) || (i7 == 3 && obj != null)) {
                        max = Math.max(0, paddingTop - paddingLeft);
                        if (obj2 != null || ViewCompat.getFitsSystemWindows(view)) {
                            i13 = i;
                            i14 = i2;
                        } else {
                            i7 = coordinatorLayout.mLastInsets.getSystemWindowInsetTop() + coordinatorLayout.mLastInsets.getSystemWindowInsetBottom();
                            i13 = MeasureSpec.makeMeasureSpec(size - (coordinatorLayout.mLastInsets.getSystemWindowInsetLeft() + coordinatorLayout.mLastInsets.getSystemWindowInsetRight()), mode);
                            i14 = MeasureSpec.makeMeasureSpec(size2 - i7, mode2);
                        }
                        behavior = layoutParams.getBehavior();
                        if (behavior != null) {
                            view3 = view;
                            i16 = i12;
                            view2 = view3;
                            i17 = i10;
                            i15 = i6;
                            i10 = i9;
                            i11 = size3;
                            if (behavior.onMeasureChild(coordinatorLayout, view3, i13, max, i14, 0)) {
                                onMeasureChild(view2, i13, max, i14, 0);
                            }
                        } else {
                            view2 = view;
                            i15 = i6;
                            i11 = size3;
                            i16 = i12;
                            i17 = i10;
                            i10 = i9;
                            onMeasureChild(view2, i13, max, i14, 0);
                        }
                        view4 = view2;
                        paddingBottom = Math.max(i15, ((i4 + view4.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                        i7 = Math.max(i16, ((i5 + view4.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                        i8 = View.combineMeasuredStates(i17, view4.getMeasuredState());
                        i6 = paddingBottom;
                    }
                }
                max = 0;
                if (obj2 != null) {
                }
                i13 = i;
                i14 = i2;
                behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    view3 = view;
                    i16 = i12;
                    view2 = view3;
                    i17 = i10;
                    i15 = i6;
                    i10 = i9;
                    i11 = size3;
                    if (behavior.onMeasureChild(coordinatorLayout, view3, i13, max, i14, 0)) {
                        onMeasureChild(view2, i13, max, i14, 0);
                    }
                } else {
                    view2 = view;
                    i15 = i6;
                    i11 = size3;
                    i16 = i12;
                    i17 = i10;
                    i10 = i9;
                    onMeasureChild(view2, i13, max, i14, 0);
                }
                view4 = view2;
                paddingBottom = Math.max(i15, ((i4 + view4.getMeasuredWidth()) + layoutParams.leftMargin) + layoutParams.rightMargin);
                i7 = Math.max(i16, ((i5 + view4.getMeasuredHeight()) + layoutParams.topMargin) + layoutParams.bottomMargin);
                i8 = View.combineMeasuredStates(i17, view4.getMeasuredState());
                i6 = paddingBottom;
            } else {
                i3 = i8;
                i10 = i9;
                i11 = size3;
                i8 = i7;
                i7 = i6;
                i7 = i8;
                i8 = i3;
            }
            i9 = i10 + 1;
            size3 = i11;
        }
        i3 = i8;
        setMeasuredDimension(View.resolveSizeAndState(i6, i, -16777216 & i3), View.resolveSizeAndState(i7, i2, i3 << 16));
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat.isConsumed()) {
            return windowInsetsCompat;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ViewCompat.getFitsSystemWindows(childAt)) {
                Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    windowInsetsCompat = behavior.onApplyWindowInsets(this, childAt, windowInsetsCompat);
                    if (windowInsetsCompat.isConsumed()) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return windowInsetsCompat;
    }

    public void onLayoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.checkAnchorChanged()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        } else if (layoutParams.mAnchorView != null) {
            layoutChildWithAnchor(view, layoutParams.mAnchorView, i);
        } else if (layoutParams.keyline >= 0) {
            layoutChildWithKeyline(view, layoutParams.keyline, i);
        } else {
            layoutChild(view, i);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        z = ViewCompat.getLayoutDirection(this);
        i = this.mDependencySortedChildren.size();
        for (i2 = 0; i2 < i; i2++) {
            View view = (View) this.mDependencySortedChildren.get(i2);
            if (view.getVisibility() != 8) {
                i4 = ((LayoutParams) view.getLayoutParams()).getBehavior();
                if (i4 == 0 || i4.onLayoutChild(this, view, z) == 0) {
                    onLayoutChild(view, z);
                }
            }
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mDrawStatusBarBackground && this.mStatusBarBackground != null) {
            int systemWindowInsetTop = this.mLastInsets != null ? this.mLastInsets.getSystemWindowInsetTop() : 0;
            if (systemWindowInsetTop > 0) {
                this.mStatusBarBackground.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.mStatusBarBackground.draw(canvas);
            }
        }
    }

    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        setupForInsets();
    }

    void recordLastChildRect(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).setLastChildRect(rect);
    }

    void getLastChildRect(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).getLastChildRect());
    }

    void getChildRect(View view, boolean z, Rect rect) {
        if (!view.isLayoutRequested()) {
            if (view.getVisibility() != 8) {
                if (z) {
                    getDescendantRect(view, rect);
                    return;
                } else {
                    rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                    return;
                }
            }
        }
        rect.setEmpty();
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        view = GravityCompat.getAbsoluteGravity(resolveAnchoredChildGravity(layoutParams.gravity), i);
        i = GravityCompat.getAbsoluteGravity(resolveGravity(layoutParams.anchorGravity), i);
        layoutParams = view & 7;
        view &= 112;
        int i4 = i & 7;
        i &= 112;
        if (i4 == 1) {
            i4 = rect.left + (rect.width() / 2);
        } else if (i4 != 5) {
            i4 = rect.left;
        } else {
            i4 = rect.right;
        }
        if (i == 16) {
            i = rect.top + (rect.height() / 2);
        } else if (i != 80) {
            i = rect.top;
        } else {
            i = rect.bottom;
        }
        if (layoutParams == 1) {
            i4 -= i2 / 2;
        } else if (layoutParams != 5) {
            i4 -= i2;
        }
        if (view == 16) {
            i -= i3 / 2;
        } else if (view != 80) {
            i -= i3;
        }
        rect2.set(i4, i, i2 + i4, i3 + i);
    }

    private void constrainChildRect(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        width = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        layoutParams = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(width, layoutParams, i + width, i2 + layoutParams);
    }

    void getDesiredAnchoredChildRect(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        getDesiredAnchoredChildRectWithoutConstraints(view, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        constrainChildRect(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    private void layoutChildWithAnchor(View view, View view2, int i) {
        view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        try {
            getDescendantRect(view2, acquireTempRect);
            getDesiredAnchoredChildRect(view, i, acquireTempRect, acquireTempRect2);
            view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        } finally {
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
        }
    }

    private void layoutChildWithKeyline(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int absoluteGravity = GravityCompat.getAbsoluteGravity(resolveKeylineGravity(layoutParams.gravity), i2);
        int i3 = absoluteGravity & 7;
        absoluteGravity &= 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        i = getKeyline(i) - measuredWidth;
        if (i3 == 1) {
            i += measuredWidth / 2;
        } else if (i3 == 5) {
            i += measuredWidth;
        }
        i3 = 0;
        if (absoluteGravity == 16) {
            i3 = 0 + (measuredHeight / 2);
        } else if (absoluteGravity == 80) {
            i3 = 0 + measuredHeight;
        }
        i = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(i, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        i2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i3, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(i, i2, measuredWidth + i, measuredHeight + i2);
    }

    private void layoutChild(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect acquireTempRect = acquireTempRect();
        acquireTempRect.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (!(this.mLastInsets == null || !ViewCompat.getFitsSystemWindows(this) || ViewCompat.getFitsSystemWindows(view))) {
            acquireTempRect.left += this.mLastInsets.getSystemWindowInsetLeft();
            acquireTempRect.top += this.mLastInsets.getSystemWindowInsetTop();
            acquireTempRect.right -= this.mLastInsets.getSystemWindowInsetRight();
            acquireTempRect.bottom -= this.mLastInsets.getSystemWindowInsetBottom();
        }
        Rect acquireTempRect2 = acquireTempRect();
        GravityCompat.apply(resolveGravity(layoutParams.gravity), view.getMeasuredWidth(), view.getMeasuredHeight(), acquireTempRect, acquireTempRect2, i);
        view.layout(acquireTempRect2.left, acquireTempRect2.top, acquireTempRect2.right, acquireTempRect2.bottom);
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mBehavior != null) {
            float scrimOpacity = layoutParams.mBehavior.getScrimOpacity(this, view);
            if (scrimOpacity > 0.0f) {
                if (this.mScrimPaint == null) {
                    this.mScrimPaint = new Paint();
                }
                this.mScrimPaint.setColor(layoutParams.mBehavior.getScrimColor(this, view));
                this.mScrimPaint.setAlpha(MathUtils.clamp(Math.round(255.0f * scrimOpacity), 0, 255));
                int save = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom(), Op.DIFFERENCE);
                }
                canvas.drawRect((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) (getHeight() - getPaddingBottom()), this.mScrimPaint);
                canvas.restoreToCount(save);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    final void onChildViewsChanged(int i) {
        int i2 = i;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int size = this.mDependencySortedChildren.size();
        Rect acquireTempRect = acquireTempRect();
        Rect acquireTempRect2 = acquireTempRect();
        Rect acquireTempRect3 = acquireTempRect();
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) r0.mDependencySortedChildren.get(i3);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (i2 != 0 || view.getVisibility() != 8) {
                int absoluteGravity;
                for (int i4 = 0; i4 < i3; i4++) {
                    if (layoutParams.mAnchorDirectChild == ((View) r0.mDependencySortedChildren.get(i4))) {
                        offsetChildToAnchor(view, layoutDirection);
                    }
                }
                getChildRect(view, true, acquireTempRect2);
                if (!(layoutParams.insetEdge == 0 || acquireTempRect2.isEmpty())) {
                    absoluteGravity = GravityCompat.getAbsoluteGravity(layoutParams.insetEdge, layoutDirection);
                    int i5 = absoluteGravity & 112;
                    if (i5 == 48) {
                        acquireTempRect.top = Math.max(acquireTempRect.top, acquireTempRect2.bottom);
                    } else if (i5 == 80) {
                        acquireTempRect.bottom = Math.max(acquireTempRect.bottom, getHeight() - acquireTempRect2.top);
                    }
                    absoluteGravity &= 7;
                    if (absoluteGravity == 3) {
                        acquireTempRect.left = Math.max(acquireTempRect.left, acquireTempRect2.right);
                    } else if (absoluteGravity == 5) {
                        acquireTempRect.right = Math.max(acquireTempRect.right, getWidth() - acquireTempRect2.left);
                    }
                }
                if (layoutParams.dodgeInsetEdges != 0 && view.getVisibility() == 0) {
                    offsetChildByInset(view, acquireTempRect, layoutDirection);
                }
                if (i2 != 2) {
                    getLastChildRect(view, acquireTempRect3);
                    if (!acquireTempRect3.equals(acquireTempRect2)) {
                        recordLastChildRect(view, acquireTempRect2);
                    }
                }
                for (absoluteGravity = i3 + 1; absoluteGravity < size; absoluteGravity++) {
                    View view2 = (View) r0.mDependencySortedChildren.get(absoluteGravity);
                    LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                    Behavior behavior = layoutParams2.getBehavior();
                    if (behavior != null && behavior.layoutDependsOn(r0, view2, view)) {
                        if (i2 == 0 && layoutParams2.getChangedAfterNestedScroll()) {
                            layoutParams2.resetChangedAfterNestedScroll();
                        } else {
                            boolean onDependentViewChanged;
                            if (i2 != 2) {
                                onDependentViewChanged = behavior.onDependentViewChanged(r0, view2, view);
                            } else {
                                behavior.onDependentViewRemoved(r0, view2, view);
                                onDependentViewChanged = true;
                            }
                            if (i2 == 1) {
                                layoutParams2.setChangedAfterNestedScroll(onDependentViewChanged);
                            }
                        }
                    }
                }
            }
        }
        releaseTempRect(acquireTempRect);
        releaseTempRect(acquireTempRect2);
        releaseTempRect(acquireTempRect3);
    }

    private void offsetChildByInset(View view, Rect rect, int i) {
        if (ViewCompat.isLaidOut(view) && view.getWidth() > 0) {
            if (view.getHeight() > 0) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                Rect acquireTempRect = acquireTempRect();
                Rect acquireTempRect2 = acquireTempRect();
                acquireTempRect2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                if (behavior == null || !behavior.getInsetDodgeRect(this, view, acquireTempRect)) {
                    acquireTempRect.set(acquireTempRect2);
                } else if (!acquireTempRect2.contains(acquireTempRect)) {
                    rect = new StringBuilder("Rect should be within the child's bounds. Rect:");
                    rect.append(acquireTempRect.toShortString());
                    rect.append(" | Bounds:");
                    rect.append(acquireTempRect2.toShortString());
                    throw new IllegalArgumentException(rect.toString());
                }
                releaseTempRect(acquireTempRect2);
                if (acquireTempRect.isEmpty()) {
                    releaseTempRect(acquireTempRect);
                    return;
                }
                int i2;
                int height;
                i = GravityCompat.getAbsoluteGravity(layoutParams.dodgeInsetEdges, i);
                if ((i & 48) == 48) {
                    i2 = (acquireTempRect.top - layoutParams.topMargin) - layoutParams.mInsetOffsetY;
                    if (i2 < rect.top) {
                        setInsetOffsetY(view, rect.top - i2);
                        i2 = 1;
                        if ((i & 80) == 80) {
                            height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY;
                            if (height < rect.bottom) {
                                setInsetOffsetY(view, height - rect.bottom);
                                i2 = 1;
                            }
                        }
                        if (i2 == 0) {
                            setInsetOffsetY(view, 0);
                        }
                        if ((i & 3) == 3) {
                            i2 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX;
                            if (i2 < rect.left) {
                                setInsetOffsetX(view, rect.left - i2);
                                i2 = 1;
                                if ((i & 5) == 5) {
                                    i = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX;
                                    if (i < rect.right) {
                                        setInsetOffsetX(view, i - rect.right);
                                        i2 = 1;
                                    }
                                }
                                if (i2 == 0) {
                                    setInsetOffsetX(view, 0);
                                }
                                releaseTempRect(acquireTempRect);
                            }
                        }
                        i2 = 0;
                        if ((i & 5) == 5) {
                            i = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX;
                            if (i < rect.right) {
                                setInsetOffsetX(view, i - rect.right);
                                i2 = 1;
                            }
                        }
                        if (i2 == 0) {
                            setInsetOffsetX(view, 0);
                        }
                        releaseTempRect(acquireTempRect);
                    }
                }
                i2 = 0;
                if ((i & 80) == 80) {
                    height = ((getHeight() - acquireTempRect.bottom) - layoutParams.bottomMargin) + layoutParams.mInsetOffsetY;
                    if (height < rect.bottom) {
                        setInsetOffsetY(view, height - rect.bottom);
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    setInsetOffsetY(view, 0);
                }
                if ((i & 3) == 3) {
                    i2 = (acquireTempRect.left - layoutParams.leftMargin) - layoutParams.mInsetOffsetX;
                    if (i2 < rect.left) {
                        setInsetOffsetX(view, rect.left - i2);
                        i2 = 1;
                        if ((i & 5) == 5) {
                            i = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX;
                            if (i < rect.right) {
                                setInsetOffsetX(view, i - rect.right);
                                i2 = 1;
                            }
                        }
                        if (i2 == 0) {
                            setInsetOffsetX(view, 0);
                        }
                        releaseTempRect(acquireTempRect);
                    }
                }
                i2 = 0;
                if ((i & 5) == 5) {
                    i = ((getWidth() - acquireTempRect.right) - layoutParams.rightMargin) + layoutParams.mInsetOffsetX;
                    if (i < rect.right) {
                        setInsetOffsetX(view, i - rect.right);
                        i2 = 1;
                    }
                }
                if (i2 == 0) {
                    setInsetOffsetX(view, 0);
                }
                releaseTempRect(acquireTempRect);
            }
        }
    }

    private void setInsetOffsetX(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mInsetOffsetX != i) {
            ViewCompat.offsetLeftAndRight(view, i - layoutParams.mInsetOffsetX);
            layoutParams.mInsetOffsetX = i;
        }
    }

    private void setInsetOffsetY(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mInsetOffsetY != i) {
            ViewCompat.offsetTopAndBottom(view, i - layoutParams.mInsetOffsetY);
            layoutParams.mInsetOffsetY = i;
        }
    }

    public void dispatchDependentViewsChanged(View view) {
        List incomingEdges = this.mChildDag.getIncomingEdges(view);
        if (incomingEdges != null && !incomingEdges.isEmpty()) {
            for (int i = 0; i < incomingEdges.size(); i++) {
                View view2 = (View) incomingEdges.get(i);
                Behavior behavior = ((LayoutParams) view2.getLayoutParams()).getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(this, view2, view);
                }
            }
        }
    }

    @NonNull
    public List<View> getDependencies(@NonNull View view) {
        view = this.mChildDag.getOutgoingEdges(view);
        this.mTempDependenciesList.clear();
        if (view != null) {
            this.mTempDependenciesList.addAll(view);
        }
        return this.mTempDependenciesList;
    }

    @NonNull
    public List<View> getDependents(@NonNull View view) {
        view = this.mChildDag.getIncomingEdges(view);
        this.mTempDependenciesList.clear();
        if (view != null) {
            this.mTempDependenciesList.addAll(view);
        }
        return this.mTempDependenciesList;
    }

    @VisibleForTesting
    final List<View> getDependencySortedChildren() {
        prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    void ensurePreDrawListener() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (hasDependencies(getChildAt(i))) {
                z = true;
                break;
            }
        }
        if (z != this.mNeedsPreDrawListener) {
            if (z) {
                addPreDrawListener();
                return;
            }
            removePreDrawListener();
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    void addPreDrawListener() {
        if (this.mIsAttachedToWindow) {
            if (this.mOnPreDrawListener == null) {
                this.mOnPreDrawListener = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = true;
    }

    void removePreDrawListener() {
        if (this.mIsAttachedToWindow && this.mOnPreDrawListener != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        }
        this.mNeedsPreDrawListener = false;
    }

    void offsetChildToAnchor(View view, int i) {
        CoordinatorLayout coordinatorLayout = this;
        View view2 = view;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.mAnchorView != null) {
            Rect acquireTempRect = acquireTempRect();
            Rect acquireTempRect2 = acquireTempRect();
            Rect acquireTempRect3 = acquireTempRect();
            getDescendantRect(layoutParams.mAnchorView, acquireTempRect);
            boolean z = false;
            getChildRect(view2, false, acquireTempRect2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            int i2 = measuredHeight;
            getDesiredAnchoredChildRectWithoutConstraints(view2, i, acquireTempRect, acquireTempRect3, layoutParams, measuredWidth, measuredHeight);
            if (!(acquireTempRect3.left == acquireTempRect2.left && acquireTempRect3.top == acquireTempRect2.top)) {
                z = true;
            }
            constrainChildRect(layoutParams, acquireTempRect3, measuredWidth, i2);
            int i3 = acquireTempRect3.left - acquireTempRect2.left;
            int i4 = acquireTempRect3.top - acquireTempRect2.top;
            if (i3 != 0) {
                ViewCompat.offsetLeftAndRight(view2, i3);
            }
            if (i4 != 0) {
                ViewCompat.offsetTopAndBottom(view2, i4);
            }
            if (z) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onDependentViewChanged(coordinatorLayout, view2, layoutParams.mAnchorView);
                }
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(acquireTempRect2);
            releaseTempRect(acquireTempRect3);
        }
    }

    public boolean isPointInChildBounds(View view, int i, int i2) {
        Rect acquireTempRect = acquireTempRect();
        getDescendantRect(view, acquireTempRect);
        try {
            view = acquireTempRect.contains(i, i2);
            return view;
        } finally {
            releaseTempRect(acquireTempRect);
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        boolean z = false;
        if (view.getVisibility() != 0 || view2.getVisibility() != 0) {
            return false;
        }
        Rect acquireTempRect = acquireTempRect();
        getChildRect(view, view.getParent() != this, acquireTempRect);
        view = acquireTempRect();
        getChildRect(view2, view2.getParent() != this, view);
        try {
            if (acquireTempRect.left <= view.right && acquireTempRect.top <= view.bottom && acquireTempRect.right >= view.left && acquireTempRect.bottom >= view.top) {
                z = true;
            }
            releaseTempRect(acquireTempRect);
            releaseTempRect(view);
            return z;
        } catch (Throwable th) {
            releaseTempRect(acquireTempRect);
            releaseTempRect(view);
        }
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        int i3 = i2;
        int childCount = getChildCount();
        int i4 = 0;
        boolean z = i4;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    boolean onStartNestedScroll = behavior.onStartNestedScroll(r12, childAt, view, view2, i, i3);
                    boolean z2 = z | onStartNestedScroll;
                    layoutParams.setNestedScrollAccepted(i3, onStartNestedScroll);
                    z = z2;
                } else {
                    layoutParams.setNestedScrollAccepted(i3, false);
                }
            }
            i4++;
        }
        CoordinatorLayout coordinatorLayout = this;
        return z;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        this.mNestedScrollingTarget = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i2)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onNestedScrollAccepted(this, childAt, view, view2, i, i2);
                }
            }
        }
    }

    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.isNestedScrollAccepted(i)) {
                Behavior behavior = layoutParams.getBehavior();
                if (behavior != null) {
                    behavior.onStopNestedScroll(this, childAt, view, i);
                }
                layoutParams.resetNestedScroll(i);
                layoutParams.resetChangedAfterNestedScroll();
            }
        }
        this.mNestedScrollingTarget = null;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            int i8;
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                i8 = i5;
                if (layoutParams.isNestedScrollAccepted(i8)) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        behavior.onNestedScroll(r9, childAt, view, i, i2, i3, i4, i8);
                        i6 = 1;
                    }
                }
            } else {
                i8 = i5;
            }
        }
        if (i6 != 0) {
            onChildViewsChanged(1);
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = i4;
        int i6 = i5;
        int i7 = i6;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(i3)) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        int max;
                        int[] iArr2 = r8.mTempIntPair;
                        r8.mTempIntPair[1] = 0;
                        iArr2[0] = 0;
                        behavior.onNestedPreScroll(r8, childAt, view, i, i2, r8.mTempIntPair, i3);
                        if (i > 0) {
                            i4 = Math.max(i6, r8.mTempIntPair[0]);
                        } else {
                            i4 = Math.min(i6, r8.mTempIntPair[0]);
                        }
                        if (i2 > 0) {
                            max = Math.max(i7, r8.mTempIntPair[1]);
                        } else {
                            max = Math.min(i7, r8.mTempIntPair[1]);
                        }
                        i6 = i4;
                        i7 = max;
                        i4 = 1;
                    }
                }
            }
            i5++;
        }
        iArr[0] = i6;
        iArr[1] = i7;
        if (i4 != 0) {
            onChildViewsChanged(1);
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        z2 |= behavior.onNestedFling(this, childAt, view, f, f2, z);
                    }
                }
            }
            i++;
        }
        if (z2) {
            onChildViewsChanged(1);
        }
        return z2;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        int childCount = getChildCount();
        int i = 0;
        boolean z = i;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isNestedScrollAccepted(0)) {
                    Behavior behavior = layoutParams.getBehavior();
                    if (behavior != null) {
                        z |= behavior.onNestedPreFling(this, childAt, view, f, f2);
                    }
                }
            }
            i++;
        }
        return z;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            parcelable = savedState.behaviorStates;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                int id = childAt.getId();
                Behavior behavior = getResolvedLayoutParams(childAt).getBehavior();
                if (!(id == -1 || behavior == null)) {
                    Parcelable parcelable2 = (Parcelable) parcelable.get(id);
                    if (parcelable2 != null) {
                        behavior.onRestoreInstanceState(this, childAt, parcelable2);
                    }
                }
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behavior = ((LayoutParams) childAt.getLayoutParams()).getBehavior();
            if (!(id == -1 || behavior == null)) {
                Parcelable onSaveInstanceState = behavior.onSaveInstanceState(this, childAt);
                if (onSaveInstanceState != null) {
                    sparseArray.append(id, onSaveInstanceState);
                }
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behavior = ((LayoutParams) view.getLayoutParams()).getBehavior();
        if (behavior == null || !behavior.onRequestChildRectangleOnScreen(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    private void setupForInsets() {
        if (VERSION.SDK_INT >= 21) {
            if (ViewCompat.getFitsSystemWindows(this)) {
                if (this.mApplyWindowInsetsListener == null) {
                    this.mApplyWindowInsetsListener = new OnApplyWindowInsetsListener() {
                        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                            return CoordinatorLayout.this.setWindowInsets(windowInsetsCompat);
                        }
                    };
                }
                ViewCompat.setOnApplyWindowInsetsListener(this, this.mApplyWindowInsetsListener);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.setOnApplyWindowInsetsListener(this, null);
        }
    }
}
