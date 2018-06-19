package android.support.v4.util;

public class LongSparseArray<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            i = ContainerHelpers.idealLongArraySize(i);
            this.mKeys = new long[i];
            this.mValues = new Object[i];
        }
        this.mSize = 0;
    }

    public android.support.v4.util.LongSparseArray<E> clone() {
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
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (android.support.v4.util.LongSparseArray) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.mKeys;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (long[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.mKeys = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r2.mValues;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (java.lang.Object[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.mValues = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LongSparseArray.clone():android.support.v4.util.LongSparseArray<E>");
    }

    public E get(long j) {
        return get(j, null);
    }

    public E get(long j, E e) {
        j = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (j >= null) {
            if (this.mValues[j] != DELETED) {
                return this.mValues[j];
            }
        }
        return e;
    }

    public void delete(long j) {
        j = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (j >= null && this.mValues[j] != DELETED) {
            this.mValues[j] = DELETED;
            this.mGarbage = 1;
        }
    }

    public void remove(long j) {
        delete(j);
    }

    public void removeAt(int i) {
        if (this.mValues[i] != DELETED) {
            this.mValues[i] = DELETED;
            this.mGarbage = true;
        }
    }

    private void gc() {
        int i = this.mSize;
        long[] jArr = this.mKeys;
        Object[] objArr = this.mValues;
        int i2 = 0;
        int i3 = i2;
        while (i2 < i) {
            Object obj = objArr[i2];
            if (obj != DELETED) {
                if (i2 != i3) {
                    jArr[i3] = jArr[i2];
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

    public void put(long j, E e) {
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        binarySearch ^= -1;
        if (binarySearch >= this.mSize || this.mValues[binarySearch] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j) ^ -1;
            }
            if (this.mSize >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(this.mSize + 1);
                Object obj = new long[idealLongArraySize];
                Object obj2 = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            if (this.mSize - binarySearch != 0) {
                int i = binarySearch + 1;
                System.arraycopy(this.mKeys, binarySearch, this.mKeys, i, this.mSize - binarySearch);
                System.arraycopy(this.mValues, binarySearch, this.mValues, i, this.mSize - binarySearch);
            }
            this.mKeys[binarySearch] = j;
            this.mValues[binarySearch] = e;
            this.mSize++;
            return;
        }
        this.mKeys[binarySearch] = j;
        this.mValues[binarySearch] = e;
    }

    public int size() {
        if (this.mGarbage) {
            gc();
        }
        return this.mSize;
    }

    public long keyAt(int i) {
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

    public int indexOfKey(long j) {
        if (this.mGarbage) {
            gc();
        }
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j);
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

    public void append(long j, E e) {
        if (this.mSize == 0 || j > this.mKeys[this.mSize - 1]) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i = this.mSize;
            if (i >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i + 1);
                Object obj = new long[idealLongArraySize];
                Object obj2 = new Object[idealLongArraySize];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            this.mKeys[i] = j;
            this.mValues[i] = e;
            this.mSize = i + 1;
            return;
        }
        put(j, e);
    }

    public String toString() {
        if (size() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(keyAt(i));
            stringBuilder.append('=');
            LongSparseArray valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
