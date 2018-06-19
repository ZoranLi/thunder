package com.airbnb.lottie.model;

import android.graphics.Color;
import org.json.JSONArray;

/* compiled from: ColorFactory */
public final class a implements com.airbnb.lottie.model.a.m.a<Integer> {
    public static final a a = new a();

    public final /* synthetic */ Object a(Object obj, float f) {
        JSONArray jSONArray = (JSONArray) obj;
        if (jSONArray.length() != 4) {
            return Integer.valueOf(-16777216);
        }
        int i = 1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            if (jSONArray.optDouble(i2) > 1.0d) {
                i = 0;
            }
        }
        double d = (double) (i != 0 ? 255.0f : 1.0f);
        return Integer.valueOf(Color.argb((int) (jSONArray.optDouble(3) * d), (int) (jSONArray.optDouble(0) * d), (int) (jSONArray.optDouble(1) * d), (int) (jSONArray.optDouble(2) * d)));
    }
}
