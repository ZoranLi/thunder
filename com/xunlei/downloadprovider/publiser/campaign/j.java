package com.xunlei.downloadprovider.publiser.campaign;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: TopicDetailActivity */
final class j implements OnClickListener {
    final /* synthetic */ TopicDetailActivity a;

    j(TopicDetailActivity topicDetailActivity) {
        this.a = topicDetailActivity;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.u.setVisibility(8);
            if (this.a.v != null) {
                this.a.v.h();
            }
            if (this.a.w != null) {
                this.a.w.h();
            }
        }
    }
}
