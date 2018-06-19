package com.airbnb.lottie.model.a;

import android.graphics.PointF;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.airbnb.lottie.a.b.h;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.c.g;
import com.airbnb.lottie.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnimatablePathValue */
public final class e implements m<PointF, PointF> {
    private final List<h> a;
    private PointF b;

    /* compiled from: AnimatablePathValue */
    private static class a implements com.airbnb.lottie.model.a.m.a<PointF> {
        private static final com.airbnb.lottie.model.a.m.a<PointF> a = new a();

        private a() {
        }

        public final /* bridge */ /* synthetic */ Object a(Object obj, float f) {
            return b.a((JSONArray) obj, f);
        }
    }

    public static m<PointF, PointF> a(JSONObject jSONObject, i iVar) {
        if (jSONObject.has("k")) {
            return new e(jSONObject.opt("k"), iVar);
        }
        return new i(com.airbnb.lottie.model.a.b.a.a(jSONObject.optJSONObject("x"), iVar, true), com.airbnb.lottie.model.a.b.a.a(jSONObject.optJSONObject("y"), iVar, true));
    }

    public e() {
        this.a = new ArrayList();
        this.b = new PointF(0.0f, 0.0f);
    }

    e(Object obj, i iVar) {
        int i;
        JSONArray jSONArray;
        int length;
        int i2;
        com.airbnb.lottie.a.a a;
        JSONArray optJSONArray;
        PointF pointF;
        PointF pointF2;
        h hVar;
        PointF pointF3;
        PointF pointF4;
        Object obj2 = obj;
        i iVar2 = iVar;
        this.a = new ArrayList();
        if (obj2 instanceof JSONArray) {
            Object opt = ((JSONArray) obj2).opt(0);
            if ((opt instanceof JSONObject) && ((JSONObject) opt).has(DispatchConstants.TIMESTAMP)) {
                i = 1;
                if (i == 0) {
                    jSONArray = (JSONArray) obj2;
                    length = jSONArray.length();
                    i2 = 0;
                    while (i2 < length) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        a = com.airbnb.lottie.a.a.a.a(optJSONObject, iVar2, iVar2.k, a.a);
                        optJSONArray = optJSONObject.optJSONArray("ti");
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("to");
                        if (optJSONArray != null || optJSONArray2 == null) {
                            pointF = null;
                            pointF2 = pointF;
                        } else {
                            PointF a2 = b.a(optJSONArray2, iVar2.k);
                            pointF = b.a(optJSONArray, iVar2.k);
                            pointF2 = a2;
                        }
                        hVar = r1;
                        pointF3 = pointF;
                        JSONArray jSONArray2 = jSONArray;
                        pointF4 = pointF2;
                        h hVar2 = new h(iVar2, (PointF) a.a, (PointF) a.b, a.c, a.d, a.e);
                        obj2 = (a.b == null && a.a != null && ((PointF) a.a).equals(((PointF) a.b).x, ((PointF) a.b).y)) ? 1 : null;
                        if (hVar.b != null && obj2 == null) {
                            hVar.f = g.a((PointF) a.a, (PointF) a.b, pointF4, pointF3);
                        }
                        r0.a.add(hVar);
                        i2++;
                        jSONArray = jSONArray2;
                    }
                    com.airbnb.lottie.a.a.a(r0.a);
                }
                r0.b = b.a((JSONArray) obj2, iVar2.k);
                return;
            }
        }
        i = 0;
        if (i == 0) {
            r0.b = b.a((JSONArray) obj2, iVar2.k);
            return;
        }
        jSONArray = (JSONArray) obj2;
        length = jSONArray.length();
        i2 = 0;
        while (i2 < length) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i2);
            a = com.airbnb.lottie.a.a.a.a(optJSONObject2, iVar2, iVar2.k, a.a);
            optJSONArray = optJSONObject2.optJSONArray("ti");
            JSONArray optJSONArray22 = optJSONObject2.optJSONArray("to");
            if (optJSONArray != null) {
            }
            pointF = null;
            pointF2 = pointF;
            hVar = hVar2;
            pointF3 = pointF;
            JSONArray jSONArray22 = jSONArray;
            pointF4 = pointF2;
            h hVar22 = new h(iVar2, (PointF) a.a, (PointF) a.b, a.c, a.d, a.e);
            if (a.b == null) {
            }
            hVar.f = g.a((PointF) a.a, (PointF) a.b, pointF4, pointF3);
            r0.a.add(hVar);
            i2++;
            jSONArray = jSONArray22;
        }
        com.airbnb.lottie.a.a.a(r0.a);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("initialPoint=");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }

    public final com.airbnb.lottie.a.b.a<PointF, PointF> a() {
        if ((this.a.isEmpty() ^ 1) == 0) {
            return new n(this.b);
        }
        return new com.airbnb.lottie.a.b.i(this.a);
    }
}
