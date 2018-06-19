package com.xunlei.downloadprovider.ad.a.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.TaskListFeedBottomView;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.view.k;

/* compiled from: FeedLargeImgHolder */
public final class a extends f implements c {
    private ImageView a = null;
    private TextView b = null;
    private TaskListFeedBottomView c = null;
    private l d;
    private e e;
    private OnClickListener f = new b(this);

    public final int a() {
        return 2;
    }

    private a(View view) {
        super(view);
        this.b = (TextView) view.findViewById(R.id.tv_title);
        this.a = (ImageView) view.findViewById(R.id.iv_poster);
        this.c = (TaskListFeedBottomView) view.findViewById(R.id.bottom_view);
        view.setOnClickListener(this.f);
    }

    public static a a(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.tasklist.list.a aVar) {
        viewGroup = new a(LayoutInflater.from(context).inflate(R.layout.layout_task_list_feed_template_large_image, viewGroup, false));
        viewGroup.setAdapter(aVar);
        return viewGroup;
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        this.e = eVar;
        if (!(eVar == null || eVar.c == null || !(eVar.c instanceof l))) {
            this.d = (l) eVar.c;
            l lVar = this.d;
            this.c.getSourceTV().setVisibility(0);
            this.c.getCommentCountTV().setVisibility(8);
            this.c.getAdSourceTagTV().setVisibility(0);
            this.c.getTmtpTV().setVisibility(8);
            this.c.getSourceTV().setText(lVar.j());
            this.c.getAdSourceTagTV().setText(com.xunlei.downloadprovider.ad.common.f.a(lVar, R.string.choiceness_ad_source_guanggao));
            k.a(getContext(), lVar.l(), this.a, null);
            this.b.setText(lVar.m());
            if (!b.a(this.mAdapter.a(), this.d.u)) {
                b.b(this.mAdapter.a(), this.d.u);
                String z = this.d.z();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.mAdapter.b(eVar));
                b.a(this.d.u, this.mAdapter.a(), "ad", "", z, stringBuilder.toString(), this.d.e(), this.d.y(), this.d.a(), this.d.A(), "1", this.d.H);
                this.d.a(this.a);
            }
        }
    }
}
