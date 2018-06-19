package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: ReplyVideoItemViewHolder */
final class as implements OnClickListener {
    final /* synthetic */ an a;

    as(an anVar) {
        this.a = anVar;
    }

    public final void onClick(View view) {
        if (this.a.j != null) {
            view = this.a.j;
            this.a.c;
            view.a(3, this.a.l, true);
            q.a("discuss_content", String.valueOf(this.a.l.getId()), this.a.l.getSourceId(), "discuss_list", this.a.l.getType());
        }
    }
}
