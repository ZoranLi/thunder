package com.airbnb.lottie.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.airbnb.lottie.c;
import com.airbnb.lottie.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: ImageAssetManager */
public final class b {
    public final Context a;
    @Nullable
    public c b;
    private String c;
    private final Map<String, p> d;
    private final Map<String, Bitmap> e = new HashMap();

    public b(Callback callback, String str, c cVar, Map<String, p> map) {
        this.c = str;
        if (TextUtils.isEmpty(str) == null && this.c.charAt(this.c.length() - 1) != 47) {
            str = new StringBuilder();
            str.append(this.c);
            str.append('/');
            this.c = str.toString();
        }
        if ((callback instanceof View) == null) {
            this.d = new HashMap();
            this.a = null;
            return;
        }
        this.a = ((View) callback).getContext();
        this.d = map;
        this.b = cVar;
    }

    @android.support.annotation.Nullable
    public final android.graphics.Bitmap a(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r5.e;
        r0 = r0.get(r6);
        r0 = (android.graphics.Bitmap) r0;
        if (r0 != 0) goto L_0x006c;
    L_0x000a:
        r0 = r5.d;
        r0 = r0.get(r6);
        r0 = (com.airbnb.lottie.p) r0;
        r1 = 0;
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return r1;
    L_0x0016:
        r2 = r5.b;
        if (r2 == 0) goto L_0x0028;
    L_0x001a:
        r0 = r5.b;
        r0 = r0.a();
        if (r0 == 0) goto L_0x0027;
    L_0x0022:
        r1 = r5.e;
        r1.put(r6, r0);
    L_0x0027:
        return r0;
    L_0x0028:
        r2 = r5.c;	 Catch:{ IOException -> 0x006b }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ IOException -> 0x006b }
        if (r2 == 0) goto L_0x0038;	 Catch:{ IOException -> 0x006b }
    L_0x0030:
        r6 = new java.lang.IllegalStateException;	 Catch:{ IOException -> 0x006b }
        r0 = "You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder";	 Catch:{ IOException -> 0x006b }
        r6.<init>(r0);	 Catch:{ IOException -> 0x006b }
        throw r6;	 Catch:{ IOException -> 0x006b }
    L_0x0038:
        r2 = r5.a;	 Catch:{ IOException -> 0x006b }
        r2 = r2.getAssets();	 Catch:{ IOException -> 0x006b }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006b }
        r3.<init>();	 Catch:{ IOException -> 0x006b }
        r4 = r5.c;	 Catch:{ IOException -> 0x006b }
        r3.append(r4);	 Catch:{ IOException -> 0x006b }
        r0 = r0.b;	 Catch:{ IOException -> 0x006b }
        r3.append(r0);	 Catch:{ IOException -> 0x006b }
        r0 = r3.toString();	 Catch:{ IOException -> 0x006b }
        r0 = r2.open(r0);	 Catch:{ IOException -> 0x006b }
        r2 = new android.graphics.BitmapFactory$Options;
        r2.<init>();
        r3 = 1;
        r2.inScaled = r3;
        r3 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r2.inDensity = r3;
        r0 = android.graphics.BitmapFactory.decodeStream(r0, r1, r2);
        r1 = r5.e;
        r1.put(r6, r0);
        goto L_0x006c;
    L_0x006b:
        return r1;
    L_0x006c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.b.b.a(java.lang.String):android.graphics.Bitmap");
    }

    public final void a() {
        Iterator it = this.e.entrySet().iterator();
        while (it.hasNext()) {
            ((Bitmap) ((Entry) it.next()).getValue()).recycle();
            it.remove();
        }
    }
}
