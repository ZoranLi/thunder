package com.airbnb.lottie.a;

import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.support.v4.util.SparseArrayCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.airbnb.lottie.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;

/* compiled from: Keyframe */
public class a<T> {
    private static final Interpolator f = new LinearInterpolator();
    @Nullable
    public final T a;
    @Nullable
    public final T b;
    @Nullable
    public final Interpolator c;
    public final float d;
    @Nullable
    public Float e;
    private final i g;
    private float h = Float.MIN_VALUE;
    private float i = Float.MIN_VALUE;

    /* compiled from: Keyframe */
    public static class a {
        private static SparseArrayCompat<WeakReference<Interpolator>> a;

        @Nullable
        private static WeakReference<Interpolator> a(int i) {
            WeakReference weakReference;
            synchronized (a.class) {
                if (a == null) {
                    a = new SparseArrayCompat();
                }
                weakReference = (WeakReference) a.get(i);
            }
            return weakReference;
        }

        private a() {
        }

        public static <T> com.airbnb.lottie.a.a<T> a(org.json.JSONObject r10, com.airbnb.lottie.i r11, float r12, com.airbnb.lottie.model.a.m.a<T> r13) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = "t";
            r0 = r10.has(r0);
            r1 = 0;
            if (r0 == 0) goto L_0x00cb;
        L_0x0009:
            r0 = "t";
            r2 = 0;
            r2 = r10.optDouble(r0, r2);
            r0 = (float) r2;
            r2 = "s";
            r2 = r10.opt(r2);
            if (r2 == 0) goto L_0x001f;
        L_0x001a:
            r2 = r13.a(r2, r12);
            goto L_0x0020;
        L_0x001f:
            r2 = r1;
        L_0x0020:
            r3 = "e";
            r3 = r10.opt(r3);
            if (r3 == 0) goto L_0x002d;
        L_0x0028:
            r13 = r13.a(r3, r12);
            goto L_0x002e;
        L_0x002d:
            r13 = r1;
        L_0x002e:
            r3 = "o";
            r3 = r10.optJSONObject(r3);
            r4 = "i";
            r4 = r10.optJSONObject(r4);
            if (r3 == 0) goto L_0x0047;
        L_0x003c:
            if (r4 == 0) goto L_0x0047;
        L_0x003e:
            r3 = com.airbnb.lottie.c.b.a(r3, r12);
            r4 = com.airbnb.lottie.c.b.a(r4, r12);
            goto L_0x0049;
        L_0x0047:
            r3 = r1;
            r4 = r3;
        L_0x0049:
            r5 = "h";
            r6 = 0;
            r10 = r10.optInt(r5, r6);
            r5 = 1;
            if (r10 != r5) goto L_0x0054;
        L_0x0053:
            goto L_0x0055;
        L_0x0054:
            r5 = r6;
        L_0x0055:
            if (r5 == 0) goto L_0x005d;
        L_0x0057:
            r1 = com.airbnb.lottie.a.a.f;
            goto L_0x00d0;
        L_0x005d:
            if (r3 == 0) goto L_0x00c2;
        L_0x005f:
            r10 = r3.x;
            r5 = -r12;
            r10 = com.airbnb.lottie.c.f.a(r10, r5, r12);
            r3.x = r10;
            r10 = r3.y;
            r6 = 1120403456; // 0x42c80000 float:100.0 double:5.53552857E-315;
            r7 = -1027080192; // 0xffffffffc2c80000 float:-100.0 double:NaN;
            r10 = com.airbnb.lottie.c.f.a(r10, r7, r6);
            r3.y = r10;
            r10 = r4.x;
            r10 = com.airbnb.lottie.c.f.a(r10, r5, r12);
            r4.x = r10;
            r10 = r4.y;
            r10 = com.airbnb.lottie.c.f.a(r10, r7, r6);
            r4.y = r10;
            r10 = r3.x;
            r5 = r3.y;
            r6 = r4.x;
            r7 = r4.y;
            r10 = com.airbnb.lottie.c.g.a(r10, r5, r6, r7);
            r5 = a(r10);
            if (r5 == 0) goto L_0x009c;
        L_0x0096:
            r1 = r5.get();
            r1 = (android.view.animation.Interpolator) r1;
        L_0x009c:
            if (r5 == 0) goto L_0x00a0;
        L_0x009e:
            if (r1 != 0) goto L_0x00c6;
        L_0x00a0:
            r1 = r3.x;
            r1 = r1 / r12;
            r3 = r3.y;
            r3 = r3 / r12;
            r5 = r4.x;
            r5 = r5 / r12;
            r4 = r4.y;
            r4 = r4 / r12;
            r1 = android.support.v4.view.animation.PathInterpolatorCompat.create(r1, r3, r5, r4);
            r12 = new java.lang.ref.WeakReference;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x00c6 }
            r12.<init>(r1);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x00c6 }
            r3 = com.airbnb.lottie.a.a.a.class;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x00c6 }
            monitor-enter(r3);	 Catch:{ ArrayIndexOutOfBoundsException -> 0x00c6 }
            r4 = a;	 Catch:{ all -> 0x00bf }
            r4.put(r10, r12);	 Catch:{ all -> 0x00bf }
            monitor-exit(r3);	 Catch:{ all -> 0x00bf }
            goto L_0x00c6;	 Catch:{ all -> 0x00bf }
        L_0x00bf:
            r10 = move-exception;	 Catch:{ all -> 0x00bf }
            monitor-exit(r3);	 Catch:{ all -> 0x00bf }
            throw r10;	 Catch:{ ArrayIndexOutOfBoundsException -> 0x00c6 }
        L_0x00c2:
            r1 = com.airbnb.lottie.a.a.f;
        L_0x00c6:
            r6 = r13;
            r8 = r0;
            r7 = r1;
            r5 = r2;
            goto L_0x00d4;
        L_0x00cb:
            r2 = r13.a(r10, r12);
            r0 = 0;
        L_0x00d0:
            r8 = r0;
            r7 = r1;
            r5 = r2;
            r6 = r5;
        L_0x00d4:
            r10 = new com.airbnb.lottie.a.a;
            r9 = 0;
            r3 = r10;
            r4 = r11;
            r3.<init>(r4, r5, r6, r7, r8, r9);
            return r10;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.a.a.a.a(org.json.JSONObject, com.airbnb.lottie.i, float, com.airbnb.lottie.model.a.m$a):com.airbnb.lottie.a.a<T>");
        }

        public static <T> List<a<T>> a(JSONArray jSONArray, i iVar, float f, com.airbnb.lottie.model.a.m.a<T> aVar) {
            int length = jSONArray.length();
            if (length == 0) {
                return Collections.emptyList();
            }
            List arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(a(jSONArray.optJSONObject(i), iVar, f, (com.airbnb.lottie.model.a.m.a) aVar));
            }
            a.a(arrayList);
            return arrayList;
        }
    }

    public static void a(List<? extends a<?>> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            a aVar = (a) list.get(i2);
            i2++;
            aVar.e = Float.valueOf(((a) list.get(i2)).d);
        }
        a aVar2 = (a) list.get(i);
        if (aVar2.a == null) {
            list.remove(aVar2);
        }
    }

    public a(i iVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.g = iVar;
        this.a = t;
        this.b = t2;
        this.c = interpolator;
        this.d = f;
        this.e = f2;
    }

    public final float a() {
        if (this.h == Float.MIN_VALUE) {
            this.h = (this.d - ((float) this.g.i)) / this.g.b();
        }
        return this.h;
    }

    public final float b() {
        if (this.i == Float.MIN_VALUE) {
            if (this.e == null) {
                this.i = 1.0f;
            } else {
                this.i = a() + ((this.e.floatValue() - this.d) / this.g.b());
            }
        }
        return this.i;
    }

    public final boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= a() && f < b();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Keyframe{startValue=");
        stringBuilder.append(this.a);
        stringBuilder.append(", endValue=");
        stringBuilder.append(this.b);
        stringBuilder.append(", startFrame=");
        stringBuilder.append(this.d);
        stringBuilder.append(", endFrame=");
        stringBuilder.append(this.e);
        stringBuilder.append(", interpolator=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
