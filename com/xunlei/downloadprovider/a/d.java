package com.xunlei.downloadprovider.a;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

/* compiled from: ActivityDlg */
final class d implements RequestListener<String, GlideDrawable> {
    final /* synthetic */ ImageView a;
    final /* synthetic */ b b;

    public final /* bridge */ /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        return false;
    }

    d(b bVar, ImageView imageView) {
        this.b = bVar;
        this.a = imageView;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        GlideDrawable glideDrawable = (GlideDrawable) obj;
        this.b.b = true;
        this.a.setImageDrawable(glideDrawable);
        if (this.b.c != null) {
            this.b.show();
        }
        return true;
    }
}
