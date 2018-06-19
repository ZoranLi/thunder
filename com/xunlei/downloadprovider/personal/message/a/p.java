package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: BaseLikeViewHolder */
final class p implements OnClickListener {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            this.a.e;
            view.a(1, this.a.b, true);
            q.a("head_icon", String.valueOf(this.a.b.getId()), this.a.b.getSourceId(), "zan_list", this.a.b.getType());
        }
    }
}
