package com.tencent.tinker.android.utils;

/* compiled from: BUGLY */
public class SparseBoolArray implements Cloneable {
    private static final boolean[] EMPTY_BOOL_ARRAY = new boolean[0];
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private int[] mKeys;
    private int mSize;
    private boolean[] mValues;

    /* compiled from: BUGLY */
    public static class KeyNotFoundException extends Exception {
        public KeyNotFoundException(String str) {
            super(str);
        }
    }

    private static int growSize(int i) {
        return i <= 4 ? 8 : i + (i >> 1);
    }

    public SparseBoolArray() {
        this(10);
    }

    public SparseBoolArray(int i) {
        if (i == 0) {
            this.mKeys = EMPTY_INT_ARRAY;
            this.mValues = EMPTY_BOOL_ARRAY;
        } else {
            this.mKeys = new int[i];
            this.mValues = new boolean[i];
        }
        this.mSize = 0;
    }

    public com.tencent.tinker.android.utils.SparseBoolArray clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (com.tencent.tinker.android.utils.SparseBoolArray) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.mKeys;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (int[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.mKeys = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r2.mValues;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (boolean[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.mValues = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.android.utils.SparseBoolArray.clone():com.tencent.tinker.android.utils.SparseBoolArray");
    }

    public boolean get(int i) throws KeyNotFoundException {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            return this.mValues[binarySearch];
        }
        throw new KeyNotFoundException(String.valueOf(i));
    }

    public void delete(int i) {
        i = binarySearch(this.mKeys, this.mSize, i);
        if (i >= 0) {
            removeAt(i);
        }
    }

    public void removeAt(int i) {
        int i2 = i + 1;
        System.arraycopy(this.mKeys, i2, this.mKeys, i, this.mSize - i2);
        System.arraycopy(this.mValues, i2, this.mValues, i, this.mSize - i2);
        this.mSize--;
    }

    public void put(int i, boolean z) {
        int binarySearch = binarySearch(this.mKeys, this.mSize, i);
        if (binarySearch >= 0) {
            this.mValues[binarySearch] = z;
            return;
        }
        binarySearch ^= -1;
        this.mKeys = insertElementIntoIntArray(this.mKeys, this.mSize, binarySearch, i);
        this.mValues = insertElementIntoBoolArray(this.mValues, this.mSize, binarySearch, z);
        this.mSize++;
    }

    public int size() {
        return this.mSize;
    }

    public int keyAt(int i) {
        return this.mKeys[i];
    }

    public boolean valueAt(int i) {
        return this.mValues[i];
    }

    public int indexOfKey(int i) {
        return binarySearch(this.mKeys, this.mSize, i);
    }

    public boolean containsKey(int i) {
        return indexOfKey(i) >= 0;
    }

    public int indexOfValue(boolean z) {
        for (int i = 0; i < this.mSize; i++) {
            if (this.mValues[i] == z) {
                return i;
            }
        }
        return true;
    }

    public void clear() {
        this.mSize = 0;
    }

    public void append(int i, boolean z) {
        if (this.mSize == 0 || i > this.mKeys[this.mSize - 1]) {
            this.mKeys = appendElementIntoIntArray(this.mKeys, this.mSize, i);
            this.mValues = appendElementIntoBoolArray(this.mValues, this.mSize, z);
            this.mSize++;
            return;
        }
        put(i, z);
    }

    private int binarySearch(int[] iArr, int i, int i2) {
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

    private int[] appendElementIntoIntArray(int[] iArr, int i, int i2) {
        if (i > iArr.length) {
            StringBuilder stringBuilder = new StringBuilder("Bad currentSize, originalSize: ");
            stringBuilder.append(iArr.length);
            stringBuilder.append(" currentSize: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (i + 1 > iArr.length) {
            Object obj = new int[growSize(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    private boolean[] appendElementIntoBoolArray(boolean[] zArr, int i, boolean z) {
        if (i > zArr.length) {
            StringBuilder stringBuilder = new StringBuilder("Bad currentSize, originalSize: ");
            stringBuilder.append(zArr.length);
            stringBuilder.append(" currentSize: ");
            stringBuilder.append(i);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (i + 1 > zArr.length) {
            Object obj = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, obj, 0, i);
            zArr = obj;
        }
        zArr[i] = z;
        return zArr;
    }

    private int[] insertElementIntoIntArray(int[] iArr, int i, int i2, int i3) {
        if (i > iArr.length) {
            i3 = new StringBuilder("Bad currentSize, originalSize: ");
            i3.append(iArr.length);
            i3.append(" currentSize: ");
            i3.append(i);
            throw new IllegalArgumentException(i3.toString());
        } else if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        } else {
            i = new int[growSize(i)];
            System.arraycopy(iArr, 0, i, 0, i2);
            i[i2] = i3;
            System.arraycopy(iArr, i2, i, i2 + 1, iArr.length - i2);
            return i;
        }
    }

    private boolean[] insertElementIntoBoolArray(boolean[] zArr, int i, int i2, boolean z) {
        if (i > zArr.length) {
            z = new StringBuilder("Bad currentSize, originalSize: ");
            z.append(zArr.length);
            z.append(" currentSize: ");
            z.append(i);
            throw new IllegalArgumentException(z.toString());
        } else if (i + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
            zArr[i2] = z;
            return zArr;
        } else {
            i = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, i, 0, i2);
            i[i2] = z;
            System.arraycopy(zArr, i2, i, i2 + 1, zArr.length - i2);
            return i;
        }
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
            stringBuilder.append(valueAt(i));
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
