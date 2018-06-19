package android.support.design.widget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap();
    private final Pool<ArrayList<T>> mListPool = new SimplePool(10);
    private final ArrayList<T> mSortResult = new ArrayList();
    private final HashSet<T> mSortTmpMarked = new HashSet();

    DirectedAcyclicGraph() {
    }

    final void addNode(@NonNull T t) {
        if (!this.mGraph.containsKey(t)) {
            this.mGraph.put(t, null);
        }
    }

    final boolean contains(@NonNull T t) {
        return this.mGraph.containsKey(t);
    }

    final void addEdge(@NonNull T t, @NonNull T t2) {
        if (this.mGraph.containsKey(t)) {
            if (this.mGraph.containsKey(t2)) {
                ArrayList arrayList = (ArrayList) this.mGraph.get(t);
                if (arrayList == null) {
                    arrayList = getEmptyList();
                    this.mGraph.put(t, arrayList);
                }
                arrayList.add(t2);
                return;
            }
        }
        throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
    }

    @Nullable
    final List getIncomingEdges(@NonNull T t) {
        return (List) this.mGraph.get(t);
    }

    @Nullable
    final List<T> getOutgoingEdges(@NonNull T t) {
        int size = this.mGraph.size();
        List<T> list = null;
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(this.mGraph.keyAt(i));
            }
        }
        return list;
    }

    final boolean hasOutgoingEdges(@NonNull T t) {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList != null && arrayList.contains(t)) {
                return true;
            }
        }
        return false;
    }

    final void clear() {
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            ArrayList arrayList = (ArrayList) this.mGraph.valueAt(i);
            if (arrayList != null) {
                poolList(arrayList);
            }
        }
        this.mGraph.clear();
    }

    @NonNull
    final ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i = 0; i < size; i++) {
            dfs(this.mGraph.keyAt(i), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    private void dfs(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t)) {
            if (hashSet.contains(t)) {
                throw new RuntimeException("This graph contains cyclic dependencies");
            }
            hashSet.add(t);
            ArrayList arrayList2 = (ArrayList) this.mGraph.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    dfs(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
        }
    }

    final int size() {
        return this.mGraph.size();
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> arrayList = (ArrayList) this.mListPool.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }
}
