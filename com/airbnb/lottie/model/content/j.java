package com.airbnb.lottie.model.content;

import com.airbnb.lottie.a.a.b;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.model.layer.a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup */
public final class j implements b {
    public final String a;
    public final List<b> b;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @android.support.annotation.Nullable
    public static com.airbnb.lottie.model.content.b a(org.json.JSONObject r19, com.airbnb.lottie.i r20) {
        /*
        r0 = r19;
        r1 = r20;
        r2 = "ty";
        r2 = r0.optString(r2);
        r3 = r2.hashCode();
        r4 = 3;
        r5 = 2;
        r6 = 1;
        r7 = 0;
        switch(r3) {
            case 3239: goto L_0x0098;
            case 3270: goto L_0x008e;
            case 3295: goto L_0x0084;
            case 3307: goto L_0x007a;
            case 3308: goto L_0x0070;
            case 3488: goto L_0x0065;
            case 3633: goto L_0x005a;
            case 3646: goto L_0x004f;
            case 3669: goto L_0x0045;
            case 3679: goto L_0x0039;
            case 3681: goto L_0x002e;
            case 3705: goto L_0x0022;
            case 3710: goto L_0x0017;
            default: goto L_0x0015;
        };
    L_0x0015:
        goto L_0x00a2;
    L_0x0017:
        r3 = "tr";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x001f:
        r2 = 5;
        goto L_0x00a3;
    L_0x0022:
        r3 = "tm";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x002a:
        r2 = 9;
        goto L_0x00a3;
    L_0x002e:
        r3 = "st";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0036:
        r2 = r6;
        goto L_0x00a3;
    L_0x0039:
        r3 = "sr";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0041:
        r2 = 10;
        goto L_0x00a3;
    L_0x0045:
        r3 = "sh";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x004d:
        r2 = 6;
        goto L_0x00a3;
    L_0x004f:
        r3 = "rp";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0057:
        r2 = 12;
        goto L_0x00a3;
    L_0x005a:
        r3 = "rc";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0062:
        r2 = 8;
        goto L_0x00a3;
    L_0x0065:
        r3 = "mm";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x006d:
        r2 = 11;
        goto L_0x00a3;
    L_0x0070:
        r3 = "gs";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0078:
        r2 = r5;
        goto L_0x00a3;
    L_0x007a:
        r3 = "gr";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0082:
        r2 = r7;
        goto L_0x00a3;
    L_0x0084:
        r3 = "gf";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x008c:
        r2 = 4;
        goto L_0x00a3;
    L_0x008e:
        r3 = "fl";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x0096:
        r2 = r4;
        goto L_0x00a3;
    L_0x0098:
        r3 = "el";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00a2;
    L_0x00a0:
        r2 = 7;
        goto L_0x00a3;
    L_0x00a2:
        r2 = -1;
    L_0x00a3:
        r3 = 0;
        switch(r2) {
            case 0: goto L_0x0252;
            case 1: goto L_0x024d;
            case 2: goto L_0x0248;
            case 3: goto L_0x0209;
            case 4: goto L_0x0204;
            case 5: goto L_0x01ff;
            case 6: goto L_0x01e3;
            case 7: goto L_0x01b4;
            case 8: goto L_0x0188;
            case 9: goto L_0x0152;
            case 10: goto L_0x00e8;
            case 11: goto L_0x00d2;
            case 12: goto L_0x00a8;
            default: goto L_0x00a7;
        };
    L_0x00a7:
        return r3;
    L_0x00a8:
        r2 = "nm";
        r2 = r0.optString(r2);
        r3 = "c";
        r3 = r0.optJSONObject(r3);
        r3 = com.airbnb.lottie.model.a.b.a.a(r3, r1, r7);
        r4 = "o";
        r4 = r0.optJSONObject(r4);
        r4 = com.airbnb.lottie.model.a.b.a.a(r4, r1, r7);
        r5 = "tr";
        r0 = r0.optJSONObject(r5);
        r0 = com.airbnb.lottie.model.a.l.a.a(r0, r1);
        r1 = new com.airbnb.lottie.model.content.g;
        r1.<init>(r2, r3, r4, r0);
        return r1;
    L_0x00d2:
        r1 = new com.airbnb.lottie.model.content.MergePaths;
        r2 = "nm";
        r2 = r0.optString(r2);
        r3 = "mm";
        r0 = r0.optInt(r3, r6);
        r0 = com.airbnb.lottie.model.content.MergePaths.MergePathsMode.forId(r0);
        r1.<init>(r2, r0);
        return r1;
    L_0x00e8:
        r2 = "nm";
        r9 = r0.optString(r2);
        r2 = "sy";
        r2 = r0.optInt(r2);
        r10 = com.airbnb.lottie.model.content.PolystarShape.Type.forValue(r2);
        r2 = "pt";
        r2 = r0.optJSONObject(r2);
        r11 = com.airbnb.lottie.model.a.b.a.a(r2, r1, r7);
        r2 = "p";
        r2 = r0.optJSONObject(r2);
        r12 = com.airbnb.lottie.model.a.e.a(r2, r1);
        r2 = "r";
        r2 = r0.optJSONObject(r2);
        r13 = com.airbnb.lottie.model.a.b.a.a(r2, r1, r7);
        r2 = "or";
        r2 = r0.optJSONObject(r2);
        r15 = com.airbnb.lottie.model.a.b.a.a(r2, r1, r6);
        r2 = "os";
        r2 = r0.optJSONObject(r2);
        r17 = com.airbnb.lottie.model.a.b.a.a(r2, r1, r7);
        r2 = com.airbnb.lottie.model.content.PolystarShape.Type.Star;
        if (r10 != r2) goto L_0x0146;
    L_0x012e:
        r2 = "ir";
        r2 = r0.optJSONObject(r2);
        r3 = com.airbnb.lottie.model.a.b.a.a(r2, r1, r6);
        r2 = "is";
        r0 = r0.optJSONObject(r2);
        r0 = com.airbnb.lottie.model.a.b.a.a(r0, r1, r7);
        r16 = r0;
        r14 = r3;
        goto L_0x0149;
    L_0x0146:
        r14 = r3;
        r16 = r14;
    L_0x0149:
        r0 = new com.airbnb.lottie.model.content.PolystarShape;
        r18 = 0;
        r8 = r0;
        r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17);
        return r0;
    L_0x0152:
        r8 = new com.airbnb.lottie.model.content.ShapeTrimPath;
        r2 = "nm";
        r2 = r0.optString(r2);
        r3 = "m";
        r3 = r0.optInt(r3, r6);
        r3 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.forId(r3);
        r4 = "s";
        r4 = r0.optJSONObject(r4);
        r4 = com.airbnb.lottie.model.a.b.a.a(r4, r1, r7);
        r5 = "e";
        r5 = r0.optJSONObject(r5);
        r5 = com.airbnb.lottie.model.a.b.a.a(r5, r1, r7);
        r6 = "o";
        r0 = r0.optJSONObject(r6);
        r6 = com.airbnb.lottie.model.a.b.a.a(r0, r1, r7);
        r7 = 0;
        r1 = r8;
        r1.<init>(r2, r3, r4, r5, r6);
        return r8;
    L_0x0188:
        r2 = new com.airbnb.lottie.model.content.f;
        r3 = "nm";
        r10 = r0.optString(r3);
        r3 = "p";
        r3 = r0.optJSONObject(r3);
        r11 = com.airbnb.lottie.model.a.e.a(r3, r1);
        r3 = "s";
        r3 = r0.optJSONObject(r3);
        r12 = com.airbnb.lottie.model.a.f.a.a(r3, r1);
        r3 = "r";
        r0 = r0.optJSONObject(r3);
        r13 = com.airbnb.lottie.model.a.b.a.a(r0, r1, r6);
        r14 = 0;
        r9 = r2;
        r9.<init>(r10, r11, r12, r13);
        return r2;
    L_0x01b4:
        r2 = new com.airbnb.lottie.model.content.a;
        r3 = "nm";
        r8 = r0.optString(r3);
        r3 = "p";
        r3 = r0.optJSONObject(r3);
        r9 = com.airbnb.lottie.model.a.e.a(r3, r1);
        r3 = "s";
        r3 = r0.optJSONObject(r3);
        r1 = com.airbnb.lottie.model.a.f.a.a(r3, r1);
        r3 = "d";
        r0 = r0.optInt(r3, r5);
        if (r0 != r4) goto L_0x01d9;
    L_0x01d8:
        r7 = r6;
    L_0x01d9:
        r0 = 0;
        r3 = r2;
        r4 = r8;
        r5 = r9;
        r6 = r1;
        r8 = r0;
        r3.<init>(r4, r5, r6, r7);
        return r2;
    L_0x01e3:
        r2 = "ks";
        r2 = r0.optJSONObject(r2);
        r1 = com.airbnb.lottie.model.a.h.a.a(r2, r1);
        r2 = new com.airbnb.lottie.model.content.k;
        r3 = "nm";
        r3 = r0.optString(r3);
        r4 = "ind";
        r0 = r0.optInt(r4);
        r2.<init>(r3, r0, r1, r7);
        return r2;
    L_0x01ff:
        r0 = com.airbnb.lottie.model.a.l.a.a(r19, r20);
        return r0;
    L_0x0204:
        r0 = com.airbnb.lottie.model.content.d.a.a(r19, r20);
        return r0;
    L_0x0209:
        r2 = "nm";
        r8 = r0.optString(r2);
        r2 = "c";
        r2 = r0.optJSONObject(r2);
        if (r2 == 0) goto L_0x021d;
    L_0x0217:
        r2 = com.airbnb.lottie.model.a.a.a.a(r2, r1);
        r11 = r2;
        goto L_0x021e;
    L_0x021d:
        r11 = r3;
    L_0x021e:
        r2 = "o";
        r2 = r0.optJSONObject(r2);
        if (r2 == 0) goto L_0x022a;
    L_0x0226:
        r3 = com.airbnb.lottie.model.a.d.a.a(r2, r1);
    L_0x022a:
        r12 = r3;
        r1 = "fillEnabled";
        r9 = r0.optBoolean(r1);
        r1 = "r";
        r0 = r0.optInt(r1, r6);
        if (r0 != r6) goto L_0x023d;
    L_0x0239:
        r0 = android.graphics.Path.FillType.WINDING;
    L_0x023b:
        r10 = r0;
        goto L_0x0240;
    L_0x023d:
        r0 = android.graphics.Path.FillType.EVEN_ODD;
        goto L_0x023b;
    L_0x0240:
        r0 = new com.airbnb.lottie.model.content.i;
        r13 = 0;
        r7 = r0;
        r7.<init>(r8, r9, r10, r11, r12);
        return r0;
    L_0x0248:
        r0 = com.airbnb.lottie.model.content.e.a.a(r19, r20);
        return r0;
    L_0x024d:
        r0 = com.airbnb.lottie.model.content.ShapeStroke.a.a(r19, r20);
        return r0;
    L_0x0252:
        r2 = "it";
        r2 = r0.optJSONArray(r2);
        r3 = "nm";
        r0 = r0.optString(r3);
        r3 = new java.util.ArrayList;
        r3.<init>();
    L_0x0263:
        r4 = r2.length();
        if (r7 >= r4) goto L_0x0279;
    L_0x0269:
        r4 = r2.optJSONObject(r7);
        r4 = a(r4, r1);
        if (r4 == 0) goto L_0x0276;
    L_0x0273:
        r3.add(r4);
    L_0x0276:
        r7 = r7 + 1;
        goto L_0x0263;
    L_0x0279:
        r1 = new com.airbnb.lottie.model.content.j;
        r1.<init>(r0, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.content.j.a(org.json.JSONObject, com.airbnb.lottie.i):com.airbnb.lottie.model.content.b");
    }

    public j(String str, List<b> list) {
        this.a = str;
        this.b = list;
    }

    public final b a(com.airbnb.lottie.j jVar, a aVar) {
        return new c(jVar, aVar, this);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ShapeGroup{name='");
        stringBuilder.append(this.a);
        stringBuilder.append("' Shapes: ");
        stringBuilder.append(Arrays.toString(this.b.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
