package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestListener;
import com.xunlei.downloadprovider.ad.common.f;
import java.util.List;

/* compiled from: MultiUrlImageDisplayer */
public final class d {

    /* compiled from: MultiUrlImageDisplayer */
    public static class a {
        a a = null;
        private String b = null;
        private a c = null;

        /* compiled from: MultiUrlImageDisplayer */
        public interface a {
            void a(Context context, String str, ImageView imageView, RequestListener<String, Bitmap> requestListener);
        }

        public a(String str, a aVar) {
            this.b = str;
            this.c = aVar;
        }

        public final void a(Context context, ImageView imageView) {
            if (!f.a(context)) {
                this.c.a(context, this.b, imageView, new e(this, imageView, context));
            }
        }
    }

    protected static void a(Context context, List<String> list, ImageView imageView, a aVar) {
        if (!list.isEmpty()) {
            a aVar2 = new a((String) list.get(0), aVar);
            int i = 1;
            a aVar3 = aVar2;
            while (i < list.size()) {
                a aVar4 = new a((String) list.get(i), aVar);
                aVar3.a = aVar4;
                i++;
                aVar3 = aVar4;
            }
            aVar2.a(context, imageView);
        }
    }
}
