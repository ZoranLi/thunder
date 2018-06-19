package android.support.v7.widget;

import java.util.ArrayList;

class PositionMap<E> implements Cloneable {
    private static final Object DELETED = new Object();
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static class ContainerHelpers {
        static final boolean[] EMPTY_BOOLEANS = new boolean[0];
        static final int[] EMPTY_INTS = new int[0];
        static final long[] EMPTY_LONGS = new long[0];
        static final Object[] EMPTY_OBJECTS = new Object[0];

        ContainerHelpers() {
        }

        static int binarySearch(int[] iArr, int i, int i2) {
            i--;
            int i3 = 0;
            while (i3 <= i) {
                int i4 = (i3 + i) >>> 1;
                int i5 = iArr[i4];
                if (i5 < i2) {
                    i3 = i4 + 1;
                } else if (i5 <= i2) {
                    return i4;
                } else {
                    i = i4 - 1;
                }
            }
            return i3 ^ -1;
        }
    }

    static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public void insertKeyRange(int i, int i2) {
    }

    public void removeKeyRange(ArrayList<E> arrayList, int i, int i2) {
    }

    PositionMap() {
        this(10);
    }

    PositionMap(int i) {
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            i = idealIntArraySize(i);
            this.mKeys = new int[i];
            this.mValues = new Object[i];
        }
        this.mSize = 0;
    }

    public android.support.v7.widget.PositionMap<E> clone() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (android.support.v7.widget.PositionMap) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.mKeys;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (int[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.PositionMap.clone():android.support.v7.widget.PositionMap<E>");
    }

    public E get(int i) {
        return get(i, null);
    }

    public E get(int i, E e) {
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (i >= 0) {
            if (this.mValues[i] != DELETED) {
                return this.mValues[i];
            }
        }
        return e;
    }

    public void delete(int i) {
        i = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
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

    public void removeAtRange(int i, int i2) {
        i2 = Math.min(this.mSize, i2 + i);
        while (i < i2) {
            removeAt(i);
            i++;
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
        int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = e;
            return;
        }
        binarySearch ^= -1;
        if (binarySearch >= this.mSize || this.mValues[binarySearch] != DELETED) {
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i) ^ -1;
            }
            if (this.mSize >= this.mKeys.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new Object[idealIntArraySize];
                System.arraycopy(this.mKeys, 0, obj, 0, this.mKeys.length);
                System.arraycopy(this.mValues, 0, obj2, 0, this.mValues.length);
                this.mKeys = obj;
                this.mValues = obj2;
            }
            if (this.mSize - binarySearch != 0) {
                int i2 = binarySearch + 1;
                System.arraycopy(this.mKeys, binarySearch, this.mKeys, i2, this.mSize - binarySearch);
                System.arraycopy(this.mValues, binarySearch, this.mValues, i2, this.mSize - binarySearch);
            }
            this.mKeys[binarySearch] = i;
            this.mValues[binarySearch] = e;
            this.mSize++;
            return;
        }
        this.mKeys[binarySearch] = i;
        this.mValues[binarySearch] = e;
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
        return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
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
                int idealIntArraySize = idealIntArraySize(i2 + 1);
                Object obj = new int[idealIntArraySize];
                Object obj2 = new Object[idealIntArraySize];
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
            PositionMap valueAt = valueAt(i);
            if (valueAt != this) {
                stringBuilder.append(valueAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    static int idealBooleanArraySize(int i) {
        return idealByteArraySize(i);
    }

    static int idealShortArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    static int idealCharArraySize(int i) {
        return idealByteArraySize(i * 2) / 2;
    }

    static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealFloatArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealObjectArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }
}
