package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: ReplyItemViewHolder */
final class ai implements OnLongClickListener {
    final /* synthetic */ ag a;

    ai(ag agVar) {
        this.a = agVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.g != null) {
            view = this.a.g;
            this.a.h;
            view.a(2, this.a.i, true);
            q.b("discuss_list", this.a.i.getType());
        }
        return null;
    }
}
