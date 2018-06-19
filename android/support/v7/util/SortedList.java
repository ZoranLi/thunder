package android.support.v7.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
    private static final int CAPACITY_GROWTH = 10;
    private static final int DELETION = 2;
    private static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    private static final int LOOKUP = 4;
    private static final int MIN_CAPACITY = 10;
    private BatchedCallback mBatchedCallback;
    private Callback mCallback;
    T[] mData;
    private int mMergedSize;
    private T[] mOldData;
    private int mOldDataSize;
    private int mOldDataStart;
    private int mSize;
    private final Class<T> mTClass;

    public static abstract class Callback<T2> implements ListUpdateCallback, Comparator<T2> {
        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        public abstract int compare(T2 t2, T2 t22);

        public abstract void onChanged(int i, int i2);

        public void onChanged(int i, int i2, Object obj) {
            onChanged(i, i2);
        }
    }

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback mBatchingListUpdateCallback = new BatchingListUpdateCallback(this.mWrappedCallback);
        final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            this.mWrappedCallback = callback;
        }

        public int compare(T2 t2, T2 t22) {
            return this.mWrappedCallback.compare(t2, t22);
        }

        public void onInserted(int i, int i2) {
            this.mBatchingListUpdateCallback.onInserted(i, i2);
        }

        public void onRemoved(int i, int i2) {
            this.mBatchingListUpdateCallback.onRemoved(i, i2);
        }

        public void onMoved(int i, int i2) {
            this.mBatchingListUpdateCallback.onMoved(i, i2);
        }

        public void onChanged(int i, int i2) {
            this.mBatchingListUpdateCallback.onChanged(i, i2, null);
        }

        public boolean areContentsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areContentsTheSame(t2, t22);
        }

        public boolean areItemsTheSame(T2 t2, T2 t22) {
            return this.mWrappedCallback.areItemsTheSame(t2, t22);
        }

        public void dispatchLastEvent() {
            this.mBatchingListUpdateCallback.dispatchLastEvent();
        }
    }

    public SortedList(Class<T> cls, Callback<T> callback) {
        this(cls, callback, 10);
    }

    public SortedList(Class<T> cls, Callback<T> callback, int i) {
        this.mTClass = cls;
        this.mData = (Object[]) Array.newInstance(cls, i);
        this.mCallback = callback;
        this.mSize = null;
    }

    public int size() {
        return this.mSize;
    }

    public int add(T t) {
        throwIfMerging();
        return add(t, true);
    }

    public void addAll(T[] tArr, boolean z) {
        throwIfMerging();
        if (tArr.length != 0) {
            if (z) {
                addAllInternal(tArr);
                return;
            }
            Object[] objArr = (Object[]) Array.newInstance(this.mTClass, tArr.length);
            System.arraycopy(tArr, 0, objArr, 0, tArr.length);
            addAllInternal(objArr);
        }
    }

    public void addAll(T... tArr) {
        addAll(tArr, false);
    }

    public void addAll(Collection<T> collection) {
        addAll(collection.toArray((Object[]) Array.newInstance(this.mTClass, collection.size())), true);
    }

    private void addAllInternal(T[] tArr) {
        int i = !(this.mCallback instanceof BatchedCallback) ? 1 : 0;
        if (i != 0) {
            beginBatchedUpdates();
        }
        this.mOldData = this.mData;
        this.mOldDataStart = 0;
        this.mOldDataSize = this.mSize;
        Arrays.sort(tArr, this.mCallback);
        int deduplicate = deduplicate(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = deduplicate;
            this.mMergedSize = deduplicate;
            this.mCallback.onInserted(0, deduplicate);
        } else {
            merge(tArr, deduplicate);
        }
        this.mOldData = null;
        if (i != 0) {
            endBatchedUpdates();
        }
    }

    private int deduplicate(T[] tArr) {
        if (tArr.length == 0) {
            throw new IllegalArgumentException("Input array must be non-empty");
        }
        int i = 0;
        int i2 = 1;
        int i3 = 1;
        while (i2 < tArr.length) {
            Object obj = tArr[i2];
            int compare = this.mCallback.compare(tArr[i], obj);
            if (compare > 0) {
                throw new IllegalArgumentException("Input must be sorted in ascending order.");
            }
            if (compare == 0) {
                compare = findSameItem(obj, tArr, i, i3);
                if (compare != -1) {
                    tArr[compare] = obj;
                } else {
                    if (i3 != i2) {
                        tArr[i3] = obj;
                    }
                    i3++;
                }
            } else {
                if (i3 != i2) {
                    tArr[i3] = obj;
                }
                int i4 = i3;
                i3++;
                i = i4;
            }
            i2++;
        }
        return i3;
    }

    private int findSameItem(T t, T[] tArr, int i, int i2) {
        while (i < i2) {
            if (this.mCallback.areItemsTheSame(tArr[i], t)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private void merge(T[] tArr, int i) {
        this.mData = (Object[]) Array.newInstance(this.mTClass, (this.mSize + i) + 10);
        int i2 = 0;
        this.mMergedSize = 0;
        while (true) {
            if (this.mOldDataStart >= this.mOldDataSize) {
                if (i2 >= i) {
                    return;
                }
            }
            if (this.mOldDataStart == this.mOldDataSize) {
                i -= i2;
                System.arraycopy(tArr, i2, this.mData, this.mMergedSize, i);
                this.mMergedSize += i;
                this.mSize += i;
                this.mCallback.onInserted(this.mMergedSize - i, i);
                return;
            } else if (i2 == i) {
                tArr = this.mOldDataSize - this.mOldDataStart;
                System.arraycopy(this.mOldData, this.mOldDataStart, this.mData, this.mMergedSize, tArr);
                this.mMergedSize += tArr;
                return;
            } else {
                Object obj = this.mOldData[this.mOldDataStart];
                Object obj2 = tArr[i2];
                int compare = this.mCallback.compare(obj, obj2);
                if (compare > 0) {
                    Object[] objArr = this.mData;
                    compare = this.mMergedSize;
                    this.mMergedSize = compare + 1;
                    objArr[compare] = obj2;
                    this.mSize++;
                    i2++;
                    this.mCallback.onInserted(this.mMergedSize - 1, 1);
                } else if (compare == 0 && this.mCallback.areItemsTheSame(obj, obj2)) {
                    Object[] objArr2 = this.mData;
                    int i3 = this.mMergedSize;
                    this.mMergedSize = i3 + 1;
                    objArr2[i3] = obj2;
                    i2++;
                    this.mOldDataStart++;
                    if (!this.mCallback.areContentsTheSame(obj, obj2)) {
                        this.mCallback.onChanged(this.mMergedSize - 1, 1);
                    }
                } else {
                    Object[] objArr3 = this.mData;
                    compare = this.mMergedSize;
                    this.mMergedSize = compare + 1;
                    objArr3[compare] = obj;
                    this.mOldDataStart++;
                }
            }
        }
    }

    private void throwIfMerging() {
        if (this.mOldData != null) {
            throw new IllegalStateException("Cannot call this method from within addAll");
        }
    }

    public void beginBatchedUpdates() {
        throwIfMerging();
        if (!(this.mCallback instanceof BatchedCallback)) {
            if (this.mBatchedCallback == null) {
                this.mBatchedCallback = new BatchedCallback(this.mCallback);
            }
            this.mCallback = this.mBatchedCallback;
        }
    }

    public void endBatchedUpdates() {
        throwIfMerging();
        if (this.mCallback instanceof BatchedCallback) {
            ((BatchedCallback) this.mCallback).dispatchLastEvent();
        }
        if (this.mCallback == this.mBatchedCallback) {
            this.mCallback = this.mBatchedCallback.mWrappedCallback;
        }
    }

    private int add(T t, boolean z) {
        int findIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 1);
        if (findIndexOf == -1) {
            findIndexOf = 0;
        } else if (findIndexOf < this.mSize) {
            Object obj = this.mData[findIndexOf];
            if (this.mCallback.areItemsTheSame(obj, t)) {
                if (this.mCallback.areContentsTheSame(obj, t)) {
                    this.mData[findIndexOf] = t;
                    return findIndexOf;
                }
                this.mData[findIndexOf] = t;
                this.mCallback.onChanged(findIndexOf, 1);
                return findIndexOf;
            }
        }
        addToData(findIndexOf, t);
        if (z) {
            this.mCallback.onInserted(findIndexOf, 1);
        }
        return findIndexOf;
    }

    public boolean remove(T t) {
        throwIfMerging();
        return remove(t, true);
    }

    public T removeItemAt(int i) {
        throwIfMerging();
        T t = get(i);
        removeItemAtIndex(i, true);
        return t;
    }

    private boolean remove(T t, boolean z) {
        t = findIndexOf(t, this.mData, 0, this.mSize, 2);
        if (t == -1) {
            return null;
        }
        removeItemAtIndex(t, z);
        return true;
    }

    private void removeItemAtIndex(int i, boolean z) {
        System.arraycopy(this.mData, i + 1, this.mData, i, (this.mSize - i) - 1);
        this.mSize--;
        this.mData[this.mSize] = null;
        if (z) {
            this.mCallback.onRemoved(i, 1);
        }
    }

    public void updateItemAt(int i, T t) {
        boolean z;
        throwIfMerging();
        T t2 = get(i);
        if (t2 != t) {
            if (this.mCallback.areContentsTheSame(t2, t)) {
                z = false;
                if (t2 == t && this.mCallback.compare(t2, t) == 0) {
                    this.mData[i] = t;
                    if (z) {
                        this.mCallback.onChanged(i, 1);
                    }
                    return;
                }
                if (z) {
                    this.mCallback.onChanged(i, 1);
                }
                removeItemAtIndex(i, false);
                t = add(t, false);
                if (i != t) {
                    this.mCallback.onMoved(i, t);
                }
            }
        }
        z = true;
        if (t2 == t) {
        }
        if (z) {
            this.mCallback.onChanged(i, 1);
        }
        removeItemAtIndex(i, false);
        t = add(t, false);
        if (i != t) {
            this.mCallback.onMoved(i, t);
        }
    }

    public void recalculatePositionOfItemAt(int i) {
        throwIfMerging();
        Object obj = get(i);
        removeItemAtIndex(i, false);
        int add = add(obj, false);
        if (i != add) {
            this.mCallback.onMoved(i, add);
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        if (i < this.mSize) {
            if (i >= 0) {
                if (this.mOldData == null || i < this.mMergedSize) {
                    return this.mData[i];
                }
                return this.mOldData[(i - this.mMergedSize) + this.mOldDataStart];
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Asked to get item at ");
        stringBuilder.append(i);
        stringBuilder.append(" but size is ");
        stringBuilder.append(this.mSize);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public int indexOf(T t) {
        if (this.mOldData != null) {
            int findIndexOf = findIndexOf(t, this.mData, 0, this.mMergedSize, 4);
            if (findIndexOf != -1) {
                return findIndexOf;
            }
            t = findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
            if (t != -1) {
                return (t - this.mOldDataStart) + this.mMergedSize;
            }
            return -1;
        }
        return findIndexOf(t, this.mData, 0, this.mSize, 4);
    }

    private int findIndexOf(T t, T[] tArr, int i, int i2, int i3) {
        while (i < i2) {
            int i4 = (i + i2) / 2;
            Object obj = tArr[i4];
            int compare = this.mCallback.compare(obj, t);
            if (compare < 0) {
                i = i4 + 1;
            } else if (compare != 0) {
                i2 = i4;
            } else if (this.mCallback.areItemsTheSame(obj, t) != null) {
                return i4;
            } else {
                t = linearEqualitySearch(t, i4, i, i2);
                return (i3 == 1 && t == -1) ? i4 : t;
            }
        }
        if (i3 == 1) {
            return i;
        }
        return -1;
    }

    private int linearEqualitySearch(T t, int i, int i2, int i3) {
        int i4 = i - 1;
        while (i4 >= i2) {
            Object obj = this.mData[i4];
            if (this.mCallback.compare(obj, t) != 0) {
                break;
            } else if (this.mCallback.areItemsTheSame(obj, t)) {
                return i4;
            } else {
                i4--;
            }
        }
        do {
            i++;
            if (i < i3) {
                i2 = this.mData[i];
                if (this.mCallback.compare(i2, t) == 0) {
                }
            }
            return -1;
        } while (this.mCallback.areItemsTheSame(i2, t) == 0);
        return i;
    }

    private void addToData(int i, T t) {
        if (i > this.mSize) {
            StringBuilder stringBuilder = new StringBuilder("cannot add item to ");
            stringBuilder.append(i);
            stringBuilder.append(" because size is ");
            stringBuilder.append(this.mSize);
            throw new IndexOutOfBoundsException(stringBuilder.toString());
        }
        if (this.mSize == this.mData.length) {
            Object[] objArr = (Object[]) Array.newInstance(this.mTClass, this.mData.length + 10);
            System.arraycopy(this.mData, 0, objArr, 0, i);
            objArr[i] = t;
            System.arraycopy(this.mData, i, objArr, i + 1, this.mSize - i);
            this.mData = objArr;
        } else {
            System.arraycopy(this.mData, i, this.mData, i + 1, this.mSize - i);
            this.mData[i] = t;
        }
        this.mSize++;
    }

    public void clear() {
        throwIfMerging();
        if (this.mSize != 0) {
            int i = this.mSize;
            Arrays.fill(this.mData, 0, i, null);
            this.mSize = 0;
            this.mCallback.onRemoved(0, i);
        }
    }
}
