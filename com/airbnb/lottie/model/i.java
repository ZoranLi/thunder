package com.airbnb.lottie.model;

import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import com.alipay.sdk.util.h;

/* compiled from: MutablePair */
public final class i<T> {
    @Nullable
    public T a;
    @Nullable
    public T b;

    public final boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!a(pair.first, this.a) || a(pair.second, this.b) == null) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.a == null ? 0 : this.a.hashCode();
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("Pair{");
        stringBuilder.append(String.valueOf(this.a));
        stringBuilder.append(" ");
        stringBuilder.append(String.valueOf(this.b));
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }
}
