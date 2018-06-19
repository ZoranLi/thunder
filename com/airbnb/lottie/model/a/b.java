package com.airbnb.lottie.model.a;

import com.airbnb.lottie.a.b.c;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatableFloatValue */
public final class b extends o<Float, Float> {

    /* compiled from: AnimatableFloatValue */
    public static final class a {
        public static b a() {
            return new b();
        }

        public static b a(JSONObject jSONObject, i iVar, boolean z) {
            if (z) {
                z = iVar.k;
            } else {
                z = true;
            }
            if (jSONObject != null && jSONObject.has("x")) {
                iVar.a("Lottie doesn't support expressions.");
            }
            jSONObject = n.a(jSONObject, z, iVar, b.a).a();
            return new b(jSONObject.a, (Float) jSONObject.b);
        }
    }

    /* compiled from: AnimatableFloatValue */
    private static class b implements com.airbnb.lottie.model.a.m.a<Float> {
        static final b a = new b();

        private b() {
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            return Float.valueOf(com.airbnb.lottie.c.b.a(obj) * f);
        }
    }

    private b() {
        super(Float.valueOf(0.0f));
    }

    private b(List<com.airbnb.lottie.a.a<Float>> list, Float f) {
        super(list, f);
    }

    public final com.airbnb.lottie.a.b.a<Float, Float> a() {
        if (d()) {
            return new c(this.a);
        }
        return new n(this.b);
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return (Float) this.b;
    }
}
