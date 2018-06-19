package com.xunlei.downloadprovider.personal.message.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeVideoItemViewHolder */
final class ad implements OnClickListener {
    final /* synthetic */ y a;

    ad(y yVar) {
        this.a = yVar;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            view = this.a.h;
            this.a.b;
            view.a(3, this.a.j, false);
            q.a("zan_content", String.valueOf(this.a.j.getId()), this.a.j.getSourceId(), "zan_list", this.a.j.getType());
        }
    }
}
