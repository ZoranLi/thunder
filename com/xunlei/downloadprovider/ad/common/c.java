package com.xunlei.downloadprovider.ad.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.BitmapRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.downloadprovider.R;

/* compiled from: ADGlideBuilders */
public final class c {
    public static BitmapRequestBuilder<String, Bitmap> a(Context context, String str) {
        return Glide.with(context).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate();
    }

    public static BitmapRequestBuilder<String, Bitmap> b(Context context, String str) {
        return a(context, str).transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.c(context, 3)});
    }

    public static void a(Context context, String str, ImageView imageView) {
        a(context, str).placeholder(R.drawable.guide_bind_default_apk_icon).error(R.drawable.guide_bind_default_apk_icon).fallback(R.drawable.guide_bind_default_apk_icon).listener(null).into(imageView);
    }

    public static void b(Context context, String str, ImageView imageView) {
        a(context, str).placeholder(R.drawable.download_ad_background).error(R.drawable.download_ad_background).fallback(R.drawable.download_ad_background).listener(null).into(imageView);
    }

    public static void a(Context context, Object obj, ImageView imageView) {
        if (obj instanceof Integer) {
            Glide.with(context).load((Integer) obj).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().placeholder(R.drawable.splash_ad_source_icon_xunlei).error(R.drawable.splash_ad_source_icon_xunlei).fallback(R.drawable.splash_ad_source_icon_xunlei).listener(null).into(imageView);
        } else if (obj instanceof String) {
            a(context, (String) obj).placeholder(R.drawable.splash_ad_source_icon_xunlei).error(R.drawable.splash_ad_source_icon_xunlei).fallback(R.drawable.splash_ad_source_icon_xunlei).listener(null).into(imageView);
        } else {
            a(context, "").placeholder(R.drawable.splash_ad_source_icon_xunlei).error(R.drawable.splash_ad_source_icon_xunlei).fallback(R.drawable.splash_ad_source_icon_xunlei).listener(null).into(imageView);
        }
    }
}
