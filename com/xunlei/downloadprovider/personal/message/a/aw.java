package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: WebsiteCommentLikeViewHolder */
final class aw implements OnClickListener {
    final /* synthetic */ av a;

    aw(av avVar) {
        this.a = avVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.c;
            view.a(3, this.a.b, true);
            q.a("zan_content", String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "zan_list", this.a.b.getType());
        }
    }
}
