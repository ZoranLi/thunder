package com.airbnb.lottie.model.a;

import com.airbnb.lottie.a.b.e;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatableIntegerValue */
public final class d extends o<Integer, Integer> {

    /* compiled from: AnimatableIntegerValue */
    public static final class a {
        public static d a(JSONObject jSONObject, i iVar) {
            if (jSONObject != null && jSONObject.has("x")) {
                iVar.a("Lottie doesn't support expressions.");
            }
            jSONObject = n.a(jSONObject, 1.0f, iVar, b.a).a();
            return new d(jSONObject.a, (Integer) jSONObject.b);
        }
    }

    /* compiled from: AnimatableIntegerValue */
    private static class b implements com.airbnb.lottie.model.a.m.a<Integer> {
        private static final b a = new b();

        private b() {
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            return Integer.valueOf(Math.round(com.airbnb.lottie.c.b.a(obj) * f));
        }
    }

    private d() {
        super(Integer.valueOf(100));
    }

    d(List<com.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    public final com.airbnb.lottie.a.b.a<Integer, Integer> a() {
        if (d()) {
            return new e(this.a);
        }
        return new n(this.b);
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return (Integer) this.b;
    }
}
