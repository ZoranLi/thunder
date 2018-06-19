package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeVideoItemViewHolder */
final class aa implements OnLongClickListener {
    final /* synthetic */ y a;

    aa(y yVar) {
        this.a = yVar;
    }

    public final boolean onLongClick(View view) {
        if (this.a.h != null) {
            view = this.a.h;
            this.a.i;
            view.a(2, this.a.j, true);
            q.b("zan_list", this.a.j.getType());
        }
        return null;
    }
}
