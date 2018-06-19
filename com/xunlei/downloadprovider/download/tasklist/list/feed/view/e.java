package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.d.a;

/* compiled from: MultiUrlImageDisplayer */
final class e implements RequestListener<String, Bitmap> {
    final /* synthetic */ ImageView a;
    final /* synthetic */ Context b;
    final /* synthetic */ a c;

    e(a aVar, ImageView imageView, Context context) {
        this.c = aVar;
        this.a = imageView;
        this.b = context;
    }

    public final /* synthetic */ boolean onException(Exception exception, Object obj, Target target, boolean z) {
        String str = (String) obj;
        target = new StringBuilder("display onException. imageView.id: ");
        target.append(this.a.getId());
        target.append(" imageUrl: ");
        target.append(str);
        target.append(" e: ");
        if (exception == null) {
            exception = "null";
        } else {
            exception = exception.getLocalizedMessage();
        }
        target.append(exception);
        target.append(" isFirstResource: ");
        target.append(z);
        if (this.c.a != null) {
            this.c.a.a(this.b, this.a);
        }
        return true;
    }

    public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, Target target, boolean z, boolean z2) {
        String str = (String) obj2;
        obj = new StringBuilder("display onResourceReady. imageView.id: ");
        obj.append(this.a.getId());
        obj.append(" imageUrl: ");
        obj.append(str);
        obj.append(" isFromMemoryCache: ");
        obj.append(z);
        obj.append(" isFirstResource: ");
        obj.append(z2);
        return null;
    }
}
