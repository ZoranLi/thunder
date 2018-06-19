package com.bumptech.glide.request.animation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;

public class BitmapCrossFadeFactory extends BitmapContainerCrossFadeFactory<Bitmap> {
    protected Bitmap getBitmap(Bitmap bitmap) {
        return bitmap;
    }

    public BitmapCrossFadeFactory(int i) {
        super(i);
    }

    public BitmapCrossFadeFactory(Context context, int i, int i2) {
        super(context, i, i2);
    }

    public BitmapCrossFadeFactory(Animation animation, int i) {
        super(animation, i);
    }

    public BitmapCrossFadeFactory(GlideAnimationFactory<Drawable> glideAnimationFactory) {
        super((GlideAnimationFactory) glideAnimationFactory);
    }
}
