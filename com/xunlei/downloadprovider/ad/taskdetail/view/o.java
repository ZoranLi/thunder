package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.graphics.Bitmap;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: TaskDetailThemeAdView */
final class o implements RequestListener<String, Bitmap> {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        Bitmap bitmap = (Bitmap) obj;
        String str = (String) obj2;
        if (bitmap == null || this.a.b == null || str.equals(this.a.d(this.a.b)) == null) {
            this.a.d();
        } else {
            this.a.c.setImageBitmap(bitmap);
            this.a.setVisibility(null);
            if (this.a.g() != null) {
                this.a.b(this.a.b);
            }
        }
        return true;
    }

    public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        this.a.d();
        return true;
    }
}
