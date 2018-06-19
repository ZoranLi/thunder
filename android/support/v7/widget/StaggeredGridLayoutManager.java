package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends LayoutManager implements ScrollVectorProvider {
    static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo = new AnchorInfo();
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy = 2;
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    @NonNull
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup = new LazySpanLookup();
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition = -1;
    int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    private int[] mPrefetchDistances;
    @NonNull
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout = false;
    @NonNull
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout = false;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount = -1;
    Span[] mSpans;
    private final Rect mTmpRect = new Rect();

    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;

        AnchorInfo() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            if (this.mSpanReferenceLines != null) {
                Arrays.fill(this.mSpanReferenceLines, -1);
            }
        }

        void saveSpanReferenceLines(Span[] spanArr) {
            int length = spanArr.length;
            if (this.mSpanReferenceLines == null || this.mSpanReferenceLines.length < length) {
                this.mSpanReferenceLines = new int[StaggeredGridLayoutManager.this.mSpans.length];
            }
            for (int i = 0; i < length; i++) {
                this.mSpanReferenceLines[i] = spanArr[i].getStartLine(Integer.MIN_VALUE);
            }
        }

        void assignCoordinateFromPadding() {
            int endAfterPadding;
            if (this.mLayoutFromEnd) {
                endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            } else {
                endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            }
            this.mOffset = endAfterPadding;
        }

        void assignCoordinateFromPadding(int i) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i;
            }
        }
    }

    static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        static class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR = new Creator<FullSpanItem>() {
                public final FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public final FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                boolean z = true;
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.mHasUnwantedGapAfter = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.mGapPerSpan = new int[readInt];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            FullSpanItem() {
            }

            int getGapForSpan(int i) {
                return this.mGapPerSpan == null ? 0 : this.mGapPerSpan[i];
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter);
                if (this.mGapPerSpan == 0 || this.mGapPerSpan.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.mGapPerSpan.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("FullSpanItem{mPosition=");
                stringBuilder.append(this.mPosition);
                stringBuilder.append(", mGapDir=");
                stringBuilder.append(this.mGapDir);
                stringBuilder.append(", mHasUnwantedGapAfter=");
                stringBuilder.append(this.mHasUnwantedGapAfter);
                stringBuilder.append(", mGapPerSpan=");
                stringBuilder.append(Arrays.toString(this.mGapPerSpan));
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
        }

        LazySpanLookup() {
        }

        int forceInvalidateAfter(int i) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.mFullSpanItems.get(size)).mPosition >= i) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i);
        }

        int invalidateAfter(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
            if (invalidateFullSpansAfter == -1) {
                Arrays.fill(this.mData, i, this.mData.length, -1);
                return this.mData.length;
            }
            invalidateFullSpansAfter++;
            Arrays.fill(this.mData, i, invalidateFullSpansAfter, -1);
            return invalidateFullSpansAfter;
        }

        int getSpan(int i) {
            if (this.mData != null) {
                if (i < this.mData.length) {
                    return this.mData[i];
                }
            }
            return -1;
        }

        void setSpan(int i, Span span) {
            ensureSize(i);
            this.mData[i] = span.mIndex;
        }

        int sizeForPosition(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void ensureSize(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.mData, -1);
                return;
            }
            if (i >= this.mData.length) {
                Object obj = this.mData;
                this.mData = new int[sizeForPosition(i)];
                System.arraycopy(obj, 0, this.mData, 0, obj.length);
                Arrays.fill(this.mData, obj.length, this.mData.length, -1);
            }
        }

        void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.mFullSpanItems = null;
        }

        void offsetForRemoval(int i, int i2) {
            if (this.mData != null) {
                if (i < this.mData.length) {
                    int i3 = i + i2;
                    ensureSize(i3);
                    System.arraycopy(this.mData, i3, this.mData, i, (this.mData.length - i) - i2);
                    Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                    offsetFullSpansForRemoval(i, i2);
                }
            }
        }

        private void offsetFullSpansForRemoval(int i, int i2) {
            if (this.mFullSpanItems != null) {
                int i3 = i + i2;
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.mFullSpanItems.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        void offsetForAddition(int i, int i2) {
            if (this.mData != null) {
                if (i < this.mData.length) {
                    int i3 = i + i2;
                    ensureSize(i3);
                    System.arraycopy(this.mData, i, this.mData, i3, (this.mData.length - i) - i2);
                    Arrays.fill(this.mData, i, i3, -1);
                    offsetFullSpansForAddition(i, i2);
                }
            }
        }

        private void offsetFullSpansForAddition(int i, int i2) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int invalidateFullSpansAfter(int i) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i2 = 0;
            while (i2 < size) {
                if (((FullSpanItem) this.mFullSpanItems.get(i2)).mPosition >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem2 = (FullSpanItem) this.mFullSpanItems.get(i2);
            this.mFullSpanItems.remove(i2);
            return fullSpanItem2.mPosition;
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.mFullSpanItems.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        public FullSpanItem getFullSpanItem(int i) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            int size = this.mFullSpanItems.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i && (i3 == 0 || fullSpanItem.mGapDir == i3 || (z && fullSpanItem.mHasUnwantedGapAfter))) {
                    return fullSpanItem;
                }
            }
            return null;
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
        int mAnchorPosition;
        List<FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        public int describeContents() {
            return 0;
        }

        SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            if (this.mSpanOffsetsSize > 0) {
                this.mSpanOffsets = new int[this.mSpanOffsetsSize];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            if (this.mSpanLookupSize > 0) {
                this.mSpanLookup = new int[this.mSpanLookupSize];
                parcel.readIntArray(this.mSpanLookup);
            }
            boolean z = false;
            this.mReverseLayout = parcel.readInt() == 1;
            this.mAnchorLayoutFromEnd = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            }
            this.mLastLayoutRTL = z;
            this.mFullSpanItems = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout);
            parcel.writeInt(this.mAnchorLayoutFromEnd);
            parcel.writeInt(this.mLastLayoutRTL);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd = Integer.MIN_VALUE;
        int mCachedStart = Integer.MIN_VALUE;
        int mDeletedSize = null;
        final int mIndex;
        ArrayList<View> mViews = new ArrayList();

        Span(int i) {
            this.mIndex = i;
        }

        int getStartLine(int i) {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                return this.mCachedStart;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        void calculateCachedStart() {
            View view = (View) this.mViews.get(0);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == -1) {
                    this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
                }
            }
        }

        int getStartLine() {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                return this.mCachedStart;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        int getEndLine(int i) {
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                return this.mCachedEnd;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        void calculateCachedEnd() {
            View view = (View) this.mViews.get(this.mViews.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == 1) {
                    this.mCachedEnd += fullSpanItem.getGapForSpan(this.mIndex);
                }
            }
        }

        int getEndLine() {
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                return this.mCachedEnd;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(0, view);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void cacheReferenceLineAndClear(boolean z, int i) {
            int endLine;
            if (z) {
                endLine = getEndLine(Integer.MIN_VALUE);
            } else {
                endLine = getStartLine(Integer.MIN_VALUE);
            }
            clear();
            if (endLine != Integer.MIN_VALUE) {
                if ((!z || endLine >= StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) && (z || endLine <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding())) {
                    if (i != Integer.MIN_VALUE) {
                        endLine += i;
                    }
                    this.mCachedEnd = endLine;
                    this.mCachedStart = endLine;
                }
            }
        }

        void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void setLine(int i) {
            this.mCachedStart = i;
            this.mCachedEnd = i;
        }

        void popEnd() {
            int size = this.mViews.size();
            View view = (View) this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            if (size == 1) {
                this.mCachedStart = Integer.MIN_VALUE;
            }
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        void popStart() {
            View view = (View) this.mViews.remove(0);
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = Integer.MIN_VALUE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            this.mCachedStart = Integer.MIN_VALUE;
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void onOffset(int i) {
            if (this.mCachedStart != Integer.MIN_VALUE) {
                this.mCachedStart += i;
            }
            if (this.mCachedEnd != Integer.MIN_VALUE) {
                this.mCachedEnd += i;
            }
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, false);
            }
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(this.mViews.size() - 1, -1, true);
            }
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), false);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
            }
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.mReverseLayout) {
                return findOneVisibleChild(0, this.mViews.size(), true);
            }
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        int findOnePartiallyOrCompletelyVisibleChild(int r11, int r12, boolean r13, boolean r14, boolean r15) {
            /*
            r10 = this;
            r0 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r0 = r0.mPrimaryOrientation;
            r0 = r0.getStartAfterPadding();
            r1 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r1 = r1.mPrimaryOrientation;
            r1 = r1.getEndAfterPadding();
            r2 = -1;
            r3 = 1;
            if (r12 <= r11) goto L_0x0016;
        L_0x0014:
            r4 = r3;
            goto L_0x0017;
        L_0x0016:
            r4 = r2;
        L_0x0017:
            if (r11 == r12) goto L_0x006f;
        L_0x0019:
            r5 = r10.mViews;
            r5 = r5.get(r11);
            r5 = (android.view.View) r5;
            r6 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r6 = r6.mPrimaryOrientation;
            r6 = r6.getDecoratedStart(r5);
            r7 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r7 = r7.mPrimaryOrientation;
            r7 = r7.getDecoratedEnd(r5);
            r8 = 0;
            if (r15 == 0) goto L_0x003a;
        L_0x0034:
            if (r6 > r1) goto L_0x0038;
        L_0x0036:
            r9 = r3;
            goto L_0x003d;
        L_0x0038:
            r9 = r8;
            goto L_0x003d;
        L_0x003a:
            if (r6 >= r1) goto L_0x0038;
        L_0x003c:
            goto L_0x0036;
        L_0x003d:
            if (r15 == 0) goto L_0x0043;
        L_0x003f:
            if (r7 < r0) goto L_0x0046;
        L_0x0041:
            r8 = r3;
            goto L_0x0046;
        L_0x0043:
            if (r7 <= r0) goto L_0x0046;
        L_0x0045:
            goto L_0x0041;
        L_0x0046:
            if (r9 == 0) goto L_0x006d;
        L_0x0048:
            if (r8 == 0) goto L_0x006d;
        L_0x004a:
            if (r13 == 0) goto L_0x0059;
        L_0x004c:
            if (r14 == 0) goto L_0x0059;
        L_0x004e:
            if (r6 < r0) goto L_0x006d;
        L_0x0050:
            if (r7 > r1) goto L_0x006d;
        L_0x0052:
            r11 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x0059:
            if (r14 == 0) goto L_0x0062;
        L_0x005b:
            r11 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x0062:
            if (r6 < r0) goto L_0x0066;
        L_0x0064:
            if (r7 <= r1) goto L_0x006d;
        L_0x0066:
            r11 = android.support.v7.widget.StaggeredGridLayoutManager.this;
            r11 = r11.getPosition(r5);
            return r11;
        L_0x006d:
            r11 = r11 + r4;
            goto L_0x0017;
        L_0x006f:
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.Span.findOnePartiallyOrCompletelyVisibleChild(int, int, boolean, boolean, boolean):int");
        }

        int findOneVisibleChild(int i, int i2, boolean z) {
            return findOnePartiallyOrCompletelyVisibleChild(i, i2, z, true, false);
        }

        int findOnePartiallyVisibleChild(int i, int i2, boolean z) {
            return findOnePartiallyOrCompletelyVisibleChild(i, i2, false, false, z);
        }

        public View getFocusableViewAfter(int i, int i2) {
            View view = null;
            if (i2 != -1) {
                i2 = this.mViews.size() - 1;
                while (i2 >= 0) {
                    View view2 = (View) this.mViews.get(i2);
                    if ((StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view2) >= i) || ((!StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view2) <= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i2--;
                    view = view2;
                }
            } else {
                i2 = this.mViews.size();
                int i3 = 0;
                while (i3 < i2) {
                    View view3 = (View) this.mViews.get(i3);
                    if ((StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view3) <= i) || ((!StaggeredGridLayoutManager.this.mReverseLayout && StaggeredGridLayoutManager.this.getPosition(view3) >= i) || !view3.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view3;
                }
            }
            return view;
        }
    }

    public static class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setFullSpan(boolean z) {
            this.mFullSpan = z;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public final int getSpanIndex() {
            if (this.mSpan == null) {
                return -1;
            }
            return this.mSpan.mIndex;
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new Runnable() {
            public void run() {
                StaggeredGridLayoutManager.this.checkForGaps();
            }
        };
        context = LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(context.orientation);
        setSpanCount(context.spanCount);
        setReverseLayout(context.reverseLayout);
        if (this.mGapStrategy == null) {
            z = false;
        }
        setAutoMeasureEnabled(z);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = /* anonymous class already generated */;
        this.mOrientation = i2;
        setSpanCount(i);
        if (this.mGapStrategy == 0) {
            z = false;
        }
        setAutoMeasureEnabled(z);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    boolean checkForGaps() {
        if (!(getChildCount() == 0 || this.mGapStrategy == 0)) {
            if (isAttachedToWindow()) {
                int lastChildPosition;
                int firstChildPosition;
                if (this.mShouldReverseLayout) {
                    lastChildPosition = getLastChildPosition();
                    firstChildPosition = getFirstChildPosition();
                } else {
                    lastChildPosition = getFirstChildPosition();
                    firstChildPosition = getLastChildPosition();
                }
                if (lastChildPosition == 0 && hasGapsToFix() != null) {
                    this.mLazySpanLookup.clear();
                    requestSimpleAnimationsInNextLayout();
                    requestLayout();
                    return true;
                } else if (!this.mLaidOutInvalidFullSpan) {
                    return false;
                } else {
                    int i = this.mShouldReverseLayout ? -1 : 1;
                    firstChildPosition++;
                    FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(lastChildPosition, firstChildPosition, i, true);
                    if (firstFullSpanItemInRange == null) {
                        this.mLaidOutInvalidFullSpan = false;
                        this.mLazySpanLookup.forceInvalidateAfter(firstChildPosition);
                        return false;
                    }
                    FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(lastChildPosition, firstFullSpanItemInRange.mPosition, i * -1, true);
                    if (firstFullSpanItemInRange2 == null) {
                        this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
                    } else {
                        this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
                    }
                    requestSimpleAnimationsInNextLayout();
                    requestLayout();
                    return true;
                }
            }
        }
        return false;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
        removeCallbacks(this.mCheckForGapsRunnable);
        for (recycler = null; recycler < this.mSpanCount; recycler++) {
            this.mSpans[recycler].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    android.view.View hasGapsToFix() {
        /*
        r12 = this;
        r0 = r12.getChildCount();
        r1 = 1;
        r0 = r0 - r1;
        r2 = new java.util.BitSet;
        r3 = r12.mSpanCount;
        r2.<init>(r3);
        r3 = r12.mSpanCount;
        r4 = 0;
        r2.set(r4, r3, r1);
        r3 = r12.mOrientation;
        r5 = -1;
        if (r3 != r1) goto L_0x0020;
    L_0x0018:
        r3 = r12.isLayoutRTL();
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        r3 = r1;
        goto L_0x0021;
    L_0x0020:
        r3 = r5;
    L_0x0021:
        r6 = r12.mShouldReverseLayout;
        if (r6 == 0) goto L_0x0027;
    L_0x0025:
        r6 = r5;
        goto L_0x002b;
    L_0x0027:
        r0 = r0 + 1;
        r6 = r0;
        r0 = r4;
    L_0x002b:
        if (r0 >= r6) goto L_0x002e;
    L_0x002d:
        r5 = r1;
    L_0x002e:
        if (r0 == r6) goto L_0x00aa;
    L_0x0030:
        r7 = r12.getChildAt(r0);
        r8 = r7.getLayoutParams();
        r8 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r8;
        r9 = r8.mSpan;
        r9 = r9.mIndex;
        r9 = r2.get(r9);
        if (r9 == 0) goto L_0x0054;
    L_0x0044:
        r9 = r8.mSpan;
        r9 = r12.checkSpanForGap(r9);
        if (r9 == 0) goto L_0x004d;
    L_0x004c:
        return r7;
    L_0x004d:
        r9 = r8.mSpan;
        r9 = r9.mIndex;
        r2.clear(r9);
    L_0x0054:
        r9 = r8.mFullSpan;
        if (r9 != 0) goto L_0x00a8;
    L_0x0058:
        r9 = r0 + r5;
        if (r9 == r6) goto L_0x00a8;
    L_0x005c:
        r9 = r12.getChildAt(r9);
        r10 = r12.mShouldReverseLayout;
        if (r10 == 0) goto L_0x0076;
    L_0x0064:
        r10 = r12.mPrimaryOrientation;
        r10 = r10.getDecoratedEnd(r7);
        r11 = r12.mPrimaryOrientation;
        r11 = r11.getDecoratedEnd(r9);
        if (r10 >= r11) goto L_0x0073;
    L_0x0072:
        return r7;
    L_0x0073:
        if (r10 != r11) goto L_0x0089;
    L_0x0075:
        goto L_0x0087;
    L_0x0076:
        r10 = r12.mPrimaryOrientation;
        r10 = r10.getDecoratedStart(r7);
        r11 = r12.mPrimaryOrientation;
        r11 = r11.getDecoratedStart(r9);
        if (r10 <= r11) goto L_0x0085;
    L_0x0084:
        return r7;
    L_0x0085:
        if (r10 != r11) goto L_0x0089;
    L_0x0087:
        r10 = r1;
        goto L_0x008a;
    L_0x0089:
        r10 = r4;
    L_0x008a:
        if (r10 == 0) goto L_0x00a8;
    L_0x008c:
        r9 = r9.getLayoutParams();
        r9 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r9;
        r8 = r8.mSpan;
        r8 = r8.mIndex;
        r9 = r9.mSpan;
        r9 = r9.mIndex;
        r8 = r8 - r9;
        if (r8 >= 0) goto L_0x009f;
    L_0x009d:
        r8 = r1;
        goto L_0x00a0;
    L_0x009f:
        r8 = r4;
    L_0x00a0:
        if (r3 >= 0) goto L_0x00a4;
    L_0x00a2:
        r9 = r1;
        goto L_0x00a5;
    L_0x00a4:
        r9 = r4;
    L_0x00a5:
        if (r8 == r9) goto L_0x00a8;
    L_0x00a7:
        return r7;
    L_0x00a8:
        r0 = r0 + r5;
        goto L_0x002e;
    L_0x00aa:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.hasGapsToFix():android.view.View");
    }

    private boolean checkSpanForGap(Span span) {
        return this.mShouldReverseLayout ? span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding() && span.getLayoutParams((View) span.mViews.get(span.mViews.size() - 1)).mFullSpan == null : span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding() && span.getLayoutParams((View) span.mViews.get(0)).mFullSpan == null;
        return false;
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (i = 0; i < this.mSpanCount; i++) {
                this.mSpans[i] = new Span(i);
            }
            requestLayout();
        }
    }

    public void setOrientation(int i) {
        if (i == 0 || i == 1) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                i = this.mPrimaryOrientation;
                this.mPrimaryOrientation = this.mSecondaryOrientation;
                this.mSecondaryOrientation = i;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mReverseLayout == z)) {
            this.mPendingSavedState.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mGapStrategy) {
            if (i == 0 || i == 2) {
                this.mGapStrategy = i;
                setAutoMeasureEnabled(this.mGapStrategy != 0 ? 1 : 0);
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
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

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            rect = LayoutManager.chooseSize(i2, rect.height() + paddingTop, getMinimumHeight());
            i = LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingLeft, getMinimumWidth());
        } else {
            i = LayoutManager.chooseSize(i, rect.width() + paddingLeft, getMinimumWidth());
            rect = LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(i, rect);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        onLayoutChildren(recycler, state, true);
    }

    private void onLayoutChildren(Recycler recycler, State state, boolean z) {
        while (true) {
            AnchorInfo anchorInfo = this.mAnchorInfo;
            if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
                removeAndRecycleAllViews(recycler);
                anchorInfo.reset();
                return;
            }
            boolean z2;
            int i;
            boolean z3 = true;
            if (anchorInfo.mValid && this.mPendingScrollPosition == -1) {
                if (this.mPendingSavedState == null) {
                    z2 = false;
                    if (z2) {
                        anchorInfo.reset();
                        if (this.mPendingSavedState == null) {
                            applyPendingSavedState(anchorInfo);
                        } else {
                            resolveShouldLayoutReverse();
                            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                        }
                        updateAnchorInfoForLayout(state, anchorInfo);
                        anchorInfo.mValid = true;
                    }
                    if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && !(anchorInfo.mLayoutFromEnd == this.mLastLayoutFromEnd && isLayoutRTL() == this.mLastLayoutRTL)) {
                        this.mLazySpanLookup.clear();
                        anchorInfo.mInvalidateOffsets = true;
                    }
                    if (getChildCount() > 0 && (this.mPendingSavedState == null || this.mPendingSavedState.mSpanOffsetsSize <= 0)) {
                        if (anchorInfo.mInvalidateOffsets) {
                            if (!z2) {
                                if (this.mAnchorInfo.mSpanReferenceLines == null) {
                                    for (i = 0; i < this.mSpanCount; i++) {
                                        Span span = this.mSpans[i];
                                        span.clear();
                                        span.setLine(this.mAnchorInfo.mSpanReferenceLines[i]);
                                    }
                                }
                            }
                            for (i = 0; i < this.mSpanCount; i++) {
                                this.mSpans[i].cacheReferenceLineAndClear(this.mShouldReverseLayout, anchorInfo.mOffset);
                            }
                            this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
                        } else {
                            for (i = 0; i < this.mSpanCount; i++) {
                                this.mSpans[i].clear();
                                if (anchorInfo.mOffset != Integer.MIN_VALUE) {
                                    this.mSpans[i].setLine(anchorInfo.mOffset);
                                }
                            }
                        }
                    }
                    detachAndScrapAttachedViews(recycler);
                    this.mLayoutState.mRecycle = false;
                    this.mLaidOutInvalidFullSpan = false;
                    updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
                    updateLayoutState(anchorInfo.mPosition, state);
                    if (anchorInfo.mLayoutFromEnd) {
                        setLayoutStateDirection(1);
                        fill(recycler, this.mLayoutState, state);
                        setLayoutStateDirection(-1);
                        this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
                        fill(recycler, this.mLayoutState, state);
                    } else {
                        setLayoutStateDirection(-1);
                        fill(recycler, this.mLayoutState, state);
                        setLayoutStateDirection(1);
                        this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
                        fill(recycler, this.mLayoutState, state);
                    }
                    repositionToWrapContentIfNecessary();
                    if (getChildCount() > 0) {
                        if (this.mShouldReverseLayout) {
                            fixStartGap(recycler, state, true);
                            fixEndGap(recycler, state, false);
                        } else {
                            fixEndGap(recycler, state, true);
                            fixStartGap(recycler, state, false);
                        }
                    }
                    if (z && !state.isPreLayout()) {
                        z = this.mGapStrategy && getChildCount() <= false && (this.mLaidOutInvalidFullSpan || hasGapsToFix());
                        if (z) {
                            removeCallbacks(this.mCheckForGapsRunnable);
                            if (checkForGaps()) {
                                if (state.isPreLayout()) {
                                    this.mAnchorInfo.reset();
                                }
                                this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
                                this.mLastLayoutRTL = isLayoutRTL();
                                if (!z3) {
                                    this.mAnchorInfo.reset();
                                    z = false;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                    z3 = false;
                    if (state.isPreLayout()) {
                        this.mAnchorInfo.reset();
                    }
                    this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
                    this.mLastLayoutRTL = isLayoutRTL();
                    if (!z3) {
                        this.mAnchorInfo.reset();
                        z = false;
                    } else {
                        return;
                    }
                }
            }
            z2 = true;
            if (z2) {
                anchorInfo.reset();
                if (this.mPendingSavedState == null) {
                    resolveShouldLayoutReverse();
                    anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
                } else {
                    applyPendingSavedState(anchorInfo);
                }
                updateAnchorInfoForLayout(state, anchorInfo);
                anchorInfo.mValid = true;
            }
            this.mLazySpanLookup.clear();
            anchorInfo.mInvalidateOffsets = true;
            if (anchorInfo.mInvalidateOffsets) {
                if (z2) {
                    if (this.mAnchorInfo.mSpanReferenceLines == null) {
                        for (i = 0; i < this.mSpanCount; i++) {
                            Span span2 = this.mSpans[i];
                            span2.clear();
                            span2.setLine(this.mAnchorInfo.mSpanReferenceLines[i]);
                        }
                    }
                }
                for (i = 0; i < this.mSpanCount; i++) {
                    this.mSpans[i].cacheReferenceLineAndClear(this.mShouldReverseLayout, anchorInfo.mOffset);
                }
                this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
            } else {
                for (i = 0; i < this.mSpanCount; i++) {
                    this.mSpans[i].clear();
                    if (anchorInfo.mOffset != Integer.MIN_VALUE) {
                        this.mSpans[i].setLine(anchorInfo.mOffset);
                    }
                }
            }
            detachAndScrapAttachedViews(recycler);
            this.mLayoutState.mRecycle = false;
            this.mLaidOutInvalidFullSpan = false;
            updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
            updateLayoutState(anchorInfo.mPosition, state);
            if (anchorInfo.mLayoutFromEnd) {
                setLayoutStateDirection(1);
                fill(recycler, this.mLayoutState, state);
                setLayoutStateDirection(-1);
                this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
                fill(recycler, this.mLayoutState, state);
            } else {
                setLayoutStateDirection(-1);
                fill(recycler, this.mLayoutState, state);
                setLayoutStateDirection(1);
                this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
                fill(recycler, this.mLayoutState, state);
            }
            repositionToWrapContentIfNecessary();
            if (getChildCount() > 0) {
                if (this.mShouldReverseLayout) {
                    fixStartGap(recycler, state, true);
                    fixEndGap(recycler, state, false);
                } else {
                    fixEndGap(recycler, state, true);
                    fixStartGap(recycler, state, false);
                }
            }
            if (!this.mGapStrategy) {
            }
            if (z) {
                removeCallbacks(this.mCheckForGapsRunnable);
                if (checkForGaps()) {
                    if (state.isPreLayout()) {
                        this.mAnchorInfo.reset();
                    }
                    this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
                    this.mLastLayoutRTL = isLayoutRTL();
                    if (!z3) {
                        this.mAnchorInfo.reset();
                        z = false;
                    } else {
                        return;
                    }
                }
            }
            z3 = false;
            if (state.isPreLayout()) {
                this.mAnchorInfo.reset();
            }
            this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
            this.mLastLayoutRTL = isLayoutRTL();
            if (!z3) {
                this.mAnchorInfo.reset();
                z = false;
            } else {
                return;
            }
        }
    }

    public void onLayoutCompleted(State state) {
        super.onLayoutCompleted(state);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) {
            int i;
            int childCount = getChildCount();
            int i2 = 0;
            float f = 0.0f;
            for (i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                float decoratedMeasurement = (float) this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement >= f) {
                    if (((LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                        decoratedMeasurement = (1.0f * decoratedMeasurement) / ((float) this.mSpanCount);
                    }
                    f = Math.max(f, decoratedMeasurement);
                }
            }
            i = this.mSizePerSpan;
            int round = Math.round(f * ((float) this.mSpanCount));
            if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.mSecondaryOrientation.getTotalSpace());
            }
            updateMeasureSpecs(round);
            if (this.mSizePerSpan != i) {
                while (i2 < childCount) {
                    View childAt2 = getChildAt(i2);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.mFullSpan) {
                        if (isLayoutRTL() && this.mOrientation == 1) {
                            childAt2.offsetLeftAndRight(((-((this.mSpanCount - 1) - layoutParams.mSpan.mIndex)) * this.mSizePerSpan) - ((-((this.mSpanCount - 1) - layoutParams.mSpan.mIndex)) * i));
                        } else {
                            int i3 = layoutParams.mSpan.mIndex * this.mSizePerSpan;
                            int i4 = layoutParams.mSpan.mIndex * i;
                            if (this.mOrientation == 1) {
                                childAt2.offsetLeftAndRight(i3 - i4);
                            } else {
                                childAt2.offsetTopAndBottom(i3 - i4);
                            }
                        }
                    }
                    i2++;
                }
            }
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
            if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
                for (int i = 0; i < this.mSpanCount; i++) {
                    this.mSpans[i].clear();
                    int i2 = this.mPendingSavedState.mSpanOffsets[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.mPendingSavedState.mAnchorLayoutFromEnd) {
                            i2 += this.mPrimaryOrientation.getEndAfterPadding();
                        } else {
                            i2 += this.mPrimaryOrientation.getStartAfterPadding();
                        }
                    }
                    this.mSpans[i].setLine(i2);
                }
            } else {
                this.mPendingSavedState.invalidateSpanInfo();
                this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
            }
        }
        this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
        setReverseLayout(this.mPendingSavedState.mReverseLayout);
        resolveShouldLayoutReverse();
        if (this.mPendingSavedState.mAnchorPosition != -1) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (this.mPendingSavedState.mSpanLookupSize > 1) {
            this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
            this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
        }
    }

    void updateAnchorInfoForLayout(State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && updateAnchorFromChildren(state, anchorInfo) == null) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = null;
        }
    }

    private boolean updateAnchorFromChildren(State state, AnchorInfo anchorInfo) {
        if (this.mLastLayoutFromEnd) {
            state = findLastReferenceChildPosition(state.getItemCount());
        } else {
            state = findFirstReferenceChildPosition(state.getItemCount());
        }
        anchorInfo.mPosition = state;
        anchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    boolean updateAnchorFromPendingData(State state, AnchorInfo anchorInfo) {
        boolean z = false;
        if (!state.isPreLayout()) {
            if (this.mPendingScrollPosition != -1) {
                if (this.mPendingScrollPosition >= 0) {
                    if (this.mPendingScrollPosition < state.getItemCount()) {
                        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == -1)) {
                            if (this.mPendingSavedState.mSpanOffsetsSize > null) {
                                anchorInfo.mOffset = Integer.MIN_VALUE;
                                anchorInfo.mPosition = this.mPendingScrollPosition;
                                return true;
                            }
                        }
                        state = findViewByPosition(this.mPendingScrollPosition);
                        if (state != null) {
                            int lastChildPosition;
                            if (this.mShouldReverseLayout) {
                                lastChildPosition = getLastChildPosition();
                            } else {
                                lastChildPosition = getFirstChildPosition();
                            }
                            anchorInfo.mPosition = lastChildPosition;
                            if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                                if (anchorInfo.mLayoutFromEnd) {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(state);
                                } else {
                                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(state);
                                }
                                return true;
                            } else if (this.mPrimaryOrientation.getDecoratedMeasurement(state) > this.mPrimaryOrientation.getTotalSpace()) {
                                if (anchorInfo.mLayoutFromEnd != null) {
                                    state = this.mPrimaryOrientation.getEndAfterPadding();
                                } else {
                                    state = this.mPrimaryOrientation.getStartAfterPadding();
                                }
                                anchorInfo.mOffset = state;
                                return true;
                            } else {
                                lastChildPosition = this.mPrimaryOrientation.getDecoratedStart(state) - this.mPrimaryOrientation.getStartAfterPadding();
                                if (lastChildPosition < 0) {
                                    anchorInfo.mOffset = -lastChildPosition;
                                    return true;
                                }
                                lastChildPosition = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(state);
                                if (lastChildPosition < 0) {
                                    anchorInfo.mOffset = lastChildPosition;
                                    return true;
                                }
                                anchorInfo.mOffset = Integer.MIN_VALUE;
                            }
                        } else {
                            anchorInfo.mPosition = this.mPendingScrollPosition;
                            if (this.mPendingScrollPositionOffset == -2147483648) {
                                if (calculateScrollDirectionForPosition(anchorInfo.mPosition) == 1) {
                                    z = true;
                                }
                                anchorInfo.mLayoutFromEnd = z;
                                anchorInfo.assignCoordinateFromPadding();
                            } else {
                                anchorInfo.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
                            }
                            anchorInfo.mInvalidateOffsets = true;
                        }
                        return true;
                    }
                }
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
        }
        return false;
    }

    void updateMeasureSpecs(int i) {
        this.mSizePerSpan = i / this.mSpanCount;
        this.mFullSizeSpec = MeasureSpec.makeMeasureSpec(i, this.mSecondaryOrientation.getMode());
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(iArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(iArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(iArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder stringBuilder = new StringBuilder("Provided int[]'s size must be more than or equal to span count. Expected:");
            stringBuilder.append(this.mSpanCount);
            stringBuilder.append(", array size:");
            stringBuilder.append(iArr.length);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int computeHorizontalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        return ScrollbarHelper.computeScrollOffset(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ 1), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ 1), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    public int computeVerticalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        return ScrollbarHelper.computeScrollExtent(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ 1), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ 1), this, this.mSmoothScrollbarEnabled);
    }

    public int computeVerticalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollRange(State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(State state) {
        if (getChildCount() == 0) {
            return null;
        }
        return ScrollbarHelper.computeScrollRange(state, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(this.mSmoothScrollbarEnabled ^ 1), findFirstVisibleItemClosestToEnd(this.mSmoothScrollbarEnabled ^ 1), this, this.mSmoothScrollbarEnabled);
    }

    public int computeVerticalScrollRange(State state) {
        return computeScrollRange(state);
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
            } else {
                measureChildWithDecorationsAndMargin(view, LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), this.mFullSizeSpec, z);
            }
        } else if (this.mOrientation == 1) {
            measureChildWithDecorationsAndMargin(view, LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, layoutParams.width, false), LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
        } else {
            measureChildWithDecorationsAndMargin(view, LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, layoutParams.height, false), z);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        i = updateSpecWithExtra(i, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right);
        i2 = updateSpecWithExtra(i2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom);
        if (z) {
            z = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            z = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (z) {
            view.measure(i, i2);
        }
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                return i;
            }
        }
        return MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        Parcelable savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        int i = 0;
        if (this.mLazySpanLookup == null || this.mLazySpanLookup.mData == null) {
            savedState.mSpanLookupSize = 0;
        } else {
            savedState.mSpanLookup = this.mLazySpanLookup.mData;
            savedState.mSpanLookupSize = savedState.mSpanLookup.length;
            savedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            int lastChildPosition;
            if (this.mLastLayoutFromEnd) {
                lastChildPosition = getLastChildPosition();
            } else {
                lastChildPosition = getFirstChildPosition();
            }
            savedState.mAnchorPosition = lastChildPosition;
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            savedState.mSpanOffsetsSize = this.mSpanCount;
            savedState.mSpanOffsets = new int[this.mSpanCount];
            while (i < this.mSpanCount) {
                if (this.mLastLayoutFromEnd) {
                    lastChildPosition = this.mSpans[i].getEndLine(Integer.MIN_VALUE);
                    if (lastChildPosition != Integer.MIN_VALUE) {
                        lastChildPosition -= this.mPrimaryOrientation.getEndAfterPadding();
                    }
                } else {
                    lastChildPosition = this.mSpans[i].getStartLine(Integer.MIN_VALUE);
                    if (lastChildPosition != Integer.MIN_VALUE) {
                        lastChildPosition -= this.mPrimaryOrientation.getStartAfterPadding();
                    }
                }
                savedState.mSpanOffsets[i] = lastChildPosition;
                i++;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = 0;
        }
        return savedState;
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        recycler = view.getLayoutParams();
        if ((recycler instanceof LayoutParams) == null) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        int i;
        int i2;
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) recycler;
        view = true;
        if (this.mOrientation == null) {
            state = layoutParams.getSpanIndex();
            if (layoutParams.mFullSpan) {
                view = this.mSpanCount;
            }
            i = state;
            i2 = view;
            i3 = -1;
            i4 = i3;
        } else {
            state = layoutParams.getSpanIndex();
            if (layoutParams.mFullSpan) {
                view = this.mSpanCount;
            }
            i3 = state;
            i4 = view;
            i = -1;
            i2 = i;
        }
        accessibilityNodeInfoCompat.setCollectionItemInfo(CollectionItemInfoCompat.obtain(i, i2, i3, i4, layoutParams.mFullSpan, false));
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (findFirstVisibleItemClosestToStart != null) {
                if (findFirstVisibleItemClosestToEnd != null) {
                    int position = getPosition(findFirstVisibleItemClosestToStart);
                    int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                    if (position < position2) {
                        accessibilityEvent.setFromIndex(position);
                        accessibilityEvent.setToIndex(position2);
                        return;
                    }
                    accessibilityEvent.setFromIndex(position2);
                    accessibilityEvent.setToIndex(position);
                }
            }
        }
    }

    int findFirstVisibleItemPositionInt() {
        View findFirstVisibleItemClosestToEnd;
        if (this.mShouldReverseLayout) {
            findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(true);
        } else {
            findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToStart(true);
        }
        if (findFirstVisibleItemClosestToEnd == null) {
            return -1;
        }
        return getPosition(findFirstVisibleItemClosestToEnd);
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        return super.getRowCountForAccessibility(recycler, state);
    }

    public int getColumnCountForAccessibility(Recycler recycler, State state) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        return super.getColumnCountForAccessibility(recycler, state);
    }

    View findFirstVisibleItemClosestToStart(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart < startAfterPadding) {
                    if (z) {
                        if (view == null) {
                            view = childAt;
                        }
                    }
                }
                return childAt;
            }
        }
        return view;
    }

    View findFirstVisibleItemClosestToEnd(boolean z) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd > endAfterPadding) {
                    if (z) {
                        if (view == null) {
                            view = childAt;
                        }
                    }
                }
                return childAt;
            }
        }
        return view;
    }

    private void fixEndGap(Recycler recycler, State state, boolean z) {
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE) {
            int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd;
            if (endAfterPadding > 0) {
                endAfterPadding -= -scrollBy(-endAfterPadding, recycler, state);
                if (z && endAfterPadding > 0) {
                    this.mPrimaryOrientation.offsetChildren(endAfterPadding);
                }
            }
        }
    }

    private void fixStartGap(Recycler recycler, State state, boolean z) {
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE) {
            minStart -= this.mPrimaryOrientation.getStartAfterPadding();
            if (minStart > 0) {
                minStart -= scrollBy(minStart, recycler, state);
                if (z && minStart > 0) {
                    this.mPrimaryOrientation.offsetChildren(-minStart);
                }
            }
        }
    }

    private void updateLayoutState(int i, State state) {
        boolean z = false;
        this.mLayoutState.mAvailable = 0;
        this.mLayoutState.mCurrentPosition = i;
        if (isSmoothScrolling()) {
            state = state.getTargetScrollPosition();
            if (state != -1) {
                if (this.mShouldReverseLayout == (state < i)) {
                    state = this.mPrimaryOrientation.getTotalSpace();
                    i = 0;
                } else {
                    i = this.mPrimaryOrientation.getTotalSpace();
                    state = null;
                }
                if (getClipToPadding()) {
                    this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + state;
                    this.mLayoutState.mStartLine = -i;
                } else {
                    this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i;
                    this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + state;
                }
                this.mLayoutState.mStopInFocusable = false;
                this.mLayoutState.mRecycle = true;
                i = this.mLayoutState;
                if (this.mPrimaryOrientation.getMode() == null && this.mPrimaryOrientation.getEnd() == null) {
                    z = true;
                }
                i.mInfinite = z;
            }
        }
        i = 0;
        state = i;
        if (getClipToPadding()) {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + state;
            this.mLayoutState.mStartLine = -i;
        } else {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + state;
        }
        this.mLayoutState.mStopInFocusable = false;
        this.mLayoutState.mRecycle = true;
        i = this.mLayoutState;
        z = true;
        i.mInfinite = z;
    }

    private void setLayoutStateDirection(int i) {
        this.mLayoutState.mLayoutDirection = i;
        LayoutState layoutState = this.mLayoutState;
        int i2 = 1;
        if (this.mShouldReverseLayout != (i == -1)) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    private void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int lastChildPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 != 8) {
            i4 = i + i2;
        } else if (i < i2) {
            i4 = i2 + 1;
        } else {
            i5 = i + 1;
            i4 = i2;
            this.mLazySpanLookup.invalidateAfter(i4);
            if (i3 != 8) {
                switch (i3) {
                    case 1:
                        this.mLazySpanLookup.offsetForAddition(i, i2);
                        break;
                    case 2:
                        this.mLazySpanLookup.offsetForRemoval(i, i2);
                        break;
                    default:
                        break;
                }
            }
            this.mLazySpanLookup.offsetForRemoval(i, 1);
            this.mLazySpanLookup.offsetForAddition(i2, 1);
            if (i5 <= lastChildPosition) {
                if (i4 <= (this.mShouldReverseLayout == 0 ? getFirstChildPosition() : getLastChildPosition())) {
                    requestLayout();
                }
            }
        }
        i5 = i4;
        i4 = i;
        this.mLazySpanLookup.invalidateAfter(i4);
        if (i3 != 8) {
            switch (i3) {
                case 1:
                    this.mLazySpanLookup.offsetForAddition(i, i2);
                    break;
                case 2:
                    this.mLazySpanLookup.offsetForRemoval(i, i2);
                    break;
                default:
                    break;
            }
        }
        this.mLazySpanLookup.offsetForRemoval(i, 1);
        this.mLazySpanLookup.offsetForAddition(i2, 1);
        if (i5 <= lastChildPosition) {
            if (this.mShouldReverseLayout == 0) {
            }
            if (i4 <= (this.mShouldReverseLayout == 0 ? getFirstChildPosition() : getLastChildPosition())) {
                requestLayout();
            }
        }
    }

    private int fill(Recycler recycler, LayoutState layoutState, State state) {
        int span;
        Recycler recycler2 = recycler;
        LayoutState layoutState2 = layoutState;
        boolean z = false;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        int i = this.mLayoutState.mInfinite ? layoutState2.mLayoutDirection == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : layoutState2.mLayoutDirection == 1 ? layoutState2.mEndLine + layoutState2.mAvailable : layoutState2.mStartLine - layoutState2.mAvailable;
        int i2 = i;
        updateAllRemainingSpans(layoutState2.mLayoutDirection, i2);
        if (r6.mShouldReverseLayout) {
            i = r6.mPrimaryOrientation.getEndAfterPadding();
        } else {
            i = r6.mPrimaryOrientation.getStartAfterPadding();
        }
        int i3 = i;
        boolean z2 = false;
        while (layoutState.hasMore(state) && (r6.mLayoutState.mInfinite || !r6.mRemainingSpans.isEmpty())) {
            Span nextSpan;
            int decoratedMeasurement;
            int i4;
            int i5;
            int decoratedMeasurement2;
            View next = layoutState2.next(recycler2);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            i = layoutParams.getViewLayoutPosition();
            span = r6.mLazySpanLookup.getSpan(i);
            boolean z3 = span == -1 ? true : z;
            if (z3) {
                nextSpan = layoutParams.mFullSpan ? r6.mSpans[z] : getNextSpan(layoutState2);
                r6.mLazySpanLookup.setSpan(i, nextSpan);
            } else {
                nextSpan = r6.mSpans[span];
            }
            Span span2 = nextSpan;
            layoutParams.mSpan = span2;
            if (layoutState2.mLayoutDirection == 1) {
                addView(next);
            } else {
                addView(next, z);
            }
            measureChildWithDecorationsAndMargin(next, layoutParams, z);
            FullSpanItem createFullSpanItemFromEnd;
            if (layoutState2.mLayoutDirection == 1) {
                if (layoutParams.mFullSpan) {
                    span = getMaxEnd(i3);
                } else {
                    span = span2.getEndLine(i3);
                }
                decoratedMeasurement = r6.mPrimaryOrientation.getDecoratedMeasurement(next) + span;
                if (z3 && layoutParams.mFullSpan) {
                    createFullSpanItemFromEnd = createFullSpanItemFromEnd(span);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = i;
                    r6.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                }
                i4 = decoratedMeasurement;
                decoratedMeasurement = span;
            } else {
                if (layoutParams.mFullSpan) {
                    span = getMinStart(i3);
                } else {
                    span = span2.getStartLine(i3);
                }
                decoratedMeasurement = span - r6.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z3 && layoutParams.mFullSpan) {
                    createFullSpanItemFromEnd = createFullSpanItemFromStart(span);
                    createFullSpanItemFromEnd.mGapDir = 1;
                    createFullSpanItemFromEnd.mPosition = i;
                    r6.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                }
                i4 = span;
            }
            if (layoutParams.mFullSpan && layoutState2.mItemDirection == -1) {
                if (!z3) {
                    if (layoutState2.mLayoutDirection == 1) {
                        span = areAllEndsEqual();
                    } else {
                        span = areAllStartsEqual();
                    }
                    if ((span ^ 1) != 0) {
                        FullSpanItem fullSpanItem = r6.mLazySpanLookup.getFullSpanItem(i);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                    }
                }
                r6.mLaidOutInvalidFullSpan = true;
            }
            attachViewToSpans(next, layoutParams, layoutState2);
            if (isLayoutRTL() && r6.mOrientation == 1) {
                if (layoutParams.mFullSpan) {
                    i = r6.mSecondaryOrientation.getEndAfterPadding();
                } else {
                    i = r6.mSecondaryOrientation.getEndAfterPadding() - (((r6.mSpanCount - 1) - span2.mIndex) * r6.mSizePerSpan);
                }
                i5 = i;
                decoratedMeasurement2 = i - r6.mSecondaryOrientation.getDecoratedMeasurement(next);
            } else {
                if (layoutParams.mFullSpan) {
                    i = r6.mSecondaryOrientation.getStartAfterPadding();
                } else {
                    i = (span2.mIndex * r6.mSizePerSpan) + r6.mSecondaryOrientation.getStartAfterPadding();
                }
                decoratedMeasurement2 = i;
                i5 = r6.mSecondaryOrientation.getDecoratedMeasurement(next) + i;
            }
            if (r6.mOrientation == 1) {
                layoutDecoratedWithMargins(next, decoratedMeasurement2, decoratedMeasurement, i5, i4);
            } else {
                layoutDecoratedWithMargins(next, decoratedMeasurement, decoratedMeasurement2, i4, i5);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(r6.mLayoutState.mLayoutDirection, i2);
            } else {
                updateRemainingSpans(span2, r6.mLayoutState.mLayoutDirection, i2);
            }
            recycle(recycler2, r6.mLayoutState);
            if (r6.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                if (layoutParams.mFullSpan) {
                    r6.mRemainingSpans.clear();
                } else {
                    r6.mRemainingSpans.set(span2.mIndex, false);
                }
            }
            z2 = true;
            z = false;
        }
        if (!z2) {
            recycle(recycler2, r6.mLayoutState);
        }
        if (r6.mLayoutState.mLayoutDirection == -1) {
            span = r6.mPrimaryOrientation.getStartAfterPadding() - getMinStart(r6.mPrimaryOrientation.getStartAfterPadding());
        } else {
            span = getMaxEnd(r6.mPrimaryOrientation.getEndAfterPadding()) - r6.mPrimaryOrientation.getEndAfterPadding();
        }
        return span > 0 ? Math.min(layoutState2.mAvailable, span) : 0;
    }

    private FullSpanItem createFullSpanItemFromEnd(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.mGapPerSpan[i2] = i - this.mSpans[i2].getEndLine(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem createFullSpanItemFromStart(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            fullSpanItem.mGapPerSpan[i2] = this.mSpans[i2].getStartLine(i) - i;
        }
        return fullSpanItem;
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (layoutParams.mFullSpan != null) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan != null) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private void recycle(Recycler recycler, LayoutState layoutState) {
        if (layoutState.mRecycle) {
            if (!layoutState.mInfinite) {
                if (layoutState.mAvailable == 0) {
                    if (layoutState.mLayoutDirection == -1) {
                        recycleFromEnd(recycler, layoutState.mEndLine);
                    } else {
                        recycleFromStart(recycler, layoutState.mStartLine);
                    }
                } else if (layoutState.mLayoutDirection == -1) {
                    r0 = layoutState.mStartLine - getMaxStart(layoutState.mStartLine);
                    if (r0 < 0) {
                        layoutState = layoutState.mEndLine;
                    } else {
                        layoutState = layoutState.mEndLine - Math.min(r0, layoutState.mAvailable);
                    }
                    recycleFromEnd(recycler, layoutState);
                } else {
                    r0 = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
                    if (r0 < 0) {
                        layoutState = layoutState.mStartLine;
                    } else {
                        layoutState = Math.min(r0, layoutState.mAvailable) + layoutState.mStartLine;
                    }
                    recycleFromStart(recycler, layoutState);
                }
            }
        }
    }

    private void appendViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].appendToSpan(view);
        }
    }

    private void prependViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].prependToSpan(view);
        }
    }

    private void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    private void updateRemainingSpans(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (span.getStartLine() + deletedSize <= i2) {
                this.mRemainingSpans.set(span.mIndex, false);
            }
            return;
        }
        if (span.getEndLine() - deletedSize >= i2) {
            this.mRemainingSpans.set(span.mIndex, false);
        }
    }

    private int getMaxStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    private int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private void recycleFromStart(Recycler recycler, int i) {
        while (getChildCount() > 0) {
            int i2 = 0;
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i && this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i3 = 0;
                    while (i3 < this.mSpanCount) {
                        if (this.mSpans[i3].mViews.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    while (i2 < this.mSpanCount) {
                        this.mSpans[i2].popStart();
                        i2++;
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void recycleFromEnd(Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i && this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i2 = 0;
                    int i3 = 0;
                    while (i3 < this.mSpanCount) {
                        if (this.mSpans[i3].mViews.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    while (i2 < this.mSpanCount) {
                        this.mSpans[i2].popEnd();
                        i2++;
                    }
                } else if (layoutParams.mSpan.mViews.size() != 1) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.mShouldReverseLayout;
        } else {
            return ((i == -1) == this.mShouldReverseLayout) == isLayoutRTL();
        }
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i = this.mSpanCount - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.mSpanCount;
            i2 = 1;
        }
        Span span = null;
        int startAfterPadding;
        Span span2;
        int endLine;
        if (layoutState.mLayoutDirection == 1) {
            layoutState = Integer.MAX_VALUE;
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            while (i != i3) {
                span2 = this.mSpans[i];
                endLine = span2.getEndLine(startAfterPadding);
                if (endLine < layoutState) {
                    span = span2;
                    layoutState = endLine;
                }
                i += i2;
            }
            return span;
        }
        layoutState = Integer.MIN_VALUE;
        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        while (i != i3) {
            span2 = this.mSpans[i];
            endLine = span2.getStartLine(startAfterPadding);
            if (endLine > layoutState) {
                span = span2;
                layoutState = endLine;
            }
            i += i2;
        }
        return span;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    private int calculateScrollDirectionForPosition(int i) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout != 0 ? 1 : -1;
        } else {
            return (i < getFirstChildPosition()) != this.mShouldReverseLayout ? -1 : 1;
        }
    }

    public PointF computeScrollVectorForPosition(int i) {
        i = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (i == 0) {
            return 0;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) i;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = (float) i;
        }
        return pointF;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        state = new LinearSmoothScroller(recyclerView.getContext());
        state.setTargetPosition(i);
        startSmoothScroll(state);
    }

    public void scrollToPosition(int i) {
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == i)) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        requestLayout();
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, State state, LayoutPrefetchRegistry layoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() != 0) {
            if (i != 0) {
                prepareLayoutStateForDelta(i, state);
                if (this.mPrefetchDistances == 0 || this.mPrefetchDistances.length < this.mSpanCount) {
                    this.mPrefetchDistances = new int[this.mSpanCount];
                }
                i = 0;
                i2 = 0;
                int i3 = i2;
                while (i2 < this.mSpanCount) {
                    int startLine;
                    if (this.mLayoutState.mItemDirection == -1) {
                        startLine = this.mLayoutState.mStartLine - this.mSpans[i2].getStartLine(this.mLayoutState.mStartLine);
                    } else {
                        startLine = this.mSpans[i2].getEndLine(this.mLayoutState.mEndLine) - this.mLayoutState.mEndLine;
                    }
                    if (startLine >= 0) {
                        this.mPrefetchDistances[i3] = startLine;
                        i3++;
                    }
                    i2++;
                }
                Arrays.sort(this.mPrefetchDistances, 0, i3);
                while (i < i3 && this.mLayoutState.hasMore(state) != 0) {
                    layoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i]);
                    i2 = this.mLayoutState;
                    i2.mCurrentPosition += this.mLayoutState.mItemDirection;
                    i++;
                }
            }
        }
    }

    void prepareLayoutStateForDelta(int i, State state) {
        int lastChildPosition;
        int i2;
        if (i > 0) {
            lastChildPosition = getLastChildPosition();
            i2 = 1;
        } else {
            i2 = -1;
            lastChildPosition = getFirstChildPosition();
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(lastChildPosition, state);
        setLayoutStateDirection(i2);
        this.mLayoutState.mCurrentPosition = lastChildPosition + this.mLayoutState.mItemDirection;
        this.mLayoutState.mAvailable = Math.abs(i);
    }

    int scrollBy(int i, Recycler recycler, State state) {
        if (getChildCount() != 0) {
            if (i != 0) {
                prepareLayoutStateForDelta(i, state);
                state = fill(recycler, this.mLayoutState, state);
                if (this.mLayoutState.mAvailable >= state) {
                    i = i < 0 ? -state : state;
                }
                this.mPrimaryOrientation.offsetChildren(-i);
                this.mLastLayoutFromEnd = this.mShouldReverseLayout;
                this.mLayoutState.mAvailable = 0;
                recycle(recycler, this.mLayoutState);
                return i;
            }
        }
        return 0;
    }

    int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int findFirstReferenceChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof MarginLayoutParams) {
            return new LayoutParams((MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public View onFocusSearchFailed(View view, int i, Recycler recycler, State state) {
        if (getChildCount() == 0) {
            return null;
        }
        State findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        i = convertFocusDirectionToLayoutDirection(i);
        if (i == Integer.MIN_VALUE) {
            return null;
        }
        int lastChildPosition;
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.mFullSpan;
        Span span = layoutParams.mSpan;
        if (i == 1) {
            lastChildPosition = getLastChildPosition();
        } else {
            lastChildPosition = getFirstChildPosition();
        }
        updateLayoutState(lastChildPosition, state);
        setLayoutStateDirection(i);
        this.mLayoutState.mCurrentPosition = this.mLayoutState.mItemDirection + lastChildPosition;
        this.mLayoutState.mAvailable = (int) (MAX_SCROLL_FACTOR * ((float) this.mPrimaryOrientation.getTotalSpace()));
        this.mLayoutState.mStopInFocusable = true;
        int i2 = 0;
        this.mLayoutState.mRecycle = false;
        fill(recycler, this.mLayoutState, state);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z) {
            recycler = span.getFocusableViewAfter(lastChildPosition, i);
            if (!(recycler == null || recycler == findContainingItemView)) {
                return recycler;
            }
        }
        if (preferLastSpan(i) != null) {
            for (recycler = this.mSpanCount - 1; recycler >= null; recycler--) {
                state = this.mSpans[recycler].getFocusableViewAfter(lastChildPosition, i);
                if (state != null && state != findContainingItemView) {
                    return state;
                }
            }
        } else {
            for (recycler = null; recycler < this.mSpanCount; recycler++) {
                state = this.mSpans[recycler].getFocusableViewAfter(lastChildPosition, i);
                if (state != null && state != findContainingItemView) {
                    return state;
                }
            }
        }
        recycler = (this.mReverseLayout ^ 1) == (i == -1 ? 1 : null) ? 1 : null;
        if (!z) {
            if (recycler != null) {
                state = span.findFirstPartiallyVisibleItemPosition();
            } else {
                state = span.findLastPartiallyVisibleItemPosition();
            }
            state = findViewByPosition(state);
            if (!(state == null || state == findContainingItemView)) {
                return state;
            }
        }
        if (preferLastSpan(i) != 0) {
            for (i = this.mSpanCount - 1; i >= 0; i--) {
                if (i != span.mIndex) {
                    if (recycler != null) {
                        state = this.mSpans[i].findFirstPartiallyVisibleItemPosition();
                    } else {
                        state = this.mSpans[i].findLastPartiallyVisibleItemPosition();
                    }
                    state = findViewByPosition(state);
                    if (!(state == null || state == findContainingItemView)) {
                        return state;
                    }
                }
            }
        } else {
            while (i2 < this.mSpanCount) {
                if (recycler != null) {
                    i = this.mSpans[i2].findFirstPartiallyVisibleItemPosition();
                } else {
                    i = this.mSpans[i2].findLastPartiallyVisibleItemPosition();
                }
                i = findViewByPosition(i);
                if (i != 0 && i != findContainingItemView) {
                    return i;
                }
                i2++;
            }
        }
        return null;
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
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
}
