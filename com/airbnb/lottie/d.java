package com.airbnb.lottie;

import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.os.TraceCompat;

@RestrictTo({Scope.LIBRARY})
/* compiled from: L */
public final class d {
    private static boolean a = false;
    private static String[] b;
    private static long[] c;
    private static int d;
    private static int e;

    public static void a(String str) {
        if (!a) {
            return;
        }
        if (d == 20) {
            e++;
            return;
        }
        b[d] = str;
        c[d] = System.nanoTime();
        TraceCompat.beginSection(str);
        d++;
    }

    public static float b(String str) {
        if (e > 0) {
            e--;
            return 0.0f;
        } else if (!a) {
            return 0.0f;
        } else {
            int i = d - 1;
            d = i;
            if (i == -1) {
                throw new IllegalStateException("Can't end trace section. There are none.");
            } else if (str.equals(b[d])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - c[d])) / 1000000.0f;
            } else {
                StringBuilder stringBuilder = new StringBuilder("Unbalanced trace call ");
                stringBuilder.append(str);
                stringBuilder.append(". Expected ");
                stringBuilder.append(b[d]);
                stringBuilder.append(".");
                throw new IllegalStateException(stringBuilder.toString());
            }
        }
    }
}
