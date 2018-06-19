package com.airbnb.lottie.model;

import android.graphics.PointF;
import com.airbnb.lottie.c.b;
import com.airbnb.lottie.model.a.m.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: PointFFactory */
public final class j implements a<PointF> {
    public static final j a = new j();

    private j() {
    }

    public final /* synthetic */ Object a(Object obj, float f) {
        if (obj instanceof JSONArray) {
            return b.a((JSONArray) obj, f);
        }
        if (obj instanceof JSONObject) {
            return b.a((JSONObject) obj, f);
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to parse point from ");
        stringBuilder.append(obj);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}
