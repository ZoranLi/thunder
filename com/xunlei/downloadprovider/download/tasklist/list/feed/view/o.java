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

/* compiled from: TouTiaoLargeImageViewHolder */
public final class o extends r {
    private ImageView e = null;

    public static o a(Context context, ViewGroup viewGroup, a aVar, f fVar) {
        viewGroup = new o(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_large_image, viewGroup, false));
        viewGroup.setAdapter(aVar);
        viewGroup.a(fVar);
        return viewGroup;
    }

    private o(View view) {
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
