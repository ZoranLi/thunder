package android.support.v7.util;

import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v7.util.ThreadUtil.BackgroundCallback;
import android.support.v7.util.ThreadUtil.MainThreadCallback;
import android.support.v7.util.TileList.Tile;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final BackgroundCallback<T> mBackgroundCallback = new BackgroundCallback<T>() {
        private int mFirstRequiredTileStart;
        private int mGeneration;
        private int mItemCount;
        private int mLastRequiredTileStart;
        final SparseBooleanArray mLoadedTiles = new SparseBooleanArray();
        private Tile<T> mRecycledRoot;

        public void refresh(int i) {
            this.mGeneration = i;
            this.mLoadedTiles.clear();
            this.mItemCount = AsyncListUtil.this.mDataCallback.refreshData();
            AsyncListUtil.this.mMainThreadProxy.updateItemCount(this.mGeneration, this.mItemCount);
        }

        public void updateRange(int i, int i2, int i3, int i4, int i5) {
            if (i <= i2) {
                i = getTileStart(i);
                i2 = getTileStart(i2);
                this.mFirstRequiredTileStart = getTileStart(i3);
                this.mLastRequiredTileStart = getTileStart(i4);
                if (i5 == 1) {
                    requestTiles(this.mFirstRequiredTileStart, i2, i5, true);
                    requestTiles(i2 + AsyncListUtil.this.mTileSize, this.mLastRequiredTileStart, i5, false);
                    return;
                }
                requestTiles(i, this.mLastRequiredTileStart, i5, false);
                requestTiles(this.mFirstRequiredTileStart, i - AsyncListUtil.this.mTileSize, i5, true);
            }
        }

        private int getTileStart(int i) {
            return i - (i % AsyncListUtil.this.mTileSize);
        }

        private void requestTiles(int i, int i2, int i3, boolean z) {
            int i4 = i;
            while (i4 <= i2) {
                AsyncListUtil.this.mBackgroundProxy.loadTile(z ? (i2 + i) - i4 : i4, i3);
                i4 += AsyncListUtil.this.mTileSize;
            }
        }

        public void loadTile(int i, int i2) {
            if (!isTileLoaded(i)) {
                Tile acquireTile = acquireTile();
                acquireTile.mStartPosition = i;
                acquireTile.mItemCount = Math.min(AsyncListUtil.this.mTileSize, this.mItemCount - acquireTile.mStartPosition);
                AsyncListUtil.this.mDataCallback.fillData(acquireTile.mItems, acquireTile.mStartPosition, acquireTile.mItemCount);
                flushTileCache(i2);
                addTile(acquireTile);
            }
        }

        public void recycleTile(Tile<T> tile) {
            AsyncListUtil.this.mDataCallback.recycleData(tile.mItems, tile.mItemCount);
            tile.mNext = this.mRecycledRoot;
            this.mRecycledRoot = tile;
        }

        private Tile<T> acquireTile() {
            if (this.mRecycledRoot == null) {
                return new Tile(AsyncListUtil.this.mTClass, AsyncListUtil.this.mTileSize);
            }
            Tile<T> tile = this.mRecycledRoot;
            this.mRecycledRoot = this.mRecycledRoot.mNext;
            return tile;
        }

        private boolean isTileLoaded(int i) {
            return this.mLoadedTiles.get(i);
        }

        private void addTile(Tile<T> tile) {
            this.mLoadedTiles.put(tile.mStartPosition, true);
            AsyncListUtil.this.mMainThreadProxy.addTile(this.mGeneration, tile);
        }

        private void removeTile(int i) {
            this.mLoadedTiles.delete(i);
            AsyncListUtil.this.mMainThreadProxy.removeTile(this.mGeneration, i);
        }

        private void flushTileCache(int i) {
            int maxCachedTiles = AsyncListUtil.this.mDataCallback.getMaxCachedTiles();
            while (this.mLoadedTiles.size() >= maxCachedTiles) {
                int keyAt = this.mLoadedTiles.keyAt(0);
                int keyAt2 = this.mLoadedTiles.keyAt(this.mLoadedTiles.size() - 1);
                int i2 = this.mFirstRequiredTileStart - keyAt;
                int i3 = keyAt2 - this.mLastRequiredTileStart;
                if (i2 > 0 && (i2 >= i3 || i == 2)) {
                    removeTile(keyAt);
                } else if (i3 > 0 && (i2 < i3 || i == 1)) {
                    removeTile(keyAt2);
                } else {
                    return;
                }
            }
        }

        private void log(String str, Object... objArr) {
            new StringBuilder("[BKGR] ").append(String.format(str, objArr));
        }
    };
    final BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration = 0;
    int mItemCount = 0;
    private final MainThreadCallback<T> mMainThreadCallback = new MainThreadCallback<T>() {
        public void updateItemCount(int i, int i2) {
            if (isRequestedGeneration(i) != 0) {
                AsyncListUtil.this.mItemCount = i2;
                AsyncListUtil.this.mViewCallback.onDataRefresh();
                AsyncListUtil.this.mDisplayedGeneration = AsyncListUtil.this.mRequestedGeneration;
                recycleAllTiles();
                AsyncListUtil.this.mAllowScrollHints = false;
                AsyncListUtil.this.updateRange();
            }
        }

        public void addTile(int i, Tile<T> tile) {
            if (isRequestedGeneration(i) == 0) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(tile);
                return;
            }
            i = AsyncListUtil.this.mTileList.addOrReplace(tile);
            if (i != 0) {
                new StringBuilder("duplicate tile @").append(i.mStartPosition);
                AsyncListUtil.this.mBackgroundProxy.recycleTile(i);
            }
            i = tile.mStartPosition + tile.mItemCount;
            int i2 = 0;
            while (i2 < AsyncListUtil.this.mMissingPositions.size()) {
                int keyAt = AsyncListUtil.this.mMissingPositions.keyAt(i2);
                if (tile.mStartPosition > keyAt || keyAt >= i) {
                    i2++;
                } else {
                    AsyncListUtil.this.mMissingPositions.removeAt(i2);
                    AsyncListUtil.this.mViewCallback.onItemLoaded(keyAt);
                }
            }
        }

        public void removeTile(int i, int i2) {
            if (isRequestedGeneration(i) != 0) {
                i = AsyncListUtil.this.mTileList.removeAtPos(i2);
                if (i != 0) {
                    AsyncListUtil.this.mBackgroundProxy.recycleTile(i);
                }
            }
        }

        private void recycleAllTiles() {
            for (int i = 0; i < AsyncListUtil.this.mTileList.size(); i++) {
                AsyncListUtil.this.mBackgroundProxy.recycleTile(AsyncListUtil.this.mTileList.getAtIndex(i));
            }
            AsyncListUtil.this.mTileList.clear();
        }

        private boolean isRequestedGeneration(int i) {
            return i == AsyncListUtil.this.mRequestedGeneration;
        }
    };
    final MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions = new SparseIntArray();
    final int[] mPrevRange = new int[2];
    int mRequestedGeneration = this.mDisplayedGeneration;
    private int mScrollHint = 0;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange = new int[2];
    final int[] mTmpRangeExtended = new int[2];
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        @WorkerThread
        public abstract void fillData(T[] tArr, int i, int i2);

        @WorkerThread
        public int getMaxCachedTiles() {
            return 10;
        }

        @WorkerThread
        public void recycleData(T[] tArr, int i) {
        }

        @WorkerThread
        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        @UiThread
        public abstract void getItemRangeInto(int[] iArr);

        @UiThread
        public abstract void onDataRefresh();

        @UiThread
        public abstract void onItemLoaded(int i);

        @UiThread
        public void extendRangeInto(int[] iArr, int[] iArr2, int i) {
            int i2 = (iArr[1] - iArr[0]) + 1;
            int i3 = i2 / 2;
            iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
            iArr = iArr[1];
            if (i != 2) {
                i2 = i3;
            }
            iArr2[1] = iArr + i2;
        }
    }

    void log(String str, Object... objArr) {
        new StringBuilder("[MAIN] ").append(String.format(str, objArr));
    }

    public AsyncListUtil(Class<T> cls, int i, DataCallback<T> dataCallback, ViewCallback viewCallback) {
        this.mTClass = cls;
        this.mTileSize = i;
        this.mDataCallback = dataCallback;
        this.mViewCallback = viewCallback;
        this.mTileList = new TileList(this.mTileSize);
        cls = new MessageThreadUtil();
        this.mMainThreadProxy = cls.getMainThreadProxy(this.mMainThreadCallback);
        this.mBackgroundProxy = cls.getBackgroundProxy(this.mBackgroundCallback);
        refresh();
    }

    private boolean isRefreshPending() {
        return this.mRequestedGeneration != this.mDisplayedGeneration;
    }

    public void onRangeChanged() {
        if (!isRefreshPending()) {
            updateRange();
            this.mAllowScrollHints = true;
        }
    }

    public void refresh() {
        this.mMissingPositions.clear();
        BackgroundCallback backgroundCallback = this.mBackgroundProxy;
        int i = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = i;
        backgroundCallback.refresh(i);
    }

    public T getItem(int i) {
        if (i >= 0) {
            if (i < this.mItemCount) {
                T itemAt = this.mTileList.getItemAt(i);
                if (itemAt == null && !isRefreshPending()) {
                    this.mMissingPositions.put(i, 0);
                }
                return itemAt;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append(" is not within 0 and ");
        stringBuilder.append(this.mItemCount);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        if (this.mTmpRange[0] <= this.mTmpRange[1]) {
            if (this.mTmpRange[0] >= 0) {
                if (this.mTmpRange[1] < this.mItemCount) {
                    if (this.mAllowScrollHints) {
                        if (this.mTmpRange[0] <= this.mPrevRange[1]) {
                            if (this.mPrevRange[0] <= this.mTmpRange[1]) {
                                if (this.mTmpRange[0] < this.mPrevRange[0]) {
                                    this.mScrollHint = 1;
                                } else if (this.mTmpRange[0] > this.mPrevRange[0]) {
                                    this.mScrollHint = 2;
                                }
                            }
                        }
                        this.mScrollHint = 0;
                    } else {
                        this.mScrollHint = 0;
                    }
                    this.mPrevRange[0] = this.mTmpRange[0];
                    this.mPrevRange[1] = this.mTmpRange[1];
                    this.mViewCallback.extendRangeInto(this.mTmpRange, this.mTmpRangeExtended, this.mScrollHint);
                    this.mTmpRangeExtended[0] = Math.min(this.mTmpRange[0], Math.max(this.mTmpRangeExtended[0], 0));
                    this.mTmpRangeExtended[1] = Math.max(this.mTmpRange[1], Math.min(this.mTmpRangeExtended[1], this.mItemCount - 1));
                    this.mBackgroundProxy.updateRange(this.mTmpRange[0], this.mTmpRange[1], this.mTmpRangeExtended[0], this.mTmpRangeExtended[1], this.mScrollHint);
                }
            }
        }
    }
}
