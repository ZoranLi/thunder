package com.airbnb.lottie.model;

import org.json.JSONArray;

/* compiled from: ScaleXY */
public final class k {
    public final float a;
    public final float b;

    /* compiled from: ScaleXY */
    public static class a implements com.airbnb.lottie.model.a.m.a<k> {
        public static final a a = new a();

        private a() {
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            return new k((((float) jSONArray.optDouble(0, 1.0d)) / 100.0f) * f, (((float) jSONArray.optDouble(1, 1.0d)) / 1120403456) * f);
        }
    }

    public k(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public k() {
        this(1.0f, 1.0f);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("x");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
