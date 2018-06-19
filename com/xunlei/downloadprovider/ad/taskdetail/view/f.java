package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.graphics.Bitmap;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: TaskDetailBannerAdView */
final class f implements RequestListener<String, Bitmap> {
    final /* synthetic */ d a;

    f(d dVar) {
        this.a = dVar;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        Bitmap bitmap = (Bitmap) obj;
        String str = (String) obj2;
        d.e;
        if (this.a.b == null || this.a.b.l().equals(str) == null) {
            this.a.d();
        } else {
            this.a.c.setImageBitmap(bitmap);
            this.a.i();
            this.a.h();
        }
        return true;
    }

    public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        d.e;
        new StringBuilder("onException e: ").append(exception == null ? "null" : exception.getLocalizedMessage());
        this.a.d();
        return true;
    }
}
