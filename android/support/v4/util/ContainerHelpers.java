package android.support.v4.util;

class ContainerHelpers {
    static final int[] EMPTY_INTS = new int[0];
    static final long[] EMPTY_LONGS = new long[0];
    static final Object[] EMPTY_OBJECTS = new Object[0];

    public static int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    ContainerHelpers() {
    }

    public static int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    public static int idealLongArraySize(int i) {
        return idealByteArraySize(i * 8) / 8;
    }

    public static boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
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

    static int binarySearch(long[] jArr, int i, long j) {
        i--;
        int i2 = 0;
        while (i2 <= i) {
            int i3 = (i2 + i) >>> 1;
            long j2 = jArr[i3];
            if (j2 < j) {
                i2 = i3 + 1;
            } else if (j2 <= j) {
                return i3;
            } else {
                i = i3 - 1;
            }
        }
        return i2 ^ -1;
    }
}
