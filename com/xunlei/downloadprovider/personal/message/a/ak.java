package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: ReplyItemViewHolder */
final class ak implements OnClickListener {
    final /* synthetic */ ag a;

    ak(ag agVar) {
        this.a = agVar;
    }

    public final void onClick(View view) {
        if (this.a.g != null) {
            view = this.a.g;
            this.a.a;
            view.a(1, this.a.i, true);
            q.a("head_icon", String.valueOf(this.a.i.getId()), this.a.i.getSourceId(), "discuss_list", this.a.i.getType());
        }
    }
}
