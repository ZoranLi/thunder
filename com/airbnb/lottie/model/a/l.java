package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.b.p;
import com.airbnb.lottie.i;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.content.b;
import com.airbnb.lottie.model.k;
import java.util.Collections;
import org.json.JSONObject;

/* compiled from: AnimatableTransform */
public final class l implements b {
    public final e a;
    public final m<PointF, PointF> b;
    public final g c;
    public final b d;
    public final d e;
    @Nullable
    public final b f;
    @Nullable
    public final b g;

    /* compiled from: AnimatableTransform */
    public static class a {
        public static l a(JSONObject jSONObject, i iVar) {
            e eVar;
            m a;
            g gVar;
            b a2;
            d a3;
            JSONObject optJSONObject = jSONObject.optJSONObject("a");
            if (optJSONObject != null) {
                eVar = new e(optJSONObject.opt("k"), iVar);
            } else {
                eVar = new e();
            }
            e eVar2 = eVar;
            optJSONObject = jSONObject.optJSONObject("p");
            if (optJSONObject != null) {
                a = e.a(optJSONObject, iVar);
            } else {
                a("position");
                a = null;
            }
            optJSONObject = jSONObject.optJSONObject("s");
            if (optJSONObject != null) {
                a a4 = n.a(optJSONObject, 1.0f, iVar, com.airbnb.lottie.model.k.a.a).a();
                gVar = new g(a4.a, (k) a4.b);
            } else {
                gVar = new g(Collections.emptyList(), new k());
            }
            optJSONObject = jSONObject.optJSONObject("r");
            if (optJSONObject == null) {
                optJSONObject = jSONObject.optJSONObject("rz");
            }
            if (optJSONObject != null) {
                a2 = com.airbnb.lottie.model.a.b.a.a(optJSONObject, iVar, false);
            } else {
                a("rotation");
                a2 = null;
            }
            optJSONObject = jSONObject.optJSONObject("o");
            if (optJSONObject != null) {
                a3 = com.airbnb.lottie.model.a.d.a.a(optJSONObject, iVar);
            } else {
                a3 = new d(Collections.emptyList(), Integer.valueOf(100));
            }
            d dVar = a3;
            optJSONObject = jSONObject.optJSONObject("so");
            b a5 = optJSONObject != null ? com.airbnb.lottie.model.a.b.a.a(optJSONObject, iVar, false) : null;
            jSONObject = jSONObject.optJSONObject("eo");
            return new l(eVar2, a, gVar, a2, dVar, a5, jSONObject != null ? com.airbnb.lottie.model.a.b.a.a(jSONObject, iVar, false) : null);
        }

        private static void a(String str) {
            StringBuilder stringBuilder = new StringBuilder("Missing transform for ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    @Nullable
    public final com.airbnb.lottie.a.a.b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return null;
    }

    private l(e eVar, m<PointF, PointF> mVar, g gVar, b bVar, d dVar, @Nullable b bVar2, @Nullable b bVar3) {
        this.a = eVar;
        this.b = mVar;
        this.c = gVar;
        this.d = bVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = bVar3;
    }

    public final p a() {
        return new p(this);
    }
}
