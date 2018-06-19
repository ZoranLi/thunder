package android.support.v7.widget;

import android.support.annotation.Nullable;
import android.support.v4.os.TraceCompat;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = new ThreadLocal();
    static Comparator<Task> sTaskComparator = new Comparator<Task>() {
        public final int compare(Task task, Task task2) {
            if ((task.view == null ? 1 : 0) != (task2.view == null ? 1 : 0)) {
                return task.view == null ? 1 : -1;
            } else {
                if (task.immediate != task2.immediate) {
                    return task.immediate != null ? -1 : 1;
                } else {
                    int i = task2.viewVelocity - task.viewVelocity;
                    if (i != 0) {
                        return i;
                    }
                    task = task.distanceToItem - task2.distanceToItem;
                    if (task != null) {
                        return task;
                    }
                    return 0;
                }
            }
        }
    };
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews = new ArrayList();
    private ArrayList<Task> mTasks = new ArrayList();

    static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    static class LayoutPrefetchRegistryImpl implements LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        LayoutPrefetchRegistryImpl() {
        }

        void setPrefetchVector(int i, int i2) {
            this.mPrefetchDx = i;
            this.mPrefetchDy = i2;
        }

        void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z) {
            this.mCount = 0;
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
            LayoutManager layoutManager = recyclerView.mLayout;
            if (recyclerView.mAdapter != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
                }
                if (this.mCount > layoutManager.mPrefetchMaxCountObserved) {
                    layoutManager.mPrefetchMaxCountObserved = this.mCount;
                    layoutManager.mPrefetchMaxObservedInInitialPrefetch = z;
                    recyclerView.mRecycler.updateViewCacheSize();
                }
            }
        }

        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            } else {
                int i3 = this.mCount * 2;
                if (this.mPrefetchArray == null) {
                    this.mPrefetchArray = new int[4];
                    Arrays.fill(this.mPrefetchArray, -1);
                } else if (i3 >= this.mPrefetchArray.length) {
                    Object obj = this.mPrefetchArray;
                    this.mPrefetchArray = new int[(i3 * 2)];
                    System.arraycopy(obj, 0, this.mPrefetchArray, 0, obj.length);
                }
                this.mPrefetchArray[i3] = i;
                this.mPrefetchArray[i3 + 1] = i2;
                this.mCount++;
            }
        }

        boolean lastPrefetchIncludedPosition(int i) {
            if (this.mPrefetchArray != null) {
                int i2 = this.mCount * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.mPrefetchArray[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void clearPrefetchPositions() {
            if (this.mPrefetchArray != null) {
                Arrays.fill(this.mPrefetchArray, -1);
            }
            this.mCount = 0;
        }
    }

    GapWorker() {
    }

    public final void add(RecyclerView recyclerView) {
        this.mRecyclerViews.add(recyclerView);
    }

    public final void remove(RecyclerView recyclerView) {
        this.mRecyclerViews.remove(recyclerView);
    }

    final void postFromTraversal(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.mPostTimeNs == 0) {
            this.mPostTimeNs = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.setPrefetchVector(i, i2);
    }

    private void buildTaskList() {
        int size = this.mRecyclerViews.size();
        int i = 0;
        int i2 = i;
        while (i < size) {
            RecyclerView recyclerView = (RecyclerView) this.mRecyclerViews.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.collectPrefetchPositionsFromView(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.mCount;
            }
            i++;
        }
        this.mTasks.ensureCapacity(i2);
        i = 0;
        i2 = i;
        while (i < size) {
            recyclerView = (RecyclerView) this.mRecyclerViews.get(i);
            if (recyclerView.getWindowVisibility() == 0) {
                LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
                int abs = Math.abs(layoutPrefetchRegistryImpl.mPrefetchDx) + Math.abs(layoutPrefetchRegistryImpl.mPrefetchDy);
                int i3 = i2;
                for (i2 = 0; i2 < layoutPrefetchRegistryImpl.mCount * 2; i2 += 2) {
                    Task task;
                    if (i3 >= this.mTasks.size()) {
                        task = new Task();
                        this.mTasks.add(task);
                    } else {
                        task = (Task) this.mTasks.get(i3);
                    }
                    int i4 = layoutPrefetchRegistryImpl.mPrefetchArray[i2 + 1];
                    task.immediate = i4 <= abs;
                    task.viewVelocity = abs;
                    task.distanceToItem = i4;
                    task.view = recyclerView;
                    task.position = layoutPrefetchRegistryImpl.mPrefetchArray[i2];
                    i3++;
                }
                i2 = i3;
            }
            i++;
        }
        Collections.sort(this.mTasks, sTaskComparator);
    }

    static boolean isPrefetchPositionAttached(RecyclerView recyclerView, int i) {
        int unfilteredChildCount = recyclerView.mChildHelper.getUnfilteredChildCount();
        for (int i2 = 0; i2 < unfilteredChildCount; i2++) {
            ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.getUnfilteredChildAt(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private ViewHolder prefetchPositionWithDeadline(RecyclerView recyclerView, int i, long j) {
        if (isPrefetchPositionAttached(recyclerView, i)) {
            return null;
        }
        Recycler recycler = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            i = recycler.tryGetViewHolderForPositionByDeadline(i, false, j);
            if (i != 0) {
                if (i.isBound() == null || i.isInvalid() != null) {
                    recycler.addViewHolderToRecycledViewPool(i, false);
                } else {
                    recycler.recycleView(i.itemView);
                }
            }
            recyclerView.onExitLayoutOrScroll(false);
            return i;
        } catch (Throwable th) {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void prefetchInnerRecyclerViewWithDeadline(@Nullable RecyclerView recyclerView, long j) {
        if (recyclerView != null) {
            if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.getUnfilteredChildCount() != 0) {
                recyclerView.removeAndRecycleViews();
            }
            LayoutPrefetchRegistryImpl layoutPrefetchRegistryImpl = recyclerView.mPrefetchRegistry;
            layoutPrefetchRegistryImpl.collectPrefetchPositionsFromView(recyclerView, true);
            if (layoutPrefetchRegistryImpl.mCount != 0) {
                try {
                    TraceCompat.beginSection("RV Nested Prefetch");
                    recyclerView.mState.prepareForNestedPrefetch(recyclerView.mAdapter);
                    for (int i = 0; i < layoutPrefetchRegistryImpl.mCount * 2; i += 2) {
                        prefetchPositionWithDeadline(recyclerView, layoutPrefetchRegistryImpl.mPrefetchArray[i], j);
                    }
                } finally {
                    TraceCompat.endSection();
                }
            }
        }
    }

    private void flushTaskWithDeadline(Task task, long j) {
        task = prefetchPositionWithDeadline(task.view, task.position, task.immediate ? Long.MAX_VALUE : j);
        if (task != null && task.mNestedRecyclerView != null && task.isBound() && !task.isInvalid()) {
            prefetchInnerRecyclerViewWithDeadline((RecyclerView) task.mNestedRecyclerView.get(), j);
        }
    }

    private void flushTasksWithDeadline(long j) {
        int i = 0;
        while (i < this.mTasks.size()) {
            Task task = (Task) this.mTasks.get(i);
            if (task.view != null) {
                flushTaskWithDeadline(task, j);
                task.clear();
                i++;
            } else {
                return;
            }
        }
    }

    final void prefetch(long j) {
        buildTaskList();
        flushTasksWithDeadline(j);
    }

    public final void run() {
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.mRecyclerViews.isEmpty()) {
                int size = this.mRecyclerViews.size();
                long j = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = (RecyclerView) this.mRecyclerViews.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j = Math.max(recyclerView.getDrawingTime(), j);
                    }
                }
                if (j == 0) {
                    this.mPostTimeNs = 0;
                    TraceCompat.endSection();
                    return;
                }
                prefetch(TimeUnit.MILLISECONDS.toNanos(j) + this.mFrameIntervalNs);
                this.mPostTimeNs = 0;
                TraceCompat.endSection();
            }
        } finally {
            this.mPostTimeNs = 0;
            TraceCompat.endSection();
        }
    }
}
