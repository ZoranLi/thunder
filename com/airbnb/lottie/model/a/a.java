package com.airbnb.lottie.model.a;

import com.airbnb.lottie.a.b.b;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.i;
import java.util.List;
import org.json.JSONObject;

/* compiled from: AnimatableColorValue */
public final class a extends o<Integer, Integer> {

    /* compiled from: AnimatableColorValue */
    public static final class a {
        public static a a(JSONObject jSONObject, i iVar) {
            jSONObject = n.a(jSONObject, 1.0f, iVar, com.airbnb.lottie.model.a.a).a();
            return new a(jSONObject.a, (Integer) jSONObject.b);
        }
    }

    private a(List<com.airbnb.lottie.a.a<Integer>> list, Integer num) {
        super(list, num);
    }

    public final com.airbnb.lottie.a.b.a<Integer, Integer> a() {
        if (d()) {
            return new b(this.a);
        }
        return new n(this.b);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("AnimatableColorValue{initialValue=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
