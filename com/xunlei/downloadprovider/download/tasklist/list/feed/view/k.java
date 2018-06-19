package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.c;

/* compiled from: TaskListFeedGlideBuilders */
public final class k {
    public static void a(Context context, String str, ImageView imageView, @Nullable RequestListener<String, Bitmap> requestListener) {
        c.a(context, str).placeholder(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).listener(requestListener).into(imageView);
    }
}
