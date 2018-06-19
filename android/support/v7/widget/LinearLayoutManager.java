package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends LayoutManager implements ScrollVectorProvider, ViewDropHandler {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        int mPosition;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        void assignCoordinateFromPadding() {
            int endAfterPadding;
            if (this.mLayoutFromEnd) {
                endAfterPadding = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding();
            } else {
                endAfterPadding = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = endAfterPadding;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("AnchorInfo{mPosition=");
            stringBuilder.append(this.mPosition);
            stringBuilder.append(", mCoordinate=");
            stringBuilder.append(this.mCoordinate);
            stringBuilder.append(", mLayoutFromEnd=");
            stringBuilder.append(this.mLayoutFromEnd);
            stringBuilder.append(", mValid=");
            stringBuilder.append(this.mValid);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        boolean isViewValidAsAnchor(View view, State state) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return (layoutParams.isItemRemoved() || layoutParams.getViewLayoutPosition() < 0 || layoutParams.getViewLayoutPosition() >= state.getItemCount()) ? null : true;
        }

        public void assignFromViewAndKeepVisibleRect(View view) {
            int totalSpaceChange = LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                assignFromView(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            int endAfterPadding;
            int decoratedMeasurement;
            if (this.mLayoutFromEnd) {
                endAfterPadding = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view);
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    decoratedMeasurement = this.mCoordinate - LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view);
                    totalSpaceChange = LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                    decoratedMeasurement -= totalSpaceChange + Math.min(LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view) - totalSpaceChange, 0);
                    if (decoratedMeasurement < 0) {
                        this.mCoordinate += Math.min(endAfterPadding, -decoratedMeasurement);
                    }
                }
                return;
            }
            endAfterPadding = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            decoratedMeasurement = endAfterPadding - LinearLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = endAfterPadding;
            if (decoratedMeasurement > 0) {
                view = (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.mOrientationHelper.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view))) - (endAfterPadding + LinearLayoutManager.this.mOrientationHelper.getDecoratedMeasurement(view));
                if (view < null) {
                    this.mCoordinate -= Math.min(decoratedMeasurement, -view);
                }
            }
        }

        public void assignFromView(View view) {
            if (this.mLayoutFromEnd) {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedEnd(view) + LinearLayoutManager.this.mOrientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = LinearLayoutManager.this.mOrientationHelper.getDecoratedStart(view);
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
        }
    }

    protected static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtra = 0;
        boolean mInfinite;
        boolean mIsPreLayout = false;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mOffset;
        boolean mRecycle = true;
        List<ViewHolder> mScrapList = null;
        int mScrollingOffset;

        LayoutState() {
        }

        boolean hasMore(State state) {
            return (this.mCurrentPosition < 0 || this.mCurrentPosition >= state.getItemCount()) ? null : true;
        }

        View next(Recycler recycler) {
            if (this.mScrapList != null) {
                return nextViewFromScrapList();
            }
            recycler = recycler.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return recycler;
        }

        private View nextViewFromScrapList() {
            int size = this.mScrapList.size();
            int i = 0;
            while (i < size) {
                View view = ((ViewHolder) this.mScrapList.get(i)).itemView;
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams.isItemRemoved() || this.mCurrentPosition != layoutParams.getViewLayoutPosition()) {
                    i++;
                } else {
                    assignPositionFromScrapList(view);
                    return view;
                }
            }
            return null;
        }

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        public void assignPositionFromScrapList(View view) {
            view = nextViewInLimitedList(view);
            if (view == null) {
                this.mCurrentPosition = -1;
            } else {
                this.mCurrentPosition = ((LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View nextViewInLimitedList(View view) {
            int size = this.mScrapList.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = ((ViewHolder) this.mScrapList.get(i2)).itemView;
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                if (!(view3 == view || layoutParams.isItemRemoved())) {
                    int viewLayoutPosition = (layoutParams.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
                    if (viewLayoutPosition >= 0 && viewLayoutPosition < r2) {
                        if (viewLayoutPosition == 0) {
                            return view3;
                        }
                        view2 = view3;
                        i = viewLayoutPosition;
                    }
                }
            }
            return view2;
        }

        void log() {
            StringBuilder stringBuilder = new StringBuilder("avail:");
            stringBuilder.append(this.mAvailable);
            stringBuilder.append(", ind:");
            stringBuilder.append(this.mCurrentPosition);
            stringBuilder.append(", dir:");
            stringBuilder.append(this.mItemDirection);
            stringBuilder.append(", offset:");
            stringBuilder.append(this.mOffset);
            stringBuilder.append(", layoutDir:");
            stringBuilder.append(this.mLayoutDirection);
        }
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public static class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public final SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        public int describeContents() {
            return 0;
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
            boolean z = true;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.mAnchorLayoutFromEnd = z;
        }

        public SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
        }

        boolean hasValidAnchor() {
            return this.mAnchorPosition >= 0;
        }

        void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
            parcel.writeInt(this.mAnchorLayoutFromEnd);
        }
    }

    void onAnchorReady(Recycler recycler, State state, AnchorInfo anchorInfo, int i) {
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        context = LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(context.orientation);
        setReverseLayout(context.reverseLayout);
        setStackFromEnd(context.stackFromEnd);
        setAutoMeasureEnabled(true);
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.mRecycleChildrenOnDetach != null) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        Parcelable savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.mAnchorLayoutFromEnd = z;
            View childClosestToEnd;
            if (z) {
                childClosestToEnd = getChildClosestToEnd();
                savedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                childClosestToEnd = getChildClosestToStart();
                savedState.mAnchorPosition = getPosition(childClosestToEnd);
                savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToEnd) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != z) {
            this.mStackFromEnd = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                this.mOrientationHelper = null;
                requestLayout();
                return;
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder("invalid orientation:");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation != 1) {
            if (isLayoutRTL()) {
                if (this.mReverseLayout) {
                    z = false;
                }
                this.mShouldReverseLayout = z;
            }
        }
        z = this.mReverseLayout;
        this.mShouldReverseLayout = z;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.mReverseLayout) {
            this.mReverseLayout = z;
            requestLayout();
        }
    }

    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    protected int getExtraLayoutSpace(State state) {
        return state.hasTargetScrollPosition() != null ? this.mOrientationHelper.getTotalSpace() : null;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        state = new LinearSmoothScroller(recyclerView.getContext());
        state.setTargetPosition(i);
        startSmoothScroll(state);
    }

    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return 0;
        }
        int i2 = 0;
        int i3 = 1;
        if (i < getPosition(getChildAt(0))) {
            i2 = 1;
        }
        if (i2 != this.mShouldReverseLayout) {
            i3 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        int i = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        int extraLayoutSpace;
        int i2;
        View findViewByPosition;
        int decoratedStart;
        int i3;
        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        if (this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1) {
            if (this.mPendingSavedState == null) {
                if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
                    this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
                }
                extraLayoutSpace = getExtraLayoutSpace(state);
                if (this.mLayoutState.mLastScrollDelta < 0) {
                    i2 = extraLayoutSpace;
                    extraLayoutSpace = 0;
                } else {
                    i2 = 0;
                }
                extraLayoutSpace += this.mOrientationHelper.getStartAfterPadding();
                i2 += this.mOrientationHelper.getEndPadding();
                if (!(!state.isPreLayout() || this.mPendingScrollPosition == -1 || this.mPendingScrollPositionOffset == Integer.MIN_VALUE)) {
                    findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mShouldReverseLayout) {
                            decoratedStart = this.mPendingScrollPositionOffset - (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding());
                        } else {
                            decoratedStart = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition)) - this.mPendingScrollPositionOffset;
                        }
                        if (decoratedStart <= 0) {
                            extraLayoutSpace += decoratedStart;
                        } else {
                            i2 -= decoratedStart;
                        }
                    }
                }
                if (this.mAnchorInfo.mLayoutFromEnd ? this.mShouldReverseLayout : !this.mShouldReverseLayout) {
                    i = 1;
                }
                onAnchorReady(recycler, state, this.mAnchorInfo, i);
                detachAndScrapAttachedViews(recycler);
                this.mLayoutState.mInfinite = resolveIsInfinite();
                this.mLayoutState.mIsPreLayout = state.isPreLayout();
                if (this.mAnchorInfo.mLayoutFromEnd) {
                    updateLayoutStateToFillEnd(this.mAnchorInfo);
                    this.mLayoutState.mExtra = i2;
                    fill(recycler, this.mLayoutState, state, false);
                    i2 = this.mLayoutState.mOffset;
                    i = this.mLayoutState.mCurrentPosition;
                    if (this.mLayoutState.mAvailable > 0) {
                        extraLayoutSpace += this.mLayoutState.mAvailable;
                    }
                    updateLayoutStateToFillStart(this.mAnchorInfo);
                    this.mLayoutState.mExtra = extraLayoutSpace;
                    LayoutState layoutState = this.mLayoutState;
                    layoutState.mCurrentPosition += this.mLayoutState.mItemDirection;
                    fill(recycler, this.mLayoutState, state, false);
                    extraLayoutSpace = this.mLayoutState.mOffset;
                    if (this.mLayoutState.mAvailable > 0) {
                        i3 = this.mLayoutState.mAvailable;
                        updateLayoutStateToFillEnd(i, i2);
                        this.mLayoutState.mExtra = i3;
                        fill(recycler, this.mLayoutState, state, false);
                        i2 = this.mLayoutState.mOffset;
                    }
                } else {
                    updateLayoutStateToFillStart(this.mAnchorInfo);
                    this.mLayoutState.mExtra = extraLayoutSpace;
                    fill(recycler, this.mLayoutState, state, false);
                    extraLayoutSpace = this.mLayoutState.mOffset;
                    i = this.mLayoutState.mCurrentPosition;
                    if (this.mLayoutState.mAvailable > 0) {
                        i2 += this.mLayoutState.mAvailable;
                    }
                    updateLayoutStateToFillEnd(this.mAnchorInfo);
                    this.mLayoutState.mExtra = i2;
                    LayoutState layoutState2 = this.mLayoutState;
                    layoutState2.mCurrentPosition += this.mLayoutState.mItemDirection;
                    fill(recycler, this.mLayoutState, state, false);
                    i2 = this.mLayoutState.mOffset;
                    if (this.mLayoutState.mAvailable > 0) {
                        i3 = this.mLayoutState.mAvailable;
                        updateLayoutStateToFillStart(i, extraLayoutSpace);
                        this.mLayoutState.mExtra = i3;
                        fill(recycler, this.mLayoutState, state, false);
                        extraLayoutSpace = this.mLayoutState.mOffset;
                    }
                }
                if (getChildCount() > 0) {
                    if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == 0) {
                        i = fixLayoutEndGap(i2, recycler, state, true);
                        extraLayoutSpace += i;
                        i2 += i;
                        i = fixLayoutStartGap(extraLayoutSpace, recycler, state, false);
                        extraLayoutSpace += i;
                        i2 += i;
                    } else {
                        i = fixLayoutStartGap(extraLayoutSpace, recycler, state, true);
                        extraLayoutSpace += i;
                        i2 += i;
                        i = fixLayoutEndGap(i2, recycler, state, false);
                        extraLayoutSpace += i;
                        i2 += i;
                    }
                }
                layoutForPredictiveAnimations(recycler, state, extraLayoutSpace, i2);
                if (state.isPreLayout() != null) {
                    this.mOrientationHelper.onLayoutComplete();
                } else {
                    this.mAnchorInfo.reset();
                }
                this.mLastStackFromEnd = this.mStackFromEnd;
            }
        }
        this.mAnchorInfo.reset();
        this.mAnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(recycler, state, this.mAnchorInfo);
        this.mAnchorInfo.mValid = true;
        extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.mLayoutState.mLastScrollDelta < 0) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        extraLayoutSpace += this.mOrientationHelper.getStartAfterPadding();
        i2 += this.mOrientationHelper.getEndPadding();
        findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
        if (findViewByPosition != null) {
            if (this.mShouldReverseLayout) {
                decoratedStart = this.mPendingScrollPositionOffset - (this.mOrientationHelper.getDecoratedStart(findViewByPosition) - this.mOrientationHelper.getStartAfterPadding());
            } else {
                decoratedStart = (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(findViewByPosition)) - this.mPendingScrollPositionOffset;
            }
            if (decoratedStart <= 0) {
                i2 -= decoratedStart;
            } else {
                extraLayoutSpace += decoratedStart;
            }
        }
        i = 1;
        onAnchorReady(recycler, state, this.mAnchorInfo, i);
        detachAndScrapAttachedViews(recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = state.isPreLayout();
        if (this.mAnchorInfo.mLayoutFromEnd) {
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = i2;
            fill(recycler, this.mLayoutState, state, false);
            i2 = this.mLayoutState.mOffset;
            i = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.mAvailable > 0) {
                extraLayoutSpace += this.mLayoutState.mAvailable;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = extraLayoutSpace;
            LayoutState layoutState3 = this.mLayoutState;
            layoutState3.mCurrentPosition += this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state, false);
            extraLayoutSpace = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                i3 = this.mLayoutState.mAvailable;
                updateLayoutStateToFillEnd(i, i2);
                this.mLayoutState.mExtra = i3;
                fill(recycler, this.mLayoutState, state, false);
                i2 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillStart(this.mAnchorInfo);
            this.mLayoutState.mExtra = extraLayoutSpace;
            fill(recycler, this.mLayoutState, state, false);
            extraLayoutSpace = this.mLayoutState.mOffset;
            i = this.mLayoutState.mCurrentPosition;
            if (this.mLayoutState.mAvailable > 0) {
                i2 += this.mLayoutState.mAvailable;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            this.mLayoutState.mExtra = i2;
            LayoutState layoutState22 = this.mLayoutState;
            layoutState22.mCurrentPosition += this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state, false);
            i2 = this.mLayoutState.mOffset;
            if (this.mLayoutState.mAvailable > 0) {
                i3 = this.mLayoutState.mAvailable;
                updateLayoutStateToFillStart(i, extraLayoutSpace);
                this.mLayoutState.mExtra = i3;
                fill(recycler, this.mLayoutState, state, false);
                extraLayoutSpace = this.mLayoutState.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == 0) {
                i = fixLayoutStartGap(extraLayoutSpace, recycler, state, true);
                extraLayoutSpace += i;
                i2 += i;
                i = fixLayoutEndGap(i2, recycler, state, false);
                extraLayoutSpace += i;
                i2 += i;
            } else {
                i = fixLayoutEndGap(i2, recycler, state, true);
                extraLayoutSpace += i;
                i2 += i;
                i = fixLayoutStartGap(extraLayoutSpace, recycler, state, false);
                extraLayoutSpace += i;
                i2 += i;
            }
        }
        layoutForPredictiveAnimations(recycler, state, extraLayoutSpace, i2);
        if (state.isPreLayout() != null) {
            this.mAnchorInfo.reset();
        } else {
            this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    private void layoutForPredictiveAnimations(Recycler recycler, State state, int i, int i2) {
        LinearLayoutManager linearLayoutManager = this;
        Recycler recycler2 = recycler;
        State state2 = state;
        if (!(!state.willRunPredictiveAnimations() || getChildCount() == 0 || state.isPreLayout())) {
            if (supportsPredictiveItemAnimations()) {
                List scrapList = recycler.getScrapList();
                int size = scrapList.size();
                int position = getPosition(getChildAt(0));
                int i3 = 0;
                int i4 = i3;
                int i5 = i4;
                while (i3 < size) {
                    ViewHolder viewHolder = (ViewHolder) scrapList.get(i3);
                    if (!viewHolder.isRemoved()) {
                        Object obj = 1;
                        if ((viewHolder.getLayoutPosition() < position) != linearLayoutManager.mShouldReverseLayout) {
                            obj = -1;
                        }
                        if (obj == -1) {
                            i4 += linearLayoutManager.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                        } else {
                            i5 += linearLayoutManager.mOrientationHelper.getDecoratedMeasurement(viewHolder.itemView);
                        }
                    }
                    i3++;
                }
                linearLayoutManager.mLayoutState.mScrapList = scrapList;
                if (i4 > 0) {
                    updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
                    linearLayoutManager.mLayoutState.mExtra = i4;
                    linearLayoutManager.mLayoutState.mAvailable = 0;
                    linearLayoutManager.mLayoutState.assignPositionFromScrapList();
                    fill(recycler2, linearLayoutManager.mLayoutState, state2, false);
                }
                if (i5 > 0) {
                    updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
                    linearLayoutManager.mLayoutState.mExtra = i5;
                    linearLayoutManager.mLayoutState.mAvailable = 0;
                    linearLayoutManager.mLayoutState.assignPositionFromScrapList();
                    fill(recycler2, linearLayoutManager.mLayoutState, state2, false);
                }
                linearLayoutManager.mLayoutState.mScrapList = null;
            }
        }
    }

    private void updateAnchorInfoForLayout(Recycler recycler, State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && updateAnchorFromChildren(recycler, state, anchorInfo) == null) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = this.mStackFromEnd != null ? state.getItemCount() - 1 : null;
        }
    }

    private boolean updateAnchorFromChildren(Recycler recycler, State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && anchorInfo.isViewValidAsAnchor(focusedChild, state)) {
            anchorInfo.assignFromViewAndKeepVisibleRect(focusedChild);
            return true;
        } else if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        } else {
            if (anchorInfo.mLayoutFromEnd) {
                recycler = findReferenceChildClosestToEnd(recycler, state);
            } else {
                recycler = findReferenceChildClosestToStart(recycler, state);
            }
            if (recycler == null) {
                return false;
            }
            anchorInfo.assignFromView(recycler);
            if (state.isPreLayout() == null && supportsPredictiveItemAnimations() != null) {
                if (this.mOrientationHelper.getDecoratedStart(recycler) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(recycler) < this.mOrientationHelper.getStartAfterPadding()) {
                    z = true;
                }
                if (z) {
                    if (anchorInfo.mLayoutFromEnd != null) {
                        recycler = this.mOrientationHelper.getEndAfterPadding();
                    } else {
                        recycler = this.mOrientationHelper.getStartAfterPadding();
                    }
                    anchorInfo.mCoordinate = recycler;
                }
            }
            return true;
        }
    }

    private boolean updateAnchorFromPendingData(State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (!state.isPreLayout()) {
            if (this.mPendingScrollPosition != -1) {
                if (this.mPendingScrollPosition >= 0) {
                    if (this.mPendingScrollPosition < state.getItemCount()) {
                        anchorInfo.mPosition = this.mPendingScrollPosition;
                        if (this.mPendingSavedState != null && this.mPendingSavedState.hasValidAnchor() != null) {
                            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
                            if (anchorInfo.mLayoutFromEnd != null) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                            } else {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                            }
                            return true;
                        } else if (this.mPendingScrollPositionOffset == -2147483648) {
                            state = findViewByPosition(this.mPendingScrollPosition);
                            if (state == null) {
                                if (getChildCount() > null) {
                                    if ((this.mPendingScrollPosition < getPosition(getChildAt(0)) ? 1 : null) == this.mShouldReverseLayout) {
                                        z = true;
                                    }
                                    anchorInfo.mLayoutFromEnd = z;
                                }
                                anchorInfo.assignCoordinateFromPadding();
                            } else if (this.mOrientationHelper.getDecoratedMeasurement(state) > this.mOrientationHelper.getTotalSpace()) {
                                anchorInfo.assignCoordinateFromPadding();
                                return true;
                            } else if (this.mOrientationHelper.getDecoratedStart(state) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                                anchorInfo.mLayoutFromEnd = false;
                                return true;
                            } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(state) < 0) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                                anchorInfo.mLayoutFromEnd = true;
                                return true;
                            } else {
                                if (anchorInfo.mLayoutFromEnd) {
                                    state = this.mOrientationHelper.getDecoratedEnd(state) + this.mOrientationHelper.getTotalSpaceChange();
                                } else {
                                    state = this.mOrientationHelper.getDecoratedStart(state);
                                }
                                anchorInfo.mCoordinate = state;
                            }
                            return true;
                        } else {
                            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                            if (this.mShouldReverseLayout != null) {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                            } else {
                                anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                            }
                            return true;
                        }
                    }
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
        }
        return false;
    }

    private int fixLayoutEndGap(int i, Recycler recycler, State state, boolean z) {
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i;
        if (endAfterPadding <= 0) {
            return 0;
        }
        recycler = -scrollBy(-endAfterPadding, recycler, state);
        i += recycler;
        if (z) {
            state = this.mOrientationHelper.getEndAfterPadding() - i;
            if (state > null) {
                this.mOrientationHelper.offsetChildren(state);
                return state + recycler;
            }
        }
        return recycler;
    }

    private int fixLayoutStartGap(int i, Recycler recycler, State state, boolean z) {
        int startAfterPadding = i - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding <= 0) {
            return 0;
        }
        recycler = -scrollBy(startAfterPadding, recycler, state);
        i += recycler;
        if (z) {
            i -= this.mOrientationHelper.getStartAfterPadding();
            if (i > 0) {
                this.mOrientationHelper.offsetChildren(-i);
                return recycler - i;
            }
        }
        return recycler;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo) {
        updateLayoutStateToFillEnd(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i2;
        this.mLayoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        this.mLayoutState.mCurrentPosition = i;
        this.mLayoutState.mLayoutDirection = 1;
        this.mLayoutState.mOffset = i2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo) {
        updateLayoutStateToFillStart(anchorInfo.mPosition, anchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.getStartAfterPadding();
        this.mLayoutState.mCurrentPosition = i;
        this.mLayoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        this.mLayoutState.mLayoutDirection = -1;
        this.mLayoutState.mOffset = i2;
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    protected boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
        if (this.mOrientationHelper == null) {
            this.mOrientationHelper = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        }
    }

    LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        if (this.mPendingSavedState != 0) {
            this.mPendingSavedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        if (this.mPendingSavedState != 0) {
            this.mPendingSavedState.invalidateAnchor();
        }
        requestLayout();
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, recycler, state);
    }

    public int computeHorizontalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(State state) {
        return computeScrollRange(state);
    }

    public int computeVerticalScrollRange(State state) {
        return computeScrollRange(state);
    }

    private int computeScrollOffset(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollExtent(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollRange(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(state, this.mOrientationHelper, findFirstVisibleChildClosestToStart(this.mSmoothScrollbarEnabled ^ true, true), findFirstVisibleChildClosestToEnd(this.mSmoothScrollbarEnabled ^ true, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void updateLayoutState(int i, int i2, boolean z, State state) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mExtra = getExtraLayoutSpace(state);
        this.mLayoutState.mLayoutDirection = i;
        state = -1;
        LayoutState layoutState;
        if (i == 1) {
            i = this.mLayoutState;
            i.mExtra += this.mOrientationHelper.getEndPadding();
            i = getChildClosestToEnd();
            layoutState = this.mLayoutState;
            if (!this.mShouldReverseLayout) {
                state = 1;
            }
            layoutState.mItemDirection = state;
            this.mLayoutState.mCurrentPosition = getPosition(i) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(i);
            i = this.mOrientationHelper.getDecoratedEnd(i) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            i = getChildClosestToStart();
            layoutState = this.mLayoutState;
            layoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
            layoutState = this.mLayoutState;
            if (this.mShouldReverseLayout) {
                state = 1;
            }
            layoutState.mItemDirection = state;
            this.mLayoutState.mCurrentPosition = getPosition(i) + this.mLayoutState.mItemDirection;
            this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(i);
            i = (-this.mOrientationHelper.getDecoratedStart(i)) + this.mOrientationHelper.getStartAfterPadding();
        }
        this.mLayoutState.mAvailable = i2;
        if (z) {
            i2 = this.mLayoutState;
            i2.mAvailable -= i;
        }
        this.mLayoutState.mScrollingOffset = i;
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
    }

    void collectPrefetchPositionsForLayoutState(State state, LayoutState layoutState, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        int i = layoutState.mCurrentPosition;
        if (i >= 0 && i < state.getItemCount()) {
            layoutPrefetchRegistry.addPosition(i, Math.max(null, layoutState.mScrollingOffset));
        }
    }

    public void collectInitialPrefetchPositions(int i, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i2;
        int i3 = -1;
        if (this.mPendingSavedState == null || !this.mPendingSavedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition == -1 ? z ? i - 1 : 0 : this.mPendingScrollPosition;
        } else {
            z = this.mPendingSavedState.mAnchorLayoutFromEnd;
            i2 = this.mPendingSavedState.mAnchorPosition;
        }
        if (!z) {
            i3 = 1;
        }
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            layoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0) {
            if (i != 0) {
                ensureLayoutState();
                updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, state);
                collectPrefetchPositionsForLayoutState(state, this.mLayoutState, layoutPrefetchRegistry);
            }
        }
    }

    int scrollBy(int i, Recycler recycler, State state) {
        if (getChildCount() != 0) {
            if (i != 0) {
                this.mLayoutState.mRecycle = true;
                ensureLayoutState();
                int i2 = i > 0 ? 1 : -1;
                int abs = Math.abs(i);
                updateLayoutState(i2, abs, true, state);
                int fill = this.mLayoutState.mScrollingOffset + fill(recycler, this.mLayoutState, state, false);
                if (fill < 0) {
                    return 0;
                }
                if (abs > fill) {
                    i = i2 * fill;
                }
                this.mOrientationHelper.offsetChildren(-i);
                this.mLayoutState.mLastScrollDelta = i;
                return i;
            }
        }
        return 0;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void recycleChildren(Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (i2--; i2 >= i; i2--) {
                    removeAndRecycleViewAt(i2, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    private void recycleViewsFromStart(Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.mShouldReverseLayout) {
                childCount--;
                int i2 = childCount;
                while (i2 >= 0) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.getDecoratedEnd(childAt) <= i) {
                        if (this.mOrientationHelper.getTransformedEndWithDecoration(childAt) <= i) {
                            i2--;
                        }
                    }
                    recycleChildren(recycler, childCount, i2);
                    return;
                }
                return;
            }
            int i3 = 0;
            while (i3 < childCount) {
                View childAt2 = getChildAt(i3);
                if (this.mOrientationHelper.getDecoratedEnd(childAt2) <= i) {
                    if (this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) <= i) {
                        i3++;
                    }
                }
                recycleChildren(recycler, 0, i3);
                return;
            }
        }
    }

    private void recycleViewsFromEnd(Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.mOrientationHelper.getEnd() - i;
            if (this.mShouldReverseLayout != 0) {
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = getChildAt(i2);
                    if (this.mOrientationHelper.getDecoratedStart(childAt) >= end) {
                        if (this.mOrientationHelper.getTransformedStartWithDecoration(childAt) >= end) {
                            i2++;
                        }
                    }
                    recycleChildren(recycler, 0, i2);
                    return;
                }
                return;
            }
            childCount--;
            i = childCount;
            while (i >= 0) {
                View childAt2 = getChildAt(i);
                if (this.mOrientationHelper.getDecoratedStart(childAt2) >= end) {
                    if (this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) >= end) {
                        i--;
                    }
                }
                recycleChildren(recycler, childCount, i);
                return;
            }
        }
    }

    private void recycleByLayoutState(Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle) {
            if (!layoutState.mInfinite) {
                if (layoutState.mLayoutDirection == -1) {
                    recycleViewsFromEnd(recycler, layoutState.mScrollingOffset);
                } else {
                    recycleViewsFromStart(recycler, layoutState.mScrollingOffset);
                }
            }
        }
    }

    int fill(Recycler recycler, LayoutState layoutState, State state, boolean z) {
        int i = layoutState.mAvailable;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                layoutState.mScrollingOffset += layoutState.mAvailable;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int i2 = layoutState.mAvailable + layoutState.mExtra;
        LayoutChunkResult layoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!layoutState.mInfinite && i2 <= 0) || !layoutState.hasMore(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            layoutChunk(recycler, state, layoutState, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                layoutState.mOffset += layoutChunkResult.mConsumed * layoutState.mLayoutDirection;
                if (!(layoutChunkResult.mIgnoreConsumed && this.mLayoutState.mScrapList == null && state.isPreLayout())) {
                    layoutState.mAvailable -= layoutChunkResult.mConsumed;
                    i2 -= layoutChunkResult.mConsumed;
                }
                if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
                    layoutState.mScrollingOffset += layoutChunkResult.mConsumed;
                    if (layoutState.mAvailable < 0) {
                        layoutState.mScrollingOffset += layoutState.mAvailable;
                    }
                    recycleByLayoutState(recycler, layoutState);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - layoutState.mAvailable;
    }

    void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        recycler = layoutState.next(recycler);
        if (recycler == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        int decoratedMeasurementInOther;
        int i;
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) recycler.getLayoutParams();
        if (layoutState.mScrapList == null) {
            if (this.mShouldReverseLayout == (layoutState.mLayoutDirection == -1)) {
                addView(recycler);
            } else {
                addView(recycler, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (layoutState.mLayoutDirection == -1)) {
                addDisappearingView(recycler);
            } else {
                addDisappearingView(recycler, 0);
            }
        }
        measureChildWithMargins(recycler, 0, 0);
        layoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(recycler);
        int width;
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                width = getWidth() - getPaddingRight();
                decoratedMeasurementInOther = width - this.mOrientationHelper.getDecoratedMeasurementInOther(recycler);
            } else {
                decoratedMeasurementInOther = getPaddingLeft();
                width = this.mOrientationHelper.getDecoratedMeasurementInOther(recycler) + decoratedMeasurementInOther;
            }
            if (layoutState.mLayoutDirection == -1) {
                i = layoutState.mOffset - layoutChunkResult.mConsumed;
                i2 = width;
                i3 = layoutState.mOffset;
            } else {
                i3 = layoutState.mOffset + layoutChunkResult.mConsumed;
                i2 = width;
                i = layoutState.mOffset;
            }
        } else {
            width = getPaddingTop();
            decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(recycler) + width;
            if (layoutState.mLayoutDirection == -1) {
                i = width;
                i2 = layoutState.mOffset;
                i3 = decoratedMeasurementInOther;
                decoratedMeasurementInOther = layoutState.mOffset - layoutChunkResult.mConsumed;
            } else {
                i2 = layoutState.mOffset + layoutChunkResult.mConsumed;
                i = width;
                i3 = decoratedMeasurementInOther;
                decoratedMeasurementInOther = layoutState.mOffset;
            }
        }
        layoutDecoratedWithMargins(recycler, decoratedMeasurementInOther, i, i2, i3);
        if (!(layoutParams.isItemRemoved() == null && layoutParams.isItemChanged() == null)) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = recycler.hasFocusable();
    }

    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        } else {
            if (i == 33) {
                return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
            } else {
                if (i == 66) {
                    return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
                } else {
                    if (i == 130) {
                        return this.mOrientation == 1 ? 1 : Integer.MIN_VALUE;
                    } else {
                        switch (i) {
                            case 1:
                                return (this.mOrientation == 1 || isLayoutRTL() == 0) ? -1 : 1;
                            case 2:
                                return (this.mOrientation == 1 || isLayoutRTL() == 0) ? 1 : -1;
                            default:
                                return Integer.MIN_VALUE;
                        }
                    }
                }
            }
        }
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    private View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    private View findReferenceChildClosestToEnd(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findFirstReferenceChild(recycler, state);
        }
        return findLastReferenceChild(recycler, state);
    }

    private View findReferenceChildClosestToStart(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findLastReferenceChild(recycler, state);
        }
        return findFirstReferenceChild(recycler, state);
    }

    private View findFirstReferenceChild(Recycler recycler, State state) {
        return findReferenceChild(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private View findLastReferenceChild(Recycler recycler, State state) {
        return findReferenceChild(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    View findReferenceChild(Recycler recycler, State state, int i, int i2, int i3) {
        ensureLayoutState();
        recycler = this.mOrientationHelper.getStartAfterPadding();
        state = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (!((LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < state) {
                        if (this.mOrientationHelper.getDecoratedEnd(childAt) >= recycler) {
                            return childAt;
                        }
                    }
                    if (view == null) {
                        view = childAt;
                    }
                } else if (view2 == null) {
                    view2 = childAt;
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(Recycler recycler, State state) {
        if (this.mShouldReverseLayout) {
            return findLastPartiallyOrCompletelyInvisibleChild(recycler, state);
        }
        return findFirstPartiallyOrCompletelyInvisibleChild(recycler, state);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild(Recycler recycler, State state) {
        return findOnePartiallyOrCompletelyInvisibleChild(null, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(Recycler recycler, State state) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = 320;
        z = z ? true : true;
        if (!z2) {
            i3 = 0;
        }
        if (this.mOrientation) {
            return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, z, i3);
        }
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, z, i3);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        ensureLayoutState();
        Object obj = i2 > i ? 1 : i2 < i ? -1 : null;
        if (obj == null) {
            return getChildAt(i);
        }
        int i3;
        int i4;
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i)) < this.mOrientationHelper.getStartAfterPadding()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
    }

    public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
        resolveShouldLayoutReverse();
        if (getChildCount() == null) {
            return null;
        }
        view = convertFocusDirectionToLayoutDirection(i);
        if (view == -2147483648) {
            return null;
        }
        ensureLayoutState();
        ensureLayoutState();
        updateLayoutState(view, (int) (MAX_SCROLL_FACTOR * ((float) this.mOrientationHelper.getTotalSpace())), false, state);
        this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        this.mLayoutState.mRecycle = false;
        fill(recycler, this.mLayoutState, state, true);
        if (view == -1) {
            recycler = findPartiallyOrCompletelyInvisibleChildClosestToStart(recycler, state);
        } else {
            recycler = findPartiallyOrCompletelyInvisibleChildClosestToEnd(recycler, state);
        }
        if (view == -1) {
            view = getChildClosestToStart();
        } else {
            view = getChildClosestToEnd();
        }
        if (view.hasFocusable() == 0) {
            return recycler;
        }
        if (recycler == null) {
            return null;
        }
        return view;
    }

    private void logChildren() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            StringBuilder stringBuilder = new StringBuilder("item ");
            stringBuilder.append(getPosition(childAt));
            stringBuilder.append(", coord:");
            stringBuilder.append(this.mOrientationHelper.getDecoratedStart(childAt));
        }
    }

    void validateChildOrder() {
        new StringBuilder("validating child count ").append(getChildCount());
        if (getChildCount() > 0) {
            boolean z = false;
            int position = getPosition(getChildAt(0));
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
            int i;
            View childAt;
            int position2;
            int decoratedStart2;
            StringBuilder stringBuilder;
            if (this.mShouldReverseLayout) {
                i = 1;
                while (i < getChildCount()) {
                    childAt = getChildAt(i);
                    position2 = getPosition(childAt);
                    decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                    if (position2 < position) {
                        logChildren();
                        stringBuilder = new StringBuilder("detected invalid position. loc invalid? ");
                        if (decoratedStart2 < decoratedStart) {
                            z = true;
                        }
                        stringBuilder.append(z);
                        throw new RuntimeException(stringBuilder.toString());
                    } else if (decoratedStart2 > decoratedStart) {
                        logChildren();
                        throw new RuntimeException("detected invalid location");
                    } else {
                        i++;
                    }
                }
                return;
            }
            i = 1;
            while (i < getChildCount()) {
                childAt = getChildAt(i);
                position2 = getPosition(childAt);
                decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    stringBuilder = new StringBuilder("detected invalid position. loc invalid? ");
                    if (decoratedStart2 < decoratedStart) {
                        z = true;
                    }
                    stringBuilder.append(z);
                    throw new RuntimeException(stringBuilder.toString());
                } else if (decoratedStart2 < decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                } else {
                    i++;
                }
            }
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    @RestrictTo({Scope.LIBRARY_GROUP})
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        i = getPosition(view);
        i2 = getPosition(view2);
        i = i < i2 ? 1 : -1;
        if (this.mShouldReverseLayout) {
            if (i == 1) {
                scrollToPositionWithOffset(i2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(view2) + this.mOrientationHelper.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(i2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
            }
        } else if (i == -1) {
            scrollToPositionWithOffset(i2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(i2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }
}
