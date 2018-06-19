package com.xunlei.downloadprovider.publiser.campaign;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* compiled from: TopicDetailActivity */
final class l implements OnPreDrawListener {
    final /* synthetic */ ViewTreeObserver a;
    final /* synthetic */ TopicDetailActivity b;

    l(TopicDetailActivity topicDetailActivity, ViewTreeObserver viewTreeObserver) {
        this.b = topicDetailActivity;
        this.a = viewTreeObserver;
    }

    public final boolean onPreDraw() {
        int lineCount = this.b.p.getLineCount();
        this.b.p.setMaxLines(3);
        this.b.q.setVisibility(lineCount <= 3 ? 8 : 0);
        this.a.removeOnPreDrawListener(this);
        return true;
    }
}
