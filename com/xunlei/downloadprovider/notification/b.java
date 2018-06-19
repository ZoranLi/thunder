package com.xunlei.downloadprovider.notification;

import android.graphics.Bitmap;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/* compiled from: DownloadADNotification */
final class b extends SimpleTarget<Bitmap> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        this.a.c.b.put(Integer.valueOf((int) this.a.b.getTaskId()), (Bitmap) obj);
        this.a.c.a(this.a.b);
    }
}
