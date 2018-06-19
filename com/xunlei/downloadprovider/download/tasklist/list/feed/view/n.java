package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.d.a.a;

/* compiled from: TouTiaoImageLoader */
public final class n implements a {
    private static n a;

    private n() {
    }

    public static n a() {
        if (a == null) {
            a = new n();
        }
        return a;
    }

    public final void a(Context context, String str, ImageView imageView, RequestListener<String, Bitmap> requestListener) {
        k.a(context, str, imageView, requestListener);
    }
}
