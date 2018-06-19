package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.c;

/* compiled from: PhotoArticleViewHolder */
public abstract class i extends f implements c {
    protected TextView a = null;
    protected TaskListFeedBottomView b = null;
    private e c;
    private c d;

    public final int a() {
        return 2;
    }

    public i(View view, a aVar) {
        super(view);
        setAdapter(aVar);
        this.a = (TextView) this.itemView.findViewById(R.id.tv_title);
        this.b = (TaskListFeedBottomView) this.itemView.findViewById(R.id.bottom_view);
        this.b.getAdSourceTagTV().setVisibility(8);
        this.b.getCommentCountTV().setVisibility(0);
        this.b.getSourceTV().setVisibility(0);
        this.b.getTmtpTV().setVisibility(8);
        this.itemView.setOnClickListener(new j(this));
    }

    public void fillData(e eVar) {
        if (eVar != null) {
            this.c = eVar;
            this.d = (c) eVar.c;
            this.a.setText(this.d.a.c);
            this.b.getSourceTV().setText(this.d.b.getNickname());
            this.b.getCommentCountTV().setText(getContext().getString(R.string.task_list_feed_comment, new Object[]{Integer.valueOf(r0.i)}));
            int a = this.mAdapter.a();
            StringBuilder stringBuilder = new StringBuilder("photo_article");
            stringBuilder.append(this.d.b());
            if (!b.a(a, stringBuilder.toString())) {
                a = this.mAdapter.a();
                stringBuilder = new StringBuilder("photo_article");
                stringBuilder.append(this.d.b());
                b.b(a, stringBuilder.toString());
                b.b(this.mAdapter.a(), this.d.b());
                b.a(this.d, b(this.mAdapter.a()), this.mAdapter.b(eVar), this.mAdapter.a());
            }
        }
    }

    private static String b(int i) {
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
