package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: ReplyVideoItemViewHolder */
final class aq implements OnClickListener {
    final /* synthetic */ an a;

    aq(an anVar) {
        this.a = anVar;
    }

    public final void onClick(View view) {
        if (this.a.j != null) {
            view = this.a.j;
            this.a.b;
            view.a(1, this.a.l, true);
            q.a("head_icon", String.valueOf(this.a.l.getId()), this.a.l.getSourceId(), "discuss_list", this.a.l.getType());
        }
    }
}
