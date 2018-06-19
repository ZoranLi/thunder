package com.xunlei.downloadprovider.h.a.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: AvatarRoundCrop */
public class a extends BitmapTransformation {
    private static final String a = "com.xunlei.downloadprovider.h.a.a.a";
    private float b = 1.0f;

    public a(Context context) {
        super(context);
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        float f;
        float f2;
        bitmapPool = this.b;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f3 = (float) i;
        int i3 = ((int) (f3 * bitmapPool)) + 3;
        if (width > height) {
            f = (float) i3;
            f2 = (float) height;
        } else {
            f = (float) i3;
            f2 = (float) width;
        }
        f /= f2;
        float f4 = (f3 - (((float) width) * f)) * PayBaseConstants.HALF_OF_FLOAT;
        float f5 = (float) i2;
        float f6 = (f5 - (((float) height) * f)) * PayBaseConstants.HALF_OF_FLOAT;
        Matrix matrix = new Matrix();
        matrix.setScale(f, f);
        matrix.postTranslate((float) ((int) (f4 + PayBaseConstants.HALF_OF_FLOAT)), (float) ((int) (f6 + PayBaseConstants.HALF_OF_FLOAT)));
        i = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        i2 = new Canvas(i);
        Paint paint = new Paint(1);
        i2.drawCircle(f3 / 2.0f, f5 / 2.0f, (f5 * bitmapPool) / 2.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        i2.concat(matrix);
        i2.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        paint.setXfermode(null);
        return i;
    }

    public String getId() {
        return a;
    }
}
