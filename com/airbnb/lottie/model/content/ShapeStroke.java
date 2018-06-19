package com.airbnb.lottie.model.content;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.support.annotation.Nullable;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.i;
import com.airbnb.lottie.j;
import com.airbnb.lottie.model.a.b;
import com.airbnb.lottie.model.a.d;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class ShapeStroke implements b {
    public final String a;
    @Nullable
    public final b b;
    public final List<b> c;
    public final com.airbnb.lottie.model.a.a d;
    public final d e;
    public final b f;
    public final LineCapType g;
    public final LineJoinType h;

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public final Cap toPaintCap() {
            switch (l.a[ordinal()]) {
                case 1:
                    return Cap.BUTT;
                case 2:
                    return Cap.ROUND;
                default:
                    return Cap.SQUARE;
            }
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public final Join toPaintJoin() {
            switch (l.b[ordinal()]) {
                case 1:
                    return Join.BEVEL;
                case 2:
                    return Join.MITER;
                case 3:
                    return Join.ROUND;
                default:
                    return null;
            }
        }
    }

    static class a {
        static ShapeStroke a(JSONObject jSONObject, i iVar) {
            String optString = jSONObject.optString("nm");
            List arrayList = new ArrayList();
            com.airbnb.lottie.model.a.a a = com.airbnb.lottie.model.a.a.a.a(jSONObject.optJSONObject(c.a), iVar);
            b a2 = com.airbnb.lottie.model.a.b.a.a(jSONObject.optJSONObject(IXAdRequestInfo.WIDTH), iVar, true);
            d a3 = com.airbnb.lottie.model.a.d.a.a(jSONObject.optJSONObject("o"), iVar);
            LineCapType lineCapType = LineCapType.values()[jSONObject.optInt("lc") - 1];
            LineJoinType lineJoinType = LineJoinType.values()[jSONObject.optInt("lj") - 1];
            b bVar = null;
            if (jSONObject.has(com.xunlei.downloadprovider.ad.downloadlist.d.a)) {
                jSONObject = jSONObject.optJSONArray(com.xunlei.downloadprovider.ad.downloadlist.d.a);
                b bVar2 = null;
                for (int i = 0; i < jSONObject.length(); i++) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(i);
                    String optString2 = optJSONObject.optString(IXAdRequestInfo.AD_COUNT);
                    if (optString2.equals("o")) {
                        bVar2 = com.airbnb.lottie.model.a.b.a.a(optJSONObject.optJSONObject("v"), iVar, true);
                    } else if (optString2.equals(com.xunlei.downloadprovider.ad.downloadlist.d.a) || optString2.equals("g")) {
                        arrayList.add(com.airbnb.lottie.model.a.b.a.a(optJSONObject.optJSONObject("v"), iVar, true));
                    }
                }
                if (arrayList.size() == 1) {
                    arrayList.add(arrayList.get(0));
                }
                bVar = bVar2;
            }
            return new ShapeStroke(optString, bVar, arrayList, a, a3, a2, lineCapType, lineJoinType);
        }
    }

    private ShapeStroke(String str, @Nullable b bVar, List<b> list, com.airbnb.lottie.model.a.a aVar, d dVar, b bVar2, LineCapType lineCapType, LineJoinType lineJoinType) {
        this.a = str;
        this.b = bVar;
        this.c = list;
        this.d = aVar;
        this.e = dVar;
        this.f = bVar2;
        this.g = lineCapType;
        this.h = lineJoinType;
    }

    public final com.airbnb.lottie.a.a.b a(j jVar, com.airbnb.lottie.model.layer.a aVar) {
        return new r(jVar, aVar, this);
    }
}
