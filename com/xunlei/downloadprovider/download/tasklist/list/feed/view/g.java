package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;
import com.xunlei.downloadprovider.homepage.choiceness.b;

/* compiled from: PhotoArticleMultiImageViewHolder */
public final class g extends i {
    private ImageView c = null;
    private ImageView d = null;
    private ImageView e = null;

    public static g a(Context context, ViewGroup viewGroup, a aVar) {
        return new g(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_multi_image, viewGroup, false), aVar);
    }

    private g(View view, a aVar) {
        super(view, aVar);
        this.c = (ImageView) view.findViewById(R.id.iv_poster1);
        this.d = (ImageView) view.findViewById(R.id.iv_poster2);
        this.e = (ImageView) view.findViewById(R.id.iv_poster3);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        eVar = ((c) eVar.c).a.e;
        b a = b.a();
        a.a((String) eVar.get(0), this.c, null);
        a.a((String) eVar.get(1), this.d, null);
        a.a((String) eVar.get(2), this.e, null);
    }
}
