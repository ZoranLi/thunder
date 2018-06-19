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

/* compiled from: TouTiaoMultiImageViewHolder */
public final class p extends r {
    private ImageView e = null;
    private ImageView f = null;
    private ImageView g = null;

    public static p a(Context context, ViewGroup viewGroup, a aVar, f fVar) {
        viewGroup = new p(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_multi_image, viewGroup, false));
        viewGroup.setAdapter(aVar);
        viewGroup.a(fVar);
        return viewGroup;
    }

    private p(View view) {
        super(view);
        b();
        c();
    }

    protected final void b() {
        super.b();
        this.c = (TextView) this.itemView.findViewById(R.id.tv_title);
        this.e = (ImageView) this.itemView.findViewById(R.id.iv_poster1);
        this.f = (ImageView) this.itemView.findViewById(R.id.iv_poster2);
        this.g = (ImageView) this.itemView.findViewById(R.id.iv_poster3);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        eVar = this.a.a.r;
        b.a aVar = (b.a) eVar.get(0);
        b.a aVar2 = (b.a) eVar.get(1);
        b.a aVar3 = (b.a) eVar.get(2);
        r.a(getContext(), aVar, this.e, n.a());
        r.a(getContext(), aVar2, this.f, n.a());
        r.a(getContext(), aVar3, this.g, n.a());
    }
}
