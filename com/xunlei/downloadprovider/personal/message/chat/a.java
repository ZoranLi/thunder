package com.xunlei.downloadprovider.personal.message.chat;

import android.content.Context;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.c;

/* compiled from: ChatGlideBuilders */
public final class a {
    public static void a(Context context, String str, ImageView imageView) {
        c.a(context, str).placeholder(R.drawable.ic_default_avatar_new).error(R.drawable.ic_default_avatar_new).fallback(R.drawable.ic_default_avatar_new).into(imageView);
    }
}
