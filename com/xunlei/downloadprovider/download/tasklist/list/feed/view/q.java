package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b;

/* compiled from: TouTiaoSmallImageViewHolder */
public final class q extends r {
    private ImageView e = null;

    public static q a(Context context, ViewGroup viewGroup, a aVar, f fVar) {
        if (com.xunlei.downloadprovider.download.tasklist.list.feed.f.b()) {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_left_small_image, viewGroup, false);
        } else {
            context = LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_right_small_image, viewGroup, false);
        }
        viewGroup = new q(context);
        viewGroup.setAdapter(aVar);
        viewGroup.a(fVar);
        return viewGroup;
    }

    private q(View view) {
        super(view);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.c = (TextView) this.itemView.findViewById(R.id.tv_title);
        this.e = (ImageView) this.itemView.findViewById(R.id.iv_poster);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        r.a(getContext(), (b.a) this.a.a.r.get(0), this.e, n.a());
    }
}
