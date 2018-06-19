package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: BaseLikeViewHolder */
final class o implements OnLongClickListener {
    final /* synthetic */ m a;

    o(m mVar) {
        this.a = mVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            View view2 = this.a.itemView;
            view.a(2, this.a.b, true);
            q.b("zan_list", this.a.b.getType());
        }
        return null;
    }
}
