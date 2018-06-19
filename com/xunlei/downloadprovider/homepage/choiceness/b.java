package com.xunlei.downloadprovider.homepage.choiceness;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.blur.XLBlur;

/* compiled from: ChoicenessImageUtil */
public final class b {
    private static final b a = new b();
    private a b = new a();

    /* compiled from: ChoicenessImageUtil */
    public interface b {
        void a(int i, int i2);
    }

    /* compiled from: ChoicenessImageUtil */
    private class a extends SimpleTarget<Bitmap> {
        final /* synthetic */ b a;
        private ImageView b;
        private float c;
        private float d;

        private a(b bVar) {
            this.a = bVar;
            this.c = 25.0f;
            this.d = 300.0f;
        }

        public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
            Bitmap bitmap = (Bitmap) obj;
            if (this.b != null) {
                XLBlur.blurBitmap(bitmap, (int) (((((float) bitmap.getWidth()) * 1.0f) * this.c) / this.d));
                this.b.setImageBitmap(bitmap);
                this.b = null;
                this.c = 25.0f;
                this.d = 300.0f;
            }
        }
    }

    public static b a() {
        return a;
    }

    private b() {
    }

    public final void a(String str, ImageView imageView, b bVar) {
        Context context = imageView.getContext();
        StringBuilder stringBuilder = new StringBuilder("displayPosterImage--startLoading--view=");
        stringBuilder.append(ViewUtil.getViewAddress(imageView));
        stringBuilder.append("|url=");
        stringBuilder.append(str);
        a(context, str).override(Integer.MIN_VALUE, Integer.MIN_VALUE).into(new c(this, imageView, bVar, imageView, str));
    }

    public static void a(String str, ImageView imageView) {
        str = Glide.with(imageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_default_avatar).error(R.drawable.feedflow_icon_default).dontAnimate();
        str.transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.a(r0)});
        str.into(imageView);
    }

    public static void a(String str, ImageView imageView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3) {
        str = Glide.with(imageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(i).fallback(i2).error(i3).dontAnimate();
        str.transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.a(r0)});
        str.into(imageView);
    }

    public final void a(Context context, ImageView imageView, String str, int i) {
        imageView.setTag(R.id.tag_image_id, null);
        Glide.with(context).load(str).placeholder(R.drawable.choiceness_icon_default).error(i).into(new e(this, imageView, str));
    }

    public static DrawableRequestBuilder<String> a(Context context, String str) {
        return Glide.with(context).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).crossFade(200);
    }
}
