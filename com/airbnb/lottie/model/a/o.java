package com.airbnb.lottie.model.a;

import com.airbnb.lottie.a.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: BaseAnimatableValue */
public abstract class o<V, O> implements m<V, O> {
    final List<a<V>> a;
    public final V b;

    O a(V v) {
        return v;
    }

    o(V v) {
        this(Collections.emptyList(), v);
    }

    o(List<a<V>> list, V v) {
        this.a = list;
        this.b = v;
    }

    public final boolean d() {
        return !this.a.isEmpty();
    }

    public O b() {
        return a(this.b);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("parseInitialValue=");
        stringBuilder.append(this.b);
        if (!this.a.isEmpty()) {
            stringBuilder.append(", values=");
            stringBuilder.append(Arrays.toString(this.a.toArray()));
        }
        return stringBuilder.toString();
    }
}
