package com.xunlei.downloadprovider.h.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/* compiled from: RoundCornerTransform */
public class c extends BitmapTransformation {
    private static final String a = "com.xunlei.downloadprovider.h.a.a.c";
    private float b = null;

    public c(Context context, int i) {
        super(context);
        this.b = Resources.getSystem().getDisplayMetrics().density * ((float) i);
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        i = this.b;
        if (bitmap == null) {
            return null;
        }
        bitmapPool = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        if (bitmapPool == null) {
            bitmapPool = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        }
        i2 = new Canvas(bitmapPool);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, TileMode.CLAMP, TileMode.CLAMP));
        paint.setAntiAlias(true);
        i2.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), i, i, paint);
        return bitmapPool;
    }

    public String getId() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(Math.round(this.b));
        return stringBuilder.toString();
    }
}
