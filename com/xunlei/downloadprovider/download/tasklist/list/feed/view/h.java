package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.b;

/* compiled from: PhotoArticleSmallImageViewHolder */
public final class h extends i {
    private ImageView c = null;

    public static h a(Context context, ViewGroup viewGroup, a aVar) {
        if (f.b()) {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_left_small_image, viewGroup, false);
        } else {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_right_small_image, viewGroup, false);
        }
        return new h(context, aVar);
    }

    private h(View view, a aVar) {
        super(view, aVar);
        this.c = (ImageView) view.findViewById(R.id.iv_poster);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        b.a().a((String) ((c) eVar.c).a.e.get(0), this.c, null);
    }
}
