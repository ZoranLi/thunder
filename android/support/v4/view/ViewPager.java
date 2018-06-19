package android.support.v4.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.annotation.CallSuper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.AutoScrollHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.alipay.sdk.util.h;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() {
        public final int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    static final int[] LAYOUT_ATTRS = new int[]{16842931};
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    public static final Interpolator sInterpolator = new Interpolator() {
        public final float getInterpolation(float f) {
            f -= 1.0f;
            return ((((f * f) * f) * f) * f) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();
    private int mActivePointerId = -1;
    PagerAdapter mAdapter;
    private List<OnAdapterChangeListener> mAdapterChangeListeners;
    private int mBottomPageBounds;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable = new Runnable() {
        public void run() {
            ViewPager.this.setScrollState(0);
            ViewPager.this.populate();
        }
    };
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout = true;
    private float mFirstOffset = -3.4028235E38f;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private OnPageChangeListener mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsScrollStarted;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems = new ArrayList();
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset = AutoScrollHelper.NO_MAX;
    private EdgeEffect mLeftEdge;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets = false;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit = 1;
    private OnPageChangeListener mOnPageChangeListener;
    private List<OnPageChangeListener> mOnPageChangeListeners;
    private int mPageMargin;
    private PageTransformer mPageTransformer;
    private int mPageTransformerLayerType;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState = null;
    private ClassLoader mRestoredClassLoader = null;
    private int mRestoredCurItem = -1;
    private EdgeEffect mRightEdge;
    private int mScrollState = 0;
    public Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private final ItemInfo mTempItem = new ItemInfo();
    private final Rect mTempRect = new Rect();
    private int mTopPageBounds;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    @Inherited
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    static class ItemInfo {
        Object object;
        float offset;
        int position;
        boolean scrolling;
        float widthFactor;

        ItemInfo() {
        }
    }

    public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        public boolean isDecor;
        boolean needsMeasure;
        int position;
        float widthFactor = 0.0f;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context = context.obtainStyledAttributes(attributeSet, ViewPager.LAYOUT_ATTRS);
            this.gravity = context.getInteger(null, 48);
            context.recycle();
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        void onPageScrollStateChanged(int i);

        void onPageScrolled(int i, float f, int i2);

        void onPageSelected(int i);
    }

    public interface PageTransformer {
        void transformPage(View view, float f);
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        public void onChanged() {
            ViewPager.this.dataSetChanged();
        }

        public void onInvalidated() {
            ViewPager.this.dataSetChanged();
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.isDecor != layoutParams2.isDecor) {
                return layoutParams.isDecor != null ? 1 : -1;
            } else {
                return layoutParams.position - layoutParams2.position;
            }
        }
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(canScroll());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.mAdapter != null) {
                accessibilityEvent.setItemCount(ViewPager.this.mAdapter.getCount());
                accessibilityEvent.setFromIndex(ViewPager.this.mCurItem);
                accessibilityEvent.setToIndex(ViewPager.this.mCurItem);
            }
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setClassName(ViewPager.class.getName());
            accessibilityNodeInfoCompat.setScrollable(canScroll());
            if (ViewPager.this.canScrollHorizontally(1) != null) {
                accessibilityNodeInfoCompat.addAction(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1) != null) {
                accessibilityNodeInfoCompat.addAction(8192);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle) != null) {
                return true;
            }
            if (i != 4096) {
                if (i != 8192 || ViewPager.this.canScrollHorizontally(-1) == null) {
                    return false;
                }
                ViewPager.this.setCurrentItem(ViewPager.this.mCurItem - 1);
                return true;
            } else if (ViewPager.this.canScrollHorizontally(1) == null) {
                return false;
            } else {
                ViewPager.this.setCurrentItem(ViewPager.this.mCurItem + 1);
                return true;
            }
        }

        private boolean canScroll() {
            return ViewPager.this.mAdapter != null && ViewPager.this.mAdapter.getCount() > 1;
        }
    }

    public static class SavedState extends AbsSavedState {
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
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("FragmentPager.SavedState{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" position=");
            stringBuilder.append(this.position);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class SimpleOnPageChangeListener implements OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    public ViewPager(Context context) {
        super(context);
        initViewPager();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViewPager();
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
        this.mMinimumVelocity = (int) (400.0f * f);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mLeftEdge = new EdgeEffect(context);
        this.mRightEdge = new EdgeEffect(context);
        this.mFlingDistance = (int) (25.0f * f);
        this.mCloseEnough = (int) (2.0f * f);
        this.mDefaultGutterSize = (int) (16.0f * f);
        ViewCompat.setAccessibilityDelegate(this, new MyAccessibilityDelegate());
        if (ViewCompat.getImportantForAccessibility(this) == 0) {
            ViewCompat.setImportantForAccessibility(this, 1);
        }
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() {
            private final Rect mTempRect = new Rect();

            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                view = ViewCompat.onApplyWindowInsets(view, windowInsetsCompat);
                if (view.isConsumed() != null) {
                    return view;
                }
                windowInsetsCompat = this.mTempRect;
                windowInsetsCompat.left = view.getSystemWindowInsetLeft();
                windowInsetsCompat.top = view.getSystemWindowInsetTop();
                windowInsetsCompat.right = view.getSystemWindowInsetRight();
                windowInsetsCompat.bottom = view.getSystemWindowInsetBottom();
                int childCount = ViewPager.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    WindowInsetsCompat dispatchApplyWindowInsets = ViewCompat.dispatchApplyWindowInsets(ViewPager.this.getChildAt(i), view);
                    windowInsetsCompat.left = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetLeft(), windowInsetsCompat.left);
                    windowInsetsCompat.top = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetTop(), windowInsetsCompat.top);
                    windowInsetsCompat.right = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetRight(), windowInsetsCompat.right);
                    windowInsetsCompat.bottom = Math.min(dispatchApplyWindowInsets.getSystemWindowInsetBottom(), windowInsetsCompat.bottom);
                }
                return view.replaceSystemWindowInsets(windowInsetsCompat.left, windowInsetsCompat.top, windowInsetsCompat.right, windowInsetsCompat.bottom);
            }
        });
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        if (!(this.mScroller == null || this.mScroller.isFinished())) {
            this.mScroller.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.mScrollState != i) {
            this.mScrollState = i;
            if (this.mPageTransformer != null) {
                enableLayers(i != 0);
            }
            dispatchOnScrollStateChanged(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        int i = 0;
        if (this.mAdapter != null) {
            this.mAdapter.setViewPagerObserver(null);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i2 = 0; i2 < this.mItems.size(); i2++) {
                ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.mAdapter;
        this.mAdapter = pagerAdapter;
        this.mExpectedAdapterCount = 0;
        if (this.mAdapter != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.setViewPagerObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z) {
                requestLayout();
            } else {
                populate();
            }
        }
        if (this.mAdapterChangeListeners != null && !this.mAdapterChangeListeners.isEmpty()) {
            int size = this.mAdapterChangeListeners.size();
            while (i < size) {
                ((OnAdapterChangeListener) this.mAdapterChangeListeners.get(i)).onAdapterChanged(this, pagerAdapter2, pagerAdapter);
                i++;
            }
        }
    }

    private void removeNonDecorViews() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((LayoutParams) getChildAt(i).getLayoutParams()).isDecor) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public PagerAdapter getAdapter() {
        return this.mAdapter;
    }

    public void addOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners == null) {
            this.mAdapterChangeListeners = new ArrayList();
        }
        this.mAdapterChangeListeners.add(onAdapterChangeListener);
    }

    public void removeOnAdapterChangeListener(@NonNull OnAdapterChangeListener onAdapterChangeListener) {
        if (this.mAdapterChangeListeners != null) {
            this.mAdapterChangeListeners.remove(onAdapterChangeListener);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, this.mFirstLayout ^ 1, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i, z, false);
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2) {
        setCurrentItemInternal(i, z, z2, 0);
    }

    void setCurrentItemInternal(int i, boolean z, boolean z2, int i2) {
        if (this.mAdapter != null) {
            if (this.mAdapter.getCount() > 0) {
                if (!z2 && this.mCurItem == i && this.mItems.size()) {
                    setScrollingCacheEnabled(false);
                    return;
                }
                z2 = true;
                if (i < 0) {
                    i = 0;
                } else if (i >= this.mAdapter.getCount()) {
                    i = this.mAdapter.getCount() - 1;
                }
                int i3 = this.mOffscreenPageLimit;
                if (i > this.mCurItem + i3 || i < this.mCurItem - i3) {
                    for (i3 = 0; i3 < this.mItems.size(); i3++) {
                        ((ItemInfo) this.mItems.get(i3)).scrolling = true;
                    }
                }
                if (this.mCurItem == i) {
                    z2 = false;
                }
                if (this.mFirstLayout) {
                    this.mCurItem = i;
                    if (z2) {
                        dispatchOnPageSelected(i);
                    }
                    requestLayout();
                    return;
                }
                populate(i);
                scrollToItem(i, z, i2, z2);
                return;
            }
        }
        setScrollingCacheEnabled(false);
    }

    private void scrollToItem(int i, boolean z, int i2, boolean z2) {
        ItemInfo infoForPosition = infoForPosition(i);
        int clientWidth = infoForPosition != null ? (int) (((float) getClientWidth()) * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset))) : 0;
        if (z) {
            smoothScrollTo(clientWidth, 0, i2);
            if (z2) {
                dispatchOnPageSelected(i);
                return;
            }
        }
        if (z2) {
            dispatchOnPageSelected(i);
        }
        completeScroll(false);
        scrollTo(clientWidth, 0);
        pageScrolled(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.mOnPageChangeListener = onPageChangeListener;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners == null) {
            this.mOnPageChangeListeners = new ArrayList();
        }
        this.mOnPageChangeListeners.add(onPageChangeListener);
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.remove(onPageChangeListener);
        }
    }

    public void clearOnPageChangeListeners() {
        if (this.mOnPageChangeListeners != null) {
            this.mOnPageChangeListeners.clear();
        }
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer) {
        setPageTransformer(z, pageTransformer, 2);
    }

    public void setPageTransformer(boolean z, PageTransformer pageTransformer, int i) {
        int i2 = 1;
        boolean z2 = pageTransformer != null;
        int i3 = z2 != (this.mPageTransformer != null) ? 1 : 0;
        this.mPageTransformer = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            if (z) {
                i2 = 2;
            }
            this.mDrawingOrder = i2;
            this.mPageTransformerLayerType = i;
        } else {
            this.mDrawingOrder = 0;
        }
        if (i3 != 0) {
            populate();
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mDrawingOrder == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) ((View) this.mDrawingOrderedChildren.get(i2)).getLayoutParams()).childIndex;
    }

    OnPageChangeListener setInternalPageChangeListener(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            StringBuilder stringBuilder = new StringBuilder("Requested offscreen page limit ");
            stringBuilder.append(i);
            stringBuilder.append(" too small; defaulting to 1");
            i = 1;
        }
        if (i != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i;
            populate();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.mPageMargin;
        this.mPageMargin = i;
        int width = getWidth();
        recomputeScrollPosition(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null ? true : null);
        invalidate();
    }

    public void setPageMarginDrawable(@DrawableRes int i) {
        setPageMarginDrawable(ContextCompat.getDrawable(getContext(), i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        if (!super.verifyDrawable(drawable)) {
            if (drawable != this.mMarginDrawable) {
                return null;
            }
        }
        return true;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - PayBaseConstants.HALF_OF_FLOAT) * 0.47123894f));
    }

    void smoothScrollTo(int i, int i2) {
        smoothScrollTo(i, i2, 0);
    }

    void smoothScrollTo(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int currX;
        boolean z = (this.mScroller == null || this.mScroller.isFinished()) ? false : true;
        if (z) {
            currX = this.mIsScrollStarted ? this.mScroller.getCurrX() : this.mScroller.getStartX();
            this.mScroller.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            currX = getScrollX();
        }
        int i4 = currX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        i = getClientWidth();
        i2 = i / 2;
        i = (float) i;
        i2 = (float) i2;
        i2 += distanceInfluenceForSnapDuration(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / i)) * i2;
        i3 = Math.abs(i3);
        if (i3 > 0) {
            i = 4 * Math.round(1000.0f * Math.abs(i2 / ((float) i3)));
        } else {
            i = (int) (((((float) Math.abs(i5)) / ((i * this.mAdapter.getPageWidth(this.mCurItem)) + ((float) this.mPageMargin))) + 1065353216) * 1120403456);
        }
        int min = Math.min(i, 600);
        this.mIsScrollStarted = false;
        this.mScroller.startScroll(i4, scrollY, i5, i6, min);
        ViewCompat.postInvalidateOnAnimation(this);
    }

    ItemInfo addNewItem(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i);
        itemInfo.widthFactor = this.mAdapter.getPageWidth(i);
        if (i2 >= 0) {
            if (i2 < this.mItems.size()) {
                this.mItems.add(i2, itemInfo);
                return itemInfo;
            }
        }
        this.mItems.add(itemInfo);
        return itemInfo;
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        boolean z2 = z;
        int i = this.mCurItem;
        int i2 = 0;
        int i3 = i2;
        while (i2 < this.mItems.size()) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i2);
                    i2--;
                    if (i3 == 0) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        i3 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    if (this.mCurItem == itemInfo.position) {
                        i = Math.max(0, Math.min(this.mCurItem, count - 1));
                    }
                } else if (itemInfo.position != itemPosition) {
                    if (itemInfo.position == this.mCurItem) {
                        i = itemPosition;
                    }
                    itemInfo.position = itemPosition;
                }
                z2 = true;
            }
            i2++;
        }
        if (i3 != 0) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z2) {
            count = getChildCount();
            for (i2 = 0; i2 < count; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.widthFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i, false, true);
            requestLayout();
        }
    }

    void populate() {
        populate(this.mCurItem);
    }

    void populate(int r19) {
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
        r18 = this;
        r0 = r18;
        r1 = r19;
        r2 = r0.mCurItem;
        if (r2 == r1) goto L_0x0011;
    L_0x0008:
        r2 = r0.mCurItem;
        r2 = r0.infoForPosition(r2);
        r0.mCurItem = r1;
        goto L_0x0012;
    L_0x0011:
        r2 = 0;
    L_0x0012:
        r1 = r0.mAdapter;
        if (r1 != 0) goto L_0x001a;
    L_0x0016:
        r18.sortChildDrawingOrder();
        return;
    L_0x001a:
        r1 = r0.mPopulatePending;
        if (r1 == 0) goto L_0x0022;
    L_0x001e:
        r18.sortChildDrawingOrder();
        return;
    L_0x0022:
        r1 = r18.getWindowToken();
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return;
    L_0x0029:
        r1 = r0.mAdapter;
        r1.startUpdate(r0);
        r1 = r0.mOffscreenPageLimit;
        r4 = r0.mCurItem;
        r4 = r4 - r1;
        r5 = 0;
        r4 = java.lang.Math.max(r5, r4);
        r6 = r0.mAdapter;
        r6 = r6.getCount();
        r7 = r6 + -1;
        r8 = r0.mCurItem;
        r8 = r8 + r1;
        r1 = java.lang.Math.min(r7, r8);
        r7 = r0.mExpectedAdapterCount;
        if (r6 == r7) goto L_0x00a0;
    L_0x004b:
        r1 = r18.getResources();	 Catch:{ NotFoundException -> 0x0058 }
        r2 = r18.getId();	 Catch:{ NotFoundException -> 0x0058 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x0058 }
        goto L_0x0060;
    L_0x0058:
        r1 = r18.getId();
        r1 = java.lang.Integer.toHexString(r1);
    L_0x0060:
        r2 = new java.lang.IllegalStateException;
        r3 = new java.lang.StringBuilder;
        r4 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r3.<init>(r4);
        r4 = r0.mExpectedAdapterCount;
        r3.append(r4);
        r4 = ", found: ";
        r3.append(r4);
        r3.append(r6);
        r4 = " Pager id: ";
        r3.append(r4);
        r3.append(r1);
        r1 = " Pager class: ";
        r3.append(r1);
        r1 = r18.getClass();
        r3.append(r1);
        r1 = " Problematic adapter: ";
        r3.append(r1);
        r1 = r0.mAdapter;
        r1 = r1.getClass();
        r3.append(r1);
        r1 = r3.toString();
        r2.<init>(r1);
        throw r2;
    L_0x00a0:
        r7 = r5;
    L_0x00a1:
        r8 = r0.mItems;
        r8 = r8.size();
        if (r7 >= r8) goto L_0x00c1;
    L_0x00a9:
        r8 = r0.mItems;
        r8 = r8.get(r7);
        r8 = (android.support.v4.view.ViewPager.ItemInfo) r8;
        r9 = r8.position;
        r10 = r0.mCurItem;
        if (r9 < r10) goto L_0x00be;
    L_0x00b7:
        r9 = r8.position;
        r10 = r0.mCurItem;
        if (r9 != r10) goto L_0x00c1;
    L_0x00bd:
        goto L_0x00c2;
    L_0x00be:
        r7 = r7 + 1;
        goto L_0x00a1;
    L_0x00c1:
        r8 = 0;
    L_0x00c2:
        if (r8 != 0) goto L_0x00cc;
    L_0x00c4:
        if (r6 <= 0) goto L_0x00cc;
    L_0x00c6:
        r8 = r0.mCurItem;
        r8 = r0.addNewItem(r8, r7);
    L_0x00cc:
        r9 = 0;
        if (r8 == 0) goto L_0x01ee;
    L_0x00cf:
        r10 = r7 + -1;
        if (r10 < 0) goto L_0x00dc;
    L_0x00d3:
        r11 = r0.mItems;
        r11 = r11.get(r10);
        r11 = (android.support.v4.view.ViewPager.ItemInfo) r11;
        goto L_0x00dd;
    L_0x00dc:
        r11 = 0;
    L_0x00dd:
        r12 = r18.getClientWidth();
        r13 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        if (r12 > 0) goto L_0x00e7;
    L_0x00e5:
        r3 = r9;
        goto L_0x00f4;
    L_0x00e7:
        r14 = r8.widthFactor;
        r14 = r13 - r14;
        r15 = r18.getPaddingLeft();
        r15 = (float) r15;
        r3 = (float) r12;
        r15 = r15 / r3;
        r3 = r14 + r15;
    L_0x00f4:
        r14 = r0.mCurItem;
        r14 = r14 + -1;
        r15 = r10;
        r10 = r7;
        r7 = r9;
    L_0x00fb:
        if (r14 < 0) goto L_0x015a;
    L_0x00fd:
        r16 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1));
        if (r16 < 0) goto L_0x0128;
    L_0x0101:
        if (r14 >= r4) goto L_0x0128;
    L_0x0103:
        if (r11 == 0) goto L_0x015a;
    L_0x0105:
        r5 = r11.position;
        if (r14 != r5) goto L_0x0156;
    L_0x0109:
        r5 = r11.scrolling;
        if (r5 != 0) goto L_0x0156;
    L_0x010d:
        r5 = r0.mItems;
        r5.remove(r15);
        r5 = r0.mAdapter;
        r11 = r11.object;
        r5.destroyItem(r0, r14, r11);
        r15 = r15 + -1;
        r10 = r10 + -1;
        if (r15 < 0) goto L_0x0154;
    L_0x011f:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x0128:
        if (r11 == 0) goto L_0x013e;
    L_0x012a:
        r5 = r11.position;
        if (r14 != r5) goto L_0x013e;
    L_0x012e:
        r5 = r11.widthFactor;
        r7 = r7 + r5;
        r15 = r15 + -1;
        if (r15 < 0) goto L_0x0154;
    L_0x0135:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x013e:
        r5 = r15 + 1;
        r5 = r0.addNewItem(r14, r5);
        r5 = r5.widthFactor;
        r7 = r7 + r5;
        r10 = r10 + 1;
        if (r15 < 0) goto L_0x0154;
    L_0x014b:
        r5 = r0.mItems;
        r5 = r5.get(r15);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0155;
    L_0x0154:
        r5 = 0;
    L_0x0155:
        r11 = r5;
    L_0x0156:
        r14 = r14 + -1;
        r5 = 0;
        goto L_0x00fb;
    L_0x015a:
        r3 = r8.widthFactor;
        r4 = r10 + 1;
        r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1));
        if (r5 >= 0) goto L_0x01eb;
    L_0x0162:
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x0173;
    L_0x016a:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x0174;
    L_0x0173:
        r5 = 0;
    L_0x0174:
        if (r12 > 0) goto L_0x0178;
    L_0x0176:
        r7 = r9;
        goto L_0x0180;
    L_0x0178:
        r7 = r18.getPaddingRight();
        r7 = (float) r7;
        r11 = (float) r12;
        r7 = r7 / r11;
        r7 = r7 + r13;
    L_0x0180:
        r11 = r0.mCurItem;
    L_0x0182:
        r11 = r11 + 1;
        if (r11 >= r6) goto L_0x01eb;
    L_0x0186:
        r12 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r12 < 0) goto L_0x01b5;
    L_0x018a:
        if (r11 <= r1) goto L_0x01b5;
    L_0x018c:
        if (r5 == 0) goto L_0x01eb;
    L_0x018e:
        r12 = r5.position;
        if (r11 != r12) goto L_0x01ea;
    L_0x0192:
        r12 = r5.scrolling;
        if (r12 != 0) goto L_0x01ea;
    L_0x0196:
        r12 = r0.mItems;
        r12.remove(r4);
        r12 = r0.mAdapter;
        r5 = r5.object;
        r12.destroyItem(r0, r11, r5);
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01aa:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x01ea;
    L_0x01b3:
        r5 = 0;
        goto L_0x01ea;
    L_0x01b5:
        if (r5 == 0) goto L_0x01d1;
    L_0x01b7:
        r12 = r5.position;
        if (r11 != r12) goto L_0x01d1;
    L_0x01bb:
        r5 = r5.widthFactor;
        r3 = r3 + r5;
        r4 = r4 + 1;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01c8:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
        goto L_0x01ea;
    L_0x01d1:
        r5 = r0.addNewItem(r11, r4);
        r4 = r4 + 1;
        r5 = r5.widthFactor;
        r3 = r3 + r5;
        r5 = r0.mItems;
        r5 = r5.size();
        if (r4 >= r5) goto L_0x01b3;
    L_0x01e2:
        r5 = r0.mItems;
        r5 = r5.get(r4);
        r5 = (android.support.v4.view.ViewPager.ItemInfo) r5;
    L_0x01ea:
        goto L_0x0182;
    L_0x01eb:
        r0.calculatePageOffsets(r8, r10, r2);
    L_0x01ee:
        r1 = r0.mAdapter;
        r2 = r0.mCurItem;
        if (r8 == 0) goto L_0x01f7;
    L_0x01f4:
        r3 = r8.object;
        goto L_0x01f8;
    L_0x01f7:
        r3 = 0;
    L_0x01f8:
        r1.setPrimaryItem(r0, r2, r3);
        r1 = r0.mAdapter;
        r1.finishUpdate(r0);
        r1 = r18.getChildCount();
        r2 = 0;
    L_0x0205:
        if (r2 >= r1) goto L_0x022e;
    L_0x0207:
        r3 = r0.getChildAt(r2);
        r4 = r3.getLayoutParams();
        r4 = (android.support.v4.view.ViewPager.LayoutParams) r4;
        r4.childIndex = r2;
        r5 = r4.isDecor;
        if (r5 != 0) goto L_0x022b;
    L_0x0217:
        r5 = r4.widthFactor;
        r5 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1));
        if (r5 != 0) goto L_0x022b;
    L_0x021d:
        r3 = r0.infoForChild(r3);
        if (r3 == 0) goto L_0x022b;
    L_0x0223:
        r5 = r3.widthFactor;
        r4.widthFactor = r5;
        r3 = r3.position;
        r4.position = r3;
    L_0x022b:
        r2 = r2 + 1;
        goto L_0x0205;
    L_0x022e:
        r18.sortChildDrawingOrder();
        r1 = r18.hasFocus();
        if (r1 == 0) goto L_0x026c;
    L_0x0237:
        r1 = r18.findFocus();
        if (r1 == 0) goto L_0x0242;
    L_0x023d:
        r3 = r0.infoForAnyChild(r1);
        goto L_0x0243;
    L_0x0242:
        r3 = 0;
    L_0x0243:
        if (r3 == 0) goto L_0x024b;
    L_0x0245:
        r1 = r3.position;
        r2 = r0.mCurItem;
        if (r1 == r2) goto L_0x026c;
    L_0x024b:
        r1 = 0;
    L_0x024c:
        r2 = r18.getChildCount();
        if (r1 >= r2) goto L_0x026c;
    L_0x0252:
        r2 = r0.getChildAt(r1);
        r3 = r0.infoForChild(r2);
        if (r3 == 0) goto L_0x0269;
    L_0x025c:
        r3 = r3.position;
        r4 = r0.mCurItem;
        if (r3 != r4) goto L_0x0269;
    L_0x0262:
        r3 = 2;
        r2 = r2.requestFocus(r3);
        if (r2 != 0) goto L_0x026c;
    L_0x0269:
        r1 = r1 + 1;
        goto L_0x024c;
    L_0x026c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.populate(int):void");
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            if (this.mDrawingOrderedChildren == null) {
                this.mDrawingOrderedChildren = new ArrayList();
            } else {
                this.mDrawingOrderedChildren.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.mDrawingOrderedChildren.add(getChildAt(i));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        int size;
        int count = this.mAdapter.getCount();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        if (itemInfo2 != null) {
            int i2 = itemInfo2.position;
            ItemInfo itemInfo3;
            if (i2 < itemInfo.position) {
                float f2 = (itemInfo2.offset + itemInfo2.widthFactor) + f;
                i2++;
                itemInfo2 = null;
                while (i2 <= itemInfo.position && itemInfo2 < this.mItems.size()) {
                    itemInfo3 = (ItemInfo) this.mItems.get(itemInfo2);
                    while (i2 > itemInfo3.position && itemInfo2 < this.mItems.size() - 1) {
                        itemInfo2++;
                        itemInfo3 = (ItemInfo) this.mItems.get(itemInfo2);
                    }
                    while (i2 < itemInfo3.position) {
                        f2 += this.mAdapter.getPageWidth(i2) + f;
                        i2++;
                    }
                    itemInfo3.offset = f2;
                    f2 += itemInfo3.widthFactor + f;
                    i2++;
                }
            } else if (i2 > itemInfo.position) {
                size = this.mItems.size() - 1;
                itemInfo2 = itemInfo2.offset;
                i2--;
                while (i2 >= itemInfo.position && size >= 0) {
                    itemInfo3 = (ItemInfo) this.mItems.get(size);
                    while (i2 < itemInfo3.position && size > 0) {
                        size--;
                        itemInfo3 = (ItemInfo) this.mItems.get(size);
                    }
                    while (i2 > itemInfo3.position) {
                        itemInfo2 -= this.mAdapter.getPageWidth(i2) + f;
                        i2--;
                    }
                    itemInfo2 -= itemInfo3.widthFactor + f;
                    itemInfo3.offset = itemInfo2;
                    i2--;
                }
            }
        }
        itemInfo2 = this.mItems.size();
        float f3 = itemInfo.offset;
        size = itemInfo.position - 1;
        this.mFirstOffset = itemInfo.position == 0 ? itemInfo.offset : -3.4028235E38f;
        count--;
        this.mLastOffset = itemInfo.position == count ? (itemInfo.offset + itemInfo.widthFactor) - 1.0f : AutoScrollHelper.NO_MAX;
        int i3 = i - 1;
        while (i3 >= 0) {
            ItemInfo itemInfo4 = (ItemInfo) this.mItems.get(i3);
            while (size > itemInfo4.position) {
                f3 -= this.mAdapter.getPageWidth(size) + f;
                size--;
            }
            f3 -= itemInfo4.widthFactor + f;
            itemInfo4.offset = f3;
            if (itemInfo4.position == 0) {
                this.mFirstOffset = f3;
            }
            i3--;
            size--;
        }
        f3 = (itemInfo.offset + itemInfo.widthFactor) + f;
        itemInfo = itemInfo.position + 1;
        i++;
        while (i < itemInfo2) {
            ItemInfo itemInfo5 = (ItemInfo) this.mItems.get(i);
            while (itemInfo < itemInfo5.position) {
                f3 += this.mAdapter.getPageWidth(itemInfo) + f;
                itemInfo++;
            }
            if (itemInfo5.position == count) {
                this.mLastOffset = (itemInfo5.widthFactor + f3) - 1.0f;
            }
            itemInfo5.offset = f3;
            f3 += itemInfo5.widthFactor + f;
            i++;
            itemInfo++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        if (this.mAdapter != null) {
            savedState.adapterState = this.mAdapter.saveState();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.mAdapter != null) {
                this.mAdapter.restoreState(savedState.adapterState, savedState.loader);
                setCurrentItemInternal(savedState.position, false, true);
                return;
            }
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        layoutParams2.isDecor |= isDecorView(view);
        if (!this.mInLayout) {
            super.addView(view, i, layoutParams);
        } else if (layoutParams2 == null || !layoutParams2.isDecor) {
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i, layoutParams);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private static boolean isDecorView(@NonNull View view) {
        return view.getClass().getAnnotation(DecorView.class) != null ? true : null;
    }

    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ItemInfo infoForChild(View view) {
        for (int i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    ItemInfo infoForAnyChild(View view) {
        while (true) {
            View parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null) {
                break;
            } else if ((parent instanceof View) == null) {
                break;
            } else {
                view = parent;
            }
        }
        return null;
    }

    ItemInfo infoForPosition(int i) {
        for (int i2 = 0; i2 < this.mItems.size(); i2++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i2);
            if (itemInfo.position == i) {
                return itemInfo;
            }
        }
        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.mGutterSize = Math.min(measuredWidth / 10, this.mDefaultGutterSize);
        measuredWidth = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i4 = measuredHeight;
        measuredHeight = measuredWidth;
        measuredWidth = 0;
        while (true) {
            boolean z2 = true;
            int i5 = 1073741824;
            if (measuredWidth >= childCount) {
                break;
            }
            View childAt = getChildAt(measuredWidth);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.isDecor) {
                    int i6;
                    int i7;
                    int i8 = layoutParams.gravity & 7;
                    int i9 = layoutParams.gravity & 112;
                    if (i9 != 48) {
                        if (i9 != 80) {
                            i9 = z;
                            if (i8 != 3) {
                                if (i8 == 5) {
                                    z2 = z;
                                }
                            }
                            i8 = Integer.MIN_VALUE;
                            if (i9 != 0) {
                                i6 = Integer.MIN_VALUE;
                                i8 = 1073741824;
                            } else {
                                i6 = z2 ? 1073741824 : Integer.MIN_VALUE;
                            }
                            if (layoutParams.width == -2) {
                                i7 = layoutParams.width == -1 ? layoutParams.width : measuredHeight;
                                i8 = 1073741824;
                            } else {
                                i7 = measuredHeight;
                            }
                            if (layoutParams.height == -2) {
                                i3 = layoutParams.height == -1 ? layoutParams.height : i4;
                            } else {
                                i3 = i4;
                                i5 = i6;
                            }
                            childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                            if (i9 != 0) {
                                i4 -= childAt.getMeasuredHeight();
                            } else if (z2) {
                                measuredHeight -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    i9 = true;
                    if (i8 != 3) {
                        if (i8 == 5) {
                            z2 = z;
                        }
                    }
                    i8 = Integer.MIN_VALUE;
                    if (i9 != 0) {
                        i6 = Integer.MIN_VALUE;
                        i8 = 1073741824;
                    } else if (z2) {
                    }
                    if (layoutParams.width == -2) {
                        i7 = measuredHeight;
                    } else {
                        if (layoutParams.width == -1) {
                        }
                        i8 = 1073741824;
                    }
                    if (layoutParams.height == -2) {
                        i3 = i4;
                        i5 = i6;
                    } else if (layoutParams.height == -1) {
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(i7, i8), MeasureSpec.makeMeasureSpec(i3, i5));
                    if (i9 != 0) {
                        i4 -= childAt.getMeasuredHeight();
                    } else if (z2) {
                        measuredHeight -= childAt.getMeasuredWidth();
                    }
                }
            }
            measuredWidth++;
            z = false;
        }
        r0.mChildWidthMeasureSpec = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        r0.mChildHeightMeasureSpec = MeasureSpec.makeMeasureSpec(i4, 1073741824);
        r0.mInLayout = true;
        populate();
        i3 = 0;
        r0.mInLayout = false;
        measuredWidth = getChildCount();
        while (i3 < measuredWidth) {
            View childAt2 = getChildAt(i3);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams2 == null || !layoutParams2.isDecor) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (((float) measuredHeight) * layoutParams2.widthFactor), 1073741824), r0.mChildHeightMeasureSpec);
                }
            }
            i3++;
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            recomputeScrollPosition(i, i3, this.mPageMargin, this.mPageMargin);
        }
    }

    private void recomputeScrollPosition(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.mItems.isEmpty()) {
            i2 = infoForPosition(this.mCurItem);
            i = (int) ((i2 != 0 ? Math.min(i2.offset, this.mLastOffset) : 0) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (i != getScrollX()) {
                completeScroll(0);
                scrollTo(i, getScrollY());
            }
        } else if (this.mScroller.isFinished()) {
            scrollTo((int) ((((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))) * ((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3))), getScrollY());
        } else {
            this.mScroller.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        ViewPager viewPager = this;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = paddingBottom;
        int i8 = 0;
        paddingBottom = paddingTop;
        paddingTop = paddingLeft;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt = getChildAt(paddingLeft);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i9 = layoutParams.gravity & 7;
                    int i10 = layoutParams.gravity & 112;
                    if (i9 == 1) {
                        i9 = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingTop);
                    } else if (i9 == 3) {
                        i9 = paddingTop;
                        paddingTop = childAt.getMeasuredWidth() + paddingTop;
                    } else if (i9 != 5) {
                        i9 = paddingTop;
                    } else {
                        i9 = (i5 - paddingRight) - childAt.getMeasuredWidth();
                        paddingRight += childAt.getMeasuredWidth();
                    }
                    if (i10 == 16) {
                        i10 = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingBottom);
                    } else if (i10 == 48) {
                        i10 = paddingBottom;
                        paddingBottom = childAt.getMeasuredHeight() + paddingBottom;
                    } else if (i10 != 80) {
                        i10 = paddingBottom;
                    } else {
                        i10 = (i6 - i7) - childAt.getMeasuredHeight();
                        i7 += childAt.getMeasuredHeight();
                    }
                    i9 += scrollX;
                    childAt.layout(i9, i10, childAt.getMeasuredWidth() + i9, i10 + childAt.getMeasuredHeight());
                    i8++;
                }
            }
        }
        i5 = (i5 - paddingTop) - paddingRight;
        for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
            View childAt2 = getChildAt(paddingLeft);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor) {
                    ItemInfo infoForChild = infoForChild(childAt2);
                    if (infoForChild != null) {
                        float f = (float) i5;
                        int i11 = ((int) (infoForChild.offset * f)) + paddingTop;
                        if (layoutParams2.needsMeasure) {
                            layoutParams2.needsMeasure = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (f * layoutParams2.widthFactor), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingBottom) - i7, 1073741824));
                        }
                        childAt2.layout(i11, paddingBottom, childAt2.getMeasuredWidth() + i11, childAt2.getMeasuredHeight() + paddingBottom);
                    }
                }
            }
        }
        viewPager.mTopPageBounds = paddingBottom;
        viewPager.mBottomPageBounds = i6 - i7;
        viewPager.mDecorChildCount = i8;
        if (viewPager.mFirstLayout) {
            z2 = false;
            scrollToItem(viewPager.mCurItem, false, 0, false);
        } else {
            z2 = false;
        }
        viewPager.mFirstLayout = z2;
    }

    public void computeScroll() {
        this.mIsScrollStarted = true;
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!pageScrolled(currX)) {
                this.mScroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ViewCompat.postInvalidateOnAnimation(this);
    }

    private boolean pageScrolled(int i) {
        if (this.mItems.size() != 0) {
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            int clientWidth = getClientWidth();
            int i2 = this.mPageMargin + clientWidth;
            float f = (float) clientWidth;
            float f2 = ((float) this.mPageMargin) / f;
            int i3 = infoForCurrentScrollPosition.position;
            i = ((((float) i) / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + f2);
            int i4 = (int) (((float) i2) * i);
            this.mCalledSuper = false;
            onPageScrolled(i3, i, i4);
            if (this.mCalledSuper != 0) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.mFirstLayout != 0) {
            return false;
        } else {
            this.mCalledSuper = false;
            onPageScrolled(0, 0, 0);
            if (this.mCalledSuper != 0) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    @CallSuper
    protected void onPageScrolled(int i, float f, int i2) {
        int i3 = 0;
        if (this.mDecorChildCount > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i4 = paddingRight;
            paddingRight = paddingLeft;
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                View childAt = getChildAt(paddingLeft);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i5 = layoutParams.gravity & 7;
                    if (i5 != 1) {
                        if (i5 == 3) {
                            i5 = childAt.getWidth() + paddingRight;
                        } else if (i5 != 5) {
                            i5 = paddingRight;
                        } else {
                            i5 = (width - i4) - childAt.getMeasuredWidth();
                            i4 += childAt.getMeasuredWidth();
                        }
                        paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                        if (paddingRight != 0) {
                            childAt.offsetLeftAndRight(paddingRight);
                        }
                        paddingRight = i5;
                    } else {
                        i5 = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingRight);
                    }
                    int i6 = i5;
                    i5 = paddingRight;
                    paddingRight = i6;
                    paddingRight = (paddingRight + scrollX) - childAt.getLeft();
                    if (paddingRight != 0) {
                        childAt.offsetLeftAndRight(paddingRight);
                    }
                    paddingRight = i5;
                }
            }
        }
        dispatchOnPageScrolled(i, f, i2);
        if (this.mPageTransformer != 0) {
            i = getScrollX();
            int childCount2 = getChildCount();
            while (i3 < childCount2) {
                i2 = getChildAt(i3);
                if (!((LayoutParams) i2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(i2, ((float) (i2.getLeft() - i)) / ((float) getClientWidth()));
                }
                i3++;
            }
        }
        this.mCalledSuper = true;
    }

    private void dispatchOnPageScrolled(int i, float f, int i2) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrolled(i, f, i2);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrolled(i, f, i2);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchOnPageSelected(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageSelected(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageSelected(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageSelected(i);
        }
    }

    private void dispatchOnScrollStateChanged(int i) {
        if (this.mOnPageChangeListener != null) {
            this.mOnPageChangeListener.onPageScrollStateChanged(i);
        }
        if (this.mOnPageChangeListeners != null) {
            int size = this.mOnPageChangeListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = (OnPageChangeListener) this.mOnPageChangeListeners.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.onPageScrollStateChanged(i);
                }
            }
        }
        if (this.mInternalPageChangeListener != null) {
            this.mInternalPageChangeListener.onPageScrollStateChanged(i);
        }
    }

    private void completeScroll(boolean z) {
        int scrollX;
        int i = this.mScrollState == 2 ? 1 : false;
        if (i != 0) {
            setScrollingCacheEnabled(false);
            if ((this.mScroller.isFinished() ^ 1) != 0) {
                this.mScroller.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.mScroller.getCurrX();
                int currY = this.mScroller.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        pageScrolled(currX);
                    }
                }
            }
        }
        this.mPopulatePending = false;
        scrollX = i;
        for (i = 0; i < this.mItems.size(); i++) {
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(i);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                scrollX = 1;
            }
        }
        if (scrollX != 0) {
            if (z) {
                ViewCompat.postOnAnimation(this, this.mEndScrollRunnable);
                return;
            }
            this.mEndScrollRunnable.run();
        }
    }

    private boolean isGutterDrag(float f, float f2) {
        return (f < ((float) this.mGutterSize) && f2 > 0.0f) || (f > ((float) (getWidth() - this.mGutterSize)) && f2 < 0.0f);
    }

    private void enableLayers(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.mPageTransformerLayerType : 0, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        View view = this;
        MotionEvent motionEvent2 = motionEvent;
        int action = motionEvent.getAction() & 255;
        if (action != 3) {
            if (action != 1) {
                if (action != 0) {
                    if (view.mIsBeingDragged) {
                        return true;
                    }
                    if (view.mIsUnableToDrag) {
                        return false;
                    }
                }
                if (action == 0) {
                    float x = motionEvent.getX();
                    view.mInitialMotionX = x;
                    view.mLastMotionX = x;
                    x = motionEvent.getY();
                    view.mInitialMotionY = x;
                    view.mLastMotionY = x;
                    view.mActivePointerId = motionEvent2.getPointerId(0);
                    view.mIsUnableToDrag = false;
                    view.mIsScrollStarted = true;
                    view.mScroller.computeScrollOffset();
                    if (view.mScrollState != 2 || Math.abs(view.mScroller.getFinalX() - view.mScroller.getCurrX()) <= view.mCloseEnough) {
                        completeScroll(false);
                        view.mIsBeingDragged = false;
                    } else {
                        view.mScroller.abortAnimation();
                        view.mPopulatePending = false;
                        populate();
                        view.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                    }
                } else if (action == 2) {
                    action = view.mActivePointerId;
                    if (action != -1) {
                        action = motionEvent2.findPointerIndex(action);
                        float x2 = motionEvent2.getX(action);
                        float f = x2 - view.mLastMotionX;
                        float abs = Math.abs(f);
                        float y = motionEvent2.getY(action);
                        float abs2 = Math.abs(y - view.mInitialMotionY);
                        if (f == 0.0f || isGutterDrag(view.mLastMotionX, f) || !canScroll(view, false, (int) f, (int) x2, (int) y)) {
                            if (abs > ((float) view.mTouchSlop) && abs * PayBaseConstants.HALF_OF_FLOAT > abs2) {
                                view.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                setScrollState(1);
                                view.mLastMotionX = f > 0.0f ? view.mInitialMotionX + ((float) view.mTouchSlop) : view.mInitialMotionX - ((float) view.mTouchSlop);
                                view.mLastMotionY = y;
                                setScrollingCacheEnabled(true);
                            } else if (abs2 > ((float) view.mTouchSlop)) {
                                view.mIsUnableToDrag = true;
                            }
                            if (view.mIsBeingDragged && performDrag(x2)) {
                                ViewCompat.postInvalidateOnAnimation(this);
                            }
                        } else {
                            view.mLastMotionX = x2;
                            view.mLastMotionY = y;
                            view.mIsUnableToDrag = true;
                            return false;
                        }
                    }
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                }
                if (view.mVelocityTracker == null) {
                    view.mVelocityTracker = VelocityTracker.obtain();
                }
                view.mVelocityTracker.addMovement(motionEvent2);
                return view.mIsBeingDragged;
            }
        }
        resetTouch();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mFakeDragging) {
            return true;
        }
        boolean z = false;
        if ((motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) && this.mAdapter != null) {
            if (this.mAdapter.getCount() != 0) {
                if (this.mVelocityTracker == null) {
                    this.mVelocityTracker = VelocityTracker.obtain();
                }
                this.mVelocityTracker.addMovement(motionEvent);
                float x;
                int xVelocity;
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.mScroller.abortAnimation();
                        this.mPopulatePending = false;
                        populate();
                        x = motionEvent.getX();
                        this.mInitialMotionX = x;
                        this.mLastMotionX = x;
                        x = motionEvent.getY();
                        this.mInitialMotionY = x;
                        this.mLastMotionY = x;
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        break;
                    case 1:
                        if (this.mIsBeingDragged) {
                            VelocityTracker velocityTracker = this.mVelocityTracker;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                            xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                            this.mPopulatePending = true;
                            int clientWidth = getClientWidth();
                            int scrollX = getScrollX();
                            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                            float f = (float) clientWidth;
                            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / f) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.widthFactor + (((float) this.mPageMargin) / f)), xVelocity, (int) (motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)) - this.mInitialMotionX)), true, true, xVelocity);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 2:
                        if (!this.mIsBeingDragged) {
                            xVelocity = motionEvent.findPointerIndex(this.mActivePointerId);
                            if (xVelocity == -1) {
                                z = resetTouch();
                                break;
                            }
                            float x2 = motionEvent.getX(xVelocity);
                            float abs = Math.abs(x2 - this.mLastMotionX);
                            x = motionEvent.getY(xVelocity);
                            float abs2 = Math.abs(x - this.mLastMotionY);
                            if (abs > ((float) this.mTouchSlop) && abs > abs2) {
                                this.mIsBeingDragged = true;
                                requestParentDisallowInterceptTouchEvent(true);
                                this.mLastMotionX = x2 - this.mInitialMotionX > 0.0f ? this.mInitialMotionX + ((float) this.mTouchSlop) : this.mInitialMotionX - ((float) this.mTouchSlop);
                                this.mLastMotionY = x;
                                setScrollState(1);
                                setScrollingCacheEnabled(true);
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                        if (this.mIsBeingDragged) {
                            z = false | performDrag(motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId)));
                            break;
                        }
                        break;
                    case 3:
                        if (this.mIsBeingDragged != null) {
                            scrollToItem(this.mCurItem, true, 0, false);
                            z = resetTouch();
                            break;
                        }
                        break;
                    case 5:
                        xVelocity = motionEvent.getActionIndex();
                        this.mLastMotionX = motionEvent.getX(xVelocity);
                        this.mActivePointerId = motionEvent.getPointerId(xVelocity);
                        break;
                    case 6:
                        onSecondaryPointerUp(motionEvent);
                        this.mLastMotionX = motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                        break;
                    default:
                        break;
                }
                if (z) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
                return true;
            }
        }
        return false;
    }

    private boolean resetTouch() {
        this.mActivePointerId = -1;
        endDrag();
        this.mLeftEdge.onRelease();
        this.mRightEdge.onRelease();
        if (!this.mLeftEdge.isFinished()) {
            if (!this.mRightEdge.isFinished()) {
                return false;
            }
        }
        return true;
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean performDrag(float f) {
        boolean z;
        boolean z2;
        float f2 = this.mLastMotionX - f;
        this.mLastMotionX = f;
        f = ((float) getScrollX()) + f2;
        f2 = (float) getClientWidth();
        float f3 = this.mFirstOffset * f2;
        float f4 = this.mLastOffset * f2;
        boolean z3 = false;
        ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
        ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
        if (itemInfo.position != 0) {
            f3 = itemInfo.offset * f2;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f4 = itemInfo2.offset * f2;
            z2 = false;
        } else {
            z2 = true;
        }
        if (f < f3) {
            if (z) {
                this.mLeftEdge.onPull(Math.abs(f3 - f) / f2);
                z3 = true;
            }
            f = f3;
        } else if (f > f4) {
            if (z2) {
                this.mRightEdge.onPull(Math.abs(f - f4) / f2);
                z3 = true;
            }
            f = f4;
        }
        int i = (int) f;
        this.mLastMotionX += f - ((float) i);
        scrollTo(i, getScrollY());
        pageScrolled(i);
        return z3;
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        float f = clientWidth > 0 ? ((float) this.mPageMargin) / ((float) clientWidth) : 0.0f;
        float f2 = 0.0f;
        float f3 = f2;
        int i = 0;
        int i2 = -1;
        ItemInfo itemInfo = null;
        int i3 = 1;
        while (i < this.mItems.size()) {
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(i);
            if (i3 == 0) {
                i2++;
                if (itemInfo2.position != i2) {
                    itemInfo2 = this.mTempItem;
                    itemInfo2.offset = (f2 + f3) + f;
                    itemInfo2.position = i2;
                    itemInfo2.widthFactor = this.mAdapter.getPageWidth(itemInfo2.position);
                    i--;
                }
            }
            f2 = itemInfo2.offset;
            float f4 = (itemInfo2.widthFactor + f2) + f;
            if (i3 == 0) {
                if (scrollX < f2) {
                    return itemInfo;
                }
            }
            if (scrollX >= f4) {
                if (i != this.mItems.size() - 1) {
                    i2 = itemInfo2.position;
                    f3 = itemInfo2.widthFactor;
                    i++;
                    i3 = 0;
                    itemInfo = itemInfo2;
                }
            }
            return itemInfo2;
        }
        return itemInfo;
    }

    private int determineTargetPage(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.mFlingDistance || Math.abs(i2) <= this.mMinimumVelocity) {
            i += (int) (f + (i >= this.mCurItem ? 1053609165 : 1058642330));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.mItems.size() <= null) {
            return i;
        }
        return Math.max(((ItemInfo) this.mItems.get(0)).position, Math.min(i, ((ItemInfo) this.mItems.get(this.mItems.size() - 1)).position));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        int i = 0;
        if (overScrollMode != 0) {
            if (overScrollMode != 1 || this.mAdapter == null || this.mAdapter.getCount() <= 1) {
                this.mLeftEdge.finish();
                this.mRightEdge.finish();
                if (i != 0) {
                    ViewCompat.postInvalidateOnAnimation(this);
                }
            }
        }
        if (!this.mLeftEdge.isFinished()) {
            overScrollMode = canvas.save();
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int width = getWidth();
            canvas.rotate(270.0f);
            canvas.translate((float) ((-height) + getPaddingTop()), this.mFirstOffset * ((float) width));
            this.mLeftEdge.setSize(height, width);
            i = 0 | this.mLeftEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (!this.mRightEdge.isFinished()) {
            overScrollMode = canvas.save();
            height = getWidth();
            width = (getHeight() - getPaddingTop()) - getPaddingBottom();
            canvas.rotate(90.0f);
            canvas.translate((float) (-getPaddingTop()), (-(this.mLastOffset + 1.0f)) * ((float) height));
            this.mRightEdge.setSize(width, height);
            i |= this.mRightEdge.draw(canvas);
            canvas.restoreToCount(overScrollMode);
        }
        if (i != 0) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mPageMargin > 0 && r0.mMarginDrawable != null && r0.mItems.size() > 0 && r0.mAdapter != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = (float) width;
            float f2 = ((float) r0.mPageMargin) / f;
            int i = 0;
            ItemInfo itemInfo = (ItemInfo) r0.mItems.get(0);
            float f3 = itemInfo.offset;
            int size = r0.mItems.size();
            int i2 = itemInfo.position;
            int i3 = ((ItemInfo) r0.mItems.get(size - 1)).position;
            while (i2 < i3) {
                float f4;
                float f5;
                while (i2 > itemInfo.position && i < size) {
                    i++;
                    itemInfo = (ItemInfo) r0.mItems.get(i);
                }
                if (i2 == itemInfo.position) {
                    f4 = (itemInfo.offset + itemInfo.widthFactor) * f;
                    f3 = (itemInfo.offset + itemInfo.widthFactor) + f2;
                } else {
                    float pageWidth = r0.mAdapter.getPageWidth(i2);
                    f4 = (f3 + pageWidth) * f;
                    f3 += pageWidth + f2;
                }
                if (((float) r0.mPageMargin) + f4 > ((float) scrollX)) {
                    f5 = f2;
                    r0.mMarginDrawable.setBounds(Math.round(f4), r0.mTopPageBounds, Math.round(((float) r0.mPageMargin) + f4), r0.mBottomPageBounds);
                    r0.mMarginDrawable.draw(canvas);
                } else {
                    Canvas canvas2 = canvas;
                    f5 = f2;
                }
                if (f4 <= ((float) (scrollX + width))) {
                    i2++;
                    f2 = f5;
                } else {
                    return;
                }
            }
        }
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionX = 0.0f;
        this.mInitialMotionX = 0.0f;
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            this.mVelocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public void endFakeDrag() {
        if (this.mFakeDragging) {
            if (this.mAdapter != null) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, (float) this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                this.mPopulatePending = true;
                int clientWidth = getClientWidth();
                int scrollX = getScrollX();
                ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
                setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((((float) scrollX) / ((float) clientWidth)) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.widthFactor, xVelocity, (int) (this.mLastMotionX - this.mInitialMotionX)), true, true, xVelocity);
            }
            endDrag();
            this.mFakeDragging = false;
            return;
        }
        throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    }

    public void fakeDragBy(float f) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        } else if (this.mAdapter != null) {
            this.mLastMotionX += f;
            float scrollX = ((float) getScrollX()) - f;
            f = (float) getClientWidth();
            float f2 = this.mFirstOffset * f;
            float f3 = this.mLastOffset * f;
            ItemInfo itemInfo = (ItemInfo) this.mItems.get(0);
            ItemInfo itemInfo2 = (ItemInfo) this.mItems.get(this.mItems.size() - 1);
            if (itemInfo.position != 0) {
                f2 = itemInfo.offset * f;
            }
            if (itemInfo2.position != this.mAdapter.getCount() - 1) {
                f3 = itemInfo2.offset * f;
            }
            if (scrollX < f2) {
                scrollX = f2;
            } else if (scrollX > f3) {
                scrollX = f3;
            }
            int i = (int) scrollX;
            this.mLastMotionX += scrollX - ((float) i);
            scrollTo(i, getScrollY());
            pageScrolled(i);
            f = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, this.mLastMotionX, 0.0f, 0);
            this.mVelocityTracker.addMovement(f);
            f.recycle();
        }
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            actionIndex = actionIndex == 0 ? 1 : 0;
            this.mLastMotionX = motionEvent.getX(actionIndex);
            this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            if (this.mVelocityTracker != null) {
                this.mVelocityTracker.clear();
            }
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.mScrollingCacheEnabled != z) {
            this.mScrollingCacheEnabled = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX > ((int) (((float) clientWidth) * this.mFirstOffset))) {
                return true;
            }
            return false;
        } else if (i <= 0 || scrollX >= ((int) (((float) clientWidth) * this.mLastOffset))) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean canScroll(View view, boolean z, int i, int i2, int i3) {
        View view2 = view;
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            int scrollX = view2.getScrollX();
            int scrollY = view2.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i4 = i2 + scrollX;
                if (i4 >= childAt.getLeft() && i4 < childAt.getRight()) {
                    int i5 = i3 + scrollY;
                    if (i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                        if (canScroll(childAt, true, i, i4 - childAt.getLeft(), i5 - childAt.getTop())) {
                            return true;
                        }
                    }
                }
            }
        }
        if (z && view2.canScrollHorizontally(-i)) {
            return true;
        }
        return false;
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
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                switch (keyCode) {
                    case 21:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageLeft();
                        }
                        return arrowScroll(17);
                    case 22:
                        if (keyEvent.hasModifiers(2) != null) {
                            return pageRight();
                        }
                        return arrowScroll(66);
                    default:
                        break;
                }
            } else if (keyEvent.hasNoModifiers()) {
                return arrowScroll(2);
            } else {
                if (keyEvent.hasModifiers(1) != null) {
                    return arrowScroll(1);
                }
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean arrowScroll(int r7) {
        /*
        r6 = this;
        r0 = r6.findFocus();
        r1 = 1;
        r2 = 0;
        r3 = 0;
        if (r0 != r6) goto L_0x000a;
    L_0x0009:
        goto L_0x005d;
    L_0x000a:
        if (r0 == 0) goto L_0x005c;
    L_0x000c:
        r4 = r0.getParent();
    L_0x0010:
        r5 = r4 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x001d;
    L_0x0014:
        if (r4 != r6) goto L_0x0018;
    L_0x0016:
        r4 = r1;
        goto L_0x001e;
    L_0x0018:
        r4 = r4.getParent();
        goto L_0x0010;
    L_0x001d:
        r4 = r2;
    L_0x001e:
        if (r4 != 0) goto L_0x005c;
    L_0x0020:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r0.getClass();
        r5 = r5.getSimpleName();
        r4.append(r5);
        r0 = r0.getParent();
    L_0x0034:
        r5 = r0 instanceof android.view.ViewGroup;
        if (r5 == 0) goto L_0x004d;
    L_0x0038:
        r5 = " => ";
        r4.append(r5);
        r5 = r0.getClass();
        r5 = r5.getSimpleName();
        r4.append(r5);
        r0 = r0.getParent();
        goto L_0x0034;
    L_0x004d:
        r0 = new java.lang.StringBuilder;
        r5 = "arrowScroll tried to find focus based on non-child current focused view ";
        r0.<init>(r5);
        r4 = r4.toString();
        r0.append(r4);
        goto L_0x005d;
    L_0x005c:
        r3 = r0;
    L_0x005d:
        r0 = android.view.FocusFinder.getInstance();
        r0 = r0.findNextFocus(r6, r3, r7);
        r4 = 66;
        r5 = 17;
        if (r0 == 0) goto L_0x00a8;
    L_0x006b:
        if (r0 == r3) goto L_0x00a8;
    L_0x006d:
        if (r7 != r5) goto L_0x008d;
    L_0x006f:
        r1 = r6.mTempRect;
        r1 = r6.getChildRectInPagerCoordinates(r1, r0);
        r1 = r1.left;
        r2 = r6.mTempRect;
        r2 = r6.getChildRectInPagerCoordinates(r2, r3);
        r2 = r2.left;
        if (r3 == 0) goto L_0x0088;
    L_0x0081:
        if (r1 < r2) goto L_0x0088;
    L_0x0083:
        r2 = r6.pageLeft();
        goto L_0x00bb;
    L_0x0088:
        r2 = r0.requestFocus();
        goto L_0x00bb;
    L_0x008d:
        if (r7 != r4) goto L_0x00bb;
    L_0x008f:
        r1 = r6.mTempRect;
        r1 = r6.getChildRectInPagerCoordinates(r1, r0);
        r1 = r1.left;
        r2 = r6.mTempRect;
        r2 = r6.getChildRectInPagerCoordinates(r2, r3);
        r2 = r2.left;
        if (r3 == 0) goto L_0x00a3;
    L_0x00a1:
        if (r1 <= r2) goto L_0x00b2;
    L_0x00a3:
        r2 = r0.requestFocus();
        goto L_0x00bb;
    L_0x00a8:
        if (r7 == r5) goto L_0x00b7;
    L_0x00aa:
        if (r7 != r1) goto L_0x00ad;
    L_0x00ac:
        goto L_0x00b7;
    L_0x00ad:
        if (r7 == r4) goto L_0x00b2;
    L_0x00af:
        r0 = 2;
        if (r7 != r0) goto L_0x00bb;
    L_0x00b2:
        r2 = r6.pageRight();
        goto L_0x00bb;
    L_0x00b7:
        r2 = r6.pageLeft();
    L_0x00bb:
        if (r2 == 0) goto L_0x00c4;
    L_0x00bd:
        r7 = android.view.SoundEffectConstants.getContantForFocusDirection(r7);
        r6.playSoundEffect(r7);
    L_0x00c4:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.arrowScroll(int):boolean");
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        view = view.getParent();
        while ((view instanceof ViewGroup) && view != this) {
            ViewGroup viewGroup = (ViewGroup) view;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            view = viewGroup.getParent();
        }
        return rect;
    }

    boolean pageLeft() {
        if (this.mCurItem <= 0) {
            return false;
        }
        setCurrentItem(this.mCurItem - 1, true);
        return true;
    }

    boolean pageRight() {
        if (this.mAdapter == null || this.mCurItem >= this.mAdapter.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    ItemInfo infoForChild = infoForChild(childAt);
                    if (infoForChild != null && infoForChild.position == this.mCurItem) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || isFocusable() == 0) {
            return;
        }
        if (!(((i2 & 1) == 1 && isInTouchMode() != 0 && isFocusableInTouchMode() == 0) || arrayList == null)) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int childCount = getChildCount();
        int i3 = -1;
        if ((i & 2) != 0) {
            i3 = childCount;
            childCount = 0;
            i2 = 1;
        } else {
            childCount--;
            i2 = -1;
        }
        while (childCount != i3) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            childCount += i2;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                ItemInfo infoForChild = infoForChild(childAt);
                if (infoForChild != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (!(layoutParams instanceof LayoutParams) || super.checkLayoutParams(layoutParams) == null) ? null : true;
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
