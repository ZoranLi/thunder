package com.airbnb.lottie.model.a;

import android.graphics.Path;
import com.airbnb.lottie.a.b.l;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatableShapeValue */
public final class h extends o<com.airbnb.lottie.model.content.h, Path> {
    private final Path c;

    /* compiled from: AnimatableShapeValue */
    public static final class a {
        public static h a(JSONObject jSONObject, i iVar) {
            jSONObject = n.a(jSONObject, iVar.k, iVar, com.airbnb.lottie.model.content.h.a.a).a();
            return new h(jSONObject.a, (com.airbnb.lottie.model.content.h) jSONObject.b);
        }
    }

    private h(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.h>> list, com.airbnb.lottie.model.content.h hVar) {
        super(list, hVar);
        this.c = new Path();
    }

    public final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.h, Path> a() {
        if (d()) {
            return new l(this.a);
        }
        return new n(a((com.airbnb.lottie.model.content.h) this.b));
    }

    private Path a(com.airbnb.lottie.model.content.h hVar) {
        this.c.reset();
        f.a(hVar, this.c);
        return this.c;
    }
}
