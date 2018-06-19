package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;

/* compiled from: BaiduNewsViewHolder */
public final class a extends f implements c {
    private TextView a = null;
    private TaskListFeedBottomView b = null;
    private com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a c;
    private e d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private OnClickListener h = new b(this);

    public final int a() {
        return 2;
    }

    public static a a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        viewGroup = new a(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_multi_image, viewGroup, false));
        viewGroup.setAdapter(aVar);
        return viewGroup;
    }

    private a(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_title);
        this.b = (TaskListFeedBottomView) view.findViewById(R.id.bottom_view);
        this.e = (ImageView) view.findViewById(R.id.iv_poster1);
        this.f = (ImageView) view.findViewById(R.id.iv_poster2);
        this.g = (ImageView) view.findViewById(R.id.iv_poster3);
        view.setOnClickListener(this.h);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        this.d = eVar;
        if (!(eVar == null || eVar.c == null || !(eVar.c instanceof com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a))) {
            this.c = (com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a) eVar.c;
            com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a aVar = this.c;
            this.b.getSourceTV().setVisibility(0);
            this.b.getCommentCountTV().setVisibility(0);
            this.b.getCommentCountTV().setText("0评论");
            this.b.getAdSourceTagTV().setVisibility(0);
            this.b.getTmtpTV().setVisibility(8);
            this.b.getSourceTV().setText(aVar.c());
            this.b.getAdSourceTagTV().setVisibility(8);
            k.a(getContext(), (String) aVar.a.get(0), this.e, null);
            k.a(getContext(), (String) aVar.a.get(1), this.f, null);
            k.a(getContext(), (String) aVar.a.get(2), this.g, null);
            this.a.setText(aVar.d);
            if (!b.a(this.mAdapter.a(), this.c.c)) {
                b.b(this.mAdapter.a(), this.c.c);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.mAdapter.b(eVar));
                b.a(this.c.c, this.mAdapter.a(), "baidu_img", "", "baidu_img", stringBuilder.toString());
            }
        }
    }
}
