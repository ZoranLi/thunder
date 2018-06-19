package android.support.v4.util;

import java.util.ConcurrentModificationException;

public class SimpleArrayMap<K, V> {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    static Object[] mBaseCache;
    static int mBaseCacheSize;
    static Object[] mTwiceBaseCache;
    static int mTwiceBaseCacheSize;
    Object[] mArray;
    int[] mHashes;
    int mSize;

    private static int binarySearchHashes(int[] r0, int r1, int r2) {
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
        r0 = android.support.v4.util.ContainerHelpers.binarySearch(r0, r1, r2);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = new java.util.ConcurrentModificationException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.binarySearchHashes(int[], int, int):int");
    }

    int indexOf(Object obj, int i) {
        int i2 = this.mSize;
        if (i2 == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i2, i);
        if (binarySearchHashes < 0 || obj.equals(this.mArray[binarySearchHashes << 1])) {
            return binarySearchHashes;
        }
        int i3 = binarySearchHashes + 1;
        while (i3 < i2 && this.mHashes[i3] == i) {
            if (obj.equals(this.mArray[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        binarySearchHashes--;
        while (binarySearchHashes >= 0 && this.mHashes[binarySearchHashes] == i) {
            if (obj.equals(this.mArray[binarySearchHashes << 1])) {
                return binarySearchHashes;
            }
            binarySearchHashes--;
        }
        return i3 ^ -1;
    }

    int indexOfNull() {
        int i = this.mSize;
        if (i == 0) {
            return -1;
        }
        int binarySearchHashes = binarySearchHashes(this.mHashes, i, 0);
        if (binarySearchHashes < 0 || this.mArray[binarySearchHashes << 1] == null) {
            return binarySearchHashes;
        }
        int i2 = binarySearchHashes + 1;
        while (i2 < i && this.mHashes[i2] == 0) {
            if (this.mArray[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        binarySearchHashes--;
        while (binarySearchHashes >= 0 && this.mHashes[binarySearchHashes] == 0) {
            if (this.mArray[binarySearchHashes << 1] == null) {
                return binarySearchHashes;
            }
            binarySearchHashes--;
        }
        return i2 ^ -1;
    }

    private void allocArrays(int i) {
        if (i == 8) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCache != null) {
                    i = mTwiceBaseCache;
                    this.mArray = i;
                    mTwiceBaseCache = (Object[]) i[0];
                    this.mHashes = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    mTwiceBaseCacheSize--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (ArrayMap.class) {
                if (mBaseCache != null) {
                    i = mBaseCache;
                    this.mArray = i;
                    mBaseCache = (Object[]) i[0];
                    this.mHashes = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    mBaseCacheSize--;
                    return;
                }
            }
        }
        this.mHashes = new int[i];
        this.mArray = new Object[(i << 1)];
    }

    private static void freeArrays(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (ArrayMap.class) {
                if (mTwiceBaseCacheSize < 10) {
                    objArr[0] = mTwiceBaseCache;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    mTwiceBaseCache = objArr;
                    mTwiceBaseCacheSize += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (ArrayMap.class) {
                if (mBaseCacheSize < 10) {
                    objArr[0] = mBaseCache;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    mBaseCache = objArr;
                    mBaseCacheSize += 1;
                }
            }
        }
    }

    public SimpleArrayMap() {
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public SimpleArrayMap(int i) {
        if (i == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            putAll(simpleArrayMap);
        }
    }

    public void clear() {
        if (this.mSize > 0) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            int i = this.mSize;
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mSize = 0;
            freeArrays(iArr, objArr, i);
        }
        if (this.mSize > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void ensureCapacity(int i) {
        int i2 = this.mSize;
        if (this.mHashes.length < i) {
            Object obj = this.mHashes;
            Object obj2 = this.mArray;
            allocArrays(i);
            if (this.mSize > 0) {
                System.arraycopy(obj, 0, this.mHashes, 0, i2);
                System.arraycopy(obj2, 0, this.mArray, 0, i2 << 1);
            }
            freeArrays(obj, obj2, i2);
        }
        if (this.mSize != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return indexOfKey(obj) >= null ? true : null;
    }

    public int indexOfKey(Object obj) {
        return obj == null ? indexOfNull() : indexOf(obj, obj.hashCode());
    }

    int indexOfValue(Object obj) {
        int i = this.mSize * 2;
        Object[] objArr = this.mArray;
        if (obj == null) {
            for (obj = 1; obj < i; obj += 2) {
                if (objArr[obj] == null) {
                    return obj >> 1;
                }
            }
        } else {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (obj.equals(objArr[i2])) {
                    return i2 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return indexOfValue(obj) >= null ? true : null;
    }

    public V get(Object obj) {
        obj = indexOfKey(obj);
        return obj >= null ? this.mArray[(obj << 1) + 1] : null;
    }

    public K keyAt(int i) {
        return this.mArray[i << 1];
    }

    public V valueAt(int i) {
        return this.mArray[(i << 1) + 1];
    }

    public V setValueAt(int i, V v) {
        i = (i << 1) + 1;
        V v2 = this.mArray[i];
        this.mArray[i] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.mSize <= 0;
    }

    public V put(K k, V v) {
        int indexOfNull;
        int i;
        int i2 = this.mSize;
        if (k == null) {
            indexOfNull = indexOfNull();
            i = 0;
        } else {
            indexOfNull = k.hashCode();
            i = indexOfNull;
            indexOfNull = indexOf(k, indexOfNull);
        }
        if (indexOfNull >= 0) {
            k = (indexOfNull << 1) + 1;
            V v2 = this.mArray[k];
            this.mArray[k] = v;
            return v2;
        }
        indexOfNull ^= -1;
        if (i2 >= this.mHashes.length) {
            int i3 = 4;
            if (i2 >= 8) {
                i3 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i3 = 8;
            }
            Object obj = this.mHashes;
            Object obj2 = this.mArray;
            allocArrays(i3);
            if (i2 != this.mSize) {
                throw new ConcurrentModificationException();
            }
            if (this.mHashes.length > 0) {
                System.arraycopy(obj, 0, this.mHashes, 0, obj.length);
                System.arraycopy(obj2, 0, this.mArray, 0, obj2.length);
            }
            freeArrays(obj, obj2, i2);
        }
        if (indexOfNull < i2) {
            int i4 = indexOfNull + 1;
            System.arraycopy(this.mHashes, indexOfNull, this.mHashes, i4, i2 - indexOfNull);
            System.arraycopy(this.mArray, indexOfNull << 1, this.mArray, i4 << 1, (this.mSize - indexOfNull) << 1);
        }
        if (i2 == this.mSize) {
            if (indexOfNull < this.mHashes.length) {
                this.mHashes[indexOfNull] = i;
                int i5 = indexOfNull << 1;
                this.mArray[i5] = k;
                this.mArray[i5 + 1] = v;
                this.mSize++;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i = simpleArrayMap.mSize;
        ensureCapacity(this.mSize + i);
        int i2 = 0;
        if (this.mSize != 0) {
            while (i2 < i) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
                i2++;
            }
        } else if (i > 0) {
            System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i);
            System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
            this.mSize = i;
        }
    }

    public V remove(Object obj) {
        obj = indexOfKey(obj);
        return obj >= null ? removeAt(obj) : null;
    }

    public V removeAt(int i) {
        int i2 = i << 1;
        V v = this.mArray[i2 + 1];
        int i3 = this.mSize;
        int i4 = 0;
        if (i3 <= 1) {
            freeArrays(this.mHashes, this.mArray, i3);
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            int i5 = i3 - 1;
            int i6 = 8;
            if (this.mHashes.length <= 8 || this.mSize >= this.mHashes.length / 3) {
                if (i < i5) {
                    int i7 = i + 1;
                    int i8 = i5 - i;
                    System.arraycopy(this.mHashes, i7, this.mHashes, i, i8);
                    System.arraycopy(this.mArray, i7 << 1, this.mArray, i2, i8 << 1);
                }
                i2 = i5 << 1;
                this.mArray[i2] = null;
                this.mArray[i2 + 1] = null;
            } else {
                if (i3 > 8) {
                    i6 = i3 + (i3 >> 1);
                }
                Object obj = this.mHashes;
                Object obj2 = this.mArray;
                allocArrays(i6);
                if (i3 != this.mSize) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(obj, 0, this.mHashes, 0, i);
                    System.arraycopy(obj2, 0, this.mArray, 0, i2);
                }
                if (i < i5) {
                    i4 = i + 1;
                    int i9 = i5 - i;
                    System.arraycopy(obj, i4, this.mHashes, i, i9);
                    System.arraycopy(obj2, i4 << 1, this.mArray, i2, i9 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.mSize) {
            throw new ConcurrentModificationException();
        }
        this.mSize = i4;
        return v;
    }

    public int size() {
        return this.mSize;
    }

    public boolean equals(java.lang.Object r7) {
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
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7 instanceof android.support.v4.util.SimpleArrayMap;
        r2 = 0;
        if (r1 == 0) goto L_0x003f;
    L_0x0009:
        r7 = (android.support.v4.util.SimpleArrayMap) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r6.mSize;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r1 >= r3) goto L_0x003c;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x001b:
        r3 = r6.keyAt(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r4 = r6.valueAt(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0029:
        if (r5 != 0) goto L_0x0031;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x002b:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0031:
        return r2;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0032:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x003c:
        return r0;
    L_0x003d:
        return r2;
    L_0x003e:
        return r2;
    L_0x003f:
        r1 = r7 instanceof java.util.Map;
        if (r1 == 0) goto L_0x0079;
    L_0x0043:
        r7 = (java.util.Map) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0050;
    L_0x004f:
        return r2;
    L_0x0050:
        r1 = r2;
    L_0x0051:
        r3 = r6.mSize;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r1 >= r3) goto L_0x0076;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0055:
        r3 = r6.keyAt(r1);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        r4 = r6.valueAt(r1);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r4 != 0) goto L_0x006c;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0063:
        if (r5 != 0) goto L_0x006b;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x0065:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r3 != 0) goto L_0x0073;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x006b:
        return r2;	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
    L_0x006c:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x0078, ClassCastException -> 0x0077 }
        if (r3 != 0) goto L_0x0073;
    L_0x0072:
        return r2;
    L_0x0073:
        r1 = r1 + 1;
        goto L_0x0051;
    L_0x0076:
        return r0;
    L_0x0077:
        return r2;
    L_0x0078:
        return r2;
    L_0x0079:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.SimpleArrayMap.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int[] iArr = this.mHashes;
        Object[] objArr = this.mArray;
        int i = this.mSize;
        int i2 = 1;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.mSize * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.mSize; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            SimpleArrayMap keyAt = keyAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            keyAt = valueAt(i);
            if (keyAt != this) {
                stringBuilder.append(keyAt);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
