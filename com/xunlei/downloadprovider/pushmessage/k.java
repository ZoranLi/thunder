package com.xunlei.downloadprovider.pushmessage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.xunlei.downloadprovider.pushmessage.biz.BasePushBiz;

/* compiled from: PushResultDispatcher */
final class k extends SimpleTarget<Bitmap> {
    final /* synthetic */ Context a;
    final /* synthetic */ BasePushBiz b;

    k(Context context, BasePushBiz basePushBiz) {
        this.a = context;
        this.b = basePushBiz;
    }

    public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        Bitmap bitmap = (Bitmap) obj;
        if (h.a() == this) {
            h.b();
        }
        m.a(this.a, this.b, bitmap);
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        super.onLoadFailed(exception, drawable);
        if (h.a() == this) {
            h.b();
        }
        m.a(this.a, this.b, null);
    }
}
