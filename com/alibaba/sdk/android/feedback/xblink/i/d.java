package com.alibaba.sdk.android.feedback.xblink.i;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.ExifInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class d {
    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            return attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : 180;
        } catch (IOException e) {
            g.b("ImageTool", String.valueOf(e));
            return 0;
        }
    }

    public static android.graphics.Bitmap a(android.graphics.Bitmap r7, int r8) {
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
        if (r8 == 0) goto L_0x0023;
    L_0x0002:
        if (r7 == 0) goto L_0x0023;
    L_0x0004:
        r5 = new android.graphics.Matrix;
        r5.<init>();
        r8 = (float) r8;
        r5.postRotate(r8);
        r1 = 0;
        r2 = 0;
        r3 = r7.getWidth();	 Catch:{ OutOfMemoryError -> 0x0023 }
        r4 = r7.getHeight();	 Catch:{ OutOfMemoryError -> 0x0023 }
        r6 = 1;	 Catch:{ OutOfMemoryError -> 0x0023 }
        r0 = r7;	 Catch:{ OutOfMemoryError -> 0x0023 }
        r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ OutOfMemoryError -> 0x0023 }
        if (r7 == r8) goto L_0x0023;	 Catch:{ OutOfMemoryError -> 0x0023 }
    L_0x001f:
        r7.recycle();	 Catch:{ OutOfMemoryError -> 0x0023 }
        r7 = r8;
    L_0x0023:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.i.d.a(android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static Bitmap a(String str, int i) {
        if (i > 1024) {
            i = 1024;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        i = Math.round(((float) (options.outHeight > options.outWidth ? options.outHeight : options.outWidth)) / ((float) i));
        if (i <= 0) {
            i = 1;
        }
        options.inSampleSize = i;
        options.inJustDecodeBounds = false;
        if (decodeFile != null) {
            decodeFile.recycle();
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static android.graphics.drawable.Drawable a(android.content.res.Resources r2, java.lang.String r3) {
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
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 0;
        r3 = android.util.Base64.decode(r3, r1);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ IllegalArgumentException -> 0x0018 }
        r1.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r3 = android.graphics.BitmapFactory.decodeStream(r1);	 Catch:{ IllegalArgumentException -> 0x0018 }
        r1 = new android.graphics.drawable.BitmapDrawable;	 Catch:{ IllegalArgumentException -> 0x0018 }
        r1.<init>(r2, r3);	 Catch:{ IllegalArgumentException -> 0x0018 }
        return r1;
    L_0x0018:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.i.d.a(android.content.res.Resources, java.lang.String):android.graphics.drawable.Drawable");
    }

    public static byte[] a(Bitmap bitmap, CompressFormat compressFormat) {
        if (bitmap == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 70, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
