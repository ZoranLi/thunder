package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: BaseCommentViewHolder */
final class i implements OnLongClickListener {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.a != null) {
            view = this.a.a;
            View view2 = this.a.itemView;
            view.a(2, this.a.b, true);
            q.b("discuss_list", this.a.b.getType());
        }
        return null;
    }
}
