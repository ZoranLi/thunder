package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: ReplyVideoItemViewHolder */
final class ap implements OnLongClickListener {
    final /* synthetic */ an a;

    ap(an anVar) {
        this.a = anVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.j != null) {
            view = this.a.j;
            this.a.k;
            view.a(2, this.a.l, true);
            q.b("discuss_list", this.a.l.getType());
        }
        return null;
    }
}
