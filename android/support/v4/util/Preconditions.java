package android.support.v4.util;

import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Locale;

@RestrictTo({Scope.LIBRARY_GROUP})
public class Preconditions {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkArgument(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException();
    }

    @NonNull
    public static <T extends CharSequence> T checkStringNotEmpty(T t, Object obj) {
        if (!TextUtils.isEmpty(t)) {
            return t;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @NonNull
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    @NonNull
    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void checkState(boolean z) {
        checkState(z, null);
    }

    public static int checkFlagsArgument(int i, int i2) {
        if ((i & i2) == i) {
            return i;
        }
        StringBuilder stringBuilder = new StringBuilder("Requested flags 0x");
        stringBuilder.append(Integer.toHexString(i));
        stringBuilder.append(", but only 0x");
        stringBuilder.append(Integer.toHexString(i2));
        stringBuilder.append(" are allowed");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    @IntRange(from = 0)
    public static int checkArgumentNonnegative(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static long checkArgumentNonnegative(long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException();
    }

    public static long checkArgumentNonnegative(long j, String str) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str);
    }

    public static int checkArgumentPositive(int i, String str) {
        if (i > 0) {
            return i;
        }
        throw new IllegalArgumentException(str);
    }

    public static float checkArgumentFinite(float f, String str) {
        StringBuilder stringBuilder;
        if (Float.isNaN(f)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be NaN");
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (!Float.isInfinite(f)) {
            return f;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be infinite");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static float checkArgumentInRange(float f, float f2, float f3, String str) {
        if (Float.isNaN(f)) {
            f2 = new StringBuilder();
            f2.append(str);
            f2.append(" must not be NaN");
            throw new IllegalArgumentException(f2.toString());
        } else if (f < f2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too low)", new Object[]{str, Float.valueOf(f2), Float.valueOf(f3)}));
        } else if (f <= f3) {
            return f;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%f, %f] (too high)", new Object[]{str, Float.valueOf(f2), Float.valueOf(f3)}));
        }
    }

    public static int checkArgumentInRange(int i, int i2, int i3, String str) {
        if (i < i2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)}));
        } else if (i <= i3) {
            return i;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i3)}));
        }
    }

    public static long checkArgumentInRange(long j, long j2, long j3, String str) {
        if (j < j2) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}));
        } else if (j <= j3) {
            return j;
        } else {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", new Object[]{str, Long.valueOf(j2), Long.valueOf(j3)}));
        }
    }

    public static <T> T[] checkArrayElementsNotNull(T[] tArr, String str) {
        if (tArr == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw new NullPointerException(stringBuilder.toString());
        }
        for (T t : tArr) {
            if (t == null) {
                throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[]{str, Integer.valueOf(r1)}));
            }
        }
        return tArr;
    }

    @NonNull
    public static <C extends Collection<T>, T> C checkCollectionElementsNotNull(C c, String str) {
        if (c == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw new NullPointerException(stringBuilder.toString());
        }
        long j = 0;
        for (Object obj : c) {
            if (obj == null) {
                throw new NullPointerException(String.format(Locale.US, "%s[%d] must not be null", new Object[]{str, Long.valueOf(j)}));
            }
            j++;
        }
        return c;
    }

    public static <T> Collection<T> checkCollectionNotEmpty(Collection<T> collection, String str) {
        StringBuilder stringBuilder;
        if (collection == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" must not be null");
            throw new NullPointerException(stringBuilder.toString());
        } else if (!collection.isEmpty()) {
            return collection;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" is empty");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static float[] checkArrayElementsInRange(float[] fArr, float f, float f2, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" must not be null");
        checkNotNull(fArr, stringBuilder.toString());
        int i = 0;
        while (i < fArr.length) {
            float f3 = fArr[i];
            if (Float.isNaN(f3)) {
                f = new StringBuilder();
                f.append(str);
                f.append("[");
                f.append(i);
                f.append("] must not be NaN");
                throw new IllegalArgumentException(f.toString());
            } else if (f3 < f) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too low)", new Object[]{str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}));
            } else if (f3 > f2) {
                throw new IllegalArgumentException(String.format(Locale.US, "%s[%d] is out of range of [%f, %f] (too high)", new Object[]{str, Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}));
            } else {
                i++;
            }
        }
        return fArr;
    }
}
