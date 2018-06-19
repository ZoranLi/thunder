package org.android.spdy;

public class NetSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    public NetSparseArray() {
        this(10);
    }

    public NetSparseArray(int i) {
        this.mGarbage = false;
        this.mKeys = new int[i];
        this.mValues = new Object[i];
        this.mSize = 0;
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        i = binarySearch(this.mKeys, 0, this.mSize, i);
        if (i >= 0) {
            if (this.mValues[i] != DELETED) {
                return this.mValues[i];
            }
        }
        return e;
    }

    public void delete(int i) {
        i = binarySearch(this.mKeys, 0, this.mSize, i);
        if (i >= 0 && this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    public void remove(int i) {
        delete(i);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        int[] iArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj = objArr[i2];
            if (obj != DELETED) {
                if (i2 != i3) {
                    iArr[i3] = iArr[i2];
                    objArr[i3] = obj;
                    objArr[i2] = null;
                }
                i3++;
            }
            i2++;
        }
        this.mGarbage = false;
        this.mSize = i3;
    }

    public void put(int i, E e) {
        int binarySearch = binarySearch(this.mKeys, 0, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        binarySearch ^= -1;
        if (binarySearch >= this.mSize || this.mValues[binarySearch] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                binarySearch = binarySearch(this.mKeys, 0, this.mSize, i) ^ -1;
            }
            if (this.mSize >= this.mKeys.length) {
                int i2 = this.mSize + 20;
                Object obj = new int[i2];
                Object obj2 = new Object[i2];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            if (this.mSize - binarySearch != 0) {
                int i3 = binarySearch + 1;
                System.arraycopy(this.mKeys, binarySearch, this.mKeys, i3, this.mSize - binarySearch);
                System.arraycopy(this.mValues, binarySearch, this.mValues, i3, this.mSize - binarySearch);
            }
            this.mKeys[binarySearch] = i;
            this.mValues[binarySearch] = e;
            this.mSize++;
            return;
        }
        this.mKeys[binarySearch] = i;
        this.mValues[binarySearch] = e;
    }

    public void toArray(E[] eArr) {
        for (int i = 0; i < eArr.length; i++) {
            eArr[i] = this.mValues[i];
        }
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public int keyAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mKeys[i];
    }

    public E valueAt(int i) {
        if (this.mGarbage) {
            gc();
        }
        return this.mValues[i];
    }

    public void setValueAt(int i, E e) {
        if (this.mGarbage) {
            gc();
        }
        this.mValues[i] = e;
    }

    public int indexOfKey(int i) {
        if (this.mGarbage) {
            gc();
        }
        return binarySearch(this.mKeys, 0, this.mSize, i);
    }

    public int indexOfValue(E e) {
        if (this.mGarbage) {
            gc();
        }
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        int i = this.mSize;
        Object[] objArr = this.mValues;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public void append(int i, E e) {
        if (this.mSize == 0 || i > this.mKeys[this.mSize - 1]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i2 = this.mSize;
            if (i2 >= this.mKeys.length) {
                int i3 = i2 + 1;
                Object obj = new int[i3];
                Object obj2 = new Object[i3];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            this.mKeys[i2] = i;
            this.mValues[i2] = e;
            this.mSize = i2 + 1;
            return;
        }
        put(i, e);
    }

    private static int binarySearch(int[] iArr, int i, int i2, int i3) {
        i2 += i;
        int i4 = i - 1;
        i = i2;
        while (i - i4 > 1) {
            int i5 = (i + i4) / 2;
            if (iArr[i5] < i3) {
                i4 = i5;
            } else {
                i = i5;
            }
        }
        if (i == i2) {
            return i2 ^ -1;
        }
        return iArr[i] == i3 ? i : i ^ -1;
    }
}
