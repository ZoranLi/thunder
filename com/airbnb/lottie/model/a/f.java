package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.i;
import com.airbnb.lottie.model.j;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatablePointValue */
public final class f extends o<PointF, PointF> {

    /* compiled from: AnimatablePointValue */
    public static final class a {
        public static f a(JSONObject jSONObject, i iVar) {
            jSONObject = n.a(jSONObject, iVar.k, iVar, j.a).a();
            return new f(jSONObject.a, (PointF) jSONObject.b);
        }
    }

    private f(List<com.airbnb.lottie.a.a<PointF>> list, PointF pointF) {
        super(list, pointF);
    }

    public final com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        if (d()) {
            return new com.airbnb.lottie.a.b.j(this.a);
        }
        return new n(this.b);
    }
}
