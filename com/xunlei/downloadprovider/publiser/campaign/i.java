package com.xunlei.downloadprovider.publiser.campaign;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: TopicDetailActivity */
final class i implements OnClickListener {
    final /* synthetic */ TopicDetailActivity a;

    i(TopicDetailActivity topicDetailActivity) {
        this.a = topicDetailActivity;
    }

    public final void onClick(View view) {
        this.a.p.setMaxLines(Integer.MAX_VALUE);
        this.a.q.setVisibility(8);
    }
}
