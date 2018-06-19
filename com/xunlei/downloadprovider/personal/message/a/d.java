package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: AttentionItemViewHolder */
final class d implements OnClickListener {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (this.a.f != null) {
            view = this.a.f;
            this.a.a;
            view.a(1, this.a.h, true);
            q.a("head_icon", String.valueOf(this.a.h.getId()), this.a.h.getSourceId(), "follow_list", this.a.h.getType());
        }
    }
}
