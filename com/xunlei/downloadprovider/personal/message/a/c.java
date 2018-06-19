package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: AttentionItemViewHolder */
final class c implements OnLongClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.f != null) {
            view = this.a.f;
            this.a.g;
            view.a(2, this.a.h, true);
            q.b("follow_list", this.a.h.getType());
        }
        return null;
    }
}
