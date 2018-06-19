package com.xunlei.common.androidutil;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

public class BitmapUtil {
    public static Bitmap scaleBitmap(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap createBitmapWithDrawable(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static void saveBitmapToFile(java.io.File r2, android.graphics.Bitmap r3, android.graphics.Bitmap.CompressFormat r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 == 0) goto L_0x0049;
    L_0x0002:
        if (r3 != 0) goto L_0x0005;
    L_0x0004:
        goto L_0x0049;
    L_0x0005:
        r0 = 0;
        r1 = r2.exists();	 Catch:{ Exception -> 0x003d, all -> 0x0031 }
        if (r1 != 0) goto L_0x000f;	 Catch:{ Exception -> 0x003d, all -> 0x0031 }
    L_0x000c:
        r2.createNewFile();	 Catch:{ Exception -> 0x003d, all -> 0x0031 }
    L_0x000f:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x003d, all -> 0x0031 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x003d, all -> 0x0031 }
        r2 = android.graphics.Bitmap.createBitmap(r3);	 Catch:{ Exception -> 0x002f, all -> 0x002c }
        r3 = 100;	 Catch:{ Exception -> 0x002f, all -> 0x002c }
        r2 = r2.compress(r4, r3, r1);	 Catch:{ Exception -> 0x002f, all -> 0x002c }
        if (r2 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x002f, all -> 0x002c }
    L_0x0020:
        r1.flush();	 Catch:{ Exception -> 0x002f, all -> 0x002c }
    L_0x0023:
        r1.close();	 Catch:{ IOException -> 0x0027 }
        return;
    L_0x0027:
        r2 = move-exception;
        r2.printStackTrace();
        return;
    L_0x002c:
        r2 = move-exception;
        r0 = r1;
        goto L_0x0032;
    L_0x002f:
        r0 = r1;
        goto L_0x003d;
    L_0x0031:
        r2 = move-exception;
    L_0x0032:
        if (r0 == 0) goto L_0x003c;
    L_0x0034:
        r0.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x003c;
    L_0x0038:
        r3 = move-exception;
        r3.printStackTrace();
    L_0x003c:
        throw r2;
    L_0x003d:
        if (r0 == 0) goto L_0x0048;
    L_0x003f:
        r0.close();	 Catch:{ IOException -> 0x0043 }
        return;
    L_0x0043:
        r2 = move-exception;
        r2.printStackTrace();
        return;
    L_0x0048:
        return;
    L_0x0049:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.BitmapUtil.saveBitmapToFile(java.io.File, android.graphics.Bitmap, android.graphics.Bitmap$CompressFormat):void");
    }
}
