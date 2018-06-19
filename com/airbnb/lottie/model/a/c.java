package com.airbnb.lottie.model.a;

import android.graphics.Color;
import com.airbnb.lottie.a.b.d;
import com.airbnb.lottie.a.b.n;
import com.airbnb.lottie.i;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AnimatableGradientColorValue */
public final class c extends o<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> {

    /* compiled from: AnimatableGradientColorValue */
    public static final class a {
        public static c a(JSONObject jSONObject, i iVar) {
            jSONObject = n.a(jSONObject, 1.0f, iVar, new b(jSONObject.optInt("p", jSONObject.optJSONArray("k").length() / 4))).a();
            return new c(jSONObject.a, (com.airbnb.lottie.model.content.c) jSONObject.b);
        }
    }

    /* compiled from: AnimatableGradientColorValue */
    private static class b implements com.airbnb.lottie.model.a.m.a<com.airbnb.lottie.model.content.c> {
        private final int a;

        private b(int i) {
            this.a = i;
        }

        private void a(com.airbnb.lottie.model.content.c cVar, JSONArray jSONArray) {
            com.airbnb.lottie.model.content.c cVar2 = cVar;
            JSONArray jSONArray2 = jSONArray;
            int i = this.a * 4;
            if (jSONArray.length() > i) {
                int length = (jSONArray.length() - i) / 2;
                double[] dArr = new double[length];
                double[] dArr2 = new double[length];
                int i2 = 0;
                int i3 = 0;
                while (i < jSONArray.length()) {
                    if (i % 2 == 0) {
                        dArr[i3] = jSONArray2.optDouble(i);
                    } else {
                        dArr2[i3] = jSONArray2.optDouble(i);
                        i3++;
                    }
                    i++;
                }
                while (i2 < cVar2.b.length) {
                    int i4 = cVar2.b[i2];
                    double d = (double) cVar2.a[i2];
                    for (int i5 = 1; i5 < dArr.length; i5++) {
                        int i6 = i5 - 1;
                        double d2 = dArr[i6];
                        double d3 = dArr[i5];
                        if (dArr[i5] >= d) {
                            d = (d - d2) / (d3 - d2);
                            double d4 = dArr2[i6];
                            i = (int) (255.0d * (d4 + (d * (dArr2[i5] - d4))));
                            break;
                        }
                    }
                    i = (int) (255.0d * dArr2[dArr2.length - 1]);
                    cVar2.b[i2] = Color.argb(i, Color.red(i4), Color.green(i4), Color.blue(i4));
                    i2++;
                }
            }
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            JSONArray jSONArray = (JSONArray) obj;
            f = new float[this.a];
            int[] iArr = new int[this.a];
            com.airbnb.lottie.model.content.c cVar = new com.airbnb.lottie.model.content.c(f, iArr);
            if (jSONArray.length() != this.a * 4) {
                StringBuilder stringBuilder = new StringBuilder("Unexpected gradient length: ");
                stringBuilder.append(jSONArray.length());
                stringBuilder.append(". Expected ");
                stringBuilder.append(this.a * 4);
                stringBuilder.append(". This may affect the appearance of the gradient. Make sure to save your After Effects file before exporting an animation with gradients.");
            }
            int i = 0;
            int i2 = 0;
            int i3 = i2;
            while (i < this.a * 4) {
                int i4 = i / 4;
                double optDouble = jSONArray.optDouble(i);
                switch (i % 4) {
                    case 0:
                        f[i4] = (float) optDouble;
                        break;
                    case 1:
                        i2 = (int) (optDouble * 255.0d);
                        break;
                    case 2:
                        i3 = (int) (optDouble * 255.0d);
                        break;
                    case 3:
                        iArr[i4] = Color.argb(255, i2, i3, (int) (optDouble * 255.0d));
                        break;
                    default:
                        break;
                }
                i++;
            }
            a(cVar, jSONArray);
            return cVar;
        }
    }

    private c(List<com.airbnb.lottie.a.a<com.airbnb.lottie.model.content.c>> list, com.airbnb.lottie.model.content.c cVar) {
        super(list, cVar);
    }

    public final com.airbnb.lottie.a.b.a<com.airbnb.lottie.model.content.c, com.airbnb.lottie.model.content.c> a() {
        if (d()) {
            return new d(this.a);
        }
        return new n(this.b);
    }
}
