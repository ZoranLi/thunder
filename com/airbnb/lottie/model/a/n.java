package com.airbnb.lottie.model.a;

import android.support.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.airbnb.lottie.i;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnimatableValueParser */
public final class n<T> {
    @Nullable
    private final JSONObject a;
    private final float b;
    private final i c;
    private final com.airbnb.lottie.model.a.m.a<T> d;

    /* compiled from: AnimatableValueParser */
    static class a<T> {
        public final List<com.airbnb.lottie.a.a<T>> a;
        @Nullable
        public final T b;

        a(List<com.airbnb.lottie.a.a<T>> list, @Nullable T t) {
            this.a = list;
            this.b = t;
        }
    }

    private n(@Nullable JSONObject jSONObject, float f, i iVar, com.airbnb.lottie.model.a.m.a<T> aVar) {
        this.a = jSONObject;
        this.b = f;
        this.c = iVar;
        this.d = aVar;
    }

    public static <T> n<T> a(@Nullable JSONObject jSONObject, float f, i iVar, com.airbnb.lottie.model.a.m.a<T> aVar) {
        return new n(jSONObject, f, iVar, aVar);
    }

    public final a<T> a() {
        List a;
        if (this.a != null) {
            int i;
            Object opt = this.a.opt("k");
            if (opt instanceof JSONArray) {
                Object opt2 = ((JSONArray) opt).opt(0);
                if ((opt2 instanceof JSONObject) && ((JSONObject) opt2).has(DispatchConstants.TIMESTAMP)) {
                    i = 1;
                    if (i == 0) {
                        a = com.airbnb.lottie.a.a.a.a((JSONArray) opt, this.c, this.b, this.d);
                    } else {
                        a = Collections.emptyList();
                    }
                }
            }
            i = 0;
            if (i == 0) {
                a = Collections.emptyList();
            } else {
                a = com.airbnb.lottie.a.a.a.a((JSONArray) opt, this.c, this.b, this.d);
            }
        } else {
            a = Collections.emptyList();
        }
        Object a2 = this.a != null ? !a.isEmpty() ? ((com.airbnb.lottie.a.a) a.get(0)).a : this.d.a(this.a.opt("k"), this.b) : null;
        return new a(a, a2);
    }
}
