package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import com.airbnb.lottie.model.content.j;
import com.airbnb.lottie.model.e;
import com.airbnb.lottie.model.f;
import com.airbnb.lottie.model.g;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.model.layer.Layer.LayerType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.Closeable;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: LottieComposition */
public final class i {
    public final Map<String, List<Layer>> a;
    public final Map<String, p> b;
    public final Map<String, f> c;
    public final SparseArrayCompat<g> d;
    final LongSparseArray<Layer> e;
    public final List<Layer> f;
    public final s g;
    public final Rect h;
    public final long i;
    public final long j;
    public final float k;
    public final int l;
    public final int m;
    public final int n;
    private final HashSet<String> o;
    private final float p;

    /* compiled from: LottieComposition */
    public static class a {
        public static a a(Context context, String str, q qVar) {
            try {
                return a(context, context.getAssets().open(str), qVar);
            } catch (Context context2) {
                StringBuilder stringBuilder = new StringBuilder("Unable to find file ");
                stringBuilder.append(str);
                throw new IllegalStateException(stringBuilder.toString(), context2);
            }
        }

        public static a a(Context context, InputStream inputStream, q qVar) {
            a eVar = new e(context.getResources(), qVar);
            eVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[]{inputStream});
            return eVar;
        }

        @Nullable
        public static i a(Resources resources, InputStream inputStream) {
            IllegalStateException illegalStateException;
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                resources = a(resources, new JSONObject(new String(bArr, "UTF-8")));
                com.airbnb.lottie.c.g.a((Closeable) inputStream);
                return resources;
            } catch (Resources resources2) {
                illegalStateException = new IllegalStateException("Unable to find file.", resources2);
            } catch (Resources resources22) {
                illegalStateException = new IllegalStateException("Unable to load JSON.", resources22);
            } catch (Throwable th) {
                com.airbnb.lottie.c.g.a((Closeable) inputStream);
            }
            com.airbnb.lottie.c.g.a((Closeable) inputStream);
            return null;
        }

        public static i a(Resources resources, JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            float f = resources.getDisplayMetrics().density;
            int optInt = jSONObject2.optInt(IXAdRequestInfo.WIDTH, -1);
            int optInt2 = jSONObject2.optInt(IXAdRequestInfo.HEIGHT, -1);
            Rect rect = (optInt == -1 || optInt2 == -1) ? null : new Rect(0, 0, (int) (((float) optInt) * f), (int) (((float) optInt2) * f));
            long optLong = jSONObject2.optLong("ip", 0);
            long optLong2 = jSONObject2.optLong("op", 0);
            float optDouble = (float) jSONObject2.optDouble(SocializeProtocolConstants.PROTOCOL_KEY_FR, 0.0d);
            String[] split = jSONObject2.optString("v").split("[.]");
            i iVar = new i(rect, optLong, optLong2, optDouble, f, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            JSONArray optJSONArray = jSONObject2.optJSONArray("assets");
            b(optJSONArray, iVar);
            a(optJSONArray, iVar);
            b(jSONObject2.optJSONObject("fonts"), iVar);
            c(jSONObject2.optJSONArray("chars"), iVar);
            a(jSONObject2, iVar);
            return iVar;
        }

        private static void a(JSONObject jSONObject, i iVar) {
            jSONObject = jSONObject.optJSONArray("layers");
            if (jSONObject != null) {
                int length = jSONObject.length();
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    Layer a = com.airbnb.lottie.model.layer.Layer.a.a(jSONObject.optJSONObject(i), iVar);
                    if (a.e == LayerType.Image) {
                        i2++;
                    }
                    List list = iVar.f;
                    LongSparseArray longSparseArray = iVar.e;
                    list.add(a);
                    longSparseArray.put(a.d, a);
                    i++;
                }
                if (i2 > 4) {
                    jSONObject = new StringBuilder("You have ");
                    jSONObject.append(i2);
                    jSONObject.append(" images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                    iVar.a(jSONObject.toString());
                }
            }
        }

        private static void a(@Nullable JSONArray jSONArray, i iVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    JSONArray optJSONArray = optJSONObject.optJSONArray("layers");
                    if (optJSONArray != null) {
                        List arrayList = new ArrayList(optJSONArray.length());
                        LongSparseArray longSparseArray = new LongSparseArray();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            Layer a = com.airbnb.lottie.model.layer.Layer.a.a(optJSONArray.optJSONObject(i2), iVar);
                            longSparseArray.put(a.d, a);
                            arrayList.add(a);
                        }
                        iVar.a.put(optJSONObject.optString(AgooConstants.MESSAGE_ID), arrayList);
                    }
                }
            }
        }

        private static void b(@Nullable JSONArray jSONArray, i iVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject.has("p")) {
                        p pVar = new p(optJSONObject.optInt(IXAdRequestInfo.WIDTH), optJSONObject.optInt(IXAdRequestInfo.HEIGHT), optJSONObject.optString(AgooConstants.MESSAGE_ID), optJSONObject.optString("p"), optJSONObject.optString("u"));
                        iVar.b.put(pVar.a, pVar);
                    }
                }
            }
        }

        private static void b(@Nullable JSONObject jSONObject, i iVar) {
            if (jSONObject != null) {
                jSONObject = jSONObject.optJSONArray("list");
                if (jSONObject != null) {
                    int length = jSONObject.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = jSONObject.optJSONObject(i);
                        f fVar = new f(optJSONObject.optString("fFamily"), optJSONObject.optString("fName"), optJSONObject.optString("fStyle"), (float) optJSONObject.optDouble("ascent"));
                        iVar.c.put(fVar.b, fVar);
                    }
                }
            }
        }

        private static void c(@Nullable JSONArray jSONArray, i iVar) {
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    char charAt = optJSONObject.optString("ch").charAt(0);
                    int optInt = optJSONObject.optInt("size");
                    double optDouble = optJSONObject.optDouble(IXAdRequestInfo.WIDTH);
                    String optString = optJSONObject.optString("style");
                    String optString2 = optJSONObject.optString("fFamily");
                    optJSONObject = optJSONObject.optJSONObject("data");
                    List emptyList = Collections.emptyList();
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("shapes");
                        if (optJSONArray != null) {
                            emptyList = new ArrayList(optJSONArray.length());
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                emptyList.add((j) j.a(optJSONArray.optJSONObject(i2), iVar));
                            }
                        }
                    }
                    g gVar = new g(emptyList, charAt, optInt, optDouble, optString, optString2);
                    iVar.d.put(gVar.hashCode(), gVar);
                }
            }
        }
    }

    private i(Rect rect, long j, long j2, float f, float f2, int i, int i2, int i3) {
        this.a = new HashMap();
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new SparseArrayCompat();
        this.e = new LongSparseArray();
        this.f = new ArrayList();
        this.o = new HashSet();
        this.g = new s();
        this.h = rect;
        this.i = j;
        this.j = j2;
        this.p = f;
        this.k = f2;
        this.l = i;
        this.m = i2;
        this.n = i3;
        if (com.airbnb.lottie.c.g.a(this, 5) == null) {
            a("Lottie only supports bodymovin >= 4.5.0");
        }
    }

    @RestrictTo({Scope.LIBRARY})
    public final void a(String str) {
        this.o.add(str);
    }

    public final void a(boolean z) {
        this.g.a = z;
    }

    @RestrictTo({Scope.LIBRARY})
    public final Layer a(long j) {
        return (Layer) this.e.get(j);
    }

    public final long a() {
        return (long) ((((float) (this.j - this.i)) / this.p) * 1000.0f);
    }

    public final float b() {
        return (((float) a()) * this.p) / 1000.0f;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("LottieComposition:\n");
        for (Layer a : this.f) {
            stringBuilder.append(a.a("\t"));
        }
        return stringBuilder.toString();
    }
}
