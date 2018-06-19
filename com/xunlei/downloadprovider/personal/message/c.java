package com.xunlei.downloadprovider.personal.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;

/* compiled from: MessageCenterGlideBuilders */
public final class c {
    public static BitmapRequestBuilder<String, Bitmap> a(Context context, String str) {
        return Glide.with(context).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate();
    }

    public static void a(Context context, String str, ImageView imageView) {
        a(context, str).placeholder(R.drawable.ic_website_default_vertical_pic).error(R.drawable.ic_website_default_vertical_pic).fallback(R.drawable.ic_website_default_vertical_pic).listener(null).into(imageView);
    }
}
