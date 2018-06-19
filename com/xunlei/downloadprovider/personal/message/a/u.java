package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeItemViewHolder */
final class u implements OnLongClickListener {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.f != null) {
            view = this.a.f;
            this.a.g;
            view.a(2, this.a.h, true);
            q.b("zan_list", this.a.h.getType());
        }
        return null;
    }
}
