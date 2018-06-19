package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.Bitmap;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: BrandADViewHolder */
final class h implements RequestListener<String, Bitmap> {
    final /* synthetic */ f a;

    public final /* bridge */ /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        return false;
    }

    h(f fVar) {
        this.a = fVar;
    }

    public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        this.a.a();
        return null;
    }
}
