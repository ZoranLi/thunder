package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.n;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.choiceness.j;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: WebsiteViewHolder */
public final class v extends f implements c {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private n f;
    private WebsiteInfo g;
    private VideoUserInfo h;
    private e i;

    public final int a() {
        return 2;
    }

    public static v a(Context context, ViewGroup viewGroup, a aVar) {
        viewGroup = new v(LayoutInflater.from(context).inflate(com.xunlei.downloadprovider.download.tasklist.list.feed.f.b() ? R.layout.layout_task_list_feed_template_website_poster_left : R.layout.layout_task_list_feed_template_website_poster_right, viewGroup, false));
        viewGroup.setAdapter(aVar);
        return viewGroup;
    }

    private v(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_publisher);
        this.b = (TextView) view.findViewById(R.id.tv_title);
        this.c = (TextView) view.findViewById(R.id.tv_url);
        this.d = (TextView) view.findViewById(R.id.tv_comment_count);
        this.e = (ImageView) view.findViewById(R.id.iv_poster);
        view.setOnClickListener(new w(this));
        this.a.setOnClickListener(new x(this));
    }

    public final void fillData(e eVar) {
        this.i = eVar;
        this.f = (n) eVar.c;
        this.g = this.f.a;
        this.h = this.f.b;
        TextView textView = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.h.getNickname());
        stringBuilder.append("分享了链接");
        textView.setText(stringBuilder.toString());
        this.b.setText(this.g.e);
        this.c.setText(this.g.f);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(j.a((long) this.g.l));
        stringBuilder2.append("评论");
        this.d.setText(stringBuilder2.toString());
        b.a().a(getContext(), this.e, this.g.g, R.drawable.ic_website_default_vertical_pic);
        int a = this.mAdapter.a();
        stringBuilder = new StringBuilder("website");
        stringBuilder.append(this.f.b());
        if (!com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(a, stringBuilder.toString())) {
            a = this.mAdapter.a();
            stringBuilder = new StringBuilder("website");
            stringBuilder.append(this.f.b());
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(a, stringBuilder.toString());
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(this.f, this.mAdapter.b(eVar), this.mAdapter.a());
        }
    }

    static /* synthetic */ BrowserFrom a(int i) {
        if (com.xunlei.downloadprovider.download.b.b.c()) {
            return BrowserFrom.DL_CENTER_HOME;
        }
        switch (i) {
            case 1:
                return BrowserFrom.DL_CENTER_DOWNLOADING;
            case 2:
                return BrowserFrom.DL_CENTER_COMPLETE;
            default:
                return BrowserFrom.DL_CENTER_ALL;
        }
    }

    static /* synthetic */ String b(int i) {
        if (com.xunlei.downloadprovider.download.b.b.c()) {
            return "dl_home";
        }
        switch (i) {
            case 1:
                return "dl_dloading";
            case 2:
                return "dl_complete";
            default:
                return "dl_all";
        }
    }
}
