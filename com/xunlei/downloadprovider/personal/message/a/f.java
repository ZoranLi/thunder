package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: AttentionItemViewHolder */
final class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (b.a().b(this.a.h.getUserId()) == null) {
            q.a("attention", String.valueOf(this.a.h.getId()), this.a.h.getSourceId(), "follow_list", this.a.h.getType());
        }
        if (this.a.f != null) {
            view = this.a.f;
            this.a.b;
            view.a(4, this.a.h, true);
        }
    }
}
