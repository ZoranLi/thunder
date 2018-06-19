package com.airbnb.lottie.c;

import android.graphics.PointF;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JsonUtils */
public final class b {
    public static PointF a(JSONObject jSONObject, float f) {
        return new PointF(a(jSONObject.opt("x")) * f, a(jSONObject.opt("y")) * f);
    }

    public static PointF a(JSONArray jSONArray, float f) {
        if (jSONArray.length() >= 2) {
            return new PointF(((float) jSONArray.optDouble(0, 1.0d)) * f, ((float) jSONArray.optDouble(1, 1.0d)) * f);
        }
        StringBuilder stringBuilder = new StringBuilder("Unable to parse point for ");
        stringBuilder.append(jSONArray);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static float a(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        if (obj instanceof Integer) {
            return (float) ((Integer) obj).intValue();
        }
        if (obj instanceof Double) {
            return (float) ((Double) obj).doubleValue();
        }
        return obj instanceof JSONArray ? (float) ((JSONArray) obj).optDouble(0) : null;
    }
}
