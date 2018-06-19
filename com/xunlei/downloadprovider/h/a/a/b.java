package com.xunlei.downloadprovider.h.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/* compiled from: PlayRecordPosterImageTransform */
public class b extends BitmapTransformation {
    private static final String a = "com.xunlei.downloadprovider.h.a.a.b";
    private float b;

    public b(Context context) {
        super(context);
        this.b = null;
        this.b = Resources.getSystem().getDisplayMetrics().density * 4.0f;
    }

    public String getId() {
        return a;
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        if (width > height) {
            f = (-height) * 0.2f;
            height -= (2.0f * height) * 0.2f;
            f2 = ((float) i2) / height;
            width = -((width * 0.2f) + (((width - ((2.0f * width) * 0.2f)) - height) / 2.0f));
        } else {
            f2 = ((float) i) / width;
            f = (-(height - width)) / 2.0f;
            width = 0.0f;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f2, f2);
        bitmapPool = bitmapPool.get(i, i2, Config.ARGB_8888);
        if (bitmapPool == null) {
            bitmapPool = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmapPool);
        Paint paint = new Paint(1);
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) i, (float) i2), this.b, this.b, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.concat(matrix);
        canvas.drawBitmap(bitmap, width, f, paint);
        paint.setXfermode(null);
        return bitmapPool;
    }
}
