package com.airbnb.lottie.model.content;

import android.support.annotation.Nullable;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.airbnb.lottie.a.a.h;
import com.airbnb.lottie.i;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.c;
import com.airbnb.lottie.model.a.d;
import com.airbnb.lottie.model.a.f;
import com.airbnb.lottie.model.content.ShapeStroke.LineCapType;
import com.airbnb.lottie.model.content.ShapeStroke.LineJoinType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: GradientStroke */
public final class e implements b {
    public final String a;
    public final GradientType b;
    public final c c;
    public final d d;
    public final f e;
    public final f f;
    public final b g;
    public final LineCapType h;
    public final LineJoinType i;
    public final List<b> j;
    @Nullable
    public final b k;

    /* compiled from: GradientStroke */
    static class a {
        static e a(JSONObject jSONObject, i iVar) {
            b bVar;
            JSONObject jSONObject2 = jSONObject;
            i iVar2 = iVar;
            String optString = jSONObject2.optString("nm");
            JSONObject optJSONObject = jSONObject2.optJSONObject("g");
            if (optJSONObject != null && optJSONObject.has("k")) {
                optJSONObject = optJSONObject.optJSONObject("k");
            }
            c a = optJSONObject != null ? com.airbnb.lottie.model.a.c.a.a(optJSONObject, iVar2) : null;
            optJSONObject = jSONObject2.optJSONObject("o");
            d a2 = optJSONObject != null ? com.airbnb.lottie.model.a.d.a.a(optJSONObject, iVar2) : null;
            boolean z = true;
            GradientType gradientType = jSONObject2.optInt(DispatchConstants.TIMESTAMP, 1) == 1 ? GradientType.Linear : GradientType.Radial;
            JSONObject optJSONObject2 = jSONObject2.optJSONObject("s");
            f a3 = optJSONObject2 != null ? com.airbnb.lottie.model.a.f.a.a(optJSONObject2, iVar2) : null;
            JSONObject optJSONObject3 = jSONObject2.optJSONObject(com.xunlei.downloadprovider.pushmessage.e.a);
            f a4 = optJSONObject3 != null ? com.airbnb.lottie.model.a.f.a.a(optJSONObject3, iVar2) : null;
            b a5 = com.airbnb.lottie.model.a.b.a.a(jSONObject2.optJSONObject(IXAdRequestInfo.WIDTH), iVar2, true);
            LineCapType lineCapType = LineCapType.values()[jSONObject2.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject2.optInt("lj") - 1];
            List arrayList = new ArrayList();
            if (jSONObject2.has(com.xunlei.downloadprovider.ad.downloadlist.d.a)) {
                JSONArray optJSONArray = jSONObject2.optJSONArray(com.xunlei.downloadprovider.ad.downloadlist.d.a);
                b bVar2 = null;
                int i = 0;
                while (i < optJSONArray.length()) {
                    JSONObject optJSONObject4 = optJSONArray.optJSONObject(i);
                    String optString2 = optJSONObject4.optString(IXAdRequestInfo.AD_COUNT);
                    JSONArray jSONArray = optJSONArray;
                    if (optString2.equals("o")) {
                        z = true;
                        bVar2 = com.airbnb.lottie.model.a.b.a.a(optJSONObject4.optJSONObject("v"), iVar2, true);
                    } else {
                        if (!optString2.equals(com.xunlei.downloadprovider.ad.downloadlist.d.a)) {
                            if (!optString2.equals("g")) {
                                z = true;
                            }
                        }
                        z = true;
                        arrayList.add(com.airbnb.lottie.model.a.b.a.a(optJSONObject4.optJSONObject("v"), iVar2, true));
                    }
                    i++;
                    optJSONArray = jSONArray;
                }
                if (arrayList.size() == z) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            } else {
                bVar = null;
            }
            return new e(optString, gradientType, a, a2, a3, a4, a5, lineCapType, lineJoinType, arrayList, bVar);
        }
    }

    private e(String str, GradientType gradientType, c cVar, d dVar, f fVar, f fVar2, b bVar, LineCapType lineCapType, LineJoinType lineJoinType, List<b> list, @Nullable b bVar2) {
        this.a = str;
        this.b = gradientType;
        this.c = cVar;
        this.d = dVar;
        this.e = fVar;
        this.f = fVar2;
        this.g = bVar;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = list;
        this.k = bVar2;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return new h(jVar, aVar, this);
    }
}
