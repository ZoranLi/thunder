package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import com.airbnb.lottie.c.f;
import com.airbnb.lottie.model.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ShapeData */
public final class h {
    public final List<c> a;
    public PointF b;
    public boolean c;

    /* compiled from: ShapeData */
    public static class a implements com.airbnb.lottie.model.a.m.a<h> {
        public static final a a = new a();

        private a() {
        }

        private static PointF a(int i, JSONArray jSONArray) {
            if (i >= jSONArray.length()) {
                StringBuilder stringBuilder = new StringBuilder("Invalid index ");
                stringBuilder.append(i);
                stringBuilder.append(". There are only ");
                stringBuilder.append(jSONArray.length());
                stringBuilder.append(" points.");
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            i = jSONArray.optJSONArray(i);
            jSONArray = i.opt(null);
            i = i.opt(1);
            return new PointF(jSONArray instanceof Double ? ((Double) jSONArray).floatValue() : (float) ((Integer) jSONArray).intValue(), i instanceof Double ? ((Double) i).floatValue() : (float) ((Integer) i).intValue());
        }

        public final /* synthetic */ Object a(Object obj, float f) {
            JSONArray optJSONArray;
            JSONArray optJSONArray2;
            JSONArray optJSONArray3;
            boolean optBoolean;
            PointF a;
            List arrayList;
            int i;
            PointF a2;
            int i2;
            PointF a3;
            PointF a4;
            PointF a5;
            PointF a6;
            int i3;
            PointF a7;
            PointF a8;
            PointF a9;
            StringBuilder stringBuilder;
            if (obj instanceof JSONArray) {
                obj = ((JSONArray) obj).opt(0);
                if (obj instanceof JSONObject) {
                    obj = (JSONObject) obj;
                    if (obj.has("v")) {
                        if (obj != null) {
                            return null;
                        }
                        optJSONArray = obj.optJSONArray("v");
                        optJSONArray2 = obj.optJSONArray("i");
                        optJSONArray3 = obj.optJSONArray("o");
                        optBoolean = obj.optBoolean(com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a, false);
                        if (!(optJSONArray == null || optJSONArray2 == null || optJSONArray3 == null || optJSONArray.length() != optJSONArray2.length())) {
                            if (optJSONArray.length() != optJSONArray3.length()) {
                                if (optJSONArray.length() != null) {
                                    return new h(new PointF(), false, Collections.emptyList());
                                }
                                obj = optJSONArray.length();
                                a = a(0, optJSONArray);
                                a.x *= f;
                                a.y *= f;
                                arrayList = new ArrayList(obj);
                                for (i = 1; i < obj; i++) {
                                    a2 = a(i, optJSONArray);
                                    i2 = i - 1;
                                    a3 = a(i2, optJSONArray);
                                    a4 = a(i2, optJSONArray3);
                                    a5 = a(i, optJSONArray2);
                                    a4 = f.a(a3, a4);
                                    a3 = f.a(a2, a5);
                                    a4.x *= f;
                                    a4.y *= f;
                                    a3.x *= f;
                                    a3.y *= f;
                                    a2.x *= f;
                                    a2.y *= f;
                                    arrayList.add(new c(a4, a3, a2));
                                }
                                if (optBoolean) {
                                    a6 = a(0, optJSONArray);
                                    i3 = obj - 1;
                                    a7 = a(i3, optJSONArray);
                                    a8 = a(i3, optJSONArray3);
                                    a9 = a(0, optJSONArray2);
                                    obj = f.a(a7, a8);
                                    a7 = f.a(a6, a9);
                                    if (f != 1.0f) {
                                        obj.x *= f;
                                        obj.y *= f;
                                        a7.x *= f;
                                        a7.y *= f;
                                        a6.x *= f;
                                        a6.y *= f;
                                    }
                                    arrayList.add(new c(obj, a7, a6));
                                }
                                return new h(a, optBoolean, arrayList);
                            }
                        }
                        stringBuilder = new StringBuilder("Unable to process points array or tangents. ");
                        stringBuilder.append(obj);
                        throw new IllegalStateException(stringBuilder.toString());
                    }
                }
            } else if (obj instanceof JSONObject) {
                obj = (JSONObject) obj;
                if (obj.has("v")) {
                    if (obj != null) {
                        return null;
                    }
                    optJSONArray = obj.optJSONArray("v");
                    optJSONArray2 = obj.optJSONArray("i");
                    optJSONArray3 = obj.optJSONArray("o");
                    optBoolean = obj.optBoolean(com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a, false);
                    if (optJSONArray.length() != optJSONArray3.length()) {
                        stringBuilder = new StringBuilder("Unable to process points array or tangents. ");
                        stringBuilder.append(obj);
                        throw new IllegalStateException(stringBuilder.toString());
                    } else if (optJSONArray.length() != null) {
                        return new h(new PointF(), false, Collections.emptyList());
                    } else {
                        obj = optJSONArray.length();
                        a = a(0, optJSONArray);
                        a.x *= f;
                        a.y *= f;
                        arrayList = new ArrayList(obj);
                        for (i = 1; i < obj; i++) {
                            a2 = a(i, optJSONArray);
                            i2 = i - 1;
                            a3 = a(i2, optJSONArray);
                            a4 = a(i2, optJSONArray3);
                            a5 = a(i, optJSONArray2);
                            a4 = f.a(a3, a4);
                            a3 = f.a(a2, a5);
                            a4.x *= f;
                            a4.y *= f;
                            a3.x *= f;
                            a3.y *= f;
                            a2.x *= f;
                            a2.y *= f;
                            arrayList.add(new c(a4, a3, a2));
                        }
                        if (optBoolean) {
                            a6 = a(0, optJSONArray);
                            i3 = obj - 1;
                            a7 = a(i3, optJSONArray);
                            a8 = a(i3, optJSONArray3);
                            a9 = a(0, optJSONArray2);
                            obj = f.a(a7, a8);
                            a7 = f.a(a6, a9);
                            if (f != 1.0f) {
                                obj.x *= f;
                                obj.y *= f;
                                a7.x *= f;
                                a7.y *= f;
                                a6.x *= f;
                                a6.y *= f;
                            }
                            arrayList.add(new c(obj, a7, a6));
                        }
                        return new h(a, optBoolean, arrayList);
                    }
                }
            }
            obj = null;
            if (obj != null) {
                return null;
            }
            optJSONArray = obj.optJSONArray("v");
            optJSONArray2 = obj.optJSONArray("i");
            optJSONArray3 = obj.optJSONArray("o");
            optBoolean = obj.optBoolean(com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a, false);
            if (optJSONArray.length() != optJSONArray3.length()) {
                stringBuilder = new StringBuilder("Unable to process points array or tangents. ");
                stringBuilder.append(obj);
                throw new IllegalStateException(stringBuilder.toString());
            } else if (optJSONArray.length() != null) {
                return new h(new PointF(), false, Collections.emptyList());
            } else {
                obj = optJSONArray.length();
                a = a(0, optJSONArray);
                a.x *= f;
                a.y *= f;
                arrayList = new ArrayList(obj);
                for (i = 1; i < obj; i++) {
                    a2 = a(i, optJSONArray);
                    i2 = i - 1;
                    a3 = a(i2, optJSONArray);
                    a4 = a(i2, optJSONArray3);
                    a5 = a(i, optJSONArray2);
                    a4 = f.a(a3, a4);
                    a3 = f.a(a2, a5);
                    a4.x *= f;
                    a4.y *= f;
                    a3.x *= f;
                    a3.y *= f;
                    a2.x *= f;
                    a2.y *= f;
                    arrayList.add(new c(a4, a3, a2));
                }
                if (optBoolean) {
                    a6 = a(0, optJSONArray);
                    i3 = obj - 1;
                    a7 = a(i3, optJSONArray);
                    a8 = a(i3, optJSONArray3);
                    a9 = a(0, optJSONArray2);
                    obj = f.a(a7, a8);
                    a7 = f.a(a6, a9);
                    if (f != 1.0f) {
                        obj.x *= f;
                        obj.y *= f;
                        a7.x *= f;
                        a7.y *= f;
                        a6.x *= f;
                        a6.y *= f;
                    }
                    arrayList.add(new c(obj, a7, a6));
                }
                return new h(a, optBoolean, arrayList);
            }
        }
    }

    private h(PointF pointF, boolean z, List<c> list) {
        this.a = new ArrayList();
        this.b = pointF;
        this.c = z;
        this.a.addAll(list);
    }

    public h() {
        this.a = new ArrayList();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("ShapeData{numCurves=");
        stringBuilder.append(this.a.size());
        stringBuilder.append("closed=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
