package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeItemViewHolder */
final class x implements OnClickListener {
    final /* synthetic */ s a;

    x(s sVar) {
        this.a = sVar;
    }

    public final void onClick(View view) {
        if (this.a.f != null) {
            view = this.a.f;
            this.a.b;
            view.a(3, this.a.h, true);
            q.a("zan_content", String.valueOf(this.a.h.getId()), this.a.h.getSourceId(), "zan_list", this.a.h.getType());
        }
    }
}
