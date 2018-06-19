package android.support.v7.content.res;

import java.lang.reflect.Array;

final class GrowingArrayUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int growSize(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static <T> T[] append(T[] tArr, int i, T t) {
        if (i + 1 > tArr.length) {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i));
            System.arraycopy(tArr, 0, tArr2, 0, i);
            tArr = tArr2;
        }
        tArr[i] = t;
        return tArr;
    }

    public static int[] append(int[] iArr, int i, int i2) {
        if (i + 1 > iArr.length) {
            Object obj = new int[growSize(i)];
            System.arraycopy(iArr, 0, obj, 0, i);
            iArr = obj;
        }
        iArr[i] = i2;
        return iArr;
    }

    public static long[] append(long[] jArr, int i, long j) {
        if (i + 1 > jArr.length) {
            Object obj = new long[growSize(i)];
            System.arraycopy(jArr, 0, obj, 0, i);
            jArr = obj;
        }
        jArr[i] = j;
        return jArr;
    }

    public static boolean[] append(boolean[] zArr, int i, boolean z) {
        if (i + 1 > zArr.length) {
            Object obj = new boolean[growSize(i)];
            System.arraycopy(zArr, 0, obj, 0, i);
            zArr = obj;
        }
        zArr[i] = z;
        return zArr;
    }

    public static <T> T[] insert(T[] tArr, int i, int i2, T t) {
        if (i + 1 <= tArr.length) {
            System.arraycopy(tArr, i2, tArr, i2 + 1, i - i2);
            tArr[i2] = t;
            return tArr;
        }
        Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), growSize(i));
        System.arraycopy(tArr, 0, objArr, 0, i2);
        objArr[i2] = t;
        System.arraycopy(tArr, i2, objArr, i2 + 1, tArr.length - i2);
        return objArr;
    }

    public static int[] insert(int[] iArr, int i, int i2, int i3) {
        if (i + 1 <= iArr.length) {
            System.arraycopy(iArr, i2, iArr, i2 + 1, i - i2);
            iArr[i2] = i3;
            return iArr;
        }
        i = new int[growSize(i)];
        System.arraycopy(iArr, 0, i, 0, i2);
        i[i2] = i3;
        System.arraycopy(iArr, i2, i, i2 + 1, iArr.length - i2);
        return i;
    }

    public static long[] insert(long[] jArr, int i, int i2, long j) {
        if (i + 1 <= jArr.length) {
            System.arraycopy(jArr, i2, jArr, i2 + 1, i - i2);
            jArr[i2] = j;
            return jArr;
        }
        i = new long[growSize(i)];
        System.arraycopy(jArr, 0, i, 0, i2);
        i[i2] = j;
        System.arraycopy(jArr, i2, i, i2 + 1, jArr.length - i2);
        return i;
    }

    public static boolean[] insert(boolean[] zArr, int i, int i2, boolean z) {
        if (i + 1 <= zArr.length) {
            System.arraycopy(zArr, i2, zArr, i2 + 1, i - i2);
            zArr[i2] = z;
            return zArr;
        }
        i = new boolean[growSize(i)];
        System.arraycopy(zArr, 0, i, 0, i2);
        i[i2] = z;
        System.arraycopy(zArr, i2, i, i2 + 1, zArr.length - i2);
        return i;
    }

    private GrowingArrayUtils() {
    }
}
