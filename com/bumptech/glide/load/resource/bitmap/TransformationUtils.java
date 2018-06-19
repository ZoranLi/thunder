package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

public final class TransformationUtils {
    public static final int PAINT_FLAGS = 6;
    private static final String TAG = "TransformationUtils";

    public static int getExifOrientationDegrees(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    private TransformationUtils() {
    }

    public static Bitmap centerCrop(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        float f = 0.0f;
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap2.getHeight());
            width = (((float) i) - (((float) bitmap2.getWidth()) * height)) * PayBaseConstants.HALF_OF_FLOAT;
        } else {
            height = ((float) i) / ((float) bitmap2.getWidth());
            f = (((float) i2) - (((float) bitmap2.getHeight()) * height)) * PayBaseConstants.HALF_OF_FLOAT;
            width = 0.0f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + PayBaseConstants.HALF_OF_FLOAT)), (float) ((int) (f + PayBaseConstants.HALF_OF_FLOAT)));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, getSafeConfig(bitmap2));
        }
        setAlpha(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap fitCenter(Bitmap bitmap, BitmapPool bitmapPool, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
        int width = (int) (((float) bitmap.getWidth()) * min);
        int height = (int) (((float) bitmap.getHeight()) * min);
        if (bitmap.getWidth() == width && bitmap.getHeight() == height) {
            return bitmap;
        }
        Config safeConfig = getSafeConfig(bitmap);
        bitmapPool = bitmapPool.get(width, height, safeConfig);
        if (bitmapPool == null) {
            bitmapPool = Bitmap.createBitmap(width, height, safeConfig);
        }
        setAlpha(bitmap, bitmapPool);
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder stringBuilder = new StringBuilder("request: ");
            stringBuilder.append(i);
            stringBuilder.append("x");
            stringBuilder.append(i2);
            i = new StringBuilder("toFit:   ");
            i.append(bitmap.getWidth());
            i.append("x");
            i.append(bitmap.getHeight());
            i = new StringBuilder("toReuse: ");
            i.append(bitmapPool.getWidth());
            i.append("x");
            i.append(bitmapPool.getHeight());
        }
        i = new Canvas(bitmapPool);
        i2 = new Matrix();
        i2.setScale(min, min);
        i.drawBitmap(bitmap, i2, new Paint(6));
        return bitmapPool;
    }

    @TargetApi(12)
    public static void setAlpha(Bitmap bitmap, Bitmap bitmap2) {
        if (VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }

    @android.annotation.TargetApi(5)
    @java.lang.Deprecated
    public static int getOrientation(java.lang.String r2) {
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
        r1 = new android.media.ExifInterface;	 Catch:{ Exception -> 0x0011 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0011 }
        r2 = "Orientation";	 Catch:{ Exception -> 0x0011 }
        r2 = r1.getAttributeInt(r2, r0);	 Catch:{ Exception -> 0x0011 }
        r2 = getExifOrientationDegrees(r2);	 Catch:{ Exception -> 0x0011 }
        return r2;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.TransformationUtils.getOrientation(java.lang.String):int");
    }

    @Deprecated
    public static Bitmap orientImage(String str, Bitmap bitmap) {
        return rotateImage(bitmap, getOrientation(str));
    }

    public static android.graphics.Bitmap rotateImage(android.graphics.Bitmap r7, int r8) {
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
        if (r8 == 0) goto L_0x001c;
    L_0x0002:
        r5 = new android.graphics.Matrix;	 Catch:{ Exception -> 0x001c }
        r5.<init>();	 Catch:{ Exception -> 0x001c }
        r8 = (float) r8;	 Catch:{ Exception -> 0x001c }
        r5.setRotate(r8);	 Catch:{ Exception -> 0x001c }
        r1 = 0;	 Catch:{ Exception -> 0x001c }
        r2 = 0;	 Catch:{ Exception -> 0x001c }
        r3 = r7.getWidth();	 Catch:{ Exception -> 0x001c }
        r4 = r7.getHeight();	 Catch:{ Exception -> 0x001c }
        r6 = 1;	 Catch:{ Exception -> 0x001c }
        r0 = r7;	 Catch:{ Exception -> 0x001c }
        r8 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x001c }
        r7 = r8;
    L_0x001c:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImage(android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static Bitmap rotateImageExif(Bitmap bitmap, BitmapPool bitmapPool, int i) {
        Matrix matrix = new Matrix();
        initializeMatrixForRotation(i, matrix);
        if (matrix.isIdentity() != 0) {
            return bitmap;
        }
        i = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(i);
        int round = Math.round(i.width());
        int round2 = Math.round(i.height());
        Config safeConfig = getSafeConfig(bitmap);
        bitmapPool = bitmapPool.get(round, round2, safeConfig);
        if (bitmapPool == null) {
            bitmapPool = Bitmap.createBitmap(round, round2, safeConfig);
        }
        matrix.postTranslate(-i.left, -i.top);
        new Canvas(bitmapPool).drawBitmap(bitmap, matrix, new Paint(6));
        return bitmapPool;
    }

    private static Config getSafeConfig(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    static void initializeMatrixForRotation(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                return;
            case 3:
                matrix.setRotate(180.0f);
                return;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 6:
                matrix.setRotate(90.0f);
                return;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                return;
            case 8:
                matrix.setRotate(-90.0f);
                break;
            default:
                break;
        }
    }
}
