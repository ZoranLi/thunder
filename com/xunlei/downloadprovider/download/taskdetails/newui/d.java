package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;

/* compiled from: DetailsTitleHeaderBar */
public final class d {
    TextView a;
    com.xunlei.downloadprovider.download.taskdetails.widget.a b;
    DownloadTaskInfo c;
    a d;
    private View e;
    private View f;
    private View g;
    private View h;

    /* compiled from: DetailsTitleHeaderBar */
    public interface a {
        void a();

        void a(int i);
    }

    public d(View view) {
        this.e = view;
        this.f = view.findViewById(R.id.close_btn);
        this.f.setOnClickListener(new e(this));
        this.h = view.findViewById(R.id.detail_title_right_icon);
        this.h.setOnClickListener(new f(this));
        this.g = view.findViewById(R.id.detail_title_share_icon);
        this.g.setOnClickListener(new g(this));
        this.a = (TextView) view.findViewById(R.id.top_bar_title);
    }

    public final void a(int i) {
        this.e.setVisibility(i);
    }

    public final void a(Context context) {
        com.xunlei.downloadprovider.download.report.a.a("dl_more", this.c);
        if (this.b != null) {
            if (this.b.isShowing()) {
                this.b.dismiss();
            }
            this.b = null;
        }
        this.b = new com.xunlei.downloadprovider.download.taskdetails.widget.a(context);
        this.b.c = new h(this);
        this.b.a = new i(this);
        this.b.b = new j(this);
        this.b.d = new k(this);
        this.b.a(this.c);
        this.b.show();
    }
}
