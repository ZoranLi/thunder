package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeVideoItemViewHolder */
final class ac implements OnClickListener {
    final /* synthetic */ y a;

    ac(y yVar) {
        this.a = yVar;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            view = this.a.h;
            this.a.a;
            view.a(1, this.a.j, true);
            q.a("head_icon", String.valueOf(this.a.j.getId()), this.a.j.getSourceId(), "zan_list", this.a.j.getType());
        }
    }
}
