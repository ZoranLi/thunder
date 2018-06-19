package com.airbnb.lottie.model.content;

import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.g;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.f;

/* compiled from: GradientFill */
public final class d implements b {
    public final GradientType a;
    public final FillType b;
    public final c c;
    public final com.airbnb.lottie.model.a.d d;
    public final f e;
    public final f f;
    public final String g;
    @Nullable
    private final b h;
    @Nullable
    private final b i;

    /* compiled from: GradientFill */
    static class a {
        static com.airbnb.lottie.model.content.d a(org.json.JSONObject r10, com.airbnb.lottie.i r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r0 = "nm";
            r2 = r10.optString(r0);
            r0 = "g";
            r0 = r10.optJSONObject(r0);
            if (r0 == 0) goto L_0x0027;
        L_0x000e:
            r1 = "k";
            r1 = r0.has(r1);
            if (r1 == 0) goto L_0x0027;
        L_0x0016:
            r1 = "p";
            r1 = r0.optInt(r1);
            r3 = "k";
            r0 = r0.optJSONObject(r3);
            r3 = "p";	 Catch:{ JSONException -> 0x0027 }
            r0.put(r3, r1);	 Catch:{ JSONException -> 0x0027 }
        L_0x0027:
            r1 = 0;
            if (r0 == 0) goto L_0x0030;
        L_0x002a:
            r0 = com.airbnb.lottie.model.a.c.a.a(r0, r11);
            r5 = r0;
            goto L_0x0031;
        L_0x0030:
            r5 = r1;
        L_0x0031:
            r0 = "o";
            r0 = r10.optJSONObject(r0);
            if (r0 == 0) goto L_0x003f;
        L_0x0039:
            r0 = com.airbnb.lottie.model.a.d.a.a(r0, r11);
            r6 = r0;
            goto L_0x0040;
        L_0x003f:
            r6 = r1;
        L_0x0040:
            r0 = "r";
            r3 = 1;
            r0 = r10.optInt(r0, r3);
            if (r0 != r3) goto L_0x004d;
        L_0x0049:
            r0 = android.graphics.Path.FillType.WINDING;
        L_0x004b:
            r4 = r0;
            goto L_0x0050;
        L_0x004d:
            r0 = android.graphics.Path.FillType.EVEN_ODD;
            goto L_0x004b;
        L_0x0050:
            r0 = "t";
            r0 = r10.optInt(r0, r3);
            if (r0 != r3) goto L_0x005c;
        L_0x0058:
            r0 = com.airbnb.lottie.model.content.GradientType.Linear;
        L_0x005a:
            r3 = r0;
            goto L_0x005f;
        L_0x005c:
            r0 = com.airbnb.lottie.model.content.GradientType.Radial;
            goto L_0x005a;
        L_0x005f:
            r0 = "s";
            r0 = r10.optJSONObject(r0);
            if (r0 == 0) goto L_0x006d;
        L_0x0067:
            r0 = com.airbnb.lottie.model.a.f.a.a(r0, r11);
            r7 = r0;
            goto L_0x006e;
        L_0x006d:
            r7 = r1;
        L_0x006e:
            r0 = "e";
            r10 = r10.optJSONObject(r0);
            if (r10 == 0) goto L_0x007c;
        L_0x0076:
            r10 = com.airbnb.lottie.model.a.f.a.a(r10, r11);
            r8 = r10;
            goto L_0x007d;
        L_0x007c:
            r8 = r1;
        L_0x007d:
            r10 = new com.airbnb.lottie.model.content.d;
            r9 = 0;
            r1 = r10;
            r1.<init>(r2, r3, r4, r5, r6, r7, r8);
            return r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.d.a.a(org.json.JSONObject, com.airbnb.lottie.i):com.airbnb.lottie.model.content.d");
        }
    }

    private d(String str, GradientType gradientType, FillType fillType, c cVar, com.airbnb.lottie.model.a.d dVar, f fVar, f fVar2) {
        this.a = gradientType;
        this.b = fillType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = str;
        this.h = null;
        this.i = null;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return new g(jVar, aVar, this);
    }
}
